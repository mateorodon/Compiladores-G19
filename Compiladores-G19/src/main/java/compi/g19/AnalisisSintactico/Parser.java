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
   11,   38,   38,   37,   37,   37,   37,   37,   37,   37,
   37,   37,   35,   35,   35,   39,   39,   39,   39,   39,
   39,   19,   40,   41,   42,   43,   19,   19,   33,   44,
   44,   44,   12,   12,   12,   12,
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
    9,    1,    2,    2,    2,    1,    1,    4,    3,    4,
    5,    2,    3,    2,    1,    1,    1,    1,    1,    1,
    1,    3,    0,    0,    0,    0,   11,    1,    3,    3,
    1,    1,    4,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,   99,    0,    0,    0,   44,   45,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   42,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    0,
    4,    6,    8,    9,   48,    0,    0,    0,    0,    2,
   41,    0,   78,    0,   79,    0,    0,   74,  132,   92,
    0,    0,    0,    0,    0,    1,    0,    0,  136,    0,
    0,    0,    0,    0,    0,    0,  128,    0,  123,    0,
    0,   49,   47,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   82,    0,    0,    0,    0,   90,    0,
   91,    0,    0,  135,  133,  134,    0,   88,    0,    0,
   36,    0,    0,    0,    0,   23,   22,    0,    0,    0,
  116,  117,  118,  121,  120,  119,    0,   46,    0,   55,
    0,    0,    0,    0,    0,    0,   70,    0,   71,    0,
   75,   72,   76,   73,    0,    0,    0,   87,    0,   86,
   89,   98,    0,    0,   21,   20,   96,   37,   38,    0,
    0,    0,  124,    0,    0,    0,   65,    0,    0,    0,
    0,    0,    0,    0,   80,    0,    0,    0,   85,   84,
  114,   97,    0,    0,    0,    0,    0,    0,    0,   54,
   64,    0,   62,   51,    0,    0,    0,    0,    0,    0,
   83,   93,  113,    0,    0,    0,    0,    0,    0,    0,
   60,    0,   53,    0,    0,    0,  105,  112,   95,    0,
   94,  100,    0,    0,    0,    0,    0,    0,   66,   52,
    0,    0,    0,  109,    0,    0,    0,   35,    0,  125,
    0,  108,  103,    0,  110,  101,   32,    0,   34,    0,
   33,  111,   31,  126,    0,  127,
};
final static short yydgoto[] = {                          3,
   12,   13,   14,   15,   16,   47,   17,   18,   19,   55,
   21,   22,   23,   37,  116,   38,   39,   40,   80,  161,
   81,   24,   25,   88,  168,  212,   89,   90,  169,  170,
   57,   58,   63,  222,  199,   26,  200,  234,  127,  119,
  187,  250,  255,   64,
};
final static short yysindex[] = {                      -179,
  305, -151,    0,  -16,    0, -151,  -11,  -32,    0,    0,
  -31,  346,    0,    6,   20, -181,    0,    0,    0,    0,
    0,    0,    0,    0,   55,   75,  389,  238,  148, -225,
  405,  -38,  -58, -122, -205, -129,   96,    0,    0,  126,
    0,    0,    0,    0,    0, -113,  -34,  105,  168,    0,
    0,  -17,    0, -158,    0,  162,   65,    0,    0,    0,
   86,  109,  128,  131,   79,    0,  142,  145,    0,  223,
 -122,  -54,  134,   11,  -37,  251,    0,  168,    0,  155,
  383,    0,    0,    2,    0,   -4,   21,  247,  256,  248,
  271,   45,  225,    0,  242,  245,  257,  266,    0,   -6,
    0,   -6,   63,    0,    0,    0,  -48,    0,   69,   74,
    0,  -16,  307, -102,  286,    0,    0,  123,  269,   81,
    0,    0,    0,    0,    0,    0,   -6,    0,  -76,    0,
   68,   83, -193,   90,  281,  102,    0,   65,    0,   65,
    0,    0,    0,    0,  295,  162,   -6,    0,  201,    0,
    0,    0,  310,  369,    0,    0,    0,    0,    0, -245,
  119,  162,    0,  122,  162,  353,    0,  118,  -76,  339,
  -76,  -76,    0,  -97,    0,  313,  362,  162,    0,    0,
    0,    0,  349,  356,  -18,  370,  380,  373,   -6,    0,
    0,  381,    0,    0,  179,  354,  391,  410,  431, -130,
    0,    0,    0,  437,  412,  168,  443,  -49,  446,  493,
    0,  235,    0,  434,  329,    0,    0,    0,    0,  -97,
    0,    0,  168,  466,  471,  168,  476,  168,    0,    0,
  249,  461,  -23,    0, -198,  483,  168,    0,  494,    0,
  496,    0,    0,  249,    0,    0,    0,  498,    0,  269,
    0,    0,    0,    0,  500,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -174,    0,    0,    0,    0,    0,    0,
    0,  543,    0,  163,  178,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  549,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  510,  191,    0,    0,    0,
    0,    1,    0,    0,    0,  121,   49,    0,    0,    0,
  507,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   -3,    0,    0,  512,    0,    0,
    0,    0,   25,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  297,    0,
    0,    0,    0,    0,    0,    0,    0,   73,    0,   97,
    0,    0,    0,    0,    0,   13,    0,    0,    0,    0,
    0,    0,  414,    0,    0,    0,    0,    0,    0,    0,
    0,  507,    0,    0,  -41,    0,    0,    0,  298,    0,
  297,  297,  104,    0,    0,    0,    0,  143,    0,    0,
    0,    0,    0,  -36,  -35,  -21,    0,  206,    0,    0,
    0,    0,    0,    0,    0,    0,  276, -105,    0,    0,
    0,    0,    0,    0,  211,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  291,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -79,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   24,  429,    0,  416,  -33,    0,    0,    0,    0,  478,
    0,    0,    0,  532,  -55,    0,    0,    0,  -22,  -80,
    3,   18,    0,  440,  317,    0,    0,    0,    0, -119,
  401,  413, -103,  343,  -94,    0,  364,  241,  366,    0,
    0,    0,    0,    0,
};
final static int YYTABLESIZE=707;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        122,
   77,   71,   69,  114,   27,   30,   54,  109,   36,   84,
  124,  126,  125,  149,   87,  163,  184,  122,  154,   29,
  117,  206,   29,   29,   81,   27,   91,   34,   32,   31,
   56,   61,  158,  159,   70,  244,   65,   56,   54,  164,
   56,   77,   77,   77,   77,   77,   62,   77,   69,  192,
   72,   73,   74,  129,  198,  118,  130,  219,  156,   77,
   77,   77,   77,   85,   43,   81,   81,   81,   81,   81,
  221,   81,   67,   92,   30,   45,  214,    1,   44,  185,
    9,   10,   43,   81,   81,   81,   81,    2,  107,   69,
   46,   69,   69,   69,   48,  233,   68,   43,   93,   87,
  198,  215,  145,   94,  146,    4,   97,   69,   69,   69,
   69,   98,    5,   67,   49,   67,   67,   67,    7,    8,
   39,  162,    9,   10,   11,  219,   99,   35,   95,  165,
   96,   67,   67,   67,   67,  220,   76,   68,  221,   68,
   68,   68,   40,   82,   57,   86,  254,   59,  100,  178,
  107,    9,   10,  155,  112,   68,   68,   68,   68,  112,
  107,    5,   11,  107,  113,   79,    5,    7,  101,  196,
   54,  103,    7,   11,  102,  166,  102,   10,   11,   39,
    4,  160,  104,  225,   78,  105,  102,    5,   60,  102,
   12,  210,   54,    7,    8,  110,  166,    9,   10,   11,
  236,   40,  108,  239,   95,  241,   96,   79,  148,  121,
  122,  123,   54,  120,  248,    9,   10,   67,   52,  112,
   27,   30,   83,   53,   68,   35,    5,   27,   30,  113,
   27,   30,    7,   27,   30,   29,  122,  122,   11,   27,
   30,   28,   29,  205,  232,   29,   28,   33,   29,   12,
   52,   26,  162,   43,   29,   53,   77,   77,  128,   77,
   77,   77,  129,  106,   77,   95,   77,   96,   77,   77,
   77,   77,  111,   77,   77,   77,   77,  130,   77,   77,
   81,   81,   54,   81,   81,   81,   54,  131,   81,   54,
   81,  133,   81,   81,   81,   81,  132,   81,   81,   81,
   81,   54,   81,   81,   69,   69,  135,   69,   69,   69,
   54,  134,   69,   54,   69,  136,   69,   69,   69,   69,
  147,   69,   69,   69,   69,  150,   69,   69,   67,   67,
  151,   67,   67,   67,  171,  177,   67,   95,   67,   96,
   67,   67,   67,   67,  157,   67,   67,   67,   67,  172,
   67,   67,   68,   68,  174,   68,   68,   68,  158,  159,
   68,   85,   68,  176,   68,   68,   68,   68,  181,   68,
   68,   68,   68,  175,   68,   68,   39,   39,    9,   10,
  186,   77,   52,  188,   39,  190,   39,   53,   39,   39,
   39,   39,  189,   39,   39,   39,   39,  193,   40,   40,
  158,  159,  202,   59,   52,  201,   40,  203,   40,   53,
   40,   40,   40,   40,  204,   40,   40,   40,   40,   11,
  208,    9,   10,   77,   52,   95,   11,   96,  207,   53,
   11,  209,   11,   11,   10,   11,   11,   11,   11,  211,
   42,   10,  124,  126,  125,   10,  213,   10,   10,  216,
   10,   10,   10,   10,   12,   42,  179,  180,   12,   42,
   12,   12,   28,   12,   12,   12,   12,   26,  217,   28,
  224,  242,   28,  245,   26,   28,  223,   26,   20,   20,
   26,   28,  226,   20,  252,  228,   26,  194,  195,   20,
  115,  115,  231,   51,   52,  138,  140,  137,   52,   53,
  139,   52,  230,   53,   20,  237,   53,  112,   20,  142,
  144,  238,  141,   52,    5,  240,  232,  113,   53,  243,
    7,  143,   52,  247,   59,   52,   11,   53,  153,  115,
   53,  106,  115,  229,  249,   95,  251,   96,  253,  115,
  256,  106,    5,  115,  106,  115,  104,  114,    3,   50,
  131,  115,   20,   20,  114,   58,  104,  167,  114,  104,
  114,    4,  152,  112,   63,   61,  114,   75,    5,  183,
    5,    6,  173,  227,    7,    8,    7,  246,    9,   10,
   11,    0,   11,  235,    0,  112,    0,    0,    0,  197,
   20,   20,    5,    0,    0,    0,  232,  191,    7,  167,
  167,  166,    4,    0,   11,    0,   20,    0,    0,    5,
  112,  153,    0,   41,  183,    7,    8,    5,    0,    9,
   10,   11,    0,    7,    0,  112,  166,    0,    0,   11,
  183,   20,    5,    0,    0,  197,  182,    0,    7,    0,
    0,  121,  122,  123,   11,    4,   20,    0,   20,   20,
    0,   20,    5,    0,    0,    0,   50,    0,    7,    8,
    0,    4,    9,   10,   11,    0,    0,    0,    5,    0,
  115,    0,   66,   20,    7,    8,   20,  115,    9,   10,
   11,  115,    0,  115,    0,    0,  115,  112,    0,  115,
    0,    0,   20,    0,    5,    0,    0,   20,  218,    0,
    7,    0,    0,    0,    0,    0,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   60,   41,   41,   41,   41,   45,   62,   40,   44,
   60,   61,   62,   62,   48,  119,  262,   59,  113,   41,
   76,   40,   40,   40,    0,    2,   49,   60,   40,    6,
   28,   29,  278,  279,   32,   59,  262,   41,   45,  120,
   44,   41,   42,   43,   44,   45,   29,   47,    0,  169,
   33,   34,  258,   41,  174,   78,   44,  256,  114,   59,
   60,   61,   62,  257,   59,   41,   42,   43,   44,   45,
  269,   47,    0,   91,   91,  257,  196,  257,   59,  160,
  274,  275,  257,   59,   60,   61,   62,  267,   71,   41,
  272,   43,   44,   45,   40,  215,    0,  272,  257,  133,
  220,  196,  100,  262,  102,  257,   42,   59,   60,   61,
   62,   47,  264,   41,   40,   43,   44,   45,  270,  271,
    0,  119,  274,  275,  276,  256,   41,  257,   43,  127,
   45,   59,   60,   61,   62,  266,   41,   41,  269,   43,
   44,   45,    0,  257,   41,   41,  250,   44,   40,  147,
  256,  274,  275,  256,  257,   59,   60,   61,   62,  257,
  266,  264,    0,  269,  267,   40,  264,  270,   41,  267,
   45,   93,  270,  276,   44,  273,  256,    0,  276,   59,
  257,   59,   41,  206,   59,   41,  266,  264,   41,  269,
    0,  189,   45,  270,  271,   62,  273,  274,  275,  276,
  223,   59,  257,  226,   43,  228,   45,   40,  257,  259,
  260,  261,   45,   59,  237,  274,  275,  256,  257,  257,
  257,  257,  257,  262,  263,  257,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  258,  264,  262,  268,  267,   41,  280,  270,   59,
  257,   41,  250,  257,  276,  262,  256,  257,  257,  259,
  260,  261,  267,   41,  264,   43,  266,   45,  268,  269,
  270,  271,  262,  273,  274,  275,  276,  257,  278,  279,
  256,  257,   45,  259,  260,  261,   45,   41,  264,   45,
  266,   44,  268,  269,  270,  271,   41,  273,  274,  275,
  276,   45,  278,  279,  256,  257,  262,  259,  260,  261,
   45,   41,  264,   45,  266,   91,  268,  269,  270,  271,
  258,  273,  274,  275,  276,  257,  278,  279,  256,  257,
  257,  259,  260,  261,  267,   41,  264,   43,  266,   45,
  268,  269,  270,  271,   59,  273,  274,  275,  276,  267,
  278,  279,  256,  257,  265,  259,  260,  261,  278,  279,
  264,  257,  266,  262,  268,  269,  270,  271,   59,  273,
  274,  275,  276,   93,  278,  279,  256,  257,  274,  275,
  262,  256,  257,  262,  264,  268,  266,  262,  268,  269,
  270,  271,   40,  273,  274,  275,  276,   59,  256,  257,
  278,  279,   41,  256,  257,   93,  264,   59,  266,  262,
  268,  269,  270,  271,   59,  273,  274,  275,  276,  257,
   41,  274,  275,  256,  257,   43,  264,   45,   59,  262,
  268,   59,  270,  271,  257,  273,  274,  275,  276,   59,
   12,  264,   60,   61,   62,  268,  268,  270,  271,   59,
  273,  274,  275,  276,  264,   27,  256,  257,  268,   31,
  270,  271,  257,  273,  274,  275,  276,  257,   59,  264,
   59,  231,  267,  233,  264,  270,   40,  267,    1,    2,
  270,  276,   40,    6,  244,   40,  276,  171,  172,   12,
   75,   76,   59,  256,  257,   95,   96,  256,  257,  262,
  256,  257,  268,  262,   27,   40,  262,  257,   31,   97,
   98,   41,  256,  257,  264,   40,  268,  267,  262,   59,
  270,  256,  257,   41,  256,  257,  276,  262,  113,  114,
  262,  256,  257,   41,   41,   43,   41,   45,   41,  264,
   41,  266,    0,  268,  269,  270,  256,  257,    0,   40,
   44,  276,   75,   76,  264,   44,  266,  129,  268,  269,
  270,  257,  256,  257,  268,  268,  276,   36,  264,  154,
  264,  267,  133,  208,  270,  271,  270,  235,  274,  275,
  276,   -1,  276,  220,   -1,  257,   -1,   -1,   -1,  174,
  113,  114,  264,   -1,   -1,   -1,  268,  169,  270,  171,
  172,  273,  257,   -1,  276,   -1,  129,   -1,   -1,  264,
  257,  196,   -1,  268,  199,  270,  271,  264,   -1,  274,
  275,  276,   -1,  270,   -1,  257,  273,   -1,   -1,  276,
  215,  154,  264,   -1,   -1,  220,  268,   -1,  270,   -1,
   -1,  259,  260,  261,  276,  257,  169,   -1,  171,  172,
   -1,  174,  264,   -1,   -1,   -1,  268,   -1,  270,  271,
   -1,  257,  274,  275,  276,   -1,   -1,   -1,  264,   -1,
  257,   -1,  268,  196,  270,  271,  199,  264,  274,  275,
  276,  268,   -1,  270,   -1,   -1,  273,  257,   -1,  276,
   -1,   -1,  215,   -1,  264,   -1,   -1,  220,  268,   -1,
  270,   -1,   -1,   -1,   -1,   -1,  276,
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
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_bloque fin_if",
"end_cuerpo_if : END",
"end_cuerpo_if : END ';'",
"cuerpo_if_bloque : sentencia_ejecutable ';'",
"cuerpo_if_bloque : sentencia_return ';'",
"cuerpo_if_bloque : sentencia_ejecutable",
"cuerpo_if_bloque : sentencia_return",
"cuerpo_if_bloque : BEGIN sentencia_return ';' end_cuerpo_if",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables end_cuerpo_if",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables sentencia_return end_cuerpo_if",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables sentencia_return ';' end_cuerpo_if",
"cuerpo_if_bloque : list_sentencias_ejecutables END",
"list_sentencias_ejecutables : list_sentencias_ejecutables sentencia_ejecutable ';'",
"list_sentencias_ejecutables : sentencia_ejecutable ';'",
"list_sentencias_ejecutables : sentencia_ejecutable",
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

//#line 803 "gramatica.y"
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
static HashMap<String,String> funcionYTipoParametro = new HashMap<>();
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
//#line 753 "Parser.java"
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
case 8:
//#line 34 "gramatica.y"
{yyval.obj = new NodoHoja("Sentencia Declarativa");}
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

                                  if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))) {
                                      agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")");
                                      yyval.obj = new NodoHoja("error");
                                  } else {
                                      if (t.getUso().equals("arreglo")) {
                                          Token t2 = TablaSimbolos.getToken(val_peek(0).sval);
                                          if (t2 != null) {
                                              if (!t2.getUso().equals("arreglo")) {
                                                  agregarErrorSemantico("Un arreglo puede ser asignado únicamente a otro arreglo");
                                              } else {
                                                  NodoHoja id = new NodoHoja(t.getLexema().toString(), t);
                                                  yyval.obj = new NodoComun(val_peek(1).sval, id, (Nodo) val_peek(0).obj);
                                              }
                                          } else {
                                              agregarErrorSemantico("Error: La expresión en la parte derecha de la asignación no está definida.");
                                              yyval.obj = new NodoHoja("error");
                                          }
                                      } else {
                                          NodoHoja id = new NodoHoja(t.getLexema().toString(), t);
                                          yyval.obj = new NodoComun(val_peek(1).sval, id, (Nodo) val_peek(0).obj);
                                      }
                                  }
                                  TablaSimbolos.removeToken(val_peek(2).sval);
                              }}
break;
case 40:
//#line 208 "gramatica.y"
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
//#line 236 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 43:
//#line 241 "gramatica.y"
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
//#line 257 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 45:
//#line 258 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 46:
//#line 262 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 47:
//#line 263 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 48:
//#line 264 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 49:
//#line 268 "gramatica.y"
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
//#line 298 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 51:
//#line 302 "gramatica.y"
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
//#line 319 "gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 54:
//#line 320 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 55:
//#line 324 "gramatica.y"
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
//#line 341 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 60:
//#line 354 "gramatica.y"
{  yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);
                                                    hasReturn = true;}
break;
case 61:
//#line 356 "gramatica.y"
{yyval=val_peek(0);}
break;
case 62:
//#line 357 "gramatica.y"
{yyval=val_peek(1); hasReturn = true;}
break;
case 63:
//#line 358 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio"); yyval.obj = new NodoComun("Cuerpo vacio");}
break;
case 64:
//#line 363 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(1).obj, (Nodo) val_peek(0).obj);}
break;
case 65:
//#line 364 "gramatica.y"
{yyval=val_peek(0);}
break;
case 66:
//#line 369 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           yyval.obj = new NodoComun("Return", (Nodo)val_peek(1).obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 67:
//#line 377 "gramatica.y"
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
//#line 389 "gramatica.y"
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
//#line 401 "gramatica.y"
{yyval = val_peek(0);}
break;
case 70:
//#line 402 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
//#line 403 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 72:
//#line 407 "gramatica.y"
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
//#line 419 "gramatica.y"
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
//#line 431 "gramatica.y"
{yyval = val_peek(0);}
break;
case 75:
//#line 432 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 76:
//#line 433 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 77:
//#line 437 "gramatica.y"
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
//#line 454 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                t.setValor(val_peek(0).sval);
                t.setUso("constante");
                yyval.obj = new NodoHoja(val_peek(0).sval,t);
                }
break;
case 79:
//#line 459 "gramatica.y"
{yyval = val_peek(0); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 80:
//#line 460 "gramatica.y"
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
//#line 485 "gramatica.y"
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
//#line 502 "gramatica.y"
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
//#line 516 "gramatica.y"
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
//#line 544 "gramatica.y"
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
//#line 567 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 86:
//#line 568 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 87:
//#line 569 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 88:
//#line 570 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 89:
//#line 571 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 90:
//#line 575 "gramatica.y"
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
//#line 600 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 92:
//#line 601 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 93:
//#line 602 "gramatica.y"
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
//#line 627 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 96:
//#line 631 "gramatica.y"
{yyval=val_peek(1);}
break;
case 97:
//#line 632 "gramatica.y"
{yyval=val_peek(1);}
break;
case 98:
//#line 633 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 99:
//#line 637 "gramatica.y"
{inIF=true; yyval=val_peek(0);}
break;
case 100:
//#line 641 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)val_peek(1).obj);
                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 101:
//#line 646 "gramatica.y"
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
//#line 666 "gramatica.y"
{yyval = val_peek(1);}
break;
case 105:
//#line 667 "gramatica.y"
{yyval = val_peek(1); cantReturns++;}
break;
case 106:
//#line 668 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 107:
//#line 669 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 108:
//#line 670 "gramatica.y"
{yyval = val_peek(2);cantReturns++;}
break;
case 109:
//#line 671 "gramatica.y"
{yyval = val_peek(1);}
break;
case 110:
//#line 672 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 111:
//#line 673 "gramatica.y"
{yyval = val_peek(3); cantReturns++;}
break;
case 112:
//#line 674 "gramatica.y"
{yyerror("Se encontró 'end_cuerpo_if' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 113:
//#line 680 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 114:
//#line 681 "gramatica.y"
{yyval = val_peek(1);}
break;
case 115:
//#line 682 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 116:
//#line 686 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 117:
//#line 687 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 118:
//#line 688 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 119:
//#line 689 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 120:
//#line 690 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 121:
//#line 691 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 122:
//#line 695 "gramatica.y"
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
case 123:
//#line 709 "gramatica.y"
{inList1 = true;}
break;
case 124:
//#line 709 "gramatica.y"
{inList1 = false;}
break;
case 125:
//#line 709 "gramatica.y"
{inList2 = true;}
break;
case 126:
//#line 709 "gramatica.y"
{inList2 = false;}
break;
case 127:
//#line 710 "gramatica.y"
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
case 128:
//#line 747 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 129:
//#line 752 "gramatica.y"
{
    if (inList1)
            expresiones1.add((Nodo)val_peek(0).obj);
        if (inList2)
            expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 130:
//#line 762 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 131:
//#line 769 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval = val_peek(0);
    }
break;
case 132:
//#line 776 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 133:
//#line 780 "gramatica.y"
{   Token t = TablaSimbolos.getToken(val_peek(1).sval);
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            yyval.obj = new NodoComun("Outf", new NodoHoja(val_peek(1).sval, t));
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 134:
//#line 786 "gramatica.y"
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
case 135:
//#line 799 "gramatica.y"
{yyerror("Los print unicamente pueden contener expresiones o cadenas");}
break;
case 136:
//#line 800 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 1931 "Parser.java"
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
