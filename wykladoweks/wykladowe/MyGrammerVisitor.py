# Generated from MyGrammer.g4 by ANTLR 4.9.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .MyGrammerParser import MyGrammerParser
else:
    from MyGrammerParser import MyGrammerParser

# This class defines a complete generic visitor for a parse tree produced by MyGrammerParser.

class MyGrammerVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by MyGrammerParser#commandx.
    def visitCommandx(self, ctx:MyGrammerParser.CommandxContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#commands.
    def visitCommands(self, ctx:MyGrammerParser.CommandsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#StartComm.
    def visitStartComm(self, ctx:MyGrammerParser.StartCommContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#EndComm.
    def visitEndComm(self, ctx:MyGrammerParser.EndCommContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#TableChangeComm.
    def visitTableChangeComm(self, ctx:MyGrammerParser.TableChangeCommContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#ExprComm.
    def visitExprComm(self, ctx:MyGrammerParser.ExprCommContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#FunctExpr.
    def visitFunctExpr(self, ctx:MyGrammerParser.FunctExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#AssignComm.
    def visitAssignComm(self, ctx:MyGrammerParser.AssignCommContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#AssignTableComm.
    def visitAssignTableComm(self, ctx:MyGrammerParser.AssignTableCommContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#TableComm.
    def visitTableComm(self, ctx:MyGrammerParser.TableCommContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#TableBody.
    def visitTableBody(self, ctx:MyGrammerParser.TableBodyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#table_content.
    def visitTable_content(self, ctx:MyGrammerParser.Table_contentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#ValExpr.
    def visitValExpr(self, ctx:MyGrammerParser.ValExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#StrExpr.
    def visitStrExpr(self, ctx:MyGrammerParser.StrExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#InfixExpr.
    def visitInfixExpr(self, ctx:MyGrammerParser.InfixExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#funct_value.
    def visitFunct_value(self, ctx:MyGrammerParser.Funct_valueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#value.
    def visitValue(self, ctx:MyGrammerParser.ValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#TableValVal.
    def visitTableValVal(self, ctx:MyGrammerParser.TableValValContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#IntVal.
    def visitIntVal(self, ctx:MyGrammerParser.IntValContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#RealVal.
    def visitRealVal(self, ctx:MyGrammerParser.RealValContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#IdVal.
    def visitIdVal(self, ctx:MyGrammerParser.IdValContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MyGrammerParser#StrVal.
    def visitStrVal(self, ctx:MyGrammerParser.StrValContext):
        return self.visitChildren(ctx)



del MyGrammerParser