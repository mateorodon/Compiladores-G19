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
    0,    0,    0,    0,    0,    1,    1,    2,    2,    2,
    2,    3,    3,    3,    4,    4,    4,    4,    4,   13,
   13,   13,   13,   14,   14,   16,   16,   16,   16,   17,
   17,   17,   17,   17,   19,   19,    9,    9,    9,    5,
    5,   21,   21,    6,    6,   24,   25,    7,    7,    7,
    7,   22,   22,   26,   27,   27,   23,   23,   23,   28,
   28,   29,   20,   20,   20,   20,   20,   30,   30,   30,
   30,   30,   31,   31,   31,   31,   31,   31,   31,    8,
    8,    8,    8,   10,   10,   10,   10,   33,   33,   15,
   15,   15,   11,   11,   11,   11,   11,   11,   11,   11,
   35,   35,   35,   34,   34,   36,   36,   36,   36,   36,
   36,   18,   18,   18,   32,   37,   37,   12,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    3,    3,    2,    2,    1,    2,    2,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    5,
    5,    4,    4,    1,    1,    8,    7,    7,    7,   12,
   11,   11,   11,   11,    1,    1,    3,    6,    3,    1,
    1,    1,    1,    3,    1,    0,    0,   11,    9,    8,
    8,    2,    1,    3,    1,    3,    3,    1,    2,    2,
    1,    4,    3,    3,    1,    3,    3,    3,    3,    1,
    3,    3,    1,    1,    1,    4,    2,    2,    5,    6,
    6,    5,    5,    4,    4,    3,    7,    1,    1,    2,
    2,    3,    9,    7,    9,    7,    6,    6,    8,    8,
    1,    5,    2,    3,    2,    1,    1,    1,    1,    1,
    1,    3,    7,    1,    3,    3,    1,    4,    4,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,   42,   43,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   40,    0,    0,    0,    0,  114,    0,
   74,    0,    0,   75,    0,    0,    0,   70,    0,    0,
    0,    0,    0,    0,   24,   25,    4,    6,    8,    9,
   45,    0,    0,    2,   39,    0,   86,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   78,    0,
  106,  107,  108,    0,    0,  111,  110,  109,    0,    0,
    0,    1,    0,  120,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   84,    0,   85,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   66,    0,   67,    0,    0,
   71,   68,   72,   69,  118,  119,    0,    0,    0,    0,
    0,    0,    0,   23,   22,    0,    0,    0,    0,   44,
    0,    0,    0,   76,    0,    0,  101,    0,    0,    0,
    0,    0,    0,   83,    0,   82,    0,    0,    0,    0,
   21,   20,   91,   90,    0,    0,    0,    0,   52,    0,
    0,    0,    0,    0,  103,   89,    0,   88,   98,    0,
    0,    0,   79,    0,   97,   81,   80,    0,    0,  105,
   92,    0,    0,    0,    0,    0,    0,   87,    0,    0,
    0,   96,    0,   94,    0,    0,   35,   36,    0,    0,
    0,  104,   61,    0,    0,    0,   46,    0,    0,    0,
    0,   62,  100,    0,    0,  113,   99,    0,    0,    0,
    0,   51,   60,    0,   59,    0,    0,   50,  102,   95,
   93,    0,    0,    0,    0,   57,   47,   49,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   48,
   31,    0,   34,   33,   32,   30,
};
short yydgoto[] = {                                       3,
   12,  203,   14,   15,   16,   53,   17,   18,   19,   20,
   21,   22,   23,   44,  137,   45,   46,   35,  200,   36,
   24,  129,  204,  226,  244,  157,  158,  205,  138,   37,
   38,   67,  169,  150,  139,   79,   61,
};
short yysindex[] = {                                   -179,
  296,  400,    0,  -33,   35,  400,  -16, -247,    0,    0,
  -34,  345,    0,  -19,   22, -219,    0,    0,    0,    0,
    0,    0,    0,    0,  361,  166,  107, -116,    0,  -26,
    0,   59,  -95,    0,   48,  144,  123,    0,  384,  -10,
  -57, -127, -104,  114,    0,    0,    0,    0,    0,    0,
    0,  -28,  124,    0,    0,   82,    0,  136,  152,  160,
  159,  139,   -3,   -6,  -39,  144,  200,  153,    0,   -1,
    0,    0,    0,  168,  218,    0,    0,    0,   -6,  238,
  242,    0,  232,    0,  154, -172,  216,   26,  -37,  256,
  254, -246,   50,    0,   -6,    0,   -6,   44,  225,   82,
  430,   66,  -52,   64,  430,    0,  123,    0,  123,   82,
    0,    0,    0,    0,    0,    0,  -45,   78,  131,  -33,
 -157,  251,  -46,    0,    0,   -7,    0,   79,  301,    0,
  155,   82,   -6,    0, -157,  310,    0,  300, -130,  -82,
  315,  267, -119,    0, -112,    0,   59,  304,  307,  441,
    0,    0,    0,    0,  112,  333,  339,  340,    0,  116,
  349,   82,  431,   -6,    0,    0,  430,    0,    0, -173,
 -105,   -6,    0,  430,    0,    0,    0,   61,  -64,    0,
    0,  327,  392,  134,  162, -246,  392,    0,  367,  365,
 -173,    0,  323,    0,  357, -173,    0,    0, -156,  179,
  181,    0,    0,  172,  392,  385,    0,  392,    0,  177,
  188,    0,    0, -173, -173,    0,    0,  388,  196,  403,
  406,    0,    0,  411,    0,  392,  191,    0,    0,    0,
    0,  432,  -18,  433,  444,    0,    0,    0,   59,  445,
   59,   59,   59,  203,  440,   59,  446,  447,  451,    0,
    0,  452,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0, -193,    0,    0,    0,    0,    0,    0,
    0,  486,    0,  178,  193,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    1,
    0,    0,    0,    0,    0,    0,   49,    0,  491,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  163,    0,    0,  121,    0,  453,    0,    0,
    0,    0,    0,    0,    0,  453,    0,   25,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  453,
    0,    0,    0,    0,    0,    0,   73,    0,   97,  -41,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   13,    0,    0,    0,
    0,  125,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  457,    0,    0,    0,    0,
    0,  143,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  228,    0,    0,    0,  175,    0,
    0,    0,    0,    0,    0,    0,    0,  -36,    0,  -22,
  -21,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  145,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   45,  477,    0,  460,  -71,    0,    0,    0,    0,  450,
    0,    0,    0,  466,  -63,    0,    0,  313, -149,  479,
   -4, -110,  -96,    0,    0,    0,    0,    0, -131,  109,
  231,  -12,  -42,  368,  -69,  407,    0,
};
#define YYTABLESIZE 717
short yytable[] = {                                     112,
   73,  102,   86,  122,   27,   43,   27,   76,   78,   77,
  127,   92,  154,   27,   60,  156,  145,  112,   29,   28,
  128,  241,   59,   40,   77,  124,  125,    9,   10,  201,
   84,  189,   41,  155,   33,  143,   87,   51,   33,   49,
  240,   73,   73,   73,   73,   73,   25,   73,   65,  219,
   39,  206,   52,   53,  128,  206,   53,   28,  152,   73,
   73,   73,   73,   41,   63,   77,   77,   77,   77,   77,
  171,   77,   63,  224,   32,  209,  206,    1,   41,   33,
   50,  117,  166,   77,   77,   77,   77,    2,   70,   65,
  210,   65,   65,   65,  206,  168,   64,  191,   64,  120,
  175,    9,   10,   33,  196,  218,    5,   65,   65,   65,
   65,  227,    7,   63,  128,   63,   63,   63,   11,  199,
   37,  197,  198,  215,   74,  166,   75,  192,  194,  237,
   88,   63,   63,   63,   63,  167,  166,   64,  168,   64,
   64,   64,   38,  176,  177,   62,  174,   57,  213,  168,
  166,   33,   42,  217,   90,   64,   64,   64,   64,  195,
  193,   68,   12,  168,   80,  115,   69,   93,  116,   81,
   64,  230,  231,  170,  120,   33,   94,   11,   74,   37,
   75,    5,  107,  109,  135,   26,   74,    7,   75,  147,
  136,   95,   10,   11,  116,  161,   74,   74,   75,   75,
   96,   38,   97,   76,   78,   77,   71,   72,   73,  153,
   33,  144,   33,  197,  198,   54,    9,   10,   56,  120,
   27,   12,   42,  112,   26,  101,    5,   27,   91,  121,
   27,   98,    7,   27,   29,   28,  112,  112,   11,   27,
  103,   29,   28,  104,   29,   28,   30,   29,   28,  127,
   30,   31,   83,   29,   28,   31,   73,   73,   99,   73,
   73,   73,   33,  105,   73,   73,    9,   10,   73,   41,
   73,   73,  115,   73,   73,   73,   73,  118,   73,   73,
   77,   77,   33,   77,   77,   77,   33,  119,   77,   77,
   29,   30,   77,  126,   77,   77,   31,   77,   77,   77,
   77,  133,   77,   77,   65,   65,  130,   65,   65,   65,
  112,  114,   65,   65,   29,   30,   65,  134,   65,   65,
   31,   65,   65,   65,   65,  142,   65,   65,   63,   63,
  140,   63,   63,   63,  146,  159,   63,   63,  197,  198,
   63,  160,   63,   63,   65,   63,   63,   63,   63,  164,
   63,   63,   64,   64,  172,   64,   64,   64,  165,  173,
   64,   64,  179,   30,   64,  180,   64,   64,   31,   64,
   64,   64,   64,  184,   64,   64,   37,   37,  183,  185,
    9,   10,  187,  186,   37,  202,   29,   30,   37,  188,
   37,   37,   31,   37,   37,   37,   37,  216,   38,   38,
  207,   26,   71,   72,   73,  212,   38,   74,   26,   75,
   38,   26,   38,   38,   26,   38,   38,   38,   38,   12,
   26,   55,   30,  106,   30,  211,   12,   31,  208,   31,
   12,  148,   12,   12,   11,   12,   12,   12,   12,  222,
  220,   11,  221,  225,  228,   11,  232,   11,   11,   10,
   11,   11,   11,   11,   34,  229,   10,  233,  238,  178,
   10,  234,   10,   10,  235,   10,   10,   10,   10,  236,
  250,  239,  242,  108,   30,   34,   34,   13,   13,   31,
  251,   34,   13,  243,  246,    5,  253,  254,   48,   34,
    3,  255,  256,  111,   30,   58,  117,  113,   30,   31,
   55,   48,  163,   31,   56,   58,  151,  120,   89,  141,
   66,    0,  120,   34,    5,   48,    0,  121,   85,    5,
    7,    0,  121,   34,   34,    7,   11,    0,   34,   34,
   34,   11,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  100,    0,   34,    0,   34,    0,  123,  123,
    0,  245,    4,  247,  248,  249,    0,  110,  252,    5,
  123,    0,    6,    0,  123,    7,    8,    0,   34,    9,
   10,   11,    0,  131,    0,  132,    0,    0,  214,  120,
  149,  123,   34,    0,    0,    0,    5,    0,    0,  135,
    0,    0,    7,    0,  149,  136,   34,    0,   11,  123,
    0,    4,    0,    0,    0,    0,    0,    0,    5,  182,
    0,  162,   47,   34,    7,    8,    0,    4,    9,   10,
   11,   34,  182,    0,    5,    0,  123,    0,   54,    0,
    7,    8,    0,  123,    9,   10,   11,    0,    0,    0,
    4,    0,  190,    0,    0,    0,    0,    5,    4,    0,
  100,   82,  123,    7,    8,    5,    4,    9,   10,   11,
    0,    7,    8,    5,  136,    9,   10,   11,    0,    7,
    8,    0,    0,    9,   10,   11,    0,    0,    0,    0,
    0,  223,    0,    0,    0,    0,  120,  120,   34,    0,
   34,   34,   34,    5,    5,   34,  135,  120,  181,    7,
    7,    0,  136,  136,    5,   11,   11,    0,  181,    0,
    7,    0,    0,    0,    0,    0,   11,
};
short yycheck[] = {                                      41,
    0,   41,   60,   41,   41,   40,   40,   60,   61,   62,
  257,   40,   59,   40,   27,  126,   62,   59,   41,   41,
   92,   40,   27,   40,    0,   89,   90,  274,  275,  179,
   41,  163,  280,   41,   45,  105,   41,  257,   45,   59,
   59,   41,   42,   43,   44,   45,    2,   47,    0,  199,
    6,  183,  272,   41,  126,  187,   44,   91,  122,   59,
   60,   61,   62,  257,   91,   41,   42,   43,   44,   45,
  140,   47,    0,  205,   40,  186,  208,  257,  272,   45,
   59,   86,  256,   59,   60,   61,   62,  267,   41,   41,
  187,   43,   44,   45,  226,  269,    0,  167,   40,  257,
  143,  274,  275,   45,  174,  262,  264,   59,   60,   61,
   62,  208,  270,   41,  186,   43,   44,   45,  276,   59,
    0,  278,  279,  193,   43,  256,   45,  170,  171,  226,
  258,   59,   60,   61,   62,  266,  256,   41,  269,   43,
   44,   45,    0,  256,  257,  262,  266,   41,  191,  269,
  256,   45,  257,  196,   41,   59,   60,   61,   62,  172,
  266,  257,    0,  269,   42,   41,  262,   44,   44,   47,
   40,  214,  215,  256,  257,   45,   41,    0,   43,   59,
   45,  264,   74,   75,  267,   41,   43,  270,   45,   59,
  273,   40,    0,  276,   41,   41,   43,   43,   45,   45,
   41,   59,   44,   60,   61,   62,  259,  260,  261,  256,
   45,  257,   45,  278,  279,   41,  274,  275,   44,  257,
  257,   59,  257,  265,  258,  265,  264,  264,  257,  267,
  267,   93,  270,  270,  257,  257,  278,  279,  276,  276,
   41,  264,  264,   91,  267,  267,  257,  270,  270,  257,
  257,  262,  263,  276,  276,  262,  256,  257,  262,  259,
  260,  261,   45,  265,  264,  265,  274,  275,  268,  257,
  270,  271,   41,  273,  274,  275,  276,   62,  278,  279,
  256,  257,   45,  259,  260,  261,   45,  262,  264,  265,
  256,  257,  268,   40,  270,  271,  262,  273,  274,  275,
  276,  258,  278,  279,  256,  257,  257,  259,  260,  261,
   80,   81,  264,  265,  256,  257,  268,   93,  270,  271,
  262,  273,  274,  275,  276,  262,  278,  279,  256,  257,
  265,  259,  260,  261,  257,  257,  264,  265,  278,  279,
  268,   41,  270,  271,   32,  273,  274,  275,  276,   40,
  278,  279,  256,  257,   40,  259,  260,  261,   59,   93,
  264,  265,   59,  257,  268,   59,  270,  271,  262,  273,
  274,  275,  276,   41,  278,  279,  256,  257,  267,   41,
  274,  275,  267,   44,  264,   59,  256,  257,  268,   41,
  270,  271,  262,  273,  274,  275,  276,   41,  256,  257,
  267,  257,  259,  260,  261,   41,  264,   43,  264,   45,
  268,  267,  270,  271,  270,  273,  274,  275,  276,  257,
  276,  256,  257,  256,  257,   59,  264,  262,  267,  262,
  268,  119,  270,  271,  257,  273,  274,  275,  276,  268,
  262,  264,  262,   59,  268,  268,   59,  270,  271,  257,
  273,  274,  275,  276,    5,  268,  264,  262,  268,  147,
  268,   59,  270,  271,   59,  273,  274,  275,  276,   59,
  268,   40,   40,  256,  257,   26,   27,    1,    2,  262,
   41,   32,    6,   40,   40,    0,   41,   41,   12,   40,
    0,   41,   41,  256,  257,  268,   44,  256,  257,  262,
   44,   25,  135,  262,   26,   27,  256,  257,   43,  103,
   32,   -1,  257,   64,  264,   39,   -1,  267,   40,  264,
  270,   -1,  267,   74,   75,  270,  276,   -1,   79,   80,
   81,  276,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   64,   -1,   95,   -1,   97,   -1,   89,   90,
   -1,  239,  257,  241,  242,  243,   -1,   79,  246,  264,
  101,   -1,  267,   -1,  105,  270,  271,   -1,  119,  274,
  275,  276,   -1,   95,   -1,   97,   -1,   -1,  256,  257,
  121,  122,  133,   -1,   -1,   -1,  264,   -1,   -1,  267,
   -1,   -1,  270,   -1,  135,  273,  147,   -1,  276,  140,
   -1,  257,   -1,   -1,   -1,   -1,   -1,   -1,  264,  150,
   -1,  133,  268,  164,  270,  271,   -1,  257,  274,  275,
  276,  172,  163,   -1,  264,   -1,  167,   -1,  268,   -1,
  270,  271,   -1,  174,  274,  275,  276,   -1,   -1,   -1,
  257,   -1,  164,   -1,   -1,   -1,   -1,  264,  257,   -1,
  172,  268,  193,  270,  271,  264,  257,  274,  275,  276,
   -1,  270,  271,  264,  273,  274,  275,  276,   -1,  270,
  271,   -1,   -1,  274,  275,  276,   -1,   -1,   -1,   -1,
   -1,  205,   -1,   -1,   -1,   -1,  257,  257,  239,   -1,
  241,  242,  243,  264,  264,  246,  267,  257,  268,  270,
  270,   -1,  273,  273,  264,  276,  276,   -1,  268,   -1,
  270,   -1,   -1,   -1,   -1,   -1,  276,
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
"programa : ID list_sentencias",
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
"asignacion : ID ASIGNACION error",
"tipo : tipo_base",
"tipo : ID",
"tipo_base : ULONGINT",
"tipo_base : SINGLE",
"list_variables : list_variables ',' ID",
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
"cuerpo_funcion : list_sentencias_funcion sentencia_return ';'",
"cuerpo_funcion : list_sentencias_funcion",
"cuerpo_funcion : sentencia_return ';'",
"list_sentencias_funcion : list_sentencias_funcion sentencia",
"list_sentencias_funcion : sentencia",
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
"condicion : expresion comparacion expresion",
"condicion : '(' bloque_list_expresiones ')' comparacion '(' bloque_list_expresiones ')'",
"condicion : error",
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
#line 255 "gramatica.y"
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

#line 508 "y.tab.c"
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
{yyerror("Faltan los delimitadores del programa");}
break;
case 10:
#line 25 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
#line 26 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 12:
#line 30 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
break;
case 13:
#line 31 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
#line 32 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
#line 36 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 16:
#line 37 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 21:
#line 46 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
#line 47 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
#line 48 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 26:
#line 57 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR de 3");}
break;
case 27:
#line 58 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
#line 59 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 29:
#line 60 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 30:
#line 64 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un FOR con condicion");}
break;
case 31:
#line 65 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 32:
#line 66 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 33:
#line 67 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 34:
#line 68 "gramatica.y"
{yyerror("Falta ; en el FOR");}
break;
case 39:
#line 79 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 46:
#line 98 "gramatica.y"
{inFunction = true; hasReturn = false;}
break;
case 47:
#line 98 "gramatica.y"
{ if (!hasReturn) {
                                                                                                 	yyerror("Falta sentencia RET en la función");
                                                                                                 }
                                                                                                 inFunction = false;
                                                                                                 }
break;
case 49:
#line 103 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");}
break;
case 50:
#line 104 "gramatica.y"
{yyerror("La funcione debe tener nombre");}
break;
case 51:
#line 105 "gramatica.y"
{yyerror("La función debe tener parámetro");}
break;
case 53:
#line 110 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 62:
#line 134 "gramatica.y"
{if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 66:
#line 145 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 67:
#line 146 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
#line 153 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 72:
#line 154 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 74:
#line 159 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
break;
case 75:
#line 166 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 78:
#line 169 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 81:
#line 178 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 82:
#line 179 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 83:
#line 180 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 85:
#line 185 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 86:
#line 186 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 87:
#line 187 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 89:
#line 192 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 91:
#line 197 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 93:
#line 202 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
break;
case 94:
#line 203 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
break;
case 95:
#line 204 "gramatica.y"
{yyerror("Falta contenido en el bloque ELSE");}
break;
case 96:
#line 205 "gramatica.y"
{yyerror("Falta contenido en el bloque THEN");}
break;
case 97:
#line 206 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 98:
#line 207 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 99:
#line 208 "gramatica.y"
{yyerror("Falta paréntesis '(' en la condición del IF");}
break;
case 100:
#line 209 "gramatica.y"
{yyerror("Falta paréntesis ')' en la condición del IF");}
break;
case 113:
#line 234 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
break;
case 114:
#line 235 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 118:
#line 249 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 119:
#line 250 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 120:
#line 251 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 905 "y.tab.c"
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
