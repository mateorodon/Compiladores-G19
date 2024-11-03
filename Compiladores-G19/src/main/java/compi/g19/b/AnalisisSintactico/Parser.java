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
    7,    7,    7,   22,   22,   26,   27,   27,   23,   23,
   23,   28,   28,   29,   20,   20,   20,   20,   20,   30,
   30,   30,   30,   30,   31,   31,   31,   31,   31,   31,
   31,    8,    8,    8,    8,    8,    8,   10,   10,   10,
   10,   33,   33,   15,   15,   15,   11,   11,   11,   11,
   11,   11,   35,   35,   36,   36,   36,   36,   34,   34,
   37,   37,   37,   37,   37,   37,   18,   18,   18,   32,
   38,   38,   38,   12,   12,   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    3,    2,    2,    1,    2,    2,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    5,
    5,    4,    4,    1,    1,    8,    7,    7,    7,    7,
   12,   11,   11,   11,   10,    1,    1,    3,    6,    3,
    1,    1,    1,    1,    3,    1,    0,    0,   11,    9,
    8,    7,    8,    2,    1,    3,    1,    3,    3,    1,
    2,    2,    1,    4,    3,    3,    1,    3,    3,    3,
    3,    1,    3,    3,    1,    1,    1,    4,    2,    2,
    5,    6,    6,    5,    5,    4,    5,    4,    4,    3,
    7,    1,    1,    2,    3,    2,    7,    7,    9,    9,
    9,    9,    2,    2,    3,    2,    2,    1,    3,    2,
    1,    1,    1,    1,    1,    1,    3,    7,    1,    3,
    3,    1,    1,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,   43,   44,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   24,   25,    4,    6,
    8,    9,   46,    0,    0,    2,   40,    0,   76,    0,
   77,    0,    0,   72,  123,   90,    0,    0,    0,    0,
    0,  119,    0,    0,    0,    1,    0,  126,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   80,    0,    0,    0,    0,   88,    0,   89,    0,    0,
    0,    0,    0,  111,  112,  113,  116,  115,  114,    0,
  124,  125,    0,   86,    0,    0,    0,    0,    0,    0,
    0,   23,   22,    0,    0,    0,    0,   45,    0,    0,
   68,    0,   69,    0,   73,   70,   74,   71,    0,    0,
    0,    0,    0,    0,   85,    0,   84,   87,    0,    0,
   96,    0,    0,   21,   20,   94,    0,    0,    0,    0,
   54,    0,   78,    0,    0,    0,    0,  108,    0,    0,
    0,    0,    0,    0,    0,   83,   82,    0,    0,  110,
   95,    0,    0,    0,    0,    0,    0,   81,   91,    0,
  106,    0,    0,    0,  104,  107,   93,    0,   92,   97,
    0,   98,   36,   37,    0,    0,    0,  109,   63,    0,
    0,    0,   47,    0,    0,   52,    0,    0,  105,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   53,   62,
    0,   61,    0,    0,   51,  118,   64,   99,  101,  102,
  100,    0,    0,    0,    0,    0,   59,   48,   50,    0,
    0,    0,    0,    0,    0,    0,    0,   35,    0,    0,
   49,   32,    0,   34,   33,   31,
};
final static short yydgoto[] = {                          3,
   12,  199,   14,   15,   16,   45,   17,   18,   19,   20,
   21,   22,   23,   36,  112,   37,   38,   64,  196,   65,
   24,  117,  200,  223,  245,  149,  150,  201,  202,   53,
   54,   59,  190,  163,  164,  165,  100,   60,
};
final static short yysindex[] = {                      -134,
  330,  398,    0,  -32,   16,  398,   32,  -28,    0,    0,
  -15,  345,    0,  -42,  -26, -242,    0,    0,    0,    0,
    0,    0,    0,    0,  354,   80,  103, -173,   34,  382,
  -38,  -58, -236, -163, -154,   85,    0,    0,    0,    0,
    0,    0,    0,    9,   98,    0,    0,  -18,    0, -243,
    0,  106,   75,    0,    0,    0,  143,  133,  135,  137,
   90,    0,  119,  152,  134,    0,  158,    0,  356, -236,
  -50,  144,  -59,  -37,  413,  183, -170,    7,   -3,  187,
    0,  126,  211,  228,  241,    0,  117,    0,  117,   29,
  106,  248,   17,    0,    0,    0,    0,    0,    0,  117,
    0,    0,  -46,    0,   36,   44,   -9,  -32, -129,  281,
  246,    0,    0,   -7,    0,   55,  275,    0,  226,   62,
    0,   75,    0,   75,    0,    0,    0,    0,  359,  106,
  117,  -51,  266,  106,    0, -176,    0,    0,   34,  269,
    0,  273,  414,    0,    0,    0,   66,  294,  298,  303,
    0,   84,    0,  262,  317,  106,  322,    0,  299,  366,
  311,  326,  424, -106,  -64,    0,    0,   35,  -66,    0,
    0,  367,  390,  151,  154, -170,  310,    0,    0,  119,
    0,  429,  117,    0,    0,    0,    0,  266,    0,    0,
  266,    0,    0,    0, -160,  163,  166,    0,    0,  171,
  390,  381,    0,  390,    0,    0,  173,  402,    0,  438,
 -111, -111, -111, -111,  392,  -17,  395,  396,    0,    0,
  399,    0,  390,  184,    0,    0,    0,    0,    0,    0,
    0,  421,  407,   34,  430,  434,    0,    0,    0,   34,
  446,  428,   34,   34,  219,  447,   34,    0,  448,  453,
    0,    0,  458,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -220,    0,    0,    0,    0,    0,    0,
    0,  501,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  502,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  116,    0,    0,    1,    0,    0,
    0,  139,   47,    0,    0,    0,  460,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   24,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  460,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   13,    0,    0,    0,    0,    0,
    0,   70,    0,   93,    0,    0,    0,    0,    0,   99,
    0,    0,    0,  -41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  464,    0,    0,
    0,    0,    0,    0,    0,  159,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  250,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  242,    0,    0,    0,  128,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -36,  -35,  -21,  -13,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  141,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  164,  155,    0,  362,  -56,    0,    0,    0,    0,  393,
    0,    0,    0,  474,    2,    0,    0,  -43, -142,  465,
    8, -101, -122,    0,    0,    0,    0,    0,  -23,  132,
  225,  -34, -114,  -83,  -67,   -1,  379,    0,
};
final static int YYTABLESIZE=705;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        117,
   75,   70,   68,  110,   27,   30,   50,   27,   97,   99,
   98,  105,  148,   80,   43,  136,   41,  117,   81,   29,
  116,   27,  234,   79,   35,  143,  197,   28,   92,   44,
   63,   33,   42,  147,   58,   50,   42,    9,   10,   71,
   72,   75,   75,   75,   75,   75,   67,   75,   77,  139,
  192,   42,  216,   55,  207,   29,   55,  116,   28,   75,
   75,   75,   75,  140,   79,   79,   79,   79,   79,   65,
   79,   31,   79,   63,  205,  182,  113,  103,   50,  166,
  167,  224,   79,   79,   79,   79,  115,   67,   61,   67,
   67,   67,   66,  195,   73,  168,  228,  229,  230,  231,
  238,  215,   34,    9,   10,   67,   67,   67,   67,  162,
   65,  145,   65,   65,   65,   12,   84,  193,  194,  116,
  211,   85,    1,  213,   50,   75,  141,  108,   65,   65,
   65,   65,    2,   66,    5,   66,   66,   66,   38,  120,
    7,   78,  121,   56,  187,  208,   11,   50,   82,  187,
   83,   66,   66,   66,   66,   13,   13,  189,   39,  188,
   13,   50,  189,   50,  162,   25,   40,  162,   56,   30,
   50,   58,   87,   11,   12,   88,   82,  221,   83,   40,
   89,   26,   90,   86,   40,   82,  212,   83,   10,  214,
  242,  187,   93,   97,   99,   98,  246,   38,  101,  249,
  250,  191,  107,  253,  189,  106,  104,   94,   95,   96,
  135,  193,  194,  122,  124,    9,   10,   39,   48,  108,
   27,   30,  114,   49,   67,   26,    5,   27,   30,  109,
   27,   30,    7,   27,   30,   29,  117,  117,   11,   27,
   30,   34,   29,   28,  233,   29,   62,   48,   29,  115,
   28,   32,   49,   28,   29,   50,   28,   75,  119,   75,
   75,   75,   28,  118,   75,   76,    9,   10,   75,   42,
   75,   75,   50,   75,   75,   75,   75,  120,   75,   75,
   79,  133,   79,   79,   79,   50,  131,   79,  132,   62,
   48,   79,  137,   79,   79,   49,   79,   79,   79,   79,
  138,   79,   79,   67,  146,   67,   67,   67,  126,  128,
   67,  151,  193,  194,   67,  152,   67,   67,  153,   67,
   67,   67,   67,  154,   67,   67,   65,  169,   65,   65,
   65,  170,  173,   65,  174,   47,   48,   65,  175,   65,
   65,   49,   65,   65,   65,   65,  176,   65,   65,   66,
  177,   66,   66,   66,  178,  220,   66,  179,   55,   48,
   66,  180,   66,   66,   49,   66,   66,   66,   66,  184,
   66,   66,   12,   48,   55,   48,    9,   10,   49,   12,
   49,  121,   48,   12,  185,   12,   12,   49,   12,   12,
   12,   12,   94,   95,   96,   38,  102,   26,   82,  155,
   83,   82,   38,   83,   26,  183,   38,   26,   38,   38,
   26,   38,   38,   38,   38,   39,   26,  203,   51,   51,
  204,   51,   39,   51,  217,  198,   39,  218,   39,   39,
   11,   39,   39,   39,   39,  111,  111,   11,  219,  222,
  225,   11,  226,   11,   11,   10,   11,   11,   11,   11,
  232,  239,   10,  235,  236,   51,   10,  237,   10,   10,
  240,   10,   10,   10,   10,  241,  123,   48,  248,  243,
  142,  111,   49,  244,   51,   51,   51,   51,  227,   51,
   82,   51,   83,  125,   48,  247,  251,  252,  254,   49,
   52,   57,   51,  255,  161,   69,  127,   48,  256,   51,
    5,    3,   49,  122,  172,  103,  110,   57,   74,   60,
  157,    0,    0,  110,    0,  103,    0,  110,  103,  110,
  142,  158,  108,   51,  172,  110,    0,   91,    0,    5,
    0,   51,  159,    0,    0,    7,  144,  108,  160,    0,
    0,   11,    0,  172,    5,    0,    0,  109,    0,  161,
    7,  129,  161,  130,  181,  108,   11,    0,    0,    0,
    0,    0,    5,    0,  134,    0,    4,    0,    7,    0,
    0,    0,   51,    5,   11,   51,    0,  206,    0,    7,
    8,    0,  160,    9,   10,   11,    4,    0,    0,    0,
    0,    0,    0,    5,    0,  156,    6,    0,    0,    7,
    8,    4,    0,    9,   10,   11,    0,    0,    5,    0,
    4,    0,   39,    0,    7,    8,    0,    5,    9,   10,
   11,   46,    0,    7,    8,    0,   51,    9,   10,   11,
    0,    0,   51,    0,    0,   51,   51,    0,    4,   51,
    0,    0,    0,    0,   91,    5,    4,  210,    0,   66,
    0,    7,    8,    5,    4,    9,   10,   11,    0,    7,
    8,    5,  160,    9,   10,   11,    0,    7,    8,  108,
  108,    9,   10,   11,    0,    0,    5,    5,    0,  109,
  108,  171,    7,    7,    0,  108,    0,    5,   11,   11,
    0,  186,    5,    7,    0,    0,  209,    0,    7,   11,
    0,    0,    0,    0,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   60,   41,   41,   41,   41,   45,   40,   60,   61,
   62,   62,  114,  257,  257,   62,   59,   59,  262,   41,
   77,   40,   40,    0,   40,  109,  169,   41,   63,  272,
   40,   60,   59,   41,   27,   45,  257,  274,  275,   32,
   33,   41,   42,   43,   44,   45,    0,   47,   40,   59,
  165,  272,  195,   41,  177,   40,   44,  114,   91,   59,
   60,   61,   62,  107,   41,   42,   43,   44,   45,    0,
   47,   40,   91,   40,  176,  159,   75,   70,   45,  256,
  257,  204,   59,   60,   61,   62,  257,   41,  262,   43,
   44,   45,    0,   59,  258,  139,  211,  212,  213,  214,
  223,  262,  257,  274,  275,   59,   60,   61,   62,  133,
   41,  110,   43,   44,   45,    0,   42,  278,  279,  176,
  188,   47,  257,  191,   45,   41,  256,  257,   59,   60,
   61,   62,  267,   41,  264,   43,   44,   45,    0,   41,
  270,   44,   44,   41,  256,  180,  276,   45,   43,  256,
   45,   59,   60,   61,   62,    1,    2,  269,    0,  266,
    6,   45,  269,   45,  188,    2,   12,  191,   41,    6,
   45,   44,   40,    0,   59,   41,   43,  201,   45,   25,
   44,   41,   93,   41,   30,   43,  188,   45,    0,  191,
  234,  256,   41,   60,   61,   62,  240,   59,   41,  243,
  244,  266,  262,  247,  269,   62,  257,  259,  260,  261,
  257,  278,  279,   82,   83,  274,  275,   59,  257,  257,
  257,  257,   40,  262,  263,  258,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  257,  262,  267,  256,  257,  270,  257,
  264,  280,  262,  267,  276,   45,  270,  257,  262,  259,
  260,  261,  276,  257,  264,  257,  274,  275,  268,  257,
  270,  271,   45,  273,  274,  275,  276,   91,  278,  279,
  257,  265,  259,  260,  261,   45,  258,  264,   41,  256,
  257,  268,  257,  270,  271,  262,  273,  274,  275,  276,
  257,  278,  279,  257,   59,  259,  260,  261,   84,   85,
  264,  257,  278,  279,  268,   41,  270,  271,   93,  273,
  274,  275,  276,  262,  278,  279,  257,   59,  259,  260,
  261,   59,  267,  264,   41,  256,  257,  268,   41,  270,
  271,  262,  273,  274,  275,  276,   44,  278,  279,  257,
  267,  259,  260,  261,   93,  201,  264,   41,  256,  257,
  268,   40,  270,  271,  262,  273,  274,  275,  276,   59,
  278,  279,  257,  257,  256,  257,  274,  275,  262,  264,
  262,  256,  257,  268,   59,  270,  271,  262,  273,  274,
  275,  276,  259,  260,  261,  257,   41,  257,   43,   41,
   45,   43,  264,   45,  264,   40,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  267,   26,   27,
  267,   29,  264,   31,  262,   59,  268,  262,  270,  271,
  257,  273,  274,  275,  276,   74,   75,  264,  268,   59,
  268,  268,   41,  270,  271,  257,  273,  274,  275,  276,
   59,  268,  264,   59,   59,   63,  268,   59,  270,  271,
   40,  273,  274,  275,  276,   59,  256,  257,   41,   40,
  109,  110,  262,   40,   82,   83,   84,   85,   41,   87,
   43,   89,   45,  256,  257,   40,  268,   41,   41,  262,
   26,   27,  100,   41,  133,   31,  256,  257,   41,  107,
    0,    0,  262,   44,  143,  256,  257,   44,   35,  268,
  132,   -1,   -1,  264,   -1,  266,   -1,  268,  269,  270,
  159,  256,  257,  131,  163,  276,   -1,   63,   -1,  264,
   -1,  139,  267,   -1,   -1,  270,  256,  257,  273,   -1,
   -1,  276,   -1,  182,  264,   -1,   -1,  267,   -1,  188,
  270,   87,  191,   89,  256,  257,  276,   -1,   -1,   -1,
   -1,   -1,  264,   -1,  100,   -1,  257,   -1,  270,   -1,
   -1,   -1,  180,  264,  276,  183,   -1,  268,   -1,  270,
  271,   -1,  273,  274,  275,  276,  257,   -1,   -1,   -1,
   -1,   -1,   -1,  264,   -1,  131,  267,   -1,   -1,  270,
  271,  257,   -1,  274,  275,  276,   -1,   -1,  264,   -1,
  257,   -1,  268,   -1,  270,  271,   -1,  264,  274,  275,
  276,  268,   -1,  270,  271,   -1,  234,  274,  275,  276,
   -1,   -1,  240,   -1,   -1,  243,  244,   -1,  257,  247,
   -1,   -1,   -1,   -1,  180,  264,  257,  183,   -1,  268,
   -1,  270,  271,  264,  257,  274,  275,  276,   -1,  270,
  271,  264,  273,  274,  275,  276,   -1,  270,  271,  257,
  257,  274,  275,  276,   -1,   -1,  264,  264,   -1,  267,
  257,  268,  270,  270,   -1,  257,   -1,  264,  276,  276,
   -1,  268,  264,  270,   -1,   -1,  268,   -1,  270,  276,
   -1,   -1,   -1,   -1,  276,
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
"declaracion_funcion : tipo FUN '(' parametro ')' BEGIN END",
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

//#line 265 "gramatica.y"
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

//#line 579 "Parser.java"
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
{yyerror("La funcione debe tener un cuerpo");}
break;
case 53:
//#line 107 "gramatica.y"
{yyerror("La función debe tener parámetro");}
break;
case 55:
//#line 112 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 64:
//#line 136 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 68:
//#line 147 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 69:
//#line 148 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 73:
//#line 155 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 74:
//#line 156 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 76:
//#line 161 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 77:
//#line 168 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 80:
//#line 171 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(1).sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 83:
//#line 180 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 84:
//#line 181 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 85:
//#line 182 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 86:
//#line 183 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 87:
//#line 184 "gramatica.y"
{yyerror("Falta TRIPLE antes de la declaracion de tipo");}
break;
case 89:
//#line 189 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 90:
//#line 190 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 91:
//#line 191 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 93:
//#line 196 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 96:
//#line 202 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 97:
//#line 206 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF con una sola sentencia en THEN");}
break;
case 98:
//#line 207 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF con múltiples sentencias en THEN");}
break;
case 99:
//#line 208 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con una sola sentencia en cada bloque");}
break;
case 100:
//#line 209 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con múltiples sentencias en cada bloque");}
break;
case 101:
//#line 210 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con una sola sentencia en THEN y múltiples sentencias en ELSE");}
break;
case 102:
//#line 211 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE con múltiples sentencias en THEN y una sola sentencia en ELSE");}
break;
case 106:
//#line 221 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 107:
//#line 222 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 108:
//#line 223 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 118:
//#line 243 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
break;
case 119:
//#line 244 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 123:
//#line 255 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 124:
//#line 259 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 125:
//#line 260 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 126:
//#line 261 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 1009 "Parser.java"
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
