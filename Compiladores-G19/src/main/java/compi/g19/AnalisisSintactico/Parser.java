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
   38,   38,   38,   38,   35,   35,   39,   39,   39,   39,
   39,   39,   19,   40,   41,   42,   43,   19,   19,   33,
   44,   44,   44,   12,   12,   12,
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
    3,    4,    2,    2,    3,    2,    1,    1,    1,    1,
    1,    1,    3,    0,    0,    0,    0,   11,    1,    3,
    3,    1,    1,    4,    4,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,   99,    0,    0,    0,   44,   45,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   42,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    0,
    4,    6,    8,    9,   48,    0,    0,    0,    0,    2,
   41,    0,   78,    0,   79,    0,    0,   74,  133,   92,
    0,    0,    0,    0,    0,    1,    0,  136,    0,    0,
    0,    0,    0,    0,    0,  129,    0,  124,    0,    0,
   49,   47,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   82,    0,    0,    0,    0,   90,    0,   91,
    0,    0,  134,  135,    0,   88,    0,    0,   36,    0,
    0,    0,    0,   23,   22,    0,    0,    0,  117,  118,
  119,  122,  121,  120,    0,   46,    0,   55,    0,    0,
    0,    0,    0,    0,   70,    0,   71,    0,   75,   72,
   76,   73,    0,    0,    0,   87,    0,   86,   89,   98,
    0,    0,   21,   20,   96,   37,   38,    0,    0,    0,
  125,    0,    0,    0,   65,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   80,    0,    0,    0,   85,
   84,  116,   97,    0,    0,    0,    0,    0,    0,    0,
   54,   64,    0,   62,   51,    0,    0,    0,    0,    0,
  113,    0,  114,    0,   83,   93,  115,    0,    0,    0,
    0,    0,    0,    0,   60,    0,   53,    0,  110,   95,
    0,   94,  100,    0,    0,  101,    0,  111,    0,    0,
    0,    0,    0,    0,    0,    0,   66,   52,    0,    0,
    0,    0,  109,  107,  112,  106,    0,    0,   35,    0,
  126,    0,  102,  104,  105,  103,   32,    0,   34,    0,
   33,   31,  127,    0,  128,
};
final static short yydgoto[] = {                          3,
   12,   13,   14,   15,   16,   47,   17,   18,   19,   20,
   21,   22,   23,   37,  114,   38,   39,   40,   79,  159,
   80,   24,   25,   87,  166,  216,   88,   89,  167,  198,
   57,   58,   63,  223,  174,   26,  199,  175,  125,  117,
  188,  260,  264,   64,
};
final static short yysindex[] = {                      -216,
  303,  384,    0,  -32,    0,  384,  -19,   13,    0,    0,
  -15,  234,    0,  -31,   37, -170,    0,    0,    0,    0,
    0,    0,    0,    0,   79,   95,  345,   34,  103, -122,
  354,  -38,   61, -222, -148, -110,  126,    0,    0,   -9,
    0,    0,    0,    0,    0,  -60,  -42,   -7,   -5,    0,
    0,  -14,    0, -140,    0,  118,   81,    0,    0,    0,
  117,  166,  167,  169,  124,    0,  182,    0,  356, -222,
  -52,  192,   -6,  -37,  428,    0,   -5,    0,  200,  134,
    0,    0,    7,    0,    3,   16,  246,  248,  257,  271,
   54,  187,    0,  119,  162,  164,  237,    0,   75,    0,
   75,   66,    0,    0,  -43,    0,   62,   71,    0,  -32,
 -175,  256,  274,    0,    0,   35,  260,  -87,    0,    0,
    0,    0,    0,    0,   75,    0,  369,    0,   72,   80,
 -218,  400,  258,   96,    0,   81,    0,   81,    0,    0,
    0,    0,  359,  118,   75,    0,  -57,    0,    0,    0,
  315,  439,    0,    0,    0,    0,    0, -129,  100,  118,
    0,  120,  118,  339,    0,  115,  369,  326,  369,  369,
    0,  414, -152,  449,  122,    0,  313,  381,  118,    0,
    0,    0,    0,  366,  393,  -18,  395,  387,  397,   75,
    0,    0,  399,    0,    0,  172,  402,  407,  -86,  299,
    0,  429,    0,  -92,    0,    0,    0,  403,  408,   -5,
  431,  -49,  436,  396,    0,  216,    0,    0,    0,    0,
  414,    0,    0,  414,  426,    0, -239,    0,  218, -239,
   -5,  443,  446,   -5,  448,   -5,    0,    0, -239, -239,
 -239, -239,    0,    0,    0,    0,  455,   -5,    0,  456,
    0,  459,    0,    0,    0,    0,    0,  470,    0,  260,
    0,    0,    0,  473,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0, -116,    0,    0,    0,    0,    0,    0,
    0,  515,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  519,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  481,  204,    0,    0,    0,
    0,    1,    0,    0,    0,  116,   47,    0,    0,    0,
  484,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -12,    0,    0,  486,    0,    0,    0,
    0,   24,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  263,    0,    0,    0,
    0,    0,    0,    0,    0,   70,    0,   93,    0,    0,
    0,    0,    0,  101,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  484,
    0,    0,  -41,    0,    0,    0,  265,    0,  263,  263,
  149,    0,    0,    0,    0,    0,    0,    0,  139,    0,
    0,    0,    0,    0,  -36,  -35,  -21,    0,  141,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  225,    0,
    0,    0,    0,    0,    0,    0,    0,  331,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  159,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   97,  424,    0,  432,  -33,    0,    0,    0,    0,  441,
    0,    0,    0,  489,  -48,    0,    0,    0,  293, -109,
   26,    4,    0,  415,   33,    0,    0,    0,    0,   -1,
  215,  259, -103,  -54,  -95,    0, -124, -149,  322,    0,
    0,    0,    0,    0,
};
final static int YYTABLESIZE=725;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        123,
   77,   83,   68,  112,   27,   30,   54,   29,  162,  107,
  122,  124,  123,  161,   86,  152,  220,  123,  147,   29,
   32,  210,  200,   81,   36,   29,  115,   43,   56,  222,
   78,   56,   62,   85,   78,   54,   71,   72,   84,   54,
    1,   77,   77,   77,   77,   77,   69,   77,  186,   77,
    2,    9,   10,   56,   61,    9,   10,   69,   30,   77,
   77,   77,   77,  154,   81,   81,   81,   81,   81,   67,
   81,  240,   34,  105,  242,  227,   91,  202,   54,  230,
  150,  110,   81,   81,   81,   81,   45,   69,    5,   69,
   69,   69,   68,  158,    7,   44,  239,   86,   27,  241,
   11,   46,   31,  201,  110,   69,   69,   69,   69,   73,
   67,    5,   67,   67,   67,   39,   92,    7,   48,   54,
   70,   93,   96,   11,  143,  168,  144,   97,   67,   67,
   67,   67,  185,   68,   49,   68,   68,   68,   40,   65,
   43,  130,  160,   60,  131,  226,   35,   54,  156,  157,
  163,   68,   68,   68,   68,   43,  263,   98,  108,   94,
   94,   95,   95,   54,  110,  193,   75,  168,  168,  220,
  179,    5,  244,   11,   39,  246,   94,    7,   95,  221,
  164,   28,  222,   11,  253,  254,  255,  256,   10,   57,
  156,  157,   59,  122,  124,  123,   81,   40,  180,  181,
  229,  195,  196,   12,  106,   99,   54,  100,   54,  119,
  120,  121,  101,  146,   82,  214,  102,  108,   52,  110,
   27,   30,  103,   53,   67,   28,    5,   27,   30,  111,
   27,   30,    7,   27,   30,   29,  123,  123,   11,   27,
   30,   35,   29,  209,   43,   29,   76,   52,   29,   84,
   76,   52,   53,  108,   29,  109,   53,   77,  118,   77,
   77,   77,   12,  126,   77,   26,    9,   10,   77,  127,
   77,   77,  128,   77,   77,   77,   77,  134,   77,   77,
   81,   54,   81,   81,   81,  160,  129,   81,  130,   51,
   52,   81,   33,   81,   81,   53,   81,   81,   81,   81,
  131,   81,   81,   69,   54,   69,   69,   69,  136,  138,
   69,  132,  156,  157,   69,  133,   69,   69,  148,   69,
   69,   69,   69,  145,   69,   69,   67,  149,   67,   67,
   67,   52,  155,   67,    9,   10,   53,   67,  169,   67,
   67,   90,   67,   67,   67,   67,  170,   67,   67,   68,
  176,   68,   68,   68,  140,  142,   68,  177,   59,   52,
   68,  187,   68,   68,   53,   68,   68,   68,   68,  116,
   68,   68,   39,  182,  135,   52,    9,   10,  190,   39,
   53,  189,  191,   39,  194,   39,   39,  204,   39,   39,
   39,   39,  119,  120,  121,   40,  104,   28,   94,  178,
   95,   94,   40,   95,   28,  205,   40,   28,   40,   40,
   28,   40,   40,   40,   40,  108,   28,  137,   52,  139,
   52,  206,  108,   53,  207,   53,  108,  212,  108,  108,
   11,  108,  108,  108,  108,   42,  237,   11,   94,  217,
   95,   11,  231,   11,   11,   10,   11,   11,   11,   11,
   42,  208,   10,  211,   42,  213,   10,  215,   10,   10,
  218,   10,   10,   10,   10,  219,  232,   12,   55,   55,
  234,   12,   55,   12,   12,  236,   12,   12,   12,   12,
   55,   26,  248,  238,  243,  245,  249,  251,   26,   55,
    4,   26,  141,   52,   26,  257,  259,    5,   53,  261,
   26,   41,  233,    7,    8,  113,  113,    9,   10,   11,
  262,  153,  110,  265,    5,   59,   52,   55,    3,    5,
   50,   53,  111,  247,   74,    7,  250,  132,  252,   58,
   63,   11,   61,  235,   55,   55,   55,   55,    0,   55,
  258,   55,  151,  113,    0,  171,    0,    0,    0,    0,
  165,    0,    0,    0,  220,  110,    0,   55,    0,    4,
    0,    0,    5,  151,  224,   55,    5,  222,    7,    6,
    0,  164,    7,    8,   11,    0,    9,   10,   11,    0,
    0,    0,    0,  184,    0,   55,  109,  116,    0,    0,
  192,    0,  165,  165,  116,    0,  109,    0,  116,  109,
  116,    4,    0,  197,  151,  184,  116,    0,    5,    0,
    4,    0,   50,    0,    7,    8,    0,    5,    9,   10,
   11,   66,    0,    7,    8,    4,    0,    9,   10,   11,
   55,  225,    5,  184,    0,  225,    0,    0,    7,    8,
    4,  164,    9,   10,   11,    0,    0,    5,    0,    0,
   55,    0,  197,    7,    8,  197,  110,    9,   10,   11,
    0,    0,    0,    5,  172,    0,  173,    0,    0,    7,
  110,   55,    0,    0,   55,   11,   55,    5,    0,    0,
  173,    0,    0,    7,  110,  110,  164,    0,   55,   11,
    0,    5,    5,    0,  111,  110,  228,    7,    7,    0,
   55,  164,    5,   11,   11,  110,  183,    0,    7,    0,
    0,    0,    5,    0,   11,    0,  203,    0,    7,    0,
    0,    0,    0,    0,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   44,   41,   41,   41,   41,   45,   40,  118,   62,
   60,   61,   62,  117,   48,  111,  256,   59,   62,   41,
   40,   40,  172,    0,   40,   40,   75,   59,   41,  269,
   40,   44,   29,   41,   40,   45,   33,   34,  257,   45,
  257,   41,   42,   43,   44,   45,    0,   47,  158,   59,
  267,  274,  275,   28,   29,  274,  275,   32,   91,   59,
   60,   61,   62,  112,   41,   42,   43,   44,   45,    0,
   47,  221,   60,   70,  224,  200,   91,  173,   45,  204,
  256,  257,   59,   60,   61,   62,  257,   41,  264,   43,
   44,   45,    0,   59,  270,   59,  221,  131,    2,  224,
  276,  272,    6,  256,  257,   59,   60,   61,   62,  258,
   41,  264,   43,   44,   45,    0,  257,  270,   40,   45,
   60,  262,   42,  276,   99,  127,  101,   47,   59,   60,
   61,   62,  262,   41,   40,   43,   44,   45,    0,  262,
  257,   41,  117,   41,   44,  200,  257,   45,  278,  279,
  125,   59,   60,   61,   62,  272,  260,   41,    0,   43,
   43,   45,   45,   45,  257,  167,   41,  169,  170,  256,
  145,  264,  227,    0,   59,  230,   43,  270,   45,  266,
  273,   41,  269,  276,  239,  240,  241,  242,    0,   41,
  278,  279,   44,   60,   61,   62,  257,   59,  256,  257,
  202,  169,  170,    0,  257,   40,   45,   41,   45,  259,
  260,  261,   44,  257,  257,  190,   93,   59,  257,  257,
  257,  257,   41,  262,  263,  258,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  262,  257,  267,  256,  257,  270,  257,
  256,  257,  262,   62,  276,  262,  262,  257,   59,  259,
  260,  261,   59,  257,  264,   41,  274,  275,  268,  267,
  270,  271,  257,  273,  274,  275,  276,   91,  278,  279,
  257,   45,  259,  260,  261,  260,   41,  264,   41,  256,
  257,  268,  280,  270,  271,  262,  273,  274,  275,  276,
   44,  278,  279,  257,   45,  259,  260,  261,   94,   95,
  264,   41,  278,  279,  268,  262,  270,  271,  257,  273,
  274,  275,  276,  258,  278,  279,  257,  257,  259,  260,
  261,  257,   59,  264,  274,  275,  262,  268,  267,  270,
  271,   49,  273,  274,  275,  276,  267,  278,  279,  257,
   93,  259,  260,  261,   96,   97,  264,  262,  256,  257,
  268,  262,  270,  271,  262,  273,  274,  275,  276,   77,
  278,  279,  257,   59,  256,  257,  274,  275,   40,  264,
  262,  262,  268,  268,   59,  270,  271,  266,  273,  274,
  275,  276,  259,  260,  261,  257,   41,  257,   43,   41,
   45,   43,  264,   45,  264,   93,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  256,  257,  256,
  257,   41,  264,  262,   59,  262,  268,   41,  270,  271,
  257,  273,  274,  275,  276,   12,   41,  264,   43,  268,
   45,  268,   40,  270,  271,  257,  273,  274,  275,  276,
   27,   59,  264,   59,   31,   59,  268,   59,  270,  271,
   59,  273,  274,  275,  276,   59,   59,  264,   28,   29,
   40,  268,   32,  270,  271,   40,  273,  274,  275,  276,
   40,  257,   40,  268,   59,  268,   41,   40,  264,   49,
  257,  267,  256,  257,  270,   41,   41,  264,  262,   41,
  276,  268,  210,  270,  271,   74,   75,  274,  275,  276,
   41,  256,  257,   41,    0,  256,  257,   77,    0,  264,
   40,  262,  267,  231,   36,  270,  234,   44,  236,   44,
  268,  276,  268,  212,   94,   95,   96,   97,   -1,   99,
  248,  101,  111,  112,   -1,  131,   -1,   -1,   -1,   -1,
  127,   -1,   -1,   -1,  256,  257,   -1,  117,   -1,  257,
   -1,   -1,  264,  132,  266,  125,  264,  269,  270,  267,
   -1,  273,  270,  271,  276,   -1,  274,  275,  276,   -1,
   -1,   -1,   -1,  152,   -1,  145,  256,  257,   -1,   -1,
  167,   -1,  169,  170,  264,   -1,  266,   -1,  268,  269,
  270,  257,   -1,  172,  173,  174,  276,   -1,  264,   -1,
  257,   -1,  268,   -1,  270,  271,   -1,  264,  274,  275,
  276,  268,   -1,  270,  271,  257,   -1,  274,  275,  276,
  190,  200,  264,  202,   -1,  204,   -1,   -1,  270,  271,
  257,  273,  274,  275,  276,   -1,   -1,  264,   -1,   -1,
  210,   -1,  221,  270,  271,  224,  257,  274,  275,  276,
   -1,   -1,   -1,  264,  265,   -1,  267,   -1,   -1,  270,
  257,  231,   -1,   -1,  234,  276,  236,  264,   -1,   -1,
  267,   -1,   -1,  270,  257,  257,  273,   -1,  248,  276,
   -1,  264,  264,   -1,  267,  257,  268,  270,  270,   -1,
  260,  273,  264,  276,  276,  257,  268,   -1,  270,   -1,
   -1,   -1,  264,   -1,  276,   -1,  268,   -1,  270,   -1,
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
"salida_mensaje : OUTF '(' ')'",
};

//#line 813 "gramatica.y"
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
        Nodo param = funcion.getIzq(); // Parámetro formal de la función
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
                param.setNombre(copia.getNombre());
                NodoHoja nodoTipoReal = new NodoHoja(tipoReal, null);
                salida = new NodoComun(funcion, param, nodoTipoReal);
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
//#line 758 "Parser.java"
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
{AnalizadorLexico.agregarEstructura("Se reconocio el programa"); raiz = new NodoComun("PROGRAMA", (Nodo)val_peek(1).obj);}
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
//#line 192 "gramatica.y"
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
//#line 220 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 43:
//#line 225 "gramatica.y"
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
//#line 241 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 45:
//#line 242 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 46:
//#line 246 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 47:
//#line 247 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 48:
//#line 248 "gramatica.y"
{varDeclaradas.add(val_peek(0).sval);}
break;
case 49:
//#line 252 "gramatica.y"
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
//#line 281 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 51:
//#line 285 "gramatica.y"
{ if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         if (!((NodoComun)val_peek(0).obj).getNombre().equals("Cuerpo vacio")){
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
//#line 302 "gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 54:
//#line 303 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 55:
//#line 307 "gramatica.y"
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
//#line 324 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 60:
//#line 337 "gramatica.y"
{  yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);
                                                    hasReturn = true;}
break;
case 61:
//#line 339 "gramatica.y"
{yyval=val_peek(0);}
break;
case 62:
//#line 340 "gramatica.y"
{yyval=val_peek(1); hasReturn = true;}
break;
case 63:
//#line 341 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio"); yyval.obj = new NodoHoja("Cuerpo vacio");}
break;
case 64:
//#line 346 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(1).obj, (Nodo) val_peek(0).obj);}
break;
case 65:
//#line 347 "gramatica.y"
{yyval=val_peek(0);}
break;
case 66:
//#line 352 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           yyval.obj = new NodoComun("Return", (Nodo)val_peek(1).obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 67:
//#line 360 "gramatica.y"
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
//#line 372 "gramatica.y"
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
//#line 384 "gramatica.y"
{yyval = val_peek(0);}
break;
case 70:
//#line 385 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
//#line 386 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 72:
//#line 390 "gramatica.y"
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
//#line 402 "gramatica.y"
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
//#line 414 "gramatica.y"
{yyval = val_peek(0);}
break;
case 75:
//#line 415 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 76:
//#line 416 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 77:
//#line 420 "gramatica.y"
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
//#line 437 "gramatica.y"
{Token t = TablaSimbolos.getToken(val_peek(0).sval);
                t.setValor(val_peek(0).sval);
                t.setUso("constante");
                yyval.obj = new NodoHoja(val_peek(0).sval,t);
                }
break;
case 79:
//#line 442 "gramatica.y"
{yyval = val_peek(0); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 80:
//#line 443 "gramatica.y"
{    String ambitoVar = buscarAmbito(ambito,val_peek(3).sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + val_peek(3).sval + "' no fue declarada");
                                    yyval.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken(val_peek(3).sval + "@" + ambitoVar);
                                    String tipo = val_peek(3).sval;
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
//#line 468 "gramatica.y"
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
//#line 485 "gramatica.y"
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
//#line 499 "gramatica.y"
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
//#line 527 "gramatica.y"
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
//#line 550 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 86:
//#line 551 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 87:
//#line 552 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 88:
//#line 553 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 89:
//#line 554 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 90:
//#line 558 "gramatica.y"
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
//#line 583 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 92:
//#line 584 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 93:
//#line 585 "gramatica.y"
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
//#line 610 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 96:
//#line 614 "gramatica.y"
{yyval=val_peek(1);}
break;
case 97:
//#line 615 "gramatica.y"
{yyval=val_peek(1);}
break;
case 98:
//#line 616 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 99:
//#line 620 "gramatica.y"
{inIF=true; yyval=val_peek(0);}
break;
case 100:
//#line 624 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; Nodo cuerpo = new NodoComun("Cuerpo",(Nodo)val_peek(1).obj);
                                                                                                                                              yyval.obj = new NodoComun("If", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 101:
//#line 626 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)val_peek(1).obj);
                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)val_peek(4).obj, cuerpo);}
break;
case 102:
//#line 630 "gramatica.y"
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
//#line 640 "gramatica.y"
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
//#line 650 "gramatica.y"
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
//#line 661 "gramatica.y"
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
//#line 671 "gramatica.y"
{yyerror("Falta THEN en IF");}
break;
case 107:
//#line 672 "gramatica.y"
{yyerror("Falta ELSE en IF");}
break;
case 108:
//#line 673 "gramatica.y"
{yyerror("Falta END_IF en IF");}
break;
case 109:
//#line 678 "gramatica.y"
{yyval = val_peek(1);}
break;
case 110:
//#line 679 "gramatica.y"
{yyval = val_peek(1); cantReturns++;}
break;
case 111:
//#line 683 "gramatica.y"
{yyval = val_peek(1);}
break;
case 112:
//#line 684 "gramatica.y"
{yyval = val_peek(2); cantReturns++;}
break;
case 113:
//#line 685 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 114:
//#line 686 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 115:
//#line 691 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 116:
//#line 692 "gramatica.y"
{yyval = val_peek(1);}
break;
case 117:
//#line 697 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 118:
//#line 698 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 119:
//#line 699 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 120:
//#line 700 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 121:
//#line 701 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 122:
//#line 702 "gramatica.y"
{yyval.obj = new NodoHoja(val_peek(0).sval);}
break;
case 123:
//#line 706 "gramatica.y"
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
case 124:
//#line 720 "gramatica.y"
{inList1 = true;}
break;
case 125:
//#line 720 "gramatica.y"
{inList1 = false;}
break;
case 126:
//#line 720 "gramatica.y"
{inList2 = true;}
break;
case 127:
//#line 720 "gramatica.y"
{inList2 = false;}
break;
case 128:
//#line 721 "gramatica.y"
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
case 129:
//#line 758 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 130:
//#line 763 "gramatica.y"
{
    if (inList1)
            expresiones1.add((Nodo)val_peek(0).obj);
        if (inList2)
            expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 131:
//#line 773 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(0).obj);
    }
break;
case 132:
//#line 780 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)val_peek(0).obj);
    if (inList2)
        expresiones2.add((Nodo)val_peek(0).obj);
    yyval = val_peek(0);
    }
break;
case 133:
//#line 787 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 134:
//#line 791 "gramatica.y"
{   Token t = TablaSimbolos.getToken(val_peek(1).sval);
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            yyval.obj = new NodoComun("Outf", new NodoHoja(val_peek(1).sval, t));
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 135:
//#line 797 "gramatica.y"
{   Nodo exp = (Nodo)val_peek(1).obj;
                                 if (!exp.getNombre().contains("error")){
                                     Token t = new Token(exp.getToken());
                                     t.setUso("mensaje");
                                     t.setTipo(exp.getTipo());
                                     yyval.obj = new NodoComun("Outf", new NodoHoja(exp.getNombre(),t));
                                 }
                                 else {
                                    yyval.obj = new NodoComun("error");
                                 }
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }
break;
case 136:
//#line 809 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
//#line 1954 "Parser.java"
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
