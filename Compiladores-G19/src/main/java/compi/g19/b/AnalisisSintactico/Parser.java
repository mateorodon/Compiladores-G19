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
   13,   13,   13,   14,   14,   16,   16,   16,   16,   17,
   17,   17,   17,   17,   19,   19,    9,    9,    9,    5,
    5,   21,   21,    6,    6,   24,   25,    7,    7,    7,
    7,   22,   22,   26,   27,   27,   23,   23,   23,   28,
   28,   29,   20,   20,   20,   20,   20,   30,   30,   30,
   30,   30,   31,   31,   31,   31,   31,   31,   31,    8,
    8,    8,    8,   10,   10,   10,   10,   33,   33,   15,
   15,   15,   11,   11,   11,   11,   11,   11,   35,   35,
   36,   36,   36,   36,   34,   34,   37,   37,   37,   37,
   37,   37,   18,   18,   18,   32,   38,   38,   38,   12,
   12,   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    3,    2,    2,    1,    2,    2,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    5,
    5,    4,    4,    1,    1,    8,    7,    7,    7,   12,
   11,   11,   11,   11,    1,    1,    3,    6,    3,    1,
    1,    1,    1,    3,    1,    0,    0,   11,    9,    8,
    8,    2,    1,    3,    1,    3,    3,    1,    2,    2,
    1,    4,    3,    3,    1,    3,    3,    3,    3,    1,
    3,    3,    1,    1,    1,    4,    2,    2,    5,    6,
    6,    5,    5,    4,    4,    3,    7,    1,    1,    2,
    2,    3,    7,    7,    9,    9,    9,    9,    2,    2,
    3,    2,    2,    1,    3,    2,    1,    1,    1,    1,
    1,    1,    3,    7,    1,    3,    3,    1,    1,    4,
    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,   42,   43,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   40,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   24,   25,    4,    6,    8,
    9,   45,    0,    0,    2,   39,    0,   74,    0,   75,
    0,    0,   70,  119,   86,    0,    0,    0,    0,    0,
  115,    0,    0,    0,    1,    0,  122,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   78,    0,
    0,    0,    0,   84,    0,   85,    0,    0,    0,    0,
    0,  107,  108,  109,  112,  111,  110,    0,  120,  121,
    0,    0,    0,    0,    0,    0,    0,   23,   22,    0,
    0,    0,    0,   44,    0,    0,   66,    0,   67,    0,
   71,   68,   72,   69,    0,    0,    0,    0,    0,    0,
   83,    0,   82,    0,    0,    0,    0,   21,   20,   91,
   90,    0,    0,    0,    0,   52,    0,   76,    0,    0,
    0,    0,  104,    0,    0,    0,    0,    0,    0,    0,
   81,   80,    0,    0,  106,   92,    0,    0,    0,    0,
    0,    0,   79,   87,    0,  102,    0,    0,    0,  100,
  103,   89,    0,   88,   93,    0,   94,   35,   36,    0,
    0,    0,  105,   61,    0,    0,    0,   46,    0,    0,
    0,    0,  101,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   51,   60,    0,   59,    0,    0,   50,  114,
   62,   95,   97,   98,   96,    0,    0,    0,    0,   57,
   47,   49,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   48,   31,    0,   34,   33,   32,   30,
};
final static short yydgoto[] = {                          3,
   12,  194,   14,   15,   16,   44,   17,   18,   19,   20,
   21,   22,   23,   35,  108,   36,   37,   63,  191,   64,
   24,  113,  195,  217,  238,  144,  145,  196,  197,   52,
   53,   58,  185,  158,  159,  160,   98,   59,
};
final static short yysindex[] = {                      -230,
  310,  371,    0,  -26,   -2,  371,    7, -226,    0,    0,
  -28,  326,    0,   32,   71, -216,    0,    0,    0,    0,
    0,    0,    0,    0,  335,   59,  107, -116,   35,  355,
  -10,   85, -104,  -97,  134,    0,    0,    0,    0,    0,
    0,    0,  -16,  118,    0,    0,  -17,    0, -229,    0,
   70,   56,    0,    0,    0,   84,  152,  144,  151,  106,
    0,   83,  164,  127,    0,  176,    0,  110, -245,  161,
    2,  -37,  -93,  204, -217,   13,   16,  192,    0,  166,
  168,  214,  218,    0,   -6,    0,   -6,   30,   70,  253,
   37,    0,    0,    0,    0,    0,    0,   -6,    0,    0,
  -51,   50,  -38,  -26,  312,  295,  -56,    0,    0,   -7,
    0,   55,  277,    0,  233,   69,    0,   56,    0,   56,
    0,    0,    0,    0,  169,   70,   -6,  -52,  272,   70,
    0, -157,    0,   35,  276,  279,  387,    0,    0,    0,
    0,   75,  309,  314,  292,    0,   95,    0,  273,  333,
   70,  339,    0,  243,  340,  324,  325,  403, -119,  -87,
    0,    0,  -53,  -88,    0,    0,  331,  363,  126,  131,
 -217,  363,    0,    0,   83,    0,  404,   -6,    0,    0,
    0,    0,  272,    0,    0,  272,    0,    0,    0, -156,
  142,  146,    0,    0,  138,  363,  351,    0,  363,    0,
  158,  388,    0,  360, -125, -125, -125, -125,  373,  179,
  381,  384,    0,    0,  385,    0,  363,  177,    0,    0,
    0,    0,    0,    0,    0,  407,  -23,  419,  422,    0,
    0,    0,   35,  425,   35,   35,   35,  210,  438,   35,
  440,  445,  447,    0,    0,  448,    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -176,    0,    0,    0,    0,    0,    0,
    0,  487,    0,  178,  193,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  493,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  163,    0,    0,    1,    0,    0,    0,
  121,   49,    0,    0,    0,  453,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   25,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  453,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    9,    0,    0,    0,    0,    0,    0,   73,    0,   97,
    0,    0,    0,    0,    0,  132,    0,    0,    0,  -41,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  454,    0,    0,    0,    0,    0,    0,    0,
  143,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  226,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  235,    0,    0,    0,  140,
    0,    0,    0,    0,    0,    0,    0,    0,  -36,    0,
  -22,  -21,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  145,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   99,   77,    0,  412,  -59,    0,    0,    0,    0,  429,
    0,    0,    0,  467,  -18,    0,    0,  -39, -138,  446,
   92,  -95, -140,    0,    0,    0,    0,    0,  -47,  123,
  133,  -49,  -40,  -83,  104,  128,  376,    0,
};
final static int YYTABLESIZE=680;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        113,
   73,   62,  141,  106,   27,  190,   49,   95,   97,   96,
  132,   34,   90,   27,  143,  112,  235,  113,   29,   28,
  134,  137,   27,   75,   77,  192,    1,   78,    9,   10,
   67,  201,   79,  142,   49,  234,    2,   29,   49,  111,
   42,   73,   73,   73,   73,   73,   31,   73,   65,   53,
  112,  210,   53,   32,  109,   43,    9,   10,  218,   73,
   73,   73,   73,  135,   28,   77,   77,   77,   77,   77,
  177,   77,   63,   77,   62,  200,  231,   13,   13,   49,
   41,  157,   13,   77,   77,   77,   77,  139,   39,   65,
   40,   65,   65,   65,  163,   41,   64,   82,  161,  162,
   25,   39,   83,   49,   30,  209,   39,   65,   65,   65,
   65,  112,   80,   63,   81,   63,   63,   63,   57,  187,
   37,  188,  189,   70,   84,  202,   80,   49,   81,   41,
  182,   63,   63,   63,   63,  157,  182,   64,  157,   64,
   64,   64,   38,  184,   69,   60,  183,   55,  215,  184,
  100,   49,   80,   71,   81,   64,   64,   64,   64,   33,
  101,   76,   12,  104,  222,  223,  224,  225,  182,   80,
    5,   81,  116,  105,   73,  117,    7,   11,  186,   37,
   54,  184,   11,   56,   86,   26,   95,   97,   96,  188,
  189,   85,   10,  239,   87,  241,  242,  243,   88,  140,
  246,   38,  118,  120,   91,  131,   92,   93,   94,  150,
   49,   80,   49,   81,  122,  124,   99,   61,   47,  104,
   27,   12,  102,   48,  188,  189,    5,   27,   33,  105,
   27,   26,    7,   27,   29,   28,  113,  113,   11,   27,
   74,   29,   28,  110,   29,   28,   47,   29,   28,  111,
   47,   48,   66,   29,   28,   48,   73,   73,   49,   73,
   73,   73,   49,  103,   73,   41,    9,   10,   73,  114,
   73,   73,  214,   73,   73,   73,   73,  115,   73,   73,
   77,   77,  116,   77,   77,   77,  205,  127,   77,  207,
   61,   47,   77,  128,   77,   77,   48,   77,   77,   77,
   77,  129,   77,   77,   65,   65,  133,   65,   65,   65,
  206,  146,   65,  208,   46,   47,   65,  147,   65,   65,
   48,   65,   65,   65,   65,  148,   65,   65,   63,   63,
  149,   63,   63,   63,  164,  171,   63,  165,   54,   47,
   63,  168,   63,   63,   48,   63,   63,   63,   63,  169,
   63,   63,   64,   64,  170,   64,   64,   64,    9,   10,
   64,  172,   54,   47,   64,  173,   64,   64,   48,   64,
   64,   64,   64,  174,   64,   64,   37,   37,  175,  178,
    9,   10,  179,  180,   37,   92,   93,   94,   37,  193,
   37,   37,  198,   37,   37,   37,   37,  199,   38,   38,
  221,   26,   80,  211,   81,  213,   38,  212,   26,  216,
   38,   26,   38,   38,   26,   38,   38,   38,   38,   12,
   26,  117,   47,  119,   47,  219,   12,   48,  220,   48,
   12,  226,   12,   12,   11,   12,   12,   12,   12,  228,
  227,   11,  229,  230,  232,   11,  233,   11,   11,   10,
   11,   11,   11,   11,   50,   50,   10,   50,  236,   50,
   10,  237,   10,   10,  240,   10,   10,   10,   10,  121,
   47,   51,   56,  123,   47,   48,   68,  244,  245,   48,
  247,   99,  106,  107,  107,  248,    5,  249,  250,  106,
   50,   99,    3,  106,   99,  106,  118,   55,  176,  104,
   72,  106,   58,  152,    0,    0,    5,   89,   50,   50,
   50,   50,    7,   50,    0,   50,  136,  107,   11,    0,
    0,    0,    0,    0,    0,    0,   50,  153,  104,    0,
  125,   50,  126,    0,    0,    5,    0,    0,  154,    0,
  156,    7,    0,  130,  155,    0,    0,   11,  167,    0,
  138,  104,    0,    0,    0,   50,    0,    0,    5,    0,
    0,  105,   50,    0,    7,  136,    4,    0,  104,  167,
   11,    0,  151,    5,    0,    5,    6,    0,    0,    7,
    8,    7,    4,    9,   10,   11,    0,   11,  167,    5,
    0,    4,    0,   38,  156,    7,    8,  156,    5,    9,
   10,   11,   45,   50,    7,    8,   50,    0,    9,   10,
   11,    4,    0,    0,    0,    0,    0,    0,    5,    4,
   89,    0,   65,  204,    7,    8,    5,    4,    9,   10,
   11,    0,    7,    8,    5,  155,    9,   10,   11,    0,
    7,    8,    0,  104,    9,   10,   11,    0,    0,    0,
    5,    0,    0,    0,  166,    0,    7,    0,    0,  104,
  104,   50,   11,   50,   50,   50,    5,    5,   50,    0,
  181,  203,    7,    7,    0,    0,    0,    0,   11,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   40,   59,   41,   41,   59,   45,   60,   61,   62,
   62,   40,   62,   40,  110,   75,   40,   59,   41,   41,
   59,  105,   40,   40,    0,  164,  257,  257,  274,  275,
   41,  172,  262,   41,   45,   59,  267,   40,   45,  257,
  257,   41,   42,   43,   44,   45,   40,   47,    0,   41,
  110,  190,   44,  280,   73,  272,  274,  275,  199,   59,
   60,   61,   62,  103,   91,   41,   42,   43,   44,   45,
  154,   47,    0,   91,   40,  171,  217,    1,    2,   45,
  257,  129,    6,   59,   60,   61,   62,  106,   12,   41,
   59,   43,   44,   45,  134,  272,    0,   42,  256,  257,
    2,   25,   47,   45,    6,  262,   30,   59,   60,   61,
   62,  171,   43,   41,   45,   43,   44,   45,   27,  160,
    0,  278,  279,   32,   41,  175,   43,   45,   45,   59,
  256,   59,   60,   61,   62,  183,  256,   41,  186,   43,
   44,   45,    0,  269,   60,  262,  266,   41,  196,  269,
   41,   45,   43,  258,   45,   59,   60,   61,   62,  257,
   69,   44,    0,  257,  205,  206,  207,  208,  256,   43,
  264,   45,   41,  267,   41,   44,  270,    0,  266,   59,
   41,  269,  276,   44,   41,   41,   60,   61,   62,  278,
  279,   40,    0,  233,   44,  235,  236,  237,   93,  256,
  240,   59,   80,   81,   41,  257,  259,  260,  261,   41,
   45,   43,   45,   45,   82,   83,   41,  256,  257,  257,
  257,   59,   62,  262,  278,  279,  264,  264,  257,  267,
  267,  258,  270,  270,  257,  257,  278,  279,  276,  276,
  257,  264,  264,   40,  267,  267,  257,  270,  270,  257,
  257,  262,  263,  276,  276,  262,  256,  257,   45,  259,
  260,  261,   45,  262,  264,  257,  274,  275,  268,  257,
  270,  271,  196,  273,  274,  275,  276,  262,  278,  279,
  256,  257,   91,  259,  260,  261,  183,  258,  264,  186,
  256,  257,  268,   41,  270,  271,  262,  273,  274,  275,
  276,  265,  278,  279,  256,  257,  257,  259,  260,  261,
  183,  257,  264,  186,  256,  257,  268,   41,  270,  271,
  262,  273,  274,  275,  276,   93,  278,  279,  256,  257,
  262,  259,  260,  261,   59,   44,  264,   59,  256,  257,
  268,  267,  270,  271,  262,  273,  274,  275,  276,   41,
  278,  279,  256,  257,   41,  259,  260,  261,  274,  275,
  264,  267,  256,  257,  268,   93,  270,  271,  262,  273,
  274,  275,  276,   41,  278,  279,  256,  257,   40,   40,
  274,  275,   59,   59,  264,  259,  260,  261,  268,   59,
  270,  271,  267,  273,  274,  275,  276,  267,  256,  257,
   41,  257,   43,  262,   45,  268,  264,  262,  264,   59,
  268,  267,  270,  271,  270,  273,  274,  275,  276,  257,
  276,  256,  257,  256,  257,  268,  264,  262,   41,  262,
  268,   59,  270,  271,  257,  273,  274,  275,  276,   59,
  262,  264,   59,   59,  268,  268,   40,  270,  271,  257,
  273,  274,  275,  276,   26,   27,  264,   29,   40,   31,
  268,   40,  270,  271,   40,  273,  274,  275,  276,  256,
  257,   26,   27,  256,  257,  262,   31,  268,   41,  262,
   41,  256,  257,   72,   73,   41,    0,   41,   41,  264,
   62,  266,    0,  268,  269,  270,   44,   44,  256,  257,
   34,  276,  268,  128,   -1,   -1,  264,   62,   80,   81,
   82,   83,  270,   85,   -1,   87,  105,  106,  276,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   98,  256,  257,   -1,
   85,  103,   87,   -1,   -1,  264,   -1,   -1,  267,   -1,
  129,  270,   -1,   98,  273,   -1,   -1,  276,  137,   -1,
  256,  257,   -1,   -1,   -1,  127,   -1,   -1,  264,   -1,
   -1,  267,  134,   -1,  270,  154,  257,   -1,  257,  158,
  276,   -1,  127,  264,   -1,  264,  267,   -1,   -1,  270,
  271,  270,  257,  274,  275,  276,   -1,  276,  177,  264,
   -1,  257,   -1,  268,  183,  270,  271,  186,  264,  274,
  275,  276,  268,  175,  270,  271,  178,   -1,  274,  275,
  276,  257,   -1,   -1,   -1,   -1,   -1,   -1,  264,  257,
  175,   -1,  268,  178,  270,  271,  264,  257,  274,  275,
  276,   -1,  270,  271,  264,  273,  274,  275,  276,   -1,
  270,  271,   -1,  257,  274,  275,  276,   -1,   -1,   -1,
  264,   -1,   -1,   -1,  268,   -1,  270,   -1,   -1,  257,
  257,  233,  276,  235,  236,  237,  264,  264,  240,   -1,
  268,  268,  270,  270,   -1,   -1,   -1,   -1,  276,  276,
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
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE '(' condicion ')'",
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
"invocacion_funcion : ID '(' expresion ')'",
"invocacion_funcion : ID '(' bloque_list_expresiones ')'",
"invocacion_funcion : ID '(' ')'",
"invocacion_funcion : ID '(' tipo_base '(' expresion ')' ')'",
"fin_if : END_IF",
"fin_if : error",
"bloque_sentencias_ejecutables : sentencia_ejecutable ';'",
"bloque_sentencias_ejecutables : sentencia_ejecutable error",
"bloque_sentencias_ejecutables : BEGIN list_sentencias_ejecutables END",
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

//#line 261 "gramatica.y"
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

//#line 566 "Parser.java"
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
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR de 3");}
break;
case 27:
//#line 58 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
//#line 59 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 29:
//#line 60 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 30:
//#line 64 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR con condicion");}
break;
case 31:
//#line 65 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 32:
//#line 66 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 33:
//#line 67 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 34:
//#line 68 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 39:
//#line 79 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 46:
//#line 98 "gramatica.y"
{inFunction = true; hasReturn = false;}
break;
case 47:
//#line 98 "gramatica.y"
{ if (!hasReturn) {
                                                                                                 	yyerror("Falta sentencia RET en la función");
                                                                                                 }
                                                                                                 inFunction = false;
                                                                                                 }
break;
case 49:
//#line 103 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");}
break;
case 50:
//#line 104 "gramatica.y"
{yyerror("La funcione debe tener nombre");}
break;
case 51:
//#line 105 "gramatica.y"
{yyerror("La función debe tener parámetro");}
break;
case 53:
//#line 110 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 62:
//#line 134 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 66:
//#line 145 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 67:
//#line 146 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
//#line 153 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 72:
//#line 154 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 74:
//#line 159 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 75:
//#line 166 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 78:
//#line 169 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(1).sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 81:
//#line 178 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 82:
//#line 179 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 83:
//#line 180 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 85:
//#line 185 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 86:
//#line 186 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 87:
//#line 187 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 89:
//#line 192 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 91:
//#line 197 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 93:
//#line 202 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF con una sola sentencia en THEN");}
break;
case 94:
//#line 203 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF con múltiples sentencias en THEN");}
break;
case 95:
//#line 204 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con una sola sentencia en cada bloque");}
break;
case 96:
//#line 205 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con múltiples sentencias en cada bloque");}
break;
case 97:
//#line 206 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con una sola sentencia en THEN y múltiples sentencias en ELSE");}
break;
case 98:
//#line 207 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con múltiples sentencias en THEN y una sola sentencia en ELSE");}
break;
case 102:
//#line 217 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 103:
//#line 218 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 104:
//#line 219 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 114:
//#line 239 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
break;
case 115:
//#line 240 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 119:
//#line 251 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 120:
//#line 255 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 121:
//#line 256 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 122:
//#line 257 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 980 "Parser.java"
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
