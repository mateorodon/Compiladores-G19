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
    0,    0,    1,    1,    2,    2,    3,    3,    3,    4,
    4,    4,    4,    4,   13,   14,   14,   14,   14,    9,
    9,    5,    5,    5,   18,   18,    6,    6,    7,   19,
   20,   20,   20,   17,   17,   17,   21,   21,   21,   22,
   22,   22,   22,    8,    8,   10,   10,   11,   11,   15,
   15,   23,   23,   24,   24,   24,   24,   24,   24,   16,
   16,   25,   26,   26,   12,   12,
};
final static short yylen[] = {                            2,
    4,    3,    3,    2,    1,    1,    2,    1,    1,    1,
    1,    1,    1,    1,    5,    8,    8,   12,   12,    3,
    6,    1,    1,    1,    1,    1,    3,    1,    9,    2,
    1,    5,    4,    3,    3,    1,    3,    3,    1,    1,
    1,    1,    4,    0,    6,    4,    7,    9,    7,    2,
    3,    3,    2,    1,    1,    1,    1,    1,    1,    3,
    7,    3,    3,    1,    4,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    2,    0,    0,   22,   23,
    0,    0,    0,    5,    6,    0,    8,    9,   10,   11,
   12,   13,   14,    0,    0,    0,    0,    0,    0,    0,
    1,    0,    4,   28,    0,    0,    0,   41,   42,    0,
    0,   39,   25,   26,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    3,    0,    0,    0,    0,
    0,    0,    0,   46,    0,    0,    0,    0,    0,    0,
   54,   55,   56,   59,   58,   57,    0,   65,   66,    0,
    0,    0,    0,   27,    0,    0,    0,   37,   38,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   15,   24,    0,    0,   43,    0,    0,    0,    0,    0,
   45,    0,    0,    0,   50,   30,    0,   47,    0,    0,
   49,    0,   53,   51,    0,    0,    0,    0,    0,   52,
    0,    0,    0,   61,   48,    0,    0,    0,    0,   29,
    0,    0,    0,    0,    0,    0,   33,    0,    0,    0,
   32,    0,    0,   18,   19,
};
final static short yydgoto[] = {                          2,
   12,   13,   14,   15,   16,   36,   17,   18,   19,   39,
   21,   22,   23,   55,  101,   49,   50,   46,  104,  133,
   41,   42,  114,   77,   68,   69,
};
final static short yysindex[] = {                      -253,
 -246,    0, -181,  -39,  -13,    0,    3, -230,    0,    0,
   35, -161,   45,    0,    0, -173,    0,    0,    0,    0,
    0,    0,    0, -184, -136, -154,  -40, -120,   60, -135,
    0,   81,    0,    0, -100,  119,  -24,    0,    0,    6,
   59,    0,    0,    0,   57,  126,   76, -184,  139,   -1,
  146,  115, -139,  -69,  152,    0,  154,  -62,  -66, -184,
 -184, -184, -184,    0, -184,  -61,    6,  157,  155,  -65,
    0,    0,    0,    0,    0,    0, -184,    0,    0,  141,
  -60, -185, -194,    0,  108,   59,   59,    0,    0,  134,
 -184,  -15, -184, -185,    6,  -53,  147,  -39, -102,  148,
    0,    0,  -52,  167,    0,  168,    6,  170,    6, -192,
    0,  -40,  153, -103,    0,    0,  -54,    0, -184, -185,
    0,  156,    0,    0,  159, -146,  173,  -49, -133,    0,
  176, -123,  -47,    0,    0,  -35,  -30, -184,  186,    0,
  172,  177,  140, -184,  197,  198,    0,  145,  -40,  -40,
    0,  199,  200,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,  180, -160,    0,    0,    0,    0,    0,    0,
    0,  180,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  183,  -36,    0,    0,  184,
  -31,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  203,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -26,   -4,    0,    0,    0,
    0,    0,    0,    0,  -21,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  189,    0,   75,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  180,    0,    0,    0,    0,
    0,  -57,    0,    0,    0,    0,    0,    0,    0,    0,
  208,  209,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  125,   -9,    0,  -28,  169,    0,    0,    0,    0,   50,
    0,    0,    0,    0,  -72,  -80,   40,  201,    0,    0,
  111,  129,    0,  161,  142,    0,
};
final static int YYTABLESIZE=261;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         48,
   25,   44,   32,    1,   40,   40,   40,   40,   40,   36,
   40,   36,   36,   36,   34,   25,   34,   34,   34,   60,
    3,  110,   40,   40,   40,   40,   27,   36,   36,   36,
   36,  122,   34,   34,   34,   34,   35,   60,   35,   35,
   35,   60,   28,   61,   74,   76,   75,  128,   60,   29,
   61,   26,   20,  100,   35,   35,   35,   35,   74,   76,
   75,   20,  102,   40,   45,  100,   59,   52,  152,  153,
  113,   98,   37,  120,   30,    4,  121,   38,    5,    9,
   10,   99,    5,   34,    7,  125,    6,   67,    7,    8,
   11,  100,    9,   10,   11,    4,   24,   64,   35,   60,
   62,   61,    5,   33,   90,   63,   31,   47,    7,    8,
    4,   24,    9,   10,   11,   62,   95,    5,   63,   53,
   37,   54,   32,    7,    8,   38,  131,    9,   10,   11,
  107,   20,  109,    4,   43,   44,   37,   43,   44,   56,
    5,   38,   51,   20,  136,  137,    7,    8,   20,  139,
    9,   10,   11,   98,   98,   79,   57,   60,   67,   61,
    5,    5,   58,   20,  124,   65,    7,    7,   66,   20,
   86,   87,   11,   11,  106,   20,   60,  143,   61,   70,
  147,   20,   60,  148,   61,  151,   78,   60,   81,   61,
   88,   89,   82,   83,   84,   85,   91,   92,   93,   94,
  105,   97,   96,  111,  116,  112,  115,  117,  118,  119,
   31,  123,  126,  134,  129,  138,   37,  130,   24,  135,
  140,   38,   40,   40,   40,  144,  141,   36,   36,   36,
  145,  142,   34,   34,   34,  146,  149,  150,   44,  154,
  155,    7,   20,   71,   72,   73,   64,   21,   16,   17,
  132,  103,  108,   80,   35,   35,   35,   71,   72,   73,
  127,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         40,
   40,   59,   12,  257,   41,   42,   43,   44,   45,   41,
   47,   43,   44,   45,   41,   40,   43,   44,   45,   41,
  267,   94,   59,   60,   61,   62,   40,   59,   60,   61,
   62,  112,   59,   60,   61,   62,   41,   59,   43,   44,
   45,   43,   40,   45,   60,   61,   62,  120,   43,  280,
   45,   91,    3,   82,   59,   60,   61,   62,   60,   61,
   62,   12,  257,   24,   25,   94,   91,   28,  149,  150,
   99,  257,  257,  266,   40,  257,  269,  262,  264,  274,
  275,  267,  264,  257,  270,  114,  268,   48,  270,  271,
  276,  120,  274,  275,  276,  257,  257,   41,  272,   43,
   42,   45,  264,   59,   65,   47,  268,  262,  270,  271,
  257,  272,  274,  275,  276,   41,   77,  264,   44,   60,
  257,  257,  132,  270,  271,  262,  273,  274,  275,  276,
   91,   82,   93,  257,  274,  275,  257,  274,  275,   59,
  264,  262,  263,   94,  278,  279,  270,  271,   99,  273,
  274,  275,  276,  257,  257,   41,  257,   43,  119,   45,
  264,  264,   44,  114,  268,   40,  270,  270,   93,  120,
   60,   61,  276,  276,   41,  126,   43,  138,   45,   41,
   41,  132,   43,  144,   45,   41,   41,   43,  258,   45,
   62,   63,   41,   40,  257,  262,  258,   41,   44,  265,
   93,  262,   62,  257,  257,   59,   59,   41,   41,   40,
  268,   59,  267,   41,   59,   40,  257,   59,  258,  269,
  268,  262,  259,  260,  261,   40,  262,  259,  260,  261,
   59,  262,  259,  260,  261,   59,   40,   40,   59,   41,
   41,   59,   59,  259,  260,  261,   44,   59,   41,   41,
  126,   83,   92,   53,  259,  260,  261,  259,  260,  261,
  119,
};
}
final static short YYFINAL=2;
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
"programa : ID BEGIN END",
"list_sentencias : list_sentencias sentencia ';'",
"list_sentencias : sentencia ';'",
"sentencia : sentencia_declarativa",
"sentencia : sentencia_ejecutable",
"sentencia_declarativa : tipo list_variables",
"sentencia_declarativa : declaracion_funcion",
"sentencia_declarativa : declaracion_tipo",
"sentencia_ejecutable : asignacion",
"sentencia_ejecutable : invocacion_funcion",
"sentencia_ejecutable : bloque_if",
"sentencia_ejecutable : salida_mensaje",
"sentencia_ejecutable : sentencia_control",
"sentencia_control : FOR '(' encabezado_for ')' bloque_sentencias_ejecutables",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE ';' '(' condicion ')'",
"asignacion : ID ASIGNACION expresion",
"asignacion : ID '[' CONSTANTE ']' ASIGNACION expresion",
"tipo : ULONGINT",
"tipo : SINGLE",
"tipo : ID",
"tipo_base : ULONGINT",
"tipo_base : SINGLE",
"list_variables : list_variables ',' ID",
"list_variables : ID",
"declaracion_funcion : tipo FUN ID '(' parametro ')' BEGIN cuerpo_funcion END",
"parametro : tipo ID",
"cuerpo_funcion : list_sentencias",
"cuerpo_funcion : list_sentencias RET '(' expresion ')'",
"cuerpo_funcion : RET '(' expresion ')'",
"expresion : expresion '+' termino",
"expresion : expresion '-' termino",
"expresion : termino",
"termino : termino '*' factor",
"termino : termino '/' factor",
"termino : factor",
"factor : ID",
"factor : CONSTANTE",
"factor : invocacion_funcion",
"factor : ID '[' CONSTANTE ']'",
"declaracion_tipo :",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base '>' ID",
"invocacion_funcion : ID '(' expresion ')'",
"invocacion_funcion : ID '(' tipo_base '(' expresion ')' ')'",
"bloque_if : IF '(' condicion ')' THEN bloque_sentencias_ejecutables ELSE bloque_sentencias_ejecutables END_IF",
"bloque_if : IF '(' condicion ')' THEN bloque_sentencias_ejecutables END_IF",
"bloque_sentencias_ejecutables : sentencia_ejecutable ';'",
"bloque_sentencias_ejecutables : BEGIN list_sentencias_ejecutables END",
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
"bloque_list_expresiones : list_expresiones ',' expresion",
"list_expresiones : list_expresiones ',' expresion",
"list_expresiones : expresion",
"salida_mensaje : OUTF '(' CADENA ')'",
"salida_mensaje : OUTF '(' expresion ')'",
};

//#line 166 "gramatica.y"
public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
      this.yylval = new ParserVal(t.getLexema());
      return (int) t.getId();
    }
    return 0;
}

public static void yyerror(String error){
    System.out.println(error);
}
//#line 371 "Parser.java"
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
{yyerror("Programa sin cuerpo");}
break;
case 7:
//#line 26 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
break;
case 8:
//#line 27 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 9:
//#line 28 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 16:
//#line 49 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 17:
//#line 50 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 18:
//#line 51 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 19:
//#line 52 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 20:
//#line 56 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 21:
//#line 57 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion ");}
break;
case 42:
//#line 105 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 45:
//#line 110 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 47:
//#line 115 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 48:
//#line 120 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 49:
//#line 121 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 65:
//#line 161 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 66:
//#line 162 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
//#line 592 "Parser.java"
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
