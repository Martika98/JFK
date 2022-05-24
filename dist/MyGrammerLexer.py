# Generated from MyGrammer.g4 by ANTLR 4.9.2
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
    from typing import TextIO
else:
    from typing.io import TextIO



def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f")
        buf.write("F\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7")
        buf.write("\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3\2\3\2\3\3\3\3\3\4")
        buf.write("\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3")
        buf.write("\b\3\b\3\b\3\b\3\b\3\b\5\b\60\n\b\3\t\3\t\3\t\3\t\3\t")
        buf.write("\3\t\3\t\5\t9\n\t\3\n\6\n<\n\n\r\n\16\n=\3\13\6\13A\n")
        buf.write("\13\r\13\16\13B\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r")
        buf.write("\b\17\t\21\n\23\13\25\f\3\2\4\3\2\62;\4\2\13\13\"\"\2")
        buf.write("I\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13")
        buf.write("\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3")
        buf.write("\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\31\3\2\2\2\7\33\3\2")
        buf.write("\2\2\t\35\3\2\2\2\13\37\3\2\2\2\r!\3\2\2\2\17/\3\2\2\2")
        buf.write("\218\3\2\2\2\23;\3\2\2\2\25@\3\2\2\2\27\30\7,\2\2\30\4")
        buf.write("\3\2\2\2\31\32\7\61\2\2\32\6\3\2\2\2\33\34\7-\2\2\34\b")
        buf.write("\3\2\2\2\35\36\7/\2\2\36\n\3\2\2\2\37 \7*\2\2 \f\3\2\2")
        buf.write("\2!\"\7+\2\2\"\16\3\2\2\2#$\7j\2\2$%\7g\2\2%&\7n\2\2&")
        buf.write("\'\7n\2\2\'\60\7q\2\2()\7d\2\2)*\7q\2\2*+\7p\2\2+,\7l")
        buf.write("\2\2,-\7q\2\2-.\7w\2\2.\60\7t\2\2/#\3\2\2\2/(\3\2\2\2")
        buf.write("\60\20\3\2\2\2\61\62\7d\2\2\62\63\7{\2\2\639\7g\2\2\64")
        buf.write("\65\7v\2\2\65\66\7c\2\2\66\67\7v\2\2\679\7c\2\28\61\3")
        buf.write("\2\2\28\64\3\2\2\29\22\3\2\2\2:<\t\2\2\2;:\3\2\2\2<=\3")
        buf.write("\2\2\2=;\3\2\2\2=>\3\2\2\2>\24\3\2\2\2?A\t\3\2\2@?\3\2")
        buf.write("\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\b\13\2")
        buf.write("\2E\26\3\2\2\2\7\2/8=B\3\b\2\2")
        return buf.getvalue()


class MyGrammerLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    T__0 = 1
    T__1 = 2
    T__2 = 3
    T__3 = 4
    T__4 = 5
    T__5 = 6
    HELLO = 7
    BYE = 8
    INT = 9
    WS = 10

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
            "'*'", "'/'", "'+'", "'-'", "'('", "')'" ]

    symbolicNames = [ "<INVALID>",
            "HELLO", "BYE", "INT", "WS" ]

    ruleNames = [ "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "HELLO", 
                  "BYE", "INT", "WS" ]

    grammarFileName = "MyGrammer.g4"

    def __init__(self, input=None, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.9.2")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


