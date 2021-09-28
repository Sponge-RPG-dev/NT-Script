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
		T__0=1, T__1=2, T__2=3, LITERAL=4, WS=5, SL_COMMENT=6, ASSIGN=7, CRLF=8, 
		RETURN=9, TRUE=10, FALSE=11, PLUS=12, MINUS=13, MUL=14, DIV=15, MOD=16, 
		EXP=17, EQUAL=18, NOT_EQUAL=19, LESS_EQUAL=20, GREATER_EQUAL=21, GREATER=22, 
		LESS=23, IF=24, ELSE=25, END=26, FOREACH=27, IN=28, FUNCTION=29, IDENTIFIER=30, 
		VARIABLE_IDENTIFIER=31, INT=32, DOT=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "ESCAPED_QUOTE", "LITERAL", "WS", "SL_COMMENT", 
			"ASSIGN", "CRLF", "RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", 
			"DIV", "MOD", "EXP", "EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", 
			"GREATER", "LESS", "IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", 
			"IDENTIFIER", "VARIABLE_IDENTIFIER", "DIGIT", "INT", "DOT", "LETTER", 
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "','", "'}'", null, null, null, "'='", null, null, null, 
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", "'!='", null, 
			null, "'>'", "'<'", null, null, null, null, null, null, null, null, null, 
			"'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "LITERAL", "WS", "SL_COMMENT", "ASSIGN", "CRLF", 
			"RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", "EXP", 
			"EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", "GREATER", "LESS", 
			"IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", "IDENTIFIER", "VARIABLE_IDENTIFIER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u0161\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\7\6\u008c"+
		"\n\6\f\6\16\6\u008f\13\6\3\6\3\6\3\6\3\6\7\6\u0095\n\6\f\6\16\6\u0098"+
		"\13\6\3\6\5\6\u009b\n\6\3\7\6\7\u009e\n\7\r\7\16\7\u009f\3\7\3\7\3\b\3"+
		"\b\7\b\u00a6\n\b\f\b\16\b\u00a9\13\b\3\b\5\b\u00ac\n\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\n\5\n\u00b5\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c6\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u00cf\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u00e8\n\26"+
		"\3\27\3\27\3\27\3\27\5\27\u00ee\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\5\37\u0117\n\37\3 \3 \7 \u011b\n \f \16 \u011e\13"+
		" \3!\3!\3!\3\"\3\"\3#\6#\u0126\n#\r#\16#\u0127\3$\3$\3%\3%\3&\3&\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39"+
		"\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\4\u008d\u0096\2@\3\3\5\4\7\5\t"+
		"\2\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%"+
		"\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? A!C\2E\""+
		"G#I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u"+
		"\2w\2y\2{\2}\2\3\2\"\4\2\f\f\17\17\4\2\13\13\"\"\5\2C\\aac|\6\2\62;C\\"+
		"aac|\3\2\62;\4\2C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh"+
		"\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2Q"+
		"Qqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4"+
		"\2ZZzz\4\2[[{{\4\2\\\\||\2\u0153\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\3\177\3\2\2\2\5\u0081\3\2\2\2\7\u0083\3\2\2\2\t\u0085\3\2"+
		"\2\2\13\u009a\3\2\2\2\r\u009d\3\2\2\2\17\u00a3\3\2\2\2\21\u00b1\3\2\2"+
		"\2\23\u00b4\3\2\2\2\25\u00b8\3\2\2\2\27\u00c5\3\2\2\2\31\u00ce\3\2\2\2"+
		"\33\u00d0\3\2\2\2\35\u00d2\3\2\2\2\37\u00d4\3\2\2\2!\u00d6\3\2\2\2#\u00d8"+
		"\3\2\2\2%\u00da\3\2\2\2\'\u00dd\3\2\2\2)\u00e0\3\2\2\2+\u00e7\3\2\2\2"+
		"-\u00ed\3\2\2\2/\u00ef\3\2\2\2\61\u00f1\3\2\2\2\63\u00f3\3\2\2\2\65\u00f6"+
		"\3\2\2\2\67\u00fb\3\2\2\29\u00ff\3\2\2\2;\u0107\3\2\2\2=\u0116\3\2\2\2"+
		"?\u0118\3\2\2\2A\u011f\3\2\2\2C\u0122\3\2\2\2E\u0125\3\2\2\2G\u0129\3"+
		"\2\2\2I\u012b\3\2\2\2K\u012d\3\2\2\2M\u012f\3\2\2\2O\u0131\3\2\2\2Q\u0133"+
		"\3\2\2\2S\u0135\3\2\2\2U\u0137\3\2\2\2W\u0139\3\2\2\2Y\u013b\3\2\2\2["+
		"\u013d\3\2\2\2]\u013f\3\2\2\2_\u0141\3\2\2\2a\u0143\3\2\2\2c\u0145\3\2"+
		"\2\2e\u0147\3\2\2\2g\u0149\3\2\2\2i\u014b\3\2\2\2k\u014d\3\2\2\2m\u014f"+
		"\3\2\2\2o\u0151\3\2\2\2q\u0153\3\2\2\2s\u0155\3\2\2\2u\u0157\3\2\2\2w"+
		"\u0159\3\2\2\2y\u015b\3\2\2\2{\u015d\3\2\2\2}\u015f\3\2\2\2\177\u0080"+
		"\7}\2\2\u0080\4\3\2\2\2\u0081\u0082\7.\2\2\u0082\6\3\2\2\2\u0083\u0084"+
		"\7\177\2\2\u0084\b\3\2\2\2\u0085\u0086\7^\2\2\u0086\u0087\7$\2\2\u0087"+
		"\n\3\2\2\2\u0088\u008d\7$\2\2\u0089\u008c\5\t\5\2\u008a\u008c\n\2\2\2"+
		"\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u009b\7$\2\2\u0091\u0096\7)\2\2\u0092\u0095\5\t\5\2\u0093\u0095\n\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009b\7)\2\2\u009a\u0088\3\2\2\2\u009a\u0091\3\2\2\2\u009b\f\3\2\2\2"+
		"\u009c\u009e\t\3\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\b\7\2\2\u00a2"+
		"\16\3\2\2\2\u00a3\u00a7\7%\2\2\u00a4\u00a6\n\2\2\2\u00a5\u00a4\3\2\2\2"+
		"\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac\7\17\2\2\u00ab\u00aa\3\2\2\2"+
		"\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\f\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b0\b\b\2\2\u00b0\20\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2"+
		"\22\3\2\2\2\u00b3\u00b5\7\17\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2"+
		"\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\f\2\2\u00b7\24\3\2\2\2\u00b8\u00b9"+
		"\5m\67\2\u00b9\u00ba\5S*\2\u00ba\u00bb\5q9\2\u00bb\u00bc\5s:\2\u00bc\u00bd"+
		"\5m\67\2\u00bd\u00be\5e\63\2\u00be\26\3\2\2\2\u00bf\u00c0\5q9\2\u00c0"+
		"\u00c1\5m\67\2\u00c1\u00c2\5s:\2\u00c2\u00c3\5S*\2\u00c3\u00c6\3\2\2\2"+
		"\u00c4\u00c6\5q9\2\u00c5\u00bf\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\30\3"+
		"\2\2\2\u00c7\u00c8\5U+\2\u00c8\u00c9\5K&\2\u00c9\u00ca\5a\61\2\u00ca\u00cb"+
		"\5o8\2\u00cb\u00cc\5S*\2\u00cc\u00cf\3\2\2\2\u00cd\u00cf\5U+\2\u00ce\u00c7"+
		"\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\32\3\2\2\2\u00d0\u00d1\7-\2\2\u00d1"+
		"\34\3\2\2\2\u00d2\u00d3\7/\2\2\u00d3\36\3\2\2\2\u00d4\u00d5\7,\2\2\u00d5"+
		" \3\2\2\2\u00d6\u00d7\7\61\2\2\u00d7\"\3\2\2\2\u00d8\u00d9\7\'\2\2\u00d9"+
		"$\3\2\2\2\u00da\u00db\7,\2\2\u00db\u00dc\7,\2\2\u00dc&\3\2\2\2\u00dd\u00de"+
		"\7?\2\2\u00de\u00df\7?\2\2\u00df(\3\2\2\2\u00e0\u00e1\7#\2\2\u00e1\u00e2"+
		"\7?\2\2\u00e2*\3\2\2\2\u00e3\u00e4\7>\2\2\u00e4\u00e8\7?\2\2\u00e5\u00e6"+
		"\7?\2\2\u00e6\u00e8\7>\2\2\u00e7\u00e3\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8"+
		",\3\2\2\2\u00e9\u00ea\7@\2\2\u00ea\u00ee\7?\2\2\u00eb\u00ec\7?\2\2\u00ec"+
		"\u00ee\7@\2\2\u00ed\u00e9\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee.\3\2\2\2\u00ef"+
		"\u00f0\7@\2\2\u00f0\60\3\2\2\2\u00f1\u00f2\7>\2\2\u00f2\62\3\2\2\2\u00f3"+
		"\u00f4\5[.\2\u00f4\u00f5\5U+\2\u00f5\64\3\2\2\2\u00f6\u00f7\5S*\2\u00f7"+
		"\u00f8\5a\61\2\u00f8\u00f9\5o8\2\u00f9\u00fa\5S*\2\u00fa\66\3\2\2\2\u00fb"+
		"\u00fc\5S*\2\u00fc\u00fd\5e\63\2\u00fd\u00fe\5Q)\2\u00fe8\3\2\2\2\u00ff"+
		"\u0100\5U+\2\u0100\u0101\5g\64\2\u0101\u0102\5m\67\2\u0102\u0103\5S*\2"+
		"\u0103\u0104\5K&\2\u0104\u0105\5O(\2\u0105\u0106\5Y-\2\u0106:\3\2\2\2"+
		"\u0107\u0108\5[.\2\u0108\u0109\5e\63\2\u0109<\3\2\2\2\u010a\u010b\5U+"+
		"\2\u010b\u010c\5e\63\2\u010c\u0117\3\2\2\2\u010d\u010e\5U+\2\u010e\u010f"+
		"\5s:\2\u010f\u0110\5e\63\2\u0110\u0111\5O(\2\u0111\u0112\5q9\2\u0112\u0113"+
		"\5[.\2\u0113\u0114\5g\64\2\u0114\u0115\5e\63\2\u0115\u0117\3\2\2\2\u0116"+
		"\u010a\3\2\2\2\u0116\u010d\3\2\2\2\u0117>\3\2\2\2\u0118\u011c\t\4\2\2"+
		"\u0119\u011b\t\5\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d@\3\2\2\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0120\7B\2\2\u0120\u0121\5? \2\u0121B\3\2\2\2\u0122\u0123\4\62;\2\u0123"+
		"D\3\2\2\2\u0124\u0126\t\6\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2"+
		"\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128F\3\2\2\2\u0129\u012a\7"+
		"\60\2\2\u012aH\3\2\2\2\u012b\u012c\t\7\2\2\u012cJ\3\2\2\2\u012d\u012e"+
		"\t\b\2\2\u012eL\3\2\2\2\u012f\u0130\t\t\2\2\u0130N\3\2\2\2\u0131\u0132"+
		"\t\n\2\2\u0132P\3\2\2\2\u0133\u0134\t\13\2\2\u0134R\3\2\2\2\u0135\u0136"+
		"\t\f\2\2\u0136T\3\2\2\2\u0137\u0138\t\r\2\2\u0138V\3\2\2\2\u0139\u013a"+
		"\t\16\2\2\u013aX\3\2\2\2\u013b\u013c\t\17\2\2\u013cZ\3\2\2\2\u013d\u013e"+
		"\t\20\2\2\u013e\\\3\2\2\2\u013f\u0140\t\21\2\2\u0140^\3\2\2\2\u0141\u0142"+
		"\t\22\2\2\u0142`\3\2\2\2\u0143\u0144\t\23\2\2\u0144b\3\2\2\2\u0145\u0146"+
		"\t\24\2\2\u0146d\3\2\2\2\u0147\u0148\t\25\2\2\u0148f\3\2\2\2\u0149\u014a"+
		"\t\26\2\2\u014ah\3\2\2\2\u014b\u014c\t\27\2\2\u014cj\3\2\2\2\u014d\u014e"+
		"\t\30\2\2\u014el\3\2\2\2\u014f\u0150\t\31\2\2\u0150n\3\2\2\2\u0151\u0152"+
		"\t\32\2\2\u0152p\3\2\2\2\u0153\u0154\t\33\2\2\u0154r\3\2\2\2\u0155\u0156"+
		"\t\34\2\2\u0156t\3\2\2\2\u0157\u0158\t\35\2\2\u0158v\3\2\2\2\u0159\u015a"+
		"\t\36\2\2\u015ax\3\2\2\2\u015b\u015c\t\37\2\2\u015cz\3\2\2\2\u015d\u015e"+
		"\t \2\2\u015e|\3\2\2\2\u015f\u0160\t!\2\2\u0160~\3\2\2\2\23\2\u008b\u008d"+
		"\u0094\u0096\u009a\u009f\u00a7\u00ab\u00b4\u00c5\u00ce\u00e7\u00ed\u0116"+
		"\u011c\u0127\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}