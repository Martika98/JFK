// Generated from Demo.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DemoParser}.
 */
public interface DemoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DemoParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(DemoParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(DemoParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code write}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWrite(DemoParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code write}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWrite(DemoParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(DemoParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(DemoParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code read}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterRead(DemoParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code read}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitRead(DemoParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(DemoParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(DemoParser.ValueContext ctx);
}