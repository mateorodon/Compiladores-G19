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
   26,   27,    7,    7,    7,   24,   24,   28,   29,   29,
   25,   25,   25,   25,   30,   30,   31,   21,   21,   21,
   21,   21,   32,   32,   32,   32,   32,   33,   33,   33,
   33,   33,   33,   33,    8,    8,    8,    8,    8,    8,
   10,   10,   10,   10,   10,   35,   35,   15,   15,   15,
   37,   11,   11,   39,   39,   38,   38,   38,   38,   38,
   38,   38,   38,   38,   36,   36,   36,   40,   40,   40,
   40,   40,   40,   19,   41,   42,   43,   44,   19,   19,
   34,   45,   45,   45,   12,   12,   12,   12,
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
    1,    7,    9,    1,    2,    2,    2,    1,    1,    4,
    3,    4,    5,    2,    3,    2,    1,    1,    1,    1,
    1,    1,    1,    3,    0,    0,    0,    0,   11,    1,
    3,    3,    1,    1,    4,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,  101,    0,    0,    0,    0,   44,
   45,    0,    0,    7,    0,    0,    0,   13,   14,   15,
   16,   17,   18,   19,   42,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   24,
   25,    0,    4,    6,    8,    9,   48,    0,    0,    0,
    0,    2,   41,    0,   79,    0,   80,    0,    0,   75,
  134,   94,    0,    0,    0,    0,    0,    1,    0,    0,
  138,    0,    0,    0,    0,    0,    0,    0,    0,  130,
    0,  125,    0,    0,   49,   47,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   83,    0,    0,    0,
    0,   91,    0,   93,    0,    0,  137,  135,  136,    0,
   89,    0,    0,   92,   36,    0,    0,    0,    0,   23,
   22,    0,    0,    0,  118,  119,  120,  123,  122,  121,
    0,   46,    0,   56,    0,    0,    0,    0,    0,    0,
   71,    0,   72,    0,   76,   73,   77,   74,    0,    0,
    0,   88,    0,   87,   90,  100,    0,    0,   21,   20,
   98,   37,   38,    0,    0,    0,  126,    0,    0,    0,
   66,    0,    0,    0,   51,    0,    0,    0,   81,    0,
    0,    0,   86,   85,  116,   99,    0,    0,    0,    0,
    0,    0,    0,   55,   65,    0,   63,    0,    0,    0,
    0,    0,    0,    0,   84,   95,  115,    0,    0,    0,
    0,    0,    0,    0,   61,   52,   54,    0,    0,    0,
  107,  114,   97,    0,   96,  102,    0,    0,    0,    0,
    0,    0,   67,    0,    0,    0,    0,  111,    0,    0,
    0,   35,    0,  127,    0,   53,  110,  105,    0,  112,
  103,   32,    0,   34,    0,   33,  113,   31,  128,    0,
  129,
};
final static short yydgoto[] = {                          3,
   13,   14,   15,   16,   17,   49,   18,   19,   20,   57,
   22,   23,   24,   39,  120,   40,   41,   42,   83,  165,
   84,   25,   26,   91,  172,  198,  234,   92,   93,  173,
  174,   59,   60,   65,  226,  203,   27,  204,  238,  131,
  123,  191,  255,  260,   66,
};
final static short yysindex[] = {                      -166,
  359,  484,    0,  -12,    0,  484,  -19,  -54,  -16,    0,
    0,   11,  400,    0,  -24,  -21, -183,    0,    0,    0,
    0,    0,    0,    0,    0,    7,   15,  422,  -43,  314,
 -187,  438,  338,  -31, -124,   -8, -176, -151,   72,    0,
    0,   -9,    0,    0,    0,    0,    0, -133,   21,  -33,
   -6,    0,    0,  -20,    0, -179,    0,   86,   65,    0,
    0,    0,  319,   90,  114,  135,   91,    0,  145,  153,
    0,  341, -124,  -49,  155,  365,  -55,  -37,  311,    0,
   -6,    0,  156,  144,    0,    0,   30,    0,  -22,   31,
  177,  251,  258,  270,   50,  225,    0,  245,  269,  293,
  335,    0,   -8,    0,   -8,   68,    0,    0,    0,  -48,
    0,   78,   79,    0,    0,  -12,  217,  -79,  281,    0,
    0,  -56,  356, -134,    0,    0,    0,    0,    0,    0,
   -8,    0,  461,    0,   83,  107, -234,  116,  295,  136,
    0,   65,    0,   65,    0,    0,    0,    0,  383,   86,
   -8,    0,  -81,    0,    0,    0,  343,  535,    0,    0,
    0,    0,    0, -174,  167,   86,    0,  168,   86,  385,
    0,  173,  461,  384,    0,  461,    0,  500,    0,  357,
  408,   86,    0,    0,    0,    0,  393,  402,  -30,  404,
  421,  406,   -8,    0,    0,  418,    0,  461,  210, -103,
  420,  424,  544, -130,    0,    0,    0,  440,  425,   -6,
  446,  361,  452,  403,    0,    0,    0,  437,  511,    0,
    0,    0,    0,  500,    0,    0,   -6,  457,  459,   -6,
  458,   -6,    0,  235,  236,  449,  -52,    0, -192,  464,
   -6,    0,  469,    0,  470,    0,    0,    0,  236,    0,
    0,    0,  472,    0,  356,    0,    0,    0,    0,  474,
    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -177,    0,    0,    0,    0,    0,    0,
    0,    0,  516,    0,  163,  183,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  519,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    7,  196,    0,
    0,    0,    0,    1,    0,    0,    0,  121,   49,    0,
    0,    0,  476,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -32,    0,    0,
  477,    0,    0,    0,    0,   25,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  254,    0,    0,    0,    0,    0,    0,    0,
    0,   73,    0,   97,    0,    0,    0,    0,    0,  105,
    0,    0,    0,    0,    0,    0,  521,    0,    0,    0,
    0,    0,    0,    0,    0,  476,    0,    0,  -41,    0,
    0,    0,  256,    0,    0,  254,  130,    0,    0,    0,
    0,  143,    0,    0,    0,    0,    0,  -36,  218,  242,
    0,  266,    0,    0,    0,    0,    0,  254,    0,    0,
 -104,  -74,    0,    0,    0,    0,    0,    0,  290,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  390,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  176,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
final static short yygindex[] = {                         0,
  113,  463,    0,  527,  -39,    0,    0,    0,    0,  571,
    0,    0,    0,  489,  -62,    0,    0,    0,  -29, -105,
   -3,   23,    0,  391, -144,    0,    0,    0,    0,    0,
  -97,  101,  110, -108,  296, -101,    0,  305, -112,  320,
    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=820;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        124,
   78,   56,  164,  118,   27,   35,  249,   89,   57,  210,
   90,   57,  112,  153,  167,  158,  121,  124,  168,   30,
   33,   94,   88,   36,   82,   58,   63,   30,   73,   72,
   82,  199,   76,   82,   45,   56,   56,   46,   56,   10,
   11,   78,   78,   78,   78,   78,   50,   78,   70,   81,
   38,  122,   64,  216,   51,  160,   74,   75,  189,   78,
   78,   78,   78,  223,   87,   82,   82,   82,   82,   82,
   95,   82,   68,   47,   67,  196,  225,   96,   31,   43,
  202,   77,   97,   82,   82,   82,   82,  188,   48,   70,
    1,   70,   70,   70,   43,  110,   69,   90,  219,  149,
    2,  150,  218,  162,  163,   37,  100,   70,   70,   70,
   70,  101,   79,   68,   28,   68,   68,   68,   32,  166,
   39,  237,  247,   85,  250,  223,  202,  169,   98,  103,
   99,   68,   68,   68,   68,  224,  257,   69,  225,   69,
   69,   69,   40,  162,  163,  131,  259,  182,  132,   10,
   11,  108,  117,  116,  104,   69,   69,   69,   69,  117,
    5,  108,   11,  117,  108,  117,    7,  117,    9,  170,
   58,  117,   12,   60,  183,  184,  159,  116,  105,   39,
  229,  109,   10,  106,    5,  107,   98,  117,   99,  214,
    7,  109,    9,  108,  109,   12,   12,  240,  142,  144,
  243,   40,  245,  128,  130,  129,  115,  111,  152,  146,
  148,  253,   53,   54,  124,  236,  113,  135,   55,  116,
   27,  162,  163,   88,   43,   34,    5,   27,    9,  117,
   27,  209,    7,   27,    9,   27,  124,  124,   12,   27,
   10,   11,   10,   11,  133,   29,   80,   54,   54,   80,
   54,  166,   55,   55,   12,   55,   78,   78,   30,   78,
   78,   78,    9,    9,   78,    9,   78,   37,   78,   78,
   78,   78,   78,   78,   78,   78,   78,   86,   78,   78,
   82,   82,   29,   82,   82,   82,  132,  134,   82,   56,
   82,  136,   82,   82,   82,   82,   82,   82,   82,   82,
   82,  137,   82,   82,   70,   70,   28,   70,   70,   70,
  138,  139,   70,   56,   70,  140,   70,   70,   70,   70,
   70,   70,   70,   70,   70,  151,   70,   70,   68,   68,
   26,   68,   68,   68,  154,  155,   68,   56,   68,  161,
   68,   68,   68,   68,   68,   68,   68,   68,   68,  175,
   68,   68,   69,   69,   62,   69,   69,   69,   56,  102,
   69,   98,   69,   99,   69,   69,   69,   69,   69,   69,
   69,   69,   69,  176,   69,   69,   39,   39,   71,   56,
  178,  109,   56,   98,   39,   99,   39,  179,   39,   39,
   39,   39,   39,   39,   39,   39,   39,  180,   40,   40,
   56,  185,  125,  126,  127,  114,   40,   98,   40,   99,
   40,   40,   40,   40,   40,   40,   40,   40,   40,   11,
  128,  130,  129,  181,  193,   98,   11,   99,  190,  192,
   11,  104,   11,   11,   11,   11,   11,   11,   11,   10,
  194,  104,  197,  233,  104,   98,   10,   99,  206,  205,
   10,  207,   10,   10,   10,   10,   10,   10,   10,   12,
  208,  212,  211,   12,  213,   12,   12,   12,   12,   12,
   12,   12,  156,  116,   30,   44,  215,  217,  220,  227,
    5,   30,  221,  228,   30,  230,    7,   30,    9,   30,
   44,  232,   12,   30,   44,  235,  241,  244,   29,  242,
  141,   54,  246,  236,  252,   29,   55,  248,   29,  254,
  256,   29,  258,   29,  261,    5,    9,   29,    3,  133,
   59,   64,   28,   62,  143,   54,   78,  177,  239,   28,
   55,  231,   28,    0,  251,   28,    0,   28,    0,    0,
    9,   28,    0,    0,    0,    0,   26,    0,  145,   54,
    0,    0,    0,   26,   55,    0,   26,    0,    0,   26,
    0,   26,    0,    0,    9,   26,    0,  116,    0,   61,
   54,   21,   21,    0,    5,   55,   21,  117,    0,    0,
    7,    0,    9,   21,    0,    9,   12,   10,   11,    0,
  147,   54,    0,   69,   54,  171,   55,    0,   21,   55,
   70,    0,   21,    0,  119,  119,    9,    0,    0,    9,
    0,   61,   54,    0,    0,    4,    0,   55,    0,  125,
  126,  127,    5,    0,    0,    6,    0,    9,    7,    8,
    9,    0,   10,   11,   12,  195,    0,    0,  171,    0,
    0,    0,    0,  157,  119,  106,  116,    0,   21,   21,
    0,    0,    0,  116,    0,  106,    4,  116,  106,  116,
  171,  116,    0,    5,    0,  116,    0,   43,    0,    7,
    8,    9,    0,   10,   11,   12,    0,    0,    4,    0,
    0,    0,    0,    0,  187,    5,    0,   21,   21,   52,
    0,    7,    8,    9,    4,   10,   11,   12,    0,    0,
    0,    5,    0,   21,  201,   68,    0,    7,    8,    9,
    0,   10,   11,   12,    0,    0,    0,    4,    0,    0,
    0,    0,    0,    0,    5,    0,  157,    0,   21,  187,
    7,    8,    9,  170,   10,   11,   12,    0,    0,    0,
    4,    0,    0,   21,    0,  187,   21,    5,   21,    0,
  201,    0,    0,    7,    8,    9,  116,   10,   11,   12,
    0,    0,    0,    5,    0,    0,  200,  116,   21,    7,
   21,    9,  170,   21,    5,   12,    0,  117,  236,    0,
    7,    0,    9,  170,  117,    0,   12,    0,  117,   21,
  117,  116,  117,  117,   21,    0,  117,    0,    5,    0,
  116,    0,  186,    0,    7,    0,    9,    5,    0,    0,
   12,  222,    0,    7,    0,    9,    0,    0,    0,   12,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   45,   59,   41,   41,   60,   59,   41,   41,   40,
   50,   44,   62,   62,  123,  117,   79,   59,  124,   40,
   40,   51,  257,   40,    0,   29,   30,   40,   60,   33,
   40,  176,   36,   40,   59,   45,   45,   59,   45,  274,
  275,   41,   42,   43,   44,   45,   40,   47,    0,   59,
   40,   81,   30,  198,   40,  118,   34,   35,  164,   59,
   60,   61,   62,  256,   44,   41,   42,   43,   44,   45,
   91,   47,    0,  257,  262,  173,  269,  257,   91,  257,
  178,  258,  262,   59,   60,   61,   62,  262,  272,   41,
  257,   43,   44,   45,  272,   73,    0,  137,  200,  103,
  267,  105,  200,  278,  279,  257,   42,   59,   60,   61,
   62,   47,   41,   41,    2,   43,   44,   45,    6,  123,
    0,  219,  235,  257,  237,  256,  224,  131,   43,   40,
   45,   59,   60,   61,   62,  266,  249,   41,  269,   43,
   44,   45,    0,  278,  279,   41,  255,  151,   44,  274,
  275,  256,  257,  257,   41,   59,   60,   61,   62,  264,
  264,  266,    0,  268,  269,  270,  270,  272,  272,  273,
   41,  276,  276,   44,  256,  257,  256,  257,   44,   59,
  210,  256,    0,   93,  264,   41,   43,  267,   45,  193,
  270,  266,  272,   41,  269,    0,  276,  227,   98,   99,
  230,   59,  232,   60,   61,   62,  262,  257,  257,  100,
  101,  241,  256,  257,   59,  268,   62,   41,  262,  257,
  257,  278,  279,  257,  257,  280,  264,  264,  272,  267,
  267,  262,  270,  270,  272,  272,  278,  279,  276,  276,
  274,  275,  274,  275,  267,  258,  256,  257,  257,  256,
  257,  255,  262,  262,   59,  262,  256,  257,   41,  259,
  260,  261,  272,  272,  264,  272,  266,  257,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  257,  278,  279,
  256,  257,   41,  259,  260,  261,  257,  257,  264,   45,
  266,   41,  268,  269,  270,  271,  272,  273,  274,  275,
  276,   44,  278,  279,  256,  257,   41,  259,  260,  261,
   41,  262,  264,   45,  266,   91,  268,  269,  270,  271,
  272,  273,  274,  275,  276,  258,  278,  279,  256,  257,
   41,  259,  260,  261,  257,  257,  264,   45,  266,   59,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  267,
  278,  279,  256,  257,   41,  259,  260,  261,   45,   41,
  264,   43,  266,   45,  268,  269,  270,  271,  272,  273,
  274,  275,  276,  267,  278,  279,  256,  257,   41,   45,
  265,   41,   45,   43,  264,   45,  266,   93,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  262,  256,  257,
   45,   59,  259,  260,  261,   41,  264,   43,  266,   45,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  257,
   60,   61,   62,   41,   40,   43,  264,   45,  262,  262,
  268,  256,  270,  271,  272,  273,  274,  275,  276,  257,
  268,  266,   59,   41,  269,   43,  264,   45,   41,   93,
  268,   59,  270,  271,  272,  273,  274,  275,  276,  264,
   59,   41,   59,  268,   59,  270,  271,  272,  273,  274,
  275,  276,  256,  257,  257,   13,   59,  268,   59,   40,
  264,  264,   59,   59,  267,   40,  270,  270,  272,  272,
   28,   40,  276,  276,   32,   59,   40,   40,  257,   41,
  256,  257,  268,  268,   41,  264,  262,   59,  267,   41,
   41,  270,   41,  272,   41,    0,  272,  276,    0,   44,
   44,  268,  257,  268,  256,  257,   38,  137,  224,  264,
  262,  212,  267,   -1,  239,  270,   -1,  272,   -1,   -1,
  272,  276,   -1,   -1,   -1,   -1,  257,   -1,  256,  257,
   -1,   -1,   -1,  264,  262,   -1,  267,   -1,   -1,  270,
   -1,  272,   -1,   -1,  272,  276,   -1,  257,   -1,  256,
  257,    1,    2,   -1,  264,  262,    6,  267,   -1,   -1,
  270,   -1,  272,   13,   -1,  272,  276,  274,  275,   -1,
  256,  257,   -1,  256,  257,  133,  262,   -1,   28,  262,
  263,   -1,   32,   -1,   78,   79,  272,   -1,   -1,  272,
   -1,  256,  257,   -1,   -1,  257,   -1,  262,   -1,  259,
  260,  261,  264,   -1,   -1,  267,   -1,  272,  270,  271,
  272,   -1,  274,  275,  276,  173,   -1,   -1,  176,   -1,
   -1,   -1,   -1,  117,  118,  256,  257,   -1,   78,   79,
   -1,   -1,   -1,  264,   -1,  266,  257,  268,  269,  270,
  198,  272,   -1,  264,   -1,  276,   -1,  268,   -1,  270,
  271,  272,   -1,  274,  275,  276,   -1,   -1,  257,   -1,
   -1,   -1,   -1,   -1,  158,  264,   -1,  117,  118,  268,
   -1,  270,  271,  272,  257,  274,  275,  276,   -1,   -1,
   -1,  264,   -1,  133,  178,  268,   -1,  270,  271,  272,
   -1,  274,  275,  276,   -1,   -1,   -1,  257,   -1,   -1,
   -1,   -1,   -1,   -1,  264,   -1,  200,   -1,  158,  203,
  270,  271,  272,  273,  274,  275,  276,   -1,   -1,   -1,
  257,   -1,   -1,  173,   -1,  219,  176,  264,  178,   -1,
  224,   -1,   -1,  270,  271,  272,  257,  274,  275,  276,
   -1,   -1,   -1,  264,   -1,   -1,  267,  257,  198,  270,
  200,  272,  273,  203,  264,  276,   -1,  257,  268,   -1,
  270,   -1,  272,  273,  264,   -1,  276,   -1,  268,  219,
  270,  257,  272,  273,  224,   -1,  276,   -1,  264,   -1,
  257,   -1,  268,   -1,  270,   -1,  272,  264,   -1,   -1,
  276,  268,   -1,  270,   -1,  272,   -1,   -1,   -1,  276,
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
"$$3 :",
"$$4 :",
"$$5 :",
"$$6 :",
"condicion : '(' $$3 bloque_list_expresiones $$4 ')' comparacion '(' $$5 bloque_list_expresiones $$6 ')'",
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

//#line 845 "gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;

static NodoComun raiz;
static String ambito = "main";
static boolean inIF = false;
static boolean hasReturn = false;
public static boolean enFuncion = false;
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
//#line 780 "Parser.java"
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
{yyval.obj = null;}
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
//#line 71 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
//#line 72 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
//#line 76 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion"); yyval=val_peek(0);}
break;
case 16:
//#line 77 "gramatica.y"
{yyval = val_peek(0);AnalizadorLexico.agregarWarning("Se ha llamado a una función pero su valor no ha sido utilizado"); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 17:
//#line 78 "gramatica.y"
{yyval=val_peek(0);}
break;
case 18:
//#line 79 "gramatica.y"
{yyval=val_peek(0);}
break;
case 19:
//#line 80 "gramatica.y"
{yyval=val_peek(0);}
break;
case 20:
//#line 85 "gramatica.y"
{ yyval.obj = new NodoComun("For",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);}
break;
case 21:
//#line 86 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
//#line 87 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
//#line 88 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 24:
//#line 92 "gramatica.y"
{yyval=val_peek(0);}
break;
case 25:
//#line 93 "gramatica.y"
{yyval=val_peek(0);}
break;
case 26:
//#line 97 "gramatica.y"
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
//#line 105 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
//#line 106 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
//#line 107 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
//#line 108 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
//#line 112 "gramatica.y"
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
//#line 129 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
//#line 130 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
//#line 131 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
//#line 132 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 36:
//#line 136 "gramatica.y"
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
//#line 159 "gramatica.y"
{yyval.obj = new NodoHoja("Up");}
break;
case 38:
//#line 160 "gramatica.y"
{yyval.obj = new NodoHoja("Down");}
break;
case 39:
//#line 164 "gramatica.y"
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
                                      yyval.obj = new NodoHoja("error");
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
                                              yyval.obj = new NodoHoja("error");
                                          }
                                      } else {
                                          NodoHoja id = new NodoHoja(t.getLexema().toString(), t);
                                          if (((Nodo)val_peek(0).obj).getTipo() != null){
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
//#line 219 "gramatica.y"
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
                                                        if (((Nodo)val_peek(0).obj).getTipo() != null){
                                                            if (!(tipoTriple.equals(((Nodo)val_peek(0).obj).getTipo())))
                                                                agregarErrorSemantico("Incompatibilidad de tipos");
                                                        }
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
//#line 251 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 43:
//#line 256 "gramatica.y"
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
//#line 272 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 45:
//#line 273 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 46:
//#line 277 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 47:
//#line 278 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 48:
//#line 279 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 49:
//#line 283 "gramatica.y"
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
                    yyval.obj = new NodoComun("error");
                 }

                 addAmbito(idFuncion);
                 }
break;
case 50:
//#line 313 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 51:
//#line 317 "gramatica.y"
{           Nodo parametro = (Nodo)val_peek(2).obj;
                                                             NodoComun funcion = (NodoComun)val_peek(4).obj; /*Encabezado con nombre funcion, este tiene el tipo*/

                                                             funcion.setUso("funcion");
                                                             funcion.setIzq(parametro);

                                                             funcionesDeclaradas.put(funcion.getNombre(),funcion);
                                                             funcionYTipoParametro.put(funcion.getNombre(), funcion.getIzq().getTipo());
                                                         }
break;
case 52:
//#line 325 "gramatica.y"
{ if (!hasReturn) {
                                                                                yyerror("Falta sentencia RET en la función");
                                                                                }
                                                                            NodoComun funcion = funcionesDeclaradas.get(((Nodo)val_peek(6).obj).getNombre());
                                                                            NodoComun cuerpo = (NodoComun)val_peek(0).obj;
                                                                            funcion.setDer(cuerpo);
                                                                            removeAmbito();
                                                                            enFuncion = false;}
break;
case 54:
//#line 333 "gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 55:
//#line 334 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 56:
//#line 338 "gramatica.y"
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
//#line 353 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 61:
//#line 366 "gramatica.y"
{  yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);
                                                    hasReturn = true;}
break;
case 62:
//#line 368 "gramatica.y"
{yyval=val_peek(0);}
break;
case 63:
//#line 369 "gramatica.y"
{yyval=val_peek(1); hasReturn = true;}
break;
case 64:
//#line 370 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio"); yyval.obj = new NodoComun("Cuerpo vacio");}
break;
case 65:
//#line 375 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(1).obj, (Nodo) val_peek(0).obj);}
break;
case 66:
//#line 376 "gramatica.y"
{yyval=val_peek(0);}
break;
case 67:
//#line 381 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           } else {
                                NodoComun funAct = funcionesDeclaradas.get(funcionActual);
                                String tipoFun = funAct.getTipo();
                                if (!(((Nodo)val_peek(1).obj).getTipo().equals(tipoFun))){
                                    agregarErrorSemantico("El tipo del retorno no coincide con el de la funcion");
                                } else {
                                    yyval.obj = new NodoHoja("error");
                                }
                           }
                           yyval.obj = new NodoComun("Return", (Nodo)val_peek(1).obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 68:
//#line 397 "gramatica.y"
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
//#line 409 "gramatica.y"
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
case 70:
//#line 421 "gramatica.y"
{yyval = val_peek(0);}
break;
case 71:
//#line 422 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 72:
//#line 423 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 73:
//#line 427 "gramatica.y"
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
//#line 439 "gramatica.y"
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
case 75:
//#line 451 "gramatica.y"
{yyval = val_peek(0);}
break;
case 76:
//#line 452 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 77:
//#line 453 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 78:
//#line 457 "gramatica.y"
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
                    Nodo aux = new NodoHoja("error");
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
//#line 490 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                t.setValor(val_peek(0).sval);
                t.setUso("constante");
                yyval.obj = new NodoHoja(val_peek(0).sval,t);
                }
break;
case 80:
//#line 495 "gramatica.y"
{yyval = val_peek(0); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 81:
//#line 496 "gramatica.y"
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
case 82:
//#line 521 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,val_peek(0).sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + val_peek(0).sval + "' no fue declarada");
                         yyval.obj = new NodoHoja("error");
                     }
                     else {
                         Token t = TablaSimbolos.getToken(val_peek(0).sval + "@" + ambitoVar);
                         if (!(t.getUso().equals("variable") || t.getUso().equals("parametro") || t.getUso().equals("arreglo"))){
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
case 83:
//#line 538 "gramatica.y"
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
case 84:
//#line 552 "gramatica.y"
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
case 85:
//#line 580 "gramatica.y"
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
case 86:
//#line 603 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 87:
//#line 604 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 88:
//#line 605 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 89:
//#line 606 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 90:
//#line 607 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 91:
//#line 611 "gramatica.y"
{
        AnalizadorLexico.agregarEstructura("Se reconocio invocacion a funcion");
        String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
        if (ambitoVar.equals("")){
                    agregarErrorSemantico("La funcion '" + val_peek(3).sval + "' no fue declarada");
                    yyval.obj = new NodoHoja("error");
                } else if (enFuncion && funcionActual.equals(val_peek(3).sval)){
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
                        yyval.obj = new NodoHoja("error");
                    }
            } else {
                agregarErrorSemantico("El tipo del parametro real no coincide con el del real");
            }
        }
        TablaSimbolos.removeToken(val_peek(3).sval);
    }
break;
case 92:
//#line 640 "gramatica.y"
{ yyerror("El identificador de una funcion no puede ser una palabra reservada");
    yyval.obj = new NodoHoja("error");}
break;
case 93:
//#line 642 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 94:
//#line 643 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 95:
//#line 644 "gramatica.y"
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
case 97:
//#line 669 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 98:
//#line 673 "gramatica.y"
{yyval=val_peek(1);}
break;
case 99:
//#line 674 "gramatica.y"
{yyval=val_peek(1);}
break;
case 100:
//#line 675 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 101:
//#line 679 "gramatica.y"
{inIF=true; yyval=val_peek(0);}
break;
case 102:
//#line 683 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)val_peek(1).obj);
                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 103:
//#line 688 "gramatica.y"
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
//#line 708 "gramatica.y"
{yyval = val_peek(1);}
break;
case 107:
//#line 709 "gramatica.y"
{yyval = val_peek(1); cantReturns++;}
break;
case 108:
//#line 710 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 109:
//#line 711 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 110:
//#line 712 "gramatica.y"
{yyval = val_peek(2);cantReturns++;}
break;
case 111:
//#line 713 "gramatica.y"
{yyval = val_peek(1);}
break;
case 112:
//#line 714 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 113:
//#line 715 "gramatica.y"
{yyval = val_peek(3); cantReturns++;}
break;
case 114:
//#line 716 "gramatica.y"
{yyerror("Se encontró 'end_cuerpo_if' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 115:
//#line 722 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 116:
//#line 723 "gramatica.y"
{yyval = val_peek(1);}
break;
case 117:
//#line 724 "gramatica.y"
{yyerror("Falta ; en la sentencia");}
break;
case 118:
//#line 728 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 119:
//#line 729 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 120:
//#line 730 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 121:
//#line 731 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 122:
//#line 732 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 123:
//#line 733 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 124:
//#line 737 "gramatica.y"
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
case 125:
//#line 751 "gramatica.y"
{inList1 = true;}
break;
case 126:
//#line 751 "gramatica.y"
{inList1 = false;}
break;
case 127:
//#line 751 "gramatica.y"
{inList2 = true;}
break;
case 128:
//#line 751 "gramatica.y"
{inList2 = false;}
break;
case 129:
//#line 752 "gramatica.y"
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
case 130:
//#line 789 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 131:
//#line 794 "gramatica.y"
{
    if (inList1)
            expresiones1.add((Nodo)val_peek(0).obj);
        if (inList2)
            expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 132:
//#line 804 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 133:
//#line 811 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval = val_peek(0);
    }
break;
case 134:
//#line 818 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 135:
//#line 822 "gramatica.y"
{   Token t = TablaSimbolos.getToken(val_peek(1).sval);
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            yyval.obj = new NodoComun("Outf", new NodoHoja(val_peek(1).sval, t));
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 136:
//#line 828 "gramatica.y"
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
case 137:
//#line 841 "gramatica.y"
{yyerror("Los print unicamente pueden contener expresiones o cadenas");}
break;
case 138:
//#line 842 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 2007 "Parser.java"
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
