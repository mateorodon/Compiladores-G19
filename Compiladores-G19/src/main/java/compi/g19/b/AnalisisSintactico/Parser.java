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
    0,    0,    0,    0,    0,    1,    1,    1,    2,    2,
    3,    3,    3,    4,    4,    4,    4,    4,   13,   13,
   13,   13,   14,   14,   14,   14,   14,   14,   17,   17,
    9,    9,    5,    5,   19,   19,    6,    6,    6,   22,
   23,    7,    7,    7,    7,   20,   20,   24,   25,   25,
   21,   21,   21,   26,   18,   18,   18,   27,   27,   27,
   28,   28,   28,   28,   28,   28,   28,   28,    8,    8,
    8,    8,    8,   10,   10,   10,   30,   30,   15,   15,
   15,   11,   11,   11,   11,   11,   11,   11,   11,   32,
   32,   32,   31,   31,   31,   31,   33,   33,   33,   33,
   33,   33,   33,   16,   16,   29,   34,   34,   12,   12,
   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    3,    3,    3,    2,    2,    1,    1,
    2,    1,    1,    1,    1,    1,    1,    1,    5,    5,
    5,    4,    8,   12,   11,   11,   11,   11,    1,    1,
    3,    6,    1,    1,    1,    1,    3,    2,    1,    0,
    0,   11,    9,    8,    8,    2,    1,    3,    1,    3,
    3,    1,    2,    4,    3,    3,    1,    3,    3,    1,
    1,    1,    1,    4,    2,    2,    5,    1,    0,    6,
    6,    3,    5,    4,    4,    7,    1,    1,    2,    2,
    3,    9,    7,    9,    7,    6,    6,    8,    8,    1,
    5,    2,    3,    2,    2,    3,    1,    1,    1,    1,
    1,    1,    1,    3,    7,    3,    3,    1,    4,    4,
    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,   35,   36,
    0,    0,    0,    9,   10,    0,   12,   13,   14,   15,
   16,   17,   18,   33,    0,    0,    0,    0,   68,    0,
   62,    0,    0,   63,    0,    0,    0,   60,    5,    0,
    0,    0,    0,    0,    4,    0,    8,    7,   39,    0,
    0,    2,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   66,    0,  103,   97,   98,   99,
    0,    0,  102,  101,  100,    0,    0,    0,    1,    0,
  111,    0,   72,    0,    0,    0,    0,    6,    0,    0,
   38,    0,   74,    0,   75,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   58,   59,  109,
  110,    0,    0,    0,    0,    0,    0,    0,   22,    0,
    0,    0,    0,   37,    0,    0,    0,   64,    0,    0,
   90,    0,    0,    0,    0,    0,    0,   73,    0,    0,
   21,    0,    0,   20,   19,   80,   79,    0,    0,    0,
    0,   46,    0,    0,    0,    0,    0,   92,   78,    0,
   77,   87,    0,    0,    0,   67,    0,   86,   71,   70,
    0,    0,   95,   94,   81,    0,    0,    0,    0,    0,
    0,   76,    0,    0,    0,   85,    0,   83,    0,    0,
    0,    0,   96,   93,    0,    0,    0,   40,    0,    0,
    0,    0,   54,   89,    0,    0,  105,   88,   29,   30,
    0,    0,    0,    0,   45,   53,    0,    0,   44,   91,
   84,   82,    0,    0,    0,    0,   51,   41,   43,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   42,
    0,    0,    0,    0,    0,   25,    0,   28,   27,   26,
   24,
};
final static short yydgoto[] = {                          3,
  195,   13,   14,   15,   16,   51,   17,   18,   19,   20,
   21,   22,   23,   86,  131,   35,  212,   36,   24,  123,
  196,  217,  234,  150,  151,  132,   37,   38,   63,  162,
  143,  133,   76,   57,
};
final static short yysindex[] = {                       -89,
  143,  226,    0,    8,   50,  165,  -11, -208,    0,    0,
  -26,  174,  -43,    0,    0, -196,    0,    0,    0,    0,
    0,    0,    0,    0,  195,   74,   41, -166,    0,   23,
    0,   52, -183,    0,   85,   68,   75,    0,    0,  210,
   48,   31, -124, -124,    0,  104,    0,    0,    0,  -25,
   -5,    0,  158,  318,  110,  133,  140,   96,  -70,   74,
  -29,   68,  154,  113,    0,  -49,    0,    0,    0,    0,
   74,   74,    0,    0,    0,   74,   74,   74,    0,  187,
    0,  336,    0,  -68,   34,  194,    3,    0,  221, -134,
    0,   37,    0,   74,    0,   74,   61,  192,  158,  -59,
   70,   91,   92,  -59,   75,   75,  158,    0,    0,    0,
    0,    7,  102,   98,    8,  132,  -74,  -35,    0,   14,
    0,  101,  325,    0,  383,  158,   74,    0,  132,  338,
    0,  335, -120, -100,  344,  302,  -57,    0,   81,  -23,
    0,   16,  112,    0,    0,    0,    0,  130,  357,  363,
  361,    0,  139,  368,  158,  241,   74,    0,    0,  -59,
    0,    0, -121,   57,   74,    0,  -59,    0,    0,    0,
   52,  352,    0,    0,    0,   18,  218,  148,  153, -134,
  218,    0,  362,  410, -121,    0,  -76,    0,  384, -121,
  -14,   62,    0,    0,  218,  159,  371,    0,  218,    0,
  164,  169,    0,    0, -121, -121,    0,    0,    0,    0,
 -178,  184,  185,  395,    0,    0,  218,  188,    0,    0,
    0,    0,  398,  196,  401,  402,    0,    0,    0,  422,
   66,  428,  433,  208,   52,  437,   52,   52,   52,    0,
  438,   52,  446,  454,  458,    0,  462,    0,    0,    0,
    0,
};
final static short yyrindex[] = {                         0,
   28,   28,    0, -141,    0,   28,    0,    0,    0,    0,
    0,  445,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  445,    0,    0,    0,    0,  -41,
    0,    0,    0,    0,    0,    0,  -10,    0,    0,   53,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   35,    0,   39,  463,    0,    0,    0,    0,    0,    0,
    0,  463,    0,  -34,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  463,    0,
    0,    0,    0,    0,   -3,   21,  -36,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    2,    0,    0,    0,    0,   27,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  464,    0,
    0,    0,    0,    0,   45,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   28,    0,    0,    0,
   28,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -27,    0,    0,    0,   28,  128,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   28,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   26,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
final static short yygindex[] = {                         0,
  136,  122,    0,  256,  -60,    0,    0,    0,    0,   83,
    0,    0,    0,  466,   -9,  107, -138,  307,   43,  -73,
  -96,    0,    0,    0,    0,  176,  315,  314,   10,  -19,
  377,   -2,  411,    0,
};
final static int YYTABLESIZE=517;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         61,
   61,   61,   61,   61,  104,   61,   65,   65,   65,   65,
   65,  101,   65,   44,   90,   48,   60,   61,   61,   61,
   61,   33,  104,  147,   65,   65,   65,   65,   41,  122,
   57,   69,   57,   57,   57,  171,   56,   55,   92,   55,
   55,   55,   47,  117,  211,   47,  149,   27,   57,   57,
   57,   57,    3,  213,  148,   55,   55,   55,   55,  122,
   49,   56,   27,   56,   56,   56,   23,  106,  139,   55,
  107,   42,  224,   64,  174,   50,  194,  119,   65,   56,
   56,   56,   56,  223,  201,   33,   69,   34,   81,   32,
   84,   60,   33,   11,   33,   58,   33,   31,   28,  209,
  210,  137,  218,   32,  141,  237,  200,  145,   34,   34,
   71,   69,   72,   59,   34,   34,   77,  168,   33,  122,
  228,   78,  121,   34,  236,   66,  112,   73,   75,   74,
   34,  164,   85,   46,  159,  159,   12,   25,   61,    9,
   10,   40,   34,  186,  188,  160,   46,  161,  161,   94,
   73,   75,   74,   34,   34,  163,  115,  185,   34,   34,
   34,   46,   88,    5,  190,  204,  129,    1,   48,    7,
  208,   50,  130,   95,  189,   11,   34,    2,   34,  205,
  115,  144,  115,   96,  206,  221,  222,    5,   97,    5,
  129,   98,  116,    7,  102,    7,  130,  115,  159,   11,
   71,   11,   72,  103,    5,    9,   10,  129,  167,   34,
    7,  161,   47,  130,   61,  104,   11,   61,   61,   61,
  146,   65,   34,   61,   65,   65,   65,  110,  104,   43,
   65,   89,   29,   30,  114,  100,   61,   61,   31,   34,
   52,  104,  104,   65,   65,   57,  172,   34,   57,   57,
   57,   91,   55,   34,   57,   55,   55,   55,   34,  115,
  120,   55,  138,  209,  210,   26,    5,   57,   57,  116,
  121,  173,    7,  193,   55,   55,   56,  191,   11,   56,
   56,   56,   23,   69,  128,   56,   83,    9,   10,   23,
   11,  113,   23,  124,   31,   23,   29,   30,   56,   56,
   32,   23,   31,   29,   30,   29,   30,   29,   30,   31,
   80,   31,  159,   31,    9,   10,   46,   34,  127,   34,
   34,   34,  187,   67,   34,  161,   68,   69,   70,   29,
   30,  183,   53,   54,  134,   31,  169,  170,   62,  209,
  210,  241,  118,  243,  244,  245,   67,   82,  247,   68,
   69,   70,  197,  136,  115,  118,  197,  152,   93,  118,
   71,    5,   72,  140,  116,  153,   99,    7,  115,  118,
  214,  142,  118,   11,  197,    5,  111,  157,   71,  175,
   72,    7,  107,  165,  142,  105,  106,   11,  115,  118,
  108,  109,  197,  158,  166,    5,  177,  178,  176,    4,
  125,    7,  126,  179,  180,  181,    5,   11,  182,    6,
  192,  176,    7,    8,  198,  118,    9,   10,   11,  199,
  202,    4,  118,  154,  207,   71,  215,   72,    5,  216,
    4,  219,   39,  155,    7,    8,  220,    5,    9,   10,
   11,   45,  118,    7,    8,  225,  226,    9,   10,   11,
  203,    4,   71,  227,   72,  229,  230,  231,    5,  232,
  233,  235,   52,  184,    7,    8,    4,  238,    9,   10,
   11,   99,  239,    5,    4,  240,  242,   79,  246,    7,
    8,    5,    4,    9,   10,   11,  248,    7,    8,    5,
  130,    9,   10,   11,  249,    7,    8,  115,  250,    9,
   10,   11,  251,   69,    5,  156,  108,   49,  175,   87,
    7,    0,  135,  130,    0,    0,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   42,   43,   44,   45,   41,   47,   41,   42,   43,   44,
   45,   41,   47,   40,   40,   59,   40,   59,   60,   61,
   62,   45,   59,   59,   59,   60,   61,   62,   40,   90,
   41,   59,   43,   44,   45,   59,   27,   41,   44,   43,
   44,   45,   41,   41,   59,   44,  120,   40,   59,   60,
   61,   62,    0,  192,   41,   59,   60,   61,   62,  120,
  257,   41,   40,   43,   44,   45,   41,   41,   62,   27,
   44,  280,  211,  257,   59,  272,   59,   87,  262,   59,
   60,   61,   62,  262,  181,   45,   59,    5,   41,   40,
   60,   40,   45,   59,   45,  262,   45,   59,   91,  278,
  279,  104,  199,   59,  114,   40,  180,  117,   26,   27,
   43,   59,   45,   91,   32,  257,   42,  137,   45,  180,
  217,   47,  257,   41,   59,   41,   84,   60,   61,   62,
  272,  134,  257,   12,  256,  256,    1,    2,   32,  274,
  275,    6,   60,  163,  164,  266,   25,  269,  269,   40,
   60,   61,   62,   71,   72,  256,  257,  160,   76,   77,
   78,   40,   59,  264,  167,  185,  267,  257,   41,  270,
  190,   44,  273,   41,  165,  276,   94,  267,   96,  256,
  257,  256,  257,   44,  187,  205,  206,  264,   93,  264,
  267,  262,  267,  270,   41,  270,  273,  257,  256,  276,
   43,  276,   45,   91,  264,  274,  275,  267,  266,  127,
  270,  269,  256,  273,  256,  265,  276,  259,  260,  261,
  256,  256,  140,  265,  259,  260,  261,   41,  265,  256,
  265,  257,  256,  257,   41,  265,  278,  279,  262,  157,
  268,  278,  279,  278,  279,  256,  140,  165,  259,  260,
  261,  257,  256,  171,  265,  259,  260,  261,  257,  257,
   40,  265,  256,  278,  279,  258,  264,  278,  279,  267,
  257,  256,  270,  256,  278,  279,  256,  171,  276,  259,
  260,  261,  257,  256,   93,  265,  256,  274,  275,  264,
  256,  258,  267,  257,  256,  270,  256,  257,  278,  279,
  256,  276,  262,  256,  257,  256,  257,  256,  257,  262,
  263,  262,  256,  262,  274,  275,  195,  235,  258,  237,
  238,  239,  266,  256,  242,  269,  259,  260,  261,  256,
  257,  156,   26,   27,  265,  262,  256,  257,   32,  278,
  279,  235,   87,  237,  238,  239,  256,   41,  242,  259,
  260,  261,  177,  262,  257,  100,  181,  257,   41,  104,
   43,  264,   45,  262,  267,   41,   60,  270,  257,  114,
  195,  116,  117,  276,  199,  264,   41,   40,   43,  268,
   45,  270,   76,   40,  129,   71,   72,  276,  257,  134,
   77,   78,  217,   59,   93,  264,  267,   41,  143,  257,
   94,  270,   96,   41,   44,  267,  264,  276,   41,  267,
   59,  156,  270,  271,  267,  160,  274,  275,  276,  267,
   59,  257,  167,   41,   41,   43,  268,   45,  264,   59,
  257,  268,  268,  127,  270,  271,  268,  264,  274,  275,
  276,  268,  187,  270,  271,  262,  262,  274,  275,  276,
   41,  257,   43,   59,   45,  268,   59,  262,  264,   59,
   59,   40,  268,  157,  270,  271,  257,   40,  274,  275,
  276,  165,   40,  264,  257,  268,   40,  268,   41,  270,
  271,  264,  257,  274,  275,  276,   41,  270,  271,  264,
  273,  274,  275,  276,   41,  270,  271,  257,   41,  274,
  275,  276,   41,   59,  264,  129,   44,   44,  268,   44,
  270,   -1,  102,  273,   -1,   -1,  276,
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
"programa : ID BEGIN END",
"list_sentencias : list_sentencias sentencia ';'",
"list_sentencias : sentencia ';'",
"list_sentencias : sentencia error",
"sentencia : sentencia_declarativa",
"sentencia : sentencia_ejecutable",
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
"sentencia_control : FOR error encabezado_for ')' bloque_sentencias_ejecutables",
"sentencia_control : FOR '(' encabezado_for bloque_sentencias_ejecutables",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE '(' condicion ')'",
"up_down : UP",
"up_down : DOWN",
"asignacion : ID ASIGNACION expresion",
"asignacion : ID '[' CONSTANTE ']' ASIGNACION expresion",
"tipo : tipo_base",
"tipo : ID",
"tipo_base : ULONGINT",
"tipo_base : SINGLE",
"list_variables : list_variables ',' ID",
"list_variables : list_variables ID",
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
"cuerpo_funcion : list_sentencias sentencia_return ';'",
"cuerpo_funcion : list_sentencias",
"cuerpo_funcion : sentencia_return ';'",
"sentencia_return : RET '(' expresion ')'",
"expresion : expresion '+' termino",
"expresion : expresion '-' termino",
"expresion : termino",
"termino : termino '*' factor",
"termino : termino '/' factor",
"termino : factor",
"factor : ID",
"factor : CONSTANTE",
"factor : invocacion_funcion",
"factor : ID '[' CONSTANTE ']'",
"factor : '-' ID",
"factor : '-' CONSTANTE",
"factor : '-' ID '[' CONSTANTE ']'",
"factor : error",
"declaracion_tipo :",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base '>' ID",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base '>' error",
"declaracion_tipo : TYPEDEF TRIPLE error",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base error",
"invocacion_funcion : ID '(' expresion ')'",
"invocacion_funcion : ID '(' bloque_list_expresiones ')'",
"invocacion_funcion : ID '(' tipo_base '(' expresion ')' ')'",
"fin_if : END_IF",
"fin_if : error",
"bloque_sentencias_ejecutables : sentencia_ejecutable ';'",
"bloque_sentencias_ejecutables : sentencia_ejecutable error",
"bloque_sentencias_ejecutables : BEGIN list_sentencias_ejecutables END",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if ELSE cuerpo_if fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if ELSE error fin_if",
"bloque_if : IF '(' condicion ')' THEN error fin_if",
"bloque_if : IF condicion ')' THEN cuerpo_if fin_if",
"bloque_if : IF '(' condicion THEN cuerpo_if fin_if",
"bloque_if : IF condicion ')' THEN cuerpo_if ELSE cuerpo_if fin_if",
"bloque_if : IF '(' condicion THEN cuerpo_if ELSE cuerpo_if fin_if",
"cuerpo_if : bloque_sentencias_ejecutables",
"cuerpo_if : BEGIN list_sentencias_ejecutables sentencia_return ';' END",
"cuerpo_if : sentencia_return ';'",
"list_sentencias_ejecutables : list_sentencias_ejecutables sentencia_ejecutable ';'",
"list_sentencias_ejecutables : sentencia_ejecutable ';'",
"list_sentencias_ejecutables : sentencia_ejecutable error",
"list_sentencias_ejecutables : list_sentencias_ejecutables sentencia_ejecutable error",
"comparacion : MAYORIGUAL",
"comparacion : MENORIGUAL",
"comparacion : DISTINTO",
"comparacion : '='",
"comparacion : '>'",
"comparacion : '<'",
"comparacion : error",
"condicion : expresion comparacion expresion",
"condicion : '(' bloque_list_expresiones ')' comparacion '(' bloque_list_expresiones ')'",
"bloque_list_expresiones : list_expresiones ',' expresion",
"list_expresiones : list_expresiones ',' expresion",
"list_expresiones : expresion",
"salida_mensaje : OUTF '(' CADENA ')'",
"salida_mensaje : OUTF '(' expresion ')'",
"salida_mensaje : OUTF '(' ')'",
};

//#line 237 "gramatica.y"
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
    if (valor < AccionSemantica.SINGLE_POSITIVE_MIN || valor >= Float.POSITIVE_INFINITY) {
        yyerror("Constante flotante fuera de rango");
    }
}

//#line 524 "Parser.java"
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
{yyerror("Programa vacío");}
break;
case 8:
//#line 21 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
//#line 30 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
break;
case 12:
//#line 31 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 13:
//#line 32 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
//#line 37 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 20:
//#line 46 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 21:
//#line 47 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 22:
//#line 48 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
//#line 52 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 24:
//#line 53 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 25:
//#line 54 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 26:
//#line 55 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 27:
//#line 56 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 28:
//#line 57 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 31:
//#line 66 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 32:
//#line 67 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion ");}
break;
case 38:
//#line 82 "gramatica.y"
{yyerror("Las variables deben estar separados por coma");}
break;
case 40:
//#line 87 "gramatica.y"
{inFunction = true; hasReturn = false;}
break;
case 41:
//#line 87 "gramatica.y"
{ if (!hasReturn) {
                                                                                                 	yyerror("Falta sentencia RET en la función");
                                                                                                 }
                                                                                                 inFunction = false;
                                                                                                 }
break;
case 43:
//#line 92 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");}
break;
case 44:
//#line 93 "gramatica.y"
{yyerror("La funcione debe tener nombre");}
break;
case 45:
//#line 94 "gramatica.y"
{yyerror("La función debe tener parámetro");}
break;
case 47:
//#line 99 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 54:
//#line 117 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 62:
//#line 138 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 63:
//#line 145 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 65:
//#line 147 "gramatica.y"
{}
break;
case 66:
//#line 148 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(1).sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 67:
//#line 152 "gramatica.y"
{}
break;
case 68:
//#line 153 "gramatica.y"
{yyerror("Falta operando en la expresión");}
break;
case 71:
//#line 158 "gramatica.y"
{yyerror("Falta ID al final de la declaracion");}
break;
case 72:
//#line 159 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion");}
break;
case 73:
//#line 160 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion");}
break;
case 75:
//#line 165 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 76:
//#line 166 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 78:
//#line 171 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 80:
//#line 176 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 82:
//#line 181 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 83:
//#line 182 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 84:
//#line 183 "gramatica.y"
{yyerror("Falta contenido en el bloque ELSE");}
break;
case 85:
//#line 184 "gramatica.y"
{yyerror("Falta contenido en el bloque THEN");}
break;
case 86:
//#line 185 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 87:
//#line 186 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 88:
//#line 187 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 89:
//#line 188 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 95:
//#line 201 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 96:
//#line 202 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 103:
//#line 212 "gramatica.y"
{yyerror("Falta comparador en la comparación");}
break;
case 109:
//#line 231 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 110:
//#line 232 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 111:
//#line 233 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 914 "Parser.java"
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
