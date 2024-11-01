//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "gramatica.y"
package compi.g19.b.AnalisisSintactico;
import java.io.*;
import compi.g19.a.AnalisisLexico.*;
//#line 21 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short ID=257;
public final static short ASIGNACION=258;
public final static short MAYORIGUAL=259;
public final static short MENORIGUAL=260;
public final static short DISTINTO=261;
public final static short CONSTANTE=262;
public final static short CADENA=263;
public final static short IF=264;
public final static short THEN=265;
public final static short ELSE=266;
public final static short BEGIN=267;
public final static short END=268;
public final static short END_IF=269;
public final static short OUTF=270;
public final static short TYPEDEF=271;
public final static short FUN=272;
public final static short RET=273;
public final static short ULONGINT=274;
public final static short SINGLE=275;
public final static short FOR=276;
public final static short OR=277;
public final static short UP=278;
public final static short DOWN=279;
public final static short TRIPLE=280;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    0,    0,    0,    1,    1,    2,    2,    2,
    2,    3,    3,    3,    4,    4,    4,    4,    4,   13,
   13,   13,   13,   14,   14,   16,   16,   16,   16,   16,
   17,   17,   17,   17,   17,   19,   19,    9,    9,    9,
    5,    5,   21,   21,    6,    6,   24,   25,    7,    7,
    7,    7,   22,   22,   26,   27,   27,   23,   23,   23,
   28,   28,   29,   20,   20,   20,   20,   20,   30,   30,
   30,   30,   30,   31,   31,   31,   31,   31,   31,   31,
    8,    8,    8,    8,    8,   10,   10,   10,   10,   33,
   33,   15,   15,   15,   11,   11,   11,   11,   11,   11,
   35,   35,   36,   36,   36,   36,   34,   34,   37,   37,
   37,   37,   37,   37,   18,   18,   18,   32,   38,   38,
   38,   12,   12,   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    3,    2,    2,    1,    2,    2,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    5,
    5,    4,    4,    1,    1,    8,    7,    7,    7,    7,
   12,   11,   11,   11,   10,    1,    1,    3,    6,    3,
    1,    1,    1,    1,    3,    1,    0,    0,   11,    9,
    8,    8,    2,    1,    3,    1,    3,    3,    1,    2,
    2,    1,    4,    3,    3,    1,    3,    3,    3,    3,
    1,    3,    3,    1,    1,    1,    4,    2,    2,    5,
    6,    6,    5,    5,    5,    4,    4,    3,    7,    1,
    1,    2,    3,    2,    7,    7,    9,    9,    9,    9,
    2,    2,    3,    2,    2,    1,    3,    2,    1,    1,
    1,    1,    1,    1,    3,    7,    1,    3,    3,    1,
    1,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,   43,   44,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   24,   25,    4,    6,
    8,    9,   46,    0,    0,    2,   40,    0,   75,    0,
   76,    0,    0,   71,  121,   88,    0,    0,    0,    0,
    0,  117,    0,    0,    0,    1,    0,  124,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   79,    0,    0,    0,    0,   86,    0,   87,    0,    0,
    0,    0,    0,  109,  110,  111,  114,  113,  112,    0,
  122,  123,    0,    0,    0,    0,    0,    0,    0,    0,
   23,   22,    0,    0,    0,    0,   45,    0,    0,   67,
    0,   68,    0,   72,   69,   73,   70,    0,    0,    0,
    0,    0,    0,   84,    0,   83,   85,    0,    0,   94,
    0,    0,   21,   20,   92,    0,    0,    0,    0,   53,
    0,   77,    0,    0,    0,    0,  106,    0,    0,    0,
    0,    0,    0,    0,   82,   81,    0,    0,  108,   93,
    0,    0,    0,    0,    0,    0,   80,   89,    0,  104,
    0,    0,    0,  102,  105,   91,    0,   90,   95,    0,
   96,   36,   37,    0,    0,    0,  107,   62,    0,    0,
    0,   47,    0,    0,    0,    0,  103,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   52,   61,    0,   60,
    0,    0,   51,  116,   63,   97,   99,  100,   98,    0,
    0,    0,    0,    0,   58,   48,   50,    0,    0,    0,
    0,    0,    0,    0,    0,   35,    0,    0,   49,   32,
    0,   34,   33,   31,
};
final static short yydgoto[] = {                          3,
   12,  198,   14,   15,   16,   45,   17,   18,   19,   20,
   21,   22,   23,   36,  111,   37,   38,   64,  195,   65,
   24,  116,  199,  221,  243,  148,  149,  200,  201,   53,
   54,   59,  189,  162,  163,  164,  100,   60,
};
final static short yysindex[] = {                      -155,
  309,  396,    0,  -32,   16,  396,   49,  -28,    0,    0,
  -15,  324,    0,   51,   58, -220,    0,    0,    0,    0,
    0,    0,    0,    0,  345,   80,  103, -116,   34,  380,
  -38,  -58, -125, -107,  -99,  128,    0,    0,    0,    0,
    0,    0,    0,    9,  137,    0,    0,  -19,    0, -227,
    0,   78,   31,    0,    0,    0,   81,  143,  152,  158,
  113,    0,  119,  182,  134,    0,  218,    0,  125, -125,
  202,  216,   20,  -37,  270,  247, -156,   32,   39,  214,
    0,  126,  211,  228,  241,    0,  117,    0,  117,   52,
   78,  252,   59,    0,    0,    0,    0,    0,    0,  117,
    0,    0,  -50,   62,   71,   -9,  -32, -129,  269,  257,
    0,    0,   -7,    0,   82,  294,    0,  254,   89,    0,
   31,    0,   31,    0,    0,    0,    0,  145,   78,  117,
  -51,  244,   78,    0,  -43,    0,    0,   34,  297,    0,
  299,  -92,    0,    0,    0,   95,  344,  359,  360,    0,
  151,    0,  313,  387,   78,  381,    0,  287,  399,  382,
  384,  301, -240,  -69,    0,    0,   35,   54,    0,    0,
  392,  388,  173,  185, -156,  388,    0,    0,  119,    0,
  354,  117,    0,    0,    0,    0,  244,    0,    0,  244,
    0,    0,    0, -175,  192,  193,    0,    0,  190,  388,
  402,    0,  388,    0,  198,  428,    0,  356, -229, -229,
 -229, -229,  411,  -17,  412,  413,    0,    0,  415,    0,
  388,  213,    0,    0,    0,    0,    0,    0,    0,  439,
  424,   34,  446,  449,    0,    0,    0,   34,  451,  463,
   34,   34,  239,  469,   34,    0,  471,  472,    0,    0,
  474,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -177,    0,    0,    0,    0,    0,    0,
    0,  516,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  518,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  116,    0,    0,    1,    0,    0,
    0,  139,   47,    0,    0,    0,  475,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   24,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  475,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   13,    0,    0,    0,    0,    0,    0,
   70,    0,   93,    0,    0,    0,    0,    0,   99,    0,
    0,    0,  -41,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  477,    0,    0,    0,
    0,    0,    0,    0,  159,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -65,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  262,
    0,    0,    0,  101,    0,    0,    0,    0,    0,    0,
    0,    0,  -36,  -35,  -21,  -13,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  141,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   75,  155,    0,  420,  -55,    0,    0,    0,    0,  393,
    0,    0,    0,  487,  -56,    0,    0,  264, -153,  461,
    6, -100, -121,    0,    0,    0,    0,    0,  -27,  343,
  352,  -46, -113,  -94,   25,  122,  401,    0,
};
final static int YYTABLESIZE=672;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        115,
   74,   70,   68,  109,   27,   30,   50,   27,   97,   99,
   98,  135,  147,  142,  196,  186,   92,  115,  112,   29,
   27,  115,  232,   78,   35,  187,  186,   28,  188,   80,
   63,   33,   58,  146,   81,   50,   43,   71,   72,  188,
  214,   74,   74,   74,   74,   74,   66,   74,   77,  138,
  191,   44,  144,   54,  205,   29,   54,  115,   28,   74,
   74,   74,   74,  181,   78,   78,   78,   78,   78,   64,
   78,   79,   84,   63,  204,  103,   25,   85,   50,   42,
   30,  222,   78,   78,   78,   78,  213,   66,   31,   66,
   66,   66,   65,  194,   42,  226,  227,  228,  229,  236,
  114,    1,  192,  193,  161,   66,   66,   66,   66,   41,
   64,    2,   64,   64,   64,   12,   42,    9,   10,  115,
   82,   86,   83,   82,   50,   83,  140,  107,   64,   64,
   64,   64,  206,   65,    5,   65,   65,   65,   38,  118,
    7,   55,  119,   56,   57,   61,   11,   50,    9,   10,
   73,   65,   65,   65,   65,   13,   13,   34,   39,  161,
   13,   50,  161,   50,  107,  102,   40,   82,   75,   83,
   50,    5,  219,   11,   12,  170,   82,    7,   83,   40,
   78,   26,   87,   11,   40,  154,  186,   82,   10,   83,
  101,  108,   88,   97,   99,   98,  190,   38,  108,  188,
  101,   89,  108,  101,  108,   90,  134,   94,   95,   96,
  108,  209,  165,  166,  211,    9,   10,   39,   48,  107,
   27,   30,   93,   49,   67,   26,    5,   27,   30,  108,
   27,   30,    7,   27,   30,   29,  115,  115,   11,   27,
   30,   34,   29,   28,  231,   29,   62,   48,   29,  114,
   28,   32,   49,   28,   29,   50,   28,   74,  101,   74,
   74,   74,   28,  104,   74,   76,    9,   10,   74,   42,
   74,   74,   50,   74,   74,   74,   74,  105,   74,   74,
   78,  106,   78,   78,   78,   50,  113,   78,  117,   62,
   48,   78,  131,   78,   78,   49,   78,   78,   78,   78,
  118,   78,   78,   66,  119,   66,   66,   66,  210,  130,
   66,  212,  192,  193,   66,  145,   66,   66,  136,   66,
   66,   66,   66,  132,   66,   66,   64,  137,   64,   64,
   64,  192,  193,   64,  151,   47,   48,   64,  150,   64,
   64,   49,   64,   64,   64,   64,  152,   64,   64,   65,
  153,   65,   65,   65,  218,  168,   65,  169,   55,   48,
   65,  172,   65,   65,   49,   65,   65,   65,   65,  139,
   65,   65,   12,   48,   55,   48,    9,   10,   49,   12,
   49,  120,   48,   12,  173,   12,   12,   49,   12,   12,
   12,   12,   94,   95,   96,   38,  225,   26,   82,  174,
   83,  167,   38,  175,   26,  177,   38,   26,   38,   38,
   26,   38,   38,   38,   38,   39,   26,  176,   51,   51,
  179,   51,   39,   51,  121,  123,   39,  178,   39,   39,
   11,   39,   39,   39,   39,  125,  127,   11,  182,  202,
  183,   11,  184,   11,   11,   10,   11,   11,   11,   11,
  197,  203,   10,  215,  216,   51,   10,  217,   10,   10,
  220,   10,   10,   10,   10,  223,  122,   48,  224,  230,
  233,  234,   49,  235,   51,   51,   51,   51,  238,   51,
  237,   51,  239,  124,   48,  241,   52,   57,  242,   49,
  245,   69,   51,  110,  110,  240,  126,   48,   51,  157,
  107,  244,   49,  246,  247,  248,  249,    5,  251,  250,
  158,  252,  253,    7,  254,    5,  159,    3,  120,   11,
   56,   74,   51,   91,  143,  107,  107,  141,  110,   59,
   51,  156,    5,    5,    0,  108,  108,    0,    7,    7,
    0,    0,  180,  107,   11,   11,    0,  128,    0,  129,
    5,  160,    0,    0,    0,    0,    7,  107,    0,    0,
  133,  171,   11,    0,    5,    4,    0,    0,  185,    0,
    7,   51,    5,    0,   51,    6,   11,  141,    7,    8,
    4,  171,    9,   10,   11,    0,    0,    5,    0,    0,
  155,   39,    0,    7,    8,    0,    0,    9,   10,   11,
  171,    4,    0,    0,    0,    0,  160,    0,    5,  160,
  107,    0,   46,    0,    7,    8,    0,    5,    9,   10,
   11,  207,    0,    7,   51,    0,    0,    0,    0,   11,
   51,    0,    0,   51,   51,    0,    4,   51,    0,   91,
    0,    0,  208,    5,    4,    0,    0,   66,    0,    7,
    8,    5,    4,    9,   10,   11,    0,    7,    8,    5,
  159,    9,   10,   11,    0,    7,    8,    0,    0,    9,
   10,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   60,   41,   41,   41,   41,   45,   40,   60,   61,
   62,   62,  113,  108,  168,  256,   63,   59,   75,   41,
   40,   77,   40,    0,   40,  266,  256,   41,  269,  257,
   40,   60,   27,   41,  262,   45,  257,   32,   33,  269,
  194,   41,   42,   43,   44,   45,    0,   47,   40,   59,
  164,  272,  109,   41,  176,   40,   44,  113,   91,   59,
   60,   61,   62,  158,   41,   42,   43,   44,   45,    0,
   47,   91,   42,   40,  175,   70,    2,   47,   45,  257,
    6,  203,   59,   60,   61,   62,  262,   41,   40,   43,
   44,   45,    0,   59,  272,  209,  210,  211,  212,  221,
  257,  257,  278,  279,  132,   59,   60,   61,   62,   59,
   41,  267,   43,   44,   45,    0,   59,  274,  275,  175,
   43,   41,   45,   43,   45,   45,  256,  257,   59,   60,
   61,   62,  179,   41,  264,   43,   44,   45,    0,   41,
  270,   41,   44,   41,   44,  262,  276,   45,  274,  275,
  258,   59,   60,   61,   62,    1,    2,  257,    0,  187,
    6,   45,  190,   45,  257,   41,   12,   43,   41,   45,
   45,  264,  200,    0,   59,  268,   43,  270,   45,   25,
   44,   41,   40,  276,   30,   41,  256,   43,    0,   45,
  256,  257,   41,   60,   61,   62,  266,   59,  264,  269,
  266,   44,  268,  269,  270,   93,  257,  259,  260,  261,
  276,  187,  256,  257,  190,  274,  275,   59,  257,  257,
  257,  257,   41,  262,  263,  258,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  257,  262,  267,  256,  257,  270,  257,
  264,  280,  262,  267,  276,   45,  270,  257,   41,  259,
  260,  261,  276,   62,  264,  257,  274,  275,  268,  257,
  270,  271,   45,  273,  274,  275,  276,   62,  278,  279,
  257,  262,  259,  260,  261,   45,   40,  264,  257,  256,
  257,  268,   41,  270,  271,  262,  273,  274,  275,  276,
  262,  278,  279,  257,   91,  259,  260,  261,  187,  258,
  264,  190,  278,  279,  268,   59,  270,  271,  257,  273,
  274,  275,  276,  265,  278,  279,  257,  257,  259,  260,
  261,  278,  279,  264,   41,  256,  257,  268,  257,  270,
  271,  262,  273,  274,  275,  276,   93,  278,  279,  257,
  262,  259,  260,  261,  200,   59,  264,   59,  256,  257,
  268,  267,  270,  271,  262,  273,  274,  275,  276,  106,
  278,  279,  257,  257,  256,  257,  274,  275,  262,  264,
  262,  256,  257,  268,   41,  270,  271,  262,  273,  274,
  275,  276,  259,  260,  261,  257,   41,  257,   43,   41,
   45,  138,  264,   44,  264,   93,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  267,   26,   27,
   40,   29,  264,   31,   82,   83,  268,   41,  270,  271,
  257,  273,  274,  275,  276,   84,   85,  264,   40,  267,
   59,  268,   59,  270,  271,  257,  273,  274,  275,  276,
   59,  267,  264,  262,  262,   63,  268,  268,  270,  271,
   59,  273,  274,  275,  276,  268,  256,  257,   41,   59,
   59,   59,  262,   59,   82,   83,   84,   85,   40,   87,
  268,   89,   59,  256,  257,   40,   26,   27,   40,  262,
   40,   31,  100,   74,   75,  232,  256,  257,  106,  256,
  257,  238,  262,   41,  241,  242,  268,  264,  245,   41,
  267,   41,   41,  270,   41,    0,  273,    0,   44,  276,
   44,   35,  130,   63,  256,  257,  257,  108,  109,  268,
  138,  131,  264,  264,   -1,  267,  267,   -1,  270,  270,
   -1,   -1,  256,  257,  276,  276,   -1,   87,   -1,   89,
  264,  132,   -1,   -1,   -1,   -1,  270,  257,   -1,   -1,
  100,  142,  276,   -1,  264,  257,   -1,   -1,  268,   -1,
  270,  179,  264,   -1,  182,  267,  276,  158,  270,  271,
  257,  162,  274,  275,  276,   -1,   -1,  264,   -1,   -1,
  130,  268,   -1,  270,  271,   -1,   -1,  274,  275,  276,
  181,  257,   -1,   -1,   -1,   -1,  187,   -1,  264,  190,
  257,   -1,  268,   -1,  270,  271,   -1,  264,  274,  275,
  276,  268,   -1,  270,  232,   -1,   -1,   -1,   -1,  276,
  238,   -1,   -1,  241,  242,   -1,  257,  245,   -1,  179,
   -1,   -1,  182,  264,  257,   -1,   -1,  268,   -1,  270,
  271,  264,  257,  274,  275,  276,   -1,  270,  271,  264,
  273,  274,  275,  276,   -1,  270,  271,   -1,   -1,  274,
  275,  276,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=280;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,"'('","')'","'*'","'+'","','",
"'-'",null,"'/'",null,null,null,null,null,null,null,null,null,null,null,"';'",
"'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
"'['",null,"']'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,"ID","ASIGNACION","MAYORIGUAL","MENORIGUAL",
"DISTINTO","CONSTANTE","CADENA","IF","THEN","ELSE","BEGIN","END","END_IF",
"OUTF","TYPEDEF","FUN","RET","ULONGINT","SINGLE","FOR","OR","UP","DOWN",
"TRIPLE",
};
final static String yyrule[] = {
"$accept : programa",
"programa : ID BEGIN list_sentencias END",
"programa : BEGIN list_sentencias END",
"programa : ID BEGIN list_sentencias",
"programa : ID list_sentencias END",
"programa : ID list_sentencias",
"list_sentencias : list_sentencias sentencia",
"list_sentencias : sentencia",
"sentencia : sentencia_declarativa ';'",
"sentencia : sentencia_ejecutable ';'",
"sentencia : sentencia_ejecutable",
"sentencia : sentencia_declarativa",
"sentencia_declarativa : tipo list_variables",
"sentencia_declarativa : declaracion_funcion",
"sentencia_declarativa : declaracion_tipo",
"sentencia_ejecutable : asignacion",
"sentencia_ejecutable : invocacion_funcion",
"sentencia_ejecutable : bloque_if",
"sentencia_ejecutable : salida_mensaje",
"sentencia_ejecutable : sentencia_control",
"sentencia_control : FOR '(' encabezado_for ')' bloque_sentencias_ejecutables",
"sentencia_control : FOR '(' encabezado_for ')' error",
"sentencia_control : FOR encabezado_for ')' bloque_sentencias_ejecutables",
"sentencia_control : FOR '(' encabezado_for bloque_sentencias_ejecutables",
"encabezado_for : encabezado_for1",
"encabezado_for : encabezado_for2",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down '(' condicion ')'",
"up_down : UP",
"up_down : DOWN",
"asignacion : ID ASIGNACION expresion",
"asignacion : ID '[' CONSTANTE ']' ASIGNACION expresion",
"asignacion : ID ASIGNACION error",
"tipo : tipo_base",
"tipo : ID",
"tipo_base : ULONGINT",
"tipo_base : SINGLE",
"list_variables : list_variables ',' ID",
"list_variables : ID",
"$$1 :",
"$$2 :",
"declaracion_funcion : tipo FUN ID '(' parametro ')' BEGIN $$1 cuerpo_funcion $$2 END",
"declaracion_funcion : tipo FUN ID '(' bloque_list_parametro ')' BEGIN cuerpo_funcion END",
"declaracion_funcion : tipo FUN '(' parametro ')' BEGIN cuerpo_funcion END",
"declaracion_funcion : tipo FUN ID '(' ')' BEGIN cuerpo_funcion END",
"parametro : tipo ID",
"parametro : ID",
"bloque_list_parametro : list_parametro ',' parametro",
"list_parametro : parametro",
"list_parametro : list_parametro ',' parametro",
"cuerpo_funcion : list_sentencias_funcion sentencia_return ';'",
"cuerpo_funcion : list_sentencias_funcion",
"cuerpo_funcion : sentencia_return ';'",
"list_sentencias_funcion : list_sentencias_funcion sentencia",
"list_sentencias_funcion : sentencia",
"sentencia_return : RET '(' expresion ')'",
"expresion : expresion '+' termino",
"expresion : expresion '-' termino",
"expresion : termino",
"expresion : expresion '+' error",
"expresion : expresion '-' error",
"termino : termino '*' factor",
"termino : termino '/' factor",
"termino : factor",
"termino : termino '*' error",
"termino : termino '/' error",
"factor : ID",
"factor : CONSTANTE",
"factor : invocacion_funcion",
"factor : ID '[' CONSTANTE ']'",
"factor : '-' ID",
"factor : '-' CONSTANTE",
"factor : '-' ID '[' CONSTANTE ']'",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base '>' ID",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base '>' error",
"declaracion_tipo : TYPEDEF TRIPLE tipo_base '>' ID",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base ID",
"declaracion_tipo : TYPEDEF '<' tipo_base '>' ID",
"invocacion_funcion : ID '(' expresion ')'",
"invocacion_funcion : ID '(' bloque_list_expresiones ')'",
"invocacion_funcion : ID '(' ')'",
"invocacion_funcion : ID '(' tipo_base '(' expresion ')' ')'",
"fin_if : END_IF",
"fin_if : error",
"bloque_sentencias_ejecutables : sentencia_ejecutable ';'",
"bloque_sentencias_ejecutables : BEGIN list_sentencias_ejecutables END",
"bloque_sentencias_ejecutables : BEGIN error",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if_unico fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if_bloque fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_unico fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_bloque fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_bloque fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_unico fin_if",
"cuerpo_if_unico : sentencia_ejecutable ';'",
"cuerpo_if_unico : sentencia_return ';'",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables END",
"cuerpo_if_bloque : BEGIN error",
"cuerpo_if_bloque : list_sentencias_ejecutables END",
"cuerpo_if_bloque : error",
"list_sentencias_ejecutables : list_sentencias_ejecutables sentencia_ejecutable ';'",
"list_sentencias_ejecutables : sentencia_ejecutable ';'",
"comparacion : MAYORIGUAL",
"comparacion : MENORIGUAL",
"comparacion : DISTINTO",
"comparacion : '='",
"comparacion : '>'",
"comparacion : '<'",
"condicion : expresion comparacion expresion",
"condicion : '(' bloque_list_expresiones ')' comparacion '(' bloque_list_expresiones ')'",
"condicion : error",
"bloque_list_expresiones : list_expresiones ',' expresion",
"list_expresiones : list_expresiones ',' expresion",
"list_expresiones : expresion",
"list_expresiones : error",
"salida_mensaje : OUTF '(' CADENA ')'",
"salida_mensaje : OUTF '(' expresion ')'",
"salida_mensaje : OUTF '(' ')'",
};

//#line 263 "gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;
static boolean inFunction = false;
static boolean hasReturn = false;

public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
      System.out.println(t);
      this.yylval = new ParserVal(t.getLexema().toString());
      return (int) t.getId();
    }
    return 0;
}

public static void yyerror(String error){
    AnalizadorLexico.agregarErrorSintactico(error);
}

private void chequeoFlotantesPositivos(String lexema){
    float valor = Float.parseFloat(lexema);
    if  ((valor != 0f) && (valor < AccionSemantica.SINGLE_POSITIVE_MIN || valor >= Float.POSITIVE_INFINITY)) {
        yyerror("Constante flotante fuera de rango");
    }
}

//#line 571 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse() throws IOException {
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 11 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa");}
break;
case 2:
//#line 12 "gramatica.y"
{yyerror("El programa debe tener un nombre");}
break;
case 3:
//#line 13 "gramatica.y"
{yyerror("Falta delimitador END del programa");}
break;
case 4:
//#line 14 "gramatica.y"
{yyerror("Falta delimitador BEGIN del programa");}
break;
case 5:
//#line 15 "gramatica.y"
{yyerror("Faltan los delimitadores del programa");}
break;
case 10:
//#line 25 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
//#line 26 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 12:
//#line 30 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
break;
case 13:
//#line 31 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
//#line 32 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
//#line 36 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 16:
//#line 37 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 21:
//#line 46 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
//#line 47 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
//#line 48 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 26:
//#line 57 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");}
break;
case 27:
//#line 58 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
//#line 59 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
//#line 60 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
//#line 61 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
//#line 65 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");}
break;
case 32:
//#line 66 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
//#line 67 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
//#line 68 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
//#line 69 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 40:
//#line 80 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 47:
//#line 99 "gramatica.y"
{inFunction = true; hasReturn = false;}
break;
case 48:
//#line 99 "gramatica.y"
{ if (!hasReturn) {
                                                                                                 	yyerror("Falta sentencia RET en la función");
                                                                                                 }
                                                                                                 inFunction = false;
                                                                                                 }
break;
case 50:
//#line 104 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");}
break;
case 51:
//#line 105 "gramatica.y"
{yyerror("La funcione debe tener nombre");}
break;
case 52:
//#line 106 "gramatica.y"
{yyerror("La función debe tener parámetro");}
break;
case 54:
//#line 111 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 63:
//#line 135 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 67:
//#line 146 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 68:
//#line 147 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 72:
//#line 154 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 73:
//#line 155 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 75:
//#line 160 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 76:
//#line 167 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 79:
//#line 170 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(1).sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 82:
//#line 179 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 83:
//#line 180 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 84:
//#line 181 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 85:
//#line 182 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 87:
//#line 187 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 88:
//#line 188 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 89:
//#line 189 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 91:
//#line 194 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 94:
//#line 200 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 95:
//#line 204 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF con una sola sentencia en THEN");}
break;
case 96:
//#line 205 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF con múltiples sentencias en THEN");}
break;
case 97:
//#line 206 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con una sola sentencia en cada bloque");}
break;
case 98:
//#line 207 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con múltiples sentencias en cada bloque");}
break;
case 99:
//#line 208 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con una sola sentencia en THEN y múltiples sentencias en ELSE");}
break;
case 100:
//#line 209 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con múltiples sentencias en THEN y una sola sentencia en ELSE");}
break;
case 104:
//#line 219 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 105:
//#line 220 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 106:
//#line 221 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 116:
//#line 241 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
break;
case 117:
//#line 242 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 121:
//#line 253 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 122:
//#line 257 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 123:
//#line 258 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 124:
//#line 259 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 993 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run() throws IOException {
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
