#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
import java.io.*
import compi.g19.a.AnalisisLexico.*;
#line 9 "y.tab.c"
#define ID 257
#define ASIGNACION 258
#define MAYORIGUAL 259
#define MENORIGUAL 260
#define DISTINTO 261
#define CONSTANTE 262
#define CADENA 263
#define IF 264
#define THEN 265
#define ELSE 266
#define BEGIN 267
#define END 268
#define END_IF 269
#define OUTF 270
#define TYPEDEF 271
#define FUN 272
#define RET 273
#define ULONGINT 274
#define SINGLE 275
#define FOR 276
#define OR 277
#define UP 278
#define DOWN 279
#define TRIPLE 280
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    1,    1,    2,    2,    3,    3,    3,    4,
    4,    4,    4,    4,   13,   14,   14,   14,   14,    9,
    9,    5,    5,    5,   18,   18,    6,    6,    7,   19,
   20,   20,   20,   17,   17,   17,   21,   21,   21,   22,
   22,   22,   22,    8,    8,   10,   10,   11,   11,   15,
   15,   23,   23,   24,   24,   24,   24,   24,   24,   16,
   16,   25,   26,   26,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    3,    2,    1,    1,    2,    1,    1,    1,
    1,    1,    1,    1,    6,    8,    8,   12,   12,    3,
    6,    1,    1,    1,    1,    1,    3,    1,    9,    2,
    1,    5,    4,    3,    3,    1,    3,    3,    1,    1,
    1,    1,    4,    0,    6,    4,    7,    9,    7,    2,
    3,    3,    2,    1,    1,    1,    1,    1,    1,    3,
    7,    3,    3,    1,    6,    4,
};
short yydefred[] = {                                      0,
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
short yydgoto[] = {                                       2,
   12,   13,   14,   15,   16,   36,   17,   18,   19,   39,
   21,   22,   23,   55,  102,   49,   50,   46,  105,  136,
   41,   42,  116,   77,   68,   69,
};
short yysindex[] = {                                   -236,
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
short yyrindex[] = {                                      0,
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
short yygindex[] = {                                      0,
  125,   -8,    0,  -19,  178,    0,    0,    0,    0,   50,
    0,    0,    0,    0,  -74,  -82,   40,  209,    0,    0,
  122,  126,    0,  173,  142,    0,
};
#define YYTABLESIZE 265
short yytable[] = {                                      48,
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
short yycheck[] = {                                      40,
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
#define YYFINAL 2
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 280
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,0,
"';'","'<'","'='","'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
"'['",0,"']'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"'{'",0,
"'}'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,"ID","ASIGNACION","MAYORIGUAL","MENORIGUAL",
"DISTINTO","CONSTANTE","CADENA","IF","THEN","ELSE","BEGIN","END","END_IF",
"OUTF","TYPEDEF","FUN","RET","ULONGINT","SINGLE","FOR","OR","UP","DOWN",
"TRIPLE",
};
char *yyrule[] = {
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
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 165 "gramatica.y"
public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    assert t != null;
    this.yylval = new ParserVal(t.getLexema());
    return (int) t.getId();
  }

public static void yyerror(String error){
    System.out.println(error);
}
#line 304 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 1:
#line 10 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa");}
break;
case 2:
#line 11 "gramatica.y"
{yyerror("Programa sin cuerpo");}
break;
case 7:
#line 25 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
break;
case 8:
#line 26 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 9:
#line 27 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
#line 40 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 20:
#line 55 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 21:
#line 56 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion ");}
break;
case 42:
#line 104 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 46:
#line 113 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 47:
#line 114 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 48:
#line 119 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 49:
#line 120 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 65:
#line 160 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 66:
#line 161 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
#line 504 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
