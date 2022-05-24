# Generated from MyGrammer.g4 by ANTLR 4.9.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .MyGrammerParser import MyGrammerParser
else:
    from MyGrammerParser import MyGrammerParser

# This class defines a complete listener for a parse tree produced by MyGrammerParser.
class MyGrammerListener(ParseTreeListener):

    # Enter a parse tree produced by MyGrammerParser#commandx.
    def enterCommandx(self, ctx:MyGrammerParser.CommandxContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#commandx.
    def exitCommandx(self, ctx:MyGrammerParser.CommandxContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#commands.
    def enterCommands(self, ctx:MyGrammerParser.CommandsContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#commands.
    def exitCommands(self, ctx:MyGrammerParser.CommandsContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#StartComm.
    def enterStartComm(self, ctx:MyGrammerParser.StartCommContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#StartComm.
    def exitStartComm(self, ctx:MyGrammerParser.StartCommContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#EndComm.
    def enterEndComm(self, ctx:MyGrammerParser.EndCommContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#EndComm.
    def exitEndComm(self, ctx:MyGrammerParser.EndCommContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#TableChangeComm.
    def enterTableChangeComm(self, ctx:MyGrammerParser.TableChangeCommContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#TableChangeComm.
    def exitTableChangeComm(self, ctx:MyGrammerParser.TableChangeCommContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#ExprComm.
    def enterExprComm(self, ctx:MyGrammerParser.ExprCommContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#ExprComm.
    def exitExprComm(self, ctx:MyGrammerParser.ExprCommContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#FunctExpr.
    def enterFunctExpr(self, ctx:MyGrammerParser.FunctExprContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#FunctExpr.
    def exitFunctExpr(self, ctx:MyGrammerParser.FunctExprContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#AssignComm.
    def enterAssignComm(self, ctx:MyGrammerParser.AssignCommContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#AssignComm.
    def exitAssignComm(self, ctx:MyGrammerParser.AssignCommContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#AssignTableComm.
    def enterAssignTableComm(self, ctx:MyGrammerParser.AssignTableCommContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#AssignTableComm.
    def exitAssignTableComm(self, ctx:MyGrammerParser.AssignTableCommContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#TableComm.
    def enterTableComm(self, ctx:MyGrammerParser.TableCommContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#TableComm.
    def exitTableComm(self, ctx:MyGrammerParser.TableCommContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#TableBody.
    def enterTableBody(self, ctx:MyGrammerParser.TableBodyContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#TableBody.
    def exitTableBody(self, ctx:MyGrammerParser.TableBodyContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#table_content.
    def enterTable_content(self, ctx:MyGrammerParser.Table_contentContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#table_content.
    def exitTable_content(self, ctx:MyGrammerParser.Table_contentContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#ValExpr.
    def enterValExpr(self, ctx:MyGrammerParser.ValExprContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#ValExpr.
    def exitValExpr(self, ctx:MyGrammerParser.ValExprContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#StrExpr.
    def enterStrExpr(self, ctx:MyGrammerParser.StrExprContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#StrExpr.
    def exitStrExpr(self, ctx:MyGrammerParser.StrExprContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#InfixExpr.
    def enterInfixExpr(self, ctx:MyGrammerParser.InfixExprContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#InfixExpr.
    def exitInfixExpr(self, ctx:MyGrammerParser.InfixExprContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#funct_value.
    def enterFunct_value(self, ctx:MyGrammerParser.Funct_valueContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#funct_value.
    def exitFunct_value(self, ctx:MyGrammerParser.Funct_valueContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#value.
    def enterValue(self, ctx:MyGrammerParser.ValueContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#value.
    def exitValue(self, ctx:MyGrammerParser.ValueContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#TableValVal.
    def enterTableValVal(self, ctx:MyGrammerParser.TableValValContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#TableValVal.
    def exitTableValVal(self, ctx:MyGrammerParser.TableValValContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#IntVal.
    def enterIntVal(self, ctx:MyGrammerParser.IntValContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#IntVal.
    def exitIntVal(self, ctx:MyGrammerParser.IntValContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#RealVal.
    def enterRealVal(self, ctx:MyGrammerParser.RealValContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#RealVal.
    def exitRealVal(self, ctx:MyGrammerParser.RealValContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#IdVal.
    def enterIdVal(self, ctx:MyGrammerParser.IdValContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#IdVal.
    def exitIdVal(self, ctx:MyGrammerParser.IdValContext):
        pass


    # Enter a parse tree produced by MyGrammerParser#StrVal.
    def enterStrVal(self, ctx:MyGrammerParser.StrValContext):
        pass

    # Exit a parse tree produced by MyGrammerParser#StrVal.
    def exitStrVal(self, ctx:MyGrammerParser.StrValContext):
        pass



del MyGrammerParser