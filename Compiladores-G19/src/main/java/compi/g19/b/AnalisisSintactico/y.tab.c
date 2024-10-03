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
    0,    1,    1,    2,    2,    3,    3,    4,    4,    4,
    4,    8,    5,    5,    6,    6,    7,   13,   14,   14,
   14,   12,   12,   12,   15,   15,   15,   16,   16,   16,
    9,   10,   10,   18,   18,   18,   17,   17,   17,   17,
   17,   17,   11,   11,
};
short yylen[] = {                                         2,
    4,    3,    2,    1,    1,    2,    1,    1,    2,    1,
    1,    4,    1,    1,    3,    1,    9,    2,    1,    5,
    4,    3,    3,    1,    3,    3,    1,    1,    1,    1,
    4,    9,    7,    1,    1,    3,    3,    3,    3,    3,
    3,    3,    5,    5,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,   13,   14,    0,    0,
    4,    5,    0,    7,    8,    0,   10,   11,    0,    0,
    0,    0,    1,    0,    3,   16,    0,    0,    9,    0,
   29,   30,    0,    0,   27,    0,    0,    0,    0,    0,
    2,    0,    0,   12,    0,    0,    0,    0,   31,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   15,
    0,    0,   25,   26,    0,    0,    0,    0,    0,    0,
    0,   43,   44,    0,    0,    0,    0,    0,    0,   18,
    0,    0,    0,   33,    0,   36,    0,    0,    0,    0,
   32,    0,    0,   17,    0,    0,   21,    0,   20,
};
short yydgoto[] = {                                       2,
   77,   10,   11,   12,   13,   28,   14,   15,   32,   17,
   18,   33,   75,   90,   34,   35,   38,   79,
};
short yysindex[] = {                                   -235,
 -229,    0, -126,  -37,    7,   27,    0,    0, -170,   18,
    0,    0, -214,    0,    0,   24,    0,    0, -196, -196,
 -196, -198,    0,   33,    0,    0, -188,   57,    0,   63,
    0,    0,  -10,   21,    0,    3,   -6,   68,   79,   37,
    0,   82, -125,    0, -196, -196, -196, -196,    0, -196,
 -196, -196, -196, -196, -196, -131,   83,   87, -259,    0,
   21,   21,    0,    0,   17,   17,   17,   17,   17,   17,
 -168,    0,    0, -105,  114, -126, -126,    0, -156,    0,
 -111, -149, -168,    0, -146,    0, -112,  118, -134, -109,
    0, -196,  120,    0,   92, -196,    0,  102,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  103,    0,  -41,
    0,    0,    0,  -36,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -31,   -9,    0,    0,  122,  123,  124,  125,  126,  127,
    0,    0,    0,    0,    0,    0, -152,  -32,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0, -107,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   10,   -1,    0,  -26,  110,    0,    0,    0,    8,    0,
    0,   20,    0,    0,  105,  106,    0,   88,
};
#define YYTABLESIZE 255
short yytable[] = {                                      28,
   28,   28,   20,   28,   24,   28,   24,   24,   24,   22,
   16,   22,    9,   22,    7,    8,   16,   28,   28,   28,
   28,    1,   24,   24,   24,   24,    5,   22,   22,   22,
   22,   23,   45,   23,   46,   23,   45,    3,   46,   36,
   37,   40,   26,   49,   78,   45,   21,   46,   44,   23,
   23,   23,   23,   55,   53,   54,   78,   27,   30,   45,
   30,   46,   47,   31,   39,   31,   22,   48,   42,   65,
   66,   67,   68,   69,   70,   24,   25,   58,   16,   45,
   24,   46,   29,   16,   16,   82,    4,   24,    4,   16,
   16,   41,   16,    5,   89,    5,   16,   23,   76,    6,
   43,    6,   20,    7,    8,    7,    8,    4,   56,   83,
    4,   95,   84,   34,    5,   98,   34,    5,   86,   57,
    6,   59,    4,    6,    7,    8,   88,    7,    8,    5,
    4,   60,   97,   71,   45,    6,   46,    5,   93,    7,
    8,   72,   99,    6,   45,   73,   46,    7,    8,   61,
   62,   80,   63,   64,   81,   85,   91,   92,   94,   96,
   19,    6,   37,   38,   39,   40,   41,   42,   74,    0,
   87,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   28,   28,   28,
   19,    0,   24,   24,   24,    0,    0,   22,   22,   22,
    0,    0,    0,   35,    0,    0,   35,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   23,
   23,   23,   50,   51,   52,
};
short yycheck[] = {                                      41,
   42,   43,   40,   45,   41,   47,   43,    9,   45,   41,
    3,   43,    3,   45,  274,  275,    9,   59,   60,   61,
   62,  257,   59,   60,   61,   62,   59,   59,   60,   61,
   62,   41,   43,   43,   45,   45,   43,  267,   45,   20,
   21,   22,  257,   41,   71,   43,   40,   45,   59,   59,
   60,   61,   62,   60,   61,   62,   83,  272,  257,   43,
  257,   45,   42,  262,  263,  262,   40,   47,  257,   50,
   51,   52,   53,   54,   55,   77,   59,   41,   71,   43,
   82,   45,   59,   76,   77,   76,  257,   89,  257,   82,
   83,   59,   85,  264,   85,  264,   89,  268,  267,  270,
   44,  270,   40,  274,  275,  274,  275,  257,   41,  266,
  257,   92,  269,  266,  264,   96,  269,  264,  268,   41,
  270,   40,  257,  270,  274,  275,  273,  274,  275,  264,
  257,  257,   41,  265,   43,  270,   45,  264,  273,  274,
  275,   59,   41,  270,   43,   59,   45,  274,  275,   45,
   46,  257,   47,   48,   41,  267,  269,   40,  268,   40,
  268,   59,   41,   41,   41,   41,   41,   41,   59,   -1,
   83,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  259,  260,  261,
  258,   -1,  259,  260,  261,   -1,   -1,  259,  260,  261,
   -1,   -1,   -1,  266,   -1,   -1,  269,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  259,
  260,  261,  259,  260,  261,
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
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"ID","ASIGNACION","MAYORIGUAL","MENORIGUAL","DISTINTO","CONSTANTE",
"CADENA","IF","THEN","ELSE","BEGIN","END","END_IF","OUTF","TYPEDEF","FUN","RET",
"ULONGINT","SINGLE","FOR","OR","UP","DOWN","TRIPLE",
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
"sentencia_ejecutable : asignacion",
"sentencia_ejecutable : invocacion_funcion ';'",
"sentencia_ejecutable : bloque_if",
"sentencia_ejecutable : salida_mensaje",
"asignacion : ID ASIGNACION expresion ';'",
"tipo : ULONGINT",
"tipo : SINGLE",
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
"invocacion_funcion : ID '(' expresion ')'",
"bloque_if : IF '(' condicion ')' THEN bloque_sentencias ELSE bloque_sentencias END_IF",
"bloque_if : IF '(' condicion ')' THEN bloque_sentencias END_IF",
"bloque_sentencias : list_sentencias",
"bloque_sentencias : sentencia_ejecutable",
"bloque_sentencias : BEGIN list_sentencias END",
"condicion : expresion MAYORIGUAL expresion",
"condicion : expresion MENORIGUAL expresion",
"condicion : expresion DISTINTO expresion",
"condicion : expresion '=' expresion",
"condicion : expresion '>' expresion",
"condicion : expresion '<' expresion",
"salida_mensaje : OUTF '(' CADENA ')' ';'",
"salida_mensaje : OUTF '(' expresion ')' ';'",
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
#line 107 "gramatica.y"

// código C asociado
#line 243 "y.tab.c"
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
