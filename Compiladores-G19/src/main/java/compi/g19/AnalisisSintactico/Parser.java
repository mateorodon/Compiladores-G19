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
package compi.g19.AnalisisSintactico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import compi.g19.AnalisisLexico.*;
import compi.g19.GeneracionDeCodigo.*;
//#line 27 "Parser.java"




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
    5,    5,   21,   21,    6,    6,    6,   22,   22,   25,
    7,    7,    7,   23,   23,   26,   27,   27,   24,   24,
   24,   24,   28,   28,   29,   20,   20,   20,   20,   20,
   30,   30,   30,   30,   30,   31,   31,   31,   31,   31,
   31,   31,    8,    8,    8,    8,    8,    8,   10,   10,
   10,   10,   33,   33,   15,   15,   15,   35,   11,   11,
   11,   11,   11,   11,   11,   11,   11,   36,   36,   37,
   37,   37,   37,   37,   34,   34,   38,   38,   38,   38,
   38,   38,   18,   39,   40,   41,   42,   18,   18,   32,
   43,   43,   43,   12,   12,   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    3,    2,    2,    1,    2,    2,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    5,
    5,    4,    4,    1,    1,    8,    7,    7,    7,    7,
   12,   11,   11,   11,   10,    1,    1,    3,    6,    3,
    1,    1,    1,    1,    3,    2,    1,    3,    2,    0,
    8,    7,    6,    2,    1,    3,    1,    3,    3,    1,
    2,    0,    2,    1,    4,    3,    3,    1,    3,    3,
    3,    3,    1,    3,    3,    1,    1,    1,    4,    2,
    2,    5,    6,    6,    5,    5,    4,    5,    4,    4,
    3,    7,    1,    1,    2,    3,    2,    1,    7,    7,
    9,    9,    9,    9,    8,    8,    7,    2,    2,    3,
    4,    2,    2,    1,    3,    2,    1,    1,    1,    1,
    1,    1,    3,    0,    0,    0,    0,   11,    1,    3,
    3,    1,    1,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,   98,    0,    0,    0,   43,   44,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    4,
    6,    8,    9,   47,    0,    0,    0,    0,    2,   40,
    0,   77,    0,   78,    0,    0,   73,  133,   91,    0,
    0,    0,    0,    0,    1,    0,  136,    0,    0,    0,
    0,    0,    0,    0,   48,   46,    0,    0,    0,    0,
    0,    0,    0,  129,  124,    0,    0,    0,    0,   81,
    0,    0,    0,    0,   89,    0,   90,    0,    0,  134,
  135,    0,   87,    0,    0,    0,    0,    0,    0,    0,
   23,   22,   45,    0,   54,    0,    0,    0,    0,    0,
  117,  118,  119,  122,  121,  120,    0,    0,    0,   69,
    0,   70,    0,   74,   71,   75,   72,    0,    0,    0,
   86,    0,   85,   88,    0,    0,   97,    0,    0,   21,
   20,   95,    0,   64,    0,    0,    0,    0,    0,    0,
    0,  125,  114,    0,    0,    0,    0,    0,   79,    0,
    0,    0,   84,   83,    0,    0,  116,   96,    0,    0,
   53,   63,    0,   61,   50,    0,    0,    0,    0,    0,
    0,  112,    0,  113,    0,   82,   92,   36,   37,    0,
    0,    0,  115,    0,   59,    0,   52,    0,    0,  109,
   94,    0,   93,   99,    0,    0,  100,    0,  110,    0,
    0,    0,    0,    0,    0,   65,   51,    0,    0,    0,
    0,    0,  108,  106,  111,  105,    0,    0,    0,    0,
    0,  126,  101,  103,  104,  102,    0,    0,    0,    0,
    0,    0,    0,    0,   35,    0,    0,  127,   32,    0,
   34,   33,    0,   31,  128,
};
final static short yydgoto[] = {                          3,
   12,   13,   14,   15,   16,   46,   17,   18,   19,   20,
   21,   22,   23,   37,  111,   38,   39,   86,  201,   87,
   24,   25,   81,  155,  206,   82,   83,  156,  189,   56,
   57,   62,  214,  166,   26,  190,  167,  127,  119,  187,
  252,  263,   63,
};
final static short yysindex[] = {                      -230,
  383,  438,    0,  -33,    0,  438,  -19,  -57,    0,    0,
  -31,  398,    0,  -26,  -10, -177,    0,    0,    0,    0,
    0,    0,    0,    0,   19,   39,  407,  -43,  103, -221,
  422,   -6,   15, -174, -139, -145,   80,    0,    0,    0,
    0,    0,    0,    0, -122,  -12,   -7,   57,    0,    0,
   -2,    0, -180,    0,   10,  109,    0,    0,    0,  142,
  101,  104,  113,   72,    0,  126,    0,  356, -174,  -54,
  110,  -86,  -37,  453,    0,    0,  -77,    0,  -75,  -71,
  156,  166,  208,    0,    0,  213,  134,    2,  179,    0,
  119,  214,  237,  246,    0,  117,    0,  117,   20,    0,
    0,  -49,    0,   16,   48,   -9,  -33,  344,  319,  242,
    0,    0,    0,  430,    0,   42,   43, -170,  248,  294,
    0,    0,    0,    0,    0,    0,  117,  219,   54,    0,
  109,    0,  109,    0,    0,    0,    0,  359,   10,  117,
    0, -129,    0,    0,   57,  265,    0,  269,  347,    0,
    0,    0,  292,    0,   65,  430,  276,  430,  430,    0,
   10,    0,    0,  317,  346,  454,   73,   10,    0,  249,
  306,   10,    0,    0,   58,  -73,    0,    0,  296,  117,
    0,    0,  297,    0,    0,   83,  321,  299,  311,  -88,
  257,    0,  252,    0,  462,    0,    0,    0,    0, -222,
  120,  121,    0,  411,    0,  138,    0,  -50,    0,    0,
    0,  317,    0,    0,  317,  326,    0, -146,    0,  150,
 -146,  329,  -18,  360,  366,    0,    0,  386, -146, -146,
 -146, -146,    0,    0,    0,    0,  388,  377,   57,  399,
  403,    0,    0,    0,    0,    0,   57,  415,  417,   57,
   57,  248,  420,   57,    0,  425,  426,    0,    0,  428,
    0,    0,  432,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -154,    0,    0,    0,    0,    0,    0,
    0,  451,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  481,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  447,  204,    0,    0,    0,    0,
    1,    0,    0,    0,  116,   47,    0,    0,    0,  452,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -15,    0,    0,
  456,    0,    0,    0,    0,    0,    0,    0,   24,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  223,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   70,    0,   93,    0,    0,    0,    0,    0,  149,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  229,    0,  223,  223,  171,
  452,    0,    0,    0,    0,    0,    0,  -41,    0,    0,
    0,  139,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  279,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  159,  -36,  -35,  -21,  141,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  225,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   13,  410,    0,  433,  -24,    0,    0,    0,    0,  392,
    0,    0,    0,  476,  -58,    0,    0,  -81, -148,   44,
   91,    0,  397,  128,    0,    0,    0,    0,  -60,  125,
   56, -105,  -30,  -91,    0,  -69, -134,  309,    0,    0,
    0,    0,    0,
};
final static int YYTABLESIZE=738;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        123,
   76,   53,   34,  109,   27,   30,   29,  104,   36,  124,
  126,  125,  142,  162,   27,  112,  149,  123,   31,   29,
   32,  239,   80,   80,  146,   55,    1,  202,   55,  191,
   85,   77,   42,   79,   67,   53,    2,   29,   53,  222,
   64,   76,   76,   76,   76,   76,   68,   76,   43,  145,
  151,  223,   91,  157,   92,  198,  199,   30,   47,   76,
   76,   76,   76,  175,   80,   80,   80,   80,   80,   66,
   80,   55,   60,  193,   69,   68,   89,  230,   48,   44,
  232,   90,   80,   80,   80,   80,   78,   68,   88,   68,
   68,   68,   67,   80,   45,  183,   85,  157,  157,    9,
   10,   53,   42,    9,   10,   68,   68,   68,   68,  211,
   66,   35,   66,   66,   66,   38,  200,   42,   72,   61,
   74,  218,  213,   70,   71,  221,  173,  174,   66,   66,
   66,   66,  220,   67,   75,   67,   67,   67,   39,  138,
   96,  139,  229,   59,   97,  231,  258,   53,  135,  137,
   93,   67,   67,   67,   67,   94,   98,  249,  107,  102,
  217,   53,  161,   53,   99,  253,  100,  211,  256,  257,
  168,  105,  260,   11,   38,  106,   91,  212,   92,  113,
  213,   28,   95,  172,   91,  115,   92,  234,   10,  130,
  236,  114,  131,  124,  126,  125,  116,   39,  243,  244,
  245,  246,  103,   12,  198,  199,  117,  141,  121,  122,
  123,   56,   50,   51,   58,  131,  133,  107,   52,  107,
   27,   30,   33,  204,   28,   35,    5,   27,   30,  108,
   27,   30,    7,   27,   30,   29,  123,  123,   11,   27,
   30,   42,   29,  238,   76,   29,   84,   51,   29,   78,
   51,  118,   52,  120,   29,   52,   66,   76,   53,   76,
   76,   76,   12,  128,   76,   26,    9,   10,   76,  129,
   76,   76,  143,   76,   76,   76,   76,  140,   76,   76,
   80,   53,   80,   80,   80,  185,  186,   80,    9,   10,
   53,   80,   53,   80,   80,  161,   80,   80,   80,   80,
  152,   80,   80,   68,  144,   68,   68,   68,  158,  159,
   68,  169,   84,   51,   68,  170,   68,   68,   52,   68,
   68,   68,   68,  176,   68,   68,   66,  177,   66,   66,
   66,  180,  181,   66,  184,  198,  199,   66,  195,   66,
   66,  196,   66,   66,   66,   66,  197,   66,   66,   67,
  207,   67,   67,   67,  203,  205,   67,  209,   58,   51,
   67,  208,   67,   67,   52,   67,   67,   67,   67,  210,
   67,   67,   38,   51,  130,   51,    9,   10,   52,   38,
   52,  224,  225,   38,  233,   38,   38,  237,   38,   38,
   38,   38,  121,  122,  123,   39,  101,   28,   91,  171,
   92,   91,   39,   92,   28,  227,   39,   28,   39,   39,
   28,   39,   39,   39,   39,  107,   28,  235,  240,   54,
   54,   41,  107,   54,  241,  242,  107,  247,  107,  107,
   11,  107,  107,  107,  107,  248,   41,   11,  250,   54,
   41,   11,  251,   11,   11,   10,   11,   11,   11,   11,
    5,  226,   10,   91,  254,   92,   10,  255,   10,   10,
  259,   10,   10,   10,   10,  261,  262,   12,  264,  132,
   51,   12,  265,   12,   12,   52,   12,   12,   12,   12,
    3,   26,   54,   54,   54,   54,   49,   54,   26,   54,
   62,   26,  134,   51,   26,  132,   60,   54,   52,   57,
   26,  136,   51,   58,   51,  110,  110,   52,  107,   52,
   54,   73,  211,  107,  160,    5,  228,    0,   54,  219,
    5,    7,  215,  154,  153,  213,    7,   11,    0,  153,
    0,   54,   11,    0,  108,  116,   54,    0,    0,    0,
  148,  110,  116,    0,  108,    0,  116,  108,  116,  163,
  107,    0,  148,    0,  116,    0,    0,    5,  164,    0,
  165,    0,    0,    7,    0,  182,    0,  154,  154,   11,
    0,   54,  163,  107,  150,  107,    0,    0,    0,    0,
    5,  179,    5,  165,    0,  108,    7,    0,    7,  153,
    0,    0,   11,    0,   11,    0,  188,  148,  179,  147,
  107,  192,  107,  107,    0,    0,    0,    5,    0,    5,
    5,    0,    0,    7,  178,    7,    7,    0,    0,   11,
    0,   11,   11,  216,    0,  179,    0,  216,    0,    0,
   54,    0,    0,    0,    0,    0,    0,    0,   54,    4,
    0,   54,   54,   54,  188,   54,    5,  188,    0,    6,
    0,    0,    7,    8,    4,    0,    9,   10,   11,    0,
    0,    5,    0,    4,    0,   40,    0,    7,    8,    0,
    5,    9,   10,   11,   49,    0,    7,    8,    4,    0,
    9,   10,   11,    0,    0,    5,    4,    0,    0,   65,
    0,    7,    8,    5,    4,    9,   10,   11,    0,    7,
    8,    5,  153,    9,   10,   11,    0,    7,    8,  107,
  107,    9,   10,   11,    0,    0,    5,    5,  107,  108,
    0,  194,    7,    7,    0,    5,    0,    0,   11,   11,
    0,    7,    0,    0,  153,    0,    0,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   45,   60,   41,   41,   41,   40,   62,   40,   60,
   61,   62,   62,  119,    2,   74,  108,   59,    6,   41,
   40,   40,   47,    0,  106,   41,  257,  176,   44,  164,
   40,   44,   59,   41,   41,   45,  267,   40,   45,  262,
  262,   41,   42,   43,   44,   45,    0,   47,   59,   59,
  109,  200,   43,  114,   45,  278,  279,   91,   40,   59,
   60,   61,   62,  145,   41,   42,   43,   44,   45,    0,
   47,   28,   29,  165,   60,   32,  257,  212,   40,  257,
  215,  262,   59,   60,   61,   62,  257,   41,   91,   43,
   44,   45,    0,  118,  272,  156,   40,  158,  159,  274,
  275,   45,  257,  274,  275,   59,   60,   61,   62,  256,
   41,  257,   43,   44,   45,    0,   59,  272,  258,   29,
   41,  191,  269,   33,   34,  195,  256,  257,   59,   60,
   61,   62,  193,   41,  257,   43,   44,   45,    0,   96,
   40,   98,  212,   41,   41,  215,  252,   45,   93,   94,
   42,   59,   60,   61,   62,   47,   44,  239,    0,   69,
  191,   45,  119,   45,   93,  247,   41,  256,  250,  251,
  127,   62,  254,    0,   59,  262,   43,  266,   45,  257,
  269,   41,   41,  140,   43,  257,   45,  218,    0,   41,
  221,  267,   44,   60,   61,   62,   41,   59,  229,  230,
  231,  232,  257,    0,  278,  279,   41,  257,  259,  260,
  261,   41,  256,  257,   44,   91,   92,   59,  262,  257,
  257,  257,  280,  180,  258,  257,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  262,  257,  267,  256,  257,  270,  257,
  257,   44,  262,   41,  276,  262,  263,  257,   45,  259,
  260,  261,   59,  262,  264,   41,  274,  275,  268,   91,
  270,  271,  257,  273,  274,  275,  276,  258,  278,  279,
  257,   45,  259,  260,  261,  158,  159,  264,  274,  275,
   45,  268,   45,  270,  271,  252,  273,  274,  275,  276,
   59,  278,  279,  257,  257,  259,  260,  261,  267,  267,
  264,   93,  256,  257,  268,  262,  270,  271,  262,  273,
  274,  275,  276,   59,  278,  279,  257,   59,  259,  260,
  261,   40,  268,  264,   59,  278,  279,  268,  266,  270,
  271,   93,  273,  274,  275,  276,   41,  278,  279,  257,
  268,  259,  260,  261,   59,   59,  264,   59,  256,  257,
  268,   41,  270,  271,  262,  273,  274,  275,  276,   59,
  278,  279,  257,  257,  256,  257,  274,  275,  262,  264,
  262,  262,  262,  268,   59,  270,  271,   59,  273,  274,
  275,  276,  259,  260,  261,  257,   41,  257,   43,   41,
   45,   43,  264,   45,  264,  268,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  268,   59,   28,
   29,   12,  264,   32,   59,   40,  268,   40,  270,  271,
  257,  273,  274,  275,  276,   59,   27,  264,   40,   48,
   31,  268,   40,  270,  271,  257,  273,  274,  275,  276,
    0,   41,  264,   43,   40,   45,  268,   41,  270,  271,
   41,  273,  274,  275,  276,   41,   41,  264,   41,  256,
  257,  268,   41,  270,  271,  262,  273,  274,  275,  276,
    0,  257,   91,   92,   93,   94,   40,   96,  264,   98,
  268,  267,  256,  257,  270,   44,  268,  106,  262,   44,
  276,  256,  257,  256,  257,   73,   74,  262,  257,  262,
  119,   36,  256,  257,  118,  264,  208,   -1,  127,  268,
  264,  270,  266,  114,  273,  269,  270,  276,   -1,  273,
   -1,  140,  276,   -1,  256,  257,  145,   -1,   -1,   -1,
  108,  109,  264,   -1,  266,   -1,  268,  269,  270,  256,
  257,   -1,  120,   -1,  276,   -1,   -1,  264,  265,   -1,
  267,   -1,   -1,  270,   -1,  156,   -1,  158,  159,  276,
   -1,  180,  256,  257,  256,  257,   -1,   -1,   -1,   -1,
  264,  149,  264,  267,   -1,  267,  270,   -1,  270,  273,
   -1,   -1,  276,   -1,  276,   -1,  164,  165,  166,  256,
  257,  256,  257,  257,   -1,   -1,   -1,  264,   -1,  264,
  264,   -1,   -1,  270,  268,  270,  270,   -1,   -1,  276,
   -1,  276,  276,  191,   -1,  193,   -1,  195,   -1,   -1,
  239,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  247,  257,
   -1,  250,  251,  252,  212,  254,  264,  215,   -1,  267,
   -1,   -1,  270,  271,  257,   -1,  274,  275,  276,   -1,
   -1,  264,   -1,  257,   -1,  268,   -1,  270,  271,   -1,
  264,  274,  275,  276,  268,   -1,  270,  271,  257,   -1,
  274,  275,  276,   -1,   -1,  264,  257,   -1,   -1,  268,
   -1,  270,  271,  264,  257,  274,  275,  276,   -1,  270,
  271,  264,  273,  274,  275,  276,   -1,  270,  271,  257,
  257,  274,  275,  276,   -1,   -1,  264,  264,  257,  267,
   -1,  268,  270,  270,   -1,  264,   -1,   -1,  276,  276,
   -1,  270,   -1,   -1,  273,   -1,   -1,  276,
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
"list_variables : list_variables ID",
"list_variables : ID",
"encabezado_funcion : tipo FUN ID",
"encabezado_funcion : tipo FUN",
"$$1 :",
"declaracion_funcion : encabezado_funcion '(' parametro ')' BEGIN cuerpo_funcion $$1 END",
"declaracion_funcion : encabezado_funcion '(' bloque_list_parametro ')' BEGIN cuerpo_funcion END",
"declaracion_funcion : encabezado_funcion '(' ')' BEGIN cuerpo_funcion END",
"parametro : tipo ID",
"parametro : ID",
"bloque_list_parametro : list_parametro ',' parametro",
"list_parametro : parametro",
"list_parametro : list_parametro ',' parametro",
"cuerpo_funcion : list_sentencias_funcion sentencia_return ';'",
"cuerpo_funcion : list_sentencias_funcion",
"cuerpo_funcion : sentencia_return ';'",
"cuerpo_funcion :",
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
"encabezado_if : IF",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_bloque fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_bloque fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico",
"cuerpo_if_unico : sentencia_ejecutable ';'",
"cuerpo_if_unico : sentencia_return ';'",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables END",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables sentencia_return END",
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
"$$2 :",
"$$3 :",
"$$4 :",
"$$5 :",
"condicion : '(' $$2 bloque_list_expresiones $$3 ')' comparacion '(' $$4 bloque_list_expresiones $$5 ')'",
"condicion : error",
"bloque_list_expresiones : list_expresiones ',' expresion",
"list_expresiones : list_expresiones ',' expresion",
"list_expresiones : expresion",
"list_expresiones : error",
"salida_mensaje : OUTF '(' CADENA ')'",
"salida_mensaje : OUTF '(' expresion ')'",
"salida_mensaje : OUTF '(' ')'",
};

//#line 681 "gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;

static NodoComun raiz;
static String ambito = "main";
static boolean inIF = false;
static boolean hasReturn = false;
static boolean enFuncion = false;
static int cantReturns = 0;
static List<String> varDeclaradas = new ArrayList<>();
static String tipoActual;
static List<String> erroresSemanticos = new ArrayList<>();
static Map<String,String> tiposDeclarados = new HashMap<>(); //clave: lexema del tipo ; valor: tipo del tipo
public static Map<String,NodoComun> funcionesDeclaradas = new HashMap<>();
static List<Nodo> expresiones1 = new ArrayList<>();
static List<Nodo> expresiones2 = new ArrayList<>();
static boolean inList1 = false;
static boolean inList2 = false;

public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
      this.yylval = new ParserVal(t.getLexema().toString());
      return (int) t.getId();
    }
    return 0;
}

public static void yyerror(String error){
    AnalizadorLexico.agregarErrorSintactico(error);
}

public void addAmbito(String ambitoActual){
    ambito = ambito.concat(":" + ambitoActual);
}

public void removeAmbito(){
        int index = ambito.lastIndexOf(':');

        if (index != -1) {
            ambito = ambito.substring(0, index);
        }
}

private void chequeoFlotantesPositivos(String lexema){
    float valor = Float.parseFloat(lexema);
    if  ((valor != 0f) && (valor < AccionSemantica.SINGLE_POSITIVE_MIN || valor >= Float.POSITIVE_INFINITY)) {
        yyerror("Constante flotante fuera de rango");
    }
}

private boolean hayErrores(String lexema){
    return !erroresSemanticos.isEmpty();
}

public String buscarAmbito(String ambitoActual, String lexema) {
    String ambito = ambitoActual;

    while (!TablaSimbolos.existeSimbolo(lexema + ":" + ambito)) {
        if (ambito.equals("main")) {
            return "";
        }
        int index = ambito.lastIndexOf(':');
        if (index == -1) {
            return "";
        }

        ambito = ambito.substring(0, index); // Reduce el ámbito
    }
    
    return ambito;
}

public static void agregarErrorSemantico(String error){
    erroresSemanticos.add(error + " en la linea " + AnalizadorLexico.lineaAct);
}

public static void imprimirErroresSemanticos(){
    for (String e : erroresSemanticos)
        System.out.println(e);
}

private void variableYaDeclarada(String var){
    Token t1 = TablaSimbolos.getToken(var + ":" + ambito);
    switch (t1.getUso()) {
        case "variable":
            agregarErrorSemantico("Ya existe una variable con el nombre '" + var + "' definida en este ámbito");
            break;
        case "funcion":
            agregarErrorSemantico("Ya existe una función con el nombre '" + var + "' definida en este ámbito");
            break;
        case "tipo":
            agregarErrorSemantico("Ya existe un tipo con el nombre '" + var + "' definido en este ámbito");
            break;
        default:
            break;
    }
}

private NodoComun controlarTipos(Nodo nodo1, String op, Nodo nodo3){
    NodoComun ret = new NodoComun(op, nodo1, nodo3);
    if (!(nodo1.getLexema().contains("error") || nodo1.getLexema().contains("error"))) {
    if (!(nodo1.getTipo().equals(nodo3.getTipo())))
        agregarErrorSemantico("Incompatibilidad de tipos en la "+op);
    else
        ret.setTipo(nodo1.getTipo());
    }

    return ret;
}

private Nodo generarLlamadoFuncion(NodoComun funcion, Token copia){
    if (funcion != null){
        Nodo param = funcion.getIzq();
        if (param.getTipo().equals(copia.getTipo())){
            param.setValor(copia.getValor());
        }
        else {
            agregarErrorSemantico("El tipo del parametro real no coincide con el del parametro formal");
        }
    }
    return funcion;
}

public NodoComun getRaiz(){
    return this.raiz;
}

public static List<Nodo> getFuncionesDeclaradas(){
    return new ArrayList<>(funcionesDeclaradas.values());
}
//#line 713 "Parser.java"
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
//#line 20 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa"); raiz = new NodoComun("PROGRAMA", (Nodo)val_peek(1).obj);}
break;
case 2:
//#line 21 "gramatica.y"
{yyerror("El programa debe tener un nombre");}
break;
case 3:
//#line 22 "gramatica.y"
{yyerror("Falta delimitador END del programa");}
break;
case 4:
//#line 23 "gramatica.y"
{yyerror("Falta delimitador BEGIN del programa");}
break;
case 5:
//#line 24 "gramatica.y"
{yyerror("Faltan los delimitadores del programa");}
break;
case 6:
//#line 27 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo)val_peek(1).obj, (Nodo)val_peek(0).obj);}
break;
case 7:
//#line 28 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 8:
//#line 32 "gramatica.y"
{yyval.obj = new NodoHoja("Sentencia Declarativa");}
break;
case 9:
//#line 33 "gramatica.y"
{yyval=val_peek(1);}
break;
case 10:
//#line 34 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
//#line 35 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 12:
//#line 39 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");
                         for (String var: varDeclaradas){
                            Token t = TablaSimbolos.getToken(var);
                            if (!TablaSimbolos.existeSimbolo(var + ":" + ambito)){
                                String tipo = t.getTipo();
                                if (tipo != null){
                                    if (tipo.toLowerCase().equals(tipoActual.toLowerCase()))
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya esta declarada");
                                    else
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya estaba declarada. Se cambio su tipo a " + tipoActual);
                                }
                                t.getLexema().setLength(0);
                                t.getLexema().append(var).append(":").append(ambito);
                                t.setAmbito(ambito);
                                t.setUso("variable");
                                t.setTipo(tipoActual);
                                TablaSimbolos.removeToken(var);
                                TablaSimbolos.addSimbolo(t.getLexema().toString(),t);

                            }
                            else {
                                TablaSimbolos.removeToken(var);
                                variableYaDeclarada(var);
                                }
                         }
                         varDeclaradas = new ArrayList<>();
                        }
break;
case 13:
//#line 66 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
//#line 67 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
//#line 71 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion"); yyval=val_peek(0);}
break;
case 16:
//#line 72 "gramatica.y"
{yyval = val_peek(0); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 17:
//#line 73 "gramatica.y"
{yyval=val_peek(0);}
break;
case 18:
//#line 74 "gramatica.y"
{yyval=val_peek(0);}
break;
case 19:
//#line 75 "gramatica.y"
{yyval=val_peek(0);}
break;
case 20:
//#line 80 "gramatica.y"
{ yyval.obj = new NodoComun("For",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);}
break;
case 21:
//#line 81 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
//#line 82 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
//#line 83 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 24:
//#line 87 "gramatica.y"
{yyval=val_peek(0);}
break;
case 25:
//#line 88 "gramatica.y"
{yyval=val_peek(0);}
break;
case 26:
//#line 92 "gramatica.y"
{  String ambitoVar = buscarAmbito(ambito,val_peek(7).sval);
                                                                   NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                   if (ambitoVar.equals("")) {
                                                                       agregarErrorSemantico("La variable '" + val_peek(7).sval + "' no fue declarada");
                                                                       idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                   }
                                                                   else {
                                                                       Token t = TablaSimbolos.getToken(val_peek(7).sval + ":" + ambitoVar);
                                                                       if (!t.getTipo().equals(ENTERO)) {
                                                                           agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                           idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                       }
                                                                       else {
                                                                           idAsignacion = new NodoHoja(val_peek(7).sval + ":" + ambitoVar, t);
                                                                       }
                                                                   }

                                                                    NodoHoja constante = new NodoHoja(val_peek(5).sval);
                                                                    Nodo asignacion = new NodoComun(val_peek(6).sval, idAsignacion, constante); /*Cambie sval x obj esto tiraba error el Parser*/

                                                                    NodoHoja constanteUpDown = new NodoHoja(val_peek(0).sval);
                                                                    Nodo incremento = new NodoComun("Incremento", (Nodo)val_peek(1).obj, constanteUpDown); /*Idem*/
                                                                    Nodo condicion = (Nodo)val_peek(3).obj;

                                                                    Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento", asignacion, incremento);

                                                                    yyval.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condicion);

                                                                    AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");
                                                                }
break;
case 27:
//#line 122 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
//#line 123 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
//#line 124 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
//#line 125 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
//#line 129 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(11).sval);
                                                                                       NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                                       if (ambitoVar.equals("")) {
                                                                                            agregarErrorSemantico("La variable '" + val_peek(11).sval + "' no fue declarada");
                                                                                            idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                                       }
                                                                                       else {
                                                                                             Token t = TablaSimbolos.getToken(val_peek(11).sval + ":" + ambitoVar);
                                                                                             if (!t.getTipo().equals(ENTERO)) {
                                                                                                    agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                                                    idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                                             }
                                                                                             else {
                                                                                                    idAsignacion = new NodoHoja(val_peek(11).sval + ":" + ambitoVar);
                                                                                             }
                                                                                       }

                                                                                       Nodo asignacion = new NodoComun("Asignacion", idAsignacion, (Nodo)val_peek(9).obj); /*Cambie sval x obj*/
                                                                                       Nodo incremento = new NodoComun("Incremento", (Nodo)val_peek(5).obj, (Nodo)val_peek(4).obj); /*Idem*/
                                                                                       Nodo condicion = (Nodo)val_peek(7).obj;
                                                                                       Nodo iteradorCondicion = (Nodo)val_peek(1).obj;

                                                                                       Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento", asignacion, incremento);
                                                                                       Nodo condiciones = new NodoComun("Condiciones", condicion, iteradorCondicion);

                                                                                       yyval.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condiciones);

                                                                                       AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");
                                                                                       }
break;
case 32:
//#line 159 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
//#line 160 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
//#line 161 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
//#line 162 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 36:
//#line 166 "gramatica.y"
{yyval.obj = new NodoHoja("Up");}
break;
case 37:
//#line 167 "gramatica.y"
{yyval.obj = new NodoHoja("Down");}
break;
case 38:
//#line 171 "gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,val_peek(2).sval);
                              Nodo asignacion = null;
                              if (ambitoVar.equals("")){
                                  Token t = TablaSimbolos.getToken(val_peek(2).sval);
                                  if (t == null)
                                        agregarErrorSemantico("La variable '" + val_peek(2).sval + "' no fue declarada");
                                  else {
                                        String var = val_peek(2).sval;
                                        if (var.charAt(0) == 's' || var.charAt(0) == 'S')
                                            t.setTipo(FLOTANTE);
                                        if (var.charAt(0) == 'x' || var.charAt(0) == 'X' || var.charAt(0) == 'y'
                                        || var.charAt(0) == 'Y' || var.charAt(0) == 'z' || var.charAt(0) == 'Z')
                                            t.setTipo(ENTERO);
                                        t.getLexema().setLength(0);
                                        t.getLexema().append(var).append(":").append(ambito);
                                        t.setAmbito(ambito);
                                        t.setUso("variable");
                                        TablaSimbolos.removeToken(var);
                                        TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                  }
                              }
                              else {
                                  Token t = TablaSimbolos.getToken(val_peek(2).sval + ":" + ambitoVar);
                                  if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))){
                                    agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")" );
                                    asignacion = new NodoHoja("error semantico");
                                  }else {
                                    NodoHoja id = new NodoHoja(val_peek(2).sval +":"+ambitoVar, t);
                                    asignacion= new NodoComun(val_peek(1).sval ,id, (Nodo)val_peek(0).obj);
                                  }
                              }
                              yyval.obj = asignacion;
                            }
break;
case 40:
//#line 205 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 42:
//#line 210 "gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
           if (ambitoVar.equals(""))
                agregarErrorSemantico("El tipo '" + val_peek(0).sval + "' no fue declarado");
           else {
            Token t = TablaSimbolos.getToken(val_peek(0).sval + ":" + ambitoVar);
            if (t.getUso() == null || !t.getUso().equals("tipo"))
                yyerror("El identificador '" + val_peek(0).sval + "' no es un tipo definido");
            else {
                tipoActual = val_peek(0).sval;
            }
            }
         }
break;
case 43:
//#line 225 "gramatica.y"
{tipoActual = ENTERO;}
break;
case 44:
//#line 226 "gramatica.y"
{tipoActual = FLOTANTE;}
break;
case 45:
//#line 230 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 46:
//#line 231 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 47:
//#line 232 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 48:
//#line 236 "gramatica.y"
{hasReturn = false;
                enFuncion = true;
                String idFuncion = val_peek(0).sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (!TablaSimbolos.existeSimbolo(idFuncion + ":" + ambito)){
                    t.getLexema().setLength(0);
                    t.getLexema().append(idFuncion).append(":").append(ambito); /*aca agrega una vez el ambito*/
                    t.setAmbito(ambito);
                    t.setUso("funcion");
                    t.setTipo(tipoActual);
                    TablaSimbolos.removeToken(idFuncion);
                    TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                 }
                 else {
                    TablaSimbolos.removeToken(idFuncion);
                    variableYaDeclarada(idFuncion);
                 }
                 NodoComun encabezado = new NodoComun(idFuncion + ":" + ambito);
                 encabezado.setTipo(tipoActual);
                 addAmbito(idFuncion);
                 yyval.obj = encabezado;
                 }
break;
case 49:
//#line 258 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 50:
//#line 262 "gramatica.y"
{ if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         Nodo parametro = (Nodo)val_peek(3).obj;
                                                         Token t = TablaSimbolos.getToken(parametro.getNombre());
                                                         if (!TablaSimbolos.existeSimbolo(parametro.getNombre() + ":" + ambito)){
                                                             String tipo = t.getTipo();
                                                             if (tipo != null)
                                                                AnalizadorLexico.agregarWarning("La variable '" + parametro.getNombre() + "' ya esta declarada");
                                                             t.getLexema().setLength(0);
                                                             t.getLexema().append(parametro.getNombre()).append(":").append(ambito);
                                                             t.setAmbito(ambito);
                                                             t.setUso("parametro");
                                                             t.setTipo(tipoActual);
                                                             TablaSimbolos.removeToken(parametro.getNombre());
                                                             TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                                         }
                                                         NodoComun funcion = (NodoComun)val_peek(5).obj; /*Encabezado con nombre funcion, este tiene el tipo*/

                                                         funcion.setIzq(parametro); /*Parametro*/
                                                         funcion.setDer((Nodo)val_peek(0).obj); /*Cuerpo funcion*/

                                                         funcionesDeclaradas.put(funcion.getNombre(),funcion);
                                                         removeAmbito();
                                                         enFuncion = false;
                                                         }
break;
case 52:
//#line 288 "gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 53:
//#line 289 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 54:
//#line 293 "gramatica.y"
{
               Token t = TablaSimbolos.getToken(val_peek(0).sval);
               if (t != null){
                   t.getLexema().setLength(0);
                   t.getLexema().append(val_peek(0).sval).append(":").append(ambito);
                   t.setAmbito(ambito);
                   t.setUso("parametro");
                   t.setTipo(tipoActual);
                   TablaSimbolos.removeToken(val_peek(0).sval);
                   TablaSimbolos.addSimbolo(String.valueOf(t.getLexema()),t);
               }
              Nodo param = new NodoHoja(val_peek(0).sval);
              param.setTipo(val_peek(1).sval);
              yyval.obj = param;
            }
break;
case 55:
//#line 308 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 59:
//#line 321 "gramatica.y"
{  yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);
                                                    hasReturn = true;}
break;
case 60:
//#line 323 "gramatica.y"
{yyval=val_peek(0);}
break;
case 61:
//#line 324 "gramatica.y"
{yyval=val_peek(1); hasReturn = true;}
break;
case 62:
//#line 325 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio");}
break;
case 63:
//#line 330 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(1).obj, (Nodo) val_peek(0).obj);}
break;
case 64:
//#line 331 "gramatica.y"
{yyval=val_peek(0);}
break;
case 65:
//#line 336 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           yyval.obj = new NodoComun("Return", (Nodo)val_peek(1).obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 66:
//#line 344 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(val_peek(2).sval);
                            Nodo nIzq = new NodoHoja(val_peek(2).sval, tIzq);

                            Token tDer = TablaSimbolos.getToken(val_peek(0).sval);
                            Nodo nDer = new NodoHoja(val_peek(0).sval, tDer);

                            yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                          }
break;
case 67:
//#line 353 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(val_peek(2).sval);
                              Nodo nIzq = new NodoHoja(val_peek(2).sval, tIzq);

                              Token tDer = TablaSimbolos.getToken(val_peek(0).sval);
                              Nodo nDer = new NodoHoja(val_peek(0).sval, tDer);

                              yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                             }
break;
case 68:
//#line 361 "gramatica.y"
{yyval = val_peek(0);}
break;
case 69:
//#line 362 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 70:
//#line 363 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
//#line 367 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(val_peek(2).sval);
                         Nodo nIzq = new NodoHoja(val_peek(2).sval, tIzq);

                         Token tDer = TablaSimbolos.getToken(val_peek(0).sval);
                         Nodo nDer = new NodoHoja(val_peek(0).sval, tDer);

                         yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                        }
break;
case 72:
//#line 375 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(val_peek(2).sval);
                           Nodo nIzq = new NodoHoja(val_peek(2).sval, tIzq);

                           Token tDer = TablaSimbolos.getToken(val_peek(0).sval);
                           Nodo nDer = new NodoHoja(val_peek(0).sval, tDer);

                           yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                          }
break;
case 73:
//#line 383 "gramatica.y"
{yyval = val_peek(0);}
break;
case 74:
//#line 384 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 75:
//#line 385 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 76:
//#line 389 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La variable '" + val_peek(0).sval + "' no fue declarada");
            Nodo aux = new NodoHoja(val_peek(0).sval);
            yyval.obj = aux;
        }
        else {
            Token t = TablaSimbolos.getToken(val_peek(0).sval + ":" + ambitoVar);
            if (!(t.getUso().equals("variable") || t.getUso().equals("parametro")))
                agregarErrorSemantico("'" + val_peek(0).sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                Nodo aux = new NodoHoja(val_peek(0).sval+":"+ambitoVar, t);
                yyval.obj = aux;
                TablaSimbolos.removeToken(val_peek(0).sval);
            }
        }
        }
break;
case 77:
//#line 406 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                t.setValor(val_peek(0).sval);
                t.setUso("constante");
                yyval.obj = new NodoHoja(val_peek(0).sval,t);
                }
break;
case 78:
//#line 411 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 79:
//#line 412 "gramatica.y"
{    String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + val_peek(3).sval + "' no fue declarada");
                                    yyval.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken(val_peek(3).sval + ":" + ambitoVar);
                                    String tipo = t.getTipo();
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja(val_peek(3).sval + val_peek(2).sval + val_peek(1).sval + val_peek(0).sval);
                                        nodo.setTipo(tipoTriple);
                                        yyval.obj = nodo;
                                    }
                                    else {
                                        agregarErrorSemantico("La variable '" + val_peek(3).sval + "' no es de un tipo TRIPLE definido");
                                        yyval.obj = new NodoHoja("error");
                                    }
                                }
                             String index = TablaSimbolos.getToken(val_peek(1).sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3"))))
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 yyval.obj = new NodoHoja("error");
                            }
break;
case 80:
//#line 436 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + val_peek(0).sval + "' no fue declarada");
                         yyval.obj = new NodoHoja("error");
                     }
                     else {
                         Token t = TablaSimbolos.getToken(val_peek(0).sval + ":" + ambitoVar);
                         if (!t.getUso().equals("variable"))
                             agregarErrorSemantico("'" + val_peek(0).sval + "' no es una variable. Es un/a " + t.getUso());
                         else {
                             yyval.obj = new NodoHoja(val_peek(0).sval + ":" + ambitoVar,t);
                             TablaSimbolos.removeToken(val_peek(0).sval);
                         }
                     }
                     }
break;
case 81:
//#line 451 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                                        if (t != null && t.getTipo().equals(ENTERO)) {
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                                            yyval.obj = new NodoHoja("error");
                                        }
                                        else if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                            String lexema = t.getLexema().toString();
                                            chequeoFlotantesPositivos(lexema);
                                            t.setUso("constante");
                                            t.setValor(val_peek(1).sval + val_peek(0).sval);
                                            yyval.obj = new NodoHoja(val_peek(1).sval + val_peek(0).sval,t);
                                        }

                    }
break;
case 82:
//#line 465 "gramatica.y"
{yyval.obj = new NodoHoja("hola");}
break;
case 83:
//#line 469 "gramatica.y"
{String idTipo = val_peek(0).sval;
                                         Token t = TablaSimbolos.getToken(idTipo);
                                         if (!TablaSimbolos.existeSimbolo(idTipo + ":" + ambito)){
                                            t.getLexema().setLength(0);
                                            t.getLexema().append(idTipo).append(":").append(ambito);
                                            t.setAmbito(ambito);
                                            t.setUso("tipo");
                                            t.setTipo(val_peek(2).sval);
                                            TablaSimbolos.removeToken(idTipo);
                                            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                            tiposDeclarados.put(val_peek(0).sval, val_peek(2).sval);
                                            }
                                         else {
                                            TablaSimbolos.removeToken(idTipo);
                                            variableYaDeclarada(idTipo);
                                         }
                                         }
break;
case 84:
//#line 486 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 85:
//#line 487 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 86:
//#line 488 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 87:
//#line 489 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 88:
//#line 490 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 89:
//#line 494 "gramatica.y"
{
        String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
        if (ambitoVar.equals(""))
            agregarErrorSemantico("La funcion '" + val_peek(3).sval + "' no fue declarada");
        else {
        if (funcionesDeclaradas.containsKey(val_peek(3).sval + ":" + ambitoVar)){
            Nodo exp = (Nodo)val_peek(1).obj;
            Token copiaValor = new Token(exp.getToken());
            NodoComun funcion = funcionesDeclaradas.get(val_peek(3).sval + ":" + ambitoVar);
            yyval.obj = generarLlamadoFuncion(funcion,copiaValor);
        }
        else {
            agregarErrorSemantico("La funcion '" + val_peek(3).sval + "' no fue declarada");
        }
     }
        }
break;
case 90:
//#line 510 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 91:
//#line 511 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 92:
//#line 512 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 94:
//#line 517 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 95:
//#line 521 "gramatica.y"
{yyval=val_peek(1);}
break;
case 96:
//#line 522 "gramatica.y"
{yyval=val_peek(1);}
break;
case 97:
//#line 523 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 98:
//#line 527 "gramatica.y"
{inIF=true; yyval=val_peek(0);}
break;
case 99:
//#line 531 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; Nodo cuerpo = new NodoComun("Cuerpo",(Nodo)val_peek(1).obj);
                                                                                                                                              yyval.obj = new NodoComun("If", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 100:
//#line 533 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)val_peek(1).obj);
                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 101:
//#line 537 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false;  NodoComun nThen = new NodoComun("Then", (Nodo)val_peek(3).obj);
                                                                                                                                                                          NodoComun nElse = new NodoComun("Else", (Nodo)val_peek(1).obj);
                                                                                                                                                                          Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)val_peek(6).obj,cuerpo);
                                                                                                                                                                          if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                               hasReturn = true;
                                                                                                                                                                          }
                                                                                                                                                                          cantReturns = 0;
                                                                                                                                                                          }
break;
case 102:
//#line 547 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)val_peek(3).obj);
                                                                                                                                                                    NodoComun nElse = new NodoComun("Else", (Nodo)val_peek(1).obj);
                                                                                                                                                                    Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                    yyval.obj = new NodoComun("If", (Nodo)val_peek(6).obj,cuerpo);
                                                                                                                                                                    if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                    }
                                                                                                                                                                    cantReturns = 0;
                                                                                                                                                                    }
break;
case 103:
//#line 557 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)val_peek(3).obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("Else", (Nodo)val_peek(1).obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                   yyval.obj = new NodoComun("If", (Nodo)val_peek(6).obj,cuerpo);

                                                                                                                                                                   if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                   }
                                                                                                                                                                   cantReturns = 0;
                                                                                                                                                                   }
break;
case 104:
//#line 568 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)val_peek(3).obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("Else", (Nodo)val_peek(1).obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                   yyval.obj = new NodoComun("If", (Nodo)val_peek(6).obj,cuerpo);

                                                                                                                                                                   if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                   }
                                                                                                                                                                   cantReturns = 0;
                                                                                                                                                                   }
break;
case 105:
//#line 578 "gramatica.y"
{yyerror("Falta THEN en IF");}
break;
case 106:
//#line 579 "gramatica.y"
{yyerror("Falta ELSE en IF");}
break;
case 107:
//#line 580 "gramatica.y"
{yyerror("Falta END_IF en IF");}
break;
case 108:
//#line 585 "gramatica.y"
{yyval = val_peek(1);}
break;
case 109:
//#line 586 "gramatica.y"
{yyval = val_peek(1); cantReturns++;}
break;
case 110:
//#line 590 "gramatica.y"
{yyval = val_peek(1);}
break;
case 111:
//#line 591 "gramatica.y"
{yyval = val_peek(2); cantReturns++;}
break;
case 112:
//#line 592 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 113:
//#line 593 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 114:
//#line 594 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 115:
//#line 598 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 116:
//#line 599 "gramatica.y"
{yyval = val_peek(1);}
break;
case 117:
//#line 604 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 118:
//#line 605 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 119:
//#line 606 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 120:
//#line 607 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 121:
//#line 608 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 122:
//#line 609 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 123:
//#line 613 "gramatica.y"
{yyval.obj = new NodoComun(val_peek(1).sval, (Nodo)val_peek(2).obj, (Nodo)val_peek(0).obj);}
break;
case 124:
//#line 614 "gramatica.y"
{inList1 = true;}
break;
case 125:
//#line 614 "gramatica.y"
{inList1 = false;}
break;
case 126:
//#line 614 "gramatica.y"
{inList2 = true;}
break;
case 127:
//#line 614 "gramatica.y"
{inList2 = false;}
break;
case 128:
//#line 615 "gramatica.y"
{ yyval.obj = new NodoComun(val_peek(7).sval, (Nodo)val_peek(9).obj, (Nodo)val_peek(7).obj);
      AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
      if (expresiones1.size() == expresiones2.size()){
        for (int i = 0; i < expresiones1.size(); i++) {
            Nodo exp1 = expresiones1.get(i);
            Nodo exp2 = expresiones2.get(i);
            if (!(exp1.getTipo().equals(exp2.getTipo())))
                agregarErrorSemantico("Las expresiones en la posicion " + i + " no tienen el mismo tipo");
        }
      }
      else {
        agregarErrorSemantico("La cantidad de elementos a comparar en pattern matching no coincide");
      }
      expresiones1.clear();
      expresiones2.clear();
    }
break;
case 129:
//#line 632 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 130:
//#line 637 "gramatica.y"
{
    if (inList1)
            expresiones1.add((Nodo)val_peek(0).obj);
        if (inList2)
            expresiones2.add((Nodo)val_peek(0).obj);
    yyval = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 131:
//#line 647 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 132:
//#line 654 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval=val_peek(0);
    }
break;
case 133:
//#line 661 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 134:
//#line 665 "gramatica.y"
{   yyval.obj = new NodoComun("Outf", new NodoHoja(val_peek(1).sval));
                            Token t = TablaSimbolos.getToken(val_peek(1).sval); /*Obtenemos el token, faltaba esto*/
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 135:
//#line 671 "gramatica.y"
{   yyval.obj = new NodoComun("Outf", new NodoHoja(val_peek(1).sval));
                                 Token t = TablaSimbolos.getToken(val_peek(1).sval); /*Obtenemos el token, faltaba esto*/
                                 t.setUso("mensaje");
                                 t.setTipo("cadena");
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }
break;
case 136:
//#line 677 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 1777 "Parser.java"
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
