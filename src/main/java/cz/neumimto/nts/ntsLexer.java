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
		IDENTIFIER=32, VARIABLE_IDENTIFIER=33, INT=34, DOT=35;
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
			"IDENTIFIER", "VARIABLE_IDENTIFIER", "DIGIT", "INT", "DOT", "LETTER", 
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "','", "'}'", null, null, null, "'='", null, 
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
			"VARIABLE_IDENTIFIER", "INT", "DOT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u0169\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\7\b\u0094\n\b\f\b\16\b\u0097\13\b\3\b\3\b\3\b\3\b\7"+
		"\b\u009d\n\b\f\b\16\b\u00a0\13\b\3\b\5\b\u00a3\n\b\3\t\6\t\u00a6\n\t\r"+
		"\t\16\t\u00a7\3\t\3\t\3\n\3\n\7\n\u00ae\n\n\f\n\16\n\u00b1\13\n\3\n\5"+
		"\n\u00b4\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\5\f\u00bd\n\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ce\n\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d7\n\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\5\30\u00f0\n\30\3\31\3\31\3\31\3\31\5\31\u00f6"+
		"\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u011f\n!\3\"\3\"\7\"\u0123\n\"\f\""+
		"\16\"\u0126\13\"\3#\3#\3#\3$\3$\3%\6%\u012e\n%\r%\16%\u012f\3&\3&\3\'"+
		"\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3"+
		"\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38"+
		"\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\4\u0095\u009e\2"+
		"B\3\3\5\4\7\5\t\6\13\7\r\2\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17"+
		"\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36"+
		"=\37? A!C\"E#G\2I$K%M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m"+
		"\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\3\2\"\4\2\f\f\17\17\4\2\13\13"+
		"\"\"\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\4\2C\\c|\4\2CCcc\4\2DDdd\4\2EE"+
		"ee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2"+
		"NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4"+
		"\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u015b\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3\u0083\3\2"+
		"\2\2\5\u0085\3\2\2\2\7\u0087\3\2\2\2\t\u0089\3\2\2\2\13\u008b\3\2\2\2"+
		"\r\u008d\3\2\2\2\17\u00a2\3\2\2\2\21\u00a5\3\2\2\2\23\u00ab\3\2\2\2\25"+
		"\u00b9\3\2\2\2\27\u00bc\3\2\2\2\31\u00c0\3\2\2\2\33\u00cd\3\2\2\2\35\u00d6"+
		"\3\2\2\2\37\u00d8\3\2\2\2!\u00da\3\2\2\2#\u00dc\3\2\2\2%\u00de\3\2\2\2"+
		"\'\u00e0\3\2\2\2)\u00e2\3\2\2\2+\u00e5\3\2\2\2-\u00e8\3\2\2\2/\u00ef\3"+
		"\2\2\2\61\u00f5\3\2\2\2\63\u00f7\3\2\2\2\65\u00f9\3\2\2\2\67\u00fb\3\2"+
		"\2\29\u00fe\3\2\2\2;\u0103\3\2\2\2=\u0107\3\2\2\2?\u010f\3\2\2\2A\u011e"+
		"\3\2\2\2C\u0120\3\2\2\2E\u0127\3\2\2\2G\u012a\3\2\2\2I\u012d\3\2\2\2K"+
		"\u0131\3\2\2\2M\u0133\3\2\2\2O\u0135\3\2\2\2Q\u0137\3\2\2\2S\u0139\3\2"+
		"\2\2U\u013b\3\2\2\2W\u013d\3\2\2\2Y\u013f\3\2\2\2[\u0141\3\2\2\2]\u0143"+
		"\3\2\2\2_\u0145\3\2\2\2a\u0147\3\2\2\2c\u0149\3\2\2\2e\u014b\3\2\2\2g"+
		"\u014d\3\2\2\2i\u014f\3\2\2\2k\u0151\3\2\2\2m\u0153\3\2\2\2o\u0155\3\2"+
		"\2\2q\u0157\3\2\2\2s\u0159\3\2\2\2u\u015b\3\2\2\2w\u015d\3\2\2\2y\u015f"+
		"\3\2\2\2{\u0161\3\2\2\2}\u0163\3\2\2\2\177\u0165\3\2\2\2\u0081\u0167\3"+
		"\2\2\2\u0083\u0084\7*\2\2\u0084\4\3\2\2\2\u0085\u0086\7+\2\2\u0086\6\3"+
		"\2\2\2\u0087\u0088\7}\2\2\u0088\b\3\2\2\2\u0089\u008a\7.\2\2\u008a\n\3"+
		"\2\2\2\u008b\u008c\7\177\2\2\u008c\f\3\2\2\2\u008d\u008e\7^\2\2\u008e"+
		"\u008f\7$\2\2\u008f\16\3\2\2\2\u0090\u0095\7$\2\2\u0091\u0094\5\r\7\2"+
		"\u0092\u0094\n\2\2\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2\2\2\u0094\u0097"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u00a3\7$\2\2\u0099\u009e\7)\2\2\u009a\u009d\5\r\7"+
		"\2\u009b\u009d\n\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a1\u00a3\7)\2\2\u00a2\u0090\3\2\2\2\u00a2\u0099\3\2"+
		"\2\2\u00a3\20\3\2\2\2\u00a4\u00a6\t\3\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\b\t\2\2\u00aa\22\3\2\2\2\u00ab\u00af\7%\2\2\u00ac\u00ae\n\2\2\2"+
		"\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b4\7\17\2\2"+
		"\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6"+
		"\7\f\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\n\2\2\u00b8\24\3\2\2\2\u00b9"+
		"\u00ba\7?\2\2\u00ba\26\3\2\2\2\u00bb\u00bd\7\17\2\2\u00bc\u00bb\3\2\2"+
		"\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7\f\2\2\u00bf\30"+
		"\3\2\2\2\u00c0\u00c1\5q9\2\u00c1\u00c2\5W,\2\u00c2\u00c3\5u;\2\u00c3\u00c4"+
		"\5w<\2\u00c4\u00c5\5q9\2\u00c5\u00c6\5i\65\2\u00c6\32\3\2\2\2\u00c7\u00c8"+
		"\5u;\2\u00c8\u00c9\5q9\2\u00c9\u00ca\5w<\2\u00ca\u00cb\5W,\2\u00cb\u00ce"+
		"\3\2\2\2\u00cc\u00ce\5u;\2\u00cd\u00c7\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\34\3\2\2\2\u00cf\u00d0\5Y-\2\u00d0\u00d1\5O(\2\u00d1\u00d2\5e\63\2\u00d2"+
		"\u00d3\5s:\2\u00d3\u00d4\5W,\2\u00d4\u00d7\3\2\2\2\u00d5\u00d7\5Y-\2\u00d6"+
		"\u00cf\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\36\3\2\2\2\u00d8\u00d9\7-\2\2"+
		"\u00d9 \3\2\2\2\u00da\u00db\7/\2\2\u00db\"\3\2\2\2\u00dc\u00dd\7,\2\2"+
		"\u00dd$\3\2\2\2\u00de\u00df\7\61\2\2\u00df&\3\2\2\2\u00e0\u00e1\7\'\2"+
		"\2\u00e1(\3\2\2\2\u00e2\u00e3\7,\2\2\u00e3\u00e4\7,\2\2\u00e4*\3\2\2\2"+
		"\u00e5\u00e6\7?\2\2\u00e6\u00e7\7?\2\2\u00e7,\3\2\2\2\u00e8\u00e9\7#\2"+
		"\2\u00e9\u00ea\7?\2\2\u00ea.\3\2\2\2\u00eb\u00ec\7>\2\2\u00ec\u00f0\7"+
		"?\2\2\u00ed\u00ee\7?\2\2\u00ee\u00f0\7>\2\2\u00ef\u00eb\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\60\3\2\2\2\u00f1\u00f2\7@\2\2\u00f2\u00f6\7?\2\2"+
		"\u00f3\u00f4\7?\2\2\u00f4\u00f6\7@\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f6\62\3\2\2\2\u00f7\u00f8\7@\2\2\u00f8\64\3\2\2\2\u00f9\u00fa"+
		"\7>\2\2\u00fa\66\3\2\2\2\u00fb\u00fc\5_\60\2\u00fc\u00fd\5Y-\2\u00fd8"+
		"\3\2\2\2\u00fe\u00ff\5W,\2\u00ff\u0100\5e\63\2\u0100\u0101\5s:\2\u0101"+
		"\u0102\5W,\2\u0102:\3\2\2\2\u0103\u0104\5W,\2\u0104\u0105\5i\65\2\u0105"+
		"\u0106\5U+\2\u0106<\3\2\2\2\u0107\u0108\5Y-\2\u0108\u0109\5k\66\2\u0109"+
		"\u010a\5q9\2\u010a\u010b\5W,\2\u010b\u010c\5O(\2\u010c\u010d\5S*\2\u010d"+
		"\u010e\5]/\2\u010e>\3\2\2\2\u010f\u0110\5_\60\2\u0110\u0111\5i\65\2\u0111"+
		"@\3\2\2\2\u0112\u0113\5Y-\2\u0113\u0114\5i\65\2\u0114\u011f\3\2\2\2\u0115"+
		"\u0116\5Y-\2\u0116\u0117\5w<\2\u0117\u0118\5i\65\2\u0118\u0119\5S*\2\u0119"+
		"\u011a\5u;\2\u011a\u011b\5_\60\2\u011b\u011c\5k\66\2\u011c\u011d\5i\65"+
		"\2\u011d\u011f\3\2\2\2\u011e\u0112\3\2\2\2\u011e\u0115\3\2\2\2\u011fB"+
		"\3\2\2\2\u0120\u0124\t\4\2\2\u0121\u0123\t\5\2\2\u0122\u0121\3\2\2\2\u0123"+
		"\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125D\3\2\2\2"+
		"\u0126\u0124\3\2\2\2\u0127\u0128\7B\2\2\u0128\u0129\5C\"\2\u0129F\3\2"+
		"\2\2\u012a\u012b\4\62;\2\u012bH\3\2\2\2\u012c\u012e\t\6\2\2\u012d\u012c"+
		"\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"J\3\2\2\2\u0131\u0132\7\60\2\2\u0132L\3\2\2\2\u0133\u0134\t\7\2\2\u0134"+
		"N\3\2\2\2\u0135\u0136\t\b\2\2\u0136P\3\2\2\2\u0137\u0138\t\t\2\2\u0138"+
		"R\3\2\2\2\u0139\u013a\t\n\2\2\u013aT\3\2\2\2\u013b\u013c\t\13\2\2\u013c"+
		"V\3\2\2\2\u013d\u013e\t\f\2\2\u013eX\3\2\2\2\u013f\u0140\t\r\2\2\u0140"+
		"Z\3\2\2\2\u0141\u0142\t\16\2\2\u0142\\\3\2\2\2\u0143\u0144\t\17\2\2\u0144"+
		"^\3\2\2\2\u0145\u0146\t\20\2\2\u0146`\3\2\2\2\u0147\u0148\t\21\2\2\u0148"+
		"b\3\2\2\2\u0149\u014a\t\22\2\2\u014ad\3\2\2\2\u014b\u014c\t\23\2\2\u014c"+
		"f\3\2\2\2\u014d\u014e\t\24\2\2\u014eh\3\2\2\2\u014f\u0150\t\25\2\2\u0150"+
		"j\3\2\2\2\u0151\u0152\t\26\2\2\u0152l\3\2\2\2\u0153\u0154\t\27\2\2\u0154"+
		"n\3\2\2\2\u0155\u0156\t\30\2\2\u0156p\3\2\2\2\u0157\u0158\t\31\2\2\u0158"+
		"r\3\2\2\2\u0159\u015a\t\32\2\2\u015at\3\2\2\2\u015b\u015c\t\33\2\2\u015c"+
		"v\3\2\2\2\u015d\u015e\t\34\2\2\u015ex\3\2\2\2\u015f\u0160\t\35\2\2\u0160"+
		"z\3\2\2\2\u0161\u0162\t\36\2\2\u0162|\3\2\2\2\u0163\u0164\t\37\2\2\u0164"+
		"~\3\2\2\2\u0165\u0166\t \2\2\u0166\u0080\3\2\2\2\u0167\u0168\t!\2\2\u0168"+
		"\u0082\3\2\2\2\23\2\u0093\u0095\u009c\u009e\u00a2\u00a7\u00af\u00b3\u00bc"+
		"\u00cd\u00d6\u00ef\u00f5\u011e\u0124\u012f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}