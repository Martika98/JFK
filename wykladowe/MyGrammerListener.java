// Generated from MyGrammer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyGrammerParser}.
 */
public interface MyGrammerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyGrammerParser#commandx}.
	 * @param ctx the parse tree
	 */
	void enterCommandx(MyGrammerParser.CommandxContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammerParser#commandx}.
	 * @param ctx the parse tree
	 */
	void exitCommandx(MyGrammerParser.CommandxContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammerParser#commands}.
	 * @param ctx the parse tree
	 */
	void enterCommands(MyGrammerParser.CommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammerParser#commands}.
	 * @param ctx the parse tree
	 */
	void exitCommands(MyGrammerParser.CommandsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StartComm}
	 * labeled alternative in {@link MyGrammerParser#hello}.
	 * @param ctx the parse tree
	 */
	void enterStartComm(MyGrammerParser.StartCommContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StartComm}
	 * labeled alternative in {@link MyGrammerParser#hello}.
	 * @param ctx the parse tree
	 */
	void exitStartComm(MyGrammerParser.StartCommContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndComm}
	 * labeled alternative in {@link MyGrammerParser#bye}.
	 * @param ctx the parse tree
	 */
	void enterEndComm(MyGrammerParser.EndCommContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndComm}
	 * labeled alternative in {@link MyGrammerParser#bye}.
	 * @param ctx the parse tree
	 */
	void exitEndComm(MyGrammerParser.EndCommContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TableChangeComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void enterTableChangeComm(MyGrammerParser.TableChangeCommContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TableChangeComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void exitTableChangeComm(MyGrammerParser.TableChangeCommContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void enterExprComm(MyGrammerParser.ExprCommContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void exitExprComm(MyGrammerParser.ExprCommContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctExpr}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void enterFunctExpr(MyGrammerParser.FunctExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctExpr}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void exitFunctExpr(MyGrammerParser.FunctExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void enterAssignComm(MyGrammerParser.AssignCommContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void exitAssignComm(MyGrammerParser.AssignCommContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignTableComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void enterAssignTableComm(MyGrammerParser.AssignTableCommContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignTableComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void exitAssignTableComm(MyGrammerParser.AssignTableCommContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TableComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void enterTableComm(MyGrammerParser.TableCommContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TableComm}
	 * labeled alternative in {@link MyGrammerParser#command}.
	 * @param ctx the parse tree
	 */
	void exitTableComm(MyGrammerParser.TableCommContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TableBody}
	 * labeled alternative in {@link MyGrammerParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTableBody(MyGrammerParser.TableBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TableBody}
	 * labeled alternative in {@link MyGrammerParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTableBody(MyGrammerParser.TableBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammerParser#table_content}.
	 * @param ctx the parse tree
	 */
	void enterTable_content(MyGrammerParser.Table_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammerParser#table_content}.
	 * @param ctx the parse tree
	 */
	void exitTable_content(MyGrammerParser.Table_contentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterValExpr(MyGrammerParser.ValExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitValExpr(MyGrammerParser.ValExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StrExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStrExpr(MyGrammerParser.StrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StrExpr}
	 * labeled alternative in {@link MyGrammerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStrExpr(MyGrammerParser.StrExprContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link MyGrammerParser#funct_value}.
	 * @param ctx the parse tree
	 */
	void enterFunct_value(MyGrammerParser.Funct_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammerParser#funct_value}.
	 * @param ctx the parse tree
	 */
	void exitFunct_value(MyGrammerParser.Funct_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammerParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(MyGrammerParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammerParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(MyGrammerParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TableValVal}
	 * labeled alternative in {@link MyGrammerParser#table_val}.
	 * @param ctx the parse tree
	 */
	void enterTableValVal(MyGrammerParser.TableValValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TableValVal}
	 * labeled alternative in {@link MyGrammerParser#table_val}.
	 * @param ctx the parse tree
	 */
	void exitTableValVal(MyGrammerParser.TableValValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntVal}
	 * labeled alternative in {@link MyGrammerParser#numbers}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(MyGrammerParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntVal}
	 * labeled alternative in {@link MyGrammerParser#numbers}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(MyGrammerParser.IntValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealVal}
	 * labeled alternative in {@link MyGrammerParser#numbers}.
	 * @param ctx the parse tree
	 */
	void enterRealVal(MyGrammerParser.RealValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealVal}
	 * labeled alternative in {@link MyGrammerParser#numbers}.
	 * @param ctx the parse tree
	 */
	void exitRealVal(MyGrammerParser.RealValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdVal}
	 * labeled alternative in {@link MyGrammerParser#id_}.
	 * @param ctx the parse tree
	 */
	void enterIdVal(MyGrammerParser.IdValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdVal}
	 * labeled alternative in {@link MyGrammerParser#id_}.
	 * @param ctx the parse tree
	 */
	void exitIdVal(MyGrammerParser.IdValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StrVal}
	 * labeled alternative in {@link MyGrammerParser#string}.
	 * @param ctx the parse tree
	 */
	void enterStrVal(MyGrammerParser.StrValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StrVal}
	 * labeled alternative in {@link MyGrammerParser#string}.
	 * @param ctx the parse tree
	 */
	void exitStrVal(MyGrammerParser.StrValContext ctx);
}