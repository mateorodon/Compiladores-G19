#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 ".\gramatica.y"
package compi.g19.AnalisisSintactico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import compi.g19.AnalisisLexico.*;
import compi.g19.GeneracionDeCodigo.*;
import static compi.g19.AnalisisLexico.AnalizadorLexico.errorLexico;
import static compi.g19.AnalisisLexico.AnalizadorLexico.errorSintactico;
#line 18 "y.tab.c"
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
   17,   17,   17,   17,   17,   18,   20,   20,    9,    9,
    9,    5,    5,   22,   22,    6,    6,    6,   23,   23,
   26,    7,    7,    7,   24,   24,   27,   28,   28,   25,
   25,   25,   25,   29,   29,   30,   21,   21,   21,   21,
   21,   31,   31,   31,   31,   31,   32,   32,   32,   32,
   32,   32,   32,    8,    8,    8,    8,    8,    8,   10,
   10,   10,   10,   34,   34,   15,   15,   15,   36,   11,
   11,   11,   11,   11,   11,   11,   11,   11,   37,   37,
   37,   37,   37,   38,   38,   38,   38,   35,   35,   39,
   39,   39,   39,   39,   39,   19,   40,   41,   42,   43,
   19,   19,   33,   44,   44,   44,   12,   12,   12,   12,
};
short yylen[] = {                                         2,
    4,    3,    3,    3,    2,    2,    1,    2,    2,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    5,
    5,    4,    4,    1,    1,    6,    5,    5,    5,    5,
   10,    9,    9,    9,    8,    3,    1,    1,    3,    6,
    3,    1,    1,    1,    1,    3,    2,    1,    3,    2,
    0,    8,    7,    6,    2,    1,    3,    1,    3,    3,
    1,    2,    0,    2,    1,    4,    3,    3,    1,    3,
    3,    3,    3,    1,    3,    3,    1,    1,    1,    4,
    2,    2,    5,    6,    6,    5,    5,    4,    5,    4,
    4,    3,    7,    1,    1,    2,    3,    2,    1,    7,
    7,    9,    9,    9,    9,    8,    8,    7,    2,    2,
    2,    4,    5,    3,    4,    2,    2,    3,    2,    1,
    1,    1,    1,    1,    1,    3,    0,    0,    0,    0,
   11,    1,    3,    3,    1,    1,    4,    4,    4,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,   99,    0,    0,    0,   44,   45,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   42,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    0,
    4,    6,    8,    9,   48,    0,    0,    0,    0,    2,
   41,    0,   78,    0,   79,    0,    0,   74,  136,   92,
    0,    0,    0,    0,    0,    1,    0,    0,  140,    0,
    0,    0,    0,    0,    0,    0,  132,    0,  127,    0,
    0,   49,   47,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   82,    0,    0,    0,    0,   90,    0,
   91,    0,    0,  139,  137,  138,    0,   88,    0,    0,
   36,    0,    0,    0,    0,   23,   22,    0,    0,    0,
  120,  121,  122,  125,  124,  123,    0,   46,    0,   55,
    0,    0,    0,    0,    0,    0,   70,    0,   71,    0,
   75,   72,   76,   73,    0,    0,    0,   87,    0,   86,
   89,   98,    0,    0,   21,   20,   96,   37,   38,    0,
    0,    0,  128,    0,    0,    0,   65,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   80,    0,    0,
    0,   85,   84,  119,   97,    0,    0,    0,    0,    0,
    0,    0,   54,   64,    0,   62,   51,    0,    0,    0,
    0,    0,    0,  116,    0,  117,    0,   83,   93,  118,
    0,    0,    0,    0,    0,    0,    0,   60,    0,   53,
    0,    0,  111,  110,   95,    0,   94,  100,    0,    0,
    0,  101,    0,  114,    0,    0,    0,    0,    0,    0,
    0,    0,   66,   52,    0,    0,    0,    0,    0,  109,
  107,  115,  106,    0,    0,   35,    0,  129,    0,    0,
  102,  104,  105,  103,   32,    0,   34,    0,   33,  113,
   31,  130,    0,  131,
};
short yydgoto[] = {                                       3,
   12,   13,   14,   15,   16,   47,   17,   18,   19,   20,
   21,   22,   23,   37,  116,   38,   39,   40,   80,  161,
   81,   24,   25,   88,  168,  219,   89,   90,  169,  201,
   57,   58,   63,  228,  176,   26,  202,  177,  127,  119,
  190,  268,  273,   64,
};
short yysindex[] = {                                   -157,
  368,  461,    0,  -19,    0,  461,  -17,  -44,    0,    0,
  -15,  390,    0,  -30,   -2, -220,    0,    0,    0,    0,
    0,    0,    0,    0,   36,   87,  415,   80,   -7, -247,
  431,  138,   35, -176, -217, -193,   94,    0,    0,  103,
    0,    0,    0,    0,    0, -117,  -34,  -27,   34,    0,
    0,  -18,    0, -230,    0,   83,  104,    0,    0,    0,
   37,  107,  115,  134,  110,    0,  123,  173,    0,  168,
 -176,  -50,  144,  -42,  -36,  491,    0,   34,    0,  158,
  165,    0,    0,   -4,    0,  -11,    7,  225,  229,  238,
  232,   31,  210,    0,  120,  214,  244,  267,    0,   71,
    0,   71,   55,    0,    0,    0,  -45,    0,   48,   59,
    0,  -19,  328,  293,  260,    0,    0,  -33,  269,  -98,
    0,    0,    0,    0,    0,    0,   71,    0,  446,    0,
   57,   65, -244,  406,  242,   77,    0,  104,    0,  104,
    0,    0,    0,    0,  361,   83,   71,    0,  -65,    0,
    0,    0,  288,  502,    0,    0,    0,    0,    0, -229,
   89,   83,    0,   96,   83,  316,    0,  102,  446,  303,
  446,  446,    0,  476,  360,  505,  109,    0,  296,  356,
   83,    0,    0,    0,    0,  340,  362,  -38,  369,  378,
  380,   71,    0,    0,  381,    0,    0,  169,  -80,  382,
  -51, -106,  324,    0,  477,    0,  487,    0,    0,    0,
  396,  384,   34,  411,  318,  412,  377,    0,  186,    0,
  397,    0,    0,    0,    0,  476,    0,    0,  476,  182,
  399,    0, -136,    0,  198, -136,   34,  427,  428,   34,
  433,   34,    0,    0,  213, -136, -136, -136, -136,    0,
    0,    0,    0,  441,   34,    0,  445,    0,  450,  438,
    0,    0,    0,    0,    0,  457,    0,  269,    0,    0,
    0,    0,  458,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0, -154,    0,    0,    0,    0,    0,    0,
    0,  504,    0,  189,  204,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  507,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  468,  219,    0,    0,    0,
    0,    1,    0,    0,    0,  139,   47,    0,    0,    0,
  467,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   -5,    0,    0,  470,    0,    0,
    0,    0,   24,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  249,    0,
    0,    0,    0,    0,    0,    0,    0,   70,    0,   93,
    0,    0,    0,    0,    0,  125,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  467,    0,    0,  -41,    0,    0,    0,  250,    0,
  249,  249,  129,    0,    0,    0,    0,    0,    0,    0,
  159,    0,    0,    0,    0,    0,  -35,  -13,  141,    0,
  245,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  246,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  345,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  174,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  117,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   99,   28,    0,  452,  -29,    0,    0,    0,    0,  456,
    0,    0,    0,  484,  -56,    0,    0,    0,  306,  -64,
  -25,   90,    0,  400,   23,    0,    0,    0,    0, -118,
  106,  118, -110,  -61,  -78,    0,  -58,  -85,  315,    0,
    0,    0,    0,    0,
};
#define YYTABLESIZE 781
short yytable[] = {                                     126,
   77,  213,   56,   61,  114,   27,   70,  224,  163,   84,
  170,  109,   85,   86,   65,   34,  149,  126,   87,  117,
   29,   29,   32,   81,   36,  160,   93,   30,   43,    9,
   10,   94,  187,   60,  154,   56,   45,   54,   56,   42,
   74,   77,   77,   77,   77,   77,   69,   77,  158,  159,
  195,   46,  170,  170,   42,  164,   44,  156,   42,   77,
   77,   77,   77,   35,   81,   81,   81,   81,   81,   67,
   81,   30,   92,   79,  145,   48,  146,   99,   54,   95,
  221,   96,   81,   81,   81,   81,  235,   69,  203,   69,
   69,   69,   68,  162,   71,  188,  205,    9,   10,    1,
   27,  165,   43,   87,   31,   69,   69,   69,   69,    2,
   67,  221,   67,   67,   67,   54,  112,   43,   62,  225,
  205,  181,   72,   73,   54,   95,   49,   96,   67,   67,
   67,   67,  227,   68,   76,   68,   68,   68,   39,   82,
  247,  232,   79,  249,  233,   97,  100,   54,  236,  225,
   98,   68,   68,   68,   68,  101,  167,  272,   40,  226,
  107,   78,  227,  104,   54,  133,  217,  246,  134,   57,
  248,  251,   59,  108,  253,  204,  112,  102,   69,  158,
  159,   29,   54,    5,  261,  262,  263,  264,   11,    7,
  182,  183,  166,  197,  198,   11,  194,   39,  167,  167,
  138,  140,  103,   10,  223,  110,  108,   95,  106,   96,
   95,  148,   96,  105,  142,  144,  120,   40,   12,  111,
  112,   27,   83,  212,  124,  126,  125,    5,   27,   85,
  113,   27,  108,    7,   27,   33,  126,  126,   28,   11,
   27,   35,  162,   30,  158,  159,    9,   10,   59,   52,
   30,   43,  128,   30,   53,  129,   30,   77,   54,   77,
   77,   77,   30,  130,   77,  131,    9,   10,   77,  132,
   77,   77,  134,   77,   77,   77,   77,   12,   77,   77,
   81,  133,   81,   81,   81,   28,   26,   81,   54,   77,
   52,   81,  135,   81,   81,   53,   81,   81,   81,   81,
  136,   81,   81,   69,  150,   69,   69,   69,    9,   10,
   69,   54,  147,   54,   69,  151,   69,   69,  157,   69,
   69,   69,   69,  171,   69,   69,   67,   52,   67,   67,
   67,  172,   53,   67,  178,   51,   52,   67,  179,   67,
   67,   53,   67,   67,   67,   67,  184,   67,   67,   68,
  189,   68,   68,   68,   91,  192,   68,  191,   77,   52,
   68,  196,   68,   68,   53,   68,   68,   68,   68,  193,
   68,   68,  112,  112,  207,  137,   52,  124,  126,  125,
  112,   53,  112,  118,  112,  112,  112,  112,  208,  112,
  112,  112,  112,   67,   52,   39,  209,   29,  210,   53,
   68,  180,   39,   95,   29,   96,   39,   29,   39,   39,
   29,   39,   39,   39,   39,   40,   29,  243,  215,   95,
  211,   96,   40,  121,  122,  123,   40,  214,   40,   40,
  108,   40,   40,   40,   40,  237,  220,  108,  216,  218,
  222,  108,  238,  108,  108,   11,  108,  108,  108,  108,
  240,  242,   11,  244,  166,  245,   11,  250,   11,   11,
   10,   11,   11,   11,   11,  252,  255,   10,  256,  139,
   52,   10,  258,   10,   10,   53,   10,   10,   10,   10,
  260,  265,   12,   55,   55,  267,   12,   55,   12,   12,
  269,   12,   12,   12,   12,   55,  270,  271,  274,  141,
   52,   28,   26,    5,   55,   53,    3,   50,   28,   26,
  135,   28,   26,   58,   28,   26,   63,   61,  239,   75,
   28,   26,  143,   52,   59,   52,  115,  115,   53,  241,
   53,    0,  173,   55,    0,    0,    0,    0,    0,    0,
    0,    0,  254,    0,    0,  257,    0,  259,  155,  112,
   55,   55,   55,   55,    0,   55,    5,   55,    0,  113,
  266,    0,    7,    0,  153,  115,    0,    0,   11,    0,
    0,    0,    0,    0,   55,    0,  121,  122,  123,  225,
  112,    0,   55,  152,  112,  153,    0,    5,    0,  229,
  230,    5,  227,    7,    0,    0,  166,    7,    0,   11,
  109,  119,   55,   11,    0,  186,    0,    0,  119,    0,
  109,    0,  119,  109,  119,  204,  112,    0,    0,    0,
  119,    0,    0,    5,    4,  200,  153,  186,    0,    7,
    0,    5,    0,    0,    6,   11,    0,    7,    8,    0,
    0,    9,   10,   11,    0,    0,    4,   55,    0,    0,
  153,    0,    0,    5,  231,    0,  186,   41,  231,    7,
    8,    0,  112,    9,   10,   11,    0,    0,   55,    5,
  174,    4,  175,    0,    0,    7,    0,  200,    5,    0,
  200,   11,   50,    0,    7,    8,    0,    4,    9,   10,
   11,    0,   55,    0,    5,   55,    0,   55,   66,    0,
    7,    8,    4,    0,    9,   10,   11,    0,    0,    5,
   55,    0,    0,    0,    0,    7,    8,    4,  166,    9,
   10,   11,    0,   55,    5,    0,    0,    0,    0,    0,
    7,    8,  112,  112,    9,   10,   11,    0,    0,    5,
    5,    0,  199,  112,  234,    7,    7,  112,  166,  166,
    5,   11,   11,  230,    5,    0,    7,  113,  112,  166,
    7,  112,   11,    0,    0,    5,   11,    0,    5,  185,
    0,    7,  206,    0,    7,    0,    0,   11,    0,    0,
   11,
};
short yycheck[] = {                                      41,
    0,   40,   28,   29,   41,   41,   32,   59,  119,   44,
  129,   62,  257,   41,  262,   60,   62,   59,   48,   76,
   40,   40,   40,    0,   40,   59,  257,   41,   59,  274,
  275,  262,  262,   41,  113,   41,  257,   45,   44,   12,
  258,   41,   42,   43,   44,   45,    0,   47,  278,  279,
  169,  272,  171,  172,   27,  120,   59,  114,   31,   59,
   60,   61,   62,  257,   41,   42,   43,   44,   45,    0,
   47,   91,   91,   40,  100,   40,  102,   41,   45,   43,
  199,   45,   59,   60,   61,   62,  205,   41,  174,   43,
   44,   45,    0,  119,   60,  160,  175,  274,  275,  257,
    2,  127,  257,  133,    6,   59,   60,   61,   62,  267,
   41,  230,   43,   44,   45,   45,    0,  272,   29,  256,
  199,  147,   33,   34,   45,   43,   40,   45,   59,   60,
   61,   62,  269,   41,   41,   43,   44,   45,    0,  257,
  226,  203,   40,  229,  203,   42,   40,   45,  207,  256,
   47,   59,   60,   61,   62,   41,  129,  268,    0,  266,
   71,   59,  269,   41,   45,   41,  192,  226,   44,   41,
  229,  233,   44,    0,  236,  256,  257,   44,   41,  278,
  279,   41,   45,  264,  246,  247,  248,  249,    0,  270,
  256,  257,  273,  171,  172,  276,  169,   59,  171,  172,
   95,   96,   93,    0,  256,   62,  257,   43,   41,   45,
   43,  257,   45,   41,   97,   98,   59,   59,    0,  262,
  257,  257,  257,  262,   60,   61,   62,  264,  264,  257,
  267,  267,   59,  270,  270,  280,  278,  279,  258,  276,
  276,  257,  268,  257,  278,  279,  274,  275,  256,  257,
  264,  257,  257,  267,  262,  267,  270,  257,   45,  259,
  260,  261,  276,  257,  264,   41,  274,  275,  268,   41,
  270,  271,   41,  273,  274,  275,  276,   59,  278,  279,
  257,   44,  259,  260,  261,   41,   41,  264,   45,  256,
  257,  268,  262,  270,  271,  262,  273,  274,  275,  276,
   91,  278,  279,  257,  257,  259,  260,  261,  274,  275,
  264,   45,  258,   45,  268,  257,  270,  271,   59,  273,
  274,  275,  276,  267,  278,  279,  257,  257,  259,  260,
  261,  267,  262,  264,   93,  256,  257,  268,  262,  270,
  271,  262,  273,  274,  275,  276,   59,  278,  279,  257,
  262,  259,  260,  261,   49,   40,  264,  262,  256,  257,
  268,   59,  270,  271,  262,  273,  274,  275,  276,  268,
  278,  279,  256,  257,  266,  256,  257,   60,   61,   62,
  264,  262,  266,   78,  268,  269,  270,  271,   93,  273,
  274,  275,  276,  256,  257,  257,   41,  257,   59,  262,
  263,   41,  264,   43,  264,   45,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,   41,   41,   43,
   59,   45,  264,  259,  260,  261,  268,   59,  270,  271,
  257,  273,  274,  275,  276,   40,  268,  264,   59,   59,
   59,  268,   59,  270,  271,  257,  273,  274,  275,  276,
   40,   40,  264,  268,  273,   59,  268,   59,  270,  271,
  257,  273,  274,  275,  276,  268,   40,  264,   41,  256,
  257,  268,   40,  270,  271,  262,  273,  274,  275,  276,
  268,   41,  264,   28,   29,   41,  268,   32,  270,  271,
   41,  273,  274,  275,  276,   40,   59,   41,   41,  256,
  257,  257,  257,    0,   49,  262,    0,   40,  264,  264,
   44,  267,  267,   44,  270,  270,  268,  268,  213,   36,
  276,  276,  256,  257,  256,  257,   75,   76,  262,  215,
  262,   -1,  133,   78,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  237,   -1,   -1,  240,   -1,  242,  256,  257,
   95,   96,   97,   98,   -1,  100,  264,  102,   -1,  267,
  255,   -1,  270,   -1,  113,  114,   -1,   -1,  276,   -1,
   -1,   -1,   -1,   -1,  119,   -1,  259,  260,  261,  256,
  257,   -1,  127,  256,  257,  134,   -1,  264,   -1,  266,
  267,  264,  269,  270,   -1,   -1,  273,  270,   -1,  276,
  256,  257,  147,  276,   -1,  154,   -1,   -1,  264,   -1,
  266,   -1,  268,  269,  270,  256,  257,   -1,   -1,   -1,
  276,   -1,   -1,  264,  257,  174,  175,  176,   -1,  270,
   -1,  264,   -1,   -1,  267,  276,   -1,  270,  271,   -1,
   -1,  274,  275,  276,   -1,   -1,  257,  192,   -1,   -1,
  199,   -1,   -1,  264,  203,   -1,  205,  268,  207,  270,
  271,   -1,  257,  274,  275,  276,   -1,   -1,  213,  264,
  265,  257,  267,   -1,   -1,  270,   -1,  226,  264,   -1,
  229,  276,  268,   -1,  270,  271,   -1,  257,  274,  275,
  276,   -1,  237,   -1,  264,  240,   -1,  242,  268,   -1,
  270,  271,  257,   -1,  274,  275,  276,   -1,   -1,  264,
  255,   -1,   -1,   -1,   -1,  270,  271,  257,  273,  274,
  275,  276,   -1,  268,  264,   -1,   -1,   -1,   -1,   -1,
  270,  271,  257,  257,  274,  275,  276,   -1,   -1,  264,
  264,   -1,  267,  257,  268,  270,  270,  257,  273,  273,
  264,  276,  276,  267,  264,   -1,  270,  267,  257,  273,
  270,  257,  276,   -1,   -1,  264,  276,   -1,  264,  268,
   -1,  270,  268,   -1,  270,   -1,   -1,  276,   -1,   -1,
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
"encabezado_for1 : asignacion_for ';' condicion ';' up_down CONSTANTE",
"encabezado_for1 : asignacion_for ';' condicion ';' CONSTANTE",
"encabezado_for1 : asignacion_for condicion ';' up_down CONSTANTE",
"encabezado_for1 : asignacion_for ';' condicion up_down CONSTANTE",
"encabezado_for1 : asignacion_for ';' condicion ';' up_down",
"encabezado_for2 : asignacion_for ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : asignacion_for ';' condicion ';' CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : asignacion_for condicion ';' up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : asignacion_for ';' condicion up_down CONSTANTE ';' '(' condicion ')'",
"encabezado_for2 : asignacion_for ';' condicion ';' up_down '(' condicion ')'",
"asignacion_for : ID ASIGNACION CONSTANTE",
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
"bloque_if : encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico",
"cuerpo_if_unico : sentencia_ejecutable ';'",
"cuerpo_if_unico : sentencia_return ';'",
"cuerpo_if_unico : sentencia_return error",
"cuerpo_if_unico : BEGIN sentencia_return ';' END",
"cuerpo_if_unico : BEGIN sentencia_return ';' END ';'",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables END",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables sentencia_return END",
"cuerpo_if_bloque : BEGIN error",
"cuerpo_if_bloque : list_sentencias_ejecutables END",
"list_sentencias_ejecutables : list_sentencias_ejecutables sentencia_ejecutable ';'",
"list_sentencias_ejecutables : sentencia_ejecutable ';'",
"comparacion : MAYORIGUAL",
"comparacion : MENORIGUAL",
"comparacion : DISTINTO",
"comparacion : '='",
"comparacion : '>'",
"comparacion : '<'",
"condicion : expresion comparacion expresion",
"$$2 :",
"$$3 :",
"$$4 :",
"$$5 :",
"condicion : '(' $$2 bloque_list_expresiones $$3 ')' comparacion '(' $$4 bloque_list_expresiones $$5 ')'",
"condicion : error",
"bloque_list_expresiones : list_expresiones ',' expresion",
"list_expresiones : list_expresiones ',' expresion",
"list_expresiones : expresion",
"list_expresiones : error",
"salida_mensaje : OUTF '(' CADENA ')'",
"salida_mensaje : OUTF '(' expresion ')'",
"salida_mensaje : OUTF '(' error ')'",
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
#line 819 ".\gramatica.y"
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;

static NodoComun raiz;
static String ambito = "main";
static boolean inIF = false;
static boolean hasReturn = false;
static boolean enFuncion = false;
static String funcionActual;
static int cantReturns = 0;
static List<String> varDeclaradas = new ArrayList<>();
static String tipoActual;
static List<String> erroresSemanticos = new ArrayList<>();
public static Map<String,String> tiposDeclarados = new HashMap<>();
public static Map<String,NodoComun> funcionesDeclaradas = new HashMap<>();
static List<Nodo> expresiones1 = new ArrayList<>();
static List<Nodo> expresiones2 = new ArrayList<>();
static boolean inList1 = false;
static boolean inList2 = false;
static boolean funcionAutoinvocada = false;

public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
      this.yylval = new ParserVal(t.getLexema().toString());
      return (int) t.getId();
    }
    return 0;
}

public static boolean getFuncionAutoinvocada(){
    return funcionAutoinvocada;
}

public static void yyerror(String error){
    if (!error.contains("syntax error"))
        AnalizadorLexico.agregarErrorSintactico(error);
}

public static void addAmbito(String ambitoActual){
    ambito = ambito.concat("@" + ambitoActual);
}

public void removeAmbito(){
        int index = ambito.lastIndexOf('@');

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

public static boolean noHayErrores(){
    return erroresSemanticos.isEmpty() && errorSintactico.isEmpty() && errorLexico.isEmpty();
}

public String buscarAmbito(String ambitoActual, String lexema) {
    String ambito = ambitoActual;

    while (!TablaSimbolos.existeSimbolo(lexema + "@" + ambito)) {
        if (ambito.equals("main")) {
            return "";
        }
        int index = ambito.lastIndexOf('@');
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
    Token t1 = TablaSimbolos.getToken(var + "@" + ambito);
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

private NodoComun controlarTipos(Nodo nodo1, String op, Nodo nodo3){
    NodoComun ret = new NodoComun(op, nodo1, nodo3);
    if (!(nodo1.getNombre().contains("error") || nodo3.getNombre().contains("error"))) {
    if (!(nodo1.getTipo().equals(nodo3.getTipo()))){
        agregarErrorSemantico("Incompatibilidad de tipos en la " + op);
        ret = new NodoComun("error");
    }
    else
        ret.setTipo(nodo1.getTipo());
    }

    return ret;
}

private Nodo generarLlamadoFuncion(NodoComun funcion, Nodo copia, String tipoCasteo) {
    NodoComun salida = null;
    if (funcion != null) {
        NodoHoja param = (NodoHoja)funcion.getIzq(); // Parámetro formal de la función
        String tipoFormal = param.getTipo(); // Tipo esperado por la función
        String tipoReal = copia.getTipo();   // Tipo de la expresión original

        if (tipoCasteo == null) {
            // Sin casteo: los tipos deben coincidir
            if (tipoFormal.equals(tipoReal)) {
                salida = new NodoComun(funcion, copia, null);
                salida.setUso("llamado");
            } else {
                agregarErrorSemantico("El tipo del parámetro real no coincide con el del parámetro formal");
                return new NodoHoja("error");
            }
        } else {
            // Con casteo: validar que sea permitido
            if (tipoCasteo.equals(tipoReal)) {
                // Intento de forzar un casteo al mismo tipo
                AnalizadorLexico.agregarWarning("El tipo del parámetro real ya es del tipo solicitado en el casteo");
                return new NodoHoja("error");
            } else if (tipoFormal.equals(tipoCasteo) && esCasteoValido(tipoReal, tipoCasteo)) {
                // Casteo válido
                //param.setNombre(copia.getNombre());
                NodoHoja newCopia = new NodoHoja(copia.getNombre(),param.getToken());
                NodoHoja nodoTipoReal = new NodoHoja(tipoReal, null);
                salida = new NodoComun(funcion, newCopia, nodoTipoReal);
                salida.setUso("llamadoConCasteo");
            } else {
                // Casteo inválido
                agregarErrorSemantico("El casteo de " + tipoReal + " a " + tipoCasteo + " no es válido");
                return new NodoHoja("error");
            }
        }
    }
    return salida;
}

// Método auxiliar para validar si un casteo es válido
private boolean esCasteoValido(String tipoOrigen, String tipoDestino) {
    // Regla: permitir solo ULONGINT ↔ SINGLE
    return (tipoOrigen.equals("ulongint") && tipoDestino.equals("single")) ||
           (tipoOrigen.equals("single") && tipoDestino.equals("ulongint"));
}

public NodoComun getRaiz(){
    return this.raiz;
}

public static List<Nodo> getFuncionesDeclaradas(){
    return new ArrayList<>(funcionesDeclaradas.values());
}

public static boolean esOperacion(String nombre){
    return nombre.equals("*") || nombre.equals("/") || nombre.equals("+") || nombre.equals("-");
}
#line 713 "y.tab.c"
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
#line 22 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa"); if (noHayErrores()){raiz = new NodoComun("PROGRAMA", (Nodo)yyvsp[-1].obj);}}
break;
case 2:
#line 23 ".\gramatica.y"
{yyerror("El programa debe tener un nombre");}
break;
case 3:
#line 24 ".\gramatica.y"
{yyerror("Falta delimitador END del programa");}
break;
case 4:
#line 25 ".\gramatica.y"
{yyerror("Falta delimitador BEGIN del programa");}
break;
case 5:
#line 26 ".\gramatica.y"
{yyerror("Faltan los delimitadores del programa");}
break;
case 6:
#line 29 ".\gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo)yyvsp[-1].obj, (Nodo)yyvsp[0].obj);}
break;
case 7:
#line 30 ".\gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 9:
#line 35 ".\gramatica.y"
{yyval=yyvsp[-1];}
break;
case 10:
#line 36 ".\gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
#line 37 ".\gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 12:
#line 41 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");
                         for (String var: varDeclaradas){
                            Token t = TablaSimbolos.getToken(var);
                            if (!TablaSimbolos.existeSimbolo(var + "@" + ambito)){
                                String tipo = t.getTipo();
                                if (tipo != null){
                                    if (tipo.toLowerCase().equals(tipoActual.toLowerCase()))
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya esta declarada");
                                    else
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya estaba declarada. Se cambio su tipo a " + tipoActual);
                                }
                                t.getLexema().setLength(0);
                                t.getLexema().append(var).append("@").append(ambito);
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
#line 68 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
#line 69 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
#line 73 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion"); yyval=yyvsp[0];}
break;
case 16:
#line 74 ".\gramatica.y"
{yyval = yyvsp[0];AnalizadorLexico.agregarWarning("Se ha llamado a una función pero su valor no ha sido utilizado"); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 17:
#line 75 ".\gramatica.y"
{yyval=yyvsp[0];}
break;
case 18:
#line 76 ".\gramatica.y"
{yyval=yyvsp[0];}
break;
case 19:
#line 77 ".\gramatica.y"
{yyval=yyvsp[0];}
break;
case 20:
#line 82 ".\gramatica.y"
{ yyval.obj = new NodoComun("For",(Nodo)yyvsp[-2].obj,(Nodo)yyvsp[0].obj);}
break;
case 21:
#line 83 ".\gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
#line 84 ".\gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
#line 85 ".\gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 24:
#line 89 ".\gramatica.y"
{yyval=yyvsp[0];}
break;
case 25:
#line 90 ".\gramatica.y"
{yyval=yyvsp[0];}
break;
case 26:
#line 94 ".\gramatica.y"
{
                                                        NodoHoja constanteUpDown = new NodoHoja(yyvsp[0].sval,TablaSimbolos.getToken(yyvsp[0].sval));
                                                        Nodo incremento = new NodoComun("Incremento", (Nodo)yyvsp[-1].obj, constanteUpDown); /*Idem*/
                                                        Nodo condicion = (Nodo)yyvsp[-3].obj;
                                                        Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento",(Nodo)yyvsp[-5].obj , incremento);
                                                        yyval.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condicion);
                                                        AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");
                                                        }
break;
case 27:
#line 102 ".\gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
#line 103 ".\gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
#line 104 ".\gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
#line 105 ".\gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
#line 109 ".\gramatica.y"
{

                                                                                       NodoHoja constanteUpDown = new NodoHoja(yyvsp[-4].sval,TablaSimbolos.getToken(yyvsp[-4].sval));
                                                                                       Nodo asignacion = (Nodo)yyvsp[-9].obj;
                                                                                       Nodo incremento = new NodoComun("Incremento", (Nodo)yyvsp[-5].obj, constanteUpDown); /*Idem*/
                                                                                       Nodo condicion = (Nodo)yyvsp[-7].obj;
                                                                                       Nodo iteradorCondicion = (Nodo)yyvsp[-1].obj;

                                                                                       Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento", asignacion, incremento);
                                                                                       Nodo condiciones = new NodoComun("Condiciones", condicion, iteradorCondicion);

                                                                                       yyval.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condiciones);

                                                                                       AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");
                                                                                       TablaSimbolos.removeToken(yyvsp[-9].sval);
                                                                                       }
break;
case 32:
#line 126 ".\gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
#line 127 ".\gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
#line 128 ".\gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
#line 129 ".\gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 36:
#line 133 ".\gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[-2].sval);
                                        NodoHoja idAsignacion = null;
                                        if (!ambitoVar.equals("")) {
                                            Token t = TablaSimbolos.getToken(yyvsp[-2].sval + "@" + ambitoVar);
                                            idAsignacion = new NodoHoja(yyvsp[-2].sval + "@" + ambitoVar, t);
                                        }
                                        else {
                                            Token t = new Token();
                                            t.setTipo(ENTERO);
                                            t.getLexema().setLength(0);
                                            t.getLexema().append(yyvsp[-2].sval).append("@").append(ambito);
                                            t.setAmbito(ambito);
                                            t.setUso("variable");
                                            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                            idAsignacion = new NodoHoja(yyvsp[-2].sval + "@" + ambito, t);
                                        }
                                        NodoHoja constante = new NodoHoja(yyvsp[0].sval, TablaSimbolos.getToken(yyvsp[0].sval));
                                        yyval.obj = new NodoComun(yyvsp[-1].sval, idAsignacion, constante);
                                        TablaSimbolos.removeToken(yyvsp[-2].sval);
                                        }
break;
case 37:
#line 156 ".\gramatica.y"
{yyval.obj = new NodoHoja("Up");}
break;
case 38:
#line 157 ".\gramatica.y"
{yyval.obj = new NodoHoja("Down");}
break;
case 39:
#line 161 ".\gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,yyvsp[-2].sval);
                              Nodo asignacion = new NodoHoja("error");
                              Token t = null;
                              if (ambitoVar.equals("")){
                                  t = TablaSimbolos.getToken(yyvsp[-2].sval);
                                  if (t.getTipo() == null){
                                        agregarErrorSemantico("La variable '" + yyvsp[-2].sval + "' no fue declarada");
                                        yyval.obj = new NodoHoja("error");
                                  }
                                  else {
                                        t.getLexema().setLength(0);
                                        t.getLexema().append(yyvsp[-2].sval).append("@").append(ambito);
                                        t.setAmbito(ambito);
                                        t.setUso("variable");
                                        TablaSimbolos.removeToken(yyvsp[-2].sval);
                                        TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                        NodoHoja id = new NodoHoja(t.getLexema().toString(),t);
                                        yyval.obj = new NodoComun(yyvsp[-1].sval ,id, (Nodo)yyvsp[0].obj);
                                  }
                              }
                              else {
                                  t = TablaSimbolos.getToken(yyvsp[-2].sval + "@" + ambitoVar);
                                  if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))){
                                        agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")" );
                                        yyval.obj = new NodoHoja("error");
                                  }
                                  else {
                                        NodoHoja id = new NodoHoja(t.getLexema().toString(),t);
                                        yyval.obj = new NodoComun(yyvsp[-1].sval ,id, (Nodo)yyvsp[0].obj);
                                  }
                              }
                              TablaSimbolos.removeToken(yyvsp[-2].sval);
                            }
break;
case 40:
#line 194 ".\gramatica.y"
{
                                                String ambitoVar = buscarAmbito(ambito,yyvsp[-5].sval);
                                                if (ambitoVar.equals("")){
                                                    agregarErrorSemantico("La variable '" + yyvsp[-5].sval + "' no fue declarada");
                                                    yyval.obj = new NodoHoja("error");
                                                }
                                                else {
                                                    Token t = TablaSimbolos.getToken(yyvsp[-5].sval + "@" + ambitoVar);
                                                    String tipo = t.getTipo();
                                                    if (tiposDeclarados.containsKey(tipo)){
                                                        String tipoTriple = tiposDeclarados.get(tipo);
                                                        NodoHoja nodo = new NodoHoja(yyvsp[-5].sval + yyvsp[-4].sval + yyvsp[-3].sval + yyvsp[-2].sval, t);
                                                        nodo.setUso("arreglo");
                                                        yyval.obj = new NodoComun(yyvsp[-1].sval,nodo,(Nodo)yyvsp[0].obj);
                                                    }
                                                    else {
                                                        agregarErrorSemantico("La variable '" + yyvsp[-5].sval + "' no es de un tipo TRIPLE definido");
                                                        yyval.obj = new NodoHoja("error");
                                                    }
                                                }
                                                String index = TablaSimbolos.getToken(yyvsp[-3].sval).getLexema().toString();
                                                if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                                    agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                                    yyval.obj = new NodoHoja("error");
                                                }
                                                TablaSimbolos.removeToken(yyvsp[-5].sval);

                                                }
break;
case 41:
#line 222 ".\gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 43:
#line 227 ".\gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,yyvsp[0].sval);
           if (ambitoVar.equals(""))
                agregarErrorSemantico("El tipo '" + yyvsp[0].sval + "' no fue declarado");
           else {
            Token t = TablaSimbolos.getToken(yyvsp[0].sval + "@" + ambitoVar);
            if (t.getUso() == null || !t.getUso().equals("tipo"))
                yyerror("El identificador '" + yyvsp[0].sval + "' no es un tipo definido");
            else {
                tipoActual = yyvsp[0].sval;
            }
            }
            TablaSimbolos.removeToken(yyvsp[0].sval);
         }
break;
case 44:
#line 243 ".\gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 45:
#line 244 ".\gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 46:
#line 248 ".\gramatica.y"
{varDeclaradas.add(yyvsp[0].sval);}
break;
case 47:
#line 249 ".\gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 48:
#line 250 ".\gramatica.y"
{varDeclaradas.add(yyvsp[0].sval);}
break;
case 49:
#line 254 ".\gramatica.y"
{hasReturn = false;
                enFuncion = true;
                funcionActual = yyvsp[0].sval;
                String idFuncion = yyvsp[0].sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (t.getTipo() == null){
                     if (!TablaSimbolos.existeSimbolo(idFuncion + "@" + ambito)){
                        t.getLexema().setLength(0);
                        t.getLexema().append(idFuncion).append("@").append(ambito); /*aca agrega una vez el ambito*/
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
                     NodoComun encabezado = new NodoComun(idFuncion + "@" + ambito);
                     encabezado.setToken(t);
                     yyval.obj = encabezado;
                 }
                 else {
                    agregarErrorSemantico("La variable '" + idFuncion + "' ya fue declarada");
                    yyval.obj = new NodoComun("error");
                 }
                 addAmbito(idFuncion);
                 }
break;
case 50:
#line 283 ".\gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 51:
#line 287 ".\gramatica.y"
{ if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         if ((((NodoComun)yyvsp[0].obj) != null)&&(!((NodoComun)yyvsp[0].obj).getNombre().equals("Cuerpo vacio"))) {
                                                             Nodo parametro = (Nodo)yyvsp[-3].obj;
                                                             NodoComun funcion = (NodoComun)yyvsp[-5].obj; /*Encabezado con nombre funcion, este tiene el tipo*/
                                                             NodoComun cuerpo = (NodoComun)yyvsp[0].obj;

                                                             funcion.setUso("funcion");
                                                             funcion.setIzq(parametro);
                                                             funcion.setDer(cuerpo);

                                                             funcionesDeclaradas.put(funcion.getNombre(),funcion);
                                                             removeAmbito();
                                                             enFuncion = false;
                                                             }
                                                         }
break;
case 53:
#line 304 ".\gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 54:
#line 305 ".\gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 55:
#line 309 ".\gramatica.y"
{
               Token t = TablaSimbolos.getToken(yyvsp[0].sval);
               if (t != null){
                   if (t.getTipo() != null)
                        AnalizadorLexico.agregarWarning("La variable '" + yyvsp[0].sval + "' ya esta declarada");
                   t.getLexema().setLength(0);
                   t.getLexema().append(yyvsp[0].sval).append("@").append(ambito);
                   t.setAmbito(ambito);
                   t.setUso("parametro");
                   t.setTipo(tipoActual);
                   TablaSimbolos.removeToken(yyvsp[0].sval);
                   TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
               }
              Nodo param = new NodoHoja(t.getLexema().toString(), t);
              param.setTipo(tipoActual);
              yyval.obj = param;
            }
break;
case 56:
#line 326 ".\gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 60:
#line 339 ".\gramatica.y"
{  yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);
                                                    hasReturn = true;}
break;
case 61:
#line 341 ".\gramatica.y"
{yyval=yyvsp[0];}
break;
case 62:
#line 342 ".\gramatica.y"
{yyval=yyvsp[-1]; hasReturn = true;}
break;
case 63:
#line 343 ".\gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio"); yyval.obj = new NodoComun("Cuerpo vacio");}
break;
case 64:
#line 348 ".\gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-1].obj, (Nodo) yyvsp[0].obj);}
break;
case 65:
#line 349 ".\gramatica.y"
{yyval=yyvsp[0];}
break;
case 66:
#line 354 ".\gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           yyval.obj = new NodoComun("Return", (Nodo)yyvsp[-1].obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 67:
#line 362 ".\gramatica.y"
{
                         String expresion = ((Nodo)yyvsp[-2].obj).getNombre();
                         String termino = ((Nodo)yyvsp[0].obj).getNombre();
                         if (!(expresion.contains("error") || termino.contains("error"))){
                             Nodo nIzq = (Nodo)yyvsp[-2].obj;
                             Nodo nDer = (Nodo)yyvsp[0].obj;
                             yyval.obj = controlarTipos(nIzq,yyvsp[-1].sval,nDer);
                         }
                         else {
                            yyval.obj = new NodoHoja("error");
                         }
                        }
break;
case 68:
#line 374 ".\gramatica.y"
{
                         String expresion = ((Nodo)yyvsp[-2].obj).getNombre();
                         String termino = ((Nodo)yyvsp[0].obj).getNombre();
                         if (!(expresion.contains("error") || termino.contains("error"))){
                             Nodo nIzq = (Nodo)yyvsp[-2].obj;
                             Nodo nDer = (Nodo)yyvsp[0].obj;
                             yyval.obj = controlarTipos(nIzq,yyvsp[-1].sval,nDer);
                         }
                         else {
                            yyval.obj = new NodoHoja("error");
                         }
                        }
break;
case 69:
#line 386 ".\gramatica.y"
{yyval = yyvsp[0];}
break;
case 70:
#line 387 ".\gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
#line 388 ".\gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 72:
#line 392 ".\gramatica.y"
{
                         String termino = ((Nodo)yyvsp[-2].obj).getNombre();
                         String factor = ((Nodo)yyvsp[0].obj).getNombre();
                         if (!(termino.contains("error") || factor.contains("error"))){
                             Nodo nIzq = (Nodo)yyvsp[-2].obj;
                             Nodo nDer = (Nodo)yyvsp[0].obj;
                             yyval.obj = controlarTipos(nIzq,yyvsp[-1].sval,nDer);
                         }
                         else {
                            yyval.obj = new NodoHoja("error");
                         }
                        }
break;
case 73:
#line 404 ".\gramatica.y"
{
                         String termino = ((Nodo)yyvsp[-2].obj).getNombre();
                         String factor = ((Nodo)yyvsp[0].obj).getNombre();
                         if (!(termino.contains("error") || factor.contains("error"))){
                             Nodo nIzq = (Nodo)yyvsp[-2].obj;
                             Nodo nDer = (Nodo)yyvsp[0].obj;
                             yyval.obj = controlarTipos(nIzq,yyvsp[-1].sval,nDer);
                         }
                         else {
                            yyval.obj = new NodoHoja("error");
                         }
                        }
break;
case 74:
#line 416 ".\gramatica.y"
{yyval = yyvsp[0];}
break;
case 75:
#line 417 ".\gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 76:
#line 418 ".\gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 77:
#line 422 ".\gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[0].sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La variable '" + yyvsp[0].sval + "' no fue declarada");
            Nodo aux = new NodoHoja("error");
            yyval.obj = aux;
        }
        else {
            Token t = TablaSimbolos.getToken(yyvsp[0].sval + "@" + ambitoVar);
            if (!(t.getUso().equals("variable") || t.getUso().equals("parametro")))
                agregarErrorSemantico("'" + yyvsp[0].sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                Nodo aux = new NodoHoja(yyvsp[0].sval+"@"+ambitoVar, t);
                yyval.obj = aux;
            }
        }
        TablaSimbolos.removeToken(yyvsp[0].sval);
        }
break;
case 78:
#line 439 ".\gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                t.setValor(yyvsp[0].sval);
                t.setUso("constante");
                yyval.obj = new NodoHoja(yyvsp[0].sval,t);
                }
break;
case 79:
#line 444 ".\gramatica.y"
{yyval = yyvsp[0]; AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 80:
#line 445 ".\gramatica.y"
{    String ambitoVar = buscarAmbito(ambito,yyvsp[-3].sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + yyvsp[-3].sval + "' no fue declarada");
                                    yyval.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken(yyvsp[-3].sval + "@" + ambitoVar);
                                    String tipo = t.getTipo();
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja(yyvsp[-3].sval + yyvsp[-2].sval + yyvsp[-1].sval + yyvsp[0].sval, t);
                                        yyval.obj = nodo;
                                    }
                                    else {
                                        agregarErrorSemantico("La variable '" + yyvsp[-3].sval + "' no es de un tipo TRIPLE definido");
                                        yyval.obj = new NodoHoja("error");
                                    }
                                }
                             String index = TablaSimbolos.getToken(yyvsp[-1].sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 yyval.obj = new NodoHoja("error");
                             }
                             TablaSimbolos.removeToken(yyvsp[-3].sval);
                            }
break;
case 81:
#line 470 ".\gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[0].sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + yyvsp[0].sval + "' no fue declarada");
                         yyval.obj = new NodoHoja("error");
                     }
                     else {
                         Token t = TablaSimbolos.getToken(yyvsp[0].sval + "@" + ambitoVar);
                         if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))){
                             agregarErrorSemantico("'" + yyvsp[0].sval + "' no es una variable. Es un/a " + t.getUso());
                             yyval.obj = new NodoHoja("error");
                         }
                         else {
                             yyval.obj = new NodoHoja(yyvsp[-1].sval + yyvsp[0].sval + "@" + ambitoVar,t);
                         }
                     }
                     TablaSimbolos.removeToken(yyvsp[0].sval);
                     }
break;
case 82:
#line 487 ".\gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                                        if (t != null && t.getTipo().equals(ENTERO)) {
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                                            yyval.obj = new NodoHoja("error");
                                        }
                                        else if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                            String lexema = t.getLexema().toString();
                                            chequeoFlotantesPositivos(lexema);
                                            t.setUso("constante");
                                            t.setValor(yyvsp[-1].sval + yyvsp[0].sval);
                                            yyval.obj = new NodoHoja(yyvsp[-1].sval + yyvsp[0].sval,t);
                                        }

                    }
break;
case 83:
#line 501 ".\gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[-3].sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + yyvsp[-3].sval + "' no fue declarada");
                                    yyval.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken(yyvsp[-3].sval + "@" + ambitoVar);
                                    String tipo = yyvsp[-4].sval;
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja(yyvsp[-4].sval + yyvsp[-3].sval + yyvsp[-2].sval + yyvsp[-1].sval + yyvsp[0].sval, t);
                                        yyval.obj = nodo;
                                    }
                                    else {
                                        agregarErrorSemantico("La variable '" + yyvsp[-3].sval + "' no es de un tipo TRIPLE definido");
                                        yyval.obj = new NodoHoja("error");
                                    }
                                }
                             String index = TablaSimbolos.getToken(yyvsp[-1].sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 yyval.obj = new NodoHoja("error");
                             }
                             TablaSimbolos.removeToken(yyvsp[-3].sval);
                            }
break;
case 84:
#line 529 ".\gramatica.y"
{String idTipo = yyvsp[0].sval;
                                         Token t = TablaSimbolos.getToken(idTipo);
                                         if (t.getTipo() == null){
                                             if (!TablaSimbolos.existeSimbolo(idTipo + "@" + ambito)){
                                                t.getLexema().setLength(0);
                                                t.getLexema().append(idTipo).append("@").append(ambito);
                                                t.setAmbito(ambito);
                                                t.setUso("tipo");
                                                t.setTipo(yyvsp[-2].sval);
                                                TablaSimbolos.removeToken(idTipo);
                                                TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                                tiposDeclarados.put(yyvsp[0].sval, yyvsp[-2].sval.toLowerCase());
                                             }
                                             else {
                                                TablaSimbolos.removeToken(idTipo);
                                                variableYaDeclarada(idTipo);
                                             }
                                         }
                                         else {
                                            agregarErrorSemantico("La variable '" + idTipo + "' ya fue declarada");
                                            yyval.obj = new NodoComun("error");
                                         }
                                         }
break;
case 85:
#line 552 ".\gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 86:
#line 553 ".\gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 87:
#line 554 ".\gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 88:
#line 555 ".\gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 89:
#line 556 ".\gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 90:
#line 560 ".\gramatica.y"
{
        AnalizadorLexico.agregarEstructura("Se reconocio invocacion a funcion");
        String ambitoVar = buscarAmbito(ambito,yyvsp[-3].sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La funcion '" + yyvsp[-3].sval + "' no fue declarada");
            yyval.obj = new NodoHoja("error");
        }
        else {
            if (enFuncion && funcionActual.equals(yyvsp[-3].sval)){
                yyval.obj = new NodoComun("autoinvocacion");
            }
            else {
                if (funcionesDeclaradas.containsKey(yyvsp[-3].sval + "@" + ambitoVar)){
                    Nodo exp = (Nodo)yyvsp[-1].obj;
                    NodoComun funcion = funcionesDeclaradas.get(yyvsp[-3].sval + "@" + ambitoVar);
                    yyval.obj = generarLlamadoFuncion(funcion,exp,null);
                }
                else {
                    agregarErrorSemantico("La funcion '" + yyvsp[-3].sval + "' no fue declarada");
                    yyval.obj = new NodoHoja("error");
                }
            }
        }
        TablaSimbolos.removeToken(yyvsp[-3].sval);
    }
break;
case 91:
#line 585 ".\gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 92:
#line 586 ".\gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 93:
#line 587 ".\gramatica.y"
{
            AnalizadorLexico.agregarEstructura("Se reconocio conversion");
            String ambitoVar = buscarAmbito(ambito,yyvsp[-6].sval);
            if (ambitoVar.equals("")){
                agregarErrorSemantico("La funcion '" + yyvsp[-6].sval + "' no fue declarada");
                yyval.obj = new NodoHoja("error");
            }
            else {
                if (funcionesDeclaradas.containsKey(yyvsp[-6].sval + "@" + ambitoVar)){
                        Nodo exp = (Nodo)yyvsp[-2].obj;
                        /*exp.setTipo($3.sval);*/
                        NodoComun funcion = funcionesDeclaradas.get(yyvsp[-6].sval + "@" + ambitoVar);
                        yyval.obj = generarLlamadoFuncion(funcion,exp, yyvsp[-4].sval);
                }
                else {
                        agregarErrorSemantico("La funcion '" + yyvsp[-6].sval + "' no fue declarada");
                        yyval.obj = new NodoHoja("error");
                }
            }
            TablaSimbolos.removeToken(yyvsp[-6].sval);
        }
break;
case 95:
#line 612 ".\gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 96:
#line 616 ".\gramatica.y"
{yyval=yyvsp[-1];}
break;
case 97:
#line 617 ".\gramatica.y"
{yyval=yyvsp[-1];}
break;
case 98:
#line 618 ".\gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 99:
#line 622 ".\gramatica.y"
{inIF=true; yyval=yyvsp[0];}
break;
case 100:
#line 626 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; Nodo cuerpo = new NodoComun("Cuerpo",(Nodo)yyvsp[-1].obj);
                                                                                                                                              yyval.obj = new NodoComun("If", (Nodo)yyvsp[-4].obj, cuerpo);}
break;
case 101:
#line 628 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)yyvsp[-1].obj);
                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)yyvsp[-4].obj, cuerpo);}
break;
case 102:
#line 632 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false;  NodoComun nThen = new NodoComun("Then", (Nodo)yyvsp[-3].obj);
                                                                                                                                                                          NodoComun nElse = new NodoComun("Else", (Nodo)yyvsp[-1].obj);
                                                                                                                                                                          Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)yyvsp[-6].obj,cuerpo);
                                                                                                                                                                          if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                               hasReturn = true;
                                                                                                                                                                          }
                                                                                                                                                                          cantReturns = 0;
                                                                                                                                                                          }
break;
case 103:
#line 642 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)yyvsp[-3].obj);
                                                                                                                                                                    NodoComun nElse = new NodoComun("Else", (Nodo)yyvsp[-1].obj);
                                                                                                                                                                    Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                    yyval.obj = new NodoComun("If", (Nodo)yyvsp[-6].obj,cuerpo);
                                                                                                                                                                    if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                    }
                                                                                                                                                                    cantReturns = 0;
                                                                                                                                                                    }
break;
case 104:
#line 652 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)yyvsp[-3].obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("Else", (Nodo)yyvsp[-1].obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                   yyval.obj = new NodoComun("If", (Nodo)yyvsp[-6].obj,cuerpo);

                                                                                                                                                                   if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                   }
                                                                                                                                                                   cantReturns = 0;
                                                                                                                                                                   }
break;
case 105:
#line 663 ".\gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)yyvsp[-3].obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("Else", (Nodo)yyvsp[-1].obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                   yyval.obj = new NodoComun("If", (Nodo)yyvsp[-6].obj,cuerpo);

                                                                                                                                                                   if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                   }
                                                                                                                                                                   cantReturns = 0;
                                                                                                                                                                   }
break;
case 106:
#line 673 ".\gramatica.y"
{yyerror("Falta THEN en IF");}
break;
case 107:
#line 674 ".\gramatica.y"
{yyerror("Falta ELSE en IF");}
break;
case 108:
#line 675 ".\gramatica.y"
{yyerror("Falta END_IF en IF");}
break;
case 109:
#line 680 ".\gramatica.y"
{yyval = yyvsp[-1];}
break;
case 110:
#line 681 ".\gramatica.y"
{yyval = yyvsp[-1]; cantReturns++;}
break;
case 111:
#line 682 ".\gramatica.y"
{yyerror("Las sentencias deben terminar con ';'");}
break;
case 112:
#line 683 ".\gramatica.y"
{yyval = yyvsp[-2];}
break;
case 114:
#line 689 ".\gramatica.y"
{yyval = yyvsp[-1];}
break;
case 115:
#line 690 ".\gramatica.y"
{yyval = yyvsp[-2]; cantReturns++;}
break;
case 116:
#line 691 ".\gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 117:
#line 692 ".\gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 118:
#line 697 ".\gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);}
break;
case 119:
#line 698 ".\gramatica.y"
{yyval = yyvsp[-1];}
break;
case 120:
#line 702 ".\gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 121:
#line 703 ".\gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 122:
#line 704 ".\gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 123:
#line 705 ".\gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 124:
#line 706 ".\gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 125:
#line 707 ".\gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 126:
#line 711 ".\gramatica.y"
{   Nodo exp1 = (Nodo)yyvsp[-2].obj;
                                        Nodo exp2 = (Nodo)yyvsp[0].obj;
                                        if (!(exp1.getNombre().contains("error") || exp2.getNombre().contains("error"))) {
                                            if (!((Nodo)yyvsp[-2].obj).getTipo().equals(((Nodo)yyvsp[0].obj).getTipo())){
                                                agregarErrorSemantico("Los tipos son incompatibles en la condicion");
                                                yyval.obj = new NodoHoja("error");
                                            }
                                            else
                                                yyval.obj = new NodoComun(yyvsp[-1].sval, (Nodo)yyvsp[-2].obj, (Nodo)yyvsp[0].obj);
                                        }
                                        else {
                                            yyval.obj = new NodoHoja("error");
                                        }
                                    }
break;
case 127:
#line 725 ".\gramatica.y"
{inList1 = true;}
break;
case 128:
#line 725 ".\gramatica.y"
{inList1 = false;}
break;
case 129:
#line 725 ".\gramatica.y"
{inList2 = true;}
break;
case 130:
#line 725 ".\gramatica.y"
{inList2 = false;}
break;
case 131:
#line 726 ".\gramatica.y"
{ NodoComun salida = new NodoComun(yyvsp[-5].sval);
      AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
      if (expresiones1.size() == expresiones2.size()){
            Nodo aux;
            for (int i = 0; i < expresiones1.size(); i++) {
                Nodo exp1 = expresiones1.get(i);
                Nodo exp2 = expresiones2.get(i);
                if (exp1.getNombre().contains("error") || exp2.getNombre().contains("error")){
                    salida = new NodoComun("error");
                    break;
                }
                if (!(exp1.getTipo().equals(exp2.getTipo()))){
                    agregarErrorSemantico("Las expresiones en la posicion " + i + " no tienen el mismo tipo");
                    aux = new NodoHoja("error");
                    }
                else {
                    aux = new NodoComun(yyvsp[-5].sval, exp1, exp2);
                    aux.setUso("pattern_matching");
                }
                if (salida.getIzq() == null)
                    salida.setIzq(aux);
                else {
                    if (salida.getDer() == null)
                        salida.setDer(aux);
                    else {
                        salida = new NodoComun(yyvsp[-5].sval,salida,aux);
                    }
                }
            }
      }
      else {
        agregarErrorSemantico("La cantidad de elementos a comparar en pattern matching no coincide");
      }
      expresiones1.clear();
      expresiones2.clear();
      yyval.obj = salida;
    }
break;
case 132:
#line 763 ".\gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 133:
#line 768 ".\gramatica.y"
{
    if (inList1)
            expresiones1.add((Nodo)yyvsp[0].obj);
        if (inList2)
            expresiones2.add((Nodo)yyvsp[0].obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[0].obj);
    }
break;
case 134:
#line 778 ".\gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)yyvsp[0].obj);
    if (inList2)
        expresiones2.add((Nodo)yyvsp[0].obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[0].obj);
    }
break;
case 135:
#line 785 ".\gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)yyvsp[0].obj);
    if (inList2)
        expresiones2.add((Nodo)yyvsp[0].obj);
    yyval = yyvsp[0];
    }
break;
case 136:
#line 792 ".\gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 137:
#line 796 ".\gramatica.y"
{   Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            yyval.obj = new NodoComun("Outf", new NodoHoja(yyvsp[-1].sval, t));
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 138:
#line 802 ".\gramatica.y"
{   Nodo exp = (Nodo)yyvsp[-1].obj;
                                 if (!exp.getNombre().contains("error")){
                                     Token t = new Token(exp.getToken());
                                     /*t.setUso("mensaje");*/
                                     t.setTipo(exp.getTipo());
                                     yyval.obj = new NodoComun("Outf", new NodoHoja(exp.getNombre(),t));
                                 }
                                 else {
                                    yyval.obj = new NodoComun("error");
                                 }
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }
break;
case 139:
#line 815 ".\gramatica.y"
{yyerror("Los print unicamente pueden contener expresiones o cadenas");}
break;
case 140:
#line 816 ".\gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 1910 "y.tab.c"
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
