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
   37,   37,   37,   34,   34,   38,   38,   38,   38,   38,
   38,   18,   18,   18,   32,   39,   39,   39,   12,   12,
   12,
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
    2,    2,    1,    3,    2,    1,    1,    1,    1,    1,
    1,    3,    7,    1,    3,    3,    1,    1,    4,    4,
    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,   98,    0,    0,    0,   43,   44,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    4,
    6,    8,    9,   47,    0,    0,    0,    0,    2,   40,
    0,   77,    0,   78,    0,    0,   73,  128,   91,    0,
    0,    0,    0,    0,    1,    0,  131,    0,    0,    0,
    0,    0,    0,    0,   48,   46,    0,    0,    0,    0,
    0,    0,    0,  124,    0,    0,    0,    0,    0,   81,
    0,    0,    0,    0,   89,    0,   90,    0,    0,  129,
  130,    0,   87,    0,    0,    0,    0,    0,    0,    0,
   23,   22,   45,    0,   54,    0,    0,    0,    0,    0,
    0,  116,  117,  118,  121,  120,  119,    0,    0,    0,
   69,    0,   70,    0,   74,   71,   75,   72,    0,    0,
    0,   86,    0,   85,   88,    0,    0,   97,    0,    0,
   21,   20,   95,    0,   64,    0,    0,    0,    0,    0,
    0,    0,  113,    0,    0,    0,    0,    0,   79,    0,
    0,    0,   84,   83,    0,    0,  115,   96,    0,    0,
   53,   63,    0,   61,   50,    0,    0,    0,    0,    0,
    0,  111,    0,  112,    0,   82,   92,   36,   37,    0,
    0,    0,  114,    0,   59,    0,   52,    0,    0,  109,
   94,    0,   93,   99,    0,    0,  100,    0,  110,    0,
    0,    0,    0,    0,   65,   51,    0,    0,    0,    0,
    0,  108,  106,  105,    0,    0,    0,    0,    0,  123,
  101,  103,  104,  102,    0,    0,    0,    0,    0,    0,
    0,   35,    0,    0,   32,    0,   34,   33,   31,
};
final static short yydgoto[] = {                          3,
   12,   13,   14,   15,   16,   46,   17,   18,   19,   20,
   21,   22,   23,   37,  111,   38,   39,   86,  201,   87,
   24,   25,   81,  156,  206,   82,   83,  157,  189,   56,
   57,   62,  214,  166,   26,  190,  167,  128,   63,
};
final static short yysindex[] = {                      -145,
  369,  436,    0,  -32,    0,  436,  -19,   -2,    0,    0,
  -15,  378,    0,  -29,   14, -176,    0,    0,    0,    0,
    0,    0,    0,    0,   42,   58,  405,   34,  103, -187,
  420,  -38,  -58, -151, -153, -154,   76,    0,    0,    0,
    0,    0,    0,    0, -124,  -34,   -7,   -5,    0,    0,
  -13,    0, -229,    0,   -6,    9,    0,    0,    0,  125,
  111,  102,  112,   65,    0,  120,    0,  359, -151,  -43,
  105,  -89,  -37,  394,    0,    0,  -88,    0,  -86,  -69,
  156,  167,  169,    0,   80,  213,  134,  -47,  165,    0,
  119,  126,  162,  164,    0,  117,    0,  117,    6,    0,
    0,    2,    0,   25,   32,   -9,  -32,  342,  227,  234,
    0,    0,    0,  428,    0,   38,   45, -155,   -6,  260,
  310,    0,    0,    0,    0,    0,    0,  117,  223,   57,
    0,    9,    0,    9,    0,    0,    0,    0,  445,   -6,
  117,    0, -107,    0,    0,   -5,  265,    0,  269,  -92,
    0,    0,    0,  295,    0,   71,  428,  288,  428,  428,
    0,  -49,    0,  337,  358,  -77,   85,   -6,    0,  262,
  315,   -6,    0,    0,   35,  -73,    0,    0,  299,  117,
    0,    0,  303,    0,    0,  129,  330,  326,  347, -109,
  289,    0,  332,    0,  197,    0,    0,    0,    0, -152,
  160,  163,    0,  464,    0,  133,    0,   80,    0,    0,
    0,  337,    0,    0,  337,  382,    0, -128,    0, -128,
  384,  -18,  397,  399,    0,    0,  387, -128, -128, -128,
 -128,    0,    0,    0,  429,  407,   -5,  441,  447,    0,
    0,    0,    0,    0,   -5,  456,  435,   -5,   -5,  444,
   -5,    0,  457,  461,    0,  469,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -168,    0,    0,    0,    0,    0,    0,
    0,  511,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  518,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  483,  204,    0,    0,    0,    0,
    1,    0,    0,    0,  116,   47,    0,    0,    0,  484,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -12,    0,    0,
  487,    0,    0,    0,    0,    0,    0,    0,   24,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  259,    0,    0,    0,    0,  484,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   70,    0,   93,    0,    0,    0,    0,    0,  101,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  271,    0,  259,  259,
  229,    0,    0,    0,    0,    0,    0,  -41,    0,    0,
    0,  139,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  256,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  159,
  -36,  -35,  -21,  141,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  225,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   74,   26,    0,  426,  -31,    0,    0,    0,    0,  423,
    0,    0,    0,  497,  -60,    0,    0,  293, -159,  408,
   66,    0,  419,  127,    0,    0,    0,    0, -105,  218,
  239,  -62,  -28,  -93,    0,  -94, -138,  381,    0,
};
final static int YYTABLESIZE=712;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        122,
   76,   69,   67,  109,   27,   30,   53,   29,  158,   77,
  125,  127,  126,  112,  150,   80,  202,  122,  104,   29,
   32,  237,  120,   80,   36,  191,   29,   89,   55,   42,
   85,   55,   90,   79,   85,   53,   91,   41,   92,   53,
  222,   76,   76,   76,   76,   76,   68,   76,  152,  146,
   93,  183,   41,  158,  158,   94,   41,   34,   30,   76,
   76,   76,   76,  143,   80,   80,   80,   80,   80,   66,
   80,  193,   43,  229,   64,   27,  231,   88,   53,   31,
   44,   47,   80,   80,   80,   80,   80,   68,   42,   68,
   68,   68,   67,  200,   61,   45,  218,   48,   70,   71,
  220,   78,   35,   42,   72,   68,   68,   68,   68,  221,
   66,    1,   66,   66,   66,   38,   74,  228,    9,   10,
  230,    2,    9,   10,   53,  198,  199,  211,   66,   66,
   66,   66,   75,   67,  102,   67,   67,   67,   39,  155,
  213,  125,   97,   59,  126,  227,  211,   53,  173,  174,
   96,   67,   67,   67,   67,   98,  212,   99,  107,  213,
  100,   53,  217,   53,  107,   95,  105,   91,  113,   92,
   53,    5,  106,   11,   38,  178,   91,    7,   92,  107,
  114,   28,  182,   11,  155,  155,    5,  115,   10,  233,
  194,  234,    7,  125,  127,  126,  116,   39,   11,  241,
  242,  243,  244,   12,  198,  199,   53,  117,   53,  122,
  123,  124,  118,  103,  129,    9,   10,  107,   51,  107,
   27,   30,   76,   52,   66,   28,    5,   27,   30,  108,
   27,   30,    7,   27,   30,   29,  122,  122,   11,   27,
   30,   35,   29,  236,   42,   29,   84,   51,   29,   78,
   84,   51,   52,  121,   29,  130,   52,   76,  142,   76,
   76,   76,   12,  141,   76,   26,    9,   10,   76,   56,
   76,   76,   58,   76,   76,   76,   76,   33,   76,   76,
   80,  144,   80,   80,   80,  185,  186,   80,  145,   50,
   51,   80,  153,   80,   80,   52,   80,   80,   80,   80,
  162,   80,   80,   68,  159,   68,   68,   68,  132,  134,
   68,  160,  198,  199,   68,  169,   68,   68,  170,   68,
   68,   68,   68,  176,   68,   68,   66,  177,   66,   66,
   66,  136,  138,   66,  180,   58,   51,   66,  181,   66,
   66,   52,   66,   66,   66,   66,  184,   66,   66,   67,
  195,   67,   67,   67,  196,  197,   67,  203,   58,   51,
   67,  205,   67,   67,   52,   67,   67,   67,   67,  208,
   67,   67,   38,   51,  131,   51,    9,   10,   52,   38,
   52,  133,   51,   38,  209,   38,   38,   52,   38,   38,
   38,   38,  122,  123,  124,   39,  207,   28,  147,  101,
  226,   91,   39,   92,   28,  210,   39,   28,   39,   39,
   28,   39,   39,   39,   39,  107,   28,  135,   51,  137,
   51,  223,  107,   52,  224,   52,  107,  240,  107,  107,
   11,  107,  107,  107,  107,   55,   60,   11,  175,   68,
  232,   11,  235,   11,   11,   10,   11,   11,   11,   11,
   54,   54,   10,  107,   54,  238,   10,  239,   10,   10,
    5,   10,   10,   10,   10,  246,    7,   12,  245,  154,
   54,   12,   11,   12,   12,  252,   12,   12,   12,   12,
  248,   26,  151,  107,  255,  171,  249,   91,   26,   92,
    5,   26,  119,  108,   26,  251,    7,  257,  110,  110,
   26,  258,   11,  139,  225,  140,   91,   54,   92,  259,
    5,  108,  115,   54,   54,   54,   54,    3,   54,  115,
   54,  108,   49,  115,  108,  115,   62,  127,   54,  247,
   57,  115,   73,  149,  110,  168,  161,  250,   60,    0,
  253,  254,  187,  256,  211,  107,  149,    0,  172,    0,
   54,    0,    5,    0,  215,    0,    0,  213,    7,    0,
    0,  154,    0,   54,   11,  163,  107,    0,   54,    0,
    0,    0,    0,    5,  164,  179,  165,    0,    0,    7,
    0,    0,    0,    0,    0,   11,    0,  204,  107,  188,
  149,  179,  163,  107,    0,    5,    0,  148,  107,  219,
    5,    7,   54,  165,    0,    5,    7,   11,    0,  154,
    0,    7,   11,  192,  107,  119,  216,   11,  179,    0,
  216,    5,    0,    0,    0,    4,    0,    7,    0,    0,
   54,    0,    5,   11,    4,    6,    0,  188,    7,    8,
  188,    5,    9,   10,   11,   40,    0,    7,    8,    0,
  107,    9,   10,   11,    0,    0,    0,    5,    0,   54,
  108,    4,    0,    7,    0,    0,    0,   54,    5,   11,
   54,   54,   49,   54,    7,    8,    4,    0,    9,   10,
   11,    0,    0,    5,    4,    0,    0,   65,    0,    7,
    8,    5,    4,    9,   10,   11,    0,    7,    8,    5,
  154,    9,   10,   11,    0,    7,    8,    0,    0,    9,
   10,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   60,   41,   41,   41,   41,   45,   40,  114,   44,
   60,   61,   62,   74,  108,   47,  176,   59,   62,   41,
   40,   40,   85,    0,   40,  164,   40,  257,   41,   59,
   40,   44,  262,   41,   40,   45,   43,   12,   45,   45,
  200,   41,   42,   43,   44,   45,    0,   47,  109,   59,
   42,  157,   27,  159,  160,   47,   31,   60,   91,   59,
   60,   61,   62,   62,   41,   42,   43,   44,   45,    0,
   47,  165,   59,  212,  262,    2,  215,   91,   45,    6,
  257,   40,   59,   60,   61,   62,  118,   41,  257,   43,
   44,   45,    0,   59,   29,  272,  191,   40,   33,   34,
  195,  257,  257,  272,  258,   59,   60,   61,   62,  262,
   41,  257,   43,   44,   45,    0,   41,  212,  274,  275,
  215,  267,  274,  275,   45,  278,  279,  256,   59,   60,
   61,   62,  257,   41,   69,   43,   44,   45,    0,  114,
  269,   41,   41,   41,   44,  208,  256,   45,  256,  257,
   40,   59,   60,   61,   62,   44,  266,   93,    0,  269,
   41,   45,  191,   45,  257,   41,   62,   43,  257,   45,
   45,  264,  262,    0,   59,  268,   43,  270,   45,  257,
  267,   41,  157,  276,  159,  160,  264,  257,    0,  218,
  268,  220,  270,   60,   61,   62,   41,   59,  276,  228,
  229,  230,  231,    0,  278,  279,   45,   41,   45,  259,
  260,  261,   44,  257,  262,  274,  275,   59,  257,  257,
  257,  257,  257,  262,  263,  258,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  262,  257,  267,  256,  257,  270,  257,
  256,  257,  262,   41,  276,   91,  262,  257,  257,  259,
  260,  261,   59,  258,  264,   41,  274,  275,  268,   41,
  270,  271,   44,  273,  274,  275,  276,  280,  278,  279,
  257,  257,  259,  260,  261,  159,  160,  264,  257,  256,
  257,  268,   59,  270,  271,  262,  273,  274,  275,  276,
   41,  278,  279,  257,  267,  259,  260,  261,   91,   92,
  264,  267,  278,  279,  268,   93,  270,  271,  262,  273,
  274,  275,  276,   59,  278,  279,  257,   59,  259,  260,
  261,   93,   94,  264,   40,  256,  257,  268,  268,  270,
  271,  262,  273,  274,  275,  276,   59,  278,  279,  257,
  266,  259,  260,  261,   93,   41,  264,   59,  256,  257,
  268,   59,  270,  271,  262,  273,  274,  275,  276,   40,
  278,  279,  257,  257,  256,  257,  274,  275,  262,  264,
  262,  256,  257,  268,   59,  270,  271,  262,  273,  274,
  275,  276,  259,  260,  261,  257,  268,  257,  106,   41,
  268,   43,  264,   45,  264,   59,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  256,  257,  256,
  257,  262,  264,  262,  262,  262,  268,   41,  270,  271,
  257,  273,  274,  275,  276,   28,   29,  264,  146,   32,
   59,  268,   59,  270,  271,  257,  273,  274,  275,  276,
   28,   29,  264,  257,   32,   59,  268,   59,  270,  271,
  264,  273,  274,  275,  276,   59,  270,  264,   40,  273,
   48,  268,  276,  270,  271,   41,  273,  274,  275,  276,
   40,  257,  256,  257,   41,   41,   40,   43,  264,   45,
  264,  267,   85,  267,  270,   40,  270,   41,   73,   74,
  276,   41,  276,   96,   41,   98,   43,   85,   45,   41,
    0,  256,  257,   91,   92,   93,   94,    0,   96,  264,
   98,  266,   40,  268,  269,  270,  268,   44,  106,  237,
   44,  276,   36,  108,  109,  128,  118,  245,  268,   -1,
  248,  249,  162,  251,  256,  257,  121,   -1,  141,   -1,
  128,   -1,  264,   -1,  266,   -1,   -1,  269,  270,   -1,
   -1,  273,   -1,  141,  276,  256,  257,   -1,  146,   -1,
   -1,   -1,   -1,  264,  265,  150,  267,   -1,   -1,  270,
   -1,   -1,   -1,   -1,   -1,  276,   -1,  180,  257,  164,
  165,  166,  256,  257,   -1,  264,   -1,  256,  257,  268,
  264,  270,  180,  267,   -1,  264,  270,  276,   -1,  273,
   -1,  270,  276,  256,  257,  208,  191,  276,  193,   -1,
  195,  264,   -1,   -1,   -1,  257,   -1,  270,   -1,   -1,
  208,   -1,  264,  276,  257,  267,   -1,  212,  270,  271,
  215,  264,  274,  275,  276,  268,   -1,  270,  271,   -1,
  257,  274,  275,  276,   -1,   -1,   -1,  264,   -1,  237,
  267,  257,   -1,  270,   -1,   -1,   -1,  245,  264,  276,
  248,  249,  268,  251,  270,  271,  257,   -1,  274,  275,
  276,   -1,   -1,  264,  257,   -1,   -1,  268,   -1,  270,
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

//#line 508 "gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;

static NodoComun raiz;
static String ambito = "main";
static boolean inIF = false;
static boolean hasReturn = false;
static List<String> varDeclaradas = new ArrayList<>();
static String tipoActual;
static List<String> erroresSemanticos = new ArrayList<>();
static Map<String,String> tiposDeclarados = new HashMap<>(); //clave: lexema del tipo ; valor: tipo del tipo
static List<Nodo> funcionesDeclaradas = new ArrayList<>();

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

public NodoComun getRaiz(){
    return this.raiz;
}
//#line 677 "Parser.java"
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
int yyparse()
{
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
{yyval.obj = new NodoComun("SENTENCIA", (Nodo)val_peek(1).obj, (Nodo)val_peek(0).obj);}
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
{yyval.obj=val_peek(1).obj;}
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
//#line 59 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
//#line 60 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
//#line 64 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 16:
//#line 65 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 18:
//#line 67 "gramatica.y"
{yyval=val_peek(0);}
break;
case 20:
//#line 73 "gramatica.y"
{ yyval = new NodoComun("FOR",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);}
break;
case 21:
//#line 74 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
//#line 75 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
//#line 76 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 24:
//#line 80 "gramatica.y"
{yyval=val_peek(0);}
break;
case 25:
//#line 81 "gramatica.y"
{yyval=val_peek(0);}
break;
case 26:
//#line 85 "gramatica.y"
{  String ambitoVar = buscarAmbito(ambito,val_peek(7).sval);
                                                                   NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                   if (ambitoVar.equals("")) {
                                                                       agregarErrorSemantico("La variable '" + val_peek(7).sval + "' no fue declarada");
                                                                       idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                   }
                                                                   else {
                                                                       Token t = TablaSimbolos.getToken(val_peek(7).sval + ":" + ambitoVar);
                                                                       if (!t.getTipo().equals("ENTERO")) {
                                                                           agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                           idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                       }
                                                                       else {
                                                                           idAsignacion = new NodoHoja(val_peek(7).sval + ":" + ambitoVar);
                                                                       }
                                                                   }

                                                                    Nodo asignacion = new NodoComun("ASIGNACION", idAsignacion, (Nodo)val_peek(5).obj); /*Cambie sval x obj esto tiraba error el Parser*/
                                                                    Nodo incremento = new NodoComun("INCREMENTO", (Nodo)val_peek(1).obj, (Nodo)val_peek(0).obj); /*Idem*/
                                                                    Nodo condicion = (Nodo)val_peek(3).obj;

                                                                    Nodo asgnacionIncremento = new NodoComun("ASIGNACION E INCREMENTO", asignacion, incremento);

                                                                    yyval.obj = new NodoComun ("ENCABEZADO FOR", asgnacionIncremento, condicion);

                                                                    AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");
                                                                }
break;
case 27:
//#line 112 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
//#line 113 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
//#line 114 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
//#line 115 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
//#line 119 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(11).sval);
                                                                                       NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                                       if (ambitoVar.equals("")) {
                                                                                            agregarErrorSemantico("La variable '" + val_peek(11).sval + "' no fue declarada");
                                                                                            idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                                       }
                                                                                       else {
                                                                                             Token t = TablaSimbolos.getToken(val_peek(11).sval + ":" + ambitoVar);
                                                                                             if (!t.getTipo().equals("ENTERO")) {
                                                                                                    agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                                                    idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                                             }
                                                                                             else {
                                                                                                    idAsignacion = new NodoHoja(val_peek(11).sval + ":" + ambitoVar);
                                                                                             }
                                                                                       }

                                                                                       Nodo asignacion = new NodoComun("ASIGNACION", idAsignacion, (Nodo)val_peek(9).obj); /*Cambie sval x obj*/
                                                                                       Nodo incremento = new NodoComun("INCREMENTO", (Nodo)val_peek(5).obj, (Nodo)val_peek(4).obj); /*Idem*/
                                                                                       Nodo condicion = (Nodo)val_peek(7).obj;
                                                                                       Nodo iteradorCondicion = (Nodo)val_peek(1).obj;

                                                                                       Nodo asgnacionIncremento = new NodoComun("ASIGNACION E INCREMENTO", asignacion, incremento);
                                                                                       Nodo condiciones = new NodoComun("ASIGNACION E INCREMENTO", condicion, iteradorCondicion);

                                                                                       yyval.obj = new NodoComun ("ENCABEZADO FOR", asgnacionIncremento, condiciones);

                                                                                       AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");
                                                                                       }
break;
case 32:
//#line 149 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
//#line 150 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
//#line 151 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
//#line 152 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 36:
//#line 156 "gramatica.y"
{yyval.obj = new NodoHoja("UP");}
break;
case 37:
//#line 157 "gramatica.y"
{yyval.obj = new NodoHoja("DOWN");}
break;
case 38:
//#line 161 "gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,val_peek(2).sval);
                              if (ambitoVar.equals(""))
                                  agregarErrorSemantico("La variable '" + val_peek(2).sval + "' no fue declarada");
                              else {
                                  Token t = TablaSimbolos.getToken(val_peek(2).sval + ":" + ambitoVar);
                                  if (!t.getUso().equals("variable"))
                                    agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")" );
                                    /*new NodoHoja("error semantico"); ??*/
                                  else {
                                    NodoHoja id = new NodoHoja(val_peek(2).sval + ":" + ambitoVar);

                                  }
                              }
                            }
break;
case 40:
//#line 176 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 42:
//#line 181 "gramatica.y"
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
//#line 196 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 44:
//#line 197 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 45:
//#line 201 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 46:
//#line 202 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 47:
//#line 203 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 48:
//#line 207 "gramatica.y"
{hasReturn = false;
                String idFuncion = val_peek(0).sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (!TablaSimbolos.existeSimbolo(idFuncion + ":" + ambito)){
                    t.getLexema().setLength(0);
                    t.getLexema().append(idFuncion).append(":").append(ambito);
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
                 addAmbito(idFuncion);
                 NodoComun encabezado = new NodoComun(idFuncion + ":" + ambito);
                 encabezado.setTipo(tipoActual);
                 yyval.obj = encabezado;
                 }
break;
case 49:
//#line 228 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 50:
//#line 232 "gramatica.y"
{ if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         String parametro = val_peek(3).sval;
                                                         Token t = TablaSimbolos.getToken(parametro);
                                                         if (!TablaSimbolos.existeSimbolo(parametro + ":" + ambito)){
                                                             t.getLexema().setLength(0);
                                                             t.getLexema().append(parametro).append(":").append(ambito);
                                                             t.setAmbito(ambito);
                                                             t.setUso("parametro");
                                                             t.setTipo(tipoActual);
                                                             TablaSimbolos.removeToken(parametro);
                                                             TablaSimbolos.addSimbolo(t.getLexema().toString(),t);

                                                             NodoComun funcion = (NodoComun)val_peek(5).obj; /*Encabezado con nombre funcion, este tiene el tipo*/

                                                             funcion.setIzq((Nodo)val_peek(3).obj); /*Parametro*/
                                                             funcion.setDer((Nodo)val_peek(0).obj); /*Cuerpo funcionn*/

                                                             funcionesDeclaradas.add(funcion);
                                                             yyval.obj = funcion;
                                                         }
                                                         removeAmbito();
                                                         }
break;
case 52:
//#line 256 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");removeAmbito();}
break;
case 53:
//#line 257 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 54:
//#line 261 "gramatica.y"
{yyval = val_peek(1);}
break;
case 55:
//#line 262 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 59:
//#line 275 "gramatica.y"
{yyval = new NodoComun("SENTENCIA", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 60:
//#line 276 "gramatica.y"
{yyval=val_peek(0);}
break;
case 61:
//#line 277 "gramatica.y"
{yyval=val_peek(1);}
break;
case 62:
//#line 278 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio");}
break;
case 63:
//#line 283 "gramatica.y"
{yyval = new NodoComun("SENTENCIA", (Nodo) val_peek(1).obj, (Nodo) val_peek(0).obj);}
break;
case 64:
//#line 284 "gramatica.y"
{yyval=val_peek(0);}
break;
case 65:
//#line 289 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           if (!inIF){
                                hasReturn = true;
                                yyval.obj = new NodoComun("RETURN", (Nodo)val_peek(1).obj);
                           }
                           /*$$ = new NodoComun("RETURN", (Nodo)$3.obj);   DONDE VA?*/
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 66:
//#line 301 "gramatica.y"
{yyval.obj = controlarTipos(val_peek(2).obj,val_peek(1).sval,val_peek(0).obj);}
break;
case 67:
//#line 302 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(2).obj,val_peek(1).sval,(Nodo)val_peek(0).obj);}
break;
case 68:
//#line 303 "gramatica.y"
{yyval.obj = val_peek(0);}
break;
case 69:
//#line 304 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 70:
//#line 305 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
//#line 309 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(2).obj, val_peek(1).sval, (Nodo)val_peek(0).obj);}
break;
case 72:
//#line 310 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(2).obj, val_peek(1).sval, (Nodo)val_peek(0).obj);}
break;
case 73:
//#line 311 "gramatica.y"
{yyval = val_peek(0);}
break;
case 74:
//#line 312 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 75:
//#line 313 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 76:
//#line 317 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La variable '" + val_peek(0).sval + "' no fue declarada");
            Nodo aux = new NodoHoja(val_peek(0).sval);
            yyval.obj = aux;
        }
        else {
            Token t = TablaSimbolos.getToken(val_peek(0).sval + ":" + ambitoVar);
            if (!t.getUso().equals("variable"))
                agregarErrorSemantico("'" + val_peek(0).sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                Nodo aux = new NodoHoja(val_peek(0).sval+ambito, t);
                yyval.obj = aux;
                TablaSimbolos.removeToken(val_peek(0).sval);
            }
        }
        }
break;
case 77:
//#line 334 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                if (t != null && (t.getTipo().equals(FLOTANTE))) {
                    String lexema = t.getLexema().toString();
                    chequeoFlotantesPositivos(lexema);
                    yyval.obj = new NodoHoja(val_peek(0).sval,t);
                }
                else
                    yyval.obj = new NodoHoja("error");
                }
break;
case 78:
//#line 343 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 79:
//#line 344 "gramatica.y"
{yyval.obj = new  NodoHoja("hola");}
break;
case 80:
//#line 345 "gramatica.y"
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
//#line 360 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                                        if (t != null && t.getTipo().equals(ENTERO)) {
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                                            yyval.obj = new NodoHoja("error");
                                        }
                                        else {
                                            yyval.obj = new NodoHoja(val_peek(1).sval + val_peek(0).sval);
                                        }
                    }
break;
case 82:
//#line 369 "gramatica.y"
{yyval.obj = new NodoHoja("hola");}
break;
case 83:
//#line 373 "gramatica.y"
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
//#line 390 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 85:
//#line 391 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 86:
//#line 392 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 87:
//#line 393 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 88:
//#line 394 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 90:
//#line 399 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 91:
//#line 400 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 92:
//#line 401 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 94:
//#line 406 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 95:
//#line 410 "gramatica.y"
{yyval=val_peek(1);}
break;
case 96:
//#line 411 "gramatica.y"
{yyval=val_peek(1);}
break;
case 97:
//#line 412 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 98:
//#line 416 "gramatica.y"
{inIF=true; yyval=val_peek(0);}
break;
case 99:
//#line 420 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; yyval.obj = new NodoComun("CUERPO",(Nodo)val_peek(1).obj);
                                                                                                                                              Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                              yyval.obj = new NodoComun("IF", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 100:
//#line 423 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)val_peek(1).obj);
                                                                                                                                          Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                          yyval.obj = new NodoComun("IF", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 101:
//#line 428 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)val_peek(3).obj, (Nodo)val_peek(1).obj);
                                                                                                                                                                          Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                                                          yyval.obj = new NodoComun("IF", (Nodo)val_peek(6).obj,(Nodo)val_peek(3).obj);}
break;
case 102:
//#line 432 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)val_peek(3).obj, (Nodo)val_peek(1).obj);
                                                                                                                                                                            Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                                                            yyval.obj = new NodoComun("IF", (Nodo)val_peek(6).obj,(Nodo)val_peek(3).obj);}
break;
case 103:
//#line 436 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)val_peek(3).obj, (Nodo)val_peek(1).obj);
                                                                                                                                                                  Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                                                  yyval.obj = new NodoComun("IF", (Nodo)val_peek(6).obj,(Nodo)val_peek(3).obj);}
break;
case 104:
//#line 440 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)val_peek(3).obj, (Nodo)val_peek(1).obj);
                                                                                                                                                                   Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                                                   yyval.obj = new NodoComun("IF", (Nodo)val_peek(6).obj,(Nodo)val_peek(3).obj); }
break;
case 105:
//#line 443 "gramatica.y"
{yyerror("Falta THEN en IF");}
break;
case 106:
//#line 444 "gramatica.y"
{yyerror("Falta ELSE en IF");}
break;
case 107:
//#line 445 "gramatica.y"
{yyerror("Falta END_IF en IF");}
break;
case 108:
//#line 450 "gramatica.y"
{yyval = val_peek(1);}
break;
case 109:
//#line 451 "gramatica.y"
{yyval = val_peek(1);}
break;
case 110:
//#line 455 "gramatica.y"
{yyval = val_peek(1);}
break;
case 111:
//#line 456 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 112:
//#line 457 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 113:
//#line 458 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 114:
//#line 462 "gramatica.y"
{yyval = new NodoComun("SENTENCIA", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 115:
//#line 463 "gramatica.y"
{yyval = val_peek(1);}
break;
case 116:
//#line 468 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);}
break;
case 117:
//#line 469 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);}
break;
case 118:
//#line 470 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);}
break;
case 119:
//#line 471 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);}
break;
case 120:
//#line 472 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);}
break;
case 121:
//#line 473 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);}
break;
case 122:
//#line 477 "gramatica.y"
{yyval = new NodoComun(val_peek(1).sval, (Nodo)val_peek(2).obj, (Nodo)val_peek(0).obj);}
break;
case 123:
//#line 478 "gramatica.y"
{ yyval = new NodoComun(val_peek(3).sval, (Nodo)val_peek(5).obj, (Nodo)val_peek(3).obj);
                                                                                    AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
                                                                                  }
break;
case 124:
//#line 482 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 125:
//#line 487 "gramatica.y"
{yyval = new NodoComun("SENTENCIA", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);}
break;
case 126:
//#line 491 "gramatica.y"
{yyval = new NodoComun("SENTENCIA", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);}
break;
case 127:
//#line 492 "gramatica.y"
{yyval=val_peek(0);}
break;
case 128:
//#line 493 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 129:
//#line 497 "gramatica.y"
{   yyval = new NodoComun("OUTF", new NodoHoja(val_peek(1).sval));
                            Token t = TablaSimbolos.getToken(val_peek(1).sval); /*Obtenemos el token, faltaba esto*/
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 130:
//#line 503 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 131:
//#line 504 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 1539 "Parser.java"
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
public void run()
{
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
