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
    0,    0,    0,    0,    1,    1,    1,    1,    2,    2,
    3,    3,    3,    4,    4,    4,    4,    4,   13,   13,
   13,   13,   14,   14,   14,   14,   14,    9,    9,    5,
    5,    5,   18,   18,    6,    6,    6,   21,    7,    7,
    7,    7,   19,   19,   22,   23,   23,   20,   20,   20,
   24,   17,   17,   17,   25,   25,   25,   26,   26,   26,
   26,   26,   26,   26,   26,    8,    8,    8,    8,    8,
   10,   10,   10,   28,   28,   15,   15,   15,   11,   11,
   11,   11,   11,   11,   30,   30,   30,   29,   29,   29,
   29,   31,   31,   31,   31,   31,   31,   31,   16,   16,
   27,   32,   32,   12,   12,   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    3,    3,    3,    2,    2,    1,    1,
    2,    1,    1,    1,    1,    1,    1,    1,    5,    5,
    5,    5,    8,    8,   12,   12,    4,    3,    6,    1,
    1,    1,    1,    1,    3,    2,    1,    0,   10,    9,
    9,    9,    2,    1,    3,    1,    3,    0,    3,    2,
    4,    3,    3,    1,    3,    3,    1,    1,    1,    1,
    4,    2,    2,    5,    1,    0,    6,    6,    3,    5,
    4,    4,    7,    1,    1,    2,    2,    3,    9,    9,
    7,    7,    7,    9,    1,    5,    2,    3,    2,    2,
    3,    1,    1,    1,    1,    1,    1,    1,    3,    7,
    3,    3,    1,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,   30,   31,
    0,    0,    0,    9,   10,    0,   12,   13,   14,   15,
   16,   17,   18,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    4,    0,    8,    7,   37,    0,
    0,    2,   65,    0,   59,    0,   60,    0,    0,   57,
   33,   34,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    0,  106,    0,   69,    0,    0,    0,    0,
    6,    5,    0,    0,   36,    0,    0,    0,   63,    0,
    0,    0,    0,   71,    0,   72,    0,    0,    0,    0,
    0,   98,   92,   93,   94,   97,   96,   95,    0,    0,
    0,  104,  105,    0,    0,    0,    0,    0,    0,    0,
   35,    0,    0,    0,    0,   55,   56,    0,    0,    0,
    0,    0,    0,    0,    0,   70,    0,    0,    0,    0,
    0,   21,   22,   20,   19,    0,    0,    0,    0,    0,
    0,    0,   61,    0,    0,    0,    0,    0,    0,   85,
    0,    0,    0,    0,    0,   68,   67,   27,    0,    0,
    0,   77,   76,   43,    0,    0,    0,    0,    0,   64,
   73,    0,    0,    0,   87,   83,    0,   75,   74,   82,
    0,   81,    0,   90,   89,   78,    0,    0,    0,   38,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   91,
   88,    0,    0,    0,    0,    0,    0,  100,    0,   51,
   84,   80,   79,    0,    0,    0,   41,   50,   42,    0,
   40,   86,    0,    0,   49,   39,    0,    0,    0,    0,
    0,    0,   25,   26,
};
final static short yydgoto[] = {                          3,
  202,   13,   14,   15,   16,   41,   17,   18,   19,   20,
   21,   22,   23,   69,  150,   59,   60,   54,  138,  203,
  206,  141,  142,  151,   49,   50,   55,  180,  161,  152,
   99,   56,
};
final static short yysindex[] = {                      -108,
   70,  118,    0,  -35,  -34,  118,   41, -252,    0,    0,
  -29,   86,  -51,    0,    0, -146,    0,    0,    0,    0,
    0,    0,    0,   95,  -20,  -45, -220,  -36,  -36,  110,
  -38,  -10, -185, -185,    0,  -49,    0,    0,    0, -105,
  -42,    0,    0,   25,    0, -140,    0,   76,  119,    0,
    0,    0,  163,   52,  102,  124,   80,  -20,  169,   34,
  -12,    0,  175,    0,  283,    0,  -83,  -73,  200,   -6,
    0,    0,  135,  208,    0,   -2,   44,  162,    0,  -20,
  -20,  -20,  -20,    0,  -20,    0,  -20,   18,   76,  250,
   38,    0,    0,    0,    0,    0,    0,    0,  -20,   46,
   49,    0,    0,    4,   55,  144,  144,   66, -145, -147,
    0,  227,   63,  119,  119,    0,    0,  306,   76,  -20,
   22,  133,   76,  133,   43,    0,    9,  -47,  -35,  158,
  -11,    0,    0,    0,    0,    0,   51,  288,  290,  291,
  294,  295,    0,  245,  307,   76,  313,  158,  315,    0,
  299,   99,   98, -125, -151,    0,    0,    0,  -36,   28,
  148,    0,    0,    0,  105,  106,  109,  112, -145,    0,
    0,  -20,  134,  -20,    0,    0,  133,    0,    0,    0,
   45,    0,  318,    0,    0,    0,   29,  -87,  -87,    0,
  -87,    0,  342,  328,  376, -125, -125, -125,  -65,    0,
    0,  -87,  127,  337,  131,  -87,  145,    0,  161,    0,
    0,    0,    0,  168,  171,  364,    0,    0,    0,  164,
    0,    0,  372,  377,    0,    0,  395,  397,  -36,  -36,
  398,  399,    0,    0,
};
final static short yyrindex[] = {                         0,
   30,   30,    0, -119,    0,   30,    0,    0,    0,    0,
    0,   30,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   30,    0,    0,    0,    0,    0,    1,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   31,    0,    0,  -28,    0,    0,    0,   32,    2,    0,
    0,    0,  394,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -21,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  394,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    8,   14,    0,    0,    0,  155,    0,
    0,    0,   -5,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -14,    0,    0,    0,  400,
    0,    0,    0,    0,    0,   40,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   21,   21,    0,
   21,  159,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   30,    0,    0,    0,   21,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   -4,    3,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  170,   90,    0,   17,  -24,    0,    0,    0,    0,   75,
    0,    0,    0,  407,  319,   42,   82,  375,  -32,  -43,
    0,    0,    0,   -9,  199,  215,  -40,  -62,  297,  -27,
  322,    0,
};
final static int YYTABLESIZE=445;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         46,
    3,   76,   64,   58,   26,   29,   46,   38,   46,   72,
   34,  159,   58,   58,   58,   58,   58,   90,   58,   62,
   62,   62,   62,   62,   46,   62,   44,   32,  101,   44,
   58,   58,   58,   58,  108,   99,   23,   62,   62,   62,
   62,   57,   54,   24,   54,   54,   54,  163,   52,   67,
   52,   52,   52,   99,   53,   27,   53,   53,   53,   66,
   54,   54,   54,   54,   26,  127,   52,   52,   52,   52,
   61,   68,   53,   53,   53,   53,   80,  140,   81,   66,
   31,   96,   98,   97,  137,  137,  185,  201,   66,   11,
   28,   85,  182,   96,   98,   97,  153,  155,   29,   47,
   47,   36,   47,   47,  178,   47,   48,   53,  139,  136,
   39,  136,   65,   36,  181,   77,   78,  179,   80,   36,
   81,   79,  131,  131,  131,   40,    9,   10,    9,   10,
  178,  193,   47,  211,  212,  213,  192,   32,  131,   89,
  131,  131,   86,  179,  137,  205,  160,  207,    1,  196,
   73,   74,   32,  198,   47,   47,   47,   47,    2,   47,
   82,   47,  220,  194,  160,   83,  118,   87,  119,    4,
   12,   24,   88,   47,  109,   30,    5,  187,  204,  204,
  123,  204,    7,    8,  105,  149,    9,   10,   11,  187,
   51,   52,  216,  131,   47,  101,  204,  131,  102,   45,
  183,  146,   47,   84,   37,   80,   71,   81,  158,   91,
   43,   44,  214,  215,   75,  102,   45,   43,   44,   43,
   44,   28,   25,   45,   63,   45,   33,   58,   51,   52,
   58,   58,   58,   47,   62,   43,   44,   62,   62,   62,
  106,   45,   32,  100,  162,   66,   47,  110,   47,  107,
   99,   23,  113,   89,  111,  195,   66,   54,   24,  126,
   54,   54,   54,   52,  156,  157,   52,   52,   52,   53,
  231,  232,   53,   53,   53,  120,   66,   92,  114,  115,
   93,   94,   95,  184,  200,   66,   11,   28,   48,   92,
  121,   36,   93,   94,   95,   29,  116,  117,  154,  129,
  197,  129,  122,   47,   47,  112,    5,  164,    5,  148,
  124,  148,    7,  125,    7,  149,  128,  149,   11,  143,
   11,  134,  129,  103,  144,   80,    4,   81,  165,    5,
  166,  167,  130,    5,  168,    7,    6,  170,  169,    7,
    8,   11,    4,    9,   10,   11,  145,  171,   80,    5,
   81,    4,  172,   35,  174,    7,    8,  175,    5,    9,
   10,   11,   42,  177,    7,    8,    4,  176,    9,   10,
   11,  188,  189,    5,    4,  190,  199,   62,  191,    7,
    8,    5,  208,    9,   10,   11,  209,    7,    8,  129,
  129,    9,   10,   11,  217,  218,    5,    5,  219,  148,
  129,  186,    7,    7,  129,  149,  149,    5,   11,   11,
  130,    5,  221,    7,  129,  186,  210,    7,   80,   11,
   81,    5,  225,   11,  132,  133,  135,    7,  222,  223,
  227,  226,  224,   11,  229,  228,  230,  103,  233,  234,
   70,  104,  147,   46,  173,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         45,
    0,   44,   41,   40,   40,   40,   45,   59,   45,   59,
   40,   59,   41,   42,   43,   44,   45,   58,   47,   41,
   42,   43,   44,   45,   45,   47,   41,  280,   41,   44,
   59,   60,   61,   62,   41,   41,   41,   59,   60,   61,
   62,  262,   41,   41,   43,   44,   45,   59,   41,   60,
   43,   44,   45,   59,   41,   91,   43,   44,   45,   59,
   59,   60,   61,   62,   40,   62,   59,   60,   61,   62,
   29,  257,   59,   60,   61,   62,   43,  110,   45,   59,
   40,   60,   61,   62,  109,  110,   59,   59,   59,   59,
   59,   40,  155,   60,   61,   62,  124,  125,   59,   25,
   26,   12,   28,   29,  256,   31,   25,   26,  256,  257,
  257,  257,   31,   24,  266,   91,  257,  269,   43,   30,
   45,  262,  106,  107,  108,  272,  274,  275,  274,  275,
  256,  172,   58,  196,  197,  198,  169,  257,  122,   58,
  124,  125,   41,  269,  169,  189,  130,  191,  257,  177,
  256,  257,  272,  181,   80,   81,   82,   83,  267,   85,
   42,   87,  206,  173,  148,   47,   85,   44,   87,  257,
    1,    2,   93,   99,   40,    6,  264,  161,  188,  189,
   99,  191,  270,  271,  258,  273,  274,  275,  276,  173,
  274,  275,  202,  177,  120,   41,  206,  181,   44,   41,
  159,  120,   44,   41,  256,   43,  256,   45,  256,   41,
  256,  257,  278,  279,  257,   41,  262,  256,  257,  256,
  257,  256,  258,  262,  263,  262,  256,  256,  274,  275,
  259,  260,  261,  159,  256,  256,  257,  259,  260,  261,
   41,  262,  257,  256,  256,  256,  172,   40,  174,  256,
  256,  256,   91,  172,  257,  174,  256,  256,  256,  256,
  259,  260,  261,  256,  256,  257,  259,  260,  261,  256,
  229,  230,  259,  260,  261,  258,  256,  256,   80,   81,
  259,  260,  261,  256,  256,  256,  256,  256,  268,  256,
   41,  202,  259,  260,  261,  256,   82,   83,  256,  257,
  256,  257,  265,  229,  230,  262,  264,  257,  264,  267,
  265,  267,  270,  265,  270,  273,  262,  273,  276,   93,
  276,  256,  257,   41,  262,   43,  257,   45,   41,  264,
   41,   41,  267,  264,   41,  270,  267,   93,   44,  270,
  271,  276,  257,  274,  275,  276,   41,   41,   43,  264,
   45,  257,   40,  268,   40,  270,  271,   59,  264,  274,
  275,  276,  268,  266,  270,  271,  257,  269,  274,  275,
  276,  267,  267,  264,  257,  267,   59,  268,  267,  270,
  271,  264,   41,  274,  275,  276,   59,  270,  271,  257,
  257,  274,  275,  276,  268,   59,  264,  264,  268,  267,
  257,  268,  270,  270,  257,  273,  273,  264,  276,  276,
  267,  264,  268,  270,  257,  268,   41,  270,   43,  276,
   45,  264,   59,  276,  106,  107,  108,  270,  268,  262,
   59,  268,  262,  276,   40,   59,   40,   44,   41,   41,
   34,   67,  121,   44,  148,
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
"list_sentencias : list_sentencias sentencia ';'",
"list_sentencias : list_sentencias sentencia error",
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
"sentencia_control : FOR '(' encabezado_for error bloque_sentencias_ejecutables",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE error",
"asignacion : ID ASIGNACION expresion",
"asignacion : ID '[' CONSTANTE ']' ASIGNACION expresion",
"tipo : ULONGINT",
"tipo : SINGLE",
"tipo : ID",
"tipo_base : ULONGINT",
"tipo_base : SINGLE",
"list_variables : list_variables ',' ID",
"list_variables : list_variables ID",
"list_variables : ID",
"$$1 :",
"declaracion_funcion : tipo FUN ID '(' parametro ')' BEGIN $$1 cuerpo_funcion END",
"declaracion_funcion : tipo FUN ID '(' bloque_list_parametro ')' BEGIN cuerpo_funcion END",
"declaracion_funcion : tipo FUN error '(' parametro ')' BEGIN cuerpo_funcion END",
"declaracion_funcion : tipo FUN ID '(' error ')' BEGIN cuerpo_funcion END",
"parametro : tipo ID",
"parametro : ID",
"bloque_list_parametro : list_parametro ',' parametro",
"list_parametro : parametro",
"list_parametro : list_parametro ',' parametro",
"cuerpo_funcion :",
"cuerpo_funcion : list_sentencias sentencia_return ';'",
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
"bloque_if : IF '(' condicion ')' THEN cuerpo_if ELSE error fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if fin_if",
"bloque_if : IF '(' condicion ')' THEN error fin_if",
"bloque_if : IF error condicion ')' THEN cuerpo_if END_IF",
"bloque_if : IF '(' condicion error THEN cuerpo_if ELSE cuerpo_if fin_if",
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

//#line 226 "gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;
static boolean inFunction = false;

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

//#line 496 "Parser.java"
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
case 6:
//#line 19 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
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
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 26:
//#line 55 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 27:
//#line 56 "gramatica.y"
{yyerror("Falta ';' en encabezado del FOR");}
break;
case 28:
//#line 60 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 29:
//#line 61 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion ");}
break;
case 36:
//#line 77 "gramatica.y"
{yyerror("Las variables deben estar separados por coma");}
break;
case 38:
//#line 82 "gramatica.y"
{inFunction = true;}
break;
case 39:
//#line 82 "gramatica.y"
{inFunction = false;}
break;
case 40:
//#line 83 "gramatica.y"
{yyerror("La funcione no puede tener mas de un parametro");}
break;
case 41:
//#line 84 "gramatica.y"
{yyerror("La funcione debe tener nombre");}
break;
case 42:
//#line 85 "gramatica.y"
{yyerror("La funcion debe tener parametro");}
break;
case 44:
//#line 90 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 51:
//#line 107 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 59:
//#line 127 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 60:
//#line 134 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 62:
//#line 136 "gramatica.y"
{}
break;
case 63:
//#line 137 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(1).sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 64:
//#line 141 "gramatica.y"
{}
break;
case 65:
//#line 142 "gramatica.y"
{yyerror("Falta operando en la expresión");}
break;
case 68:
//#line 147 "gramatica.y"
{yyerror("Falta ID al final de la declaracion");}
break;
case 69:
//#line 148 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion");}
break;
case 70:
//#line 149 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion");}
break;
case 72:
//#line 154 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 73:
//#line 155 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 75:
//#line 160 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 77:
//#line 165 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 79:
//#line 170 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 80:
//#line 171 "gramatica.y"
{yyerror("Falta contenido en el bloque ELSE");}
break;
case 81:
//#line 172 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 82:
//#line 173 "gramatica.y"
{yyerror("Falta contenido en el bloque THEN");}
break;
case 83:
//#line 174 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 84:
//#line 175 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 90:
//#line 188 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 91:
//#line 189 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 98:
//#line 199 "gramatica.y"
{yyerror("Falta comparador en la comparación");}
break;
case 104:
//#line 220 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 105:
//#line 221 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 106:
//#line 222 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 869 "Parser.java"
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
