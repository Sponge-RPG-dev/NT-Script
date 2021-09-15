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
		T__0=1, T__1=2, T__2=3, T__3=4, LITERAL=5, WS=6, SL_COMMENT=7, ASSIGN=8, 
		CRLF=9, RETURN=10, TRUE=11, FALSE=12, PLUS=13, MINUS=14, MUL=15, DIV=16, 
		MOD=17, EXP=18, EQUAL=19, NOT_EQUAL=20, LESS_EQUAL=21, GREATER_EQUAL=22, 
		GREATER=23, LESS=24, IF=25, ELSE=26, END=27, FOREACH=28, IN=29, FUNCTION=30, 
		IDENTIFIER=31, VARIABLE_IDENTIFIER=32, INT=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "ESCAPED_QUOTE", "LITERAL", "WS", "SL_COMMENT", 
			"ASSIGN", "CRLF", "RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", 
			"DIV", "MOD", "EXP", "EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", 
			"GREATER", "LESS", "IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", 
			"IDENTIFIER", "VARIABLE_IDENTIFIER", "DIGIT", "INT", "LETTER", "A", "B", 
			"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'{'", "','", "'}'", null, null, null, "'='", null, null, 
			null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", "'!='", 
			null, null, "'>'", "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "LITERAL", "WS", "SL_COMMENT", "ASSIGN", 
			"CRLF", "RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", 
			"EXP", "EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", "GREATER", 
			"LESS", "IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", "IDENTIFIER", 
			"VARIABLE_IDENTIFIER", "INT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u0161\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\7"+
		"\7\u008e\n\7\f\7\16\7\u0091\13\7\3\7\3\7\3\7\3\7\7\7\u0097\n\7\f\7\16"+
		"\7\u009a\13\7\3\7\5\7\u009d\n\7\3\b\6\b\u00a0\n\b\r\b\16\b\u00a1\3\b\3"+
		"\b\3\t\3\t\7\t\u00a8\n\t\f\t\16\t\u00ab\13\t\3\t\5\t\u00ae\n\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\13\5\13\u00b7\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c8\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00d1\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\5\27\u00ea\n\27\3\30\3\30\3\30\3\30\5\30\u00f0\n\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \5 \u0119\n \3!\3!\7!\u011d\n!\f!\16!\u0120\13!\3\"\3\""+
		"\3\"\3#\3#\3$\6$\u0128\n$\r$\16$\u0129\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3"+
		"\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;"+
		"\3;\3<\3<\3=\3=\3>\3>\3?\3?\4\u008f\u0098\2@\3\3\5\4\7\5\t\6\13\2\r\7"+
		"\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25"+
		"+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E\2G#I\2K\2M\2"+
		"O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2"+
		"}\2\3\2\"\4\2\f\f\17\17\4\2\13\13\"\"\5\2C\\aac|\6\2\62;C\\aac|\3\2\62"+
		";\4\2C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2"+
		"JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4"+
		"\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{"+
		"{\4\2\\\\||\2\u0153\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2G\3\2\2\2\3"+
		"\177\3\2\2\2\5\u0081\3\2\2\2\7\u0083\3\2\2\2\t\u0085\3\2\2\2\13\u0087"+
		"\3\2\2\2\r\u009c\3\2\2\2\17\u009f\3\2\2\2\21\u00a5\3\2\2\2\23\u00b3\3"+
		"\2\2\2\25\u00b6\3\2\2\2\27\u00ba\3\2\2\2\31\u00c7\3\2\2\2\33\u00d0\3\2"+
		"\2\2\35\u00d2\3\2\2\2\37\u00d4\3\2\2\2!\u00d6\3\2\2\2#\u00d8\3\2\2\2%"+
		"\u00da\3\2\2\2\'\u00dc\3\2\2\2)\u00df\3\2\2\2+\u00e2\3\2\2\2-\u00e9\3"+
		"\2\2\2/\u00ef\3\2\2\2\61\u00f1\3\2\2\2\63\u00f3\3\2\2\2\65\u00f5\3\2\2"+
		"\2\67\u00f8\3\2\2\29\u00fd\3\2\2\2;\u0101\3\2\2\2=\u0109\3\2\2\2?\u0118"+
		"\3\2\2\2A\u011a\3\2\2\2C\u0121\3\2\2\2E\u0124\3\2\2\2G\u0127\3\2\2\2I"+
		"\u012b\3\2\2\2K\u012d\3\2\2\2M\u012f\3\2\2\2O\u0131\3\2\2\2Q\u0133\3\2"+
		"\2\2S\u0135\3\2\2\2U\u0137\3\2\2\2W\u0139\3\2\2\2Y\u013b\3\2\2\2[\u013d"+
		"\3\2\2\2]\u013f\3\2\2\2_\u0141\3\2\2\2a\u0143\3\2\2\2c\u0145\3\2\2\2e"+
		"\u0147\3\2\2\2g\u0149\3\2\2\2i\u014b\3\2\2\2k\u014d\3\2\2\2m\u014f\3\2"+
		"\2\2o\u0151\3\2\2\2q\u0153\3\2\2\2s\u0155\3\2\2\2u\u0157\3\2\2\2w\u0159"+
		"\3\2\2\2y\u015b\3\2\2\2{\u015d\3\2\2\2}\u015f\3\2\2\2\177\u0080\7\60\2"+
		"\2\u0080\4\3\2\2\2\u0081\u0082\7}\2\2\u0082\6\3\2\2\2\u0083\u0084\7.\2"+
		"\2\u0084\b\3\2\2\2\u0085\u0086\7\177\2\2\u0086\n\3\2\2\2\u0087\u0088\7"+
		"^\2\2\u0088\u0089\7$\2\2\u0089\f\3\2\2\2\u008a\u008f\7$\2\2\u008b\u008e"+
		"\5\13\6\2\u008c\u008e\n\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2"+
		"\u008e\u0091\3\2\2\2\u008f\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u009d\7$\2\2\u0093\u0098\7)\2\2\u0094"+
		"\u0097\5\13\6\2\u0095\u0097\n\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3"+
		"\2\2\2\u0097\u009a\3\2\2\2\u0098\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009d\7)\2\2\u009c\u008a\3\2"+
		"\2\2\u009c\u0093\3\2\2\2\u009d\16\3\2\2\2\u009e\u00a0\t\3\2\2\u009f\u009e"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\b\b\2\2\u00a4\20\3\2\2\2\u00a5\u00a9\7%\2\2"+
		"\u00a6\u00a8\n\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00ae\7\17\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3"+
		"\2\2\2\u00af\u00b0\7\f\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b\t\2\2\u00b2"+
		"\22\3\2\2\2\u00b3\u00b4\7?\2\2\u00b4\24\3\2\2\2\u00b5\u00b7\7\17\2\2\u00b6"+
		"\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\f"+
		"\2\2\u00b9\26\3\2\2\2\u00ba\u00bb\5m\67\2\u00bb\u00bc\5S*\2\u00bc\u00bd"+
		"\5q9\2\u00bd\u00be\5s:\2\u00be\u00bf\5m\67\2\u00bf\u00c0\5e\63\2\u00c0"+
		"\30\3\2\2\2\u00c1\u00c2\5q9\2\u00c2\u00c3\5m\67\2\u00c3\u00c4\5s:\2\u00c4"+
		"\u00c5\5S*\2\u00c5\u00c8\3\2\2\2\u00c6\u00c8\5q9\2\u00c7\u00c1\3\2\2\2"+
		"\u00c7\u00c6\3\2\2\2\u00c8\32\3\2\2\2\u00c9\u00ca\5U+\2\u00ca\u00cb\5"+
		"K&\2\u00cb\u00cc\5a\61\2\u00cc\u00cd\5o8\2\u00cd\u00ce\5S*\2\u00ce\u00d1"+
		"\3\2\2\2\u00cf\u00d1\5U+\2\u00d0\u00c9\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1"+
		"\34\3\2\2\2\u00d2\u00d3\7-\2\2\u00d3\36\3\2\2\2\u00d4\u00d5\7/\2\2\u00d5"+
		" \3\2\2\2\u00d6\u00d7\7,\2\2\u00d7\"\3\2\2\2\u00d8\u00d9\7\61\2\2\u00d9"+
		"$\3\2\2\2\u00da\u00db\7\'\2\2\u00db&\3\2\2\2\u00dc\u00dd\7,\2\2\u00dd"+
		"\u00de\7,\2\2\u00de(\3\2\2\2\u00df\u00e0\7?\2\2\u00e0\u00e1\7?\2\2\u00e1"+
		"*\3\2\2\2\u00e2\u00e3\7#\2\2\u00e3\u00e4\7?\2\2\u00e4,\3\2\2\2\u00e5\u00e6"+
		"\7>\2\2\u00e6\u00ea\7?\2\2\u00e7\u00e8\7?\2\2\u00e8\u00ea\7>\2\2\u00e9"+
		"\u00e5\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea.\3\2\2\2\u00eb\u00ec\7@\2\2\u00ec"+
		"\u00f0\7?\2\2\u00ed\u00ee\7?\2\2\u00ee\u00f0\7@\2\2\u00ef\u00eb\3\2\2"+
		"\2\u00ef\u00ed\3\2\2\2\u00f0\60\3\2\2\2\u00f1\u00f2\7@\2\2\u00f2\62\3"+
		"\2\2\2\u00f3\u00f4\7>\2\2\u00f4\64\3\2\2\2\u00f5\u00f6\5[.\2\u00f6\u00f7"+
		"\5U+\2\u00f7\66\3\2\2\2\u00f8\u00f9\5S*\2\u00f9\u00fa\5a\61\2\u00fa\u00fb"+
		"\5o8\2\u00fb\u00fc\5S*\2\u00fc8\3\2\2\2\u00fd\u00fe\5S*\2\u00fe\u00ff"+
		"\5e\63\2\u00ff\u0100\5Q)\2\u0100:\3\2\2\2\u0101\u0102\5U+\2\u0102\u0103"+
		"\5g\64\2\u0103\u0104\5m\67\2\u0104\u0105\5S*\2\u0105\u0106\5K&\2\u0106"+
		"\u0107\5O(\2\u0107\u0108\5Y-\2\u0108<\3\2\2\2\u0109\u010a\5[.\2\u010a"+
		"\u010b\5e\63\2\u010b>\3\2\2\2\u010c\u010d\5U+\2\u010d\u010e\5e\63\2\u010e"+
		"\u0119\3\2\2\2\u010f\u0110\5U+\2\u0110\u0111\5s:\2\u0111\u0112\5e\63\2"+
		"\u0112\u0113\5O(\2\u0113\u0114\5q9\2\u0114\u0115\5[.\2\u0115\u0116\5g"+
		"\64\2\u0116\u0117\5e\63\2\u0117\u0119\3\2\2\2\u0118\u010c\3\2\2\2\u0118"+
		"\u010f\3\2\2\2\u0119@\3\2\2\2\u011a\u011e\t\4\2\2\u011b\u011d\t\5\2\2"+
		"\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011fB\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7B\2\2\u0122\u0123"+
		"\5A!\2\u0123D\3\2\2\2\u0124\u0125\4\62;\2\u0125F\3\2\2\2\u0126\u0128\t"+
		"\6\2\2\u0127\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012aH\3\2\2\2\u012b\u012c\t\7\2\2\u012cJ\3\2\2\2\u012d"+
		"\u012e\t\b\2\2\u012eL\3\2\2\2\u012f\u0130\t\t\2\2\u0130N\3\2\2\2\u0131"+
		"\u0132\t\n\2\2\u0132P\3\2\2\2\u0133\u0134\t\13\2\2\u0134R\3\2\2\2\u0135"+
		"\u0136\t\f\2\2\u0136T\3\2\2\2\u0137\u0138\t\r\2\2\u0138V\3\2\2\2\u0139"+
		"\u013a\t\16\2\2\u013aX\3\2\2\2\u013b\u013c\t\17\2\2\u013cZ\3\2\2\2\u013d"+
		"\u013e\t\20\2\2\u013e\\\3\2\2\2\u013f\u0140\t\21\2\2\u0140^\3\2\2\2\u0141"+
		"\u0142\t\22\2\2\u0142`\3\2\2\2\u0143\u0144\t\23\2\2\u0144b\3\2\2\2\u0145"+
		"\u0146\t\24\2\2\u0146d\3\2\2\2\u0147\u0148\t\25\2\2\u0148f\3\2\2\2\u0149"+
		"\u014a\t\26\2\2\u014ah\3\2\2\2\u014b\u014c\t\27\2\2\u014cj\3\2\2\2\u014d"+
		"\u014e\t\30\2\2\u014el\3\2\2\2\u014f\u0150\t\31\2\2\u0150n\3\2\2\2\u0151"+
		"\u0152\t\32\2\2\u0152p\3\2\2\2\u0153\u0154\t\33\2\2\u0154r\3\2\2\2\u0155"+
		"\u0156\t\34\2\2\u0156t\3\2\2\2\u0157\u0158\t\35\2\2\u0158v\3\2\2\2\u0159"+
		"\u015a\t\36\2\2\u015ax\3\2\2\2\u015b\u015c\t\37\2\2\u015cz\3\2\2\2\u015d"+
		"\u015e\t \2\2\u015e|\3\2\2\2\u015f\u0160\t!\2\2\u0160~\3\2\2\2\23\2\u008d"+
		"\u008f\u0096\u0098\u009c\u00a1\u00a9\u00ad\u00b6\u00c7\u00d0\u00e9\u00ef"+
		"\u0118\u011e\u0129\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}