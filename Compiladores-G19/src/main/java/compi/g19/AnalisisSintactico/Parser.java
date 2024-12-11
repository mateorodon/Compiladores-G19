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
import static compi.g19.AnalisisLexico.AnalizadorLexico.errorLexico;
import static compi.g19.AnalisisLexico.AnalizadorLexico.errorSintactico;
//#line 29 "Parser.java"




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
   17,   17,   17,   17,   17,   18,   20,   20,    9,    9,
    9,    5,    5,   22,   22,    6,    6,    6,   23,   23,
   26,    7,    7,    7,   24,   24,   27,   28,   28,   25,
   25,   25,   25,   29,   29,   30,   21,   21,   21,   21,
   21,   31,   31,   31,   31,   31,   32,   32,   32,   32,
   32,   32,   32,    8,    8,    8,    8,    8,    8,   10,
   10,   10,   10,   34,   34,   15,   15,   15,   36,   11,
   11,   11,   11,   11,   11,   11,   11,   11,   37,   37,
   37,   37,   38,   38,   38,   38,   35,   35,   39,   39,
   39,   39,   39,   39,   19,   40,   41,   42,   43,   19,
   19,   33,   44,   44,   44,   12,   12,   12,   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    3,    2,    2,    1,    2,    2,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    5,
    5,    4,    4,    1,    1,    6,    5,    5,    5,    5,
   10,    9,    9,    9,    8,    3,    1,    1,    3,    6,
    3,    1,    1,    1,    1,    3,    2,    1,    3,    2,
    0,    8,    7,    6,    2,    1,    3,    1,    3,    3,
    1,    2,    0,    2,    1,    4,    3,    3,    1,    3,
    3,    3,    3,    1,    3,    3,    1,    1,    1,    4,
    2,    2,    5,    6,    6,    5,    5,    4,    5,    4,
    4,    3,    7,    1,    1,    2,    3,    2,    1,    7,
    7,    9,    9,    9,    9,    8,    8,    7,    2,    2,
    2,    4,    3,    4,    2,    2,    3,    2,    1,    1,
    1,    1,    1,    1,    3,    0,    0,    0,    0,   11,
    1,    3,    3,    1,    1,    4,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,   99,    0,    0,    0,   44,   45,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   42,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    0,
    4,    6,    8,    9,   48,    0,    0,    0,    0,    2,
   41,    0,   78,    0,   79,    0,    0,   74,  135,   92,
    0,    0,    0,    0,    0,    1,    0,    0,  139,    0,
    0,    0,    0,    0,    0,    0,  131,    0,  126,    0,
    0,   49,   47,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   82,    0,    0,    0,    0,   90,    0,
   91,    0,    0,  138,  136,  137,    0,   88,    0,    0,
   36,    0,    0,    0,    0,   23,   22,    0,    0,    0,
  119,  120,  121,  124,  123,  122,    0,   46,    0,   55,
    0,    0,    0,    0,    0,    0,   70,    0,   71,    0,
   75,   72,   76,   73,    0,    0,    0,   87,    0,   86,
   89,   98,    0,    0,   21,   20,   96,   37,   38,    0,
    0,    0,  127,    0,    0,    0,   65,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   80,    0,    0,
    0,   85,   84,  118,   97,    0,    0,    0,    0,    0,
    0,    0,   54,   64,    0,   62,   51,    0,    0,    0,
    0,    0,    0,  115,    0,  116,    0,   83,   93,  117,
    0,    0,    0,    0,    0,    0,    0,   60,    0,   53,
    0,    0,  111,  110,   95,    0,   94,  100,    0,    0,
    0,  101,    0,  113,    0,    0,    0,    0,    0,    0,
    0,    0,   66,   52,    0,    0,    0,    0,    0,  109,
  107,  114,  106,    0,    0,   35,    0,  128,    0,  112,
  102,  104,  105,  103,   32,    0,   34,    0,   33,   31,
  129,    0,  130,
};
final static short yydgoto[] = {                          3,
   12,   13,   14,   15,   16,   47,   17,   18,   19,   20,
   21,   22,   23,   37,  116,   38,   39,   40,   80,  161,
   81,   24,   25,   88,  168,  219,   89,   90,  169,  201,
   57,   58,   63,  228,  176,   26,  202,  177,  127,  119,
  190,  268,  272,   64,
};
final static short yysindex[] = {                      -203,
  385,  440,    0,  -32,    0,  440,   13,  -46,    0,    0,
  -28,  401,    0,  -25,   22, -236,    0,    0,    0,    0,
    0,    0,    0,    0,   63,   87,  416,  119,  -34, -127,
  425,   -6,   16, -124, -118, -115,  140,    0,    0,  103,
    0,    0,    0,    0,    0, -100,    7,  -22,   57,    0,
    0,  -11,    0, -175,    0,  -20,   86,    0,    0,    0,
  104,  127,  144,  149,   94,    0,  165,  169,    0,  115,
 -124,  -52,  163,  -59,  -37,  387,    0,   57,    0,  154,
  118,    0,    0,  -26,    0,  -19,    2,  180,  232,  234,
  241,   27,  202,    0,  126,  138,  162,  164,    0,  -15,
    0,  -15,   38,    0,    0,    0,  -49,    0,   48,   55,
    0,  -32,  324,  270,  242,    0,    0,   58,  199,  -77,
    0,    0,    0,    0,    0,    0,  -15,    0,  284,    0,
   49,   61, -225,  455,  231,   71,    0,   86,    0,   86,
    0,    0,    0,    0,  125,  -20,  -15,    0,  -45,    0,
    0,    0,  273,  482,    0,    0,    0,    0,    0, -157,
   73,  -20,    0,   77,  -20,  302,    0,   79,  284,  292,
  284,  284,    0,  460,  360,  492,   89,    0,  265,  321,
  -20,    0,    0,    0,    0,  311,  315,  -38,  334,  356,
  342,  -15,    0,    0,  343,    0,    0,  131,  345,  347,
  -56, -146,  309,    0,  464,    0,  478,    0,    0,    0,
  364,  363,   57,  388,  379,  396,  143,    0,  157,    0,
  378,    0,    0,    0,    0,  460,    0,    0,  460,  179,
  384,    0, -144,    0,  186, -144,   57,  418,  426,   57,
  431,   57,    0,    0,  205, -144, -144, -144, -144,    0,
    0,    0,    0,  435,   57,    0,  442,    0,  446,    0,
    0,    0,    0,    0,    0,  447,    0,  199,    0,    0,
    0,  449,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -235,    0,    0,    0,    0,    0,    0,
    0,  481,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  498,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  462,  204,    0,    0,    0,
    0,    1,    0,    0,    0,  116,   47,    0,    0,    0,
  456,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   -3,    0,    0,  463,    0,    0,
    0,    0,   24,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  236,    0,
    0,    0,    0,    0,    0,    0,    0,   70,    0,   93,
    0,    0,    0,    0,    0,  151,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  456,    0,    0,  -41,    0,    0,    0,  238,    0,
  236,  236,  153,    0,    0,    0,    0,    0,    0,    0,
  139,    0,    0,    0,    0,    0,  -21,  141,  225,    0,
  227,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  229,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  327,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  159,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
final static short yygindex[] = {                         0,
  170,  439,    0,  438,  -33,    0,    0,    0,    0,  -23,
    0,    0,    0,  472,  -36,    0,    0,    0,  307,  -62,
   -1,   23,    0,  377,   44,    0,    0,    0,    0,  340,
  191,  212, -103,  282,  -80,    0,  -30,  -85,  301,    0,
    0,    0,    0,    0,
};
final static int YYTABLESIZE=768;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        125,
   77,  213,  224,  114,   55,   55,   60,   29,   55,  109,
   54,   36,  149,   34,   87,  163,   55,  125,   86,   27,
   45,   43,   95,   81,   96,   55,   56,   61,   29,   54,
   70,   85,  154,   43,   69,   46,   43,   56,   54,  117,
   56,   77,   77,   77,   77,   77,   69,   77,    9,   10,
   84,   62,   32,    1,   55,   72,   73,  164,   30,   77,
   77,   77,   77,    2,   81,   81,   81,   81,   81,   67,
   81,   55,   55,   55,   55,   71,   55,  156,   55,   92,
   44,   93,   81,   81,   81,   81,   94,   69,  203,   69,
   69,   69,   68,  107,  205,   55,   79,  188,  145,   87,
  146,   54,   48,   55,  187,   69,   69,   69,   69,  225,
   67,  225,   67,   67,   67,   39,  160,  162,  205,  226,
  158,  159,  227,   55,  227,  165,   49,   97,   67,   67,
   67,   67,   98,   68,   65,   68,   68,   68,   40,   74,
  247,   35,   79,  249,   99,  181,   95,   54,   96,    9,
   10,   68,   68,   68,   68,  106,   82,   95,  108,   96,
   95,   78,   96,   54,  271,  180,  100,   95,   55,   96,
   54,   27,  233,   11,   39,   31,  236,  124,  126,  125,
   76,   30,   54,  243,  101,   95,  103,   96,   10,   55,
  217,  132,  102,   57,  133,  246,   59,   40,  248,  223,
  158,  159,  111,   12,  108,  104,   54,  148,   54,  105,
  182,  183,  120,   55,  197,  198,   55,  108,   55,  112,
  131,   59,   52,  212,  110,   28,    5,   53,   35,  113,
  128,   55,    7,   33,   85,   27,  125,  125,   11,    9,
   10,   52,   27,   54,   55,   27,   53,  129,   27,   67,
   52,    9,   10,   43,   27,   53,   68,   77,  130,   77,
   77,   77,   12,   83,   77,   29,  162,   28,   77,   26,
   77,   77,  132,   77,   77,   77,   77,  133,   77,   77,
   81,  134,   81,   81,   81,  138,  140,   81,  135,    9,
   10,   81,  136,   81,   81,  147,   81,   81,   81,   81,
  157,   81,   81,   69,  150,   69,   69,   69,  142,  144,
   69,  151,   77,   52,   69,  171,   69,   69,   53,   69,
   69,   69,   69,  178,   69,   69,   67,  172,   67,   67,
   67,  184,  179,   67,  189,  158,  159,   67,  191,   67,
   67,  192,   67,   67,   67,   67,  193,   67,   67,   68,
  196,   68,   68,   68,  207,   91,   68,  208,   77,   52,
   68,  209,   68,   68,   53,   68,   68,   68,   68,  210,
   68,   68,   39,  211,   51,   52,  121,  122,  123,   39,
   53,  137,   52,   39,  118,   39,   39,   53,   39,   39,
   39,   39,  214,  139,   52,   40,  215,   30,  220,   53,
  216,  218,   40,  237,   30,  222,   40,   30,   40,   40,
   30,   40,   40,   40,   40,  108,   30,  141,   52,  143,
   52,  238,  108,   53,  244,   53,  108,  240,  108,  108,
   11,  108,  108,  108,  108,  242,  245,   11,  124,  126,
  125,   11,  250,   11,   11,   10,   11,   11,   11,   11,
   42,  166,   10,  252,   59,   52,   10,  255,   10,   10,
   53,   10,   10,   10,   10,   42,  256,   12,  170,   42,
  258,   12,  260,   12,   12,  265,   12,   12,   12,   12,
    5,   29,  267,   28,  232,   26,  269,  270,   29,  273,
   28,   29,   26,   28,   29,   26,   28,    3,   26,  134,
   29,   50,   28,   63,   26,   61,   58,   75,  195,  173,
  170,  170,  115,  115,  251,  241,    0,  253,    0,  239,
    0,    0,    0,    0,    0,  155,  112,  261,  262,  263,
  264,    0,    0,    5,    0,    0,  113,    0,  221,    7,
    4,    0,    0,  254,  235,   11,  257,    5,  259,    0,
  153,  115,    0,    7,    8,    0,  166,    9,   10,   11,
    0,  266,    0,    0,  225,  112,    0,  167,    0,  221,
    0,  153,    5,    0,  229,  230,    0,  227,    7,  152,
  112,  166,  109,  118,   11,    0,    0,    5,    0,    0,
  118,  186,  109,    7,  118,  109,  118,    0,    0,   11,
  204,  112,  118,    0,    0,    0,    0,  194,    5,  167,
  167,  200,  153,  186,    7,  204,  112,  166,    0,    0,
   11,    0,    0,    5,    0,    0,    0,    0,    0,    7,
    0,    0,    0,    0,    0,   11,  153,  121,  122,  123,
  231,    4,  186,  112,  231,    0,    0,    0,    5,    0,
    5,    6,    0,  113,    7,    8,    7,    4,    9,   10,
   11,    0,   11,  200,    5,    0,  200,    0,   41,    0,
    7,    8,    4,    0,    9,   10,   11,    0,    0,    5,
    0,    4,    0,   50,    0,    7,    8,    0,    5,    9,
   10,   11,   66,    0,    7,    8,    4,    0,    9,   10,
   11,    0,    0,    5,    0,    0,    0,    0,    0,    7,
    8,  112,    0,    9,   10,   11,  112,    0,    5,  174,
  112,  175,    0,    5,    7,    0,  199,    5,    0,    7,
   11,  234,  166,    7,  112,   11,  166,    0,  112,   11,
    0,    5,    0,    0,  230,    5,    0,    7,  112,  185,
  166,    7,    0,   11,    0,    5,    0,   11,    0,  206,
    0,    7,    0,    0,    0,    0,    0,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   40,   59,   41,   28,   29,   41,   40,   32,   62,
   45,   40,   62,   60,   48,  119,   40,   59,   41,   41,
  257,  257,   43,    0,   45,   49,   28,   29,   40,   45,
   32,  257,  113,   59,   41,  272,  272,   41,   45,   76,
   44,   41,   42,   43,   44,   45,    0,   47,  274,  275,
   44,   29,   40,  257,   78,   33,   34,  120,   91,   59,
   60,   61,   62,  267,   41,   42,   43,   44,   45,    0,
   47,   95,   96,   97,   98,   60,  100,  114,  102,   91,
   59,  257,   59,   60,   61,   62,  262,   41,  174,   43,
   44,   45,    0,   71,  175,  119,   40,  160,  100,  133,
  102,   45,   40,  127,  262,   59,   60,   61,   62,  256,
   41,  256,   43,   44,   45,    0,   59,  119,  199,  266,
  278,  279,  269,  147,  269,  127,   40,   42,   59,   60,
   61,   62,   47,   41,  262,   43,   44,   45,    0,  258,
  226,  257,   40,  229,   41,  147,   43,   45,   45,  274,
  275,   59,   60,   61,   62,   41,  257,   43,    0,   45,
   43,   59,   45,   45,  268,   41,   40,   43,  192,   45,
   45,    2,  203,    0,   59,    6,  207,   60,   61,   62,
   41,   41,   45,   41,   41,   43,   93,   45,    0,  213,
  192,   41,   44,   41,   44,  226,   44,   59,  229,  256,
  278,  279,  262,    0,  257,   41,   45,  257,   45,   41,
  256,  257,   59,  237,  171,  172,  240,   59,  242,  257,
   41,  256,  257,  262,   62,  258,  264,  262,  257,  267,
  257,  255,  270,  280,  257,  257,  278,  279,  276,  274,
  275,  257,  264,   45,  268,  267,  262,  267,  270,  256,
  257,  274,  275,  257,  276,  262,  263,  257,  257,  259,
  260,  261,   59,  257,  264,   41,  268,   41,  268,   41,
  270,  271,   41,  273,  274,  275,  276,   44,  278,  279,
  257,   41,  259,  260,  261,   95,   96,  264,  262,  274,
  275,  268,   91,  270,  271,  258,  273,  274,  275,  276,
   59,  278,  279,  257,  257,  259,  260,  261,   97,   98,
  264,  257,  256,  257,  268,  267,  270,  271,  262,  273,
  274,  275,  276,   93,  278,  279,  257,  267,  259,  260,
  261,   59,  262,  264,  262,  278,  279,  268,  262,  270,
  271,   40,  273,  274,  275,  276,  268,  278,  279,  257,
   59,  259,  260,  261,  266,   49,  264,   93,  256,  257,
  268,   41,  270,  271,  262,  273,  274,  275,  276,   59,
  278,  279,  257,   59,  256,  257,  259,  260,  261,  264,
  262,  256,  257,  268,   78,  270,  271,  262,  273,  274,
  275,  276,   59,  256,  257,  257,   41,  257,  268,  262,
   59,   59,  264,   40,  264,   59,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  256,  257,  256,
  257,   59,  264,  262,  268,  262,  268,   40,  270,  271,
  257,  273,  274,  275,  276,   40,   59,  264,   60,   61,
   62,  268,   59,  270,  271,  257,  273,  274,  275,  276,
   12,  273,  264,  268,  256,  257,  268,   40,  270,  271,
  262,  273,  274,  275,  276,   27,   41,  264,  129,   31,
   40,  268,  268,  270,  271,   41,  273,  274,  275,  276,
    0,  257,   41,  257,  203,  257,   41,   41,  264,   41,
  264,  267,  264,  267,  270,  267,  270,    0,  270,   44,
  276,   40,  276,  268,  276,  268,   44,   36,  169,  133,
  171,  172,   75,   76,  233,  215,   -1,  236,   -1,  213,
   -1,   -1,   -1,   -1,   -1,  256,  257,  246,  247,  248,
  249,   -1,   -1,  264,   -1,   -1,  267,   -1,  199,  270,
  257,   -1,   -1,  237,  205,  276,  240,  264,  242,   -1,
  113,  114,   -1,  270,  271,   -1,  273,  274,  275,  276,
   -1,  255,   -1,   -1,  256,  257,   -1,  129,   -1,  230,
   -1,  134,  264,   -1,  266,  267,   -1,  269,  270,  256,
  257,  273,  256,  257,  276,   -1,   -1,  264,   -1,   -1,
  264,  154,  266,  270,  268,  269,  270,   -1,   -1,  276,
  256,  257,  276,   -1,   -1,   -1,   -1,  169,  264,  171,
  172,  174,  175,  176,  270,  256,  257,  273,   -1,   -1,
  276,   -1,   -1,  264,   -1,   -1,   -1,   -1,   -1,  270,
   -1,   -1,   -1,   -1,   -1,  276,  199,  259,  260,  261,
  203,  257,  205,  257,  207,   -1,   -1,   -1,  264,   -1,
  264,  267,   -1,  267,  270,  271,  270,  257,  274,  275,
  276,   -1,  276,  226,  264,   -1,  229,   -1,  268,   -1,
  270,  271,  257,   -1,  274,  275,  276,   -1,   -1,  264,
   -1,  257,   -1,  268,   -1,  270,  271,   -1,  264,  274,
  275,  276,  268,   -1,  270,  271,  257,   -1,  274,  275,
  276,   -1,   -1,  264,   -1,   -1,   -1,   -1,   -1,  270,
  271,  257,   -1,  274,  275,  276,  257,   -1,  264,  265,
  257,  267,   -1,  264,  270,   -1,  267,  264,   -1,  270,
  276,  268,  273,  270,  257,  276,  273,   -1,  257,  276,
   -1,  264,   -1,   -1,  267,  264,   -1,  270,  257,  268,
  273,  270,   -1,  276,   -1,  264,   -1,  276,   -1,  268,
   -1,  270,   -1,   -1,   -1,   -1,   -1,  276,
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
"encabezado_for1 : asignacion_for ';' condicion ';' up_down CONSTANTE",
"encabezado_for1 : asignacion_for ';' condicion ';' CONSTANTE",
"encabezado_for1 : asignacion_for condicion ';' up_down CONSTANTE",
"encabezado_for1 : asignacion_for ';' condicion up_down CONSTANTE",
"encabezado_for1 : asignacion_for ';' condicion ';' up_down",
"encabezado_for2 : asignacion_for ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : asignacion_for ';' condicion ';' CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : asignacion_for condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : asignacion_for ';' condicion up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : asignacion_for ';' condicion ';' up_down '(' condicion ')'",
"asignacion_for : ID ASIGNACION CONSTANTE",
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
"cuerpo_if_unico : sentencia_return error",
"cuerpo_if_unico : BEGIN sentencia_return ';' END",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables END",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables sentencia_return END",
"cuerpo_if_bloque : BEGIN error",
"cuerpo_if_bloque : list_sentencias_ejecutables END",
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
"salida_mensaje : OUTF '(' error ')'",
"salida_mensaje : OUTF '(' ')'",
};

//#line 818 "gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;

static NodoComun raiz;
static String ambito = "main";
static boolean inIF = false;
static boolean hasReturn = false;
static boolean enFuncion = false;
static String funcionActual;
static int cantReturns = 0;
static List<String> varDeclaradas = new ArrayList<>();
static String tipoActual;
static List<String> erroresSemanticos = new ArrayList<>();
public static Map<String,String> tiposDeclarados = new HashMap<>();
public static Map<String,NodoComun> funcionesDeclaradas = new HashMap<>();
static List<Nodo> expresiones1 = new ArrayList<>();
static List<Nodo> expresiones2 = new ArrayList<>();
static boolean inList1 = false;
static boolean inList2 = false;
static boolean funcionAutoinvocada = false;

public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
      this.yylval = new ParserVal(t.getLexema().toString());
      return (int) t.getId();
    }
    return 0;
}

public static boolean getFuncionAutoinvocada(){
    return funcionAutoinvocada;
}

public static void yyerror(String error){
    if (!error.contains("syntax error"))
        AnalizadorLexico.agregarErrorSintactico(error);
}

public static void addAmbito(String ambitoActual){
    ambito = ambito.concat("@" + ambitoActual);
}

public void removeAmbito(){
        int index = ambito.lastIndexOf('@');

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

public static boolean noHayErrores(){
    return erroresSemanticos.isEmpty() && errorSintactico.isEmpty() && errorLexico.isEmpty();
}

public String buscarAmbito(String ambitoActual, String lexema) {
    String ambito = ambitoActual;

    while (!TablaSimbolos.existeSimbolo(lexema + "@" + ambito)) {
        if (ambito.equals("main")) {
            return "";
        }
        int index = ambito.lastIndexOf('@');
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
    Token t1 = TablaSimbolos.getToken(var + "@" + ambito);
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
    if (!(nodo1.getNombre().contains("error") || nodo3.getNombre().contains("error"))) {
    if (!(nodo1.getTipo().equals(nodo3.getTipo()))){
        agregarErrorSemantico("Incompatibilidad de tipos en la " + op);
        ret = new NodoComun("error");
    }
    else
        ret.setTipo(nodo1.getTipo());
    }

    return ret;
}

private Nodo generarLlamadoFuncion(NodoComun funcion, Nodo copia, String tipoCasteo) {
    NodoComun salida = null;
    if (funcion != null) {
        NodoHoja param = (NodoHoja)funcion.getIzq(); // Parámetro formal de la función
        String tipoFormal = param.getTipo(); // Tipo esperado por la función
        String tipoReal = copia.getTipo();   // Tipo de la expresión original

        if (tipoCasteo == null) {
            // Sin casteo: los tipos deben coincidir
            if (tipoFormal.equals(tipoReal)) {
                salida = new NodoComun(funcion, copia, null);
                salida.setUso("llamado");
            } else {
                agregarErrorSemantico("El tipo del parámetro real no coincide con el del parámetro formal");
                return new NodoHoja("error");
            }
        } else {
            // Con casteo: validar que sea permitido
            if (tipoCasteo.equals(tipoReal)) {
                // Intento de forzar un casteo al mismo tipo
                AnalizadorLexico.agregarWarning("El tipo del parámetro real ya es del tipo solicitado en el casteo");
                return new NodoHoja("error");
            } else if (tipoFormal.equals(tipoCasteo) && esCasteoValido(tipoReal, tipoCasteo)) {
                // Casteo válido
                //param.setNombre(copia.getNombre());
                NodoHoja newCopia = new NodoHoja(copia.getNombre(),param.getToken());
                NodoHoja nodoTipoReal = new NodoHoja(tipoReal, null);
                salida = new NodoComun(funcion, newCopia, nodoTipoReal);
                salida.setUso("llamadoConCasteo");
            } else {
                // Casteo inválido
                agregarErrorSemantico("El casteo de " + tipoReal + " a " + tipoCasteo + " no es válido");
                return new NodoHoja("error");
            }
        }
    }
    return salida;
}

// Método auxiliar para validar si un casteo es válido
private boolean esCasteoValido(String tipoOrigen, String tipoDestino) {
    // Regla: permitir solo ULONGINT ↔ SINGLE
    return (tipoOrigen.equals("ulongint") && tipoDestino.equals("single")) ||
           (tipoOrigen.equals("single") && tipoDestino.equals("ulongint"));
}

public NodoComun getRaiz(){
    return this.raiz;
}

public static List<Nodo> getFuncionesDeclaradas(){
    return new ArrayList<>(funcionesDeclaradas.values());
}

public static boolean esOperacion(String nombre){
    return nombre.equals("*") || nombre.equals("/") || nombre.equals("+") || nombre.equals("-");
}
//#line 773 "Parser.java"
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
//#line 22 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa"); if (noHayErrores()){raiz = new NodoComun("PROGRAMA", (Nodo)val_peek(1).obj);}}
break;
case 2:
//#line 23 "gramatica.y"
{yyerror("El programa debe tener un nombre");}
break;
case 3:
//#line 24 "gramatica.y"
{yyerror("Falta delimitador END del programa");}
break;
case 4:
//#line 25 "gramatica.y"
{yyerror("Falta delimitador BEGIN del programa");}
break;
case 5:
//#line 26 "gramatica.y"
{yyerror("Faltan los delimitadores del programa");}
break;
case 6:
//#line 29 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo)val_peek(1).obj, (Nodo)val_peek(0).obj);}
break;
case 7:
//#line 30 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 9:
//#line 35 "gramatica.y"
{yyval=val_peek(1);}
break;
case 10:
//#line 36 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
//#line 37 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 12:
//#line 41 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");
                         for (String var: varDeclaradas){
                            Token t = TablaSimbolos.getToken(var);
                            if (!TablaSimbolos.existeSimbolo(var + "@" + ambito)){
                                String tipo = t.getTipo();
                                if (tipo != null){
                                    if (tipo.toLowerCase().equals(tipoActual.toLowerCase()))
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya esta declarada");
                                    else
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya estaba declarada. Se cambio su tipo a " + tipoActual);
                                }
                                t.getLexema().setLength(0);
                                t.getLexema().append(var).append("@").append(ambito);
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
//#line 68 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
//#line 69 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
//#line 73 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion"); yyval=val_peek(0);}
break;
case 16:
//#line 74 "gramatica.y"
{yyval = val_peek(0);AnalizadorLexico.agregarWarning("Se ha llamado a una función pero su valor no ha sido utilizado"); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 17:
//#line 75 "gramatica.y"
{yyval=val_peek(0);}
break;
case 18:
//#line 76 "gramatica.y"
{yyval=val_peek(0);}
break;
case 19:
//#line 77 "gramatica.y"
{yyval=val_peek(0);}
break;
case 20:
//#line 82 "gramatica.y"
{ yyval.obj = new NodoComun("For",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);}
break;
case 21:
//#line 83 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
//#line 84 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
//#line 85 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 24:
//#line 89 "gramatica.y"
{yyval=val_peek(0);}
break;
case 25:
//#line 90 "gramatica.y"
{yyval=val_peek(0);}
break;
case 26:
//#line 94 "gramatica.y"
{
                                                        NodoHoja constanteUpDown = new NodoHoja(val_peek(0).sval,TablaSimbolos.getToken(val_peek(0).sval));
                                                        Nodo incremento = new NodoComun("Incremento", (Nodo)val_peek(1).obj, constanteUpDown); /*Idem*/
                                                        Nodo condicion = (Nodo)val_peek(3).obj;
                                                        Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento",(Nodo)val_peek(5).obj , incremento);
                                                        yyval.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condicion);
                                                        AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");
                                                        }
break;
case 27:
//#line 102 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
//#line 103 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
//#line 104 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
//#line 105 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
//#line 109 "gramatica.y"
{

                                                                                       NodoHoja constanteUpDown = new NodoHoja(val_peek(4).sval,TablaSimbolos.getToken(val_peek(4).sval));
                                                                                       Nodo asignacion = (Nodo)val_peek(9).obj;
                                                                                       Nodo incremento = new NodoComun("Incremento", (Nodo)val_peek(5).obj, constanteUpDown); /*Idem*/
                                                                                       Nodo condicion = (Nodo)val_peek(7).obj;
                                                                                       Nodo iteradorCondicion = (Nodo)val_peek(1).obj;

                                                                                       Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento", asignacion, incremento);
                                                                                       Nodo condiciones = new NodoComun("Condiciones", condicion, iteradorCondicion);

                                                                                       yyval.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condiciones);

                                                                                       AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");
                                                                                       TablaSimbolos.removeToken(val_peek(9).sval);
                                                                                       }
break;
case 32:
//#line 126 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
//#line 127 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
//#line 128 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
//#line 129 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 36:
//#line 133 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(2).sval);
                                        NodoHoja idAsignacion = null;
                                        if (!ambitoVar.equals("")) {
                                            Token t = TablaSimbolos.getToken(val_peek(2).sval + "@" + ambitoVar);
                                            idAsignacion = new NodoHoja(val_peek(2).sval + "@" + ambitoVar, t);
                                        }
                                        else {
                                            Token t = new Token();
                                            t.setTipo(ENTERO);
                                            t.getLexema().setLength(0);
                                            t.getLexema().append(val_peek(2).sval).append("@").append(ambito);
                                            t.setAmbito(ambito);
                                            t.setUso("variable");
                                            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                            idAsignacion = new NodoHoja(val_peek(2).sval + "@" + ambito, t);
                                        }
                                        NodoHoja constante = new NodoHoja(val_peek(0).sval, TablaSimbolos.getToken(val_peek(0).sval));
                                        yyval.obj = new NodoComun(val_peek(1).sval, idAsignacion, constante);
                                        TablaSimbolos.removeToken(val_peek(2).sval);
                                        }
break;
case 37:
//#line 156 "gramatica.y"
{yyval.obj = new NodoHoja("Up");}
break;
case 38:
//#line 157 "gramatica.y"
{yyval.obj = new NodoHoja("Down");}
break;
case 39:
//#line 161 "gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,val_peek(2).sval);
                              Nodo asignacion = new NodoHoja("error");
                              Token t = null;
                              if (ambitoVar.equals("")){
                                  t = TablaSimbolos.getToken(val_peek(2).sval);
                                  if (t.getTipo() == null){
                                        agregarErrorSemantico("La variable '" + val_peek(2).sval + "' no fue declarada");
                                        yyval.obj = new NodoHoja("error");
                                  }
                                  else {
                                        t.getLexema().setLength(0);
                                        t.getLexema().append(val_peek(2).sval).append("@").append(ambito);
                                        t.setAmbito(ambito);
                                        t.setUso("variable");
                                        TablaSimbolos.removeToken(val_peek(2).sval);
                                        TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                        NodoHoja id = new NodoHoja(t.getLexema().toString(),t);
                                        yyval.obj = new NodoComun(val_peek(1).sval ,id, (Nodo)val_peek(0).obj);
                                  }
                              }
                              else {
                                  t = TablaSimbolos.getToken(val_peek(2).sval + "@" + ambitoVar);
                                  if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))){
                                        agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")" );
                                        yyval.obj = new NodoHoja("error");
                                  }
                                  else {
                                        NodoHoja id = new NodoHoja(t.getLexema().toString(),t);
                                        yyval.obj = new NodoComun(val_peek(1).sval ,id, (Nodo)val_peek(0).obj);
                                  }
                              }
                              TablaSimbolos.removeToken(val_peek(2).sval);
                            }
break;
case 40:
//#line 194 "gramatica.y"
{
                                                String ambitoVar = buscarAmbito(ambito,val_peek(5).sval);
                                                if (ambitoVar.equals("")){
                                                    agregarErrorSemantico("La variable '" + val_peek(5).sval + "' no fue declarada");
                                                    yyval.obj = new NodoHoja("error");
                                                }
                                                else {
                                                    Token t = TablaSimbolos.getToken(val_peek(5).sval + "@" + ambitoVar);
                                                    String tipo = t.getTipo();
                                                    if (tiposDeclarados.containsKey(tipo)){
                                                        String tipoTriple = tiposDeclarados.get(tipo);
                                                        NodoHoja nodo = new NodoHoja(val_peek(5).sval + val_peek(4).sval + val_peek(3).sval + val_peek(2).sval, t);
                                                        nodo.setUso("arreglo");
                                                        yyval.obj = new NodoComun(val_peek(1).sval,nodo,(Nodo)val_peek(0).obj);
                                                    }
                                                    else {
                                                        agregarErrorSemantico("La variable '" + val_peek(5).sval + "' no es de un tipo TRIPLE definido");
                                                        yyval.obj = new NodoHoja("error");
                                                    }
                                                }
                                                String index = TablaSimbolos.getToken(val_peek(3).sval).getLexema().toString();
                                                if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                                    agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                                    yyval.obj = new NodoHoja("error");
                                                }
                                                TablaSimbolos.removeToken(val_peek(5).sval);

                                                }
break;
case 41:
//#line 222 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 43:
//#line 227 "gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
           if (ambitoVar.equals(""))
                agregarErrorSemantico("El tipo '" + val_peek(0).sval + "' no fue declarado");
           else {
            Token t = TablaSimbolos.getToken(val_peek(0).sval + "@" + ambitoVar);
            if (t.getUso() == null || !t.getUso().equals("tipo"))
                yyerror("El identificador '" + val_peek(0).sval + "' no es un tipo definido");
            else {
                tipoActual = val_peek(0).sval;
            }
            }
            TablaSimbolos.removeToken(val_peek(0).sval);
         }
break;
case 44:
//#line 243 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 45:
//#line 244 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 46:
//#line 248 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 47:
//#line 249 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 48:
//#line 250 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 49:
//#line 254 "gramatica.y"
{hasReturn = false;
                enFuncion = true;
                funcionActual = val_peek(0).sval;
                String idFuncion = val_peek(0).sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (t.getTipo() == null){
                     if (!TablaSimbolos.existeSimbolo(idFuncion + "@" + ambito)){
                        t.getLexema().setLength(0);
                        t.getLexema().append(idFuncion).append("@").append(ambito); /*aca agrega una vez el ambito*/
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
                     NodoComun encabezado = new NodoComun(idFuncion + "@" + ambito);
                     encabezado.setToken(t);
                     yyval.obj = encabezado;
                 }
                 else {
                    agregarErrorSemantico("La variable '" + idFuncion + "' ya fue declarada");
                    yyval.obj = new NodoComun("error");
                 }
                 addAmbito(idFuncion);
                 }
break;
case 50:
//#line 283 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 51:
//#line 287 "gramatica.y"
{ if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         if ((((NodoComun)val_peek(0).obj) != null)&&(!((NodoComun)val_peek(0).obj).getNombre().equals("Cuerpo vacio"))) {
                                                             Nodo parametro = (Nodo)val_peek(3).obj;
                                                             NodoComun funcion = (NodoComun)val_peek(5).obj; /*Encabezado con nombre funcion, este tiene el tipo*/
                                                             NodoComun cuerpo = (NodoComun)val_peek(0).obj;

                                                             funcion.setUso("funcion");
                                                             funcion.setIzq(parametro);
                                                             funcion.setDer(cuerpo);

                                                             funcionesDeclaradas.put(funcion.getNombre(),funcion);
                                                             removeAmbito();
                                                             enFuncion = false;
                                                             }
                                                         }
break;
case 53:
//#line 304 "gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 54:
//#line 305 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 55:
//#line 309 "gramatica.y"
{
               Token t = TablaSimbolos.getToken(val_peek(0).sval);
               if (t != null){
                   if (t.getTipo() != null)
                        AnalizadorLexico.agregarWarning("La variable '" + val_peek(0).sval + "' ya esta declarada");
                   t.getLexema().setLength(0);
                   t.getLexema().append(val_peek(0).sval).append("@").append(ambito);
                   t.setAmbito(ambito);
                   t.setUso("parametro");
                   t.setTipo(tipoActual);
                   TablaSimbolos.removeToken(val_peek(0).sval);
                   TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
               }
              Nodo param = new NodoHoja(t.getLexema().toString(), t);
              param.setTipo(tipoActual);
              yyval.obj = param;
            }
break;
case 56:
//#line 326 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 60:
//#line 339 "gramatica.y"
{  yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);
                                                    hasReturn = true;}
break;
case 61:
//#line 341 "gramatica.y"
{yyval=val_peek(0);}
break;
case 62:
//#line 342 "gramatica.y"
{yyval=val_peek(1); hasReturn = true;}
break;
case 63:
//#line 343 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio"); yyval.obj = new NodoComun("Cuerpo vacio");}
break;
case 64:
//#line 348 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(1).obj, (Nodo) val_peek(0).obj);}
break;
case 65:
//#line 349 "gramatica.y"
{yyval=val_peek(0);}
break;
case 66:
//#line 354 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           yyval.obj = new NodoComun("Return", (Nodo)val_peek(1).obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 67:
//#line 362 "gramatica.y"
{
                         String expresion = ((Nodo)val_peek(2).obj).getNombre();
                         String termino = ((Nodo)val_peek(0).obj).getNombre();
                         if (!(expresion.contains("error") || termino.contains("error"))){
                             Nodo nIzq = (Nodo)val_peek(2).obj;
                             Nodo nDer = (Nodo)val_peek(0).obj;
                             yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                         }
                         else {
                            yyval.obj = new NodoHoja("error");
                         }
                        }
break;
case 68:
//#line 374 "gramatica.y"
{
                         String expresion = ((Nodo)val_peek(2).obj).getNombre();
                         String termino = ((Nodo)val_peek(0).obj).getNombre();
                         if (!(expresion.contains("error") || termino.contains("error"))){
                             Nodo nIzq = (Nodo)val_peek(2).obj;
                             Nodo nDer = (Nodo)val_peek(0).obj;
                             yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                         }
                         else {
                            yyval.obj = new NodoHoja("error");
                         }
                        }
break;
case 69:
//#line 386 "gramatica.y"
{yyval = val_peek(0);}
break;
case 70:
//#line 387 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
//#line 388 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 72:
//#line 392 "gramatica.y"
{
                         String termino = ((Nodo)val_peek(2).obj).getNombre();
                         String factor = ((Nodo)val_peek(0).obj).getNombre();
                         if (!(termino.contains("error") || factor.contains("error"))){
                             Nodo nIzq = (Nodo)val_peek(2).obj;
                             Nodo nDer = (Nodo)val_peek(0).obj;
                             yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                         }
                         else {
                            yyval.obj = new NodoHoja("error");
                         }
                        }
break;
case 73:
//#line 404 "gramatica.y"
{
                         String termino = ((Nodo)val_peek(2).obj).getNombre();
                         String factor = ((Nodo)val_peek(0).obj).getNombre();
                         if (!(termino.contains("error") || factor.contains("error"))){
                             Nodo nIzq = (Nodo)val_peek(2).obj;
                             Nodo nDer = (Nodo)val_peek(0).obj;
                             yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                         }
                         else {
                            yyval.obj = new NodoHoja("error");
                         }
                        }
break;
case 74:
//#line 416 "gramatica.y"
{yyval = val_peek(0);}
break;
case 75:
//#line 417 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 76:
//#line 418 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 77:
//#line 422 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La variable '" + val_peek(0).sval + "' no fue declarada");
            Nodo aux = new NodoHoja("error");
            yyval.obj = aux;
        }
        else {
            Token t = TablaSimbolos.getToken(val_peek(0).sval + "@" + ambitoVar);
            if (!(t.getUso().equals("variable") || t.getUso().equals("parametro")))
                agregarErrorSemantico("'" + val_peek(0).sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                Nodo aux = new NodoHoja(val_peek(0).sval+"@"+ambitoVar, t);
                yyval.obj = aux;
            }
        }
        TablaSimbolos.removeToken(val_peek(0).sval);
        }
break;
case 78:
//#line 439 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                t.setValor(val_peek(0).sval);
                t.setUso("constante");
                yyval.obj = new NodoHoja(val_peek(0).sval,t);
                }
break;
case 79:
//#line 444 "gramatica.y"
{yyval = val_peek(0); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 80:
//#line 445 "gramatica.y"
{    String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + val_peek(3).sval + "' no fue declarada");
                                    yyval.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken(val_peek(3).sval + "@" + ambitoVar);
                                    String tipo = t.getTipo();
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja(val_peek(3).sval + val_peek(2).sval + val_peek(1).sval + val_peek(0).sval, t);
                                        yyval.obj = nodo;
                                    }
                                    else {
                                        agregarErrorSemantico("La variable '" + val_peek(3).sval + "' no es de un tipo TRIPLE definido");
                                        yyval.obj = new NodoHoja("error");
                                    }
                                }
                             String index = TablaSimbolos.getToken(val_peek(1).sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 yyval.obj = new NodoHoja("error");
                             }
                             TablaSimbolos.removeToken(val_peek(3).sval);
                            }
break;
case 81:
//#line 470 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + val_peek(0).sval + "' no fue declarada");
                         yyval.obj = new NodoHoja("error");
                     }
                     else {
                         Token t = TablaSimbolos.getToken(val_peek(0).sval + "@" + ambitoVar);
                         if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))){
                             agregarErrorSemantico("'" + val_peek(0).sval + "' no es una variable. Es un/a " + t.getUso());
                             yyval.obj = new NodoHoja("error");
                         }
                         else {
                             yyval.obj = new NodoHoja(val_peek(1).sval + val_peek(0).sval + "@" + ambitoVar,t);
                         }
                     }
                     TablaSimbolos.removeToken(val_peek(0).sval);
                     }
break;
case 82:
//#line 487 "gramatica.y"
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
case 83:
//#line 501 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + val_peek(3).sval + "' no fue declarada");
                                    yyval.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken(val_peek(3).sval + "@" + ambitoVar);
                                    String tipo = val_peek(4).sval;
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja(val_peek(4).sval + val_peek(3).sval + val_peek(2).sval + val_peek(1).sval + val_peek(0).sval, t);
                                        yyval.obj = nodo;
                                    }
                                    else {
                                        agregarErrorSemantico("La variable '" + val_peek(3).sval + "' no es de un tipo TRIPLE definido");
                                        yyval.obj = new NodoHoja("error");
                                    }
                                }
                             String index = TablaSimbolos.getToken(val_peek(1).sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 yyval.obj = new NodoHoja("error");
                             }
                             TablaSimbolos.removeToken(val_peek(3).sval);
                            }
break;
case 84:
//#line 529 "gramatica.y"
{String idTipo = val_peek(0).sval;
                                         Token t = TablaSimbolos.getToken(idTipo);
                                         if (t.getTipo() == null){
                                             if (!TablaSimbolos.existeSimbolo(idTipo + "@" + ambito)){
                                                t.getLexema().setLength(0);
                                                t.getLexema().append(idTipo).append("@").append(ambito);
                                                t.setAmbito(ambito);
                                                t.setUso("tipo");
                                                t.setTipo(val_peek(2).sval);
                                                TablaSimbolos.removeToken(idTipo);
                                                TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                                tiposDeclarados.put(val_peek(0).sval, val_peek(2).sval.toLowerCase());
                                             }
                                             else {
                                                TablaSimbolos.removeToken(idTipo);
                                                variableYaDeclarada(idTipo);
                                             }
                                         }
                                         else {
                                            agregarErrorSemantico("La variable '" + idTipo + "' ya fue declarada");
                                            yyval.obj = new NodoComun("error");
                                         }
                                         }
break;
case 85:
//#line 552 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 86:
//#line 553 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 87:
//#line 554 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 88:
//#line 555 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 89:
//#line 556 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 90:
//#line 560 "gramatica.y"
{
        AnalizadorLexico.agregarEstructura("Se reconocio invocacion a funcion");
        String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La funcion '" + val_peek(3).sval + "' no fue declarada");
            yyval.obj = new NodoHoja("error");
        }
        else {
            if (enFuncion && funcionActual.equals(val_peek(3).sval)){
                yyval.obj = new NodoComun("autoinvocacion");
            }
            else {
                if (funcionesDeclaradas.containsKey(val_peek(3).sval + "@" + ambitoVar)){
                    Nodo exp = (Nodo)val_peek(1).obj;
                    NodoComun funcion = funcionesDeclaradas.get(val_peek(3).sval + "@" + ambitoVar);
                    yyval.obj = generarLlamadoFuncion(funcion,exp,null);
                }
                else {
                    agregarErrorSemantico("La funcion '" + val_peek(3).sval + "' no fue declarada");
                    yyval.obj = new NodoHoja("error");
                }
            }
        }
        TablaSimbolos.removeToken(val_peek(3).sval);
    }
break;
case 91:
//#line 585 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 92:
//#line 586 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 93:
//#line 587 "gramatica.y"
{
            AnalizadorLexico.agregarEstructura("Se reconocio conversion");
            String ambitoVar = buscarAmbito(ambito,val_peek(6).sval);
            if (ambitoVar.equals("")){
                agregarErrorSemantico("La funcion '" + val_peek(6).sval + "' no fue declarada");
                yyval.obj = new NodoHoja("error");
            }
            else {
                if (funcionesDeclaradas.containsKey(val_peek(6).sval + "@" + ambitoVar)){
                        Nodo exp = (Nodo)val_peek(2).obj;
                        /*exp.setTipo($3.sval);*/
                        NodoComun funcion = funcionesDeclaradas.get(val_peek(6).sval + "@" + ambitoVar);
                        yyval.obj = generarLlamadoFuncion(funcion,exp, val_peek(4).sval);
                }
                else {
                        agregarErrorSemantico("La funcion '" + val_peek(6).sval + "' no fue declarada");
                        yyval.obj = new NodoHoja("error");
                }
            }
            TablaSimbolos.removeToken(val_peek(6).sval);
        }
break;
case 95:
//#line 612 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 96:
//#line 616 "gramatica.y"
{yyval=val_peek(1);}
break;
case 97:
//#line 617 "gramatica.y"
{yyval=val_peek(1);}
break;
case 98:
//#line 618 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 99:
//#line 622 "gramatica.y"
{inIF=true; yyval=val_peek(0);}
break;
case 100:
//#line 626 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; Nodo cuerpo = new NodoComun("Cuerpo",(Nodo)val_peek(1).obj);
                                                                                                                                              yyval.obj = new NodoComun("If", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 101:
//#line 628 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)val_peek(1).obj);
                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 102:
//#line 632 "gramatica.y"
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
case 103:
//#line 642 "gramatica.y"
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
//#line 652 "gramatica.y"
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
//#line 663 "gramatica.y"
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
case 106:
//#line 673 "gramatica.y"
{yyerror("Falta THEN en IF");}
break;
case 107:
//#line 674 "gramatica.y"
{yyerror("Falta ELSE en IF");}
break;
case 108:
//#line 675 "gramatica.y"
{yyerror("Falta END_IF en IF");}
break;
case 109:
//#line 680 "gramatica.y"
{yyval = val_peek(1);}
break;
case 110:
//#line 681 "gramatica.y"
{yyval = val_peek(1); cantReturns++;}
break;
case 111:
//#line 682 "gramatica.y"
{yyerror("Las sentencias deben terminar con ';'");}
break;
case 112:
//#line 683 "gramatica.y"
{yyval = val_peek(2);}
break;
case 113:
//#line 688 "gramatica.y"
{yyval = val_peek(1);}
break;
case 114:
//#line 689 "gramatica.y"
{yyval = val_peek(2); cantReturns++;}
break;
case 115:
//#line 690 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 116:
//#line 691 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 117:
//#line 696 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 118:
//#line 697 "gramatica.y"
{yyval = val_peek(1);}
break;
case 119:
//#line 701 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 120:
//#line 702 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 121:
//#line 703 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 122:
//#line 704 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 123:
//#line 705 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 124:
//#line 706 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 125:
//#line 710 "gramatica.y"
{   Nodo exp1 = (Nodo)val_peek(2).obj;
                                        Nodo exp2 = (Nodo)val_peek(0).obj;
                                        if (!(exp1.getNombre().contains("error") || exp2.getNombre().contains("error"))) {
                                            if (!((Nodo)val_peek(2).obj).getTipo().equals(((Nodo)val_peek(0).obj).getTipo())){
                                                agregarErrorSemantico("Los tipos son incompatibles en la condicion");
                                                yyval.obj = new NodoHoja("error");
                                            }
                                            else
                                                yyval.obj = new NodoComun(val_peek(1).sval, (Nodo)val_peek(2).obj, (Nodo)val_peek(0).obj);
                                        }
                                        else {
                                            yyval.obj = new NodoHoja("error");
                                        }
                                    }
break;
case 126:
//#line 724 "gramatica.y"
{inList1 = true;}
break;
case 127:
//#line 724 "gramatica.y"
{inList1 = false;}
break;
case 128:
//#line 724 "gramatica.y"
{inList2 = true;}
break;
case 129:
//#line 724 "gramatica.y"
{inList2 = false;}
break;
case 130:
//#line 725 "gramatica.y"
{ NodoComun salida = new NodoComun(val_peek(5).sval);
      AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
      if (expresiones1.size() == expresiones2.size()){
            Nodo aux;
            for (int i = 0; i < expresiones1.size(); i++) {
                Nodo exp1 = expresiones1.get(i);
                Nodo exp2 = expresiones2.get(i);
                if (exp1.getNombre().contains("error") || exp2.getNombre().contains("error")){
                    salida = new NodoComun("error");
                    break;
                }
                if (!(exp1.getTipo().equals(exp2.getTipo()))){
                    agregarErrorSemantico("Las expresiones en la posicion " + i + " no tienen el mismo tipo");
                    aux = new NodoHoja("error");
                    }
                else {
                    aux = new NodoComun(val_peek(5).sval, exp1, exp2);
                    aux.setUso("pattern_matching");
                }
                if (salida.getIzq() == null)
                    salida.setIzq(aux);
                else {
                    if (salida.getDer() == null)
                        salida.setDer(aux);
                    else {
                        salida = new NodoComun(val_peek(5).sval,salida,aux);
                    }
                }
            }
      }
      else {
        agregarErrorSemantico("La cantidad de elementos a comparar en pattern matching no coincide");
      }
      expresiones1.clear();
      expresiones2.clear();
      yyval.obj = salida;
    }
break;
case 131:
//#line 762 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 132:
//#line 767 "gramatica.y"
{
    if (inList1)
            expresiones1.add((Nodo)val_peek(0).obj);
        if (inList2)
            expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 133:
//#line 777 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 134:
//#line 784 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval = val_peek(0);
    }
break;
case 135:
//#line 791 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 136:
//#line 795 "gramatica.y"
{   Token t = TablaSimbolos.getToken(val_peek(1).sval);
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            yyval.obj = new NodoComun("Outf", new NodoHoja(val_peek(1).sval, t));
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 137:
//#line 801 "gramatica.y"
{   Nodo exp = (Nodo)val_peek(1).obj;
                                 if (!exp.getNombre().contains("error")){
                                     Token t = new Token(exp.getToken());
                                     /*t.setUso("mensaje");*/
                                     t.setTipo(exp.getTipo());
                                     yyval.obj = new NodoComun("Outf", new NodoHoja(exp.getNombre(),t));
                                 }
                                 else {
                                    yyval.obj = new NodoComun("error");
                                 }
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }
break;
case 138:
//#line 814 "gramatica.y"
{yyerror("Los print unicamente pueden contener expresiones o cadenas");}
break;
case 139:
//#line 815 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 1979 "Parser.java"
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
