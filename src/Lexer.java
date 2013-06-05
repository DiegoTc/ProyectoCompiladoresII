/* The following code was generated by JFlex 1.4.3 on 06-02-13 12:52 AM */

import java_cup.runtime.*;
      

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 06-02-13 12:52 AM from the specification file
 * <tt>lcalc.flex</tt>
 */
class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\12\1\10\1\0\1\12\1\11\22\0\1\12\1\33\3\0"+
    "\1\25\1\0\1\7\1\13\1\15\1\14\1\23\1\22\1\24\1\4"+
    "\1\16\4\60\6\2\1\21\1\20\1\32\1\31\1\30\2\0\1\40"+
    "\1\56\1\45\1\55\1\52\1\42\1\37\1\54\1\47\2\1\1\6"+
    "\1\41\1\44\1\36\1\34\1\1\1\35\1\51\1\46\1\43\1\50"+
    "\1\53\1\1\1\57\1\1\1\26\1\17\1\27\1\0\1\3\1\0"+
    "\1\40\1\56\1\45\1\55\1\52\1\42\1\37\1\54\1\47\2\1"+
    "\1\6\1\41\1\44\1\36\1\34\1\1\1\35\1\51\1\46\1\43"+
    "\1\50\1\53\1\1\1\57\1\1\1\0\1\5\1\0\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\0\1\2\1\3\1\1\1\4\1\5\1\6"+
    "\2\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\17\3\1\30\1\31\2\32\1\33\1\34\2\0"+
    "\1\35\1\36\1\37\1\40\1\41\2\3\1\42\1\43"+
    "\11\3\1\44\2\3\1\45\10\3\1\46\2\3\1\47"+
    "\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\33"+
    "\1\57\2\0\2\35\3\3\1\60\2\3\1\61\1\3"+
    "\1\62\7\3\1\63\1\3\1\64\2\3\1\65\4\3"+
    "\1\0\1\35\11\3\1\66\1\67\1\70\1\71\1\72"+
    "\1\3\1\73\2\3\1\74\5\3\1\75\1\76\1\3"+
    "\1\77\1\100\2\3\1\101\1\102\1\3\1\103\1\104"+
    "\1\105\1\3\1\106\1\3\1\107\1\3\1\110\1\111";

  private static int [] zzUnpackAction() {
    int [] result = new int[168];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\142\0\u0126"+
    "\0\142\0\u0157\0\u0188\0\142\0\142\0\u01b9\0\142\0\u01ea"+
    "\0\142\0\142\0\142\0\142\0\142\0\142\0\u021b\0\142"+
    "\0\u024c\0\u027d\0\u02ae\0\u02df\0\u0310\0\u0341\0\u0372\0\u03a3"+
    "\0\u03d4\0\u0405\0\u0436\0\u0467\0\u0498\0\u04c9\0\u04fa\0\u052b"+
    "\0\u055c\0\u058d\0\142\0\142\0\u05be\0\u05ef\0\365\0\u0620"+
    "\0\u0651\0\u0682\0\142\0\142\0\142\0\142\0\u06b3\0\u06e4"+
    "\0\223\0\223\0\u0715\0\u0746\0\u0777\0\u07a8\0\u07d9\0\u080a"+
    "\0\u083b\0\u086c\0\u089d\0\223\0\u08ce\0\u08ff\0\223\0\u0930"+
    "\0\u0961\0\u0992\0\u09c3\0\u09f4\0\u0a25\0\u0a56\0\u0a87\0\223"+
    "\0\u0ab8\0\u0ae9\0\142\0\142\0\142\0\142\0\142\0\142"+
    "\0\142\0\142\0\142\0\142\0\u0b1a\0\u0b4b\0\142\0\u0b7c"+
    "\0\u0bad\0\u0bde\0\u0c0f\0\223\0\u0c40\0\u0c71\0\223\0\u0ca2"+
    "\0\223\0\u0cd3\0\u0d04\0\u0d35\0\u0d66\0\u0d97\0\u0dc8\0\u0df9"+
    "\0\223\0\u0e2a\0\223\0\u0e5b\0\u0e8c\0\223\0\u0ebd\0\u0eee"+
    "\0\u0f1f\0\u0f50\0\u0f81\0\u0b1a\0\u0fb2\0\u0fe3\0\u1014\0\u1045"+
    "\0\u1076\0\u10a7\0\u10d8\0\u1109\0\u113a\0\223\0\223\0\223"+
    "\0\223\0\223\0\u116b\0\223\0\u119c\0\u11cd\0\223\0\u11fe"+
    "\0\u122f\0\u1260\0\u1291\0\u12c2\0\223\0\223\0\u12f3\0\223"+
    "\0\223\0\u1324\0\u1355\0\223\0\223\0\u1386\0\223\0\223"+
    "\0\223\0\u13b7\0\223\0\u13e8\0\223\0\u1419\0\223\0\223";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[168];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\3\1\6\1\7\1\4\1\10"+
    "\1\11\1\12\1\11\1\13\1\14\1\15\1\16\1\3"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\4"+
    "\1\36\1\4\1\37\1\40\1\4\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\4\1\50\1\51\1\4"+
    "\1\5\7\52\1\53\1\54\1\55\5\52\1\56\41\52"+
    "\62\0\3\4\2\0\1\4\25\0\25\4\2\0\1\5"+
    "\1\0\1\57\53\0\1\5\2\0\1\57\55\0\1\57"+
    "\10\60\1\0\50\60\10\0\1\11\64\0\1\61\62\0"+
    "\1\62\73\0\1\63\60\0\1\64\60\0\1\65\60\0"+
    "\1\66\30\0\3\4\2\0\1\4\25\0\1\4\1\67"+
    "\23\4\1\0\3\4\2\0\1\4\25\0\16\4\1\70"+
    "\6\4\1\0\3\4\2\0\1\4\25\0\1\4\1\71"+
    "\4\4\1\72\16\4\1\0\3\4\2\0\1\4\25\0"+
    "\1\4\1\73\6\4\1\74\14\4\1\0\3\4\2\0"+
    "\1\75\25\0\2\4\1\76\4\4\1\77\15\4\1\0"+
    "\3\4\2\0\1\4\25\0\10\4\1\100\14\4\1\0"+
    "\3\4\2\0\1\4\25\0\2\4\1\101\1\4\1\102"+
    "\13\4\1\103\4\4\1\0\3\4\2\0\1\4\25\0"+
    "\2\4\1\104\15\4\1\105\2\4\1\106\1\4\1\0"+
    "\3\4\2\0\1\4\25\0\6\4\1\107\1\4\1\110"+
    "\14\4\1\0\3\4\2\0\1\4\25\0\2\4\1\111"+
    "\1\4\1\112\20\4\1\0\3\4\2\0\1\4\25\0"+
    "\12\4\1\113\12\4\1\0\3\4\2\0\1\114\25\0"+
    "\10\4\1\115\14\4\1\0\3\4\2\0\1\4\25\0"+
    "\1\4\1\116\16\4\1\117\4\4\1\0\3\4\2\0"+
    "\1\4\25\0\2\4\1\120\22\4\1\0\3\4\2\0"+
    "\1\4\25\0\2\4\1\121\13\4\1\122\6\4\7\52"+
    "\3\0\5\52\1\0\41\52\10\0\1\54\50\0\7\123"+
    "\1\124\1\0\6\123\1\125\15\123\1\126\4\123\1\127"+
    "\1\123\1\130\1\123\1\131\7\123\1\132\1\123\1\133"+
    "\7\0\1\134\51\0\14\135\1\136\44\135\10\62\1\137"+
    "\1\140\47\62\1\0\3\4\2\0\1\4\25\0\2\4"+
    "\1\141\22\4\1\0\3\4\2\0\1\4\25\0\1\142"+
    "\3\4\1\143\1\4\1\144\2\4\1\145\13\4\1\0"+
    "\3\4\2\0\1\4\25\0\1\4\1\146\23\4\1\0"+
    "\3\4\2\0\1\4\25\0\21\4\1\147\3\4\1\0"+
    "\3\4\2\0\1\4\25\0\2\4\1\150\22\4\1\0"+
    "\3\4\2\0\1\4\25\0\1\4\1\151\23\4\1\0"+
    "\3\4\2\0\1\4\25\0\10\4\1\152\14\4\1\0"+
    "\3\4\2\0\1\4\25\0\12\4\1\153\12\4\1\0"+
    "\3\4\2\0\1\4\25\0\10\4\1\154\14\4\1\0"+
    "\3\4\2\0\1\4\25\0\15\4\1\155\7\4\1\0"+
    "\3\4\2\0\1\4\25\0\4\4\1\156\20\4\1\0"+
    "\3\4\2\0\1\4\25\0\16\4\1\157\6\4\1\0"+
    "\3\4\2\0\1\4\25\0\1\160\24\4\1\0\3\4"+
    "\2\0\1\4\25\0\12\4\1\161\12\4\1\0\3\4"+
    "\2\0\1\4\25\0\13\4\1\162\11\4\1\0\3\4"+
    "\2\0\1\4\25\0\1\4\1\163\23\4\1\0\3\4"+
    "\2\0\1\4\25\0\1\4\1\164\23\4\1\0\3\4"+
    "\2\0\1\4\25\0\15\4\1\165\7\4\1\0\3\4"+
    "\2\0\1\4\25\0\21\4\1\166\3\4\1\0\3\4"+
    "\2\0\1\4\25\0\13\4\1\167\11\4\1\0\3\4"+
    "\2\0\1\4\25\0\13\4\1\170\11\4\1\0\3\4"+
    "\2\0\1\4\25\0\2\4\1\171\22\4\1\0\3\4"+
    "\2\0\1\4\25\0\3\4\1\172\21\4\14\135\1\173"+
    "\57\135\1\0\1\136\1\174\43\135\10\0\1\137\51\0"+
    "\3\4\2\0\1\4\25\0\3\4\1\175\21\4\1\0"+
    "\3\4\2\0\1\4\25\0\16\4\1\176\6\4\1\0"+
    "\3\4\2\0\1\4\25\0\21\4\1\177\3\4\1\0"+
    "\3\4\2\0\1\4\25\0\2\4\1\200\22\4\1\0"+
    "\3\4\2\0\1\4\25\0\4\4\1\201\20\4\1\0"+
    "\3\4\2\0\1\4\25\0\4\4\1\202\20\4\1\0"+
    "\3\4\2\0\1\4\25\0\11\4\1\203\13\4\1\0"+
    "\3\4\2\0\1\4\25\0\13\4\1\204\11\4\1\0"+
    "\3\4\2\0\1\4\25\0\15\4\1\205\7\4\1\0"+
    "\3\4\2\0\1\4\25\0\16\4\1\206\6\4\1\0"+
    "\3\4\2\0\1\4\25\0\1\4\1\207\23\4\1\0"+
    "\3\4\2\0\1\4\25\0\10\4\1\210\14\4\1\0"+
    "\3\4\2\0\1\4\25\0\16\4\1\211\6\4\1\0"+
    "\3\4\2\0\1\4\25\0\21\4\1\212\3\4\1\0"+
    "\3\4\2\0\1\4\25\0\13\4\1\213\11\4\1\0"+
    "\3\4\2\0\1\4\25\0\16\4\1\214\6\4\1\0"+
    "\3\4\2\0\1\4\25\0\12\4\1\215\12\4\1\0"+
    "\3\4\2\0\1\216\25\0\25\4\1\0\3\4\2\0"+
    "\1\217\25\0\25\4\1\0\3\4\2\0\1\4\25\0"+
    "\13\4\1\220\11\4\14\135\1\173\1\137\43\135\1\0"+
    "\3\4\2\0\1\4\25\0\1\4\1\221\23\4\1\0"+
    "\3\4\2\0\1\4\25\0\4\4\1\222\20\4\1\0"+
    "\3\4\2\0\1\223\25\0\25\4\1\0\3\4\2\0"+
    "\1\4\25\0\1\4\1\224\23\4\1\0\3\4\2\0"+
    "\1\4\25\0\23\4\1\225\1\4\1\0\3\4\2\0"+
    "\1\4\25\0\12\4\1\226\12\4\1\0\3\4\2\0"+
    "\1\4\25\0\12\4\1\227\12\4\1\0\3\4\2\0"+
    "\1\230\25\0\25\4\1\0\3\4\2\0\1\4\25\0"+
    "\12\4\1\231\12\4\1\0\3\4\2\0\1\4\25\0"+
    "\10\4\1\232\14\4\1\0\3\4\2\0\1\4\25\0"+
    "\16\4\1\233\6\4\1\0\3\4\2\0\1\4\25\0"+
    "\16\4\1\234\6\4\1\0\3\4\2\0\1\4\25\0"+
    "\10\4\1\235\14\4\1\0\3\4\2\0\1\4\25\0"+
    "\4\4\1\236\20\4\1\0\3\4\2\0\1\4\25\0"+
    "\12\4\1\237\12\4\1\0\3\4\2\0\1\4\25\0"+
    "\10\4\1\240\14\4\1\0\3\4\2\0\1\4\25\0"+
    "\21\4\1\241\3\4\1\0\3\4\2\0\1\4\25\0"+
    "\13\4\1\242\11\4\1\0\3\4\2\0\1\4\25\0"+
    "\3\4\1\243\21\4\1\0\3\4\2\0\1\244\25\0"+
    "\25\4\1\0\3\4\2\0\1\4\25\0\5\4\1\245"+
    "\17\4\1\0\3\4\2\0\1\4\25\0\2\4\1\246"+
    "\22\4\1\0\3\4\2\0\1\4\25\0\10\4\1\247"+
    "\14\4\1\0\3\4\2\0\1\4\25\0\10\4\1\250"+
    "\14\4";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5194];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\0\1\11\3\1\1\11\1\1\1\11\2\1"+
    "\2\11\1\1\1\11\1\1\6\11\1\1\1\11\22\1"+
    "\2\11\3\1\2\0\1\1\4\11\34\1\12\11\2\0"+
    "\1\11\33\1\1\0\55\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[168];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
   
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 178) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 57: 
          { return symbol(sym.TYPE);
          }
        case 74: break;
        case 33: 
          { return symbol(sym.NOT_EQUAL);
          }
        case 75: break;
        case 17: 
          { return symbol(sym.MOD);
          }
        case 76: break;
        case 30: 
          { return symbol(sym.ASSIGN);
          }
        case 77: break;
        case 6: 
          { yybegin(STRING); string.setLength(0);
          }
        case 78: break;
        case 58: 
          { return symbol(sym.VOID);
          }
        case 79: break;
        case 34: 
          { return symbol(sym.OR);
          }
        case 80: break;
        case 22: 
          { return symbol(sym.LESS_THAN);
          }
        case 81: break;
        case 61: 
          { return symbol(sym.ARRAY);
          }
        case 82: break;
        case 62: 
          { return symbol(sym.FLOAT);
          }
        case 83: break;
        case 16: 
          { return symbol(sym.MINUS);
          }
        case 84: break;
        case 32: 
          { return symbol(sym.LESS_THAN_OR_EQUAL);
          }
        case 85: break;
        case 45: 
          { string.append( '\t' );
          }
        case 86: break;
        case 12: 
          { return symbol(sym.SEMICOLON);
          }
        case 87: break;
        case 59: 
          { return symbol(sym.ELSE);
          }
        case 88: break;
        case 21: 
          { return symbol(sym.EQUAL);
          }
        case 89: break;
        case 71: 
          { return symbol(sym.PROGRAM);
          }
        case 90: break;
        case 63: 
          { return symbol(sym.UNTIL);
          }
        case 91: break;
        case 4: 
          { return symbol(sym.DOT);
          }
        case 92: break;
        case 13: 
          { return symbol(sym.COLON);
          }
        case 93: break;
        case 51: 
          { return symbol(sym.INT);
          }
        case 94: break;
        case 49: 
          { return symbol(sym.AND);
          }
        case 95: break;
        case 27: 
          { char val = (char) Integer.parseInt(yytext().substring(1),8);
                        	   string.append( val );
          }
        case 96: break;
        case 44: 
          { string.append( '\n' );
          }
        case 97: break;
        case 37: 
          { return symbol(sym.IF);
          }
        case 98: break;
        case 31: 
          { return symbol(sym.GREATER_THAN);
          }
        case 99: break;
        case 1: 
          { return symbol(sym.INT_LITERAL, new Integer(yytext()));
          }
        case 100: break;
        case 36: 
          { return symbol(sym.TO);
          }
        case 101: break;
        case 23: 
          { return symbol(sym.NOT);
          }
        case 102: break;
        case 25: 
          { yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, string.toString());
          }
        case 103: break;
        case 72: 
          { return symbol(sym.WRITELN);
          }
        case 104: break;
        case 65: 
          { return symbol(sym.WHILE);
          }
        case 105: break;
        case 67: 
          { return symbol(sym.REPEAT);
          }
        case 106: break;
        case 14: 
          { return symbol(sym.SEMI);
          }
        case 107: break;
        case 69: 
          { return symbol(sym.RECORD);
          }
        case 108: break;
        case 35: 
          { return symbol(sym.OF);
          }
        case 109: break;
        case 70: 
          { return symbol(sym.STRING);
          }
        case 110: break;
        case 53: 
          { return symbol(sym.END);
          }
        case 111: break;
        case 39: 
          { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\"");
          }
        case 112: break;
        case 15: 
          { return symbol(sym.PLUS);
          }
        case 113: break;
        case 52: 
          { return symbol(sym.VAR);
          }
        case 114: break;
        case 42: 
          { string.append( '\r' );
          }
        case 115: break;
        case 46: 
          { string.append( '\b' );
          }
        case 116: break;
        case 10: 
          { return symbol(sym.RPAR);
          }
        case 117: break;
        case 66: 
          { return symbol(sym.BEGIN);
          }
        case 118: break;
        case 26: 
          { throw new RuntimeException("Unterminated string at end of line");
          }
        case 119: break;
        case 56: 
          { return symbol(sym.THEN);
          }
        case 120: break;
        case 8: 
          { return symbol(sym.LPAR);
          }
        case 121: break;
        case 9: 
          { return symbol(sym.TIMES);
          }
        case 122: break;
        case 18: 
          { return symbol(sym.LBRACKET);
          }
        case 123: break;
        case 5: 
          { return symbol(sym.BOOLEAN_LITERAL, new Character(yytext().charAt(1)));
          }
        case 124: break;
        case 40: 
          { string.append( '\'' );
          }
        case 125: break;
        case 73: 
          { return symbol(sym.FUNCTION);
          }
        case 126: break;
        case 41: 
          { string.append( '\\' );
          }
        case 127: break;
        case 3: 
          { return symbol(sym.ID, yytext());
          }
        case 128: break;
        case 68: 
          { return symbol(sym.READLN);
          }
        case 129: break;
        case 47: 
          { return symbol(sym.CHAR_LITERAL, new Character(yytext().charAt(1)));
          }
        case 130: break;
        case 7: 
          { /* just skip what was found, do nothing */
          }
        case 131: break;
        case 55: 
          { return symbol(sym.CHAR);
          }
        case 132: break;
        case 48: 
          { return symbol(sym.REF);
          }
        case 133: break;
        case 19: 
          { return symbol(sym.RBRACKET);
          }
        case 134: break;
        case 64: 
          { return symbol(sym.CONST);
          }
        case 135: break;
        case 43: 
          { string.append( '\f' );
          }
        case 136: break;
        case 11: 
          { return symbol(sym.DIVIDE);
          }
        case 137: break;
        case 60: 
          { return symbol(sym.BOOL);
          }
        case 138: break;
        case 29: 
          { /* ignore */
          }
        case 139: break;
        case 2: 
          { throw new Error("Illegal character <"+yytext()+">");
          }
        case 140: break;
        case 20: 
          { return symbol(sym.GREATER_THAN_OR_EQUAL);
          }
        case 141: break;
        case 24: 
          { string.append( yytext() );
          }
        case 142: break;
        case 38: 
          { return symbol(sym.DO);
          }
        case 143: break;
        case 50: 
          { return symbol(sym.FOR);
          }
        case 144: break;
        case 54: 
          { return symbol(sym.CASE);
          }
        case 145: break;
        case 28: 
          { return symbol(sym.FLOAT_LITERAL, new Float(yytext()));
          }
        case 146: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
