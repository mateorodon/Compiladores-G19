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
   21,   21,   21,   26,   18,   18,   18,   27,   27,   27,
   28,   28,   28,   28,   28,   28,   28,   28,    8,    8,
    8,    8,    8,   10,   10,   10,   30,   30,   15,   15,
   15,   11,   11,   11,   11,   11,   11,   11,   11,   32,
   32,   32,   31,   31,   31,   31,   33,   33,   33,   33,
   33,   33,   33,   16,   16,   29,   34,   34,   12,   12,
   12,
};
short yylen[] = {                                         2,
    4,    3,    3,    3,    3,    3,    2,    2,    1,    1,
    2,    1,    1,    1,    1,    1,    1,    1,    5,    5,
    5,    4,    8,   12,   11,   11,   11,   11,    1,    1,
    3,    6,    1,    1,    1,    1,    3,    2,    1,    0,
    0,   11,    9,    8,    8,    2,    1,    3,    1,    3,
    3,    1,    2,    4,    3,    3,    1,    3,    3,    1,
    1,    1,    1,    4,    2,    2,    5,    1,    0,    6,
    6,    3,    5,    4,    4,    7,    1,    1,    2,    2,
    3,    9,    7,    9,    7,    6,    6,    8,    8,    1,
    5,    2,    3,    2,    2,    3,    1,    1,    1,    1,
    1,    1,    1,    3,    7,    3,    3,    1,    4,    4,
    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,   35,   36,
    0,    0,    0,    9,   10,    0,   12,   13,   14,   15,
   16,   17,   18,   33,    0,    0,    0,    0,   68,    0,
   62,    0,    0,   63,    0,    0,    0,   60,    5,    0,
    0,    0,    0,    0,    4,    0,    8,    7,   39,    0,
    0,    2,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   66,    0,  103,   97,   98,   99,
    0,    0,  102,  101,  100,    0,    0,    0,    1,    0,
  111,    0,   72,    0,    0,    0,    0,    6,    0,    0,
   38,    0,   74,    0,   75,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   58,   59,  109,
  110,    0,    0,    0,    0,    0,    0,    0,   22,    0,
    0,    0,    0,   37,    0,    0,    0,   64,    0,    0,
   90,    0,    0,    0,    0,    0,    0,   73,    0,    0,
   21,    0,    0,   20,   19,   80,   79,    0,    0,    0,
    0,   46,    0,    0,    0,    0,    0,   92,   78,    0,
   77,   87,    0,    0,    0,   67,    0,   86,   71,   70,
    0,    0,   95,   94,   81,    0,    0,    0,    0,    0,
    0,   76,    0,    0,    0,   85,    0,   83,    0,    0,
    0,    0,   96,   93,    0,    0,    0,   40,    0,    0,
    0,    0,   54,   89,    0,    0,  105,   88,   29,   30,
    0,    0,    0,    0,   45,   53,    0,    0,   44,   91,
   84,   82,    0,    0,    0,    0,   51,   41,   43,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   42,
    0,    0,    0,    0,    0,   25,    0,   28,   27,   26,
   24,
};
short yydgoto[] = {                                       3,
  195,   13,   14,   15,   16,   51,   17,   18,   19,   20,
   21,   22,   23,   86,  131,   35,  212,   36,   24,  123,
  196,  217,  234,  150,  151,  132,   37,   38,   63,  162,
  143,  133,   76,   57,
};
short yysindex[] = {                                    -89,
  143,  226,    0,    8,   50,  165,  -11, -208,    0,    0,
  -26,  174,  -43,    0,    0, -196,    0,    0,    0,    0,
    0,    0,    0,    0,  195,   74,   41, -166,    0,   23,
    0,   52, -183,    0,   85,   68,   75,    0,    0,  210,
   48,   31, -124, -124,    0,  104,    0,    0,    0,  -25,
   -5,    0,  158,  318,  110,  133,  140,   96,  -70,   74,
  -29,   68,  154,  113,    0,  -49,    0,    0,    0,    0,
   74,   74,    0,    0,    0,   74,   74,   74,    0,  187,
    0,  336,    0,  -68,   34,  194,    3,    0,  221, -134,
    0,   37,    0,   74,    0,   74,   61,  192,  158,  -59,
   70,   91,   92,  -59,   75,   75,  158,    0,    0,    0,
    0,    7,  102,   98,    8,  132,  -74,  -35,    0,   14,
    0,  101,  325,    0,  383,  158,   74,    0,  132,  338,
    0,  335, -120, -100,  344,  302,  -57,    0,   81,  -23,
    0,   16,  112,    0,    0,    0,    0,  130,  357,  363,
  361,    0,  139,  368,  158,  241,   74,    0,    0,  -59,
    0,    0, -121,   57,   74,    0,  -59,    0,    0,    0,
   52,  352,    0,    0,    0,   18,  218,  148,  153, -134,
  218,    0,  362,  410, -121,    0,  -76,    0,  384, -121,
  -14,   62,    0,    0,  218,  159,  371,    0,  218,    0,
  164,  169,    0,    0, -121, -121,    0,    0,    0,    0,
 -178,  184,  185,  395,    0,    0,  218,  188,    0,    0,
    0,    0,  398,  196,  401,  402,    0,    0,    0,  422,
   66,  428,  433,  208,   52,  437,   52,   52,   52,    0,
  438,   52,  446,  454,  458,    0,  462,    0,    0,    0,
    0,
};
short yyrindex[] = {                                      0,
   28,   28,    0, -141,    0,   28,    0,    0,    0,    0,
    0,  445,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  445,    0,    0,    0,    0,  -41,
    0,    0,    0,    0,    0,    0,  -10,    0,    0,   53,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   35,    0,   39,  463,    0,    0,    0,    0,    0,    0,
    0,  463,    0,  -34,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  463,    0,
    0,    0,    0,    0,   -3,   21,  -36,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    2,    0,    0,    0,    0,   27,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  464,    0,
    0,    0,    0,    0,   45,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   28,    0,    0,    0,
   28,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -27,    0,    0,    0,   28,  128,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   28,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   26,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
short yygindex[] = {                                      0,
  136,  122,    0,  256,  -60,    0,    0,    0,    0,   83,
    0,    0,    0,  466,   -9,  107, -138,  307,   43,  -73,
  -96,    0,    0,    0,    0,  176,  315,  314,   10,  -19,
  377,   -2,  411,    0,
};
#define YYTABLESIZE 517
short yytable[] = {                                      61,
   61,   61,   61,   61,  104,   61,   65,   65,   65,   65,
   65,  101,   65,   44,   90,   48,   60,   61,   61,   61,
   61,   33,  104,  147,   65,   65,   65,   65,   41,  122,
   57,   69,   57,   57,   57,  171,   56,   55,   92,   55,
   55,   55,   47,  117,  211,   47,  149,   27,   57,   57,
   57,   57,    3,  213,  148,   55,   55,   55,   55,  122,
   49,   56,   27,   56,   56,   56,   23,  106,  139,   55,
  107,   42,  224,   64,  174,   50,  194,  119,   65,   56,
   56,   56,   56,  223,  201,   33,   69,   34,   81,   32,
   84,   60,   33,   11,   33,   58,   33,   31,   28,  209,
  210,  137,  218,   32,  141,  237,  200,  145,   34,   34,
   71,   69,   72,   59,   34,   34,   77,  168,   33,  122,
  228,   78,  121,   34,  236,   66,  112,   73,   75,   74,
   34,  164,   85,   46,  159,  159,   12,   25,   61,    9,
   10,   40,   34,  186,  188,  160,   46,  161,  161,   94,
   73,   75,   74,   34,   34,  163,  115,  185,   34,   34,
   34,   46,   88,    5,  190,  204,  129,    1,   48,    7,
  208,   50,  130,   95,  189,   11,   34,    2,   34,  205,
  115,  144,  115,   96,  206,  221,  222,    5,   97,    5,
  129,   98,  116,    7,  102,    7,  130,  115,  159,   11,
   71,   11,   72,  103,    5,    9,   10,  129,  167,   34,
    7,  161,   47,  130,   61,  104,   11,   61,   61,   61,
  146,   65,   34,   61,   65,   65,   65,  110,  104,   43,
   65,   89,   29,   30,  114,  100,   61,   61,   31,   34,
   52,  104,  104,   65,   65,   57,  172,   34,   57,   57,
   57,   91,   55,   34,   57,   55,   55,   55,   34,  115,
  120,   55,  138,  209,  210,   26,    5,   57,   57,  116,
  121,  173,    7,  193,   55,   55,   56,  191,   11,   56,
   56,   56,   23,   69,  128,   56,   83,    9,   10,   23,
   11,  113,   23,  124,   31,   23,   29,   30,   56,   56,
   32,   23,   31,   29,   30,   29,   30,   29,   30,   31,
   80,   31,  159,   31,    9,   10,   46,   34,  127,   34,
   34,   34,  187,   67,   34,  161,   68,   69,   70,   29,
   30,  183,   53,   54,  134,   31,  169,  170,   62,  209,
  210,  241,  118,  243,  244,  245,   67,   82,  247,   68,
   69,   70,  197,  136,  115,  118,  197,  152,   93,  118,
   71,    5,   72,  140,  116,  153,   99,    7,  115,  118,
  214,  142,  118,   11,  197,    5,  111,  157,   71,  175,
   72,    7,  107,  165,  142,  105,  106,   11,  115,  118,
  108,  109,  197,  158,  166,    5,  177,  178,  176,    4,
  125,    7,  126,  179,  180,  181,    5,   11,  182,    6,
  192,  176,    7,    8,  198,  118,    9,   10,   11,  199,
  202,    4,  118,  154,  207,   71,  215,   72,    5,  216,
    4,  219,   39,  155,    7,    8,  220,    5,    9,   10,
   11,   45,  118,    7,    8,  225,  226,    9,   10,   11,
  203,    4,   71,  227,   72,  229,  230,  231,    5,  232,
  233,  235,   52,  184,    7,    8,    4,  238,    9,   10,
   11,   99,  239,    5,    4,  240,  242,   79,  246,    7,
    8,    5,    4,    9,   10,   11,  248,    7,    8,    5,
  130,    9,   10,   11,  249,    7,    8,  115,  250,    9,
   10,   11,  251,   69,    5,  156,  108,   49,  175,   87,
    7,    0,  135,  130,    0,    0,   11,
};
short yycheck[] = {                                      41,
   42,   43,   44,   45,   41,   47,   41,   42,   43,   44,
   45,   41,   47,   40,   40,   59,   40,   59,   60,   61,
   62,   45,   59,   59,   59,   60,   61,   62,   40,   90,
   41,   59,   43,   44,   45,   59,   27,   41,   44,   43,
   44,   45,   41,   41,   59,   44,  120,   40,   59,   60,
   61,   62,    0,  192,   41,   59,   60,   61,   62,  120,
  257,   41,   40,   43,   44,   45,   41,   41,   62,   27,
   44,  280,  211,  257,   59,  272,   59,   87,  262,   59,
   60,   61,   62,  262,  181,   45,   59,    5,   41,   40,
   60,   40,   45,   59,   45,  262,   45,   59,   91,  278,
  279,  104,  199,   59,  114,   40,  180,  117,   26,   27,
   43,   59,   45,   91,   32,  257,   42,  137,   45,  180,
  217,   47,  257,   41,   59,   41,   84,   60,   61,   62,
  272,  134,  257,   12,  256,  256,    1,    2,   32,  274,
  275,    6,   60,  163,  164,  266,   25,  269,  269,   40,
   60,   61,   62,   71,   72,  256,  257,  160,   76,   77,
   78,   40,   59,  264,  167,  185,  267,  257,   41,  270,
  190,   44,  273,   41,  165,  276,   94,  267,   96,  256,
  257,  256,  257,   44,  187,  205,  206,  264,   93,  264,
  267,  262,  267,  270,   41,  270,  273,  257,  256,  276,
   43,  276,   45,   91,  264,  274,  275,  267,  266,  127,
  270,  269,  256,  273,  256,  265,  276,  259,  260,  261,
  256,  256,  140,  265,  259,  260,  261,   41,  265,  256,
  265,  257,  256,  257,   41,  265,  278,  279,  262,  157,
  268,  278,  279,  278,  279,  256,  140,  165,  259,  260,
  261,  257,  256,  171,  265,  259,  260,  261,  257,  257,
   40,  265,  256,  278,  279,  258,  264,  278,  279,  267,
  257,  256,  270,  256,  278,  279,  256,  171,  276,  259,
  260,  261,  257,  256,   93,  265,  256,  274,  275,  264,
  256,  258,  267,  257,  256,  270,  256,  257,  278,  279,
  256,  276,  262,  256,  257,  256,  257,  256,  257,  262,
  263,  262,  256,  262,  274,  275,  195,  235,  258,  237,
  238,  239,  266,  256,  242,  269,  259,  260,  261,  256,
  257,  156,   26,   27,  265,  262,  256,  257,   32,  278,
  279,  235,   87,  237,  238,  239,  256,   41,  242,  259,
  260,  261,  177,  262,  257,  100,  181,  257,   41,  104,
   43,  264,   45,  262,  267,   41,   60,  270,  257,  114,
  195,  116,  117,  276,  199,  264,   41,   40,   43,  268,
   45,  270,   76,   40,  129,   71,   72,  276,  257,  134,
   77,   78,  217,   59,   93,  264,  267,   41,  143,  257,
   94,  270,   96,   41,   44,  267,  264,  276,   41,  267,
   59,  156,  270,  271,  267,  160,  274,  275,  276,  267,
   59,  257,  167,   41,   41,   43,  268,   45,  264,   59,
  257,  268,  268,  127,  270,  271,  268,  264,  274,  275,
  276,  268,  187,  270,  271,  262,  262,  274,  275,  276,
   41,  257,   43,   59,   45,  268,   59,  262,  264,   59,
   59,   40,  268,  157,  270,  271,  257,   40,  274,  275,
  276,  165,   40,  264,  257,  268,   40,  268,   41,  270,
  271,  264,  257,  274,  275,  276,   41,  270,  271,  264,
  273,  274,  275,  276,   41,  270,  271,  257,   41,  274,
  275,  276,   41,   59,  264,  129,   44,   44,  268,   44,
  270,   -1,  102,  273,   -1,   -1,  276,
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
"declaracion_tipo : TYPEDEF TRIPLE error",
"declaracion_tipo : TYPEDEF TRIPLE '<' tipo_base error",
"invocacion_funcion : ID '(' expresion ')'",
"invocacion_funcion : ID '(' bloque_list_expresiones ')'",
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
#line 237 "gramatica.y"
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
    if (valor < AccionSemantica.SINGLE_POSITIVE_MIN || valor >= Float.POSITIVE_INFINITY) {
        yyerror("Constante flotante fuera de rango");
    }
}

#line 459 "y.tab.c"
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
case 62:
#line 138 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 63:
#line 145 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 65:
#line 147 "gramatica.y"
{}
break;
case 66:
#line 148 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 67:
#line 152 "gramatica.y"
{}
break;
case 68:
#line 153 "gramatica.y"
{yyerror("Falta operando en la expresión");}
break;
case 71:
#line 158 "gramatica.y"
{yyerror("Falta ID al final de la declaracion");}
break;
case 72:
#line 159 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion");}
break;
case 73:
#line 160 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion");}
break;
case 75:
#line 165 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 76:
#line 166 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 78:
#line 171 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 80:
#line 176 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 82:
#line 181 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 83:
#line 182 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 84:
#line 183 "gramatica.y"
{yyerror("Falta contenido en el bloque ELSE");}
break;
case 85:
#line 184 "gramatica.y"
{yyerror("Falta contenido en el bloque THEN");}
break;
case 86:
#line 185 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 87:
#line 186 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 88:
#line 187 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 89:
#line 188 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 95:
#line 201 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 96:
#line 202 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 103:
#line 212 "gramatica.y"
{yyerror("Falta comparador en la comparación");}
break;
case 109:
#line 231 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 110:
#line 232 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 111:
#line 233 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 840 "y.tab.c"
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
