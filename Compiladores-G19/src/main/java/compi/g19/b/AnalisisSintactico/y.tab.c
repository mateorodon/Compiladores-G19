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
    4,    4,    4,   13,   13,   13,   13,    9,    9,    5,
    5,    5,    6,    6,    7,   17,   18,   18,   18,   16,
   16,   16,   19,   19,   19,   20,   20,   20,   20,    8,
    8,   10,   11,   11,   11,   11,   15,   15,   21,   21,
   22,   22,   22,   22,   22,   22,   14,   14,   23,   24,
   24,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    2,    1,    1,    2,    1,    1,    1,    1,
    1,    1,    1,   13,   13,   14,   14,    3,    6,    1,
    1,    1,    3,    1,    9,    2,    1,    5,    4,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    4,    0,
    6,    4,   11,    8,   13,    9,    0,    3,    3,    2,
    1,    1,    1,    1,    1,    1,    3,    7,    3,    3,
    1,    6,    4,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,   20,   21,    0,
    0,    0,    4,    5,    0,    7,    8,    9,   10,   11,
   12,   13,    0,    0,    0,    0,    0,    0,    0,    1,
    0,    3,   24,    0,    0,    0,   37,   38,    0,    0,
   35,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    2,    0,    0,    0,    0,    0,    0,    0,   42,    0,
    0,    0,    0,    0,   51,   52,   53,   56,   55,   54,
    0,    0,   63,   22,    0,    0,    0,   23,    0,    0,
    0,   33,   34,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   39,    0,    0,    0,    0,    0,    0,
   62,   41,    0,   26,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   50,    0,    0,    0,   44,    0,    0,
    0,    0,   58,    0,   46,    0,    0,    0,    0,    0,
    0,   25,    0,    0,    0,    0,    0,    0,    0,   43,
    0,    0,   29,    0,    0,    0,    0,    0,    0,   28,
   45,    0,   14,    0,   15,   16,   17,
};
short yydgoto[] = {                                       2,
   11,   12,   13,   14,   15,   35,   16,   17,   18,   38,
   20,   21,   22,   45,  108,   46,   93,  122,   40,   41,
  109,   71,   62,   63,
};
short yysindex[] = {                                   -236,
 -229,    0, -116,  -39,   -8,   29, -207,    0,    0,   55,
 -193,   43,    0,    0, -138,    0,    0,    0,    0,    0,
    0,    0, -235, -235, -156,  -40, -120,   66, -122,    0,
   91,    0,    0,  -91,  124,  -24,    0,    0,  108,   21,
    0,   53,   81, -235,  135,   -1,  -84,   60, -150,  -71,
    0,  151,  -61,  -63, -235, -235, -235, -235,    0,  -58,
  108,  161,  162,  -60,    0,    0,    0,    0,    0,    0,
 -235,   82,    0,    0,  146,  -52, -150,    0,  119,   21,
   21,    0,    0, -235,  -15, -235,  -92,  108,  172,  -43,
  156,  -41,  177,    0,  108,  180,  108,  -39, -177,  167,
    0,    0,  -40,    0,  -46, -235,  168,  -37, -177, -204,
  173, -185,  195,    0, -136,  178, -177,    0, -133,  198,
 -153,  -28,    0,  -25,    0,    0,  182,  -23,  -19, -235,
  207,    0, -177,  -21,  208,  209,   95, -235,  -16,    0,
  -87,  -72,    0,  126,  -18, -177,  194, -177,  202,    0,
    0,  -14,    0,   -6,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,  204, -129,    0,    0,    0,    0,    0,    0,
  204,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  205,  -36,    0,    0,  206,  -31,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  222,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -26,
   -4,    0,    0,    0,    0,    0,    0,   33,    0,    0,
    0,    0,    0,    0,  210,    0,  103,    0,    2,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  204,    0,    0,    0,    0,    0,    0,    0,    0,
  -57,    0,    0,    0,    0,  -67,    0,    0,    0,    0,
    0,    0,    2,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    2,    0,    2,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  155,   -7,    0,  -33,  -29,    0,    0,    0,    0,   40,
    0,    0,    0,  165,  -17,   26,    0,    0,  107,  136,
    0,  186,  166,    0,
};
#define YYTABLESIZE 272
short yytable[] = {                                      44,
   24,   40,   47,   31,   36,   36,   36,   36,   36,   32,
   36,   32,   32,   32,   30,   24,   30,   30,   30,   75,
    1,   36,   36,   36,   36,   36,   37,   32,   32,   32,
   32,   26,   30,   30,   30,   30,   31,    3,   31,   31,
   31,   55,   19,   56,   68,   70,   69,   92,   39,   42,
   19,   25,   48,  100,   31,   31,   31,   31,   68,   70,
   69,  117,   57,    4,  118,  107,   54,   58,   27,   61,
    5,    4,   28,   57,   30,  116,    6,    7,    5,   98,
    8,    9,   10,  127,    6,    7,    5,  120,    8,    9,
   10,   57,    6,   59,   29,   55,   88,   56,   10,  107,
   73,   32,   55,    4,   56,   43,   74,  147,  149,   95,
    5,   97,  107,   31,  107,  139,    6,    7,   33,  131,
    8,    9,   10,    8,    9,   49,   19,   22,  152,  124,
  154,   61,  125,   34,   50,  143,   36,   55,   19,   56,
    4,   37,   22,   59,  128,  129,   60,    5,   19,   51,
   55,   19,   56,    6,    7,  137,   19,    8,    9,   10,
   19,   80,   81,  144,   98,   52,  150,   53,   55,   98,
   56,    5,   19,   60,   99,   64,    5,    6,   72,  146,
   19,   19,    6,   10,   98,   19,   76,   19,   10,   49,
   77,    5,   82,   83,  148,   78,   49,    6,   79,   84,
   48,   85,   49,   10,   87,   86,   89,   90,   49,   91,
   27,   94,  101,  102,  103,  104,   36,  105,   23,  106,
  112,   37,   36,   36,   36,  110,  114,   32,   32,   32,
  115,  119,   30,   30,   30,  123,  126,  130,  135,  132,
  134,  133,  136,   65,   66,   67,  138,  140,  141,  142,
  151,  145,  153,  156,   31,   31,   31,   65,   66,   67,
  155,  157,   40,    6,   18,   61,  121,  111,   19,   47,
   96,  113,
};
short yycheck[] = {                                      40,
   40,   59,  123,   11,   41,   42,   43,   44,   45,   41,
   47,   43,   44,   45,   41,   40,   43,   44,   45,   49,
  257,  257,   59,   60,   61,   62,  262,   59,   60,   61,
   62,   40,   59,   60,   61,   62,   41,  267,   43,   44,
   45,   43,    3,   45,   60,   61,   62,   77,   23,   24,
   11,   91,   27,   87,   59,   60,   61,   62,   60,   61,
   62,  266,   42,  257,  269,   99,   91,   47,   40,   44,
  264,  257,  280,   41,  268,  109,  270,  271,  264,  257,
  274,  275,  276,  117,  270,  271,  264,  273,  274,  275,
  276,   59,  270,   41,   40,   43,   71,   45,  276,  133,
   41,   59,   43,  257,   45,  262,  257,  141,  142,   84,
  264,   86,  146,  121,  148,  133,  270,  271,  257,  273,
  274,  275,  276,  274,  275,   60,   87,  257,  146,  266,
  148,  106,  269,  272,  257,   41,  257,   43,   99,   45,
  257,  262,  272,   41,  278,  279,   44,  264,  109,   59,
   43,  112,   45,  270,  271,  130,  117,  274,  275,  276,
  121,   55,   56,  138,  257,  257,   41,   44,   43,  257,
   45,  264,  133,   93,  267,   41,  264,  270,  263,  267,
  141,  142,  270,  276,  257,  146,  258,  148,  276,  257,
   40,  264,   57,   58,  267,  257,  264,  270,  262,  258,
  268,   41,  270,  276,  265,   44,  125,   62,  276,  262,
  268,   93,   41,  257,   59,  257,  257,   41,  258,   40,
  267,  262,  259,  260,  261,   59,   59,  259,  260,  261,
  268,   59,  259,  260,  261,   41,   59,   40,  262,  268,
   59,  267,  262,  259,  260,  261,   40,  269,   41,   41,
  269,  268,   59,  268,  259,  260,  261,  259,  260,  261,
   59,  268,   59,   59,   59,   44,  112,  103,   59,  268,
   85,  106,
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
"sentencia_control : FOR '(' ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE ')' sentencia_ejecutable ';'",
"sentencia_control : FOR '(' ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE ')' sentencia_ejecutable ';'",
"sentencia_control : FOR '(' ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE ')' BEGIN bloque_sentencias_ejecutables END",
"sentencia_control : FOR '(' ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE ')' BEGIN bloque_sentencias_ejecutables END",
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
#line 144 "gramatica.y"

// código C asociado
#line 291 "y.tab.c"
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
