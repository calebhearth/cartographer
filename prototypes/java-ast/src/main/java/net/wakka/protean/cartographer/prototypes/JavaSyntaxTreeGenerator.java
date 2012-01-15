package net.wakka.protean.cartographer.prototypes;

import com.sun.source.tree.*;
import com.sun.source.util.JavacTask;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JavaSyntaxTreeGenerator implements TreeVisitor<Void, Integer> {

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
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFiles);
    JavaCompiler.CompilationTask compilationTask = compiler.getTask(null,fileManager,null,null,null,compilationUnits);
    JavacTask javacTask = (JavacTask) compilationTask;
    for(CompilationUnitTree compilationUnitTree: javacTask.parse()) {
      System.out.println("CompilationUnitTree for source file: " + compilationUnitTree.getSourceFile().getName());
      compilationUnitTree.accept(this,0);
    }
  }

  private void commonPreVisitationOperations(Tree tree, Integer depth) {
    for(int i=0; i<depth; i++) System.out.print(" ");
    System.out.print("> ");
  }

  private void commonVisitationOperations(Tree tree, Integer depth) { }

  public Void visitAnnotation(AnnotationTree annotationTree, Integer depth) {
    commonPreVisitationOperations(annotationTree,depth+1);
    System.out.println("annotation (pruned)");
    commonVisitationOperations(annotationTree, depth + 1);
    return null;
  }

  public Void visitMethodInvocation(MethodInvocationTree methodInvocationTree, Integer depth) {
    commonPreVisitationOperations(methodInvocationTree,depth+1);
    System.out.println("method invocation (pruned)");
    commonVisitationOperations(methodInvocationTree, depth + 1);
    return null;
  }

  public Void visitAssert(AssertTree assertTree, Integer depth) {
    commonPreVisitationOperations(assertTree,depth+1);
    System.out.println("assert (pruned)");
    commonVisitationOperations(assertTree, depth + 1);
    return null;
  }

  public Void visitAssignment(AssignmentTree assignmentTree, Integer depth) {
    commonPreVisitationOperations(assignmentTree,depth+1);
    System.out.println("assignment (pruned)");
    commonVisitationOperations(assignmentTree, depth + 1);
    return null;
  }

  public Void visitCompoundAssignment(CompoundAssignmentTree compoundAssignmentTree, Integer depth) {
    commonPreVisitationOperations(compoundAssignmentTree,depth+1);
    System.out.println("compound assignment (pruned)");
    commonVisitationOperations(compoundAssignmentTree, depth + 1);
    return null;
  }

  public Void visitBinary(BinaryTree binaryTree, Integer depth) {
    commonPreVisitationOperations(binaryTree,depth+1);
    System.out.println("binary (pruned)");
    commonVisitationOperations(binaryTree, depth + 1);
    return null;
  }

  public Void visitBlock(BlockTree blockTree, Integer depth) {
    commonPreVisitationOperations(blockTree,depth+1);
    System.out.println("block (pruned)");
    commonVisitationOperations(blockTree, depth + 1);
    return null;
  }

  public Void visitBreak(BreakTree breakTree, Integer depth) {
    commonPreVisitationOperations(breakTree,depth+1);
    System.out.println("break (pruned)");
    commonVisitationOperations(breakTree, depth + 1);
    return null;
  }

  public Void visitCase(CaseTree caseTree, Integer depth) {
    commonPreVisitationOperations(caseTree,depth+1);
    System.out.println("case (pruned)");
    commonVisitationOperations(caseTree, depth + 1);
    return null;
  }

  public Void visitCatch(CatchTree catchTree, Integer depth) {
    commonPreVisitationOperations(catchTree,depth+1);
    System.out.println("catch (pruned)");
    commonVisitationOperations(catchTree, depth + 1);
    return null;
  }

  public Void visitClass(ClassTree classTree, Integer depth) {
    commonPreVisitationOperations(classTree,depth+1);
    System.out.println("class (" + classTree.getSimpleName().toString() + ")");
    for(Tree tree: classTree.getMembers()) tree.accept(this,depth+1);
    commonVisitationOperations(classTree, depth + 1);
    return null;
  }

  public Void visitConditionalExpression(ConditionalExpressionTree conditionalExpressionTree, Integer depth) {
    commonPreVisitationOperations(conditionalExpressionTree,depth+1);
    System.out.println("conditional expression (pruned)");
    commonVisitationOperations(conditionalExpressionTree, depth + 1);
    return null;
  }

  public Void visitContinue(ContinueTree continueTree, Integer depth) {
    commonPreVisitationOperations(continueTree,depth+1);
    System.out.println("continue (pruned)");
    commonVisitationOperations(continueTree, depth + 1);
    return null;
  }

  public Void visitDoWhileLoop(DoWhileLoopTree doWhileLoopTree, Integer depth) {
    commonPreVisitationOperations(doWhileLoopTree,depth+1);
    System.out.println("do-while loop (pruned)");
    commonVisitationOperations(doWhileLoopTree, depth + 1);
    return null;
  }

  public Void visitErroneous(ErroneousTree erroneousTree, Integer depth) {
    commonPreVisitationOperations(erroneousTree,depth+1);
    System.out.println("erroneous (pruned)");
    commonVisitationOperations(erroneousTree, depth + 1);
    return null;
  }

  public Void visitExpressionStatement(ExpressionStatementTree expressionStatementTree, Integer depth) {
    commonPreVisitationOperations(expressionStatementTree,depth+1);
    System.out.println("expression statement (pruned)");
    commonVisitationOperations(expressionStatementTree, depth + 1);
    return null;
  }

  public Void visitEnhancedForLoop(EnhancedForLoopTree enhancedForLoopTree, Integer depth) {
    commonPreVisitationOperations(enhancedForLoopTree,depth+1);
    System.out.println("enhanced for-loop (pruned)");
    commonVisitationOperations(enhancedForLoopTree, depth + 1);
    return null;
  }

  public Void visitForLoop(ForLoopTree forLoopTree, Integer depth) {
    commonPreVisitationOperations(forLoopTree,depth+1);
    System.out.println("for-loop (pruned)");
    commonVisitationOperations(forLoopTree, depth + 1);
    return null;
  }

  public Void visitIdentifier(IdentifierTree identifierTree, Integer depth) {
    commonPreVisitationOperations(identifierTree,depth+1);
    System.out.println("identifier (pruned)");
    commonVisitationOperations(identifierTree, depth + 1);
    return null;
  }

  public Void visitIf(IfTree ifTree, Integer depth) {
    commonPreVisitationOperations(ifTree,depth+1);
    System.out.println("if (pruned)");
    commonVisitationOperations(ifTree, depth + 1);
    return null;
  }

  public Void visitImport(ImportTree importTree, Integer depth) {
    commonPreVisitationOperations(importTree,depth+1);
    System.out.println("import (pruned)");
    commonVisitationOperations(importTree, depth + 1);
    return null;
  }

  public Void visitArrayAccess(ArrayAccessTree arrayAccessTree, Integer depth) {
    commonPreVisitationOperations(arrayAccessTree,depth+1);
    System.out.println("array access (pruned)");
    commonVisitationOperations(arrayAccessTree, depth + 1);
    return null;
  }

  public Void visitLabeledStatement(LabeledStatementTree labeledStatementTree, Integer depth) {
    commonPreVisitationOperations(labeledStatementTree,depth+1);
    System.out.println("labeled statement (pruned)");
    commonVisitationOperations(labeledStatementTree, depth + 1);
    return null;
  }

  public Void visitLiteral(LiteralTree literalTree, Integer depth) {
    commonPreVisitationOperations(literalTree,depth+1);
    System.out.println("literal (pruned)");
    commonVisitationOperations(literalTree, depth + 1);
    return null;
  }

  public Void visitMethod(MethodTree methodTree, Integer depth) {
    commonPreVisitationOperations(methodTree,depth+1);
    System.out.println("method (" + methodTree.getName().toString() + ") (pruned)");
    commonVisitationOperations(methodTree, depth + 1);
    return null;
  }

  public Void visitModifiers(ModifiersTree modifiersTree, Integer depth) {
    commonPreVisitationOperations(modifiersTree,depth+1);
    System.out.println("modifiers (pruned)");
    commonVisitationOperations(modifiersTree, depth + 1);
    return null;
  }

  public Void visitNewArray(NewArrayTree newArrayTree, Integer depth) {
    commonPreVisitationOperations(newArrayTree,depth+1);
    System.out.println("new array (pruned)");
    commonVisitationOperations(newArrayTree, depth + 1);
    return null;
  }

  public Void visitNewClass(NewClassTree newClassTree, Integer depth) {
    commonPreVisitationOperations(newClassTree,depth+1);
    System.out.println("new class (pruned)");
    commonVisitationOperations(newClassTree, depth + 1);
    return null;
  }

  public Void visitParenthesized(ParenthesizedTree parenthesizedTree, Integer depth) {
    commonPreVisitationOperations(parenthesizedTree,depth+1);
    System.out.println("parenthesized (pruned)");
    commonVisitationOperations(parenthesizedTree, depth + 1);
    return null;
  }

  public Void visitReturn(ReturnTree returnTree, Integer depth) {
    commonPreVisitationOperations(returnTree,depth+1);
    System.out.println("return (pruned)");
    commonVisitationOperations(returnTree, depth + 1);
    return null;
  }

  public Void visitMemberSelect(MemberSelectTree memberSelectTree, Integer depth) {
    commonPreVisitationOperations(memberSelectTree,depth+1);
    System.out.println("member select (pruned)");
    commonVisitationOperations(memberSelectTree, depth + 1);
    return null;
  }

  public Void visitEmptyStatement(EmptyStatementTree emptyStatementTree, Integer depth) {
    commonPreVisitationOperations(emptyStatementTree,depth+1);
    System.out.println("empty statement (pruned)");
    commonVisitationOperations(emptyStatementTree, depth + 1);
    return null;
  }

  public Void visitSwitch(SwitchTree switchTree, Integer depth) {
    commonPreVisitationOperations(switchTree,depth+1);
    System.out.println("switch (pruned)");
    commonVisitationOperations(switchTree, depth + 1);
    return null;
  }

  public Void visitSynchronized(SynchronizedTree synchronizedTree, Integer depth) {
    commonPreVisitationOperations(synchronizedTree,depth+1);
    System.out.println("synchronized (pruned)");
    commonVisitationOperations(synchronizedTree, depth + 1);
    return null;
  }

  public Void visitThrow(ThrowTree throwTree, Integer depth) {
    commonPreVisitationOperations(throwTree,depth+1);
    System.out.println("throw (pruned)");
    commonVisitationOperations(throwTree,depth+1);
    return null;
  }

  public Void visitCompilationUnit(CompilationUnitTree compilationUnitTree, Integer depth) {
    commonPreVisitationOperations(compilationUnitTree,depth+1);
    System.out.println("compilation unit");
    for(Tree tree: compilationUnitTree.getTypeDecls()) tree.accept(this,depth+1);
    commonVisitationOperations(compilationUnitTree,depth+1);
    return null;
  }

  public Void visitTry(TryTree tryTree, Integer depth) {
    commonPreVisitationOperations(tryTree,depth+1);
    System.out.println("try (pruned)");
    commonVisitationOperations(tryTree,depth+1);
    return null;
  }

  public Void visitParameterizedType(ParameterizedTypeTree parameterizedTypeTree, Integer depth) {
    commonPreVisitationOperations(parameterizedTypeTree,depth+1);
    System.out.println("parameterized type (pruned)");
    commonVisitationOperations(parameterizedTypeTree,depth+1);
    return null;
  }

  public Void visitArrayType(ArrayTypeTree arrayTypeTree, Integer depth) {
    commonPreVisitationOperations(arrayTypeTree,depth+1);
    System.out.println("array type (pruned)");
    commonVisitationOperations(arrayTypeTree,depth+1);
    return null;
  }

  public Void visitTypeCast(TypeCastTree typeCastTree, Integer depth) {
commonPreVisitationOperations(typeCastTree,depth+1);
    System.out.println("typecast (pruned)");
    commonVisitationOperations(typeCastTree,depth+1);
    return null;
  }

  public Void visitPrimitiveType(PrimitiveTypeTree primitiveTypeTree, Integer depth) {
    commonPreVisitationOperations(primitiveTypeTree,depth+1);
    System.out.println("primative type (pruned)");
    commonVisitationOperations(primitiveTypeTree,depth+1);
    return null;
  }

  public Void visitTypeParameter(TypeParameterTree typeParameterTree, Integer depth) {
    commonPreVisitationOperations(typeParameterTree,depth+1);
    System.out.println("type parameter (pruned)");
    commonVisitationOperations(typeParameterTree,depth+1);
    return null;
  }

  public Void visitInstanceOf(InstanceOfTree instanceOfTree, Integer depth) {
    commonPreVisitationOperations(instanceOfTree,depth+1);
    System.out.println("instanceOf (pruned)");
    commonVisitationOperations(instanceOfTree,depth+1);
    return null;
  }

  public Void visitUnary(UnaryTree unaryTree, Integer depth) {
    commonPreVisitationOperations(unaryTree,depth+1);
    System.out.println("unary tree (pruned)");
    commonVisitationOperations(unaryTree,depth+1);
    return null;
  }

  public Void visitVariable(VariableTree variableTree, Integer depth) {
    commonPreVisitationOperations(variableTree,depth+1);
    System.out.println("variable (pruned)");
    commonVisitationOperations(variableTree,depth+1);
    return null;
  }

  public Void visitWhileLoop(WhileLoopTree whileLoopTree, Integer depth) {
    commonPreVisitationOperations(whileLoopTree,depth+1);
    System.out.println("while-loop (pruned)");
    commonVisitationOperations(whileLoopTree,depth+1);
    return null;
  }

  public Void visitWildcard(WildcardTree wildcardTree, Integer depth) {
    commonPreVisitationOperations(wildcardTree,depth+1);
    System.out.println("wildcard (pruned)");
    commonVisitationOperations(wildcardTree,depth+1);
    return null;
  }

  public Void visitOther(Tree tree, Integer depth) {
    commonPreVisitationOperations(tree,depth+1);
    System.out.println("other (pruned)");
    commonVisitationOperations(tree,depth+1);
    return null;
  }
}
