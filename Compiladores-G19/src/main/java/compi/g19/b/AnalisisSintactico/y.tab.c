#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package compi.g19.b.AnalisisSintactico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import compi.g19.a.AnalisisLexico.*;
import compi.g19.c.GeneracionDeCodigo.*;
#line 14 "y.tab.c"
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
   13,   13,   13,   14,   14,   16,   16,   16,   16,   16,
   17,   17,   17,   17,   17,   19,   19,    9,    9,    9,
    5,    5,   21,   21,    6,    6,    6,   22,   22,   25,
    7,    7,    7,   23,   23,   26,   27,   27,   24,   24,
   24,   24,   28,   28,   29,   20,   20,   20,   20,   20,
   30,   30,   30,   30,   30,   31,   31,   31,   31,   31,
   31,   31,    8,    8,    8,    8,    8,    8,   10,   10,
   10,   10,   33,   33,   15,   15,   15,   35,   11,   11,
   11,   11,   11,   11,   36,   36,   37,   37,   37,   37,
   34,   34,   38,   38,   38,   38,   38,   38,   18,   18,
   18,   32,   39,   39,   39,   12,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    3,    3,    2,    2,    1,    2,    2,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    5,
    5,    4,    4,    1,    1,    8,    7,    7,    7,    7,
   12,   11,   11,   11,   10,    1,    1,    3,    6,    3,
    1,    1,    1,    1,    3,    2,    1,    3,    2,    0,
    8,    7,    6,    2,    1,    3,    1,    3,    3,    1,
    2,    0,    2,    1,    4,    3,    3,    1,    3,    3,
    3,    3,    1,    3,    3,    1,    1,    1,    4,    2,
    2,    5,    6,    6,    5,    5,    4,    5,    4,    4,
    3,    7,    1,    1,    2,    3,    2,    1,    7,    7,
    9,    9,    9,    9,    2,    2,    3,    2,    2,    1,
    3,    2,    1,    1,    1,    1,    1,    1,    3,    7,
    1,    3,    3,    1,    1,    4,    4,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,   98,    0,    0,    0,   43,   44,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    4,
    6,    8,    9,   47,    0,    0,    0,    0,    2,   40,
    0,   77,    0,   78,    0,    0,   73,  125,   91,    0,
    0,    0,    0,    0,    1,    0,  128,    0,    0,    0,
    0,    0,    0,    0,   48,   46,    0,    0,    0,    0,
    0,    0,    0,  121,    0,    0,    0,    0,    0,   81,
    0,    0,    0,    0,   89,    0,   90,    0,    0,  126,
  127,    0,   87,    0,    0,    0,    0,    0,    0,    0,
   23,   22,   45,    0,   54,    0,    0,    0,    0,    0,
    0,  113,  114,  115,  118,  117,  116,    0,    0,    0,
   69,    0,   70,    0,   74,   71,   75,   72,    0,    0,
    0,   86,    0,   85,   88,    0,    0,   97,    0,    0,
   21,   20,   95,    0,   64,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   79,    0,    0,    0,   84,   83,
    0,    0,  112,   96,    0,    0,   53,   63,    0,   61,
   50,    0,    0,  110,    0,    0,    0,    0,    0,    0,
   82,   92,   36,   37,    0,    0,    0,  111,    0,   59,
    0,   52,    0,  108,    0,    0,  106,  109,   94,    0,
   93,   99,    0,  100,    0,    0,    0,    0,   65,   51,
    0,  107,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  120,  101,  103,  104,  102,    0,    0,    0,    0,
    0,    0,    0,   35,    0,    0,   32,    0,   34,   33,
   31,
};
short yydgoto[] = {                                       3,
   12,   13,   14,   15,   16,   46,   17,   18,   19,   54,
   21,   22,   23,   37,  111,   38,   39,   86,  196,   87,
   24,   25,   81,  156,  201,   82,   83,  157,  158,   56,
   57,   62,  212,  188,   26,  189,  190,  128,   63,
};
short yysindex[] = {                                   -117,
  287,  319,    0,  -32,    0,  319,  -21,  -57,    0,    0,
   -5,  303,    0,   -3,    5, -154,    0,    0,    0,    0,
    0,    0,    0,    0,   37,   61,  328,  103,   -7, -229,
  350,  -15,   12, -118, -116, -152,  108,    0,    0,    0,
    0,    0,    0,    0,  -81,    7,   16,   57,    0,    0,
  -17,    0, -182,    0,  156,   79,    0,    0,    0,  145,
  140,  144,  152,  107,    0,  161,    0,  172, -118,  -53,
  146,  -56,  -37,  -73,    0,    0,  -43,    0,  -51,   -1,
  184,  218,  222,    0,  126,  229,  117,   27,  191,    0,
  138,  162,  164,  208,    0,  113,    0,  113,   35,    0,
    0,  -52,    0,   21,   39,  -38,  -32, -129,  249,  242,
    0,    0,    0,  371,    0,   38,   45, -175,  156,  275,
   59,    0,    0,    0,    0,    0,    0,  113,  235,   73,
    0,   79,    0,   79,    0,    0,    0,    0,  356,  156,
  113,    0,  -84,    0,    0,   57,  280,    0,  283,  216,
    0,    0,    0,  307,    0,   83,  371,  299,  371,  371,
    0,  -49,  251,  156,    0,  281,  321,  156,    0,    0,
   58,   31,    0,    0,  320,  113,    0,    0,  322,    0,
    0,  125,  345,    0,  272,  363,  366,  269, -144, -105,
    0,    0,    0,    0, -183,  166,  177,    0,  361,    0,
  175,    0,  126,    0,  386,    0,    0,    0,    0,  251,
    0,    0,  251,    0,  381,  -26,  382,  387,    0,    0,
  413,    0, -217, -217, -217, -217,  427,  409,   57,  431,
  443,    0,    0,    0,    0,    0,   57,  447,  449,   57,
   57,  455,   57,    0,  456,  457,    0,  458,    0,    0,
    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0, -153,    0,    0,    0,    0,    0,    0,
    0,  488,    0,  159,  174,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  502,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  463,  187,    0,    0,    0,    0,
    1,    0,    0,    0,  116,   47,    0,    0,    0,  466,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -12,    0,    0,
  470,    0,    0,    0,    0,    0,    0,    0,   24,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  255,    0,    0,    0,    0,  466,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   70,    0,   93,    0,    0,    0,    0,    0,   32,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  262,    0,  255,  255,
  122,    0,    0,  -41,    0,    0,    0,  139,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  225,    0,    0,    0,    0,
    0,    0,    0,    0,  -36,  -35,  -13,  141,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  202,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
short yygindex[] = {                                      0,
   34,   10,    0,  403,  -31,    0,    0,    0,    0,  473,
    0,    0,    0,  481,  -54,    0,    0,  -48, -145,  424,
   20,    0,  414,  173,    0,    0,    0,    0, -132,  264,
  343,  -70,  -80,  -91,    0,  -90,  -45,  369,    0,
};
#define YYTABLESIZE 686
short yytable[] = {                                     119,
   76,   85,   34,  109,   27,   30,   53,   29,  104,  143,
  125,  127,  126,  229,  120,   80,  150,  119,   32,  112,
  146,   41,   29,   80,  179,   67,  197,   29,   55,   53,
  187,   55,   64,   59,   36,   27,   41,   53,  209,   31,
   41,   76,   76,   76,   76,   76,   68,   76,   61,  216,
   77,  211,   70,   71,  152,   42,   79,  147,   30,   76,
   76,   76,   76,   43,   80,   80,   80,   80,   80,   66,
   80,   69,  122,   88,   89,  123,   47,  187,  215,   90,
  187,   78,   80,   80,   80,   80,   80,   68,  102,   68,
   68,   68,   67,  205,  193,  194,   85,  171,    9,   10,
   48,   53,   44,   42,   35,   68,   68,   68,   68,  214,
   66,  209,   66,   66,   66,   38,  195,   45,   42,  223,
   93,  210,  225,  155,  211,   94,  148,  107,   66,   66,
   66,   66,  221,   67,    5,   67,   67,   67,   39,    1,
    7,   72,  233,  234,  235,  236,   11,   53,   74,    2,
  209,   67,   67,   67,   67,    9,   10,   53,   11,   91,
  213,   92,   56,  211,  224,   58,  178,  226,  155,  155,
   53,  169,  170,   10,   38,   75,  125,  127,  126,   96,
  239,   28,   53,  107,   97,   95,   12,   91,  242,   92,
    5,  245,  246,  108,  248,   98,    7,   39,   91,   99,
   92,  100,   11,  103,  142,  106,   53,  105,   53,  122,
  123,  124,  101,  113,   91,  114,   92,   84,   51,  107,
   27,   30,   33,   52,  116,   28,    5,   27,   30,  108,
   27,   30,    7,   27,   30,  228,  119,  119,   11,   27,
   30,   51,   26,   29,   42,   12,   52,   66,   58,   51,
   29,   35,   53,   29,   52,  115,   29,   76,  117,   76,
   76,   76,   29,   76,   76,  118,    9,   10,   76,  121,
   76,   76,   78,   76,   76,   76,   76,  144,   76,   76,
   80,  130,   80,   80,   80,    9,   10,   80,  129,    9,
   10,   80,  141,   80,   80,  145,   80,   80,   80,   80,
  153,   80,   80,   68,  159,   68,   68,   68,  193,  194,
   68,  160,   84,   51,   68,  162,   68,   68,   52,   68,
   68,   68,   68,  163,   68,   68,   66,  165,   66,   66,
   66,  181,  182,   66,  166,  193,  194,   66,  172,   66,
   66,  173,   66,   66,   66,   66,  176,   66,   66,   67,
  177,   67,   67,   67,  132,  134,   67,  180,   50,   51,
   67,  192,   67,   67,   52,   67,   67,   67,   67,   51,
   67,   67,   38,  191,   52,  122,  123,  124,  198,   38,
  200,   58,   51,   38,  203,   38,   38,   52,   38,   38,
   38,   38,  202,  131,   51,   39,  167,   28,   91,   52,
   92,  219,   39,   91,   28,   92,   39,   28,   39,   39,
   28,   39,   39,   39,   39,   11,   28,  133,   51,  135,
   51,  206,   11,   52,  207,   52,   11,  217,   11,   11,
   10,   11,   11,   11,   11,  136,  138,   10,  218,  227,
  230,   10,  220,   10,   10,  231,   10,   10,   10,   10,
   12,   55,   60,  232,   12,   68,   12,   12,   26,   12,
   12,   12,   12,  137,   51,   26,  237,  238,   26,   52,
  240,   26,  107,   20,   20,  110,  110,   26,   20,    5,
  105,  112,  241,  174,   20,    7,  243,    5,  112,  244,
  105,   11,  112,  105,  112,  247,  249,  250,  251,   20,
  112,    3,   49,   20,  151,  107,  184,  107,  119,  124,
  149,  110,    5,   57,    5,  108,   73,  185,    7,  139,
    7,  140,   62,  154,   11,  107,   11,  204,  107,   60,
  183,  161,    5,    0,    0,    5,  208,    0,    7,    0,
    0,    7,    0,    4,   11,   20,   20,   11,    0,    0,
    5,  164,  175,    6,    0,    0,    7,    8,    0,    4,
    9,   10,   11,    0,  168,  186,    5,    0,    0,    0,
   40,    0,    7,    8,    0,    4,    9,   10,   11,    0,
   20,   20,    5,    0,    4,    0,   20,  149,    7,    8,
  175,    5,    9,   10,   11,   49,    0,    7,    8,  199,
    0,    9,   10,   11,    0,    0,    4,  175,    0,    0,
    0,    0,  186,    5,    0,  186,    0,   65,    0,    7,
    8,    0,   20,    9,   10,   11,  119,    4,    0,   20,
    0,   20,   20,    0,    5,   20,    0,    0,    0,    0,
    7,    8,  107,  154,    9,   10,   11,    0,    0,    5,
    0,    0,    0,  222,    0,    7,    0,   20,    0,    0,
   20,   11,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   20,    0,    0,
    0,    0,   20,    0,    0,   20,
};
short yycheck[] = {                                      41,
    0,   40,   60,   41,   41,   41,   45,   40,   62,   62,
   60,   61,   62,   40,   85,   47,  108,   59,   40,   74,
   59,   12,   40,    0,  157,   41,  172,   41,   41,   45,
  163,   44,  262,   41,   40,    2,   27,   45,  256,    6,
   31,   41,   42,   43,   44,   45,    0,   47,   29,  195,
   44,  269,   33,   34,  109,   59,   41,  106,   91,   59,
   60,   61,   62,   59,   41,   42,   43,   44,   45,    0,
   47,   60,   41,   91,  257,   44,   40,  210,  262,  262,
  213,  257,   59,   60,   61,   62,  118,   41,   69,   43,
   44,   45,    0,  185,  278,  279,   40,  146,  274,  275,
   40,   45,  257,  257,  257,   59,   60,   61,   62,  190,
   41,  256,   43,   44,   45,    0,   59,  272,  272,  210,
   42,  266,  213,  114,  269,   47,  256,  257,   59,   60,
   61,   62,  203,   41,  264,   43,   44,   45,    0,  257,
  270,  258,  223,  224,  225,  226,  276,   45,   41,  267,
  256,   59,   60,   61,   62,  274,  275,   45,    0,   43,
  266,   45,   41,  269,  210,   44,  157,  213,  159,  160,
   45,  256,  257,    0,   59,  257,   60,   61,   62,   40,
  229,   41,   45,  257,   41,   41,    0,   43,  237,   45,
  264,  240,  241,  267,  243,   44,  270,   59,   43,   93,
   45,   41,  276,  257,  257,  262,   45,   62,   45,  259,
  260,  261,   41,  257,   43,  267,   45,  256,  257,  257,
  257,  257,  280,  262,   41,  258,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  262,  278,  279,  276,  276,
  276,  257,   41,  257,  257,   59,  262,  263,  256,  257,
  264,  257,   45,  267,  262,  257,  270,  257,   41,  259,
  260,  261,  276,  257,  264,   44,  274,  275,  268,   41,
  270,  271,  257,  273,  274,  275,  276,  257,  278,  279,
  257,   91,  259,  260,  261,  274,  275,  264,  262,  274,
  275,  268,  258,  270,  271,  257,  273,  274,  275,  276,
   59,  278,  279,  257,  267,  259,  260,  261,  278,  279,
  264,  267,  256,  257,  268,   41,  270,  271,  262,  273,
  274,  275,  276,  265,  278,  279,  257,   93,  259,  260,
  261,  159,  160,  264,  262,  278,  279,  268,   59,  270,
  271,   59,  273,  274,  275,  276,   40,  278,  279,  257,
  268,  259,  260,  261,   91,   92,  264,   59,  256,  257,
  268,   41,  270,  271,  262,  273,  274,  275,  276,  257,
  278,  279,  257,   93,  262,  259,  260,  261,   59,  264,
   59,  256,  257,  268,   40,  270,  271,  262,  273,  274,
  275,  276,  268,  256,  257,  257,   41,  257,   43,  262,
   45,   41,  264,   43,  264,   45,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  256,  257,  256,
  257,   59,  264,  262,   59,  262,  268,  262,  270,  271,
  257,  273,  274,  275,  276,   93,   94,  264,  262,   59,
   59,  268,  268,  270,  271,   59,  273,  274,  275,  276,
  264,   28,   29,   41,  268,   32,  270,  271,  257,  273,
  274,  275,  276,  256,  257,  264,   40,   59,  267,  262,
   40,  270,  257,    1,    2,   73,   74,  276,    6,  264,
  256,  257,   40,  268,   12,  270,   40,    0,  264,   41,
  266,  276,  268,  269,  270,   41,   41,   41,   41,   27,
  276,    0,   40,   31,  256,  257,  256,  257,   85,   44,
  108,  109,  264,   44,  264,  267,   36,  267,  270,   96,
  270,   98,  268,  273,  276,  257,  276,  256,  257,  268,
  162,  118,  264,   -1,   -1,  264,  268,   -1,  270,   -1,
   -1,  270,   -1,  257,  276,   73,   74,  276,   -1,   -1,
  264,  128,  150,  267,   -1,   -1,  270,  271,   -1,  257,
  274,  275,  276,   -1,  141,  163,  264,   -1,   -1,   -1,
  268,   -1,  270,  271,   -1,  257,  274,  275,  276,   -1,
  108,  109,  264,   -1,  257,   -1,  114,  185,  270,  271,
  188,  264,  274,  275,  276,  268,   -1,  270,  271,  176,
   -1,  274,  275,  276,   -1,   -1,  257,  205,   -1,   -1,
   -1,   -1,  210,  264,   -1,  213,   -1,  268,   -1,  270,
  271,   -1,  150,  274,  275,  276,  203,  257,   -1,  157,
   -1,  159,  160,   -1,  264,  163,   -1,   -1,   -1,   -1,
  270,  271,  257,  273,  274,  275,  276,   -1,   -1,  264,
   -1,   -1,   -1,  268,   -1,  270,   -1,  185,   -1,   -1,
  188,  276,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  205,   -1,   -1,
   -1,   -1,  210,   -1,   -1,  213,
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
"encabezado_for1 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : ID ASIGNACION CONSTANTE ';' condicion ';' up_down '(' condicion ')'",
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
"list_variables : list_variables ID",
"list_variables : ID",
"encabezado_funcion : tipo FUN ID",
"encabezado_funcion : tipo FUN",
"$$1 :",
"declaracion_funcion : encabezado_funcion '(' parametro ')' BEGIN cuerpo_funcion $$1 END",
"declaracion_funcion : encabezado_funcion '(' bloque_list_parametro ')' BEGIN cuerpo_funcion END",
"declaracion_funcion : encabezado_funcion '(' ')' BEGIN cuerpo_funcion END",
"parametro : tipo ID",
"parametro : ID",
"bloque_list_parametro : list_parametro ',' parametro",
"list_parametro : parametro",
"list_parametro : list_parametro ',' parametro",
"cuerpo_funcion : list_sentencias_funcion sentencia_return ';'",
"cuerpo_funcion : list_sentencias_funcion",
"cuerpo_funcion : sentencia_return ';'",
"cuerpo_funcion :",
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
"declaracion_tipo : TYPEDEF TRIPLE tipo_base ID",
"declaracion_tipo : TYPEDEF '<' tipo_base '>' ID",
"invocacion_funcion : ID '(' expresion ')'",
"invocacion_funcion : ID '(' bloque_list_expresiones ')'",
"invocacion_funcion : ID '(' ')'",
"invocacion_funcion : ID '(' tipo_base '(' expresion ')' ')'",
"fin_if : END_IF",
"fin_if : error",
"bloque_sentencias_ejecutables : sentencia_ejecutable ';'",
"bloque_sentencias_ejecutables : BEGIN list_sentencias_ejecutables END",
"bloque_sentencias_ejecutables : BEGIN error",
"encabezado_if : IF",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_bloque fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_bloque fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_unico fin_if",
"cuerpo_if_unico : sentencia_ejecutable ';'",
"cuerpo_if_unico : sentencia_return ';'",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables END",
"cuerpo_if_bloque : BEGIN error",
"cuerpo_if_bloque : list_sentencias_ejecutables END",
"cuerpo_if_bloque : error",
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
"list_expresiones : error",
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
#line 446 "gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;

static NodoComun raiz;
static String ambito = "main";
static boolean inIF = false;
static boolean hasReturn = false;
static List<String> varDeclaradas = new ArrayList<>();
static String tipoActual;
static List<String> erroresSemanticos = new ArrayList<>();

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

public void addAmbito(String ambitoActual){
    ambito = ambito.concat(":" + ambitoActual);
}

public void removeAmbito(){
        int index = ambito.lastIndexOf(':');

        if (index != -1) {
            ambito = ambito.substring(0, index);
        }
}

private void chequeoFlotantesPositivos(String lexema){
    float valor = Float.parseFloat(lexema);
    if  ((valor != 0f) && (valor < AccionSemantica.SINGLE_POSITIVE_MIN || valor >= Float.POSITIVE_INFINITY)) {
        yyerror("Constante flotante fuera de rango");
    }
}

private boolean hayErrores(String lexema){
    return !erroresSemanticos.isEmpty();
}

public String buscarAmbito(String ambitoActual, String lexema) {
    String ambito = ambitoActual;

    while (!TablaSimbolos.existeSimbolo(lexema + ":" + ambito)) {
        if (ambito.equals("main")) {
            return "";
        }
        int index = ambito.lastIndexOf(':');
        if (index == -1) {
            return "";
        }

        ambito = ambito.substring(0, index); // Reduce el ámbito
    }
    
    return ambito;
}

public static void agregarErrorSemantico(String error){
    erroresSemanticos.add(error + " en la linea " + AnalizadorLexico.lineaAct);
}

public static void imprimirErroresSemanticos(){
    for (String e : erroresSemanticos)
        System.out.println(e);
}

private void variableYaDeclarada(String var){
    Token t1 = TablaSimbolos.getToken(var + ":" + ambito);
    switch (t1.getUso()) {
        case "variable":
            agregarErrorSemantico("Ya existe una variable con el nombre '" + var + "' definida en este ámbito");
            break;
        case "funcion":
            agregarErrorSemantico("Ya existe una función con el nombre '" + var + "' definida en este ámbito");
            break;
        case "tipo":
            agregarErrorSemantico("Ya existe un tipo con el nombre '" + var + "' definido en este ámbito");
            break;
        default:
            break;
    }
}

public NodoComun getRaiz(){
    return this.raiz;
}
#line 585 "y.tab.c"
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
#line 18 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa"); raiz = new NodoComun("PROGRAMA", (Nodo)yyvsp[-1].obj);}
break;
case 2:
#line 19 "gramatica.y"
{yyerror("El programa debe tener un nombre");}
break;
case 3:
#line 20 "gramatica.y"
{yyerror("Falta delimitador END del programa");}
break;
case 4:
#line 21 "gramatica.y"
{yyerror("Falta delimitador BEGIN del programa");}
break;
case 5:
#line 22 "gramatica.y"
{yyerror("Faltan los delimitadores del programa");}
break;
case 6:
#line 25 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo)yyvsp[-1].obj, (Nodo)yyvsp[0].obj);}
break;
case 7:
#line 26 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 8:
#line 30 "gramatica.y"
{yyval= new NodoHoja("Sentencia Declarativa");}
break;
case 9:
#line 31 "gramatica.y"
{yyval.obj=yyvsp[-1].obj;}
break;
case 10:
#line 32 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
#line 33 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 12:
#line 37 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");
                         for (String var: varDeclaradas){
                            Token t = TablaSimbolos.getToken(var);
                            if (!TablaSimbolos.existeSimbolo(var + ":" + ambito)){
                                t.getLexema().setLength(0);
                                t.getLexema().append(var).append(":").append(ambito);
                                t.setAmbito(ambito);
                                t.setUso("variable");
                                t.setTipo(tipoActual);
                                TablaSimbolos.removeToken(var);
                                TablaSimbolos.addSimbolo(t.getLexema().toString(),t);

                            }
                            else {
                                TablaSimbolos.removeToken(var);
                                variableYaDeclarada(var);
                                }
                         }
                         varDeclaradas = new ArrayList<>();
                        }
break;
case 13:
#line 57 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
#line 58 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
#line 62 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
break;
case 16:
#line 63 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 18:
#line 65 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 20:
#line 71 "gramatica.y"
{ yyval = new NodoComun("FOR",(Nodo)yyvsp[-2].obj,(Nodo)yyvsp[0].obj);}
break;
case 21:
#line 72 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
#line 73 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
#line 74 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 24:
#line 78 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 25:
#line 79 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 26:
#line 83 "gramatica.y"
{  String ambitoVar = buscarAmbito(ambito,yyvsp[-7].sval);
                                                                   NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                   if (ambitoVar.equals(""))
                                                                       agregarErrorSemantico("La variable '" + yyvsp[-7].sval + "' no fue declarada");
                                                                       idAsignacion = new NodoHoja("error semantico"); ??
                                                                   else {
                                                                       Token t = TablaSimbolos.getToken(yyvsp[-7].sval + ":" + ambitoVar);
                                                                       if (!t.getTipo().equals("ENTERO"))
                                                                           agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                           idAsignacion = new NodoHoja("error semantico"); ??
                                                                       else {
                                                                           idAsignacion = new NodoHoja(yyvsp[-7].sval + ":" + ambitoVar);
                                                                       }
                                                                   }

                                                                    NodoComun asignacion = new NodoComun("ASIGNACION", idAsignacion, (Nodo)yyvsp[-5].sval);
                                                                    NodoComun incremento = new NodoComun("INCREMENTO", (Nodo)yyvsp[-1].obj, (Nodo)yyvsp[0].sval);
                                                                    NodoComun condicion = (Nodo)yyvsp[-3].obj;

                                                                    NodoComun asgnacionIncremento = new NodoComun("ASIGNACION E INCREMENTO", asignacion, incremento);

                                                                    yyval.obj = new NodoComun ("ENCABEZADO FOR", asgnacionIncremento, condicion);

                                                                    AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");
                                                                }
break;
case 27:
#line 108 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
#line 109 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
#line 110 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
#line 111 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
#line 115 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[-11].sval);
                                                                                       NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                                       if (ambitoVar.equals(""))
                                                                                            agregarErrorSemantico("La variable '" + yyvsp[-11].sval + "' no fue declarada");
                                                                                            idAsignacion = new NodoHoja("error semantico"); ??
                                                                                       else {
                                                                                             Token t = TablaSimbolos.getToken(yyvsp[-11].sval + ":" + ambitoVar);
                                                                                             if (!t.getTipo().equals("ENTERO"))
                                                                                                    agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                                                    idAsignacion = new NodoHoja("error semantico"); ??
                                                                                             else {
                                                                                                    idAsignacion = new NodoHoja(yyvsp[-11].sval + ":" + ambitoVar);
                                                                                             }
                                                                                       }

                                                                                       NodoComun asignacion = new NodoComun("ASIGNACION", idAsignacion, (Nodo)yyvsp[-9].sval);
                                                                                       NodoComun incremento = new NodoComun("INCREMENTO", (Nodo)yyvsp[-5].obj, (Nodo)yyvsp[-4].sval);
                                                                                       NodoComun condicion = (Nodo)yyvsp[-7].obj;
                                                                                       NodoComun iteradorCondicion = (Nodo)yyvsp[-1].obj;

                                                                                       NodoComun asgnacionIncremento = new NodoComun("ASIGNACION E INCREMENTO", asignacion, incremento);
                                                                                       NodoComun condiciones = new NodoComun("ASIGNACION E INCREMENTO", condicion, iteradorCondicion);

                                                                                       yyval.obj = new NodoComun ("ENCABEZADO FOR", asgnacionIncremento, condiciones);

                                                                                       AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");
                                                                                       }
break;
case 32:
#line 143 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
#line 144 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
#line 145 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
#line 146 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 36:
#line 150 "gramatica.y"
{yyval.obj = new NodoHoja("UP");}
break;
case 37:
#line 151 "gramatica.y"
{yyval.obj = new NodoHoja("DOWN");}
break;
case 38:
#line 155 "gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,yyvsp[-2].sval);
                              if (ambitoVar.equals(""))
                                  agregarErrorSemantico("La variable '" + yyvsp[-2].sval + "' no fue declarada");
                              else {
                                  Token t = TablaSimbolos.getToken(yyvsp[-2].sval + ":" + ambitoVar);
                                  if (!t.getUso().equals("variable"))
                                    agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")" );
                                    /*new NodoHoja("error semantico"); ??*/
                                  else {
                                    NodoHoja id = new NodoHoja(yyvsp[-2].sval + ":" + ambitoVar);

                                  }
                              }
                            }
break;
case 40:
#line 170 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 42:
#line 175 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval + ":" + ambito);
            if (t!= null){
                if (t.getUso() == null || !t.getUso().equals("tipo"))
                    yyerror("El identificador '" + yyvsp[0].sval + "' no es un tipo definido");
            }
            else {
                yyerror("El identificador '" + yyvsp[0].sval + "' no es un tipo definido");}
            tipoActual = yyvsp[0].sval;
            }
break;
case 43:
#line 187 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 44:
#line 188 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 45:
#line 192 "gramatica.y"
{varDeclaradas.add(yyvsp[0].sval);}
break;
case 46:
#line 193 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 47:
#line 194 "gramatica.y"
{varDeclaradas.add(yyvsp[0].sval);}
break;
case 48:
#line 198 "gramatica.y"
{hasReturn = false;
                String idFuncion = yyvsp[0].sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (!TablaSimbolos.existeSimbolo(idFuncion + ":" + ambito)){
                    t.getLexema().setLength(0);
                    t.getLexema().append(idFuncion).append(":").append(ambito);
                    t.setAmbito(ambito);
                    t.setUso("funcion");
                    t.setTipo(tipoActual);
                    TablaSimbolos.removeToken(idFuncion);
                    TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                 }
                 else {
                    TablaSimbolos.removeToken(idFuncion);
                    variableYaDeclarada(idFuncion);
                 }
                 addAmbito(idFuncion);
                 }
break;
case 49:
#line 216 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 50:
#line 220 "gramatica.y"
{ if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         removeAmbito();
                                                         }
break;
case 52:
#line 225 "gramatica.y"
{yyerror("La funcione no puede tener más de un parámetro");removeAmbito();}
break;
case 53:
#line 226 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 55:
#line 231 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 62:
#line 247 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio");}
break;
case 65:
#line 258 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           if (!inIF){
                                hasReturn = true;
                           }
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 66:
#line 268 "gramatica.y"
{
                            }
break;
case 69:
#line 272 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 70:
#line 273 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 73:
#line 279 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 74:
#line 280 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 75:
#line 281 "gramatica.y"
{yyerror("Se esperaba un factor");}
break;
case 76:
#line 285 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[0].sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La variable '" + yyvsp[0].sval + "' no fue declarada");
            yyval = new NodoHoja("error");
        }
        else {
            Token t = TablaSimbolos.getToken(yyvsp[0].sval + ":" + ambitoVar);
            if (!t.getUso().equals("variable"))
                agregarErrorSemantico("'" + yyvsp[0].sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                yyval = new NodoHoja(yyvsp[0].sval + ":" + ambitoVar);
                TablaSimbolos.removeToken(yyvsp[0].sval);
            }
        }
        }
break;
case 77:
#line 300 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                if (t != null && (t.getTipo().equals(FLOTANTE))) {
                    String lexema = t.getLexema().toString();
                    chequeoFlotantesPositivos(lexema);
                    yyval = new NodoHoja(yyvsp[0].sval);
                }
                else
                    yyval = new NodoHoja("error");
                }
break;
case 78:
#line 309 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 81:
#line 312 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
break;
case 83:
#line 320 "gramatica.y"
{String idTipo = yyvsp[0].sval;
                                         Token t = TablaSimbolos.getToken(idTipo);
                                         if (!TablaSimbolos.existeSimbolo(idTipo + ":" + ambito)){
                                            t.getLexema().setLength(0);
                                            t.getLexema().append(idTipo).append(":").append(ambito);
                                            t.setAmbito(ambito);
                                            t.setUso("tipo");
                                            t.setTipo("triple");
                                            TablaSimbolos.removeToken(idTipo);
                                            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                            }
                                         else {
                                            TablaSimbolos.removeToken(idTipo);
                                            variableYaDeclarada(idTipo);
                                         }
                                         }
break;
case 84:
#line 336 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 85:
#line 337 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 86:
#line 338 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 87:
#line 339 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 88:
#line 340 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 90:
#line 345 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 91:
#line 346 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 92:
#line 347 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 94:
#line 352 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 97:
#line 358 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 98:
#line 362 "gramatica.y"
{inIF=true; yyval=yyvsp[0];}
break;
case 99:
#line 366 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-1].obj);
                                                                                                                                              Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                              yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-4].obj, cuerpo);}
break;
case 100:
#line 369 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)yyvsp[-1].obj);
                                                                                                                                          Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                          yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-4].obj, cuerpo);}
break;
case 101:
#line 374 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)yyvsp[-3].obj, (Nodo)yyvsp[-1].obj));
                                                                                                                                                                          Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                                                          yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-6].obj,(Nodo)yyvsp[-3].obj);}
break;
case 102:
#line 378 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)yyvsp[-3].obj, (Nodo)yyvsp[-1].obj));
                                                                                                                                                                            Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                                                            yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-6].obj,(Nodo)yyvsp[-3].obj);}
break;
case 103:
#line 382 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)yyvsp[-3].obj, (Nodo)yyvsp[-1].obj));
                                                                                                                                                                  Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                                                  yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-6].obj,(Nodo)yyvsp[-3].obj);}
break;
case 104:
#line 386 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)yyvsp[-3].obj, (Nodo)yyvsp[-1].obj));
                                                                                                                                                                   Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                                                   yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-6].obj,(Nodo)yyvsp[-3].obj); }
break;
case 105:
#line 392 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 106:
#line 393 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 107:
#line 397 "gramatica.y"
{inIF=true;}
break;
case 108:
#line 398 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE"); inIF=true;}
break;
case 109:
#line 399 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");inIF=true; }
break;
case 110:
#line 400 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 111:
#line 404 "gramatica.y"
{inIF=true;}
break;
case 112:
#line 405 "gramatica.y"
{inIF=true;}
break;
case 120:
#line 420 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
break;
case 121:
#line 421 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 125:
#line 432 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 126:
#line 436 "gramatica.y"
{   yyval = new NodoComun("OUTF", new NodoHoja(yyvsp[-1].sval));
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 127:
#line 441 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 128:
#line 442 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 1271 "y.tab.c"
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
