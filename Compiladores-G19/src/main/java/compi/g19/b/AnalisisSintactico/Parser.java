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
   13,   13,   14,   14,   16,   16,   16,   16,   17,   17,
   17,   17,   17,   19,   19,    9,    9,    5,    5,   21,
   21,    6,    6,    6,   24,   25,    7,    7,    7,    7,
   22,   22,   26,   27,   27,   23,   23,   23,   28,   20,
   20,   20,   29,   29,   29,   30,   30,   30,   30,   30,
   30,   30,   30,    8,    8,    8,    8,    8,   10,   10,
   10,   10,   32,   32,   15,   15,   15,   11,   11,   11,
   11,   11,   11,   11,   11,   34,   34,   34,   33,   33,
   35,   35,   35,   35,   35,   35,   35,   18,   18,   31,
   36,   36,   12,   12,   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    3,    3,    3,    2,    2,    1,    1,
    2,    1,    1,    1,    1,    1,    1,    1,    5,    5,
    4,    4,    1,    1,    8,    7,    7,    7,   12,   11,
   11,   11,   11,    1,    1,    3,    6,    1,    1,    1,
    1,    3,    2,    1,    0,    0,   11,    9,    8,    8,
    2,    1,    3,    1,    3,    3,    1,    2,    4,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    4,    2,
    2,    5,    1,    0,    6,    6,    5,    5,    4,    4,
    3,    7,    1,    1,    2,    2,    3,    9,    7,    9,
    7,    6,    6,    8,    8,    1,    5,    2,    3,    2,
    1,    1,    1,    1,    1,    1,    1,    3,    7,    3,
    3,    1,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,   40,   41,
    0,    0,    0,    9,   10,    0,   12,   13,   14,   15,
   16,   17,   18,   38,    0,    0,    0,    0,   73,    0,
   67,    0,    0,   68,    0,    0,    0,   65,    5,    0,
    0,    0,    0,    0,    0,   23,   24,    4,    0,    8,
    7,   44,    0,    0,    2,    0,   81,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   71,    0,
  107,  101,  102,  103,    0,    0,  106,  105,  104,    0,
    0,    0,    1,    0,  115,    0,    0,    0,    0,    0,
    0,    6,    0,    0,   43,    0,   79,    0,   80,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   63,   64,  113,  114,    0,    0,    0,    0,    0,
    0,    0,   22,   21,    0,    0,    0,    0,   42,    0,
    0,    0,   69,    0,    0,   96,    0,    0,    0,    0,
    0,    0,   78,    0,   77,    0,    0,    0,    0,   20,
   19,   86,   85,    0,    0,    0,    0,   51,    0,    0,
    0,    0,    0,   98,   84,    0,   83,   93,    0,    0,
    0,   72,    0,   92,   76,   75,    0,    0,  100,   87,
    0,    0,    0,    0,    0,    0,   82,    0,    0,    0,
   91,    0,   89,    0,    0,   34,   35,    0,    0,    0,
   99,    0,    0,    0,   45,    0,    0,    0,    0,   59,
   95,    0,    0,  109,   94,    0,    0,    0,    0,    0,
   50,   58,    0,    0,   49,   97,   90,   88,    0,    0,
    0,    0,   56,   46,   48,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   47,   30,    0,   33,
   32,   31,   29,
};
final static short yydgoto[] = {                          3,
  202,   13,   14,   15,   16,   54,   17,   18,   19,   20,
   21,   22,   23,   45,  136,   46,   47,   35,  199,   36,
   24,  128,  203,  223,  241,  156,  157,  137,   37,   38,
   67,  168,  149,  138,   80,   61,
};
final static short yysindex[] = {                       -50,
  142,  237,    0,    6,   85,  169,   38, -252,    0,    0,
  -30,  184,  -45,    0,    0, -204,    0,    0,    0,    0,
    0,    0,    0,    0,  205,  -44,   71, -202,    0,   58,
    0,   92, -155,    0,   59,   99,  268,    0,    0,  214,
   73,  -15, -123, -109,  111,    0,    0,    0,  115,    0,
    0,    0,  -27,   -6,    0,  318,    0,  342,  155,  175,
  178,  148,  -17,  -44,  -37,   99,  213,  193,    0,   32,
    0,    0,    0,    0,  -44,  -44,    0,    0,    0,  -44,
  -44,  -44,    0,  283,    0,  420,   78,  272,   82,    1,
  -66,    0,  300,   37,    0,  100,    0,  -44,    0,  -44,
  104,  271,  318,  -70,  109,  117,  107,  -70,  268,  268,
  318,    0,    0,    0,    0,  -11,  122,   75,    6, -131,
  -94,  -42,    0,    0,  -38,    0,  129,  350,    0,  429,
  318,  -44,    0, -131,  353,    0,  335,   52,  -71,  362,
  312,  134,    0,  -76,    0,   92,  348,  349,  253,    0,
    0,    0,    0,  144,  373,  379,  377,    0,  156,  386,
  318,  252,  -44,    0,    0,  -70,    0,    0, -170,  163,
  -44,    0,  -70,    0,    0,    0,  -16,    9,    0,    0,
  369,  229,  164,  167,   37,  229,    0,  371,  489, -170,
    0,  125,    0,  394, -170,    0,    0, -122,  174,  185,
    0,  229,  182,  387,    0,  229,    0,  183,  189,    0,
    0, -170, -170,    0,    0,  405,  204,  408,  418,  424,
    0,    0,  229,  223,    0,    0,    0,    0,  413,  110,
  452,  456,    0,    0,    0,   92,  457,   92,   92,   92,
  230,  465,   92,  473,  474,  477,    0,    0,  478,    0,
    0,    0,    0,
};
final static short yyrindex[] = {                         0,
  -41,  -41,    0, -129,    0,  -41,    0,    0,    0,    0,
    0,  467,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  467,    0,    0,    0,    0,  -36,
    0,    0,    0,    0,    0,    0,   -4,    0,    0,   15,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   13,    0,   14,    0,  480,    0,    0,
    0,    0,    0,    0,    0,  480,    0,  -12,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  480,    0,    0,    0,    0,    0,   20,   44,
  -39,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -25,    0,    0,    0,    0,
   67,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  483,    0,    0,    0,    0,    0,
   35,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -41,    0,    0,    0,  -41,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -47,    0,    0,    0,  -41,  124,    0,    0,    0,
    0,    0,    0,    0,    0,   25,    0,   26,   49,    0,
    0,    0,  -41,    0,    0,    0,    0,    0,    0,   50,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
final static short yygindex[] = {                         0,
  337,   84,    0,  276,   -2,    0,    0,    0,    0,   -5,
    0,    0,    0,  487,   63,    0,    0,  132, -144,  324,
   42,  -63,  -85,    0,    0,    0,    0,  -31,  133,  191,
   17,  -23,  399,  -56,  430,    0,
};
final static int YYTABLESIZE=536;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         34,
   33,  108,  154,  105,   66,   66,   66,   66,   66,   44,
   66,   74,   94,   51,    3,   52,  153,   74,   52,  108,
   34,   34,   66,   66,   66,   66,   34,   42,   70,   70,
   70,   70,   70,  200,   70,   34,   62,   96,   62,   62,
   62,  121,  198,   60,   87,   27,   70,   70,   70,   70,
  144,  142,   52,  217,   62,   62,   62,   62,   34,   62,
   60,  155,   60,   60,   60,   26,   28,   53,   59,   34,
   34,   11,   36,   74,   34,   34,   34,   41,   60,   60,
   60,   60,  170,   88,   61,  165,   61,   61,   61,   27,
   25,  127,   34,   37,   34,   49,   28,   27,  167,   70,
  208,   68,   61,   61,   61,   61,   69,  110,   49,  190,
  111,   57,   34,   85,   64,   33,  195,   33,  174,   33,
  224,  207,  127,   49,   32,  119,   34,   39,  116,   33,
  188,   64,    5,  146,   89,  213,   33,  234,    7,  216,
   34,   75,   39,   76,   11,  191,  193,   43,   63,  238,
  204,   91,  123,  124,  204,  196,  197,   34,   77,   79,
   78,  150,  119,   65,   53,   34,  211,   55,  237,    5,
  220,  215,  120,   92,  204,    7,   77,   79,   78,  175,
  176,   11,  127,  151,  169,  119,  119,  194,  227,  228,
  119,  204,    5,    5,   98,  134,  134,    5,    7,    7,
  120,  135,  135,    7,   11,   11,    1,  109,  110,   11,
   50,   29,   30,  152,   74,   99,    2,   31,  126,   66,
   57,  100,   66,   66,   66,  108,   43,  104,   66,   93,
   34,   39,   34,   34,   34,    9,   10,   34,  108,  108,
  101,   66,   66,   70,  102,  143,   70,   70,   70,  147,
   95,   62,   70,  106,   62,   62,   62,  119,    9,   10,
   62,  196,  197,   26,    5,   70,   70,  120,   11,   36,
    7,  112,  113,   62,   62,   60,   11,  177,   60,   60,
   60,   26,   28,  107,   60,   49,  196,  197,   26,   28,
   37,   26,   28,  126,   26,   28,  108,   60,   60,   61,
   26,   28,   61,   61,   61,   27,   25,  165,   61,   81,
    9,   10,   27,   25,   82,   27,   25,  166,   27,   25,
  167,   61,   61,  114,   27,   25,   29,   30,   29,   30,
   29,   30,   31,  117,   31,   84,   31,   12,   25,  125,
   29,   30,   40,  118,    9,   10,   31,   29,   30,   56,
   58,    9,   10,   31,   71,   66,  129,   72,   73,   74,
   75,  132,   76,  133,   86,  122,  122,  242,  141,  244,
  245,  246,   71,  139,  249,   72,   73,   74,  145,  122,
  212,  119,   97,  122,   75,  158,   76,  103,    5,  165,
  159,  134,  163,  164,    7,  148,  122,  135,    4,  173,
   11,  171,  167,  111,  172,    5,  178,  179,    6,  148,
  182,    7,    8,  183,  122,    9,   10,   11,  165,  184,
  185,  130,  186,  131,  181,    4,  187,  201,  192,  209,
  205,  167,    5,  206,  214,  218,   39,  181,    7,    8,
    4,  122,    9,   10,   11,  222,  219,    5,  122,  221,
  225,   48,  236,    7,    8,  161,  226,    9,   10,   11,
  115,    4,   75,  229,   76,  230,  231,  122,    5,  160,
    4,   75,   55,   76,    7,    8,  232,    5,    9,   10,
   11,   83,  233,    7,    8,    4,  189,    9,   10,   11,
  235,  239,    5,    4,  103,  240,  243,  247,    7,    8,
    5,  135,    9,   10,   11,  248,    7,    8,  119,  119,
    9,   10,   11,  250,  251,    5,    5,  252,  253,  180,
  180,    7,    7,  112,  135,   74,   54,   11,   11,  210,
   90,   75,  162,   76,    0,  140,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          5,
   45,   41,   41,   41,   41,   42,   43,   44,   45,   40,
   47,   59,   40,   59,    0,   41,   59,   59,   44,   59,
   26,   27,   59,   60,   61,   62,   32,  280,   41,   42,
   43,   44,   45,  178,   47,   41,   41,   44,   43,   44,
   45,   41,   59,   27,   60,   40,   59,   60,   61,   62,
   62,  108,  257,  198,   59,   60,   61,   62,   64,  262,
   41,  125,   43,   44,   45,   41,   41,  272,   27,   75,
   76,   59,   59,   59,   80,   81,   82,   40,   59,   60,
   61,   62,  139,   42,   41,  256,   43,   44,   45,   41,
   41,   94,   98,   59,  100,   12,   91,   40,  269,   41,
  186,  257,   59,   60,   61,   62,  262,   41,   25,  166,
   44,   41,  118,   41,   40,   45,  173,   45,  142,   45,
  206,  185,  125,   40,   40,  257,  132,  257,   87,   45,
  162,   40,  264,   59,  258,  192,   45,  223,  270,  262,
  146,   43,  272,   45,  276,  169,  170,  257,   91,   40,
  182,   41,   90,   91,  186,  278,  279,  163,   60,   61,
   62,  256,  257,   32,   41,  171,  190,   44,   59,  264,
  202,  195,  267,   59,  206,  270,   60,   61,   62,  256,
  257,  276,  185,  121,  256,  257,  257,  171,  212,  213,
  257,  223,  264,  264,   40,  267,  267,  264,  270,  270,
  267,  273,  273,  270,  276,  276,  257,   75,   76,  276,
  256,  256,  257,  256,  256,   41,  267,  262,  257,  256,
  268,   44,  259,  260,  261,  265,  257,  265,  265,  257,
  236,  257,  238,  239,  240,  274,  275,  243,  278,  279,
   93,  278,  279,  256,  262,  257,  259,  260,  261,  118,
  257,  256,  265,   41,  259,  260,  261,  257,  274,  275,
  265,  278,  279,  258,  264,  278,  279,  267,  256,  256,
  270,   81,   82,  278,  279,  256,  276,  146,  259,  260,
  261,  257,  257,   91,  265,  202,  278,  279,  264,  264,
  256,  267,  267,  257,  270,  270,  265,  278,  279,  256,
  276,  276,  259,  260,  261,  257,  257,  256,  265,   42,
  274,  275,  264,  264,   47,  267,  267,  266,  270,  270,
  269,  278,  279,   41,  276,  276,  256,  257,  256,  257,
  256,  257,  262,   62,  262,  263,  262,    1,    2,   40,
  256,  257,    6,  262,  274,  275,  262,  256,  257,   26,
   27,  274,  275,  262,  256,   32,  257,  259,  260,  261,
   43,  258,   45,   93,   41,   90,   91,  236,  262,  238,
  239,  240,  256,  265,  243,  259,  260,  261,  257,  104,
  256,  257,   41,  108,   43,  257,   45,   64,  264,  256,
   41,  267,   40,   59,  270,  120,  121,  273,  257,  266,
  276,   40,  269,   80,   93,  264,   59,   59,  267,  134,
  267,  270,  271,   41,  139,  274,  275,  276,  256,   41,
   44,   98,  267,  100,  149,  257,   41,   59,  266,   59,
  267,  269,  264,  267,   41,  262,  268,  162,  270,  271,
  257,  166,  274,  275,  276,   59,  262,  264,  173,  268,
  268,  268,   40,  270,  271,  132,  268,  274,  275,  276,
   41,  257,   43,   59,   45,  262,   59,  192,  264,   41,
  257,   43,  268,   45,  270,  271,   59,  264,  274,  275,
  276,  268,   59,  270,  271,  257,  163,  274,  275,  276,
  268,   40,  264,  257,  171,   40,   40,  268,  270,  271,
  264,  273,  274,  275,  276,   41,  270,  271,  257,  257,
  274,  275,  276,   41,   41,  264,  264,   41,   41,  268,
  268,  270,  270,   44,  273,   59,   44,  276,  276,   41,
   44,   43,  134,   45,   -1,  106,
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
"sentencia_control : FOR encabezado_for ')' bloque_sentencias_ejecutables",
"sentencia_control : FOR '(' encabezado_for bloque_sentencias_ejecutables",
"encabezado_for : encabezado_for1",
"encabezado_for : encabezado_for2",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE '(' condicion ')'",
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
"declaracion_tipo : TYPEDEF TRIPLE tipo_base '>' ID",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base ID",
"invocacion_funcion : ID '(' expresion ')'",
"invocacion_funcion : ID '(' bloque_list_expresiones ')'",
"invocacion_funcion : ID '(' ')'",
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

//#line 246 "gramatica.y"
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

//#line 532 "Parser.java"
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
case 14:
//#line 36 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
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
case 25:
//#line 57 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR de 3");}
break;
case 26:
//#line 58 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 27:
//#line 59 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 28:
//#line 60 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 29:
//#line 64 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR con condicion");}
break;
case 30:
//#line 65 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 31:
//#line 66 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 32:
//#line 67 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 33:
//#line 68 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 43:
//#line 93 "gramatica.y"
{yyerror("Las variables deben estar separados por coma");}
break;
case 45:
//#line 98 "gramatica.y"
{inFunction = true; hasReturn = false;}
break;
case 46:
//#line 98 "gramatica.y"
{ if (!hasReturn) {
                                                                                                 	yyerror("Falta sentencia RET en la función");
                                                                                                 }
                                                                                                 inFunction = false;
                                                                                                 }
break;
case 48:
//#line 103 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");}
break;
case 49:
//#line 104 "gramatica.y"
{yyerror("La funcione debe tener nombre");}
break;
case 50:
//#line 105 "gramatica.y"
{yyerror("La función debe tener parámetro");}
break;
case 52:
//#line 110 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 59:
//#line 128 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 67:
//#line 149 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 68:
//#line 156 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 71:
//#line 159 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(1).sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 72:
//#line 163 "gramatica.y"
{}
break;
case 73:
//#line 164 "gramatica.y"
{yyerror("Falta termino en la expresion");}
break;
case 76:
//#line 169 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 77:
//#line 170 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 78:
//#line 171 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 80:
//#line 176 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 81:
//#line 177 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 82:
//#line 178 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 84:
//#line 183 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 86:
//#line 188 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 88:
//#line 193 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 89:
//#line 194 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 90:
//#line 195 "gramatica.y"
{yyerror("Falta contenido en el bloque ELSE");}
break;
case 91:
//#line 196 "gramatica.y"
{yyerror("Falta contenido en el bloque THEN");}
break;
case 92:
//#line 197 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 93:
//#line 198 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 94:
//#line 199 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 95:
//#line 200 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 107:
//#line 221 "gramatica.y"
{yyerror("Falta comparador en la comparación");}
break;
case 109:
//#line 226 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
break;
case 110:
//#line 231 "gramatica.y"
{}
break;
case 113:
//#line 240 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 114:
//#line 241 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 115:
//#line 242 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 930 "Parser.java"
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
