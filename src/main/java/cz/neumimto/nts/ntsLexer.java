// Generated from nts.g4 by ANTLR 4.9.2
package cz.neumimto.nts;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ntsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, LITERAL=6, WS=7, SL_COMMENT=8, 
		ASSIGN=9, CRLF=10, RETURN=11, TRUE=12, FALSE=13, PLUS=14, MINUS=15, MUL=16, 
		DIV=17, MOD=18, EXP=19, EQUAL=20, NOT_EQUAL=21, LESS_EQUAL=22, GREATER_EQUAL=23, 
		GREATER=24, LESS=25, IF=26, ELSE=27, END=28, FOREACH=29, IN=30, FUNCTION=31, 
		IDENTIFIER=32, INT=33, DOT=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "ESCAPED_QUOTE", "LITERAL", "WS", 
			"SL_COMMENT", "ASSIGN", "CRLF", "RETURN", "TRUE", "FALSE", "PLUS", "MINUS", 
			"MUL", "DIV", "MOD", "EXP", "EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", 
			"GREATER", "LESS", "IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", 
			"IDENTIFIER", "DIGIT", "INT", "DOT", "LETTER", "A", "B", "C", "D", "E", 
			"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
			"T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'as'", "'('", "')'", "','", "':'", null, null, null, "'='", null, 
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", 
			"'!='", null, null, "'>'", "'<'", null, null, null, null, null, null, 
			null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "LITERAL", "WS", "SL_COMMENT", "ASSIGN", 
			"CRLF", "RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", 
			"EXP", "EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", "GREATER", 
			"LESS", "IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", "IDENTIFIER", 
			"INT", "DOT"
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


	public ntsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "nts.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0165\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\7\b\u0093\n\b\f\b\16\b\u0096\13\b\3\b\3\b\3\b\3\b\7\b"+
		"\u009c\n\b\f\b\16\b\u009f\13\b\3\b\5\b\u00a2\n\b\3\t\6\t\u00a5\n\t\r\t"+
		"\16\t\u00a6\3\t\3\t\3\n\3\n\7\n\u00ad\n\n\f\n\16\n\u00b0\13\n\3\n\5\n"+
		"\u00b3\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\5\f\u00bc\n\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00cd\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d6\n\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\5\30\u00ef\n\30\3\31\3\31\3\31\3\31\5\31\u00f5\n"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u011e\n!\3\"\3\"\7\"\u0122\n\"\f\"\16"+
		"\"\u0125\13\"\3#\3#\3$\6$\u012a\n$\r$\16$\u012b\3%\3%\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3"+
		":\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\4\u0094\u009d\2A\3\3\5\4\7\5"+
		"\t\6\13\7\r\2\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22"+
		"%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E"+
		"\2G#I$K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2"+
		"u\2w\2y\2{\2}\2\177\2\3\2\"\4\2\f\f\17\17\4\2\13\13\"\"\5\2C\\aac|\6\2"+
		"\62;C\\aac|\3\2\62;\4\2C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4"+
		"\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPp"+
		"p\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2"+
		"YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u0157\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2G\3\2\2\2\2I\3\2\2\2\3\u0081\3\2\2\2\5\u0084\3\2\2\2\7\u0086\3\2"+
		"\2\2\t\u0088\3\2\2\2\13\u008a\3\2\2\2\r\u008c\3\2\2\2\17\u00a1\3\2\2\2"+
		"\21\u00a4\3\2\2\2\23\u00aa\3\2\2\2\25\u00b8\3\2\2\2\27\u00bb\3\2\2\2\31"+
		"\u00bf\3\2\2\2\33\u00cc\3\2\2\2\35\u00d5\3\2\2\2\37\u00d7\3\2\2\2!\u00d9"+
		"\3\2\2\2#\u00db\3\2\2\2%\u00dd\3\2\2\2\'\u00df\3\2\2\2)\u00e1\3\2\2\2"+
		"+\u00e4\3\2\2\2-\u00e7\3\2\2\2/\u00ee\3\2\2\2\61\u00f4\3\2\2\2\63\u00f6"+
		"\3\2\2\2\65\u00f8\3\2\2\2\67\u00fa\3\2\2\29\u00fd\3\2\2\2;\u0102\3\2\2"+
		"\2=\u0106\3\2\2\2?\u010e\3\2\2\2A\u011d\3\2\2\2C\u011f\3\2\2\2E\u0126"+
		"\3\2\2\2G\u0129\3\2\2\2I\u012d\3\2\2\2K\u012f\3\2\2\2M\u0131\3\2\2\2O"+
		"\u0133\3\2\2\2Q\u0135\3\2\2\2S\u0137\3\2\2\2U\u0139\3\2\2\2W\u013b\3\2"+
		"\2\2Y\u013d\3\2\2\2[\u013f\3\2\2\2]\u0141\3\2\2\2_\u0143\3\2\2\2a\u0145"+
		"\3\2\2\2c\u0147\3\2\2\2e\u0149\3\2\2\2g\u014b\3\2\2\2i\u014d\3\2\2\2k"+
		"\u014f\3\2\2\2m\u0151\3\2\2\2o\u0153\3\2\2\2q\u0155\3\2\2\2s\u0157\3\2"+
		"\2\2u\u0159\3\2\2\2w\u015b\3\2\2\2y\u015d\3\2\2\2{\u015f\3\2\2\2}\u0161"+
		"\3\2\2\2\177\u0163\3\2\2\2\u0081\u0082\7c\2\2\u0082\u0083\7u\2\2\u0083"+
		"\4\3\2\2\2\u0084\u0085\7*\2\2\u0085\6\3\2\2\2\u0086\u0087\7+\2\2\u0087"+
		"\b\3\2\2\2\u0088\u0089\7.\2\2\u0089\n\3\2\2\2\u008a\u008b\7<\2\2\u008b"+
		"\f\3\2\2\2\u008c\u008d\7^\2\2\u008d\u008e\7$\2\2\u008e\16\3\2\2\2\u008f"+
		"\u0094\7$\2\2\u0090\u0093\5\r\7\2\u0091\u0093\n\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0095\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u00a2\7$"+
		"\2\2\u0098\u009d\7)\2\2\u0099\u009c\5\r\7\2\u009a\u009c\n\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a2\7)\2\2\u00a1\u008f\3\2\2\2\u00a1\u0098\3\2\2\2\u00a2\20\3\2\2\2"+
		"\u00a3\u00a5\t\3\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\t\2\2\u00a9"+
		"\22\3\2\2\2\u00aa\u00ae\7%\2\2\u00ab\u00ad\n\2\2\2\u00ac\u00ab\3\2\2\2"+
		"\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b2"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\7\17\2\2\u00b2\u00b1\3\2\2\2"+
		"\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\7\f\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b7\b\n\2\2\u00b7\24\3\2\2\2\u00b8\u00b9\7?\2\2\u00b9"+
		"\26\3\2\2\2\u00ba\u00bc\7\17\2\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2"+
		"\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\7\f\2\2\u00be\30\3\2\2\2\u00bf\u00c0"+
		"\5o8\2\u00c0\u00c1\5U+\2\u00c1\u00c2\5s:\2\u00c2\u00c3\5u;\2\u00c3\u00c4"+
		"\5o8\2\u00c4\u00c5\5g\64\2\u00c5\32\3\2\2\2\u00c6\u00c7\5s:\2\u00c7\u00c8"+
		"\5o8\2\u00c8\u00c9\5u;\2\u00c9\u00ca\5U+\2\u00ca\u00cd\3\2\2\2\u00cb\u00cd"+
		"\5s:\2\u00cc\u00c6\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\34\3\2\2\2\u00ce"+
		"\u00cf\5W,\2\u00cf\u00d0\5M\'\2\u00d0\u00d1\5c\62\2\u00d1\u00d2\5q9\2"+
		"\u00d2\u00d3\5U+\2\u00d3\u00d6\3\2\2\2\u00d4\u00d6\5W,\2\u00d5\u00ce\3"+
		"\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\36\3\2\2\2\u00d7\u00d8\7-\2\2\u00d8 "+
		"\3\2\2\2\u00d9\u00da\7/\2\2\u00da\"\3\2\2\2\u00db\u00dc\7,\2\2\u00dc$"+
		"\3\2\2\2\u00dd\u00de\7\61\2\2\u00de&\3\2\2\2\u00df\u00e0\7\'\2\2\u00e0"+
		"(\3\2\2\2\u00e1\u00e2\7,\2\2\u00e2\u00e3\7,\2\2\u00e3*\3\2\2\2\u00e4\u00e5"+
		"\7?\2\2\u00e5\u00e6\7?\2\2\u00e6,\3\2\2\2\u00e7\u00e8\7#\2\2\u00e8\u00e9"+
		"\7?\2\2\u00e9.\3\2\2\2\u00ea\u00eb\7>\2\2\u00eb\u00ef\7?\2\2\u00ec\u00ed"+
		"\7?\2\2\u00ed\u00ef\7>\2\2\u00ee\u00ea\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef"+
		"\60\3\2\2\2\u00f0\u00f1\7@\2\2\u00f1\u00f5\7?\2\2\u00f2\u00f3\7?\2\2\u00f3"+
		"\u00f5\7@\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\62\3\2\2\2"+
		"\u00f6\u00f7\7@\2\2\u00f7\64\3\2\2\2\u00f8\u00f9\7>\2\2\u00f9\66\3\2\2"+
		"\2\u00fa\u00fb\5]/\2\u00fb\u00fc\5W,\2\u00fc8\3\2\2\2\u00fd\u00fe\5U+"+
		"\2\u00fe\u00ff\5c\62\2\u00ff\u0100\5q9\2\u0100\u0101\5U+\2\u0101:\3\2"+
		"\2\2\u0102\u0103\5U+\2\u0103\u0104\5g\64\2\u0104\u0105\5S*\2\u0105<\3"+
		"\2\2\2\u0106\u0107\5W,\2\u0107\u0108\5i\65\2\u0108\u0109\5o8\2\u0109\u010a"+
		"\5U+\2\u010a\u010b\5M\'\2\u010b\u010c\5Q)\2\u010c\u010d\5[.\2\u010d>\3"+
		"\2\2\2\u010e\u010f\5]/\2\u010f\u0110\5g\64\2\u0110@\3\2\2\2\u0111\u0112"+
		"\5W,\2\u0112\u0113\5g\64\2\u0113\u011e\3\2\2\2\u0114\u0115\5W,\2\u0115"+
		"\u0116\5u;\2\u0116\u0117\5g\64\2\u0117\u0118\5Q)\2\u0118\u0119\5s:\2\u0119"+
		"\u011a\5]/\2\u011a\u011b\5i\65\2\u011b\u011c\5g\64\2\u011c\u011e\3\2\2"+
		"\2\u011d\u0111\3\2\2\2\u011d\u0114\3\2\2\2\u011eB\3\2\2\2\u011f\u0123"+
		"\t\4\2\2\u0120\u0122\t\5\2\2\u0121\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124D\3\2\2\2\u0125\u0123\3\2\2\2"+
		"\u0126\u0127\4\62;\2\u0127F\3\2\2\2\u0128\u012a\t\6\2\2\u0129\u0128\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"H\3\2\2\2\u012d\u012e\7\60\2\2\u012eJ\3\2\2\2\u012f\u0130\t\7\2\2\u0130"+
		"L\3\2\2\2\u0131\u0132\t\b\2\2\u0132N\3\2\2\2\u0133\u0134\t\t\2\2\u0134"+
		"P\3\2\2\2\u0135\u0136\t\n\2\2\u0136R\3\2\2\2\u0137\u0138\t\13\2\2\u0138"+
		"T\3\2\2\2\u0139\u013a\t\f\2\2\u013aV\3\2\2\2\u013b\u013c\t\r\2\2\u013c"+
		"X\3\2\2\2\u013d\u013e\t\16\2\2\u013eZ\3\2\2\2\u013f\u0140\t\17\2\2\u0140"+
		"\\\3\2\2\2\u0141\u0142\t\20\2\2\u0142^\3\2\2\2\u0143\u0144\t\21\2\2\u0144"+
		"`\3\2\2\2\u0145\u0146\t\22\2\2\u0146b\3\2\2\2\u0147\u0148\t\23\2\2\u0148"+
		"d\3\2\2\2\u0149\u014a\t\24\2\2\u014af\3\2\2\2\u014b\u014c\t\25\2\2\u014c"+
		"h\3\2\2\2\u014d\u014e\t\26\2\2\u014ej\3\2\2\2\u014f\u0150\t\27\2\2\u0150"+
		"l\3\2\2\2\u0151\u0152\t\30\2\2\u0152n\3\2\2\2\u0153\u0154\t\31\2\2\u0154"+
		"p\3\2\2\2\u0155\u0156\t\32\2\2\u0156r\3\2\2\2\u0157\u0158\t\33\2\2\u0158"+
		"t\3\2\2\2\u0159\u015a\t\34\2\2\u015av\3\2\2\2\u015b\u015c\t\35\2\2\u015c"+
		"x\3\2\2\2\u015d\u015e\t\36\2\2\u015ez\3\2\2\2\u015f\u0160\t\37\2\2\u0160"+
		"|\3\2\2\2\u0161\u0162\t \2\2\u0162~\3\2\2\2\u0163\u0164\t!\2\2\u0164\u0080"+
		"\3\2\2\2\23\2\u0092\u0094\u009b\u009d\u00a1\u00a6\u00ae\u00b2\u00bb\u00cc"+
		"\u00d5\u00ee\u00f4\u011d\u0123\u012b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}