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
   13,   13,   14,   14,   14,   14,   14,   14,   17,   17,
    9,    9,    5,    5,   19,   19,    6,    6,    6,   22,
   23,    7,    7,    7,    7,   20,   20,   24,   25,   25,
   21,   21,   21,   26,   18,   18,   18,   18,   18,   27,
   27,   27,   27,   27,   28,   28,   28,   28,   28,   28,
   28,    8,    8,    8,    8,    8,   10,   10,   10,   10,
   30,   30,   15,   15,   15,   11,   11,   11,   11,   11,
   11,   11,   11,   32,   32,   32,   31,   31,   31,   31,
   33,   33,   33,   33,   33,   33,   33,   16,   16,   29,
   34,   34,   12,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    3,    3,    3,    3,    2,    2,    1,    1,
    2,    1,    1,    1,    1,    1,    1,    1,    5,    5,
    5,    4,    8,   12,   11,   11,   11,   11,    1,    1,
    3,    6,    1,    1,    1,    1,    3,    2,    1,    0,
    0,   11,    9,    8,    8,    2,    1,    3,    1,    3,
    3,    1,    2,    4,    3,    3,    1,    3,    3,    3,
    3,    1,    3,    3,    1,    1,    1,    4,    2,    2,
    5,    0,    6,    6,    3,    5,    4,    4,    3,    7,
    1,    1,    2,    2,    3,    9,    7,    9,    7,    6,
    6,    8,    8,    1,    5,    2,    3,    2,    2,    3,
    1,    1,    1,    1,    1,    1,    1,    3,    7,    3,
    3,    1,    4,    4,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,   35,   36,
    0,    0,    0,    9,   10,    0,   12,   13,   14,   15,
   16,   17,   18,   33,    0,    0,    0,    0,    0,   66,
    0,    0,   67,    0,    0,    0,   62,    5,    0,    0,
    0,    0,    0,    4,    0,    8,    7,   39,    0,    0,
    2,    0,   79,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   70,    0,  107,  101,  102,  103,
    0,    0,  106,  105,  104,    0,    0,    0,    1,    0,
  115,    0,   75,    0,    0,    0,    0,    6,    0,    0,
   38,    0,   77,    0,   78,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   58,    0,   59,    0,    0,   63,
   60,   64,   61,  113,  114,    0,    0,    0,    0,    0,
    0,    0,   22,    0,    0,    0,    0,   37,    0,    0,
    0,   68,    0,    0,   94,    0,    0,    0,    0,    0,
    0,   76,    0,    0,   21,    0,    0,   20,   19,   84,
   83,    0,    0,    0,    0,   46,    0,    0,    0,    0,
    0,   96,   82,    0,   81,   91,    0,    0,    0,   71,
    0,   90,   74,   73,    0,    0,   99,   98,   85,    0,
    0,    0,    0,    0,    0,   80,    0,    0,    0,   89,
    0,   87,    0,    0,    0,    0,  100,   97,    0,    0,
    0,   40,    0,    0,    0,    0,   54,   93,    0,    0,
  109,   92,   29,   30,    0,    0,    0,    0,   45,   53,
    0,    0,   44,   95,   88,   86,    0,    0,    0,    0,
   51,   41,   43,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   42,    0,    0,    0,    0,    0,   25,
    0,   28,   27,   26,   24,
};
short yydgoto[] = {                                       3,
  199,   13,   14,   15,   16,   50,   17,   18,   19,   20,
   21,   22,   23,   86,  135,   34,  216,   35,   24,  127,
  200,  221,  238,  154,  155,  136,   36,   37,   63,  166,
  147,  137,   76,   57,
};
short yysindex[] = {                                     77,
  143,  231,    0,   29,   58,  163,   14, -248,    0,    0,
   -4,  183,  -52,    0,    0, -139,    0,    0,    0,    0,
    0,    0,    0,    0,  192,   52,    6, -194,   24,    0,
   74,  -73,    0,   34,   89,  243,    0,    0,  208,    8,
  -43, -126, -126,    0,   79,    0,    0,    0,  -26,  -38,
    0,  123,    0,  261,  105,  111,  137,   92,  -18,   52,
  -40,   89,  151,  139,    0,  -14,    0,    0,    0,    0,
  -41,   17,    0,    0,    0,   52,   51,   60,    0,  214,
    0,  280,    0, -150,   30,  245,  -22,    0,  224,  -66,
    0,   69,    0,   52,    0,   52,   39,  217,  123,  246,
   65,   81,   70,  246,    0,  243,    0,  243,  123,    0,
    0,    0,    0,    0,    0,  -44,   99,  247,   29,  -69,
  113,  -51,    0,  -25,    0,  108,  313,    0,  330,  123,
   52,    0,  -69,  327,    0,  317, -232,  -74,  347,  300,
   97,    0,  -46,   20,    0,  -36, -111,    0,    0,    0,
    0,  154,  382,  385,  386,    0,  162,  391,  123,  122,
   52,    0,    0,  246,    0,    0, -152,  125,   52,    0,
  246,    0,    0,    0,   74,  377,    0,    0,    0,  -13,
  223,  174,  177,  -66,  223,    0,  383,  358, -152,    0,
  -70,    0,  404, -152,  -56,  126,    0,    0,  223,  178,
  389,    0,  223,    0,  182,  184,    0,    0, -152, -152,
    0,    0,    0,    0, -118,  199,  202,  410,    0,    0,
  223,  203,    0,    0,    0,    0,  411,  212,  416,  418,
    0,    0,    0,  445,   -7,  446,  449,  222,   74,  451,
   74,   74,   74,    0,  459,   74,  467,  468,  471,    0,
  474,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
   11,   11,    0, -103,    0,   11,    0,    0,    0,    0,
    0,  433,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  433,    0,    0,    0,  -32,    0,
    0,    0,    0,    0,    0,   33,    0,    0,   31,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   27,
    0,   28,    0,  476,    0,    0,    0,    0,    0,    0,
    0,  476,    0,   -3,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  476,    0,
    0,    0,    0,    0,    0,   40,    0,   68,  -39,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    4,    0,    0,    0,    0,  368,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  477,    0,    0,    0,    0,    0,   47,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   11,    0,    0,    0,   11,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  -54,    0,
    0,    0,   11,  381,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   11,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    2,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  171,   96,    0,  264,   -8,    0,    0,    0,    0,   -5,
    0,    0,    0,  475,   53,  116, -135,  312,   23,  -61,
  -23,    0,    0,    0,    0,  175,  146,  338,   -2,  -31,
  392,  -16,  422,    0,
};
#define YYTABLESIZE 525
short yytable[] = {                                      33,
  101,  108,  215,   32,   72,   92,   47,  151,   65,   65,
   65,   65,   65,   90,   65,  152,   84,  143,  121,  108,
   33,   33,  178,  163,   56,   33,   65,   65,   65,   65,
    3,   41,  241,  164,   33,   43,  165,   69,   69,   69,
   69,   69,   23,   69,   47,  198,   53,   47,   81,   55,
   32,  240,   32,   40,   33,   69,   69,   69,   69,   60,
  217,   32,  153,   27,   32,   33,   33,   58,   27,   72,
   33,   33,   33,   57,   66,   57,   57,   57,  175,  228,
   55,  126,   55,   55,   55,   11,   31,  141,   33,   72,
   33,   57,   57,   57,   57,   32,   32,   31,   55,   55,
   55,   55,   32,  163,   32,   32,  116,   45,   56,  172,
   56,   56,   56,   60,   59,  126,  165,   48,   32,   28,
   45,  168,  204,    9,   10,   33,   56,   56,   56,   56,
   85,   71,   49,   72,   45,  190,  192,   88,   33,  123,
   73,   75,   74,  227,   94,  119,   61,  189,   73,   75,
   74,   95,    5,   34,  194,   33,  179,  208,    7,  213,
  214,  205,  212,   33,   11,   71,  193,   72,   34,   33,
  145,   12,   25,  149,  210,  126,   39,  225,  226,  222,
   96,  167,  119,   64,   97,  209,  119,  119,   65,    5,
  125,  102,  133,    5,    5,    7,  133,  232,  134,    7,
    7,   11,  134,   46,  150,   11,   11,    9,   10,  173,
  174,  142,   83,   52,  105,   29,  106,  108,   91,  177,
   30,  213,  214,   65,  100,  108,   65,   65,   65,  103,
   89,  125,   65,   33,  119,   33,   33,   33,  108,  108,
   33,    5,  197,   98,  120,   65,   65,    7,    9,   10,
  104,   42,   69,   11,  114,   69,   69,   69,   23,  176,
   34,   69,   29,  124,   29,   23,   72,   30,   23,   30,
   80,   23,  107,   29,   69,   69,   29,   23,   30,    9,
   10,   30,   11,   31,   77,  118,   26,  117,   57,   78,
  195,   57,   57,   57,   45,   55,  131,   57,   55,   55,
   55,   93,   32,   71,   55,   72,  110,   29,   29,  132,
   57,   57,   30,   30,   29,  112,   29,   55,   55,   30,
  115,   30,   71,   56,   72,  128,   56,   56,   56,  138,
   29,  140,   56,    1,  187,   30,   67,   52,   54,   68,
   69,   70,   62,    2,   67,   56,   56,   68,   69,   70,
  122,   82,  163,  157,  245,  201,  247,  248,  249,  201,
  144,  251,  171,  122,  156,  165,  161,  122,  148,  119,
  158,   99,   71,  218,   72,  162,    5,  201,  119,  120,
  163,  122,    7,  146,  122,    5,  169,  109,   11,  179,
  191,    7,  170,  165,  134,  201,  146,   11,  207,    4,
   71,  122,   72,  213,  214,  129,    5,  130,  110,    6,
  180,  111,    7,    8,  111,  113,    9,   10,   11,    4,
  181,   48,  182,  180,   50,  183,    5,  122,  185,  184,
   38,  186,    7,    8,  122,  196,    9,   10,   11,    4,
  202,  206,  159,  203,  211,  219,    5,  220,    4,  223,
   44,  224,    7,    8,  122,    5,    9,   10,   11,   51,
  229,    7,    8,  230,    4,    9,   10,   11,  231,  234,
  233,    5,  188,  235,  236,   79,  237,    7,    8,    4,
   99,    9,   10,   11,  239,  242,    5,    4,  243,  244,
  246,   72,    7,    8,    5,  134,    9,   10,   11,  250,
    7,    8,  119,  119,    9,   10,   11,  252,  253,    5,
    5,  254,  133,  120,  255,    7,    7,   87,  134,  112,
   49,   11,   11,  139,  160,
};
short yycheck[] = {                                       5,
   41,   41,   59,   45,   59,   44,   59,   59,   41,   42,
   43,   44,   45,   40,   47,   41,   60,   62,   41,   59,
   26,   27,   59,  256,   27,   31,   59,   60,   61,   62,
    0,  280,   40,  266,   40,   40,  269,   41,   42,   43,
   44,   45,   41,   47,   41,   59,   41,   44,   41,   27,
   45,   59,   45,   40,   60,   59,   60,   61,   62,   40,
  196,   45,  124,   40,   45,   71,   72,  262,   40,   59,
   76,   77,   78,   41,   41,   43,   44,   45,   59,  215,
   41,   90,   43,   44,   45,   59,   59,  104,   94,   59,
   96,   59,   60,   61,   62,   45,   45,   40,   59,   60,
   61,   62,   45,  256,   45,   59,   84,   12,   41,  141,
   43,   44,   45,   40,   91,  124,  269,  257,   45,   91,
   25,  138,  184,  274,  275,  131,   59,   60,   61,   62,
  257,   43,  272,   45,   39,  167,  168,   59,  144,   87,
   60,   61,   62,  262,   40,  257,   31,  164,   60,   61,
   62,   41,  264,  257,  171,  161,  268,  189,  270,  278,
  279,  185,  194,  169,  276,   43,  169,   45,  272,  175,
  118,    1,    2,  121,  191,  184,    6,  209,  210,  203,
   44,  256,  257,  257,   93,  256,  257,  257,  262,  264,
  257,   41,  267,  264,  264,  270,  267,  221,  273,  270,
  270,  276,  273,  256,  256,  276,  276,  274,  275,  256,
  257,  256,  256,  268,  256,  257,   71,   72,  257,  256,
  262,  278,  279,  256,  265,  265,  259,  260,  261,   91,
  257,  257,  265,  239,  257,  241,  242,  243,  278,  279,
  246,  264,  256,  262,  267,  278,  279,  270,  274,  275,
  265,  256,  256,  276,   41,  259,  260,  261,  257,  144,
  257,  265,  257,   40,  257,  264,  256,  262,  267,  262,
  263,  270,  256,  257,  278,  279,  257,  276,  262,  274,
  275,  262,  256,  256,   42,   41,  258,  258,  256,   47,
  175,  259,  260,  261,  199,  256,  258,  265,  259,  260,
  261,   41,  256,   43,  265,   45,  256,  257,  257,   93,
  278,  279,  262,  262,  257,  256,  257,  278,  279,  262,
   41,  262,   43,  256,   45,  257,  259,  260,  261,  265,
  257,  262,  265,  257,  160,  262,  256,   26,   27,  259,
  260,  261,   31,  267,  256,  278,  279,  259,  260,  261,
   87,   40,  256,   41,  239,  181,  241,  242,  243,  185,
  262,  246,  266,  100,  257,  269,   40,  104,  256,  257,
   41,   60,   43,  199,   45,   59,  264,  203,  257,  267,
  256,  118,  270,  120,  121,  264,   40,   76,  276,  268,
  266,  270,   93,  269,  273,  221,  133,  276,   41,  257,
   43,  138,   45,  278,  279,   94,  264,   96,   41,  267,
  147,   44,  270,  271,   77,   78,  274,  275,  276,  257,
  267,   41,   41,  160,   44,   41,  264,  164,  267,   44,
  268,   41,  270,  271,  171,   59,  274,  275,  276,  257,
  267,   59,  131,  267,   41,  268,  264,   59,  257,  268,
  268,  268,  270,  271,  191,  264,  274,  275,  276,  268,
  262,  270,  271,  262,  257,  274,  275,  276,   59,   59,
  268,  264,  161,  262,   59,  268,   59,  270,  271,  257,
  169,  274,  275,  276,   40,   40,  264,  257,   40,  268,
   40,   59,  270,  271,  264,  273,  274,  275,  276,   41,
  270,  271,  257,  257,  274,  275,  276,   41,   41,  264,
  264,   41,  267,  267,   41,  270,  270,   43,  273,   44,
   44,  276,  276,  102,  133,
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
"sentencia_control : FOR error encabezado_for ')' bloque_sentencias_ejecutables",
"sentencia_control : FOR '(' encabezado_for bloque_sentencias_ejecutables",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE '(' condicion ')'",
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
"declaracion_tipo :",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base '>' ID",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base '>' error",
"declaracion_tipo : TYPEDEF TRIPLE error",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base error",
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
"list_sentencias_ejecutables : sentencia_ejecutable error",
"list_sentencias_ejecutables : list_sentencias_ejecutables sentencia_ejecutable error",
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
#line 240 "gramatica.y"
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

#line 465 "y.tab.c"
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
case 23:
#line 52 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 24:
#line 53 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}
break;
case 25:
#line 54 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 26:
#line 55 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 27:
#line 56 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 28:
#line 57 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 31:
#line 66 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 32:
#line 67 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion ");}
break;
case 38:
#line 82 "gramatica.y"
{yyerror("Las variables deben estar separados por coma");}
break;
case 40:
#line 87 "gramatica.y"
{inFunction = true; hasReturn = false;}
break;
case 41:
#line 87 "gramatica.y"
{ if (!hasReturn) {
                                                                                                 	yyerror("Falta sentencia RET en la función");
                                                                                                 }
                                                                                                 inFunction = false;
                                                                                                 }
break;
case 43:
#line 92 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");}
break;
case 44:
#line 93 "gramatica.y"
{yyerror("La funcione debe tener nombre");}
break;
case 45:
#line 94 "gramatica.y"
{yyerror("La función debe tener parámetro");}
break;
case 47:
#line 99 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 54:
#line 117 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 66:
#line 142 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 67:
#line 149 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 69:
#line 151 "gramatica.y"
{}
break;
case 70:
#line 152 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 71:
#line 156 "gramatica.y"
{}
break;
case 74:
#line 161 "gramatica.y"
{yyerror("Falta ID al final de la declaracion");}
break;
case 75:
#line 162 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion");}
break;
case 76:
#line 163 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion");}
break;
case 78:
#line 168 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 79:
#line 169 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 80:
#line 170 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 82:
#line 175 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 84:
#line 180 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 86:
#line 185 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 87:
#line 186 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 88:
#line 187 "gramatica.y"
{yyerror("Falta contenido en el bloque ELSE");}
break;
case 89:
#line 188 "gramatica.y"
{yyerror("Falta contenido en el bloque THEN");}
break;
case 90:
#line 189 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 91:
#line 190 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 92:
#line 191 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 93:
#line 192 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 99:
#line 204 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 100:
#line 205 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 107:
#line 215 "gramatica.y"
{yyerror("Falta comparador en la comparación");}
break;
case 110:
#line 225 "gramatica.y"
{}
break;
case 113:
#line 234 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 114:
#line 235 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 115:
#line 236 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 850 "y.tab.c"
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
