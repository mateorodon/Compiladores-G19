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
import java.util.Stack;
import java.util.Map;

import compi.g19.AnalisisLexico.*;
import compi.g19.GeneracionDeCodigo.*;
import static compi.g19.AnalisisLexico.AnalizadorLexico.errorLexico;
import static compi.g19.AnalisisLexico.AnalizadorLexico.errorSintactico;
//#line 30 "Parser.java"




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
   26,   27,    7,    7,    7,   24,   24,   28,   29,   29,
   25,   25,   25,   25,   30,   30,   31,   21,   21,   21,
   21,   21,   32,   32,   32,   32,   32,   33,   33,   33,
   33,   33,   33,   33,    8,    8,    8,    8,    8,    8,
   10,   10,   10,   10,   10,   35,   35,   15,   15,   15,
   37,   11,   39,   40,   11,   11,   11,   41,   41,   38,
   38,   38,   38,   38,   38,   38,   38,   38,   36,   36,
   36,   42,   42,   42,   42,   42,   42,   19,   43,   44,
   45,   46,   19,   19,   34,   47,   47,   47,   12,   12,
   12,   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    3,    2,    2,    1,    2,    2,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    5,
    5,    4,    4,    1,    1,    6,    5,    5,    5,    5,
   10,    9,    9,    9,    8,    3,    1,    1,    3,    6,
    3,    1,    1,    1,    1,    3,    2,    1,    3,    2,
    0,    0,    9,    7,    6,    2,    1,    3,    1,    3,
    3,    1,    2,    0,    2,    1,    4,    3,    3,    1,
    3,    3,    3,    3,    1,    3,    3,    1,    1,    1,
    4,    2,    2,    5,    6,    6,    5,    5,    4,    5,
    4,    4,    4,    3,    7,    1,    1,    2,    3,    2,
    1,    7,    0,    0,   11,    6,    6,    1,    2,    2,
    2,    1,    1,    4,    3,    4,    5,    2,    3,    2,
    1,    1,    1,    1,    1,    1,    1,    3,    0,    0,
    0,    0,   11,    1,    3,    3,    1,    1,    4,    4,
    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,  101,    0,    0,    0,    0,   44,
   45,    0,    0,    7,    0,    0,    0,   13,   14,   15,
   16,   17,   18,   19,   42,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   24,
   25,    0,    4,    6,    8,    9,   48,    0,    0,    0,
    0,    2,   41,    0,   79,    0,   80,    0,    0,   75,
  138,   94,    0,    0,    0,    0,    0,    1,    0,    0,
  142,    0,    0,    0,    0,    0,    0,    0,    0,  134,
    0,  129,    0,    0,   49,   47,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   83,    0,    0,
    0,    0,   91,    0,   93,    0,    0,  141,  139,  140,
    0,   89,    0,    0,   92,   36,    0,    0,    0,    0,
   23,   22,    0,    0,    0,  122,  123,  124,  127,  126,
  125,    0,   46,    0,   56,    0,    0,    0,    0,    0,
    0,    0,   71,    0,   72,    0,   76,   73,   77,   74,
    0,    0,    0,   88,    0,   87,   90,  100,    0,    0,
   21,   20,   98,   37,   38,    0,    0,    0,  130,    0,
    0,    0,   66,    0,    0,    0,   51,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   81,    0,    0,    0,
   86,   85,  120,   99,    0,    0,    0,    0,    0,    0,
    0,   55,   65,    0,   63,    0,    0,    0,    0,    0,
  111,  118,   97,   96,  106,    0,  107,   84,   95,  119,
    0,    0,    0,    0,    0,    0,    0,   61,   52,   54,
    0,    0,    0,  115,  102,    0,    0,    0,    0,    0,
    0,    0,   67,    0,  114,  109,    0,  116,    0,    0,
    0,   35,    0,  131,    0,   53,  117,  104,   32,    0,
   34,    0,   33,    0,   31,  132,  105,    0,  133,
};
final static short yydgoto[] = {                          3,
   13,   14,   15,   16,   17,   49,   18,   19,   20,   57,
   22,   23,   24,   39,  121,   40,   41,   42,   83,  167,
   84,   25,   26,   91,  174,  206,  244,   92,   93,  175,
  182,   59,   60,   65,  215,  183,   27,  184,  236,  264,
  234,  132,  124,  199,  262,  268,   66,
};
final static short yysindex[] = {                      -145,
  430,  506,    0,  -11,    0,  506,   -7,  -57,   12,    0,
    0,   -9,  439,    0,    6,   29, -236,    0,    0,    0,
    0,    0,    0,    0,    0,   58,   83,  461,  -43,  290,
 -131,  470,  314,  105, -216,   54, -112, -120,  119,    0,
    0,   -6,    0,    0,    0,    0,    0,  -81,   -3,  -33,
  -13,    0,    0,  -16,    0, -138,    0,  109,  102,    0,
    0,    0,  152,  142,  159,  201,  153,    0,  211,  227,
    0,  158, -216,  -48,  216,  295,   26,  -37,  564,    0,
  126,    0,  233,  144,    0,    0,   45,    0,   93,   55,
  309,  323,  330,  136,  343,  124,  333,    0,  245,  269,
  317,  336,    0,   54,    0,   54,  164,    0,    0,    0,
  -42,    0,  169,  171,    0,    0,  -11,  311,  -95,  370,
    0,    0,  -53,  357, -111,    0,    0,    0,    0,    0,
    0,   54,    0,  486,    0,  165,  174, -168,  533,  522,
  337,  180,    0,  102,    0,  102,    0,    0,    0,    0,
  365,  109,   54,    0,  -72,    0,    0,    0,  384,  575,
    0,    0,    0,    0,    0, -149,  182,  109,    0,  184,
  109,  408,    0,  181,  486,  391,    0,  486,    0,  331,
  393,  402,  578, -234,  533, -234,    0,  369,  422,  109,
    0,    0,    0,    0,  406,  417,  -30,  418,  440,  423,
   54,    0,    0,  424,    0,  486,  220,  425,  544,    0,
    0,    0,    0,    0,    0, -234,    0,    0,    0,    0,
  451,  437,  126,  457,  -49,  466,  380,    0,    0,    0,
  240,  450,  -52,    0,    0,  248,  126,  471,  474,  126,
  479,  126,    0,  244,    0,    0,  240,    0,  533,  480,
  126,    0,  487,    0,  488,    0,    0,    0,    0,  491,
    0,  357,    0, -234,    0,    0,    0,  493,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -157,    0,    0,    0,    0,    0,    0,
    0,    0,  527,    0,  163,  183,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  535,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   58,  196,    0,
    0,    0,    0,    1,    0,    0,    0,  121,   49,    0,
    0,    0,  495,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   -4,    0,    0,
  496,    0,    0,    0,    0,    0,   25,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  275,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   73,    0,   97,    0,    0,    0,    0,
    0,  -18,    0,    0,    0,    0,    0,    0,  554,    0,
    0,    0,    0,    0,    0,    0,    0,  495,    0,    0,
  -41,    0,    0,    0,  276,    0,    0,  275,  129,    0,
  -78, -165,    0,    0,    0,    0,    0,    0,    0,  143,
    0,    0,    0,    0,    0,  -36,  222,  223,    0,  246,
    0,    0,    0,    0,    0,  275,    0,    0,    0,  416,
    0,    0,    0,    0,    0,  271,    0,    0,    0,    0,
    0,  266,    0,    0,    0,    0,    0,    0,    0,    0,
    0, -130,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  149,  492,    0,  481,  -35,    0,    0,    0,    0,  472,
    0,    0,    0,  507,  -23,    0,    0,    0,  394,  -87,
   21,   47,    0,  410, -123,    0,    0,    0,    0,    0,
 -104,  108,  116, -115, -169, -102,    0, -121,    0,    0,
  -83,  324,    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=854;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        128,
   78,   56,   35,  119,   27,  166,  247,   89,  169,  223,
  129,  131,  130,  113,   90,  160,  217,  128,  186,  155,
   47,  213,  135,   30,   82,  136,   82,   94,   30,  176,
   38,   56,   33,   82,  214,   48,   57,  170,   56,   57,
   87,   78,   78,   78,   78,   78,  235,   78,   70,   58,
   63,   36,   81,   72,  207,  122,   76,   10,   11,   78,
   78,   78,   78,  216,   45,   82,   82,   82,   82,   82,
  204,   82,   68,  176,   96,  208,   64,  209,  197,   31,
   74,   75,  229,   82,   82,   82,   82,   46,   88,   70,
  113,   70,   70,   70,  267,  162,   69,   50,   56,   43,
  113,  176,   90,  113,  233,   10,   11,   70,   70,   70,
   70,    1,  196,   68,   43,   68,   68,   68,   97,  111,
   39,    2,   51,   98,  151,  108,  152,  258,  164,  165,
   67,   68,   68,   68,   68,  108,   37,   69,  108,   69,
   69,   69,   40,  101,  168,   77,  266,  245,  102,  248,
   28,   99,  171,  100,   32,   69,   69,   69,   69,   79,
  161,  117,   11,  257,   73,   82,  164,  165,    5,   58,
   56,  118,   60,  190,    7,   85,    9,  112,  121,   39,
   12,  104,   10,  191,  192,  121,   99,  112,  100,  121,
  112,  121,  103,  121,   99,   12,  100,  121,  110,  105,
   99,   40,  100,  129,  131,  130,  144,  146,  112,  126,
  127,  128,   53,   54,  154,  232,  148,  150,   55,  117,
   27,  227,   34,   88,  164,  165,    5,   27,    9,  118,
   27,  222,    7,   27,    9,   27,  128,  128,   12,   27,
   10,   11,   80,   54,  106,  107,   29,   37,   55,   80,
   54,  108,   43,   86,   12,   55,   78,   78,    9,   78,
   78,   78,   30,   29,   78,    9,   78,  109,   78,   78,
   78,   78,   78,   78,   78,   78,   78,  114,   78,   78,
   82,   82,  168,   82,   82,   82,   28,  116,   82,   56,
   82,  125,   82,   82,   82,   82,   82,   82,   82,   82,
   82,  133,   82,   82,   70,   70,   26,   70,   70,   70,
   54,  135,   70,   56,   70,   55,   70,   70,   70,   70,
   70,   70,   70,   70,   70,    9,   70,   70,   68,   68,
   62,   68,   68,   68,   56,  115,   68,   99,   68,  100,
   68,   68,   68,   68,   68,   68,   68,   68,   68,  136,
   68,   68,   69,   69,   71,   69,   69,   69,   56,  134,
   69,   56,   69,  137,   69,   69,   69,   69,   69,   69,
   69,   69,   69,  138,   69,   69,   39,   39,   10,   11,
   56,   80,   54,  140,   39,  141,   39,   55,   39,   39,
   39,   39,   39,   39,   39,   39,   39,    9,   40,   40,
  139,   56,  126,  127,  128,  189,   40,   99,   40,  100,
   40,   40,   40,   40,   40,   40,   40,   40,   40,   11,
  243,  153,   99,  142,  100,  156,   11,  157,  163,  187,
   11,  177,   11,   11,   11,   11,   11,   11,   11,   10,
  178,  188,  193,  198,   95,  200,   10,  201,  202,  205,
   10,  210,   10,   10,   10,   10,   10,   10,   10,   12,
  211,  218,  219,   12,  220,   12,   12,   12,   12,   12,
   12,   12,   21,   21,  123,  221,  224,   21,   30,   29,
  225,  226,  228,  231,   21,   30,   29,  230,   30,   29,
  237,   30,   29,   30,   29,  238,  240,   30,   29,   21,
  143,   54,   28,   21,   44,  242,   55,  232,  246,   28,
  251,  256,   28,  249,  252,   28,    9,   28,  254,   44,
  259,   28,   26,   44,  145,   54,    5,  261,  263,   26,
   55,  265,   26,  269,    3,   26,  103,   26,  137,   59,
    9,   26,   64,   62,   78,   61,   54,  179,  241,   21,
   21,   55,    0,    0,    0,    0,    0,    0,  120,  120,
    0,    9,    0,   10,   11,    0,  158,  117,    0,   69,
   54,    0,  147,   54,    5,   55,   70,    0,   55,    0,
    7,    0,    9,    0,    0,    9,   12,  117,    9,   21,
   21,  149,   54,    0,    5,    0,    0,   55,  159,  120,
    7,    0,    9,  172,    0,   21,   12,    9,    0,    0,
   21,   21,   61,   54,    0,    0,  239,    0,   55,  181,
  181,    0,    0,    0,    0,  173,    0,    0,    9,    0,
  250,   21,    0,  253,    0,  255,    0,    0,    0,    0,
  195,    0,    0,    0,  260,    0,   21,    0,    0,   21,
    0,   21,    0,    0,   21,    0,   21,    0,    0,    0,
  159,    0,    0,  195,    0,  181,  203,    0,    0,  173,
    0,  110,  120,    0,    0,    0,    0,   21,    0,  120,
   21,  110,    0,  120,  110,  120,    4,  120,    0,  195,
    0,  120,    0,    5,    0,    4,    6,  173,    0,    7,
    8,    9,    5,   10,   11,   12,   43,    0,    7,    8,
    9,    0,   10,   11,   12,    0,    0,    4,    0,    0,
   21,    0,    0,    0,    5,    0,    4,    0,   52,  181,
    7,    8,    9,    5,   10,   11,   12,   68,    0,    7,
    8,    9,    4,   10,   11,   12,    0,    0,    0,    5,
    0,    0,    0,    0,    0,    7,    8,    9,  172,   10,
   11,   12,    4,    0,    0,    0,    0,    0,    0,    5,
    0,    0,    0,    0,    0,    7,    8,    9,  117,   10,
   11,   12,    0,    0,    0,    5,  185,    0,  180,  117,
    0,    7,    0,    9,  172,    0,    5,   12,    0,  180,
  117,    0,    7,    0,    9,  172,    0,    5,   12,    0,
  121,  232,    0,    7,    0,    9,  172,  121,    0,   12,
  117,  121,    0,  121,    0,  121,  121,    5,    0,  121,
  118,  117,    0,    7,  117,    9,    0,    0,    5,   12,
    0,    5,  194,    0,    7,  212,    9,    7,    0,    9,
   12,    0,    0,   12,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   45,   60,   41,   41,   59,   59,   41,  124,   40,
   60,   61,   62,   62,   50,  118,  186,   59,  140,   62,
  257,  256,   41,   40,    0,   44,   40,   41,   40,  134,
   40,   45,   40,   40,  269,  272,   41,  125,   45,   44,
   44,   41,   42,   43,   44,   45,  216,   47,    0,   29,
   30,   40,   59,   33,  178,   79,   36,  274,  275,   59,
   60,   61,   62,  185,   59,   41,   42,   43,   44,   45,
  175,   47,    0,  178,   91,  180,   30,  180,  166,   91,
   34,   35,  206,   59,   60,   61,   62,   59,  257,   41,
  256,   43,   44,   45,  264,  119,    0,   40,   45,  257,
  266,  206,  138,  269,  209,  274,  275,   59,   60,   61,
   62,  257,  262,   41,  272,   43,   44,   45,  257,   73,
    0,  267,   40,  262,  104,  256,  106,  249,  278,  279,
  262,   59,   60,   61,   62,  266,  257,   41,  269,   43,
   44,   45,    0,   42,  124,  258,  262,  231,   47,  233,
    2,   43,  132,   45,    6,   59,   60,   61,   62,   41,
  256,  257,    0,  247,   60,   40,  278,  279,  264,   41,
   45,  267,   44,  153,  270,  257,  272,  256,  257,   59,
  276,   40,    0,  256,  257,  264,   43,  266,   45,  268,
  269,  270,   41,  272,   43,    0,   45,  276,   41,   41,
   43,   59,   45,   60,   61,   62,   99,  100,  257,  259,
  260,  261,  256,  257,  257,  268,  101,  102,  262,  257,
  257,  201,  280,  257,  278,  279,  264,  264,  272,  267,
  267,  262,  270,  270,  272,  272,  278,  279,  276,  276,
  274,  275,  256,  257,   44,   93,  258,  257,  262,  256,
  257,   41,  257,  257,   59,  262,  256,  257,  272,  259,
  260,  261,   41,   41,  264,  272,  266,   41,  268,  269,
  270,  271,  272,  273,  274,  275,  276,   62,  278,  279,
  256,  257,  262,  259,  260,  261,   41,  262,  264,   45,
  266,   59,  268,  269,  270,  271,  272,  273,  274,  275,
  276,  257,  278,  279,  256,  257,   41,  259,  260,  261,
  257,  257,  264,   45,  266,  262,  268,  269,  270,  271,
  272,  273,  274,  275,  276,  272,  278,  279,  256,  257,
   41,  259,  260,  261,   45,   41,  264,   43,  266,   45,
  268,  269,  270,  271,  272,  273,  274,  275,  276,   41,
  278,  279,  256,  257,   41,  259,  260,  261,   45,  267,
  264,   45,  266,   41,  268,  269,  270,  271,  272,  273,
  274,  275,  276,   44,  278,  279,  256,  257,  274,  275,
   45,  256,  257,   41,  264,  262,  266,  262,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  272,  256,  257,
  265,   45,  259,  260,  261,   41,  264,   43,  266,   45,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  257,
   41,  258,   43,   91,   45,  257,  264,  257,   59,   93,
  268,  267,  270,  271,  272,  273,  274,  275,  276,  257,
  267,  262,   59,  262,   51,  262,  264,   40,  268,   59,
  268,   59,  270,  271,  272,  273,  274,  275,  276,  264,
   59,   93,   41,  268,   59,  270,  271,  272,  273,  274,
  275,  276,    1,    2,   81,   59,   59,    6,  257,  257,
   41,   59,   59,   59,   13,  264,  264,  268,  267,  267,
   40,  270,  270,  272,  272,   59,   40,  276,  276,   28,
  256,  257,  257,   32,   13,   40,  262,  268,   59,  264,
   40,  268,  267,  266,   41,  270,  272,  272,   40,   28,
   41,  276,  257,   32,  256,  257,    0,   41,   41,  264,
  262,   41,  267,   41,    0,  270,  266,  272,   44,   44,
  272,  276,  268,  268,   38,  256,  257,  138,  225,   78,
   79,  262,   -1,   -1,   -1,   -1,   -1,   -1,   78,   79,
   -1,  272,   -1,  274,  275,   -1,  256,  257,   -1,  256,
  257,   -1,  256,  257,  264,  262,  263,   -1,  262,   -1,
  270,   -1,  272,   -1,   -1,  272,  276,  257,  272,  118,
  119,  256,  257,   -1,  264,   -1,   -1,  262,  118,  119,
  270,   -1,  272,  273,   -1,  134,  276,  272,   -1,   -1,
  139,  140,  256,  257,   -1,   -1,  223,   -1,  262,  139,
  140,   -1,   -1,   -1,   -1,  134,   -1,   -1,  272,   -1,
  237,  160,   -1,  240,   -1,  242,   -1,   -1,   -1,   -1,
  160,   -1,   -1,   -1,  251,   -1,  175,   -1,   -1,  178,
   -1,  180,   -1,   -1,  183,   -1,  185,   -1,   -1,   -1,
  180,   -1,   -1,  183,   -1,  185,  175,   -1,   -1,  178,
   -1,  256,  257,   -1,   -1,   -1,   -1,  206,   -1,  264,
  209,  266,   -1,  268,  269,  270,  257,  272,   -1,  209,
   -1,  276,   -1,  264,   -1,  257,  267,  206,   -1,  270,
  271,  272,  264,  274,  275,  276,  268,   -1,  270,  271,
  272,   -1,  274,  275,  276,   -1,   -1,  257,   -1,   -1,
  249,   -1,   -1,   -1,  264,   -1,  257,   -1,  268,  249,
  270,  271,  272,  264,  274,  275,  276,  268,   -1,  270,
  271,  272,  257,  274,  275,  276,   -1,   -1,   -1,  264,
   -1,   -1,   -1,   -1,   -1,  270,  271,  272,  273,  274,
  275,  276,  257,   -1,   -1,   -1,   -1,   -1,   -1,  264,
   -1,   -1,   -1,   -1,   -1,  270,  271,  272,  257,  274,
  275,  276,   -1,   -1,   -1,  264,  265,   -1,  267,  257,
   -1,  270,   -1,  272,  273,   -1,  264,  276,   -1,  267,
  257,   -1,  270,   -1,  272,  273,   -1,  264,  276,   -1,
  257,  268,   -1,  270,   -1,  272,  273,  264,   -1,  276,
  257,  268,   -1,  270,   -1,  272,  273,  264,   -1,  276,
  267,  257,   -1,  270,  257,  272,   -1,   -1,  264,  276,
   -1,  264,  268,   -1,  270,  268,  272,  270,   -1,  272,
  276,   -1,   -1,  276,
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
"$$2 :",
"declaracion_funcion : encabezado_funcion '(' parametro ')' BEGIN $$1 cuerpo_funcion $$2 END",
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
"invocacion_funcion : FUN '(' expresion ')'",
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
"$$3 :",
"$$4 :",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque $$3 ELSE cuerpo_if_bloque $$4 fin_if",
"bloque_if : encabezado_if '(' ')' THEN cuerpo_if_bloque fin_if",
"bloque_if : encabezado_if '(' condicion ')' cuerpo_if_bloque fin_if",
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
"$$5 :",
"$$6 :",
"$$7 :",
"$$8 :",
"condicion : '(' $$5 bloque_list_expresiones $$6 ')' comparacion '(' $$7 bloque_list_expresiones $$8 ')'",
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

//#line 918 "gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;

static NodoComun raiz;
static String ambito = "main";
static boolean inIF = false;
static boolean faltaReturn = false;
static boolean hasReturn = false;
static boolean functionTieneIF = false;
static int cantIF = 0;
public static boolean enFuncion = false;
static boolean ifHasReturn = false;
Stack<Boolean> returnIFStack = new Stack<>();
Stack<Boolean> returnELSEStack = new Stack<>();
public static String funcionActual;
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
    if (!(nodo1 == null || nodo3 == null)) {
    if (!(nodo1.getTipo().equals(nodo3.getTipo()))){
        agregarErrorSemantico("Incompatibilidad de tipos en la " + op);
        ret = null;
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
                return null;
            }
        } else {
            // Con casteo: validar que sea permitido
            if (tipoCasteo.equals(tipoReal)) {
                // Intento de forzar un casteo al mismo tipo
                AnalizadorLexico.agregarWarning("El tipo del parámetro real ya es del tipo solicitado en el casteo");
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
                return null;
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
//#line 800 "Parser.java"
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
//#line 23 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa"); if (noHayErrores()){raiz = new NodoComun("PROGRAMA", (Nodo)val_peek(1).obj);}}
break;
case 2:
//#line 24 "gramatica.y"
{yyerror("El programa debe tener un nombre");}
break;
case 3:
//#line 25 "gramatica.y"
{yyerror("Falta delimitador END del programa");}
break;
case 4:
//#line 26 "gramatica.y"
{yyerror("Falta delimitador BEGIN del programa");}
break;
case 5:
//#line 27 "gramatica.y"
{yyerror("Faltan los delimitadores del programa");}
break;
case 6:
//#line 30 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo)val_peek(1).obj, (Nodo)val_peek(0).obj);}
break;
case 7:
//#line 31 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 8:
//#line 35 "gramatica.y"
{yyval.obj = null;}
break;
case 9:
//#line 36 "gramatica.y"
{yyval=val_peek(1);}
break;
case 10:
//#line 37 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
//#line 38 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 12:
//#line 42 "gramatica.y"
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
                                if (tipoActual.equals(ENTERO) || tipoActual.equals(FLOTANTE)) {
                                    t.setUso("variable");
                                } else {
                                    t.setUso("arreglo");
                                }
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
//#line 72 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
//#line 73 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
//#line 77 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion"); yyval=val_peek(0);}
break;
case 16:
//#line 78 "gramatica.y"
{yyval = val_peek(0);AnalizadorLexico.agregarWarning("Se ha llamado a una función pero su valor no ha sido utilizado"); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 17:
//#line 79 "gramatica.y"
{yyval=val_peek(0);}
break;
case 18:
//#line 80 "gramatica.y"
{yyval=val_peek(0);}
break;
case 19:
//#line 81 "gramatica.y"
{yyval=val_peek(0);}
break;
case 20:
//#line 86 "gramatica.y"
{ yyval.obj = new NodoComun("For",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);}
break;
case 21:
//#line 87 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
//#line 88 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
//#line 89 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 24:
//#line 93 "gramatica.y"
{yyval=val_peek(0);}
break;
case 25:
//#line 94 "gramatica.y"
{yyval=val_peek(0);}
break;
case 26:
//#line 98 "gramatica.y"
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
//#line 106 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
//#line 107 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
//#line 108 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
//#line 109 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
//#line 113 "gramatica.y"
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
//#line 130 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
//#line 131 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
//#line 132 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
//#line 133 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 36:
//#line 137 "gramatica.y"
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
//#line 160 "gramatica.y"
{yyval.obj = new NodoHoja("Up");}
break;
case 38:
//#line 161 "gramatica.y"
{yyval.obj = new NodoHoja("Down");}
break;
case 39:
//#line 165 "gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,val_peek(2).sval);
                              Nodo asignacion = null;
                              Token t = null;
                              if (ambitoVar.equals("")){
                                  t = TablaSimbolos.getToken(val_peek(2).sval);
                                  if (t.getTipo() == null){
                                        agregarErrorSemantico("La variable '" + val_peek(2).sval + "' no fue declarada");
                                        yyval.obj = null;
                                  }
                                  else {
                                        t.getLexema().setLength(0);
                                        t.getLexema().append(val_peek(2).sval).append("@").append(ambito);
                                        t.setAmbito(ambito);
                                        t.setUso("variable");
                                        TablaSimbolos.removeToken(val_peek(2).sval);
                                        TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                        NodoHoja id = new NodoHoja(t.getLexema().toString(),t);
                                        if (((Nodo)val_peek(0).obj).getTipo() != null){
                                            if (!(id.getTipo().equals(((Nodo)val_peek(0).obj).getTipo())))
                                                agregarErrorSemantico("Incompatibilidad de tipos");
                                        }
                                        yyval.obj = new NodoComun(val_peek(1).sval ,id, (Nodo)val_peek(0).obj);
                                  }
                              }
                              else {
                                  t = TablaSimbolos.getToken(val_peek(2).sval + "@" + ambitoVar);

                                  if (!(t.getUso().equals("variable") || t.getUso().equals("parametro") || t.getUso().equals("arreglo"))) {
                                      agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")");
                                      yyval.obj = null;
                                  } else {
                                      if (t.getUso().equals("arreglo")) {
                                          Token t2 = TablaSimbolos.getToken(val_peek(0).sval + "@" + ambitoVar);
                                          if (t2 != null) {
                                              if (!(t2.getTipo().equals(t.getTipo()))) {
                                                  agregarErrorSemantico("Incompatibilidad de tipos");
                                              } else {
                                                  NodoHoja id = new NodoHoja(t.getLexema().toString(), t);
                                                  yyval.obj = new NodoComun(val_peek(1).sval, id, (Nodo) val_peek(0).obj);
                                              }
                                          } else {
                                              agregarErrorSemantico("La expresión en la parte derecha de la asignación no está definida.");
                                              yyval.obj = null;
                                          }
                                      } else {
                                          NodoHoja id = new NodoHoja(t.getLexema().toString(), t);
                                          if ((Nodo)val_peek(0).obj != null && ((Nodo)val_peek(0).obj).getTipo() != null){
                                          if (!(id.getTipo().equals(((Nodo)val_peek(0).obj).getTipo())))
                                            agregarErrorSemantico("Incompatibilidad de tipos");
                                          }
                                          yyval.obj = new NodoComun(val_peek(1).sval, id, (Nodo) val_peek(0).obj);
                                      }
                                  }
                                  TablaSimbolos.removeToken(val_peek(2).sval);
                              }}
break;
case 40:
//#line 220 "gramatica.y"
{
                                                String ambitoVar = buscarAmbito(ambito,val_peek(5).sval);
                                                if (ambitoVar.equals("")){
                                                    agregarErrorSemantico("La variable '" + val_peek(5).sval + "' no fue declarada");
                                                    yyval.obj = null;
                                                }
                                                else {
                                                    Token t = TablaSimbolos.getToken(val_peek(5).sval + "@" + ambitoVar);
                                                    String tipo = t.getTipo();
                                                    if (tiposDeclarados.containsKey(tipo)){
                                                        String tipoTriple = tiposDeclarados.get(tipo);
                                                        NodoHoja nodo = new NodoHoja(val_peek(5).sval + val_peek(4).sval + val_peek(3).sval + val_peek(2).sval, t);
                                                        nodo.setUso("arreglo");
                                                        if (((Nodo)val_peek(0).obj).getTipo() != null){
                                                            if (!(tipoTriple.equals(((Nodo)val_peek(0).obj).getTipo())))
                                                                agregarErrorSemantico("Incompatibilidad de tipos");
                                                        }
                                                        yyval.obj = new NodoComun(val_peek(1).sval,nodo,(Nodo)val_peek(0).obj);
                                                    }
                                                    else {
                                                        agregarErrorSemantico("La variable '" + val_peek(5).sval + "' no es de un tipo TRIPLE definido");
                                                        yyval.obj = null;
                                                    }
                                                }
                                                String index = TablaSimbolos.getToken(val_peek(3).sval).getLexema().toString();
                                                if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                                    agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                                    yyval.obj = null;
                                                }
                                                TablaSimbolos.removeToken(val_peek(5).sval);

                                                }
break;
case 41:
//#line 252 "gramatica.y"
{if (yychar == ID || yychar == CONSTANTE) {
                            yyerror("Se esperaba un operador");
                           } else {
                            if (!(yychar == 91 || yychar == 40))
                                yyerror("Falta parte derecha de la asignación");
                           }
                           while (yychar != 59)
                                yychar = yylex();
                           }
break;
case 43:
//#line 265 "gramatica.y"
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
//#line 281 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 45:
//#line 282 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 46:
//#line 286 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 47:
//#line 287 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 48:
//#line 288 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 49:
//#line 292 "gramatica.y"
{hasReturn = false;
                enFuncion = true;
                funcionActual = val_peek(0).sval + "@" + ambito;
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
                    yyval.obj = null;
                 }

                 addAmbito(idFuncion);
                 }
break;
case 50:
//#line 322 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 51:
//#line 326 "gramatica.y"
{           Nodo parametro = (Nodo)val_peek(2).obj;
                                                             NodoComun funcion = (NodoComun)val_peek(4).obj; /*Encabezado con nombre funcion, este tiene el tipo*/

                                                             funcion.setUso("funcion");
                                                             funcion.setIzq(parametro);

                                                             funcionesDeclaradas.put(funcion.getNombre(),funcion);
                                                             funcionYTipoParametro.put(funcion.getNombre(), funcion.getIzq().getTipo());
                                                         }
break;
case 52:
//#line 334 "gramatica.y"
{
                                                                            NodoComun funcion = funcionesDeclaradas.get(((Nodo)val_peek(6).obj).getNombre());
                                                                            NodoComun cuerpo = (NodoComun)val_peek(0).obj;
                                                                            funcion.setDer(cuerpo);
                                                                            removeAmbito();

                                                                            if (functionTieneIF && faltaReturn && !hasReturn){
                                                                                agregarErrorSemantico("Falta sentencia return en la funcion");
                                                                            }

                                                                            faltaReturn = false;
                                                                            hasReturn = false;
                                                                            functionTieneIF = false;
                                                                            enFuncion = false;}
break;
case 54:
//#line 348 "gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 55:
//#line 349 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 56:
//#line 353 "gramatica.y"
{
               Token t = TablaSimbolos.getToken(val_peek(0).sval);
               if (t != null){
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
case 57:
//#line 368 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 61:
//#line 381 "gramatica.y"
{  yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);
                                                    hasReturn = true;}
break;
case 62:
//#line 383 "gramatica.y"
{yyval=val_peek(0);}
break;
case 63:
//#line 384 "gramatica.y"
{yyval=val_peek(1); hasReturn = true;}
break;
case 64:
//#line 385 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio"); yyval.obj = new NodoComun("Cuerpo vacio");}
break;
case 65:
//#line 390 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(1).obj, (Nodo) val_peek(0).obj);}
break;
case 66:
//#line 391 "gramatica.y"
{yyval=val_peek(0);}
break;
case 67:
//#line 396 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           } else {
                                NodoComun funAct = funcionesDeclaradas.get(funcionActual);
                                String tipoFun = funAct.getTipo();
                                if (!(((Nodo)val_peek(1).obj).getTipo().equals(tipoFun))){
                                    agregarErrorSemantico("El tipo del retorno no coincide con el de la funcion");
                                } else {
                                    yyval.obj = null;
                                }
                           }
                           yyval.obj = new NodoComun("Return", (Nodo)val_peek(1).obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 68:
//#line 412 "gramatica.y"
{
                         String expresion = ((Nodo)val_peek(2).obj).getNombre();
                         String termino = ((Nodo)val_peek(0).obj).getNombre();
                         if (!(expresion == null || termino == null)){
                             Nodo nIzq = (Nodo)val_peek(2).obj;
                             Nodo nDer = (Nodo)val_peek(0).obj;
                             yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                         }
                         else {
                            yyval.obj = null;
                         }
                        }
break;
case 69:
//#line 424 "gramatica.y"
{
                         String expresion = ((Nodo)val_peek(2).obj).getNombre();
                         String termino = ((Nodo)val_peek(0).obj).getNombre();
                         if (!(expresion == null || termino == null)){
                             Nodo nIzq = (Nodo)val_peek(2).obj;
                             Nodo nDer = (Nodo)val_peek(0).obj;
                             yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                         }
                         else {
                            yyval.obj = null;
                         }
                        }
break;
case 70:
//#line 436 "gramatica.y"
{if (yychar == ID || yychar == CONSTANTE) {
                yyerror("Se esperaba un operador");
                yychar = yylex();
              }
              yyval = val_peek(0);}
break;
case 71:
//#line 441 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 72:
//#line 442 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 73:
//#line 446 "gramatica.y"
{
                         String termino = ((Nodo)val_peek(2).obj).getNombre();
                         String factor = ((Nodo)val_peek(0).obj).getNombre();
                         if (!(termino == null || factor == null)){
                             Nodo nIzq = (Nodo)val_peek(2).obj;
                             Nodo nDer = (Nodo)val_peek(0).obj;
                             yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                         }
                         else {
                            yyval.obj = null;
                         }
                        }
break;
case 74:
//#line 458 "gramatica.y"
{
                         String termino = ((Nodo)val_peek(2).obj).getNombre();
                         String factor = ((Nodo)val_peek(0).obj).getNombre();
                         if (!(termino == null || factor == null)){
                             Nodo nIzq = (Nodo)val_peek(2).obj;
                             Nodo nDer = (Nodo)val_peek(0).obj;
                             yyval.obj = controlarTipos(nIzq,val_peek(1).sval,nDer);
                         }
                         else {
                            yyval.obj = null;
                         }
                        }
break;
case 75:
//#line 470 "gramatica.y"
{if (yychar == ID || yychar == CONSTANTE) {
                                   yyerror("Se esperaba un operador");
                                   yychar = yylex();
                               }
                               yyval = val_peek(0);}
break;
case 76:
//#line 475 "gramatica.y"
{yyval.obj = null; yyerror("Se esperaba un factor");}
break;
case 77:
//#line 476 "gramatica.y"
{yyval.obj = null; yyerror("Se esperaba un factor");}
break;
case 78:
//#line 480 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
        String idToString = val_peek(0).sval;
        if (ambitoVar.equals("") && (idToString.startsWith("x") || idToString.startsWith("z") || idToString.startsWith("s"))) {
            Token t = TablaSimbolos.getToken(idToString);
            t.getLexema().setLength(0);
            t.getLexema().append(idToString).append("@").append(ambito);
            t.setAmbito(ambito);
            t.setUso("variable");
            if (idToString.startsWith("s")) {
                t.setTipo(FLOTANTE);}
            else {
                t.setTipo(ENTERO);}
            TablaSimbolos.removeToken(idToString);
            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
            Nodo aux = new NodoHoja(val_peek(0).sval+"@"+ambito, t);
            yyval.obj = aux;
        }
        else if (ambitoVar.equals("")) {
                    agregarErrorSemantico("La variable '" + val_peek(0).sval + "' no fue declarada");
                    Nodo aux = null;
                    yyval.obj = aux;
        }
        else {
            Token t = TablaSimbolos.getToken(val_peek(0).sval + "@" + ambitoVar);
            if (!(t.getUso().equals("variable") || t.getUso().equals("parametro") || t.getUso().equals("arreglo")))
                agregarErrorSemantico("'" + val_peek(0).sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                Nodo aux = new NodoHoja(val_peek(0).sval+"@"+ambitoVar, t);
                yyval.obj = aux;
            }
        }
        TablaSimbolos.removeToken(val_peek(0).sval);
        }
break;
case 79:
//#line 513 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                t.setValor(val_peek(0).sval);
                t.setUso("constante");
                yyval.obj = new NodoHoja(val_peek(0).sval,t);
                }
break;
case 80:
//#line 518 "gramatica.y"
{yyval = val_peek(0); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 81:
//#line 519 "gramatica.y"
{    String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + val_peek(3).sval + "' no fue declarada");
                                    yyval.obj = null;
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
                                        yyval.obj = null;
                                    }
                                }
                             String index = TablaSimbolos.getToken(val_peek(1).sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 yyval.obj = null;
                             }
                             TablaSimbolos.removeToken(val_peek(3).sval);
                            }
break;
case 82:
//#line 544 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + val_peek(0).sval + "' no fue declarada");
                         yyval.obj = null;
                     }
                     else {
                         Token t = TablaSimbolos.getToken(val_peek(0).sval + "@" + ambitoVar);
                         if (!(t.getUso().equals("variable") || t.getUso().equals("parametro") || t.getUso().equals("arreglo"))){
                             agregarErrorSemantico("'" + val_peek(0).sval + "' no es una variable. Es un/a " + t.getUso());
                             yyval.obj = null;
                         }
                         else {
                             yyval.obj = new NodoHoja(val_peek(1).sval + val_peek(0).sval + "@" + ambitoVar,t);
                         }
                     }
                     TablaSimbolos.removeToken(val_peek(0).sval);
                     }
break;
case 83:
//#line 561 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                                        if (t != null && t.getTipo().equals(ENTERO)) {
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                                            yyval.obj = null;
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
case 84:
//#line 575 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + val_peek(3).sval + "' no fue declarada");
                                    yyval.obj = null;
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
                                        yyval.obj = null;
                                    }
                                }
                             String index = TablaSimbolos.getToken(val_peek(1).sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 yyval.obj = null;
                             }
                             TablaSimbolos.removeToken(val_peek(3).sval);
                            }
break;
case 85:
//#line 603 "gramatica.y"
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
                                            yyval.obj = null;
                                         }
                                         }
break;
case 86:
//#line 626 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 87:
//#line 627 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 88:
//#line 628 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 89:
//#line 629 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 90:
//#line 630 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 91:
//#line 634 "gramatica.y"
{
        AnalizadorLexico.agregarEstructura("Se reconocio invocacion a funcion");
        String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
        if (ambitoVar.equals("")){
                    agregarErrorSemantico("La funcion '" + val_peek(3).sval + "' no fue declarada");
                    yyval.obj = null;
        }
        else if (enFuncion && funcionActual.equals(val_peek(3).sval)){
                        NodoComun nodoFunActual = funcionesDeclaradas.get(val_peek(3).sval + "@" + ambito);
                        Nodo exp = (Nodo)val_peek(3).obj;
                        generarLlamadoFuncion(nodoFunActual,exp,null);
        }
        else {
            NodoComun funcion = funcionesDeclaradas.get(val_peek(3).sval + "@" + ambitoVar);
            String tipoParametroFormal = funcion.getIzq().getTipo();
            if (((Nodo)val_peek(1).obj).getTipo().equals(tipoParametroFormal)){
                if (funcionesDeclaradas.containsKey(val_peek(3).sval + "@" + ambitoVar)){
                        Nodo exp = (Nodo)val_peek(1).obj;
                        yyval.obj = generarLlamadoFuncion(funcion,exp,null);
                    }
                    else {
                        agregarErrorSemantico("La funcion '" + val_peek(3).sval + "' no fue declarada");
                        yyval.obj = null;
                    }
            } else {
                agregarErrorSemantico("El tipo del parametro real no coincide con el del real");
            }
        }
        TablaSimbolos.removeToken(val_peek(3).sval);
    }
break;
case 92:
//#line 664 "gramatica.y"
{ yyerror("El identificador de una funcion no puede ser una palabra reservada");
    yyval.obj = null;}
break;
case 93:
//#line 666 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 94:
//#line 667 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 95:
//#line 668 "gramatica.y"
{
            AnalizadorLexico.agregarEstructura("Se reconocio conversion");
            String ambitoVar = buscarAmbito(ambito,val_peek(6).sval);
            if (ambitoVar.equals("")){
                agregarErrorSemantico("La funcion '" + val_peek(6).sval + "' no fue declarada");
                yyval.obj = null;
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
                        yyval.obj = null;
                }
            }
            TablaSimbolos.removeToken(val_peek(6).sval);
        }
break;
case 97:
//#line 693 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 98:
//#line 697 "gramatica.y"
{yyval=val_peek(1);}
break;
case 99:
//#line 698 "gramatica.y"
{yyval=val_peek(1);}
break;
case 100:
//#line 699 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 101:
//#line 703 "gramatica.y"
{inIF=true; yyval=val_peek(0); cantIF++; returnIFStack.push(false);}
break;
case 102:
//#line 707 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)val_peek(1).obj);
                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)val_peek(4).obj, cuerpo);
                                                                                                                                          boolean currentReturnIF = returnIFStack.pop();
                                                                                                                                          /*if (enFuncion){*/
                                                                                                                                            functionTieneIF = true;
                                                                                                                                           /* if (!(currentReturnIF)){*/
                                                                                                                                                faltaReturn = true;
                                                                                                                                           /* }*/
                                                                                                                                          /*}*/
                                                                                                                                          /*returnIF = false;*/
                                                                                                                                          if (!(--cantIF == 0))
                                                                                                                                              inIF = true;
                                                                                                                                          }
break;
case 103:
//#line 723 "gramatica.y"
{inIF=false; if (ifHasReturn){ returnIFStack.pop();returnIFStack.push(true); ifHasReturn=false;} returnELSEStack.push(false);}
break;
case 104:
//#line 723 "gramatica.y"
{if (ifHasReturn){returnELSEStack.pop();returnELSEStack.push(true); ifHasReturn=false;}}
break;
case 105:
//#line 723 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE"); NodoComun nThen = new NodoComun("Then", (Nodo)val_peek(5).obj);
                                                                                                                                                                    NodoComun nElse = new NodoComun("Else", (Nodo)val_peek(2).obj);
                                                                                                                                                                    Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                    yyval.obj = new NodoComun("If", (Nodo)val_peek(8).obj,cuerpo);
                                                                                                                                                                    boolean currentReturnIF = returnIFStack.pop();
                                                                                                                                                                    boolean currentReturnELSE = returnELSEStack.pop();
                                                                                                                                                                    if (enFuncion){
                                                                                                                                                                        functionTieneIF = true;
                                                                                                                                                                        if (!(currentReturnIF && currentReturnELSE)){
                                                                                                                                                                            faltaReturn = true;
                                                                                                                                                                        } else {
                                                                                                                                                                            ifHasReturn=true;
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                    /*returnELSE = false;*/
                                                                                                                                                                    /*returnIF = false;*/

                                                                                                                                                                    cantIF--;
                                                                                                                                                                    if (!(cantIF == 0)){
                                                                                                                                                                        inIF = true;
                                                                                                                                                                    }else{
                                                                                                                                                                        inIF=false;}
                                                                                                                                                                    }
break;
case 106:
//#line 749 "gramatica.y"
{yyerror("Falta condicion en el IF");}
break;
case 107:
//#line 750 "gramatica.y"
{yyerror("Falta THEN en el IF");}
break;
case 110:
//#line 759 "gramatica.y"
{yyval = val_peek(1);}
break;
case 111:
//#line 760 "gramatica.y"
{yyval = val_peek(1); if (inIF) {
                                        returnIFStack.pop();
                                        returnIFStack.push(true); /* Marcamos el return en el nivel actual*/
                                             } else {
                                                 returnELSEStack.pop();
                                                 returnELSEStack.push(true); /* Marcamos el return en el nivel actual*/
                                             }
                            }
break;
case 112:
//#line 768 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 113:
//#line 769 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 114:
//#line 770 "gramatica.y"
{yyval = val_peek(2);if (inIF) {
                                                                    returnIFStack.pop();
                                                                    returnIFStack.push(true); /* Marcamos el return en el nivel actual*/
                                                                } else {
                                                                    returnELSEStack.pop();
                                                                    returnELSEStack.push(true); /* Marcamos el return en el nivel actual*/
                                                                }
                                                }
break;
case 115:
//#line 778 "gramatica.y"
{yyval = val_peek(1);}
break;
case 116:
//#line 779 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 117:
//#line 780 "gramatica.y"
{yyval = val_peek(3); if (inIF) {
                                                                                                 returnIFStack.pop();
                                                                                                 returnIFStack.push(true); /* Marcamos el return en el nivel actual*/
                                                                                             } else {
                                                                                                 returnELSEStack.pop();
                                                                                                 returnELSEStack.push(true); /* Marcamos el return en el nivel actual*/
                                                                                             }}
break;
case 118:
//#line 787 "gramatica.y"
{yyerror("Se encontró 'end_cuerpo_if' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 119:
//#line 795 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 120:
//#line 796 "gramatica.y"
{yyval = val_peek(1);}
break;
case 121:
//#line 797 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 122:
//#line 801 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 123:
//#line 802 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 124:
//#line 803 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 125:
//#line 804 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 126:
//#line 805 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 127:
//#line 806 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 128:
//#line 810 "gramatica.y"
{   Nodo exp1 = (Nodo)val_peek(2).obj;
                                        Nodo exp2 = (Nodo)val_peek(0).obj;
                                        if (!(exp1 == null || exp2 == null)) {
                                            if (!((Nodo)val_peek(2).obj).getTipo().equals(((Nodo)val_peek(0).obj).getTipo())){
                                                agregarErrorSemantico("Los tipos son incompatibles en la condicion");
                                                yyval.obj = null;
                                            }
                                            else
                                                yyval.obj = new NodoComun(val_peek(1).sval, (Nodo)val_peek(2).obj, (Nodo)val_peek(0).obj);
                                        }
                                        else {
                                            yyval.obj = null;
                                        }
                                    }
break;
case 129:
//#line 824 "gramatica.y"
{inList1 = true;}
break;
case 130:
//#line 824 "gramatica.y"
{inList1 = false;}
break;
case 131:
//#line 824 "gramatica.y"
{inList2 = true;}
break;
case 132:
//#line 824 "gramatica.y"
{inList2 = false;}
break;
case 133:
//#line 825 "gramatica.y"
{ NodoComun salida = new NodoComun(val_peek(5).sval);
      AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
      if (expresiones1.size() == expresiones2.size()){
            Nodo aux;
            for (int i = 0; i < expresiones1.size(); i++) {
                Nodo exp1 = expresiones1.get(i);
                Nodo exp2 = expresiones2.get(i);
                if (exp1 == null || exp2 == null){
                    salida = null;
                    break;
                }
                if (!(exp1.getTipo().equals(exp2.getTipo()))){
                    agregarErrorSemantico("Las expresiones en la posicion " + i + " no tienen el mismo tipo");
                    aux = null;
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
case 134:
//#line 862 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 135:
//#line 867 "gramatica.y"
{
    if (inList1)
            expresiones1.add((Nodo)val_peek(0).obj);
        if (inList2)
            expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 136:
//#line 877 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 137:
//#line 884 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval = val_peek(0);
    }
break;
case 138:
//#line 891 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 139:
//#line 895 "gramatica.y"
{   Token t = TablaSimbolos.getToken(val_peek(1).sval);
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            yyval.obj = new NodoComun("Outf", new NodoHoja(val_peek(1).sval, t));
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 140:
//#line 901 "gramatica.y"
{   Nodo exp = (Nodo)val_peek(1).obj;
                                 if (!(exp == null)){
                                     Token t = new Token(exp.getToken());
                                     /*t.setUso("mensaje");*/
                                     t.setTipo(exp.getTipo());
                                     yyval.obj = new NodoComun("Outf", new NodoHoja(exp.getNombre(),t));
                                 }
                                 else {
                                    yyval.obj = null;
                                 }
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }
break;
case 141:
//#line 914 "gramatica.y"
{yyerror("Los print unicamente pueden contener expresiones o cadenas");}
break;
case 142:
//#line 915 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 2111 "Parser.java"
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
