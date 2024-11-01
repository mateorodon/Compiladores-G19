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
    8,    8,    8,    8,    8,    8,   10,   10,   10,   10,
   33,   33,   15,   15,   15,   11,   11,   11,   11,   11,
   11,   35,   35,   36,   36,   36,   36,   34,   34,   37,
   37,   37,   37,   37,   37,   18,   18,   18,   32,   38,
   38,   38,   12,   12,   12,
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
    6,    6,    5,    5,    4,    5,    4,    4,    3,    7,
    1,    1,    2,    3,    2,    7,    7,    9,    9,    9,
    9,    2,    2,    3,    2,    2,    1,    3,    2,    1,
    1,    1,    1,    1,    1,    3,    7,    1,    3,    3,
    1,    1,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,   43,   44,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   24,   25,    4,    6,
    8,    9,   46,    0,    0,    2,   40,    0,   75,    0,
   76,    0,    0,   71,  122,   89,    0,    0,    0,    0,
    0,  118,    0,    0,    0,    1,    0,  125,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   79,    0,    0,    0,    0,   87,    0,   88,    0,    0,
    0,    0,    0,  110,  111,  112,  115,  114,  113,    0,
  123,  124,    0,   85,    0,    0,    0,    0,    0,    0,
    0,   23,   22,    0,    0,    0,    0,   45,    0,    0,
   67,    0,   68,    0,   72,   69,   73,   70,    0,    0,
    0,    0,    0,    0,   84,    0,   83,   86,    0,    0,
   95,    0,    0,   21,   20,   93,    0,    0,    0,    0,
   53,    0,   77,    0,    0,    0,    0,  107,    0,    0,
    0,    0,    0,    0,    0,   82,   81,    0,    0,  109,
   94,    0,    0,    0,    0,    0,    0,   80,   90,    0,
  105,    0,    0,    0,  103,  106,   92,    0,   91,   96,
    0,   97,   36,   37,    0,    0,    0,  108,   62,    0,
    0,    0,   47,    0,    0,    0,    0,  104,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   52,   61,    0,
   60,    0,    0,   51,  117,   63,   98,  100,  101,   99,
    0,    0,    0,    0,    0,   58,   48,   50,    0,    0,
    0,    0,    0,    0,    0,    0,   35,    0,    0,   49,
   32,    0,   34,   33,   31,
};
final static short yydgoto[] = {                          3,
   12,  199,   14,   15,   16,   45,   17,   18,   19,   20,
   21,   22,   23,   36,  112,   37,   38,   64,  196,   65,
   24,  117,  200,  222,  244,  149,  150,  201,  202,   53,
   54,   59,  190,  163,  164,  165,  100,   60,
};
final static short yysindex[] = {                      -134,
  269,  374,    0,  -32,  -14,  374,   16,  -28,    0,    0,
  -15,  291,    0,  -40,   30, -177,    0,    0,    0,    0,
    0,    0,    0,    0,  314,   80,  103, -190,   34,  329,
  -38,  -58,  -61, -157, -135,  101,    0,    0,    0,    0,
    0,    0,    0,    9,  107,    0,    0,  -18,    0, -138,
    0,  127,   79,    0,    0,    0,  145,  118,  132,  137,
   83,    0,  119,  146,  134,    0,  158,    0,  356,  -61,
  -50,  153,  -39,  -37,  389,  161, -222,    7,   -3,  187,
    0,  126,  211,  228,  241,    0,  117,    0,  117,   29,
  127,  248,   17,    0,    0,    0,    0,    0,    0,  117,
    0,    0,  -46,    0,   36,   44,   -9,  -32, -129,  251,
  246,    0,    0,   -7,    0,   55,  275,    0,  226,   62,
    0,   79,    0,   79,    0,    0,    0,    0,  396,  127,
  117,  -51,  255,  127,    0,   53,    0,    0,   34,  276,
    0,  280,  390,    0,    0,    0,   61,  306,  310,  311,
    0,   91,    0,  292,  321,  127,  360,    0,  -73,  364,
  347,  359,  400, -239, -106,    0,    0,   35,   54,    0,
    0,  362,  349,  169,  173, -222,  349,    0,    0,  119,
    0,  405,  117,    0,    0,    0,    0,  255,    0,    0,
  255,    0,    0,    0, -175,  166,  181,    0,    0,  186,
  349,  399,    0,  349,    0,  193,  414,    0,  429, -151,
 -151, -151, -151,  407,  -17,  410,  412,    0,    0,  422,
    0,  349,  215,    0,    0,    0,    0,    0,    0,    0,
  439,  430,   34,  448,  452,    0,    0,    0,   34,  459,
  463,   34,   34,  233,  469,   34,    0,  472,  473,    0,
    0,  475,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -155,    0,    0,    0,    0,    0,    0,
    0,  517,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  520,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  116,    0,    0,    1,    0,    0,
    0,  139,   47,    0,    0,    0,  490,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   24,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  490,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   13,    0,    0,    0,    0,    0,
    0,   70,    0,   93,    0,    0,    0,    0,    0,   -4,
    0,    0,    0,  -41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  491,    0,    0,
    0,    0,    0,    0,    0,  159,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -64,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  270,    0,    0,    0,   37,    0,    0,    0,    0,    0,
    0,    0,    0,  -36,  -35,  -21,  -13,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  141,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  143,  155,    0,  420,  -56,    0,    0,    0,    0,  393,
    0,    0,    0,  502,    2,    0,    0,  263, -154,  460,
    6, -101, -122,    0,    0,    0,    0,    0,  -23,  343,
  367,  -34, -114,  -95,  -48,  -22,  409,    0,
};
final static int YYTABLESIZE=681;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        116,
   74,   70,   68,  110,   27,   30,   50,   27,   97,   99,
   98,  105,  148,  143,  197,  136,  187,  116,   41,   29,
  116,   27,  233,   78,   35,   29,  188,   28,   92,  189,
   63,   33,   58,  147,  115,   50,  119,   71,   72,  120,
  215,   74,   74,   74,   74,   74,   66,   74,   77,  139,
  192,    9,   10,   54,  206,   31,   54,  116,   28,   74,
   74,   74,   74,  182,   78,   78,   78,   78,   78,   64,
   78,   61,   79,   63,  205,  103,  113,   55,   50,   43,
   57,  223,   78,   78,   78,   78,  214,   66,   42,   66,
   66,   66,   65,  195,   44,  227,  228,  229,  230,  237,
   73,   42,  193,  194,  187,   66,   66,   66,   66,  162,
   64,  145,   64,   64,   64,   12,   42,  189,   80,  116,
   84,   34,    1,   81,   50,   85,  141,  108,   64,   64,
   64,   64,    2,   65,    5,   65,   65,   65,   38,  210,
    7,   75,  212,   56,   25,  207,   11,   50,   30,  187,
   78,   65,   65,   65,   65,   13,   13,   87,   39,  191,
   13,   50,  189,   50,  162,  211,   40,  162,  213,   82,
   50,   83,   88,   11,   12,   90,   82,  220,   83,   40,
   89,   26,  181,  108,   40,   86,   93,   82,   10,   83,
    5,  102,  109,   97,   99,   98,    7,   38,  101,  109,
  114,  102,   11,  109,  102,  109,  104,   94,   95,   96,
  135,  109,    9,   10,  106,    9,   10,   39,   48,  108,
   27,   30,  107,   49,   67,   26,    5,   27,   30,  109,
   27,   30,    7,   27,   30,   29,  116,  116,   11,   27,
   30,   34,   29,   28,  232,   29,   62,   48,   29,  115,
   28,   32,   49,   28,   29,   50,   28,   74,  119,   74,
   74,   74,   28,  118,   74,   76,    9,   10,   74,   42,
   74,   74,   50,   74,   74,   74,   74,  120,   74,   74,
   78,  133,   78,   78,   78,   50,  131,   78,  132,   62,
   48,   78,  137,   78,   78,   49,   78,   78,   78,   78,
  138,   78,   78,   66,  146,   66,   66,   66,  166,  167,
   66,  151,  193,  194,   66,  152,   66,   66,  153,   66,
   66,   66,   66,  154,   66,   66,   64,  173,   64,   64,
   64,  193,  194,   64,  169,   47,   48,   64,  170,   64,
   64,   49,   64,   64,   64,   64,  174,   64,   64,   65,
  175,   65,   65,   65,  176,  219,   65,  177,   55,   48,
   65,  179,   65,   65,   49,   65,   65,   65,   65,  140,
   65,   65,   12,   48,   55,   48,    9,   10,   49,   12,
   49,  121,   48,   12,  178,   12,   12,   49,   12,   12,
   12,   12,   94,   95,   96,   38,  102,   26,   82,  180,
   83,  168,   38,  183,   26,  184,   38,   26,   38,   38,
   26,   38,   38,   38,   38,   39,   26,  185,   51,   51,
  198,   51,   39,   51,  122,  124,   39,  216,   39,   39,
   11,   39,   39,   39,   39,  203,  155,   11,   82,  204,
   83,   11,  217,   11,   11,   10,   11,   11,   11,   11,
  126,  128,   10,  218,  225,   51,   10,  221,   10,   10,
  224,   10,   10,   10,   10,  231,  123,   48,  234,  226,
  235,   82,   49,   83,   51,   51,   51,   51,  239,   51,
  236,   51,  238,  125,   48,   52,   57,  242,  240,   49,
   69,  243,   51,  111,  111,  241,  127,   48,  246,   51,
  250,  245,   49,  247,  248,  249,  144,  108,  252,  251,
  158,  108,  253,  254,    5,  255,    5,  109,    5,    3,
    7,  159,   91,   51,    7,    4,   11,  160,  142,  111,
   11,   51,    5,  121,   56,    6,   74,   59,    7,    8,
  157,    0,    9,   10,   11,    0,  129,    4,  130,    0,
    0,    0,  161,    0,    5,    0,    0,    0,   39,  134,
    7,    8,  172,    0,    9,   10,   11,    0,    0,    0,
    4,    0,   51,    0,    0,   51,    0,    5,  142,    0,
    0,   46,  172,    7,    8,    4,    0,    9,   10,   11,
  156,    0,    5,    0,    0,    0,   66,    0,    7,    8,
    0,  172,    9,   10,   11,    4,    0,  161,    0,    0,
  161,    0,    5,    0,    0,    0,    0,    0,    7,    8,
    0,  160,    9,   10,   11,   51,    0,    0,    0,    0,
    4,   51,    0,    0,   51,   51,    0,    5,   51,   91,
    0,    0,  209,    7,    8,  108,  108,    9,   10,   11,
    0,    0,    5,    5,    0,  109,  108,  171,    7,    7,
    0,  108,    0,    5,   11,   11,    0,  186,    5,    7,
    0,    0,  208,    0,    7,   11,    0,    0,    0,    0,
   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   60,   41,   41,   41,   41,   45,   40,   60,   61,
   62,   62,  114,  109,  169,   62,  256,   59,   59,   41,
   77,   40,   40,    0,   40,   40,  266,   41,   63,  269,
   40,   60,   27,   41,  257,   45,   41,   32,   33,   44,
  195,   41,   42,   43,   44,   45,    0,   47,   40,   59,
  165,  274,  275,   41,  177,   40,   44,  114,   91,   59,
   60,   61,   62,  159,   41,   42,   43,   44,   45,    0,
   47,  262,   91,   40,  176,   70,   75,   41,   45,  257,
   44,  204,   59,   60,   61,   62,  262,   41,   59,   43,
   44,   45,    0,   59,  272,  210,  211,  212,  213,  222,
  258,  257,  278,  279,  256,   59,   60,   61,   62,  133,
   41,  110,   43,   44,   45,    0,  272,  269,  257,  176,
   42,  257,  257,  262,   45,   47,  256,  257,   59,   60,
   61,   62,  267,   41,  264,   43,   44,   45,    0,  188,
  270,   41,  191,   41,    2,  180,  276,   45,    6,  256,
   44,   59,   60,   61,   62,    1,    2,   40,    0,  266,
    6,   45,  269,   45,  188,  188,   12,  191,  191,   43,
   45,   45,   41,    0,   59,   93,   43,  201,   45,   25,
   44,   41,  256,  257,   30,   41,   41,   43,    0,   45,
  264,  256,  257,   60,   61,   62,  270,   59,   41,  264,
   40,  266,  276,  268,  269,  270,  257,  259,  260,  261,
  257,  276,  274,  275,   62,  274,  275,   59,  257,  257,
  257,  257,  262,  262,  263,  258,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  257,  262,  267,  256,  257,  270,  257,
  264,  280,  262,  267,  276,   45,  270,  257,  262,  259,
  260,  261,  276,  257,  264,  257,  274,  275,  268,  257,
  270,  271,   45,  273,  274,  275,  276,   91,  278,  279,
  257,  265,  259,  260,  261,   45,  258,  264,   41,  256,
  257,  268,  257,  270,  271,  262,  273,  274,  275,  276,
  257,  278,  279,  257,   59,  259,  260,  261,  256,  257,
  264,  257,  278,  279,  268,   41,  270,  271,   93,  273,
  274,  275,  276,  262,  278,  279,  257,  267,  259,  260,
  261,  278,  279,  264,   59,  256,  257,  268,   59,  270,
  271,  262,  273,  274,  275,  276,   41,  278,  279,  257,
   41,  259,  260,  261,   44,  201,  264,  267,  256,  257,
  268,   41,  270,  271,  262,  273,  274,  275,  276,  107,
  278,  279,  257,  257,  256,  257,  274,  275,  262,  264,
  262,  256,  257,  268,   93,  270,  271,  262,  273,  274,
  275,  276,  259,  260,  261,  257,   41,  257,   43,   40,
   45,  139,  264,   40,  264,   59,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,   59,   26,   27,
   59,   29,  264,   31,   82,   83,  268,  262,  270,  271,
  257,  273,  274,  275,  276,  267,   41,  264,   43,  267,
   45,  268,  262,  270,  271,  257,  273,  274,  275,  276,
   84,   85,  264,  268,   41,   63,  268,   59,  270,  271,
  268,  273,  274,  275,  276,   59,  256,  257,   59,   41,
   59,   43,  262,   45,   82,   83,   84,   85,   40,   87,
   59,   89,  268,  256,  257,   26,   27,   40,   59,  262,
   31,   40,  100,   74,   75,  233,  256,  257,   40,  107,
  268,  239,  262,   41,  242,  243,  256,  257,  246,   41,
  256,  257,   41,   41,  264,   41,    0,  267,  264,    0,
  270,  267,   63,  131,  270,  257,  276,  273,  109,  110,
  276,  139,  264,   44,   44,  267,   35,  268,  270,  271,
  132,   -1,  274,  275,  276,   -1,   87,  257,   89,   -1,
   -1,   -1,  133,   -1,  264,   -1,   -1,   -1,  268,  100,
  270,  271,  143,   -1,  274,  275,  276,   -1,   -1,   -1,
  257,   -1,  180,   -1,   -1,  183,   -1,  264,  159,   -1,
   -1,  268,  163,  270,  271,  257,   -1,  274,  275,  276,
  131,   -1,  264,   -1,   -1,   -1,  268,   -1,  270,  271,
   -1,  182,  274,  275,  276,  257,   -1,  188,   -1,   -1,
  191,   -1,  264,   -1,   -1,   -1,   -1,   -1,  270,  271,
   -1,  273,  274,  275,  276,  233,   -1,   -1,   -1,   -1,
  257,  239,   -1,   -1,  242,  243,   -1,  264,  246,  180,
   -1,   -1,  183,  270,  271,  257,  257,  274,  275,  276,
   -1,   -1,  264,  264,   -1,  267,  257,  268,  270,  270,
   -1,  257,   -1,  264,  276,  276,   -1,  268,  264,  270,
   -1,   -1,  268,   -1,  270,  276,   -1,   -1,   -1,   -1,
  276,
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
"declaracion_tipo : TYPEDEF TRIPLE tipo_base ID",
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

//#line 264 "gramatica.y"
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

//#line 574 "Parser.java"
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
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 86:
//#line 183 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 88:
//#line 188 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 89:
//#line 189 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 90:
//#line 190 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 92:
//#line 195 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 95:
//#line 201 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 96:
//#line 205 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF con una sola sentencia en THEN");}
break;
case 97:
//#line 206 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF con múltiples sentencias en THEN");}
break;
case 98:
//#line 207 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con una sola sentencia en cada bloque");}
break;
case 99:
//#line 208 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con múltiples sentencias en cada bloque");}
break;
case 100:
//#line 209 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con una sola sentencia en THEN y múltiples sentencias en ELSE");}
break;
case 101:
//#line 210 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con múltiples sentencias en THEN y una sola sentencia en ELSE");}
break;
case 105:
//#line 220 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 106:
//#line 221 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 107:
//#line 222 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 117:
//#line 242 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
break;
case 118:
//#line 243 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 122:
//#line 254 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 123:
//#line 258 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 124:
//#line 259 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 125:
//#line 260 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 1000 "Parser.java"
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
