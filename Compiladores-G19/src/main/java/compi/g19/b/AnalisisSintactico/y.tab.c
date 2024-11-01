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
   36,   18,   18,   18,   32,   37,   37,   37,   12,   12,
   12,
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
    1,    3,    7,    1,    3,    3,    1,    1,    4,    4,
    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,   42,   43,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   40,    0,    0,    0,    0,  114,    0,
   74,    0,    0,   75,    0,    0,    0,   70,    0,    0,
    0,    0,    0,    0,   24,   25,    4,    6,    8,    9,
   45,    0,    0,    2,   39,    0,  118,   86,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   78,    0,  106,  107,  108,    0,    0,  111,  110,  109,
    0,    0,    0,    1,    0,  121,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   84,    0,   85,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   66,    0,   67,
    0,    0,   71,   68,   72,   69,  119,  120,    0,    0,
    0,    0,    0,    0,    0,   23,   22,    0,    0,    0,
    0,   44,    0,    0,    0,   76,    0,    0,  101,    0,
    0,    0,    0,    0,    0,   83,    0,   82,    0,    0,
    0,    0,   21,   20,   91,   90,    0,    0,    0,    0,
   52,    0,    0,    0,    0,    0,  103,   89,    0,   88,
   98,    0,    0,    0,   79,    0,   97,   81,   80,    0,
    0,  105,   92,    0,    0,    0,    0,    0,    0,   87,
    0,    0,    0,   96,    0,   94,    0,    0,   35,   36,
    0,    0,    0,  104,   61,    0,    0,    0,   46,    0,
    0,    0,    0,   62,  100,    0,    0,  113,   99,    0,
    0,    0,    0,   51,   60,    0,   59,    0,    0,   50,
  102,   95,   93,    0,    0,    0,    0,   57,   47,   49,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   48,   31,    0,   34,   33,   32,   30,
};
short yydgoto[] = {                                       3,
   12,  205,   14,   15,   16,   53,   17,   18,   19,   20,
   21,   22,   23,   44,  139,   45,   46,   35,  202,   36,
   24,  131,  206,  228,  246,  159,  160,  207,  140,   37,
   38,   69,  171,  152,  141,   81,   62,
};
short yysindex[] = {                                   -121,
  356,  432,    0,  -17,   35,  432,   12, -250,    0,    0,
  -34,  371,    0,   -3,   30, -219,    0,    0,    0,    0,
    0,    0,    0,    0,  386,  166,  107, -140,    0,  -14,
    0,   59, -230,    0,   89,  144,   17,    0,  395,  -10,
  -57,  -92, -104,  147,    0,    0,    0,    0,    0,    0,
    0,  -28,  128,    0,    0,  139,    0,    0,   86,  152,
  155,  156,  110,  -54,    0,  168,  -39,  144,  169,  153,
    0,  -46,    0,    0,    0,  218,  238,    0,    0,    0,
   -6,  242,  249,    0,  184,    0,  134, -179,  197,    2,
  -37, -102,  233, -224,   21,    0,   -6,    0,   -6,   44,
  195,  139,  324,   46,  -45,   56,  324,    0,   17,    0,
   17,  139,    0,    0,    0,    0,    0,    0,  -48,   69,
  131,  -17,  435,  296,  -49,    0,    0,   -7,    0,   74,
  309,    0,  140,  139,   -6,    0,  435,  302,    0,  307,
 -178,  322,  315,  281, -119,    0, -112,    0,   83,  327,
  331,  278,    0,    0,    0,    0,  141,  357,  365,  366,
    0,  159,  391,  139,  215,   -6,    0,    0,  324,    0,
    0, -156, -105,  168,    0,  324,    0,    0,    0,  101,
   57,    0,    0,  381,  410,  174,  176, -224,  410,    0,
  385,  154, -156,    0,  345,    0,  404, -156,    0,    0,
 -159,  185,  194,    0,    0,  190,  410,  400,    0,  410,
    0,  192,  202,    0,    0, -156, -156,    0,    0,  403,
  203,  412,  414,    0,    0,  419,    0,  410,  213,    0,
    0,    0,    0,  444,  -18,  447,  449,    0,    0,    0,
   83,  452,   83,   83,   83,  225,  460,   83,  462,  466,
  467,    0,    0,  468,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0, -217,    0,    0,    0,    0,    0,    0,
    0,  512,    0,  178,  193,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    1,
    0,    0,    0,    0,    0,    0,   49,    0,  515,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  163,    0,    0,  121,    0,    0,  473,    0,
    0,    0,    0,    0,  -33,    0,    0,  473,    0,   25,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  473,    0,    0,    0,    0,    0,    0,   73,    0,
   97,  -41,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   13,    0,
    0,    0,    0,  126,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  474,    0,    0,
    0,    0,    0,  143,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  251,    0,    0,    0,
  157,    0,    0,    0,    0,    0,    0,    0,    0,  -36,
    0,  -22,  -21,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  145,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   22,  100,    0,  438,  -81,    0,    0,    0,    0,  450,
    0,    0,    0,  477,   -9,    0,    0,  280, -172,  470,
   38, -107, -152,    0,    0,    0,    0,    0,  -16,  283,
  301,  -20,  341,  401,  -71,  417,    0,
};
#define YYTABLESIZE 711
short yytable[] = {                                     112,
   73,  104,   88,  124,   27,   43,   61,  114,  203,  156,
  118,   94,  130,  147,   78,   80,   79,  112,   29,   28,
  158,  243,   27,   25,   77,   27,   70,   39,  221,   41,
   86,   71,  129,  157,   33,  145,  212,   51,   33,   41,
  242,   73,   73,   73,   73,   73,  130,   73,   65,    9,
   10,   40,   52,   53,   41,   49,   53,  229,   82,   73,
   73,   73,   73,   83,   60,   77,   77,   77,   77,   77,
  173,   77,   63,   28,   32,  239,   64,  168,   89,   33,
  211,  126,  127,   77,   77,   77,   77,  169,   50,   65,
  170,   65,   65,   65,    9,   10,   64,  193,   66,  168,
   13,   13,  220,   33,  198,   13,  130,   65,   65,   65,
   65,   48,  170,   63,  154,   63,   63,   63,  199,  200,
   37,   63,   66,  217,   48,  119,   96,   33,   76,   72,
   77,   63,   63,   63,   63,    1,  168,   64,   48,   64,
   64,   64,   38,  178,  179,    2,  176,   58,  191,  170,
  168,   33,   42,  197,  122,   64,   64,   64,   64,  201,
  195,    5,   12,  170,  123,   90,  115,    7,  208,  116,
   66,   95,  208,   11,  118,   33,   76,   11,   77,   37,
  163,   76,   76,   77,   77,   26,   76,   92,   77,  149,
  226,   97,   10,  208,  214,   98,   76,   54,   77,   99,
   56,   38,  100,   78,   80,   79,  155,  101,  146,  105,
   33,  208,   33,   73,   74,   75,    9,   10,  107,  122,
   27,   12,   42,  112,  117,  103,    5,   27,   93,  123,
   27,  114,    7,   27,   29,   28,  112,  112,   11,   27,
   26,   29,   28,  106,   29,   28,   30,   29,   28,  129,
   30,   31,   85,   29,   28,   31,   73,   73,  120,   73,
   73,   73,   33,  121,   73,   73,    9,   10,   73,   41,
   73,   73,  128,   73,   73,   73,   73,  132,   73,   73,
   77,   77,   33,   77,   77,   77,   33,  136,   77,   77,
   29,   30,   77,   33,   77,   77,   31,   77,   77,   77,
   77,  135,   77,   77,   65,   65,  225,   65,   65,   65,
  142,   67,   65,   65,   65,   30,   65,  144,   65,   65,
   31,   65,   65,   65,   65,  148,   65,   65,   63,   63,
  161,   63,   63,   63,  199,  200,   63,   63,   29,   30,
   63,  166,   63,   63,   31,   63,   63,   63,   63,  162,
   63,   63,   64,   64,  174,   64,   64,   64,  109,  111,
   64,   64,   57,   30,   64,  167,   64,   64,   31,   64,
   64,   64,   64,  175,   64,   64,   37,   37,  199,  200,
    9,   10,  114,  116,   37,  181,   29,   30,   37,  182,
   37,   37,   31,   37,   37,   37,   37,  186,   38,   38,
  150,   26,   73,   74,   75,  187,   38,  185,   26,  188,
   38,   26,   38,   38,   26,   38,   38,   38,   38,   12,
   26,   55,   30,   57,   30,  189,   12,   31,  180,   31,
   12,  190,   12,   12,   11,   12,   12,   12,   12,  204,
  209,   11,  210,  213,  218,   11,  222,   11,   11,   10,
   11,   11,   11,   11,   34,  223,   10,  224,  227,  230,
   10,  234,   10,   10,  235,   10,   10,   10,   10,  231,
  236,  122,  237,  108,   30,   34,   34,  238,    5,   31,
  240,   34,  183,  241,    7,  177,  244,  138,  245,   34,
   11,  248,  252,  110,   30,   56,   59,  113,   30,   31,
  253,   68,  255,   31,  115,   30,  256,  257,  258,   87,
   31,    5,  194,  196,    3,   34,  117,   55,   58,   91,
  247,  143,  249,  250,  251,   34,   34,  254,  125,  125,
   34,   34,   34,  215,  122,  102,    0,  165,  219,    0,
  125,    5,    0,    0,  125,  183,   34,    7,   34,    0,
  112,  153,  122,   11,    0,    0,  232,  233,    0,    5,
  151,  125,  123,    0,    0,    7,  133,    0,  134,    0,
   34,   11,    0,    0,  151,    0,    0,  172,  122,  125,
  122,    0,    0,    0,   34,    5,    0,    5,  137,  184,
  137,    7,    0,    7,  138,    0,  138,   11,   34,   11,
  216,  122,  184,    0,  164,    0,  125,    0,    5,    0,
    0,  137,    4,  125,    7,   34,    0,  138,    0,    5,
   11,    0,    6,   34,    0,    7,    8,    4,    0,    9,
   10,   11,  125,    0,    5,  192,    0,    0,   47,    0,
    7,    8,    4,  102,    9,   10,   11,    0,    0,    5,
    0,    4,    0,   54,    0,    7,    8,    0,    5,    9,
   10,   11,   84,    0,    7,    8,    4,    0,    9,   10,
   11,    0,    0,    5,    0,    0,    0,    0,    0,    7,
    8,    0,  138,    9,   10,   11,    0,    0,    4,    0,
   34,  122,   34,   34,   34,    5,    0,   34,    5,    0,
    0,    7,    8,    0,    7,    9,   10,   11,    0,    0,
   11,
};
short yycheck[] = {                                      41,
    0,   41,   60,   41,   41,   40,   27,   41,  181,   59,
   44,   40,   94,   62,   60,   61,   62,   59,   41,   41,
  128,   40,   40,    2,    0,   40,  257,    6,  201,  280,
   41,  262,  257,   41,   45,  107,  189,  257,   45,  257,
   59,   41,   42,   43,   44,   45,  128,   47,    0,  274,
  275,   40,  272,   41,  272,   59,   44,  210,   42,   59,
   60,   61,   62,   47,   27,   41,   42,   43,   44,   45,
  142,   47,    0,   91,   40,  228,   91,  256,   41,   45,
  188,   91,   92,   59,   60,   61,   62,  266,   59,   41,
  269,   43,   44,   45,  274,  275,    0,  169,   40,  256,
    1,    2,  262,   45,  176,    6,  188,   59,   60,   61,
   62,   12,  269,   41,  124,   43,   44,   45,  278,  279,
    0,  262,   40,  195,   25,   88,   41,   45,   43,   41,
   45,   59,   60,   61,   62,  257,  256,   41,   39,   43,
   44,   45,    0,  256,  257,  267,  266,   41,  165,  269,
  256,   45,  257,  174,  257,   59,   60,   61,   62,   59,
  266,  264,    0,  269,  267,  258,   41,  270,  185,   44,
   40,   44,  189,  276,   41,   45,   43,    0,   45,   59,
   41,   43,   43,   45,   45,   41,   43,   41,   45,   59,
  207,   40,    0,  210,   41,   41,   43,   41,   45,   44,
   44,   59,   93,   60,   61,   62,  256,  262,  257,   41,
   45,  228,   45,  259,  260,  261,  274,  275,  265,  257,
  257,   59,  257,  265,   41,  265,  264,  264,  257,  267,
  267,  265,  270,  270,  257,  257,  278,  279,  276,  276,
  258,  264,  264,   91,  267,  267,  257,  270,  270,  257,
  257,  262,  263,  276,  276,  262,  256,  257,   62,  259,
  260,  261,   45,  262,  264,  265,  274,  275,  268,  257,
  270,  271,   40,  273,  274,  275,  276,  257,  278,  279,
  256,  257,   45,  259,  260,  261,   45,   93,  264,  265,
  256,  257,  268,   45,  270,  271,  262,  273,  274,  275,
  276,  258,  278,  279,  256,  257,  207,  259,  260,  261,
  265,   32,  264,  265,  256,  257,  268,  262,  270,  271,
  262,  273,  274,  275,  276,  257,  278,  279,  256,  257,
  257,  259,  260,  261,  278,  279,  264,  265,  256,  257,
  268,   40,  270,  271,  262,  273,  274,  275,  276,   41,
  278,  279,  256,  257,   40,  259,  260,  261,   76,   77,
  264,  265,  256,  257,  268,   59,  270,  271,  262,  273,
  274,  275,  276,   93,  278,  279,  256,  257,  278,  279,
  274,  275,   82,   83,  264,   59,  256,  257,  268,   59,
  270,  271,  262,  273,  274,  275,  276,   41,  256,  257,
  121,  257,  259,  260,  261,   41,  264,  267,  264,   44,
  268,  267,  270,  271,  270,  273,  274,  275,  276,  257,
  276,  256,  257,  256,  257,  267,  264,  262,  149,  262,
  268,   41,  270,  271,  257,  273,  274,  275,  276,   59,
  267,  264,  267,   59,   41,  268,  262,  270,  271,  257,
  273,  274,  275,  276,    5,  262,  264,  268,   59,  268,
  268,   59,  270,  271,  262,  273,  274,  275,  276,  268,
   59,  257,   59,  256,  257,   26,   27,   59,  264,  262,
  268,   32,  268,   40,  270,  145,   40,  273,   40,   40,
  276,   40,  268,  256,  257,   26,   27,  256,  257,  262,
   41,   32,   41,  262,  256,  257,   41,   41,   41,   40,
  262,    0,  172,  173,    0,   66,   44,   44,  268,   43,
  241,  105,  243,  244,  245,   76,   77,  248,   91,   92,
   81,   82,   83,  193,  257,   66,   -1,  137,  198,   -1,
  103,  264,   -1,   -1,  107,  268,   97,  270,   99,   -1,
   81,  256,  257,  276,   -1,   -1,  216,  217,   -1,  264,
  123,  124,  267,   -1,   -1,  270,   97,   -1,   99,   -1,
  121,  276,   -1,   -1,  137,   -1,   -1,  256,  257,  142,
  257,   -1,   -1,   -1,  135,  264,   -1,  264,  267,  152,
  267,  270,   -1,  270,  273,   -1,  273,  276,  149,  276,
  256,  257,  165,   -1,  135,   -1,  169,   -1,  264,   -1,
   -1,  267,  257,  176,  270,  166,   -1,  273,   -1,  264,
  276,   -1,  267,  174,   -1,  270,  271,  257,   -1,  274,
  275,  276,  195,   -1,  264,  166,   -1,   -1,  268,   -1,
  270,  271,  257,  174,  274,  275,  276,   -1,   -1,  264,
   -1,  257,   -1,  268,   -1,  270,  271,   -1,  264,  274,
  275,  276,  268,   -1,  270,  271,  257,   -1,  274,  275,
  276,   -1,   -1,  264,   -1,   -1,   -1,   -1,   -1,  270,
  271,   -1,  273,  274,  275,  276,   -1,   -1,  257,   -1,
  241,  257,  243,  244,  245,  264,   -1,  248,  264,   -1,
   -1,  270,  271,   -1,  270,  274,  275,  276,   -1,   -1,
  276,
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
#line 256 "gramatica.y"
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

#line 511 "y.tab.c"
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
case 119:
#line 250 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 120:
#line 251 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
break;
case 121:
#line 252 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 908 "y.tab.c"
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
