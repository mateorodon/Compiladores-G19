#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package compi.g19.b.AnalisisSintactico;
import java.io.*;
import compi.g19.a.AnalisisLexico.*;
#line 10 "y.tab.c"
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
    0,    0,    0,    0,    0,    1,    1,    1,    2,    2,
    3,    3,    3,    4,    4,    4,    4,    4,   13,   13,
   13,   13,   14,   14,   16,   16,   16,   16,   17,   17,
   17,   17,   17,   19,   19,    9,    9,    5,    5,   21,
   21,    6,    6,    6,   24,   25,    7,    7,    7,    7,
   22,   22,   26,   27,   27,   23,   23,   23,   28,   20,
   20,   20,   29,   29,   29,   30,   30,   30,   30,   30,
   30,   30,   30,    8,    8,    8,    8,    8,   10,   10,
   10,   10,   32,   32,   15,   15,   15,   11,   11,   11,
   11,   11,   11,   11,   11,   34,   34,   34,   33,   33,
   35,   35,   35,   35,   35,   35,   35,   18,   18,   31,
   36,   36,   12,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    3,    3,    3,    3,    2,    2,    1,    1,
    2,    1,    1,    1,    1,    1,    1,    1,    5,    5,
    4,    4,    1,    1,    8,    7,    7,    7,   12,   11,
   11,   11,   11,    1,    1,    3,    6,    1,    1,    1,
    1,    3,    2,    1,    0,    0,   11,    9,    8,    8,
    2,    1,    3,    1,    3,    3,    1,    2,    4,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    4,    2,
    2,    5,    1,    0,    6,    6,    5,    5,    4,    4,
    3,    7,    1,    1,    2,    2,    3,    9,    7,    9,
    7,    6,    6,    8,    8,    1,    5,    2,    3,    2,
    1,    1,    1,    1,    1,    1,    1,    3,    7,    3,
    3,    1,    4,    4,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,   40,   41,
    0,    0,    0,    9,   10,    0,   12,   13,   14,   15,
   16,   17,   18,   38,    0,    0,    0,    0,   73,    0,
   67,    0,    0,   68,    0,    0,    0,   65,    5,    0,
    0,    0,    0,    0,    0,   23,   24,    4,    0,    8,
    7,   44,    0,    0,    2,    0,   81,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   71,    0,
  107,  101,  102,  103,    0,    0,  106,  105,  104,    0,
    0,    0,    1,    0,  115,    0,    0,    0,    0,    0,
    0,    6,    0,    0,   43,    0,   79,    0,   80,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   63,   64,  113,  114,    0,    0,    0,    0,    0,
    0,    0,   22,   21,    0,    0,    0,    0,   42,    0,
    0,    0,   69,    0,    0,   96,    0,    0,    0,    0,
    0,    0,   78,    0,   77,    0,    0,    0,    0,   20,
   19,   86,   85,    0,    0,    0,    0,   51,    0,    0,
    0,    0,    0,   98,   84,    0,   83,   93,    0,    0,
    0,   72,    0,   92,   76,   75,    0,    0,  100,   87,
    0,    0,    0,    0,    0,    0,   82,    0,    0,    0,
   91,    0,   89,    0,    0,   34,   35,    0,    0,    0,
   99,    0,    0,    0,   45,    0,    0,    0,    0,   59,
   95,    0,    0,  109,   94,    0,    0,    0,    0,    0,
   50,   58,    0,    0,   49,   97,   90,   88,    0,    0,
    0,    0,   56,   46,   48,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   47,   30,    0,   33,
   32,   31,   29,
};
short yydgoto[] = {                                       3,
  202,   13,   14,   15,   16,   54,   17,   18,   19,   20,
   21,   22,   23,   45,  136,   46,   47,   35,  199,   36,
   24,  128,  203,  223,  241,  156,  157,  137,   37,   38,
   67,  168,  149,  138,   80,   61,
};
short yysindex[] = {                                    -50,
  142,  237,    0,    6,   85,  169,   38, -252,    0,    0,
  -30,  184,  -45,    0,    0, -204,    0,    0,    0,    0,
    0,    0,    0,    0,  205,  -44,   71, -202,    0,   58,
    0,   92, -155,    0,   59,   99,  268,    0,    0,  214,
   73,  -15, -123, -109,  111,    0,    0,    0,  115,    0,
    0,    0,  -27,   -6,    0,  318,    0,  342,  155,  175,
  178,  148,  -17,  -44,  -37,   99,  213,  193,    0,   32,
    0,    0,    0,    0,  -44,  -44,    0,    0,    0,  -44,
  -44,  -44,    0,  283,    0,  420,   78,  272,   82,    1,
  -66,    0,  300,   37,    0,  100,    0,  -44,    0,  -44,
  104,  271,  318,  -70,  109,  117,  107,  -70,  268,  268,
  318,    0,    0,    0,    0,  -11,  122,   75,    6, -131,
  -94,  -42,    0,    0,  -38,    0,  129,  350,    0,  429,
  318,  -44,    0, -131,  353,    0,  335,   52,  -71,  362,
  312,  134,    0,  -76,    0,   92,  348,  349,  253,    0,
    0,    0,    0,  144,  373,  379,  377,    0,  156,  386,
  318,  252,  -44,    0,    0,  -70,    0,    0, -170,  163,
  -44,    0,  -70,    0,    0,    0,  -16,    9,    0,    0,
  369,  229,  164,  167,   37,  229,    0,  371,  489, -170,
    0,  125,    0,  394, -170,    0,    0, -122,  174,  185,
    0,  229,  182,  387,    0,  229,    0,  183,  189,    0,
    0, -170, -170,    0,    0,  405,  204,  408,  418,  424,
    0,    0,  229,  223,    0,    0,    0,    0,  413,  110,
  452,  456,    0,    0,    0,   92,  457,   92,   92,   92,
  230,  465,   92,  473,  474,  477,    0,    0,  478,    0,
    0,    0,    0,
};
short yyrindex[] = {                                      0,
  -41,  -41,    0, -129,    0,  -41,    0,    0,    0,    0,
    0,  467,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  467,    0,    0,    0,    0,  -36,
    0,    0,    0,    0,    0,    0,   -4,    0,    0,   15,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   13,    0,   14,    0,  480,    0,    0,
    0,    0,    0,    0,    0,  480,    0,  -12,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  480,    0,    0,    0,    0,    0,   20,   44,
  -39,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -25,    0,    0,    0,    0,
   67,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  483,    0,    0,    0,    0,    0,
   35,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -41,    0,    0,    0,  -41,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -47,    0,    0,    0,  -41,  124,    0,    0,    0,
    0,    0,    0,    0,    0,   25,    0,   26,   49,    0,
    0,    0,  -41,    0,    0,    0,    0,    0,    0,   50,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
short yygindex[] = {                                      0,
  337,   84,    0,  276,   -2,    0,    0,    0,    0,   -5,
    0,    0,    0,  487,   63,    0,    0,  132, -144,  324,
   42,  -63,  -85,    0,    0,    0,    0,  -31,  133,  191,
   17,  -23,  399,  -56,  430,    0,
};
#define YYTABLESIZE 536
short yytable[] = {                                      34,
   33,  108,  154,  105,   66,   66,   66,   66,   66,   44,
   66,   74,   94,   51,    3,   52,  153,   74,   52,  108,
   34,   34,   66,   66,   66,   66,   34,   42,   70,   70,
   70,   70,   70,  200,   70,   34,   62,   96,   62,   62,
   62,  121,  198,   60,   87,   27,   70,   70,   70,   70,
  144,  142,   52,  217,   62,   62,   62,   62,   34,   62,
   60,  155,   60,   60,   60,   26,   28,   53,   59,   34,
   34,   11,   36,   74,   34,   34,   34,   41,   60,   60,
   60,   60,  170,   88,   61,  165,   61,   61,   61,   27,
   25,  127,   34,   37,   34,   49,   28,   27,  167,   70,
  208,   68,   61,   61,   61,   61,   69,  110,   49,  190,
  111,   57,   34,   85,   64,   33,  195,   33,  174,   33,
  224,  207,  127,   49,   32,  119,   34,   39,  116,   33,
  188,   64,    5,  146,   89,  213,   33,  234,    7,  216,
   34,   75,   39,   76,   11,  191,  193,   43,   63,  238,
  204,   91,  123,  124,  204,  196,  197,   34,   77,   79,
   78,  150,  119,   65,   53,   34,  211,   55,  237,    5,
  220,  215,  120,   92,  204,    7,   77,   79,   78,  175,
  176,   11,  127,  151,  169,  119,  119,  194,  227,  228,
  119,  204,    5,    5,   98,  134,  134,    5,    7,    7,
  120,  135,  135,    7,   11,   11,    1,  109,  110,   11,
   50,   29,   30,  152,   74,   99,    2,   31,  126,   66,
   57,  100,   66,   66,   66,  108,   43,  104,   66,   93,
   34,   39,   34,   34,   34,    9,   10,   34,  108,  108,
  101,   66,   66,   70,  102,  143,   70,   70,   70,  147,
   95,   62,   70,  106,   62,   62,   62,  119,    9,   10,
   62,  196,  197,   26,    5,   70,   70,  120,   11,   36,
    7,  112,  113,   62,   62,   60,   11,  177,   60,   60,
   60,   26,   28,  107,   60,   49,  196,  197,   26,   28,
   37,   26,   28,  126,   26,   28,  108,   60,   60,   61,
   26,   28,   61,   61,   61,   27,   25,  165,   61,   81,
    9,   10,   27,   25,   82,   27,   25,  166,   27,   25,
  167,   61,   61,  114,   27,   25,   29,   30,   29,   30,
   29,   30,   31,  117,   31,   84,   31,   12,   25,  125,
   29,   30,   40,  118,    9,   10,   31,   29,   30,   56,
   58,    9,   10,   31,   71,   66,  129,   72,   73,   74,
   75,  132,   76,  133,   86,  122,  122,  242,  141,  244,
  245,  246,   71,  139,  249,   72,   73,   74,  145,  122,
  212,  119,   97,  122,   75,  158,   76,  103,    5,  165,
  159,  134,  163,  164,    7,  148,  122,  135,    4,  173,
   11,  171,  167,  111,  172,    5,  178,  179,    6,  148,
  182,    7,    8,  183,  122,    9,   10,   11,  165,  184,
  185,  130,  186,  131,  181,    4,  187,  201,  192,  209,
  205,  167,    5,  206,  214,  218,   39,  181,    7,    8,
    4,  122,    9,   10,   11,  222,  219,    5,  122,  221,
  225,   48,  236,    7,    8,  161,  226,    9,   10,   11,
  115,    4,   75,  229,   76,  230,  231,  122,    5,  160,
    4,   75,   55,   76,    7,    8,  232,    5,    9,   10,
   11,   83,  233,    7,    8,    4,  189,    9,   10,   11,
  235,  239,    5,    4,  103,  240,  243,  247,    7,    8,
    5,  135,    9,   10,   11,  248,    7,    8,  119,  119,
    9,   10,   11,  250,  251,    5,    5,  252,  253,  180,
  180,    7,    7,  112,  135,   74,   54,   11,   11,  210,
   90,   75,  162,   76,    0,  140,
};
short yycheck[] = {                                       5,
   45,   41,   41,   41,   41,   42,   43,   44,   45,   40,
   47,   59,   40,   59,    0,   41,   59,   59,   44,   59,
   26,   27,   59,   60,   61,   62,   32,  280,   41,   42,
   43,   44,   45,  178,   47,   41,   41,   44,   43,   44,
   45,   41,   59,   27,   60,   40,   59,   60,   61,   62,
   62,  108,  257,  198,   59,   60,   61,   62,   64,  262,
   41,  125,   43,   44,   45,   41,   41,  272,   27,   75,
   76,   59,   59,   59,   80,   81,   82,   40,   59,   60,
   61,   62,  139,   42,   41,  256,   43,   44,   45,   41,
   41,   94,   98,   59,  100,   12,   91,   40,  269,   41,
  186,  257,   59,   60,   61,   62,  262,   41,   25,  166,
   44,   41,  118,   41,   40,   45,  173,   45,  142,   45,
  206,  185,  125,   40,   40,  257,  132,  257,   87,   45,
  162,   40,  264,   59,  258,  192,   45,  223,  270,  262,
  146,   43,  272,   45,  276,  169,  170,  257,   91,   40,
  182,   41,   90,   91,  186,  278,  279,  163,   60,   61,
   62,  256,  257,   32,   41,  171,  190,   44,   59,  264,
  202,  195,  267,   59,  206,  270,   60,   61,   62,  256,
  257,  276,  185,  121,  256,  257,  257,  171,  212,  213,
  257,  223,  264,  264,   40,  267,  267,  264,  270,  270,
  267,  273,  273,  270,  276,  276,  257,   75,   76,  276,
  256,  256,  257,  256,  256,   41,  267,  262,  257,  256,
  268,   44,  259,  260,  261,  265,  257,  265,  265,  257,
  236,  257,  238,  239,  240,  274,  275,  243,  278,  279,
   93,  278,  279,  256,  262,  257,  259,  260,  261,  118,
  257,  256,  265,   41,  259,  260,  261,  257,  274,  275,
  265,  278,  279,  258,  264,  278,  279,  267,  256,  256,
  270,   81,   82,  278,  279,  256,  276,  146,  259,  260,
  261,  257,  257,   91,  265,  202,  278,  279,  264,  264,
  256,  267,  267,  257,  270,  270,  265,  278,  279,  256,
  276,  276,  259,  260,  261,  257,  257,  256,  265,   42,
  274,  275,  264,  264,   47,  267,  267,  266,  270,  270,
  269,  278,  279,   41,  276,  276,  256,  257,  256,  257,
  256,  257,  262,   62,  262,  263,  262,    1,    2,   40,
  256,  257,    6,  262,  274,  275,  262,  256,  257,   26,
   27,  274,  275,  262,  256,   32,  257,  259,  260,  261,
   43,  258,   45,   93,   41,   90,   91,  236,  262,  238,
  239,  240,  256,  265,  243,  259,  260,  261,  257,  104,
  256,  257,   41,  108,   43,  257,   45,   64,  264,  256,
   41,  267,   40,   59,  270,  120,  121,  273,  257,  266,
  276,   40,  269,   80,   93,  264,   59,   59,  267,  134,
  267,  270,  271,   41,  139,  274,  275,  276,  256,   41,
   44,   98,  267,  100,  149,  257,   41,   59,  266,   59,
  267,  269,  264,  267,   41,  262,  268,  162,  270,  271,
  257,  166,  274,  275,  276,   59,  262,  264,  173,  268,
  268,  268,   40,  270,  271,  132,  268,  274,  275,  276,
   41,  257,   43,   59,   45,  262,   59,  192,  264,   41,
  257,   43,  268,   45,  270,  271,   59,  264,  274,  275,
  276,  268,   59,  270,  271,  257,  163,  274,  275,  276,
  268,   40,  264,  257,  171,   40,   40,  268,  270,  271,
  264,  273,  274,  275,  276,   41,  270,  271,  257,  257,
  274,  275,  276,   41,   41,  264,  264,   41,   41,  268,
  268,  270,  270,   44,  273,   59,   44,  276,  276,   41,
   44,   43,  134,   45,   -1,  106,
};
#define YYFINAL 3
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 280
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,0,
"';'","'<'","'='","'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
"'['",0,"']'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,"ID","ASIGNACION","MAYORIGUAL","MENORIGUAL","DISTINTO",
"CONSTANTE","CADENA","IF","THEN","ELSE","BEGIN","END","END_IF","OUTF","TYPEDEF",
"FUN","RET","ULONGINT","SINGLE","FOR","OR","UP","DOWN","TRIPLE",
};
char *yyrule[] = {
"$accept : programa",
"programa : ID BEGIN list_sentencias END",
"programa : BEGIN list_sentencias END",
"programa : ID BEGIN list_sentencias",
"programa : ID list_sentencias END",
"programa : ID BEGIN END",
"list_sentencias : list_sentencias sentencia ';'",
"list_sentencias : sentencia ';'",
"list_sentencias : sentencia error",
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
"sentencia_control : FOR '(' encabezado_for ')' error",
"sentencia_control : FOR encabezado_for ')' bloque_sentencias_ejecutables",
"sentencia_control : FOR '(' encabezado_for bloque_sentencias_ejecutables",
"encabezado_for : encabezado_for1",
"encabezado_for : encabezado_for2",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE",
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE '(' condicion ')'",
"up_down : UP",
"up_down : DOWN",
"asignacion : ID ASIGNACION expresion",
"asignacion : ID '[' CONSTANTE ']' ASIGNACION expresion",
"tipo : tipo_base",
"tipo : ID",
"tipo_base : ULONGINT",
"tipo_base : SINGLE",
"list_variables : list_variables ',' ID",
"list_variables : list_variables ID",
"list_variables : ID",
"$$1 :",
"$$2 :",
"declaracion_funcion : tipo FUN ID '(' parametro ')' BEGIN $$1 cuerpo_funcion $$2 END",
"declaracion_funcion : tipo FUN ID '(' bloque_list_parametro ')' BEGIN cuerpo_funcion END",
"declaracion_funcion : tipo FUN '(' parametro ')' BEGIN cuerpo_funcion END",
"declaracion_funcion : tipo FUN ID '(' ')' BEGIN cuerpo_funcion END",
"parametro : tipo ID",
"parametro : ID",
"bloque_list_parametro : list_parametro ',' parametro",
"list_parametro : parametro",
"list_parametro : list_parametro ',' parametro",
"cuerpo_funcion : list_sentencias sentencia_return ';'",
"cuerpo_funcion : list_sentencias",
"cuerpo_funcion : sentencia_return ';'",
"sentencia_return : RET '(' expresion ')'",
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
"factor : '-' ID",
"factor : '-' CONSTANTE",
"factor : '-' ID '[' CONSTANTE ']'",
"factor : error",
"declaracion_tipo :",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base '>' ID",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base '>' error",
"declaracion_tipo : TYPEDEF TRIPLE tipo_base '>' ID",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base ID",
"invocacion_funcion : ID '(' expresion ')'",
"invocacion_funcion : ID '(' bloque_list_expresiones ')'",
"invocacion_funcion : ID '(' ')'",
"invocacion_funcion : ID '(' tipo_base '(' expresion ')' ')'",
"fin_if : END_IF",
"fin_if : error",
"bloque_sentencias_ejecutables : sentencia_ejecutable ';'",
"bloque_sentencias_ejecutables : sentencia_ejecutable error",
"bloque_sentencias_ejecutables : BEGIN list_sentencias_ejecutables END",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if ELSE cuerpo_if fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if fin_if",
"bloque_if : IF '(' condicion ')' THEN cuerpo_if ELSE error fin_if",
"bloque_if : IF '(' condicion ')' THEN error fin_if",
"bloque_if : IF condicion ')' THEN cuerpo_if fin_if",
"bloque_if : IF '(' condicion THEN cuerpo_if fin_if",
"bloque_if : IF condicion ')' THEN cuerpo_if ELSE cuerpo_if fin_if",
"bloque_if : IF '(' condicion THEN cuerpo_if ELSE cuerpo_if fin_if",
"cuerpo_if : bloque_sentencias_ejecutables",
"cuerpo_if : BEGIN list_sentencias_ejecutables sentencia_return ';' END",
"cuerpo_if : sentencia_return ';'",
"list_sentencias_ejecutables : list_sentencias_ejecutables sentencia_ejecutable ';'",
"list_sentencias_ejecutables : sentencia_ejecutable ';'",
"comparacion : MAYORIGUAL",
"comparacion : MENORIGUAL",
"comparacion : DISTINTO",
"comparacion : '='",
"comparacion : '>'",
"comparacion : '<'",
"comparacion : error",
"condicion : expresion comparacion expresion",
"condicion : '(' bloque_list_expresiones ')' comparacion '(' bloque_list_expresiones ')'",
"bloque_list_expresiones : list_expresiones ',' expresion",
"list_expresiones : list_expresiones ',' expresion",
"list_expresiones : expresion",
"salida_mensaje : OUTF '(' CADENA ')'",
"salida_mensaje : OUTF '(' expresion ')'",
"salida_mensaje : OUTF '(' ')'",
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
#line 246 "gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;
static boolean inFunction = false;
static boolean hasReturn = false;

public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
      System.out.println(t);
      this.yylval = new ParserVal(t.getLexema().toString());
      return (int) t.getId();
    }
    return 0;
}

public static void yyerror(String error){
    AnalizadorLexico.agregarErrorSintactico(error);
}

private void chequeoFlotantesPositivos(String lexema){
    float valor = Float.parseFloat(lexema);
    if  ((valor != 0f) && (valor < AccionSemantica.SINGLE_POSITIVE_MIN || valor >= Float.POSITIVE_INFINITY)) {
        yyerror("Constante flotante fuera de rango");
    }
}

#line 467 "y.tab.c"
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
#line 11 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa");}
break;
case 2:
#line 12 "gramatica.y"
{yyerror("El programa debe tener un nombre");}
break;
case 3:
#line 13 "gramatica.y"
{yyerror("Falta delimitador END del programa");}
break;
case 4:
#line 14 "gramatica.y"
{yyerror("Falta delimitador BEGIN del programa");}
break;
case 5:
#line 15 "gramatica.y"
{yyerror("Programa vacío");}
break;
case 8:
#line 21 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
#line 30 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
break;
case 12:
#line 31 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 13:
#line 32 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 14:
#line 36 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 15:
#line 37 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 20:
#line 46 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 21:
#line 47 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 22:
#line 48 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 25:
#line 57 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR de 3");}
break;
case 26:
#line 58 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 27:
#line 59 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 28:
#line 60 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 29:
#line 64 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR con condicion");}
break;
case 30:
#line 65 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 31:
#line 66 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 32:
#line 67 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 33:
#line 68 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 43:
#line 93 "gramatica.y"
{yyerror("Las variables deben estar separados por coma");}
break;
case 45:
#line 98 "gramatica.y"
{inFunction = true; hasReturn = false;}
break;
case 46:
#line 98 "gramatica.y"
{ if (!hasReturn) {
                                                                                                 	yyerror("Falta sentencia RET en la función");
                                                                                                 }
                                                                                                 inFunction = false;
                                                                                                 }
break;
case 48:
#line 103 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");}
break;
case 49:
#line 104 "gramatica.y"
{yyerror("La funcione debe tener nombre");}
break;
case 50:
#line 105 "gramatica.y"
{yyerror("La función debe tener parámetro");}
break;
case 52:
#line 110 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 59:
#line 128 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 67:
#line 149 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 68:
#line 156 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 71:
#line 159 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 72:
#line 163 "gramatica.y"
{}
break;
case 73:
#line 164 "gramatica.y"
{yyerror("Falta termino en la expresion");}
break;
case 76:
#line 169 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 77:
#line 170 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 78:
#line 171 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 80:
#line 176 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 81:
#line 177 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 82:
#line 178 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 84:
#line 183 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 86:
#line 188 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 88:
#line 193 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 89:
#line 194 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 90:
#line 195 "gramatica.y"
{yyerror("Falta contenido en el bloque ELSE");}
break;
case 91:
#line 196 "gramatica.y"
{yyerror("Falta contenido en el bloque THEN");}
break;
case 92:
#line 197 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 93:
#line 198 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 94:
#line 199 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 95:
#line 200 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 107:
#line 221 "gramatica.y"
{yyerror("Falta comparador en la comparación");}
break;
case 109:
#line 226 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
break;
case 110:
#line 231 "gramatica.y"
{}
break;
case 113:
#line 240 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 114:
#line 241 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 115:
#line 242 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 856 "y.tab.c"
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
