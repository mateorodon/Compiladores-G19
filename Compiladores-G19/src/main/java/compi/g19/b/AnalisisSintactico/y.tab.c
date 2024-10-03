#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
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
    0,    1,    1,    2,    2,    3,    3,    3,    4,    4,
    4,    4,    4,   13,   13,   14,   14,   14,   14,    9,
    9,    5,    5,    5,    6,    6,    7,   18,   19,   19,
   19,   17,   17,   17,   20,   20,   20,   21,   21,   21,
   21,    8,    8,   10,   10,   11,   11,   22,   22,   15,
   15,   23,   23,   23,   23,   23,   23,   16,   16,   24,
   25,   25,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    2,    1,    1,    2,    1,    1,    1,    1,
    1,    1,    1,    6,    7,    8,    8,   12,   12,    3,
    6,    1,    1,    1,    3,    1,    9,    2,    1,    5,
    4,    3,    3,    1,    3,    3,    1,    1,    1,    1,
    4,    0,    6,    4,    5,    9,    7,    2,    3,    3,
    2,    1,    1,    1,    1,    1,    1,    3,    7,    3,
    3,    1,    6,    4,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,   22,   23,    0,
    0,    0,    4,    5,    0,    7,    8,    9,   10,   11,
   12,   13,    0,    0,    0,    0,    0,    0,    0,    1,
    0,    3,   26,    0,    0,    0,   39,   40,    0,    0,
   37,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    2,    0,    0,    0,    0,    0,    0,
    0,    0,   44,    0,    0,    0,    0,    0,   52,   53,
   54,   57,   56,   55,    0,    0,   64,   24,    0,    0,
    0,    0,   25,    0,    0,    0,   35,   36,   45,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   41,    0,    0,    0,    0,    0,    0,   63,
   43,    0,    0,    0,   14,   28,    0,    0,    0,   48,
    0,   47,    0,   51,   15,    0,    0,    0,   49,    0,
    0,   50,    0,    0,    0,   59,   46,    0,    0,    0,
    0,   27,    0,    0,    0,    0,    0,    0,   31,    0,
    0,    0,   30,    0,    0,   18,   19,
};
short yydgoto[] = {                                       2,
   11,   12,   13,   14,   15,   35,   16,   17,   18,   38,
   20,   21,   22,   53,  114,   47,   48,  102,  135,   40,
   41,  109,   75,   66,   67,
};
short yysindex[] = {                                   -232,
 -219,    0, -103,  -33,   72,   80, -157,    0,    0,   95,
 -161,   81,    0,    0, -216,    0,    0,    0,    0,    0,
    0,    0, -226, -158, -120,  -40, -118,   97,  -98,    0,
  103,    0,    0,  -79,  136,  -16,    0,    0,   12,   84,
    0,  -16, -226,   57,   96, -226,  158,    4,  -62,  115,
 -203,  -52,  167,    0,  171,  -45,  -49, -226, -226, -226,
 -226,  153,    0,  -44,   12,  174,  172,  -46,    0,    0,
    0,    0,    0,    0, -226,   99,    0,    0,  168,  -42,
 -179, -203,    0,  128,   84,   84,    0,    0,    0, -226,
  -10, -226,  -88,   12,  185,  -26,  176,  -33, -183,  177,
  -17,  200,    0,   12,  202,   12, -183,  184, -190,    0,
    0,  -40,  186,  -83,    0,    0,  -23, -226,  -73,    0,
  -88,    0,  187,    0,    0,  188, -146,  207,    0,  -15,
 -133,    0,  212, -123,  -12,    0,    0,   -9,   -7, -226,
  217,    0,  199,  208,  159, -226,  219,  226,    0,  164,
  -40,  -40,    0,  227,  228,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,  211, -167,    0,    0,    0,    0,    0,    0,
  211,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  213,  -32,    0,    0,  214,  -27,
    0,  -39,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  230,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -22,    1,    0,    0,    0,    0,
    0,    0,    0,   36,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  216,    0,   78,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  211,    0,    0,    0,
    0,    0,    0,  -58,    0,    0,    0,    0,    0,    0,
    0,    0,  235,  236,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  144,    9,    0,  -13,    2,    0,    0,    0,    0,   56,
    0,    0,    0,    0,  173,  -69,   46,    0,    0,   74,
  105,  157,  190,  161,    0,
};
#define YYTABLESIZE 281
short yytable[] = {                                      46,
   42,   38,   38,   38,   49,   38,   24,   38,   38,   38,
   38,   38,   38,   34,   38,   34,   34,   34,   32,   31,
   32,   32,   32,   24,    1,   43,   38,   38,   38,   38,
   36,   34,   34,   34,   34,   37,   32,   32,   32,   32,
   33,   33,  123,   33,   33,   33,   58,    3,   59,   72,
   74,   73,   79,   78,   58,   34,   59,   25,   19,   33,
   33,   33,   33,   72,   74,   73,   19,  100,   39,   44,
    8,    9,   50,   98,   57,  121,   58,   98,  122,  108,
    5,  154,  155,  101,    5,  113,    6,   99,   62,   24,
    6,   65,   10,  113,   58,    4,   10,   63,   42,   58,
  126,   59,    5,   37,   24,  126,   30,  108,    6,    7,
    4,   26,    8,    9,   10,    8,    9,    5,   60,   27,
   94,   61,   28,    6,    7,   60,  133,    8,    9,   10,
   61,   85,   86,    4,   29,  104,   19,  106,   36,   32,
    5,   45,   31,   37,  138,  139,    6,    7,   19,  141,
    8,    9,   10,    4,   19,   77,   51,   58,   52,   59,
    5,   54,   19,   65,   87,   88,    6,    7,   98,   19,
    8,    9,   10,   98,   19,    5,   19,   55,  107,   56,
    5,    6,   19,   98,  125,  145,    6,   10,   64,   19,
    5,  150,   10,   89,  129,   58,    6,   59,   68,  149,
   76,   58,   10,   59,  153,   80,   58,   81,   59,   29,
   82,   83,   84,   90,   91,   92,   36,   24,   93,   97,
  103,   37,   24,   95,   23,  110,   38,   38,   38,   96,
  111,   34,   34,   34,  112,  115,   32,   32,   32,  116,
  117,  118,  120,  127,  124,  131,  132,  136,   69,   70,
   71,  140,  143,  137,  144,  142,  146,  147,  151,   33,
   33,   33,   69,   70,   71,  152,  148,  156,  157,   42,
  134,    6,   20,   62,   21,   16,   17,  130,  128,  119,
  105,
};
short yycheck[] = {                                      40,
   59,   41,   42,   43,  123,   45,   40,   47,   41,   42,
   43,   44,   45,   41,   47,   43,   44,   45,   41,   11,
   43,   44,   45,   40,  257,   24,   59,   60,   61,   62,
  257,   59,   60,   61,   62,  262,   59,   60,   61,   62,
  257,   41,  112,   43,   44,   45,   43,  267,   45,   60,
   61,   62,   51,  257,   43,  272,   45,   91,    3,   59,
   60,   61,   62,   60,   61,   62,   11,   81,   23,   24,
  274,  275,   27,  257,   91,  266,   41,  257,  269,   93,
  264,  151,  152,   82,  264,   99,  270,  267,   43,  257,
  270,   46,  276,  107,   59,  257,  276,   41,  257,   43,
  114,   45,  264,  262,  272,  119,  268,  121,  270,  271,
  257,   40,  274,  275,  276,  274,  275,  264,   41,   40,
   75,   44,  280,  270,  271,   42,  273,  274,  275,  276,
   47,   58,   59,  257,   40,   90,   81,   92,  257,   59,
  264,  262,  134,  262,  278,  279,  270,  271,   93,  273,
  274,  275,  276,  257,   99,   41,   60,   43,  257,   45,
  264,   59,  107,  118,   60,   61,  270,  271,  257,  114,
  274,  275,  276,  257,  119,  264,  121,  257,  267,   44,
  264,  270,  127,  257,  268,  140,  270,  276,   93,  134,
  264,  146,  276,   41,  268,   43,  270,   45,   41,   41,
  263,   43,  276,   45,   41,  258,   43,   41,   45,  268,
   40,  257,  262,  258,   41,   44,  257,  257,  265,  262,
   93,  262,  262,  125,  258,   41,  259,  260,  261,   62,
  257,  259,  260,  261,   59,   59,  259,  260,  261,  257,
   41,   40,   59,  267,   59,   59,   59,   41,  259,  260,
  261,   40,  262,  269,  262,  268,   40,   59,   40,  259,
  260,  261,  259,  260,  261,   40,   59,   41,   41,   59,
  127,   59,   59,   44,   59,   41,   41,  121,  118,  107,
   91,
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
"sentencia_control : FOR '(' encabezado_for ')' sentencia_ejecutable ';'",
"sentencia_control : FOR '(' encabezado_for ')' BEGIN list_sentencias_ejecutables END",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE ';' '(' condicion ')'",
"asignacion : ID ASIGNACION expresion",
"asignacion : ID '[' CONSTANTE ']' ASIGNACION expresion",
"tipo : ULONGINT",
"tipo : SINGLE",
"tipo : ID",
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
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo '>' ID",
"invocacion_funcion : ID '(' expresion ')'",
"invocacion_funcion : ID '(' tipo expresion ')'",
"bloque_if : IF '(' condicion ')' THEN bloque_sentencias ELSE bloque_sentencias END_IF",
"bloque_if : IF '(' condicion ')' THEN bloque_sentencias END_IF",
"bloque_sentencias : sentencia_ejecutable ';'",
"bloque_sentencias : BEGIN list_sentencias_ejecutables END",
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
#line 157 "gramatica.y"

// código C asociado
#line 294 "y.tab.c"
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
#line 6 "gramatica.y"
{AnalisisLexico.agregarEstructura("Se reconocio el programa");}
break;
case 20:
#line 51 "gramatica.y"
{AnalisisLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 21:
#line 52 "gramatica.y"
{AnalisisLexico.agregarEstructura("Se reconocio una asignacion ");}
break;
case 27:
#line 68 "gramatica.y"
{AnalisisLexico.agregarEstructura("Se reconocio una declaracion de funcion");}
break;
case 44:
#line 105 "gramatica.y"
{AnalisisLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 45:
#line 106 "gramatica.y"
{AnalisisLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
#line 458 "y.tab.c"
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
