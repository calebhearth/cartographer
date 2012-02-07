package net.wakka.protean.cartographer.prototypes;

import com.sun.source.tree.*;
import com.sun.source.util.JavacTask;
import com.sun.tools.javac.tree.JCTree;
import net.wakka.protean.cartographer.prototypes.beans.*;
import net.wakka.protean.cartographer.prototypes.beans.Class;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import javax.lang.model.element.Modifier;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JavaSyntaxTreeGenerator
  extends AbstractSourceTreeVisitor<Void,Void> {

  public static void main(String[] args) throws IOException {
    System.out.println("### Java Abstract Syntax Tree Generator");
    JavaSyntaxTreeGenerator generator = new JavaSyntaxTreeGenerator();
    // for each argument create a file object and add it to the source file list
    LinkedList<File> sourceFiles = new LinkedList<File>();
    for(String s : args) sourceFiles.add(new File(s));
    // generate the AST
    generator.generateFromSourceFiles(sourceFiles);
  }

  public JavaSyntaxTreeGenerator() {
    compiler = ToolProvider.getSystemJavaCompiler();
  }

  private JavaCompiler compiler;

  public void generateFromSourceFiles(List<File> sourceFiles) throws IOException {
    // create a javac task
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFiles);
    JavaCompiler.CompilationTask compilationTask = compiler.getTask(null,fileManager,null,null,null,compilationUnits);
    JavacTask javacTask = (JavacTask) compilationTask;
    List<Namespace> namespaces = new LinkedList<Namespace>();
    // parse each source file
    for(CompilationUnitTree compilationUnitTree: javacTask.parse()) {
      System.out.println("parsing source file: " + compilationUnitTree.getSourceFile().getName());

      // create a new namespace for this computational unit
      Namespace namespace = new Namespace();
      namespace.setName(compilationUnitTree.getPackageName().accept(new ComputationalUnitPackageNameVisitor(),null));
      // if we've already seen this namespace
      if(namespaces.contains(namespace)) {
        // discard the duplicate
        namespace = namespaces.get(namespaces.indexOf(namespace));
      } else {
        // otherwise add this namespace to the list
        namespaces.add(namespace);
      }

      // add computational unit type declarations to the namespace
      for(Tree tree: compilationUnitTree.getTypeDecls()) {
        tree.accept(new NamespaceChildVisitor(),namespace);
      }

    }
    // print the resulting syntax tree
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    FileWriter fw = new FileWriter("target/java-ast.json");
    fw.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(namespaces));
    fw.flush();
    fw.close();
  }

}

/**
 * acquires the package name from a computational unit tree
 */
class ComputationalUnitPackageNameVisitor extends AbstractSourceTreeVisitor<String, Void> {

  @Override
  public String visitCompilationUnit(CompilationUnitTree compilationUnitTree, Void data) {
    return compilationUnitTree.getPackageName().accept(this, data);
  }

  @Override
  public String visitMemberSelect(MemberSelectTree memberSelectTree, Void data) {
    return memberSelectTree.toString();
  }

}

/**
 * identifies top level members of a namespace
 */
class NamespaceChildVisitor extends AbstractSourceTreeVisitor<Void, Namespace> {

  @Override
  public Void visitClass(ClassTree classTree, Namespace data) {
    Class clazz = new Class();
    clazz.setName(classTree.getSimpleName().toString());
    for(Modifier modifier: classTree.getModifiers().getFlags()) clazz.getModifiers().add(modifier.toString());
    if ((((JCTree.JCModifiers) classTree.getModifiers()).flags & (1L << 9)) != 0) clazz.getModifiers().add("interface");
    if(classTree.getExtendsClause() != null) classTree.getExtendsClause().accept(new ClassExtendsVisitor(), clazz);
    for(Tree tree: classTree.getMembers()) tree.accept(new ClassChildVisitor(), clazz);
    data.getMembers().add(clazz);
    return null;
  }

}

class ClassExtendsVisitor extends AbstractSourceTreeVisitor<Void,Class> {

  @Override
  public Void visitParameterizedType(ParameterizedTypeTree parameterizedTypeTree, Class data) {
    data.getSuperclasses().add(parameterizedTypeTree.toString());
    return super.visitParameterizedType(parameterizedTypeTree, data);
  }

  @Override
  public Void visitIdentifier(IdentifierTree identifierTree, Class data) {
    data.getSuperclasses().add(identifierTree.toString());
    return super.visitIdentifier(identifierTree, data);
  }
}

class ClassChildVisitor extends AbstractSourceTreeVisitor<Void,Class> {

  @Override
  public Void visitVariable(VariableTree variableTree, Class data) {
    Variable variable = new Variable();
    variable.setIdentifier(variableTree.getName().toString());
    variable.setValueType(variableTree.getType().toString());
    data.getMembers().add(variable);
    return null;
  }

  @Override
  public Void visitMethod(MethodTree methodTree, Class data) {
    Function function = new Function();
    function.setIdentifier(methodTree.getName().toString());
    data.getMembers().add(function);
    return null;
  }
}

/** TEST CODE **/

interface Doer {
  public void doStuff();
  public void doThings();
  public void doOver();
}

abstract strictfp interface OverDoer extends Doer {
  public void doIt();
  public void doItAgain();
}

class ConcreteDoer implements OverDoer {

  public void doIt() {
  }

  public void doItAgain() {
  }

  public void doStuff() {
  }

  public void doThings() {
  }

  public void doOver() {
  }
}