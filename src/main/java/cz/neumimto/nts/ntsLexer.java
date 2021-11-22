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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, LITERAL=7, WS=8, SL_COMMENT=9, 
		ASSIGN=10, CRLF=11, RETURN=12, TRUE=13, FALSE=14, PLUS=15, MINUS=16, MUL=17, 
		DIV=18, MOD=19, EXP=20, EQUAL=21, NOT_EQUAL=22, LESS_EQUAL=23, GREATER_EQUAL=24, 
		GREATER=25, LESS=26, IF=27, ELSE=28, END=29, FOREACH=30, IN=31, FUNCTION=32, 
		IDENTIFIER=33, VARIABLE_IDENTIFIER=34, INT=35, DOT=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "ESCAPED_QUOTE", "LITERAL", 
			"WS", "SL_COMMENT", "ASSIGN", "CRLF", "RETURN", "TRUE", "FALSE", "PLUS", 
			"MINUS", "MUL", "DIV", "MOD", "EXP", "EQUAL", "NOT_EQUAL", "LESS_EQUAL", 
			"GREATER_EQUAL", "GREATER", "LESS", "IF", "ELSE", "END", "FOREACH", "IN", 
			"FUNCTION", "IDENTIFIER", "VARIABLE_IDENTIFIER", "DIGIT", "INT", "DOT", 
			"LETTER", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'as'", "'('", "')'", "'{'", "','", "'}'", null, null, null, "'='", 
			null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", 
			"'!='", null, null, "'>'", "'<'", null, null, null, null, null, null, 
			null, null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "LITERAL", "WS", "SL_COMMENT", 
			"ASSIGN", "CRLF", "RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", 
			"DIV", "MOD", "EXP", "EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", 
			"GREATER", "LESS", "IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", 
			"IDENTIFIER", "VARIABLE_IDENTIFIER", "INT", "DOT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u016e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\7\t\u0099\n\t\f\t\16\t\u009c\13\t"+
		"\3\t\3\t\3\t\3\t\7\t\u00a2\n\t\f\t\16\t\u00a5\13\t\3\t\5\t\u00a8\n\t\3"+
		"\n\6\n\u00ab\n\n\r\n\16\n\u00ac\3\n\3\n\3\13\3\13\7\13\u00b3\n\13\f\13"+
		"\16\13\u00b6\13\13\3\13\5\13\u00b9\n\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\r\5\r\u00c2\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u00d3\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00dc\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u00f5"+
		"\n\31\3\32\3\32\3\32\3\32\5\32\u00fb\n\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3"+
		" \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0124"+
		"\n\"\3#\3#\7#\u0128\n#\f#\16#\u012b\13#\3$\3$\3$\3%\3%\3&\6&\u0133\n&"+
		"\r&\16&\u0134\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/"+
		"\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66"+
		"\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3"+
		"A\3B\3B\4\u009a\u00a3\2C\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\t\23\n\25\13"+
		"\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63"+
		"\32\65\33\67\349\35;\36=\37? A!C\"E#G$I\2K%M&O\2Q\2S\2U\2W\2Y\2[\2]\2"+
		"_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2"+
		"\3\2\"\4\2\f\f\17\17\4\2\13\13\"\"\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\4"+
		"\2C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJ"+
		"jj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2"+
		"SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4"+
		"\2\\\\||\2\u0160\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2"+
		"\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2"+
		";\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3\u0085\3\2\2\2\5\u0088\3\2\2\2\7\u008a\3"+
		"\2\2\2\t\u008c\3\2\2\2\13\u008e\3\2\2\2\r\u0090\3\2\2\2\17\u0092\3\2\2"+
		"\2\21\u00a7\3\2\2\2\23\u00aa\3\2\2\2\25\u00b0\3\2\2\2\27\u00be\3\2\2\2"+
		"\31\u00c1\3\2\2\2\33\u00c5\3\2\2\2\35\u00d2\3\2\2\2\37\u00db\3\2\2\2!"+
		"\u00dd\3\2\2\2#\u00df\3\2\2\2%\u00e1\3\2\2\2\'\u00e3\3\2\2\2)\u00e5\3"+
		"\2\2\2+\u00e7\3\2\2\2-\u00ea\3\2\2\2/\u00ed\3\2\2\2\61\u00f4\3\2\2\2\63"+
		"\u00fa\3\2\2\2\65\u00fc\3\2\2\2\67\u00fe\3\2\2\29\u0100\3\2\2\2;\u0103"+
		"\3\2\2\2=\u0108\3\2\2\2?\u010c\3\2\2\2A\u0114\3\2\2\2C\u0123\3\2\2\2E"+
		"\u0125\3\2\2\2G\u012c\3\2\2\2I\u012f\3\2\2\2K\u0132\3\2\2\2M\u0136\3\2"+
		"\2\2O\u0138\3\2\2\2Q\u013a\3\2\2\2S\u013c\3\2\2\2U\u013e\3\2\2\2W\u0140"+
		"\3\2\2\2Y\u0142\3\2\2\2[\u0144\3\2\2\2]\u0146\3\2\2\2_\u0148\3\2\2\2a"+
		"\u014a\3\2\2\2c\u014c\3\2\2\2e\u014e\3\2\2\2g\u0150\3\2\2\2i\u0152\3\2"+
		"\2\2k\u0154\3\2\2\2m\u0156\3\2\2\2o\u0158\3\2\2\2q\u015a\3\2\2\2s\u015c"+
		"\3\2\2\2u\u015e\3\2\2\2w\u0160\3\2\2\2y\u0162\3\2\2\2{\u0164\3\2\2\2}"+
		"\u0166\3\2\2\2\177\u0168\3\2\2\2\u0081\u016a\3\2\2\2\u0083\u016c\3\2\2"+
		"\2\u0085\u0086\7c\2\2\u0086\u0087\7u\2\2\u0087\4\3\2\2\2\u0088\u0089\7"+
		"*\2\2\u0089\6\3\2\2\2\u008a\u008b\7+\2\2\u008b\b\3\2\2\2\u008c\u008d\7"+
		"}\2\2\u008d\n\3\2\2\2\u008e\u008f\7.\2\2\u008f\f\3\2\2\2\u0090\u0091\7"+
		"\177\2\2\u0091\16\3\2\2\2\u0092\u0093\7^\2\2\u0093\u0094\7$\2\2\u0094"+
		"\20\3\2\2\2\u0095\u009a\7$\2\2\u0096\u0099\5\17\b\2\u0097\u0099\n\2\2"+
		"\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u009b"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u00a8\7$\2\2\u009e\u00a3\7)\2\2\u009f\u00a2\5\17\b\2\u00a0\u00a2\n\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a6\u00a8\7)\2\2\u00a7\u0095\3\2\2\2\u00a7\u009e\3\2\2\2\u00a8"+
		"\22\3\2\2\2\u00a9\u00ab\t\3\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2"+
		"\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af"+
		"\b\n\2\2\u00af\24\3\2\2\2\u00b0\u00b4\7%\2\2\u00b1\u00b3\n\2\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\7\17\2\2\u00b8"+
		"\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\f"+
		"\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\b\13\2\2\u00bd\26\3\2\2\2\u00be\u00bf"+
		"\7?\2\2\u00bf\30\3\2\2\2\u00c0\u00c2\7\17\2\2\u00c1\u00c0\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\f\2\2\u00c4\32\3\2\2"+
		"\2\u00c5\u00c6\5s:\2\u00c6\u00c7\5Y-\2\u00c7\u00c8\5w<\2\u00c8\u00c9\5"+
		"y=\2\u00c9\u00ca\5s:\2\u00ca\u00cb\5k\66\2\u00cb\34\3\2\2\2\u00cc\u00cd"+
		"\5w<\2\u00cd\u00ce\5s:\2\u00ce\u00cf\5y=\2\u00cf\u00d0\5Y-\2\u00d0\u00d3"+
		"\3\2\2\2\u00d1\u00d3\5w<\2\u00d2\u00cc\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"\36\3\2\2\2\u00d4\u00d5\5[.\2\u00d5\u00d6\5Q)\2\u00d6\u00d7\5g\64\2\u00d7"+
		"\u00d8\5u;\2\u00d8\u00d9\5Y-\2\u00d9\u00dc\3\2\2\2\u00da\u00dc\5[.\2\u00db"+
		"\u00d4\3\2\2\2\u00db\u00da\3\2\2\2\u00dc \3\2\2\2\u00dd\u00de\7-\2\2\u00de"+
		"\"\3\2\2\2\u00df\u00e0\7/\2\2\u00e0$\3\2\2\2\u00e1\u00e2\7,\2\2\u00e2"+
		"&\3\2\2\2\u00e3\u00e4\7\61\2\2\u00e4(\3\2\2\2\u00e5\u00e6\7\'\2\2\u00e6"+
		"*\3\2\2\2\u00e7\u00e8\7,\2\2\u00e8\u00e9\7,\2\2\u00e9,\3\2\2\2\u00ea\u00eb"+
		"\7?\2\2\u00eb\u00ec\7?\2\2\u00ec.\3\2\2\2\u00ed\u00ee\7#\2\2\u00ee\u00ef"+
		"\7?\2\2\u00ef\60\3\2\2\2\u00f0\u00f1\7>\2\2\u00f1\u00f5\7?\2\2\u00f2\u00f3"+
		"\7?\2\2\u00f3\u00f5\7>\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\62\3\2\2\2\u00f6\u00f7\7@\2\2\u00f7\u00fb\7?\2\2\u00f8\u00f9\7?\2\2\u00f9"+
		"\u00fb\7@\2\2\u00fa\u00f6\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\64\3\2\2\2"+
		"\u00fc\u00fd\7@\2\2\u00fd\66\3\2\2\2\u00fe\u00ff\7>\2\2\u00ff8\3\2\2\2"+
		"\u0100\u0101\5a\61\2\u0101\u0102\5[.\2\u0102:\3\2\2\2\u0103\u0104\5Y-"+
		"\2\u0104\u0105\5g\64\2\u0105\u0106\5u;\2\u0106\u0107\5Y-\2\u0107<\3\2"+
		"\2\2\u0108\u0109\5Y-\2\u0109\u010a\5k\66\2\u010a\u010b\5W,\2\u010b>\3"+
		"\2\2\2\u010c\u010d\5[.\2\u010d\u010e\5m\67\2\u010e\u010f\5s:\2\u010f\u0110"+
		"\5Y-\2\u0110\u0111\5Q)\2\u0111\u0112\5U+\2\u0112\u0113\5_\60\2\u0113@"+
		"\3\2\2\2\u0114\u0115\5a\61\2\u0115\u0116\5k\66\2\u0116B\3\2\2\2\u0117"+
		"\u0118\5[.\2\u0118\u0119\5k\66\2\u0119\u0124\3\2\2\2\u011a\u011b\5[.\2"+
		"\u011b\u011c\5y=\2\u011c\u011d\5k\66\2\u011d\u011e\5U+\2\u011e\u011f\5"+
		"w<\2\u011f\u0120\5a\61\2\u0120\u0121\5m\67\2\u0121\u0122\5k\66\2\u0122"+
		"\u0124\3\2\2\2\u0123\u0117\3\2\2\2\u0123\u011a\3\2\2\2\u0124D\3\2\2\2"+
		"\u0125\u0129\t\4\2\2\u0126\u0128\t\5\2\2\u0127\u0126\3\2\2\2\u0128\u012b"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012aF\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012c\u012d\7B\2\2\u012d\u012e\5E#\2\u012eH\3\2\2\2\u012f"+
		"\u0130\4\62;\2\u0130J\3\2\2\2\u0131\u0133\t\6\2\2\u0132\u0131\3\2\2\2"+
		"\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135L\3"+
		"\2\2\2\u0136\u0137\7\60\2\2\u0137N\3\2\2\2\u0138\u0139\t\7\2\2\u0139P"+
		"\3\2\2\2\u013a\u013b\t\b\2\2\u013bR\3\2\2\2\u013c\u013d\t\t\2\2\u013d"+
		"T\3\2\2\2\u013e\u013f\t\n\2\2\u013fV\3\2\2\2\u0140\u0141\t\13\2\2\u0141"+
		"X\3\2\2\2\u0142\u0143\t\f\2\2\u0143Z\3\2\2\2\u0144\u0145\t\r\2\2\u0145"+
		"\\\3\2\2\2\u0146\u0147\t\16\2\2\u0147^\3\2\2\2\u0148\u0149\t\17\2\2\u0149"+
		"`\3\2\2\2\u014a\u014b\t\20\2\2\u014bb\3\2\2\2\u014c\u014d\t\21\2\2\u014d"+
		"d\3\2\2\2\u014e\u014f\t\22\2\2\u014ff\3\2\2\2\u0150\u0151\t\23\2\2\u0151"+
		"h\3\2\2\2\u0152\u0153\t\24\2\2\u0153j\3\2\2\2\u0154\u0155\t\25\2\2\u0155"+
		"l\3\2\2\2\u0156\u0157\t\26\2\2\u0157n\3\2\2\2\u0158\u0159\t\27\2\2\u0159"+
		"p\3\2\2\2\u015a\u015b\t\30\2\2\u015br\3\2\2\2\u015c\u015d\t\31\2\2\u015d"+
		"t\3\2\2\2\u015e\u015f\t\32\2\2\u015fv\3\2\2\2\u0160\u0161\t\33\2\2\u0161"+
		"x\3\2\2\2\u0162\u0163\t\34\2\2\u0163z\3\2\2\2\u0164\u0165\t\35\2\2\u0165"+
		"|\3\2\2\2\u0166\u0167\t\36\2\2\u0167~\3\2\2\2\u0168\u0169\t\37\2\2\u0169"+
		"\u0080\3\2\2\2\u016a\u016b\t \2\2\u016b\u0082\3\2\2\2\u016c\u016d\t!\2"+
		"\2\u016d\u0084\3\2\2\2\23\2\u0098\u009a\u00a1\u00a3\u00a7\u00ac\u00b4"+
		"\u00b8\u00c1\u00d2\u00db\u00f4\u00fa\u0123\u0129\u0134\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}