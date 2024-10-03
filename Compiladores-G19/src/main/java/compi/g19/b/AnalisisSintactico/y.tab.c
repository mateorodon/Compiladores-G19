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
   21,    8,    8,   10,   10,   11,   11,   11,   11,   15,
   15,   22,   22,   23,   23,   23,   23,   23,   23,   16,
   16,   24,   25,   25,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    2,    1,    1,    2,    1,    1,    1,    1,
    1,    1,    1,    6,    7,    8,    8,   12,   12,    3,
    6,    1,    1,    1,    3,    1,    9,    2,    1,    5,
    4,    3,    3,    1,    3,    3,    1,    1,    1,    1,
    4,    0,    6,    4,    5,   11,    8,   13,    9,    0,
    3,    3,    2,    1,    1,    1,    1,    1,    1,    3,
    7,    3,    3,    1,    6,    4,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,   22,   23,    0,
    0,    0,    4,    5,    0,    7,    8,    9,   10,   11,
   12,   13,    0,    0,    0,    0,    0,    0,    0,    1,
    0,    3,   26,    0,    0,    0,   39,   40,    0,    0,
   37,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    2,    0,    0,    0,    0,    0,    0,
    0,    0,   44,    0,    0,    0,    0,    0,   54,   55,
   56,   59,   58,   57,    0,    0,   66,   24,    0,    0,
    0,    0,   25,    0,    0,    0,   35,   36,   45,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   41,    0,    0,    0,    0,    0,   65,   43,
    0,    0,    0,    0,   14,   28,    0,    0,    0,    0,
    0,   53,   15,    0,    0,    0,    0,    0,   47,    0,
    0,    0,    0,    0,   61,    0,   49,    0,    0,    0,
    0,    0,   27,    0,    0,    0,    0,    0,    0,    0,
   46,    0,    0,   31,    0,    0,    0,    0,   30,   48,
    0,    0,   18,   19,
};
short yydgoto[] = {                                       2,
   11,   12,   13,   14,   15,   35,   16,   17,   18,   38,
   20,   21,   22,   53,  113,   47,   48,  102,  134,   40,
   41,  114,   75,   66,   67,
};
short yysindex[] = {                                   -221,
 -175,    0, -114,  -33,   56,   70, -165,    0,    0,   88,
 -173,   62,    0,    0, -202,    0,    0,    0,    0,    0,
    0,    0, -150, -133, -129,  -40,  -99,   86, -103,    0,
  106,    0,    0,  -75,  133,  -20,    0,    0,   38,   66,
    0,  -20, -150,  104,   97, -150,  150,    4,  -71,  110,
 -185,  -65,  155,    0,  159,  -55,  -59, -150, -150, -150,
 -150,  123,    0,  -54,   38,  164,  175,  -57,    0,    0,
    0,    0,    0,    0, -150,   90,    0,    0,  158,  -41,
  -70, -185,    0,  131,   66,   66,    0,    0,    0, -150,
  -10, -150,  -69,   38,  185,  -26,  176,  -33, -153,  177,
  -17,  189,    0,   38,  201,   38, -153,  183,    0,    0,
  -40,  184,  -24, -153,    0,    0,  -21, -150,  -23, -160,
  188,    0,    0,  193, -139,  207,  -97, -153,    0, -253,
    0,  213,  -90,  -13,    0,  -11,    0,  195,   -5,   -4,
 -150,  219,    0, -153,   -3,  208,  209,  168, -150,    2,
    0,  229,  231,    0,  171,    3,  -40,  -40,    0,    0,
  232,  233,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,  216, -198,    0,    0,    0,    0,    0,    0,
  216,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  217,  -32,    0,    0,  218,  -27,
    0,  -39,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  234,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -22,    1,    0,    0,    0,    0,
    0,    0,    0,   28,    0,    0,    0,    0,   11,    0,
    0,    0,    0,  221,    0,   75,   11,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  216,    0,    0,    0,    0,    0,
 -182,    0,  -58,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   11,    0,  240,  241,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  160,   -6,    0,  -14,   17,    0,    0,    0,    0,   45,
    0,    0,    0,    0,  -64,  -80,   30,    0,    0,   81,
  115,    0,  192,  166,    0,
};
#define YYTABLESIZE 285
short yytable[] = {                                      46,
   42,   38,   38,   38,   31,   38,   24,   38,   38,   38,
   38,   38,   38,   34,   38,   34,   34,   34,   32,   24,
   32,   32,   32,   49,  139,  140,   38,   38,   38,   38,
  121,   34,   34,   34,   34,    1,   32,   32,   32,   32,
   43,   33,  119,   33,   33,   33,   58,   19,   59,   72,
   74,   73,   39,   44,   33,   19,   50,   25,   24,   33,
   33,   33,   33,   72,   74,   73,  100,   79,   60,   34,
   57,   78,   62,   24,   52,   65,  161,  162,  108,  150,
   58,   52,   59,    4,  112,   51,   60,   52,    8,    9,
    5,    3,  112,   52,   30,   26,    6,    7,  101,  124,
    8,    9,   10,   98,   94,  128,   36,   60,  129,   27,
    5,   37,   61,  138,   28,   62,    6,    4,   63,  104,
   32,  106,   10,   42,    5,   19,   31,   29,   37,  112,
    6,    7,   45,  132,    8,    9,   10,   19,   85,   86,
    8,    9,    4,   19,   63,   51,   58,   65,   59,    5,
   77,   19,   58,   52,   59,    6,    7,   36,   19,    8,
    9,   10,   37,   89,   54,   58,    4,   59,  136,   19,
  148,  137,   19,    5,   87,   88,   56,   19,  155,    6,
    7,   55,  142,    8,    9,   10,   98,   98,   19,   64,
   68,   76,   80,    5,    5,   81,   99,  107,   82,    6,
    6,   83,   84,   90,   91,   10,   10,   93,  154,   29,
   58,  159,   59,   58,   95,   59,   36,   24,   92,   96,
   97,   37,   24,  103,   23,  109,   38,   38,   38,  117,
  110,   34,   34,   34,  111,  115,   32,   32,   32,  116,
  118,  120,  122,  123,  127,  125,  130,  135,   69,   70,
   71,  131,  141,  145,  143,  144,  146,  147,  149,   33,
   33,   33,   69,   70,   71,  151,  152,  153,  157,  156,
  158,  160,  163,  164,   42,    6,   20,   64,   50,   21,
   16,   17,  105,  126,  133,
};
short yycheck[] = {                                      40,
   59,   41,   42,   43,   11,   45,   40,   47,   41,   42,
   43,   44,   45,   41,   47,   43,   44,   45,   41,   40,
   43,   44,   45,  123,  278,  279,   59,   60,   61,   62,
  111,   59,   60,   61,   62,  257,   59,   60,   61,   62,
   24,   41,  107,   43,   44,   45,   43,    3,   45,   60,
   61,   62,   23,   24,  257,   11,   27,   91,  257,   59,
   60,   61,   62,   60,   61,   62,   81,   51,   41,  272,
   91,  257,   43,  272,  257,   46,  157,  158,   93,  144,
   43,  264,   45,  257,   99,  268,   59,  270,  274,  275,
  264,  267,  107,  276,  268,   40,  270,  271,   82,  114,
  274,  275,  276,  257,   75,  266,  257,   42,  269,   40,
  264,  262,   47,  128,  280,   41,  270,  257,   44,   90,
   59,   92,  276,  257,  264,   81,  133,   40,  262,  144,
  270,  271,  262,  273,  274,  275,  276,   93,   58,   59,
  274,  275,  257,   99,   41,   60,   43,  118,   45,  264,
   41,  107,   43,  257,   45,  270,  271,  257,  114,  274,
  275,  276,  262,   41,   59,   43,  257,   45,  266,  125,
  141,  269,  128,  264,   60,   61,   44,  133,  149,  270,
  271,  257,  273,  274,  275,  276,  257,  257,  144,   93,
   41,  263,  258,  264,  264,   41,  267,  267,   40,  270,
  270,  257,  262,  258,   41,  276,  276,  265,   41,  268,
   43,   41,   45,   43,  125,   45,  257,  257,   44,   62,
  262,  262,  262,   93,  258,   41,  259,  260,  261,   41,
  257,  259,  260,  261,   59,   59,  259,  260,  261,  257,
   40,   59,   59,  268,  268,  267,   59,   41,  259,  260,
  261,   59,   40,   59,  268,  267,  262,  262,   40,  259,
  260,  261,  259,  260,  261,  269,   59,   59,   40,  268,
   40,  269,   41,   41,   59,   59,   59,   44,  268,   59,
   41,   41,   91,  118,  125,
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
"sentencia_control : FOR '(' encabezado_for ')' BEGIN bloque_sentencias_ejecutables END",
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
"bloque_if : IF '(' condicion ')' THEN sentencia_ejecutable ';' ELSE sentencia_ejecutable ';' END_IF",
"bloque_if : IF '(' condicion ')' THEN sentencia_ejecutable ';' END_IF",
"bloque_if : IF '(' condicion ')' THEN BEGIN bloque_sentencias_ejecutables END ELSE BEGIN bloque_sentencias_ejecutables END END_IF",
"bloque_if : IF '(' condicion ')' THEN BEGIN bloque_sentencias_ejecutables END END_IF",
"bloque_sentencias_ejecutables :",
"bloque_sentencias_ejecutables : list_sentencias_ejecutables sentencia_ejecutable ';'",
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
#line 150 "gramatica.y"

// código C asociado
#line 299 "y.tab.c"
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
