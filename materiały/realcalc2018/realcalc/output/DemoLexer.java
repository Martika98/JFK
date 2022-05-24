// Generated from Demo.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DemoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, PRINT=4, TOINT=5, TOREAL=6, ID=7, REAL=8, INT=9, 
		ADD=10, MULT=11, NEWLINE=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "PRINT", "TOINT", "TOREAL", "ID", "REAL", "INT", 
			"ADD", "MULT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'print'", "'(int)'", "'(real)'", null, null, 
			null, "'+'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "PRINT", "TOINT", "TOREAL", "ID", "REAL", "INT", 
			"ADD", "MULT", "NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DemoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Demo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 12:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17[\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\6\b8"+
		"\n\b\r\b\16\b9\3\t\6\t=\n\t\r\t\16\t>\3\t\3\t\6\tC\n\t\r\t\16\tD\3\n\6"+
		"\nH\n\n\r\n\16\nI\3\13\3\13\3\f\3\f\3\r\5\rQ\n\r\3\r\3\r\3\16\6\16V\n"+
		"\16\r\16\16\16W\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\3\2\4\4\2C\\c|\4\2\13\13\"\"\2`\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13)\3\2"+
		"\2\2\r/\3\2\2\2\17\67\3\2\2\2\21<\3\2\2\2\23G\3\2\2\2\25K\3\2\2\2\27M"+
		"\3\2\2\2\31P\3\2\2\2\33U\3\2\2\2\35\36\7?\2\2\36\4\3\2\2\2\37 \7*\2\2"+
		" \6\3\2\2\2!\"\7+\2\2\"\b\3\2\2\2#$\7r\2\2$%\7t\2\2%&\7k\2\2&\'\7p\2\2"+
		"\'(\7v\2\2(\n\3\2\2\2)*\7*\2\2*+\7k\2\2+,\7p\2\2,-\7v\2\2-.\7+\2\2.\f"+
		"\3\2\2\2/\60\7*\2\2\60\61\7t\2\2\61\62\7g\2\2\62\63\7c\2\2\63\64\7n\2"+
		"\2\64\65\7+\2\2\65\16\3\2\2\2\668\t\2\2\2\67\66\3\2\2\289\3\2\2\29\67"+
		"\3\2\2\29:\3\2\2\2:\20\3\2\2\2;=\4\62;\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2"+
		">?\3\2\2\2?@\3\2\2\2@B\7\60\2\2AC\4\62;\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2"+
		"\2DE\3\2\2\2E\22\3\2\2\2FH\4\62;\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2J\24\3\2\2\2KL\7-\2\2L\26\3\2\2\2MN\7,\2\2N\30\3\2\2\2OQ\7\17\2\2"+
		"PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\7\f\2\2S\32\3\2\2\2TV\t\3\2\2UT\3\2\2"+
		"\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\b\16\2\2Z\34\3\2\2\2\t\2"+
		"9>DIPW\3\3\16\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}