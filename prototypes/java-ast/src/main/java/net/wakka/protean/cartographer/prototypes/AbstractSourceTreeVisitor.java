package net.wakka.protean.cartographer.prototypes;

import com.sun.source.tree.*;
import net.wakka.protean.cartographer.prototypes.beans.Node;

import javax.lang.model.element.Modifier;

public abstract class AbstractSourceTreeVisitor<X,Y> implements TreeVisitor<X, Y> {

  public X visitCompilationUnit(CompilationUnitTree compilationUnitTree, Y data) { return null; }
  public X visitMemberSelect(MemberSelectTree memberSelectTree, Y data) { return null; }
  public X visitClass(ClassTree classTree, Y data) { return null; }
  public X visitMethod(MethodTree methodTree, Y data) { return null; }
  public X visitParameterizedType(ParameterizedTypeTree parameterizedTypeTree, Y data) { return null; }
  public X visitArrayType(ArrayTypeTree arrayTypeTree, Y data) { return null; }
  public X visitModifiers(ModifiersTree modifiersTree, Y data) { return null; }
  public X visitReturn(ReturnTree returnTree, Y data) { return null; }
  public X visitVariable(VariableTree variableTree, Y data) { return null;}
  public X visitPrimitiveType(PrimitiveTypeTree primitiveTypeTree, Y data) { return null; }
  public X visitTypeParameter(TypeParameterTree typeParameterTree, Y data) { return null; }
  public X visitContinue(ContinueTree continueTree, Y data) { return null; }
  public X visitDoWhileLoop(DoWhileLoopTree doWhileLoopTree, Y data) { return null; }
  public X visitErroneous(ErroneousTree erroneousTree, Y data) { return null; }
  public X visitExpressionStatement(ExpressionStatementTree expressionStatementTree, Y data) { return null; }
  public X visitEnhancedForLoop(EnhancedForLoopTree enhancedForLoopTree, Y data) { return null; }
  public X visitForLoop(ForLoopTree forLoopTree, Y data) { return null; }
  public X visitIdentifier(IdentifierTree identifierTree, Y data) { return null; }
  public X visitIf(IfTree ifTree, Y data) { return null; }
  public X visitImport(ImportTree importTree, Y data) { return null; }
  public X visitArrayAccess(ArrayAccessTree arrayAccessTree, Y data) { return null; }
  public X visitLabeledStatement(LabeledStatementTree labeledStatementTree, Y data) { return null; }
  public X visitLiteral(LiteralTree literalTree, Y data) { return null; }
  public X visitNewArray(NewArrayTree newArrayTree, Y data) { return null; }
  public X visitNewClass(NewClassTree newClassTree, Y data) { return null; }
  public X visitParenthesized(ParenthesizedTree parenthesizedTree, Y data) { return null; }
  public X visitEmptyStatement(EmptyStatementTree emptyStatementTree, Y data) { return null; }
  public X visitSwitch(SwitchTree switchTree, Y data) { return null; }
  public X visitSynchronized(SynchronizedTree synchronizedTree, Y data) { return null; }
  public X visitThrow(ThrowTree throwTree, Y data) { return null; }
  public X visitTry(TryTree tryTree, Y data) { return null; }
  public X visitTypeCast(TypeCastTree typeCastTree, Y data) { return null; }
  public X visitInstanceOf(InstanceOfTree instanceOfTree, Y data) { return null; }
  public X visitUnary(UnaryTree unaryTree, Y data) { return null; }
  public X visitWhileLoop(WhileLoopTree whileLoopTree, Y data) { return null; }
  public X visitWildcard(WildcardTree wildcardTree, Y data) { return null; }
  public X visitOther(Tree tree, Y data) { return null; }
  public X visitAnnotation(AnnotationTree annotationTree, Y data) { return null; }
  public X visitMethodInvocation(MethodInvocationTree methodInvocationTree, Y data) { return null; }
  public X visitAssert(AssertTree assertTree, Y data) { return null; }
  public X visitAssignment(AssignmentTree assignmentTree, Y data) { return null; }
  public X visitCompoundAssignment(CompoundAssignmentTree compoundAssignmentTree, Y data) { return null; }
  public X visitBinary(BinaryTree binaryTree, Y data) { return null; }
  public X visitBlock(BlockTree blockTree, Y data) { return null; }
  public X visitBreak(BreakTree breakTree, Y data) { return null; }
  public X visitCase(CaseTree caseTree, Y data) { return null; }
  public X visitCatch(CatchTree catchTree, Y data) { return null; }
  public X visitConditionalExpression(ConditionalExpressionTree conditionalExpressionTree, Y data) { return null; }

}
