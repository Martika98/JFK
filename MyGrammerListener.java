// Generated from MyGrammer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyGrammerParser}.
 */
public interface MyGrammerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(MyGrammerParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(MyGrammerParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ByeExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterByeExpr(MyGrammerParser.ByeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ByeExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitByeExpr(MyGrammerParser.ByeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HelloExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterHelloExpr(MyGrammerParser.HelloExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HelloExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitHelloExpr(MyGrammerParser.HelloExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(MyGrammerParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(MyGrammerParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InfixExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(MyGrammerParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InfixExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(MyGrammerParser.InfixExprContext ctx);
}