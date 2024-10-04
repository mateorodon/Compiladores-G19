package compi.g19.b.AnalisisSintactico;//### This file created by BYACC 1.8(/Java extension  1.15)
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
import java.io.*;
import compi.g19.a.AnalisisLexico.*;
//#line 20 "Parser.java"




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
    1,    1,    1,    1,    6,    8,    8,   12,   12,    3,
    6,    1,    1,    1,    1,    1,    3,    1,    9,    2,
    1,    5,    4,    3,    3,    1,    3,    3,    1,    1,
    1,    1,    4,    0,    6,    4,    7,    9,    7,    2,
    3,    3,    2,    1,    1,    1,    1,    1,    1,    3,
    7,    3,    3,    1,    6,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    2,    0,    0,   22,   23,
    0,    0,    0,    5,    6,    0,    8,    9,   10,   11,
   12,   13,   14,    0,    0,    0,    0,    0,    0,    0,
    1,    0,    4,   28,    0,    0,    0,   41,   42,    0,
    0,   39,   25,   26,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    3,    0,    0,    0,    0,
    0,    0,    0,   46,    0,    0,    0,    0,    0,    0,
   54,   55,   56,   59,   58,   57,    0,    0,   66,    0,
    0,    0,    0,   27,    0,    0,    0,   37,   38,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   24,    0,    0,   43,    0,    0,    0,    0,
    0,   65,   45,    0,    0,    0,   50,   15,   30,    0,
   47,    0,    0,   49,    0,   53,   51,    0,    0,    0,
    0,    0,   52,    0,    0,    0,   61,   48,    0,    0,
    0,    0,   29,    0,    0,    0,    0,    0,    0,   33,
    0,    0,    0,   32,    0,    0,   18,   19,
};
final static short yydgoto[] = {                          2,
   12,   13,   14,   15,   16,   36,   17,   18,   19,   39,
   21,   22,   23,   55,  102,   49,   50,   46,  105,  136,
   41,   42,  116,   77,   68,   69,
};
final static short yysindex[] = {                      -236,
 -229,    0, -191,  -39,   38,    0,   71, -157,    0,    0,
   85, -175,   75,    0,    0, -181,    0,    0,    0,    0,
    0,    0,    0, -235, -188, -132,  -40, -120,   88, -114,
    0,   95,    0,    0,  -90,  140,  -24,    0,    0,   49,
    1,    0,    0,    0,   69,  131,   93, -235,  149,   -1,
  -72,   83, -224,  -66,  152,    0,  154,  -62,  -65, -235,
 -235, -235, -235,    0, -235,  -60,   49,  155,  156,  -64,
    0,    0,    0,    0,    0,    0, -235,   74,    0,  141,
  -58, -112, -167,    0,  109,    1,    1,    0,    0,  106,
 -235,  -15, -235, -112,   49,  164,  -51,  148,  -39, -101,
  150,  151,    0,  -49,  171,    0,  172,   49,  174,   49,
 -163,    0,    0,  -40,  157, -111,    0,    0,    0,  -52,
    0, -235, -112,    0,  159,    0,    0,  161, -155,  180,
  -43, -118,    0,  187, -135,  -37,    0,    0,  -30,  -25,
 -235,  196,    0,  179,  181,  127, -235,  199,  201,    0,
  133,  -40,  -40,    0,  202,  206,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,  183, -159,    0,    0,    0,    0,    0,    0,
    0,  183,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  189,  -36,    0,    0,  190,
  -31,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  207,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -26,   -4,    0,    0,    0,
    0,    0,    0,    0,   13,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  191,    0,  136,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  183,    0,
    0,    0,    0,    0,  -57,    0,    0,    0,    0,    0,
    0,    0,    0,  211,  212,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  125,   -8,    0,  -19,  178,    0,    0,    0,    0,   50,
    0,    0,    0,    0,  -74,  -82,   40,  209,    0,    0,
  122,  126,    0,  173,  142,    0,
};
final static int YYTABLESIZE=265;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         48,
   25,   44,   51,   32,   40,   40,   40,   40,   40,   36,
   40,   36,   36,   36,   34,   25,   34,   34,   34,  111,
    1,   37,   40,   40,   40,   40,   38,   36,   36,   36,
   36,  125,   34,   34,   34,   34,   35,    3,   35,   35,
   35,   60,   62,   61,   74,   76,   75,   63,  131,   43,
   44,   26,   20,   60,   35,   35,   35,   35,   74,   76,
   75,   20,  101,   40,   45,    4,   59,   52,   37,  155,
  156,   60,    5,   38,  101,   34,    6,   27,    7,    8,
  115,    4,    9,   10,   11,   43,   44,   67,    5,  103,
   35,   60,   31,   61,    7,    8,  128,   24,    9,   10,
   11,    4,  123,  101,   90,  124,    9,   10,    5,   64,
   28,   60,   24,   61,    7,    8,   95,  134,    9,   10,
   11,    4,   29,   79,   30,   60,   32,   61,    5,   47,
  108,   20,  110,   33,    7,    8,   37,  142,    9,   10,
   11,   38,   54,   20,   99,   99,  107,   53,   60,   20,
   61,    5,    5,   56,  100,   99,  127,    7,    7,  139,
  140,   67,    5,   11,   11,   20,   57,  150,    7,   60,
   65,   61,   20,  154,   11,   60,   62,   61,   20,   63,
  146,   86,   87,   58,   20,   66,  151,   88,   89,   70,
   78,   81,   82,   83,   84,   92,   85,   91,   96,   93,
   94,  106,   97,   98,  112,  113,  114,  119,  117,  118,
   31,  120,  121,  122,  129,  126,   37,  132,   24,  133,
  137,   38,   40,   40,   40,  138,  141,   36,   36,   36,
  143,  144,   34,   34,   34,  147,  145,  148,  152,  149,
  153,   44,  157,   71,   72,   73,  158,    7,   20,   21,
   64,   16,   17,  135,   35,   35,   35,   71,   72,   73,
  104,   80,    0,  130,  109,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         40,
   40,   59,  123,   12,   41,   42,   43,   44,   45,   41,
   47,   43,   44,   45,   41,   40,   43,   44,   45,   94,
  257,  257,   59,   60,   61,   62,  262,   59,   60,   61,
   62,  114,   59,   60,   61,   62,   41,  267,   43,   44,
   45,   43,   42,   45,   60,   61,   62,   47,  123,  274,
  275,   91,    3,   41,   59,   60,   61,   62,   60,   61,
   62,   12,   82,   24,   25,  257,   91,   28,  257,  152,
  153,   59,  264,  262,   94,  257,  268,   40,  270,  271,
  100,  257,  274,  275,  276,  274,  275,   48,  264,  257,
  272,   43,  268,   45,  270,  271,  116,  257,  274,  275,
  276,  257,  266,  123,   65,  269,  274,  275,  264,   41,
   40,   43,  272,   45,  270,  271,   77,  273,  274,  275,
  276,  257,  280,   41,   40,   43,  135,   45,  264,  262,
   91,   82,   93,   59,  270,  271,  257,  273,  274,  275,
  276,  262,  257,   94,  257,  257,   41,   60,   43,  100,
   45,  264,  264,   59,  267,  257,  268,  270,  270,  278,
  279,  122,  264,  276,  276,  116,  257,   41,  270,   43,
   40,   45,  123,   41,  276,   43,   41,   45,  129,   44,
  141,   60,   61,   44,  135,   93,  147,   62,   63,   41,
  263,  258,   41,   40,  257,   41,  262,  258,  125,   44,
  265,   93,   62,  262,   41,  257,   59,  257,   59,   59,
  268,   41,   41,   40,  267,   59,  257,   59,  258,   59,
   41,  262,  259,  260,  261,  269,   40,  259,  260,  261,
  268,  262,  259,  260,  261,   40,  262,   59,   40,   59,
   40,   59,   41,  259,  260,  261,   41,   59,   59,   59,
   44,   41,   41,  129,  259,  260,  261,  259,  260,  261,
   83,   53,   -1,  122,   92,
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
null,"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,"ID","ASIGNACION","MAYORIGUAL",
"MENORIGUAL","DISTINTO","CONSTANTE","CADENA","IF","THEN","ELSE","BEGIN","END",
"END_IF","OUTF","TYPEDEF","FUN","RET","ULONGINT","SINGLE","FOR","OR","UP",
"DOWN","TRIPLE",
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
"sentencia_control : FOR '(' encabezado_for ')' bloque_sentencias_ejecutables ';'",
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
"salida_mensaje : OUTF '(' '{' CADENA '}' ')'",
"salida_mensaje : OUTF '(' expresion ')'",
};

//#line 165 "gramatica.y"
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
//#line 368 "Parser.java"
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
//#line 10 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa");}
break;
case 2:
//#line 11 "gramatica.y"
{yyerror("Programa sin cuerpo");}
break;
case 7:
//#line 25 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
break;
case 8:
//#line 26 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 9:
//#line 27 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
//#line 40 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 20:
//#line 55 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 21:
//#line 56 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion ");}
break;
case 42:
//#line 104 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 46:
//#line 113 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 47:
//#line 114 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 48:
//#line 119 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 49:
//#line 120 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 65:
//#line 160 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 66:
//#line 161 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
//#line 577 "Parser.java"
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
