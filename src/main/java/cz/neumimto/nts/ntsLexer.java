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
		IDENTIFIER=32, ENUM_IDENTIFIER=33, INT=34, DOT=35;
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
			"IDENTIFIER", "ENUM_IDENTIFIER", "DIGIT", "INT", "DOT", "LETTER", "A", 
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'as'", "'('", "')'", "','", "':'", null, null, null, "'='", null, 
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", 
			"'!='", null, null, "'>'", "'<'", null, null, null, null, null, null, 
			null, null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "LITERAL", "WS", "SL_COMMENT", "ASSIGN", 
			"CRLF", "RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", 
			"EXP", "EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", "GREATER", 
			"LESS", "IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", "IDENTIFIER", 
			"ENUM_IDENTIFIER", "INT", "DOT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u016d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\7\b\u0095\n\b\f\b\16\b\u0098\13\b\3\b\3\b\3\b\3"+
		"\b\7\b\u009e\n\b\f\b\16\b\u00a1\13\b\3\b\5\b\u00a4\n\b\3\t\6\t\u00a7\n"+
		"\t\r\t\16\t\u00a8\3\t\3\t\3\n\3\n\7\n\u00af\n\n\f\n\16\n\u00b2\13\n\3"+
		"\n\5\n\u00b5\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\5\f\u00be\n\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00cf\n"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d8\n\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u00f1\n\30\3\31\3\31\3\31\3\31\5\31"+
		"\u00f7\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0120\n!\3\"\3\"\7\"\u0124\n\""+
		"\f\"\16\"\u0127\13\"\3#\7#\u012a\n#\f#\16#\u012d\13#\3$\3$\3%\6%\u0132"+
		"\n%\r%\16%\u0133\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3."+
		"\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3"+
		"@\3@\3A\3A\4\u0096\u009f\2B\3\3\5\4\7\5\t\6\13\7\r\2\17\b\21\t\23\n\25"+
		"\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31"+
		"\63\32\65\33\67\349\35;\36=\37? A!C\"E#G\2I$K%M\2O\2Q\2S\2U\2W\2Y\2[\2"+
		"]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\3\2"+
		"#\4\2\f\f\17\17\4\2\13\13\"\"\5\2C\\aac|\6\2\62;C\\aac|\4\2C\\aa\3\2\62"+
		";\4\2C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2"+
		"JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4"+
		"\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{"+
		"{\4\2\\\\||\2\u0160\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\3\u0083\3\2\2\2\5\u0086\3\2\2\2\7\u0088\3\2\2\2\t"+
		"\u008a\3\2\2\2\13\u008c\3\2\2\2\r\u008e\3\2\2\2\17\u00a3\3\2\2\2\21\u00a6"+
		"\3\2\2\2\23\u00ac\3\2\2\2\25\u00ba\3\2\2\2\27\u00bd\3\2\2\2\31\u00c1\3"+
		"\2\2\2\33\u00ce\3\2\2\2\35\u00d7\3\2\2\2\37\u00d9\3\2\2\2!\u00db\3\2\2"+
		"\2#\u00dd\3\2\2\2%\u00df\3\2\2\2\'\u00e1\3\2\2\2)\u00e3\3\2\2\2+\u00e6"+
		"\3\2\2\2-\u00e9\3\2\2\2/\u00f0\3\2\2\2\61\u00f6\3\2\2\2\63\u00f8\3\2\2"+
		"\2\65\u00fa\3\2\2\2\67\u00fc\3\2\2\29\u00ff\3\2\2\2;\u0104\3\2\2\2=\u0108"+
		"\3\2\2\2?\u0110\3\2\2\2A\u011f\3\2\2\2C\u0121\3\2\2\2E\u012b\3\2\2\2G"+
		"\u012e\3\2\2\2I\u0131\3\2\2\2K\u0135\3\2\2\2M\u0137\3\2\2\2O\u0139\3\2"+
		"\2\2Q\u013b\3\2\2\2S\u013d\3\2\2\2U\u013f\3\2\2\2W\u0141\3\2\2\2Y\u0143"+
		"\3\2\2\2[\u0145\3\2\2\2]\u0147\3\2\2\2_\u0149\3\2\2\2a\u014b\3\2\2\2c"+
		"\u014d\3\2\2\2e\u014f\3\2\2\2g\u0151\3\2\2\2i\u0153\3\2\2\2k\u0155\3\2"+
		"\2\2m\u0157\3\2\2\2o\u0159\3\2\2\2q\u015b\3\2\2\2s\u015d\3\2\2\2u\u015f"+
		"\3\2\2\2w\u0161\3\2\2\2y\u0163\3\2\2\2{\u0165\3\2\2\2}\u0167\3\2\2\2\177"+
		"\u0169\3\2\2\2\u0081\u016b\3\2\2\2\u0083\u0084\7c\2\2\u0084\u0085\7u\2"+
		"\2\u0085\4\3\2\2\2\u0086\u0087\7*\2\2\u0087\6\3\2\2\2\u0088\u0089\7+\2"+
		"\2\u0089\b\3\2\2\2\u008a\u008b\7.\2\2\u008b\n\3\2\2\2\u008c\u008d\7<\2"+
		"\2\u008d\f\3\2\2\2\u008e\u008f\7^\2\2\u008f\u0090\7$\2\2\u0090\16\3\2"+
		"\2\2\u0091\u0096\7$\2\2\u0092\u0095\5\r\7\2\u0093\u0095\n\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u00a4\7$\2\2\u009a\u009f\7)\2\2\u009b\u009e\5\r\7\2\u009c\u009e\n\2\2"+
		"\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u00a4\7)\2\2\u00a3\u0091\3\2\2\2\u00a3\u009a\3\2\2\2\u00a4\20\3\2\2\2"+
		"\u00a5\u00a7\t\3\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\b\t\2\2\u00ab"+
		"\22\3\2\2\2\u00ac\u00b0\7%\2\2\u00ad\u00af\n\2\2\2\u00ae\u00ad\3\2\2\2"+
		"\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b4"+
		"\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\7\17\2\2\u00b4\u00b3\3\2\2\2"+
		"\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\f\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00b9\b\n\2\2\u00b9\24\3\2\2\2\u00ba\u00bb\7?\2\2\u00bb"+
		"\26\3\2\2\2\u00bc\u00be\7\17\2\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2"+
		"\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7\f\2\2\u00c0\30\3\2\2\2\u00c1\u00c2"+
		"\5q9\2\u00c2\u00c3\5W,\2\u00c3\u00c4\5u;\2\u00c4\u00c5\5w<\2\u00c5\u00c6"+
		"\5q9\2\u00c6\u00c7\5i\65\2\u00c7\32\3\2\2\2\u00c8\u00c9\5u;\2\u00c9\u00ca"+
		"\5q9\2\u00ca\u00cb\5w<\2\u00cb\u00cc\5W,\2\u00cc\u00cf\3\2\2\2\u00cd\u00cf"+
		"\5u;\2\u00ce\u00c8\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\34\3\2\2\2\u00d0"+
		"\u00d1\5Y-\2\u00d1\u00d2\5O(\2\u00d2\u00d3\5e\63\2\u00d3\u00d4\5s:\2\u00d4"+
		"\u00d5\5W,\2\u00d5\u00d8\3\2\2\2\u00d6\u00d8\5Y-\2\u00d7\u00d0\3\2\2\2"+
		"\u00d7\u00d6\3\2\2\2\u00d8\36\3\2\2\2\u00d9\u00da\7-\2\2\u00da \3\2\2"+
		"\2\u00db\u00dc\7/\2\2\u00dc\"\3\2\2\2\u00dd\u00de\7,\2\2\u00de$\3\2\2"+
		"\2\u00df\u00e0\7\61\2\2\u00e0&\3\2\2\2\u00e1\u00e2\7\'\2\2\u00e2(\3\2"+
		"\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e5\7,\2\2\u00e5*\3\2\2\2\u00e6\u00e7"+
		"\7?\2\2\u00e7\u00e8\7?\2\2\u00e8,\3\2\2\2\u00e9\u00ea\7#\2\2\u00ea\u00eb"+
		"\7?\2\2\u00eb.\3\2\2\2\u00ec\u00ed\7>\2\2\u00ed\u00f1\7?\2\2\u00ee\u00ef"+
		"\7?\2\2\u00ef\u00f1\7>\2\2\u00f0\u00ec\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\60\3\2\2\2\u00f2\u00f3\7@\2\2\u00f3\u00f7\7?\2\2\u00f4\u00f5\7?\2\2\u00f5"+
		"\u00f7\7@\2\2\u00f6\u00f2\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\62\3\2\2\2"+
		"\u00f8\u00f9\7@\2\2\u00f9\64\3\2\2\2\u00fa\u00fb\7>\2\2\u00fb\66\3\2\2"+
		"\2\u00fc\u00fd\5_\60\2\u00fd\u00fe\5Y-\2\u00fe8\3\2\2\2\u00ff\u0100\5"+
		"W,\2\u0100\u0101\5e\63\2\u0101\u0102\5s:\2\u0102\u0103\5W,\2\u0103:\3"+
		"\2\2\2\u0104\u0105\5W,\2\u0105\u0106\5i\65\2\u0106\u0107\5U+\2\u0107<"+
		"\3\2\2\2\u0108\u0109\5Y-\2\u0109\u010a\5k\66\2\u010a\u010b\5q9\2\u010b"+
		"\u010c\5W,\2\u010c\u010d\5O(\2\u010d\u010e\5S*\2\u010e\u010f\5]/\2\u010f"+
		">\3\2\2\2\u0110\u0111\5_\60\2\u0111\u0112\5i\65\2\u0112@\3\2\2\2\u0113"+
		"\u0114\5Y-\2\u0114\u0115\5i\65\2\u0115\u0120\3\2\2\2\u0116\u0117\5Y-\2"+
		"\u0117\u0118\5w<\2\u0118\u0119\5i\65\2\u0119\u011a\5S*\2\u011a\u011b\5"+
		"u;\2\u011b\u011c\5_\60\2\u011c\u011d\5k\66\2\u011d\u011e\5i\65\2\u011e"+
		"\u0120\3\2\2\2\u011f\u0113\3\2\2\2\u011f\u0116\3\2\2\2\u0120B\3\2\2\2"+
		"\u0121\u0125\t\4\2\2\u0122\u0124\t\5\2\2\u0123\u0122\3\2\2\2\u0124\u0127"+
		"\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126D\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0128\u012a\t\6\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2"+
		"\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012cF\3\2\2\2\u012d\u012b"+
		"\3\2\2\2\u012e\u012f\4\62;\2\u012fH\3\2\2\2\u0130\u0132\t\7\2\2\u0131"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134J\3\2\2\2\u0135\u0136\7\60\2\2\u0136L\3\2\2\2\u0137\u0138\t"+
		"\b\2\2\u0138N\3\2\2\2\u0139\u013a\t\t\2\2\u013aP\3\2\2\2\u013b\u013c\t"+
		"\n\2\2\u013cR\3\2\2\2\u013d\u013e\t\13\2\2\u013eT\3\2\2\2\u013f\u0140"+
		"\t\f\2\2\u0140V\3\2\2\2\u0141\u0142\t\r\2\2\u0142X\3\2\2\2\u0143\u0144"+
		"\t\16\2\2\u0144Z\3\2\2\2\u0145\u0146\t\17\2\2\u0146\\\3\2\2\2\u0147\u0148"+
		"\t\20\2\2\u0148^\3\2\2\2\u0149\u014a\t\21\2\2\u014a`\3\2\2\2\u014b\u014c"+
		"\t\22\2\2\u014cb\3\2\2\2\u014d\u014e\t\23\2\2\u014ed\3\2\2\2\u014f\u0150"+
		"\t\24\2\2\u0150f\3\2\2\2\u0151\u0152\t\25\2\2\u0152h\3\2\2\2\u0153\u0154"+
		"\t\26\2\2\u0154j\3\2\2\2\u0155\u0156\t\27\2\2\u0156l\3\2\2\2\u0157\u0158"+
		"\t\30\2\2\u0158n\3\2\2\2\u0159\u015a\t\31\2\2\u015ap\3\2\2\2\u015b\u015c"+
		"\t\32\2\2\u015cr\3\2\2\2\u015d\u015e\t\33\2\2\u015et\3\2\2\2\u015f\u0160"+
		"\t\34\2\2\u0160v\3\2\2\2\u0161\u0162\t\35\2\2\u0162x\3\2\2\2\u0163\u0164"+
		"\t\36\2\2\u0164z\3\2\2\2\u0165\u0166\t\37\2\2\u0166|\3\2\2\2\u0167\u0168"+
		"\t \2\2\u0168~\3\2\2\2\u0169\u016a\t!\2\2\u016a\u0080\3\2\2\2\u016b\u016c"+
		"\t\"\2\2\u016c\u0082\3\2\2\2\24\2\u0094\u0096\u009d\u009f\u00a3\u00a8"+
		"\u00b0\u00b4\u00bd\u00ce\u00d7\u00f0\u00f6\u011f\u0125\u012b\u0133\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}