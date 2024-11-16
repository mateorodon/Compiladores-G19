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
   38,   18,   39,   40,   41,   42,   18,   18,   32,   43,
   43,   43,   12,   12,   12,
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
    1,    3,    0,    0,    0,    0,   11,    1,    3,    3,
    1,    1,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,   98,    0,    0,    0,   43,   44,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    4,
    6,    8,    9,   47,    0,    0,    0,    0,    2,   40,
    0,   77,    0,   78,    0,    0,   73,  132,   91,    0,
    0,    0,    0,    0,    1,    0,  135,    0,    0,    0,
    0,    0,    0,    0,   48,   46,    0,    0,    0,    0,
    0,    0,    0,  128,  123,    0,    0,    0,    0,   81,
    0,    0,    0,    0,   89,    0,   90,    0,    0,  133,
  134,    0,   87,    0,    0,    0,    0,    0,    0,    0,
   23,   22,   45,    0,   54,    0,    0,    0,    0,    0,
  116,  117,  118,  121,  120,  119,    0,    0,    0,   69,
    0,   70,    0,   74,   71,   75,   72,    0,    0,    0,
   86,    0,   85,   88,    0,    0,   97,    0,    0,   21,
   20,   95,    0,   64,    0,    0,    0,    0,    0,    0,
    0,  124,  113,    0,    0,    0,    0,    0,   79,    0,
    0,    0,   84,   83,    0,    0,  115,   96,    0,    0,
   53,   63,    0,   61,   50,    0,    0,    0,    0,    0,
    0,  111,    0,  112,    0,   82,   92,   36,   37,    0,
    0,    0,  114,    0,   59,    0,   52,    0,    0,  109,
   94,    0,   93,   99,    0,    0,  100,    0,  110,    0,
    0,    0,    0,    0,   65,   51,    0,    0,    0,    0,
    0,  108,  106,  105,    0,    0,    0,    0,    0,  125,
  101,  103,  104,  102,    0,    0,    0,    0,    0,    0,
    0,    0,   35,    0,    0,  126,   32,    0,   34,   33,
    0,   31,  127,
};
final static short yydgoto[] = {                          3,
   12,   13,   14,   15,   16,   46,   17,   18,   19,   20,
   21,   22,   23,   37,  111,   38,   39,   86,  201,   87,
   24,   25,   81,  155,  206,   82,   83,  156,  189,   56,
   57,   62,  214,  166,   26,  190,  167,  127,  119,  187,
  250,  261,   63,
};
final static short yysindex[] = {                      -218,
  336,  413,    0,  -32,    0,  413,  -23,   -2,    0,    0,
  -15,  345,    0,   51,   64, -114,    0,    0,    0,    0,
    0,    0,    0,    0,   17,  121,  381,   34,  103, -105,
  390,  -38,  -58, -199,  -82,  -88,  140,    0,    0,    0,
    0,    0,    0,    0,  -67,  -34,   -7,   -5,    0,    0,
  -13,    0, -234,    0,   58,  109,    0,    0,    0,  356,
  152,  167,  169,  122,    0,  213,    0,  359, -199,  -48,
  194,    2,  -37,  -79,    0,    0,   13,    0,   20,   36,
  260,  264,  268,    0,    0,  275,  134,   57,  233,    0,
   80,  119,  126,  214,    0,  117,    0,  117,   77,    0,
    0,  -43,    0,   71,   82,   -9,  -32, -152,  322,  292,
    0,    0,    0,  405,    0,   88,   89, -193,  237,  306,
    0,    0,    0,    0,    0,    0,  117,  254,   96,    0,
  109,    0,  109,    0,    0,    0,    0,  411,   58,  117,
    0,  -89,    0,    0,   -5,  303,    0,  311,  428,    0,
    0,    0,  366,    0,  150,  405,  326,  405,  405,    0,
   58,    0,    0,  288, -129,  429,  153,   58,    0,  332,
  385,   58,    0,    0,   35,  -78,    0,    0,  369,  117,
    0,    0,  377,    0,    0,  171,  402,  396,  399, -167,
  277,    0,  438,    0,  -71,    0,    0,    0,    0, -113,
  199,  205,    0,  480,    0,  183,    0,  -49,    0,    0,
    0,  288,    0,    0,  288,  407,    0, -123,    0, -123,
  414,  -18,  422,  437,    0,    0,  447, -123, -123, -123,
 -123,    0,    0,    0,  457,  441,   -5,  466,  467,    0,
    0,    0,    0,    0,   -5,  468,  472,   -5,   -5,  237,
  476,   -5,    0,  485,  486,    0,    0,  494,    0,    0,
  495,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -112,    0,    0,    0,    0,    0,    0,
    0,  469,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  509,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  498,  204,    0,    0,    0,    0,
    1,    0,    0,    0,  116,   47,    0,    0,    0,  504,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -12,    0,    0,
  505,    0,    0,    0,    0,    0,    0,    0,   24,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  274,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   70,    0,   93,    0,    0,    0,    0,    0,  129,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  286,    0,  274,  274,  245,
  504,    0,    0,    0,    0,    0,    0,  -41,    0,    0,
    0,  139,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  246,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  159,
  -36,  -35,  -21,  141,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  225,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
final static short yygindex[] = {                         0,
  120,  410,    0,  431,  -31,    0,    0,    0,    0,  392,
    0,    0,    0,  520,  -53,    0,    0,  -65, -146,   23,
    4,    0,  439,   48,    0,    0,    0,    0,  -61,  218,
  239, -110,  300,  -93,    0,  -95, -138,  351,    0,    0,
    0,    0,    0,
};
final static int YYTABLESIZE=714;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        122,
   76,   69,   67,  109,   27,   30,   53,   29,  162,   77,
  124,  126,  125,  104,  149,   80,   32,  122,  142,   29,
  112,  237,   89,   80,   36,  191,   29,   90,   55,  202,
   85,   55,   61,   79,   85,   53,   70,   71,    1,   53,
  146,   76,   76,   76,   76,   76,   68,   76,    2,  145,
   55,   60,  157,  222,   68,  151,   47,   34,   30,   76,
   76,   76,   76,   78,   80,   80,   80,   80,   80,   66,
   80,  193,  102,  229,    9,   10,  231,   88,   53,  175,
    9,   10,   80,   80,   80,   80,   80,   68,  211,   68,
   68,   68,   67,  200,  183,  218,  157,  157,  212,  220,
   91,  213,   92,  147,  107,   68,   68,   68,   68,   42,
   66,    5,   66,   66,   66,   38,  228,    7,  138,  230,
  139,   27,   43,   11,   53,   31,  192,  107,   66,   66,
   66,   66,  211,   67,    5,   67,   67,   67,   39,  256,
    7,  161,   44,   59,   42,  213,   11,   53,  221,  168,
   93,   67,   67,   67,   67,   94,   64,   45,  107,   42,
   48,   53,  172,   53,  198,  199,  173,  174,   35,  129,
   53,  247,  130,   11,   38,   72,   91,  107,   92,  251,
   74,   28,  254,  255,    5,  107,  258,  108,   10,   75,
    7,   96,    5,  124,  126,  125,   11,   39,    7,  198,
  199,  153,  204,   12,   11,  185,  186,   97,  103,  121,
  122,  123,   98,  141,   99,    9,   10,  107,   51,  107,
   27,   30,   76,   52,   66,   28,    5,   27,   30,  108,
   27,   30,    7,   27,   30,   29,  122,  122,   11,   27,
   30,   35,   29,  236,   42,   29,   84,   51,   29,   78,
   84,   51,   52,  100,   29,  105,   52,   76,   53,   76,
   76,   76,   12,  106,   76,   26,    9,   10,   76,  113,
   76,   76,  161,   76,   76,   76,   76,   33,   76,   76,
   80,   53,   80,   80,   80,   56,  114,   80,   58,   50,
   51,   80,  115,   80,   80,   52,   80,   80,   80,   80,
  116,   80,   80,   68,  117,   68,   68,   68,  131,  133,
   68,  118,  198,  199,   68,  120,   68,   68,  128,   68,
   68,   68,   68,  129,   68,   68,   66,  143,   66,   66,
   66,  135,  137,   66,  140,  130,   51,   66,  144,   66,
   66,   52,   66,   66,   66,   66,  169,   66,   66,   67,
  152,   67,   67,   67,  158,  159,   67,  170,   58,   51,
   67,  176,   67,   67,   52,   67,   67,   67,   67,  177,
   67,   67,   38,   51,  132,   51,    9,   10,   52,   38,
   52,  134,   51,   38,  184,   38,   38,   52,   38,   38,
   38,   38,  121,  122,  123,   39,   95,   28,   91,  101,
   92,   91,   39,   92,   28,  180,   39,   28,   39,   39,
   28,   39,   39,   39,   39,  107,   28,  181,  195,   54,
   54,   41,  107,   54,  196,  197,  107,  203,  107,  107,
   11,  107,  107,  107,  107,  205,   41,   11,  207,   54,
   41,   11,  208,   11,   11,   10,   11,   11,   11,   11,
  226,  171,   10,   91,  209,   92,   10,  210,   10,   10,
  223,   10,   10,   10,   10,  232,  224,   12,    5,  136,
   51,   12,  235,   12,   12,   52,   12,   12,   12,   12,
  238,   26,   54,   54,   54,   54,  240,   54,   26,   54,
  217,   26,   58,   51,   26,  239,  245,   54,   52,  246,
   26,  108,  115,  110,  110,  248,  249,  252,    3,  115,
   54,  108,  253,  115,  108,  115,  257,  233,   54,  234,
  225,  115,   91,  154,   92,  259,  260,  241,  242,  243,
  244,   54,  211,  107,  262,  263,   54,   49,  148,  110,
    5,   62,  215,  163,  107,  213,    7,  131,   57,  153,
  148,    5,   11,   60,  165,   73,  160,    7,  227,    0,
  153,  163,  107,   11,    0,  182,    0,  154,  154,    5,
  164,   54,  165,    0,    0,    7,    0,  150,  107,  179,
    0,   11,    0,    0,    0,    5,    0,    0,  108,    0,
    0,    7,    4,    0,  188,  148,  179,   11,    0,    5,
    0,    4,    6,    0,    0,    7,    8,    0,    5,    9,
   10,   11,   40,    0,    7,    8,    0,    0,    9,   10,
   11,  216,    0,  179,    0,  216,    0,    0,   54,    0,
    0,    0,    0,    0,    0,    0,   54,    4,    0,   54,
   54,   54,  188,   54,    5,  188,    4,    0,   49,    0,
    7,    8,    0,    5,    9,   10,   11,   65,    0,    7,
    8,    4,    0,    9,   10,   11,    0,    0,    5,    4,
    0,    0,    0,    0,    7,    8,    5,  153,    9,   10,
   11,    0,    7,    8,  107,  107,    9,   10,   11,    0,
    0,    5,    5,    0,  107,  178,  194,    7,    7,    0,
    0,    5,    0,   11,   11,  219,    0,    7,    0,    0,
    0,    0,    0,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   60,   41,   41,   41,   41,   45,   40,  119,   44,
   60,   61,   62,   62,  108,   47,   40,   59,   62,   41,
   74,   40,  257,    0,   40,  164,   40,  262,   41,  176,
   40,   44,   29,   41,   40,   45,   33,   34,  257,   45,
  106,   41,   42,   43,   44,   45,    0,   47,  267,   59,
   28,   29,  114,  200,   32,  109,   40,   60,   91,   59,
   60,   61,   62,  257,   41,   42,   43,   44,   45,    0,
   47,  165,   69,  212,  274,  275,  215,   91,   45,  145,
  274,  275,   59,   60,   61,   62,  118,   41,  256,   43,
   44,   45,    0,   59,  156,  191,  158,  159,  266,  195,
   43,  269,   45,  256,  257,   59,   60,   61,   62,   59,
   41,  264,   43,   44,   45,    0,  212,  270,   96,  215,
   98,    2,   59,  276,   45,    6,  256,  257,   59,   60,
   61,   62,  256,   41,  264,   43,   44,   45,    0,  250,
  270,  119,  257,   41,  257,  269,  276,   45,  262,  127,
   42,   59,   60,   61,   62,   47,  262,  272,    0,  272,
   40,   45,  140,   45,  278,  279,  256,  257,  257,   41,
   45,  237,   44,    0,   59,  258,   43,  257,   45,  245,
   41,   41,  248,  249,  264,  257,  252,  267,    0,  257,
  270,   40,  264,   60,   61,   62,  276,   59,  270,  278,
  279,  273,  180,    0,  276,  158,  159,   41,  257,  259,
  260,  261,   44,  257,   93,  274,  275,   59,  257,  257,
  257,  257,  257,  262,  263,  258,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  262,  257,  267,  256,  257,  270,  257,
  256,  257,  262,   41,  276,   62,  262,  257,   45,  259,
  260,  261,   59,  262,  264,   41,  274,  275,  268,  257,
  270,  271,  250,  273,  274,  275,  276,  280,  278,  279,
  257,   45,  259,  260,  261,   41,  267,  264,   44,  256,
  257,  268,  257,  270,  271,  262,  273,  274,  275,  276,
   41,  278,  279,  257,   41,  259,  260,  261,   91,   92,
  264,   44,  278,  279,  268,   41,  270,  271,  262,  273,
  274,  275,  276,   91,  278,  279,  257,  257,  259,  260,
  261,   93,   94,  264,  258,  256,  257,  268,  257,  270,
  271,  262,  273,  274,  275,  276,   93,  278,  279,  257,
   59,  259,  260,  261,  267,  267,  264,  262,  256,  257,
  268,   59,  270,  271,  262,  273,  274,  275,  276,   59,
  278,  279,  257,  257,  256,  257,  274,  275,  262,  264,
  262,  256,  257,  268,   59,  270,  271,  262,  273,  274,
  275,  276,  259,  260,  261,  257,   41,  257,   43,   41,
   45,   43,  264,   45,  264,   40,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  268,  266,   28,
   29,   12,  264,   32,   93,   41,  268,   59,  270,  271,
  257,  273,  274,  275,  276,   59,   27,  264,  268,   48,
   31,  268,   41,  270,  271,  257,  273,  274,  275,  276,
  268,   41,  264,   43,   59,   45,  268,   59,  270,  271,
  262,  273,  274,  275,  276,   59,  262,  264,    0,  256,
  257,  268,   59,  270,  271,  262,  273,  274,  275,  276,
   59,  257,   91,   92,   93,   94,   40,   96,  264,   98,
  191,  267,  256,  257,  270,   59,   40,  106,  262,   59,
  276,  256,  257,   73,   74,   40,   40,   40,    0,  264,
  119,  266,   41,  268,  269,  270,   41,  218,  127,  220,
   41,  276,   43,  114,   45,   41,   41,  228,  229,  230,
  231,  140,  256,  257,   41,   41,  145,   40,  108,  109,
  264,  268,  266,  256,  257,  269,  270,   44,   44,  273,
  120,  264,  276,  268,  267,   36,  118,  270,  208,   -1,
  273,  256,  257,  276,   -1,  156,   -1,  158,  159,  264,
  265,  180,  267,   -1,   -1,  270,   -1,  256,  257,  149,
   -1,  276,   -1,   -1,   -1,  264,   -1,   -1,  267,   -1,
   -1,  270,  257,   -1,  164,  165,  166,  276,   -1,  264,
   -1,  257,  267,   -1,   -1,  270,  271,   -1,  264,  274,
  275,  276,  268,   -1,  270,  271,   -1,   -1,  274,  275,
  276,  191,   -1,  193,   -1,  195,   -1,   -1,  237,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  245,  257,   -1,  248,
  249,  250,  212,  252,  264,  215,  257,   -1,  268,   -1,
  270,  271,   -1,  264,  274,  275,  276,  268,   -1,  270,
  271,  257,   -1,  274,  275,  276,   -1,   -1,  264,  257,
   -1,   -1,   -1,   -1,  270,  271,  264,  273,  274,  275,
  276,   -1,  270,  271,  257,  257,  274,  275,  276,   -1,
   -1,  264,  264,   -1,  257,  268,  268,  270,  270,   -1,
   -1,  264,   -1,  276,  276,  268,   -1,  270,   -1,   -1,
   -1,   -1,   -1,  276,
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

//#line 658 "gramatica.y"
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
//#line 706 "Parser.java"
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
                                                                           idAsignacion = new NodoHoja(val_peek(7).sval + ":" + ambitoVar);
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
                                    NodoHoja id = new NodoHoja(val_peek(2).sval +":"+ambitoVar);
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
{tipoActual = val_peek(0).sval;}
break;
case 44:
//#line 226 "gramatica.y"
{tipoActual = val_peek(0).sval;}
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
//#line 257 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 50:
//#line 261 "gramatica.y"
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
                                                         }
break;
case 52:
//#line 286 "gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 53:
//#line 287 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 54:
//#line 291 "gramatica.y"
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
//#line 306 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 59:
//#line 319 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 60:
//#line 320 "gramatica.y"
{yyval=val_peek(0);}
break;
case 61:
//#line 321 "gramatica.y"
{yyval=val_peek(1);}
break;
case 62:
//#line 322 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio");}
break;
case 63:
//#line 327 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(1).obj, (Nodo) val_peek(0).obj);}
break;
case 64:
//#line 328 "gramatica.y"
{yyval=val_peek(0);}
break;
case 65:
//#line 333 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           if (!inIF){
                                hasReturn = true;
                           }
                           yyval.obj = new NodoComun("Return", (Nodo)val_peek(1).obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 66:
//#line 344 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(val_peek(2).sval);
                            Nodo nIzq = new NodoHoja(val_peek(2).sval, tIzq);

                            Token tDer = TablaSimbolos.getToken(val_peek(0).sval);
                            Nodo nDer = new NodoHoja(val_peek(0).sval, tIzq);

                            yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                          }
break;
case 67:
//#line 353 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(val_peek(2).sval);
                              Nodo nIzq = new NodoHoja(val_peek(2).sval, tIzq);

                              Token tDer = TablaSimbolos.getToken(val_peek(0).sval);
                              Nodo nDer = new NodoHoja(val_peek(0).sval, tIzq);

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
                         Nodo nDer = new NodoHoja(val_peek(0).sval, tIzq);

                         yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                        }
break;
case 72:
//#line 375 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(val_peek(2).sval);
                           Nodo nIzq = new NodoHoja(val_peek(2).sval, tIzq);

                           Token tDer = TablaSimbolos.getToken(val_peek(0).sval);
                           Nodo nDer = new NodoHoja(val_peek(0).sval, tIzq);

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
                                                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)val_peek(6).obj,cuerpo);}
break;
case 102:
//#line 542 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)val_peek(3).obj);
                                                                                                                                                                    NodoComun nElse = new NodoComun("Else", (Nodo)val_peek(1).obj);
                                                                                                                                                                    Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                    yyval.obj = new NodoComun("If", (Nodo)val_peek(6).obj,cuerpo);}
break;
case 103:
//#line 547 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)val_peek(3).obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("Else", (Nodo)val_peek(1).obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                   yyval.obj = new NodoComun("If", (Nodo)val_peek(6).obj,cuerpo);}
break;
case 104:
//#line 552 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)val_peek(3).obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("Else", (Nodo)val_peek(1).obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                   yyval.obj = new NodoComun("If", (Nodo)val_peek(6).obj,cuerpo);}
break;
case 105:
//#line 556 "gramatica.y"
{yyerror("Falta THEN en IF");}
break;
case 106:
//#line 557 "gramatica.y"
{yyerror("Falta ELSE en IF");}
break;
case 107:
//#line 558 "gramatica.y"
{yyerror("Falta END_IF en IF");}
break;
case 108:
//#line 563 "gramatica.y"
{yyval = val_peek(1);}
break;
case 109:
//#line 564 "gramatica.y"
{yyval = val_peek(1);}
break;
case 110:
//#line 568 "gramatica.y"
{yyval = val_peek(1);}
break;
case 111:
//#line 569 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 112:
//#line 570 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 113:
//#line 571 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 114:
//#line 575 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 115:
//#line 576 "gramatica.y"
{yyval = val_peek(1);}
break;
case 116:
//#line 581 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 117:
//#line 582 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 118:
//#line 583 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 119:
//#line 584 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 120:
//#line 585 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 121:
//#line 586 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 122:
//#line 590 "gramatica.y"
{yyval.obj = new NodoComun(val_peek(1).sval, (Nodo)val_peek(2).obj, (Nodo)val_peek(0).obj);}
break;
case 123:
//#line 591 "gramatica.y"
{inList1 = true;}
break;
case 124:
//#line 591 "gramatica.y"
{inList1 = false;}
break;
case 125:
//#line 591 "gramatica.y"
{inList2 = true;}
break;
case 126:
//#line 591 "gramatica.y"
{inList2 = false;}
break;
case 127:
//#line 592 "gramatica.y"
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
case 128:
//#line 609 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 129:
//#line 614 "gramatica.y"
{
    if (inList1)
            expresiones1.add((Nodo)val_peek(0).obj);
        if (inList2)
            expresiones2.add((Nodo)val_peek(0).obj);
    yyval = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 130:
//#line 624 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 131:
//#line 631 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval=val_peek(0);
    }
break;
case 132:
//#line 638 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 133:
//#line 642 "gramatica.y"
{   yyval.obj = new NodoComun("Outf", new NodoHoja(val_peek(1).sval));
                            Token t = TablaSimbolos.getToken(val_peek(1).sval); /*Obtenemos el token, faltaba esto*/
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 134:
//#line 648 "gramatica.y"
{   yyval.obj = new NodoComun("Outf", new NodoHoja(val_peek(1).sval));
                                 Token t = TablaSimbolos.getToken(val_peek(1).sval); /*Obtenemos el token, faltaba esto*/
                                 t.setUso("mensaje");
                                 t.setTipo("cadena");
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }
break;
case 135:
//#line 654 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 1744 "Parser.java"
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
