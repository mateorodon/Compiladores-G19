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
    0,    0,    0,    0,    1,    1,    2,    2,    2,    2,
    3,    3,    3,    4,    4,    4,    4,    4,   13,   13,
   13,   13,   14,   14,   16,   16,   16,   16,   17,   17,
   17,   17,   17,   19,   19,    9,    9,    5,    5,   21,
   21,    6,    6,    6,   24,   25,    7,    7,    7,    7,
   22,   22,   26,   27,   27,   23,   23,   23,   28,   20,
   20,   20,   20,   20,   29,   29,   29,   29,   29,   30,
   30,   30,   30,   30,   30,   30,    8,    8,    8,    8,
   10,   10,   10,   10,   32,   32,   15,   15,   15,   11,
   11,   11,   11,   11,   11,   11,   11,   34,   34,   34,
   33,   33,   35,   35,   35,   35,   35,   35,   35,   18,
   18,   31,   36,   36,   12,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    3,    3,    2,    1,    2,    2,    1,    1,
    2,    1,    1,    1,    1,    1,    1,    1,    5,    5,
    4,    4,    1,    1,    8,    7,    7,    7,   12,   11,
   11,   11,   11,    1,    1,    3,    6,    1,    1,    1,
    1,    3,    2,    1,    0,    0,   11,    9,    8,    8,
    2,    1,    3,    1,    3,    3,    1,    2,    4,    3,
    3,    1,    3,    3,    3,    3,    1,    3,    3,    1,
    1,    1,    4,    2,    2,    5,    6,    6,    5,    5,
    4,    4,    3,    7,    1,    1,    2,    2,    3,    9,
    7,    9,    7,    6,    6,    8,    8,    1,    5,    2,
    3,    2,    1,    1,    1,    1,    1,    1,    1,    3,
    7,    3,    3,    1,    4,    4,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,   40,   41,
    0,    0,    6,    0,    0,    0,   12,   13,   14,   15,
   16,   17,   18,   38,    0,    0,    0,    0,    0,   71,
    0,    0,   72,    0,    0,    0,   67,    0,    0,    0,
    0,    0,    0,   23,   24,    4,    5,    7,    8,   44,
    0,    0,    2,    0,   83,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   75,    0,  109,  103,
  104,  105,    0,    0,  108,  107,  106,    0,    0,    0,
    1,    0,  117,    0,    0,    0,    0,    0,    0,    0,
    0,   43,    0,   81,    0,   82,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   63,    0,   64,    0,    0,
   68,   65,   69,   66,  115,  116,    0,    0,    0,    0,
    0,    0,    0,   22,   21,    0,    0,    0,    0,   42,
    0,    0,    0,   73,    0,    0,   98,    0,    0,    0,
    0,    0,    0,   80,    0,   79,    0,    0,    0,    0,
   20,   19,   88,   87,    0,    0,    0,    0,   51,    0,
    0,    0,    0,    0,  100,   86,    0,   85,   95,    0,
    0,    0,   76,    0,   94,   78,   77,    0,    0,  102,
   89,    0,    0,    0,    0,    0,    0,   84,    0,    0,
    0,   93,    0,   91,    0,    0,   34,   35,    0,    0,
    0,  101,    0,    0,    0,   45,    0,    0,    0,    0,
   59,   97,    0,    0,  111,   96,    0,    0,    0,    0,
    0,   50,   58,    0,    0,   49,   99,   92,   90,    0,
    0,    0,    0,   56,   46,   48,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   47,   30,    0,
   33,   32,   31,   29,
};
short yydgoto[] = {                                       3,
  203,   13,   14,   15,   16,   52,   17,   18,   19,   20,
   21,   22,   23,   43,  137,   44,   45,   34,  200,   35,
   24,  129,  204,  224,  242,  157,  158,  138,   36,   37,
   65,  169,  150,  139,   78,   59,
};
short yysindex[] = {                                   -245,
  292,  366,    0,  -33,   11,  366,  -29, -257,    0,    0,
  -13,  312,    0,  -30,  -19, -183,    0,    0,    0,    0,
    0,    0,    0,    0,  328,    2,  107, -205,   -9,    0,
   35,  -80,    0,   23,  127,  152,    0,  337,  -15,  -57,
 -167, -155,   74,    0,    0,    0,    0,    0,    0,    0,
  -12,  -34,    0,  147,    0,  400,   85,   88,   95,   67,
  -86,    2,  -39,  127,  160,  117,    0,  -55,    0,    0,
    0,    0,   59,   83,    0,    0,    0,    2,  148,  166,
    0,  175,    0,  502,  -91,  157,    5,  -37,  386,  223,
 -130,    0,   21,    0,    2,    0,    2,   36,  190,  147,
  238,   26,  -47,   40,  238,    0,  152,    0,  152,  147,
    0,    0,    0,    0,    0,    0,  -53,   50,   -6,  -33,
 -169,  268,  -51,    0,    0,   13,    0,   61,  285,    0,
  529,  147,    2,    0, -169,  291,    0,  296, -119,  218,
  310,  270, -101,    0,  -50,    0,   35,  307,  315,  -95,
    0,    0,    0,    0,  112,  339,  343,  346,    0,  126,
  357,  147,  381,    2,    0,    0,  238,    0,    0, -191,
  -71,    2,    0,  238,    0,    0,    0,  -26,   33,    0,
    0,  342,  358,  136,  139, -130,  358,    0,  349,  536,
 -191,    0,  233,    0,  383, -191,    0,    0, -156,  164,
  167,    0,  358,  172,  373,    0,  358,    0,  176,  182,
    0,    0, -191, -191,    0,    0,  397,  195,  401,  404,
  411,    0,    0,  358,  209,    0,    0,    0,    0,  385,
   60,  438,  443,    0,    0,    0,   35,  446,   35,   35,
   35,  219,  452,   35,  457,  458,  460,    0,    0,  469,
    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0, -121,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  163,  178,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    1,    0,
    0,    0,    0,    0,    0,   49,    0,  517,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  191,    0,  121,    0,  474,    0,    0,    0,    0,
    0,    0,    0,  474,    0,   25,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  474,
    0,    0,    0,    0,    0,    0,   73,    0,   97,  -41,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   -3,    0,    0,    0,
    0,  105,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  475,    0,    0,    0,    0,
    0,  143,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  259,    0,    0,    0,    0,  159,    0,    0,
    0,    0,    0,    0,    0,    0,  -36,    0,  -35,  -21,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  145,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  165,   12,    0,  391,  -74,    0,    0,    0,    0,  442,
    0,    0,    0,  486,   42,    0,    0,  311, -144,  445,
   -8, -105, -111,    0,    0,    0,    0, -104,  262,  280,
  -11,  -17,  394,  -69,  427,    0,
};
#define YYTABLESIZE 686
short yytable[] = {                                     110,
   70,  102,   85,  122,   26,   28,   27,  154,  145,   93,
   39,    1,   75,   77,   76,   58,  128,  110,   57,   27,
  156,    2,   40,   47,   74,   83,   42,   91,   48,   32,
   27,   86,  199,   62,  201,  143,   47,   52,   32,   49,
   52,   70,   70,   70,   70,   70,   32,   70,   62,   47,
   31,  128,  147,  155,  218,   32,   60,   28,  189,   70,
   70,   70,   70,   68,  166,   74,   74,   74,   74,   74,
  171,   74,   60,   50,   62,  209,  117,  168,  205,   32,
  208,   61,  205,   74,   74,   74,   74,  120,   51,   62,
   87,   62,   62,   62,    5,  225,   61,  191,  221,  239,
    7,   41,  205,   32,  196,  217,   11,   62,   62,   62,
   62,  128,  235,   60,   89,   60,   60,   60,  238,  205,
   36,  197,  198,  214,   95,  175,  127,   32,   96,  124,
  125,   60,   60,   60,   60,   39,  166,   61,   97,   61,
   61,   61,   37,    9,   10,  112,  167,   55,  113,  168,
   39,   32,  192,  194,  166,   61,   61,   61,   61,   98,
  195,  120,   10,  152,  174,   12,   25,  168,    5,   73,
   38,   74,  181,  212,    7,   99,   66,    9,  216,   36,
   11,   67,    9,   10,  166,   25,   75,   77,   76,   73,
   11,   74,   32,   79,  193,  228,  229,  168,   80,   53,
  103,   37,   55,  144,  153,  176,  177,  104,   69,  105,
   32,   70,   71,   72,   47,  115,    9,   10,  118,  120,
   26,   28,   92,  110,   26,  101,    5,   26,   28,  121,
   26,   28,    7,   26,   28,   27,  110,  110,   11,   26,
   28,   29,   27,   41,   90,   27,   30,   82,   27,   11,
   29,  197,  198,   39,   27,   30,   70,   70,   29,   70,
   70,   70,  126,   30,   70,   70,  119,   29,   70,  127,
   70,   70,   30,   70,   70,   70,   70,  130,   70,   70,
   74,   74,  134,   74,   74,   74,    9,   10,   74,   74,
  140,   29,   74,  133,   74,   74,   30,   74,   74,   74,
   74,  142,   74,   74,   62,   62,  146,   62,   62,   62,
  197,  198,   62,   62,  106,   29,   62,  159,   62,   62,
   30,   62,   62,   62,   62,  160,   62,   62,   60,   60,
  164,   60,   60,   60,  107,  109,   60,   60,  108,   29,
   60,   63,   60,   60,   30,   60,   60,   60,   60,  172,
   60,   60,   61,   61,  165,   61,   61,   61,  112,  114,
   61,   61,  173,   29,   61,  179,   61,   61,   30,   61,
   61,   61,   61,  180,   61,   61,   36,   36,  183,  184,
    9,   10,   69,  185,   36,   70,   71,   72,   36,  186,
   36,   36,  187,   36,   36,   36,   36,  188,   37,   37,
  202,   25,  206,  111,   29,  207,   37,  210,   25,   30,
   37,   25,   37,   37,   25,   37,   37,   37,   37,   10,
   25,  113,   29,  215,  237,  219,   10,   30,  220,  148,
   10,  223,   10,   10,    9,   10,   10,   10,   10,  222,
   94,    9,   73,  226,   74,    9,   33,    9,    9,  227,
    9,    9,    9,    9,   11,  230,  231,  178,   11,  232,
   11,   11,  233,   11,   11,   11,   11,   33,   33,  234,
   54,   56,   33,  170,  120,   64,  236,  240,  123,  123,
   33,    5,  241,   84,  135,  244,  248,    7,  213,  120,
  136,  123,  249,   11,  120,  123,    5,  251,  252,  135,
  253,    5,    7,   33,  135,  136,  100,    7,   11,  254,
  136,  149,  123,   11,   33,   33,    3,  114,   54,   33,
   33,   33,  110,  151,  120,  149,   57,   88,  163,  141,
  123,    5,    0,    0,  121,    0,   33,    7,   33,  131,
  182,  132,  116,   11,   73,    0,   74,  243,    4,  245,
  246,  247,    0,  182,  250,    5,    0,  123,    6,    0,
   33,    7,    8,    0,  123,    9,   10,   11,    4,  161,
    0,   73,    0,   74,   33,    5,  211,  162,   73,   46,
   74,    7,    8,  123,    4,    9,   10,   11,   33,    0,
    0,    5,    0,    4,    0,   53,    0,    7,    8,    0,
    5,    9,   10,   11,   81,   33,    7,    8,  190,    0,
    9,   10,   11,   33,    4,    0,  100,    0,    0,    0,
    0,    5,    4,    0,    0,    0,    0,    7,    8,    5,
  136,    9,   10,   11,    0,    7,    8,  120,    0,    9,
   10,   11,  120,    0,    5,    0,    0,    0,  181,    5,
    7,    0,  121,  136,    0,    7,   11,    0,    0,    0,
    0,   11,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   33,    0,
   33,   33,   33,    0,    0,   33,
};
short yycheck[] = {                                      41,
    0,   41,   60,   41,   41,   41,   40,   59,   62,   44,
   40,  257,   60,   61,   62,   27,   91,   59,   27,   41,
  126,  267,  280,   12,    0,   41,   40,   40,   59,   45,
   40,   40,   59,   40,  179,  105,   25,   41,   45,   59,
   44,   41,   42,   43,   44,   45,   45,   47,    0,   38,
   40,  126,   59,   41,  199,   45,  262,   91,  163,   59,
   60,   61,   62,   41,  256,   41,   42,   43,   44,   45,
  140,   47,    0,  257,   40,  187,   85,  269,  183,   45,
  186,   91,  187,   59,   60,   61,   62,  257,  272,   41,
  258,   43,   44,   45,  264,  207,    0,  167,  203,   40,
  270,  257,  207,   45,  174,  262,  276,   59,   60,   61,
   62,  186,  224,   41,   41,   43,   44,   45,   59,  224,
    0,  278,  279,  193,   40,  143,  257,   45,   41,   88,
   89,   59,   60,   61,   62,  257,  256,   41,   44,   43,
   44,   45,    0,  274,  275,   41,  266,   41,   44,  269,
  272,   45,  170,  171,  256,   59,   60,   61,   62,   93,
  172,  257,    0,  122,  266,    1,    2,  269,  264,   43,
    6,   45,  268,  191,  270,  262,  257,    0,  196,   59,
  276,  262,  274,  275,  256,   41,   60,   61,   62,   43,
    0,   45,   45,   42,  266,  213,  214,  269,   47,   41,
   41,   59,   44,  257,  256,  256,  257,   91,  256,  265,
   45,  259,  260,  261,  203,   41,  274,  275,   62,  257,
  257,  257,  257,  265,  258,  265,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  257,  257,  267,  262,  263,  270,   59,
  257,  278,  279,  257,  276,  262,  256,  257,  257,  259,
  260,  261,   40,  262,  264,  265,  262,  257,  268,  257,
  270,  271,  262,  273,  274,  275,  276,  257,  278,  279,
  256,  257,   93,  259,  260,  261,  274,  275,  264,  265,
  265,  257,  268,  258,  270,  271,  262,  273,  274,  275,
  276,  262,  278,  279,  256,  257,  257,  259,  260,  261,
  278,  279,  264,  265,  256,  257,  268,  257,  270,  271,
  262,  273,  274,  275,  276,   41,  278,  279,  256,  257,
   40,  259,  260,  261,   73,   74,  264,  265,  256,  257,
  268,   31,  270,  271,  262,  273,  274,  275,  276,   40,
  278,  279,  256,  257,   59,  259,  260,  261,   79,   80,
  264,  265,   93,  257,  268,   59,  270,  271,  262,  273,
  274,  275,  276,   59,  278,  279,  256,  257,  267,   41,
  274,  275,  256,   41,  264,  259,  260,  261,  268,   44,
  270,  271,  267,  273,  274,  275,  276,   41,  256,  257,
   59,  257,  267,  256,  257,  267,  264,   59,  264,  262,
  268,  267,  270,  271,  270,  273,  274,  275,  276,  257,
  276,  256,  257,   41,   40,  262,  264,  262,  262,  119,
  268,   59,  270,  271,  257,  273,  274,  275,  276,  268,
   41,  264,   43,  268,   45,  268,    5,  270,  271,  268,
  273,  274,  275,  276,  264,   59,  262,  147,  268,   59,
  270,  271,   59,  273,  274,  275,  276,   26,   27,   59,
   26,   27,   31,  256,  257,   31,  268,   40,   88,   89,
   39,  264,   40,   39,  267,   40,  268,  270,  256,  257,
  273,  101,   41,  276,  257,  105,  264,   41,   41,  267,
   41,  264,  270,   62,  267,  273,   62,  270,  276,   41,
  273,  121,  122,  276,   73,   74,    0,   44,   44,   78,
   79,   80,   78,  256,  257,  135,  268,   42,  135,  103,
  140,  264,   -1,   -1,  267,   -1,   95,  270,   97,   95,
  150,   97,   41,  276,   43,   -1,   45,  237,  257,  239,
  240,  241,   -1,  163,  244,  264,   -1,  167,  267,   -1,
  119,  270,  271,   -1,  174,  274,  275,  276,  257,   41,
   -1,   43,   -1,   45,  133,  264,   41,  133,   43,  268,
   45,  270,  271,  193,  257,  274,  275,  276,  147,   -1,
   -1,  264,   -1,  257,   -1,  268,   -1,  270,  271,   -1,
  264,  274,  275,  276,  268,  164,  270,  271,  164,   -1,
  274,  275,  276,  172,  257,   -1,  172,   -1,   -1,   -1,
   -1,  264,  257,   -1,   -1,   -1,   -1,  270,  271,  264,
  273,  274,  275,  276,   -1,  270,  271,  257,   -1,  274,
  275,  276,  257,   -1,  264,   -1,   -1,   -1,  268,  264,
  270,   -1,  267,  273,   -1,  270,  276,   -1,   -1,   -1,
   -1,  276,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  237,   -1,
  239,  240,  241,   -1,   -1,  244,
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
"list_sentencias : list_sentencias sentencia",
"list_sentencias : sentencia",
"sentencia : sentencia_declarativa ';'",
"sentencia : sentencia_ejecutable ';'",
"sentencia : sentencia_ejecutable",
"sentencia : sentencia_declarativa",
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
#line 248 "gramatica.y"
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
    if (!error.contains("syntax error"))
        AnalizadorLexico.agregarErrorSintactico(error);
}

private void chequeoFlotantesPositivos(String lexema){
    float valor = Float.parseFloat(lexema);
    if  ((valor != 0f) && (valor < AccionSemantica.SINGLE_POSITIVE_MIN || valor >= Float.POSITIVE_INFINITY)) {
        yyerror("Constante flotante fuera de rango");
    }
}

#line 500 "y.tab.c"
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
case 9:
#line 24 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 10:
#line 25 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
#line 29 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
break;
case 12:
#line 30 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 13:
#line 31 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 14:
#line 35 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 15:
#line 36 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 20:
#line 45 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 21:
#line 46 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 22:
#line 47 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 25:
#line 56 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR de 3");}
break;
case 26:
#line 57 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 27:
#line 58 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 28:
#line 59 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 29:
#line 63 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR con condicion");}
break;
case 30:
#line 64 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 31:
#line 65 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 32:
#line 66 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 33:
#line 67 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 43:
#line 92 "gramatica.y"
{yyerror("Las variables deben estar separados por coma");}
break;
case 45:
#line 97 "gramatica.y"
{inFunction = true; hasReturn = false;}
break;
case 46:
#line 97 "gramatica.y"
{ if (!hasReturn) {
                                                                                                 	yyerror("Falta sentencia RET en la función");
                                                                                                 }
                                                                                                 inFunction = false;
                                                                                                 }
break;
case 48:
#line 102 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");}
break;
case 49:
#line 103 "gramatica.y"
{yyerror("La funcione debe tener nombre");}
break;
case 50:
#line 104 "gramatica.y"
{yyerror("La función debe tener parámetro");}
break;
case 52:
#line 109 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 59:
#line 127 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 63:
#line 138 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 64:
#line 139 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 68:
#line 146 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 69:
#line 147 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 71:
#line 152 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 72:
#line 159 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 75:
#line 162 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 78:
#line 171 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 79:
#line 172 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 80:
#line 173 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 82:
#line 178 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 83:
#line 179 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 84:
#line 180 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 86:
#line 185 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 88:
#line 190 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 90:
#line 195 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 91:
#line 196 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 92:
#line 197 "gramatica.y"
{yyerror("Falta contenido en el bloque ELSE");}
break;
case 93:
#line 198 "gramatica.y"
{yyerror("Falta contenido en el bloque THEN");}
break;
case 94:
#line 199 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 95:
#line 200 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 96:
#line 201 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 97:
#line 202 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 109:
#line 223 "gramatica.y"
{yyerror("Falta comparador en la comparación");}
break;
case 111:
#line 228 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
break;
case 112:
#line 233 "gramatica.y"
{}
break;
case 115:
#line 242 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 116:
#line 243 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 117:
#line 244 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 897 "y.tab.c"
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
