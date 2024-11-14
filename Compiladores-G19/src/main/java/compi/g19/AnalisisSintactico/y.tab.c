#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package compi.g19.AnalisisSintactico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import compi.g19.AnalisisLexico.*;
import compi.g19.GeneracionDeCodigo.*;
#line 16 "y.tab.c"
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
   11,   11,   11,   11,   11,   11,   11,   36,   36,   37,
   37,   37,   37,   34,   34,   38,   38,   38,   38,   38,
   38,   18,   18,   18,   32,   39,   39,   39,   12,   12,
   12,
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
    9,    9,    9,    9,    8,    8,    7,    2,    2,    3,
    2,    2,    1,    3,    2,    1,    1,    1,    1,    1,
    1,    3,    7,    1,    3,    3,    1,    1,    4,    4,
    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,   98,    0,    0,    0,   43,   44,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   41,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    4,
    6,    8,    9,   47,    0,    0,    0,    0,    2,   40,
    0,   77,    0,   78,    0,    0,   73,  128,   91,    0,
    0,    0,    0,    0,    1,    0,  131,    0,    0,    0,
    0,    0,    0,    0,   48,   46,    0,    0,    0,    0,
    0,    0,    0,  124,    0,    0,    0,    0,    0,   81,
    0,    0,    0,    0,   89,    0,   90,    0,    0,  129,
  130,    0,   87,    0,    0,    0,    0,    0,    0,    0,
   23,   22,   45,    0,   54,    0,    0,    0,    0,    0,
    0,  116,  117,  118,  121,  120,  119,    0,    0,    0,
   69,    0,   70,    0,   74,   71,   75,   72,    0,    0,
    0,   86,    0,   85,   88,    0,    0,   97,    0,    0,
   21,   20,   95,    0,   64,    0,    0,    0,    0,    0,
    0,    0,  113,    0,    0,    0,    0,    0,   79,    0,
    0,    0,   84,   83,    0,    0,  115,   96,    0,    0,
   53,   63,    0,   61,   50,    0,    0,    0,    0,    0,
    0,  111,    0,  112,    0,   82,   92,   36,   37,    0,
    0,    0,  114,    0,   59,    0,   52,    0,    0,  109,
   94,    0,   93,   99,    0,    0,  100,    0,  110,    0,
    0,    0,    0,    0,   65,   51,    0,    0,    0,    0,
    0,  108,  106,  105,    0,    0,    0,    0,    0,  123,
  101,  103,  104,  102,    0,    0,    0,    0,    0,    0,
    0,   35,    0,    0,   32,    0,   34,   33,   31,
};
short yydgoto[] = {                                       3,
   12,   13,   14,   15,   16,   46,   17,   18,   19,   20,
   21,   22,   23,   37,  111,   38,   39,   86,  201,   87,
   24,   25,   81,  156,  206,   82,   83,  157,  189,   56,
   57,   62,  214,  166,   26,  190,  167,  128,   63,
};
short yysindex[] = {                                   -145,
  369,  436,    0,  -32,    0,  436,  -19,   -2,    0,    0,
  -15,  378,    0,  -29,   14, -176,    0,    0,    0,    0,
    0,    0,    0,    0,   42,   58,  405,   34,  103, -187,
  420,  -38,  -58, -151, -153, -154,   76,    0,    0,    0,
    0,    0,    0,    0, -124,  -34,   -7,   -5,    0,    0,
  -13,    0, -229,    0,   -6,    9,    0,    0,    0,  125,
  111,  102,  112,   65,    0,  120,    0,  359, -151,  -43,
  105,  -89,  -37,  394,    0,    0,  -88,    0,  -86,  -69,
  156,  167,  169,    0,   80,  213,  134,  -47,  165,    0,
  119,  126,  162,  164,    0,  117,    0,  117,    6,    0,
    0,    2,    0,   25,   32,   -9,  -32,  342,  227,  234,
    0,    0,    0,  428,    0,   38,   45, -155,   -6,  260,
  310,    0,    0,    0,    0,    0,    0,  117,  223,   57,
    0,    9,    0,    9,    0,    0,    0,    0,  445,   -6,
  117,    0, -107,    0,    0,   -5,  265,    0,  269,  -92,
    0,    0,    0,  295,    0,   71,  428,  288,  428,  428,
    0,  -49,    0,  337,  358,  -77,   85,   -6,    0,  262,
  315,   -6,    0,    0,   35,  -73,    0,    0,  299,  117,
    0,    0,  303,    0,    0,  129,  330,  326,  347, -109,
  289,    0,  332,    0,  197,    0,    0,    0,    0, -152,
  160,  163,    0,  464,    0,  133,    0,   80,    0,    0,
    0,  337,    0,    0,  337,  382,    0, -128,    0, -128,
  384,  -18,  397,  399,    0,    0,  387, -128, -128, -128,
 -128,    0,    0,    0,  429,  407,   -5,  441,  447,    0,
    0,    0,    0,    0,   -5,  456,  435,   -5,   -5,  444,
   -5,    0,  457,  461,    0,  469,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0, -168,    0,    0,    0,    0,    0,    0,
    0,  511,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  518,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  483,  204,    0,    0,    0,    0,
    1,    0,    0,    0,  116,   47,    0,    0,    0,  484,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -12,    0,    0,
  487,    0,    0,    0,    0,    0,    0,    0,   24,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  259,    0,    0,    0,    0,  484,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   70,    0,   93,    0,    0,    0,    0,    0,  101,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  271,    0,  259,  259,
  229,    0,    0,    0,    0,    0,    0,  -41,    0,    0,
    0,  139,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  256,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  159,
  -36,  -35,  -21,  141,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  225,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   74,   26,    0,  426,  -31,    0,    0,    0,    0,  423,
    0,    0,    0,  497,  -60,    0,    0,  293, -159,  408,
   66,    0,  419,  127,    0,    0,    0,    0, -105,  218,
  239,  -62,  -28,  -93,    0,  -94, -138,  381,    0,
};
#define YYTABLESIZE 712
short yytable[] = {                                     122,
   76,   69,   67,  109,   27,   30,   53,   29,  158,   77,
  125,  127,  126,  112,  150,   80,  202,  122,  104,   29,
   32,  237,  120,   80,   36,  191,   29,   89,   55,   42,
   85,   55,   90,   79,   85,   53,   91,   41,   92,   53,
  222,   76,   76,   76,   76,   76,   68,   76,  152,  146,
   93,  183,   41,  158,  158,   94,   41,   34,   30,   76,
   76,   76,   76,  143,   80,   80,   80,   80,   80,   66,
   80,  193,   43,  229,   64,   27,  231,   88,   53,   31,
   44,   47,   80,   80,   80,   80,   80,   68,   42,   68,
   68,   68,   67,  200,   61,   45,  218,   48,   70,   71,
  220,   78,   35,   42,   72,   68,   68,   68,   68,  221,
   66,    1,   66,   66,   66,   38,   74,  228,    9,   10,
  230,    2,    9,   10,   53,  198,  199,  211,   66,   66,
   66,   66,   75,   67,  102,   67,   67,   67,   39,  155,
  213,  125,   97,   59,  126,  227,  211,   53,  173,  174,
   96,   67,   67,   67,   67,   98,  212,   99,  107,  213,
  100,   53,  217,   53,  107,   95,  105,   91,  113,   92,
   53,    5,  106,   11,   38,  178,   91,    7,   92,  107,
  114,   28,  182,   11,  155,  155,    5,  115,   10,  233,
  194,  234,    7,  125,  127,  126,  116,   39,   11,  241,
  242,  243,  244,   12,  198,  199,   53,  117,   53,  122,
  123,  124,  118,  103,  129,    9,   10,  107,   51,  107,
   27,   30,   76,   52,   66,   28,    5,   27,   30,  108,
   27,   30,    7,   27,   30,   29,  122,  122,   11,   27,
   30,   35,   29,  236,   42,   29,   84,   51,   29,   78,
   84,   51,   52,  121,   29,  130,   52,   76,  142,   76,
   76,   76,   12,  141,   76,   26,    9,   10,   76,   56,
   76,   76,   58,   76,   76,   76,   76,   33,   76,   76,
   80,  144,   80,   80,   80,  185,  186,   80,  145,   50,
   51,   80,  153,   80,   80,   52,   80,   80,   80,   80,
  162,   80,   80,   68,  159,   68,   68,   68,  132,  134,
   68,  160,  198,  199,   68,  169,   68,   68,  170,   68,
   68,   68,   68,  176,   68,   68,   66,  177,   66,   66,
   66,  136,  138,   66,  180,   58,   51,   66,  181,   66,
   66,   52,   66,   66,   66,   66,  184,   66,   66,   67,
  195,   67,   67,   67,  196,  197,   67,  203,   58,   51,
   67,  205,   67,   67,   52,   67,   67,   67,   67,  208,
   67,   67,   38,   51,  131,   51,    9,   10,   52,   38,
   52,  133,   51,   38,  209,   38,   38,   52,   38,   38,
   38,   38,  122,  123,  124,   39,  207,   28,  147,  101,
  226,   91,   39,   92,   28,  210,   39,   28,   39,   39,
   28,   39,   39,   39,   39,  107,   28,  135,   51,  137,
   51,  223,  107,   52,  224,   52,  107,  240,  107,  107,
   11,  107,  107,  107,  107,   55,   60,   11,  175,   68,
  232,   11,  235,   11,   11,   10,   11,   11,   11,   11,
   54,   54,   10,  107,   54,  238,   10,  239,   10,   10,
    5,   10,   10,   10,   10,  246,    7,   12,  245,  154,
   54,   12,   11,   12,   12,  252,   12,   12,   12,   12,
  248,   26,  151,  107,  255,  171,  249,   91,   26,   92,
    5,   26,  119,  108,   26,  251,    7,  257,  110,  110,
   26,  258,   11,  139,  225,  140,   91,   54,   92,  259,
    5,  108,  115,   54,   54,   54,   54,    3,   54,  115,
   54,  108,   49,  115,  108,  115,   62,  127,   54,  247,
   57,  115,   73,  149,  110,  168,  161,  250,   60,    0,
  253,  254,  187,  256,  211,  107,  149,    0,  172,    0,
   54,    0,    5,    0,  215,    0,    0,  213,    7,    0,
    0,  154,    0,   54,   11,  163,  107,    0,   54,    0,
    0,    0,    0,    5,  164,  179,  165,    0,    0,    7,
    0,    0,    0,    0,    0,   11,    0,  204,  107,  188,
  149,  179,  163,  107,    0,    5,    0,  148,  107,  219,
    5,    7,   54,  165,    0,    5,    7,   11,    0,  154,
    0,    7,   11,  192,  107,  119,  216,   11,  179,    0,
  216,    5,    0,    0,    0,    4,    0,    7,    0,    0,
   54,    0,    5,   11,    4,    6,    0,  188,    7,    8,
  188,    5,    9,   10,   11,   40,    0,    7,    8,    0,
  107,    9,   10,   11,    0,    0,    0,    5,    0,   54,
  108,    4,    0,    7,    0,    0,    0,   54,    5,   11,
   54,   54,   49,   54,    7,    8,    4,    0,    9,   10,
   11,    0,    0,    5,    4,    0,    0,   65,    0,    7,
    8,    5,    4,    9,   10,   11,    0,    7,    8,    5,
  154,    9,   10,   11,    0,    7,    8,    0,    0,    9,
   10,   11,
};
short yycheck[] = {                                      41,
    0,   60,   41,   41,   41,   41,   45,   40,  114,   44,
   60,   61,   62,   74,  108,   47,  176,   59,   62,   41,
   40,   40,   85,    0,   40,  164,   40,  257,   41,   59,
   40,   44,  262,   41,   40,   45,   43,   12,   45,   45,
  200,   41,   42,   43,   44,   45,    0,   47,  109,   59,
   42,  157,   27,  159,  160,   47,   31,   60,   91,   59,
   60,   61,   62,   62,   41,   42,   43,   44,   45,    0,
   47,  165,   59,  212,  262,    2,  215,   91,   45,    6,
  257,   40,   59,   60,   61,   62,  118,   41,  257,   43,
   44,   45,    0,   59,   29,  272,  191,   40,   33,   34,
  195,  257,  257,  272,  258,   59,   60,   61,   62,  262,
   41,  257,   43,   44,   45,    0,   41,  212,  274,  275,
  215,  267,  274,  275,   45,  278,  279,  256,   59,   60,
   61,   62,  257,   41,   69,   43,   44,   45,    0,  114,
  269,   41,   41,   41,   44,  208,  256,   45,  256,  257,
   40,   59,   60,   61,   62,   44,  266,   93,    0,  269,
   41,   45,  191,   45,  257,   41,   62,   43,  257,   45,
   45,  264,  262,    0,   59,  268,   43,  270,   45,  257,
  267,   41,  157,  276,  159,  160,  264,  257,    0,  218,
  268,  220,  270,   60,   61,   62,   41,   59,  276,  228,
  229,  230,  231,    0,  278,  279,   45,   41,   45,  259,
  260,  261,   44,  257,  262,  274,  275,   59,  257,  257,
  257,  257,  257,  262,  263,  258,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  262,  257,  267,  256,  257,  270,  257,
  256,  257,  262,   41,  276,   91,  262,  257,  257,  259,
  260,  261,   59,  258,  264,   41,  274,  275,  268,   41,
  270,  271,   44,  273,  274,  275,  276,  280,  278,  279,
  257,  257,  259,  260,  261,  159,  160,  264,  257,  256,
  257,  268,   59,  270,  271,  262,  273,  274,  275,  276,
   41,  278,  279,  257,  267,  259,  260,  261,   91,   92,
  264,  267,  278,  279,  268,   93,  270,  271,  262,  273,
  274,  275,  276,   59,  278,  279,  257,   59,  259,  260,
  261,   93,   94,  264,   40,  256,  257,  268,  268,  270,
  271,  262,  273,  274,  275,  276,   59,  278,  279,  257,
  266,  259,  260,  261,   93,   41,  264,   59,  256,  257,
  268,   59,  270,  271,  262,  273,  274,  275,  276,   40,
  278,  279,  257,  257,  256,  257,  274,  275,  262,  264,
  262,  256,  257,  268,   59,  270,  271,  262,  273,  274,
  275,  276,  259,  260,  261,  257,  268,  257,  106,   41,
  268,   43,  264,   45,  264,   59,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  256,  257,  256,
  257,  262,  264,  262,  262,  262,  268,   41,  270,  271,
  257,  273,  274,  275,  276,   28,   29,  264,  146,   32,
   59,  268,   59,  270,  271,  257,  273,  274,  275,  276,
   28,   29,  264,  257,   32,   59,  268,   59,  270,  271,
  264,  273,  274,  275,  276,   59,  270,  264,   40,  273,
   48,  268,  276,  270,  271,   41,  273,  274,  275,  276,
   40,  257,  256,  257,   41,   41,   40,   43,  264,   45,
  264,  267,   85,  267,  270,   40,  270,   41,   73,   74,
  276,   41,  276,   96,   41,   98,   43,   85,   45,   41,
    0,  256,  257,   91,   92,   93,   94,    0,   96,  264,
   98,  266,   40,  268,  269,  270,  268,   44,  106,  237,
   44,  276,   36,  108,  109,  128,  118,  245,  268,   -1,
  248,  249,  162,  251,  256,  257,  121,   -1,  141,   -1,
  128,   -1,  264,   -1,  266,   -1,   -1,  269,  270,   -1,
   -1,  273,   -1,  141,  276,  256,  257,   -1,  146,   -1,
   -1,   -1,   -1,  264,  265,  150,  267,   -1,   -1,  270,
   -1,   -1,   -1,   -1,   -1,  276,   -1,  180,  257,  164,
  165,  166,  256,  257,   -1,  264,   -1,  256,  257,  268,
  264,  270,  180,  267,   -1,  264,  270,  276,   -1,  273,
   -1,  270,  276,  256,  257,  208,  191,  276,  193,   -1,
  195,  264,   -1,   -1,   -1,  257,   -1,  270,   -1,   -1,
  208,   -1,  264,  276,  257,  267,   -1,  212,  270,  271,
  215,  264,  274,  275,  276,  268,   -1,  270,  271,   -1,
  257,  274,  275,  276,   -1,   -1,   -1,  264,   -1,  237,
  267,  257,   -1,  270,   -1,   -1,   -1,  245,  264,  276,
  248,  249,  268,  251,  270,  271,  257,   -1,  274,  275,
  276,   -1,   -1,  264,  257,   -1,   -1,  268,   -1,  270,
  271,  264,  257,  274,  275,  276,   -1,  270,  271,  264,
  273,  274,  275,  276,   -1,  270,  271,   -1,   -1,  274,
  275,  276,
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
"bloque_if : encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' THEN cuerpo_if_bloque cuerpo_if_unico fin_if",
"bloque_if : encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico",
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
#line 601 "gramatica.y"
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
static Map<String,String> tiposDeclarados = new HashMap<>(); //clave: lexema del tipo ; valor: tipo del tipo
public static Map<String,NodoComun> funcionesDeclaradas = new HashMap<>();

public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
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

private NodoComun controlarTipos(Nodo nodo1, String op, Nodo nodo3){
    NodoComun ret = new NodoComun(op, nodo1, nodo3);
    if (!(nodo1.getLexema().contains("error") || nodo1.getLexema().contains("error"))) {
    if (!(nodo1.getTipo().equals(nodo3.getTipo())))
        agregarErrorSemantico("Incompatibilidad de tipos en la "+op);
    else
        ret.setTipo(nodo1.getTipo());
    }

    return ret;
}

private Nodo generarLlamadoFuncion(NodoComun funcion, Token copia){
    if (funcion != null){
        Nodo param = funcion.getIzq();
        if (param.getTipo().equals(copia.getTipo())){
            param.setValor(copia.getValor());
        }
        else {
            agregarErrorSemantico("El tipo del parametro real no coincide con el del parametro formal");
        }
    }
    return funcion;
}

public NodoComun getRaiz(){
    return this.raiz;
}

private boolean idCompatible(String id){
    return id.startsWith("x") || id.startsWith("s");
}

public static List<Nodo> getFuncionesDeclaradas(){
    return new ArrayList<>(funcionesDeclaradas.values());
}
#line 632 "y.tab.c"
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
#line 20 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa"); raiz = new NodoComun("PROGRAMA", (Nodo)yyvsp[-1].obj);}
break;
case 2:
#line 21 "gramatica.y"
{yyerror("El programa debe tener un nombre");}
break;
case 3:
#line 22 "gramatica.y"
{yyerror("Falta delimitador END del programa");}
break;
case 4:
#line 23 "gramatica.y"
{yyerror("Falta delimitador BEGIN del programa");}
break;
case 5:
#line 24 "gramatica.y"
{yyerror("Faltan los delimitadores del programa");}
break;
case 6:
#line 27 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo)yyvsp[-1].obj, (Nodo)yyvsp[0].obj);}
break;
case 7:
#line 28 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 8:
#line 32 "gramatica.y"
{yyval.obj = new NodoHoja("Sentencia Declarativa");}
break;
case 9:
#line 33 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 10:
#line 34 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
#line 35 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 12:
#line 39 "gramatica.y"
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
#line 59 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
#line 60 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
#line 64 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion"); yyval=yyvsp[0];}
break;
case 16:
#line 65 "gramatica.y"
{yyval = yyvsp[0]; AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 17:
#line 66 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 18:
#line 67 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 19:
#line 68 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 20:
#line 73 "gramatica.y"
{ yyval.obj = new NodoComun("FOR",(Nodo)yyvsp[-2].obj,(Nodo)yyvsp[0].obj);}
break;
case 21:
#line 74 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
#line 75 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
#line 76 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 24:
#line 80 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 25:
#line 81 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 26:
#line 85 "gramatica.y"
{  String ambitoVar = buscarAmbito(ambito,yyvsp[-7].sval);
                                                                   NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                   if (ambitoVar.equals("")) {
                                                                       agregarErrorSemantico("La variable '" + yyvsp[-7].sval + "' no fue declarada");
                                                                       idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                   }
                                                                   else {
                                                                       Token t = TablaSimbolos.getToken(yyvsp[-7].sval + ":" + ambitoVar);
                                                                       if (!t.getTipo().equals(ENTERO)) {
                                                                           agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                           idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                       }
                                                                       else {
                                                                           idAsignacion = new NodoHoja(yyvsp[-7].sval + ":" + ambitoVar);
                                                                       }
                                                                   }

                                                                    NodoHoja constante = new NodoHoja(yyvsp[-5].sval);
                                                                    Nodo asignacion = new NodoComun(yyvsp[-6].sval, idAsignacion, constante); /*Cambie sval x obj esto tiraba error el Parser*/

                                                                    NodoHoja constanteUpDown = new NodoHoja(yyvsp[0].sval);
                                                                    Nodo incremento = new NodoComun("INCREMENTO", (Nodo)yyvsp[-1].obj, constanteUpDown); /*Idem*/
                                                                    Nodo condicion = (Nodo)yyvsp[-3].obj;

                                                                    Nodo asgnacionIncremento = new NodoComun("ASIGNACION E INCREMENTO", asignacion, incremento);

                                                                    yyval.obj = new NodoComun ("ENCABEZADO FOR", asgnacionIncremento, condicion);

                                                                    AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");
                                                                }
break;
case 27:
#line 115 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
#line 116 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
#line 117 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
#line 118 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
#line 122 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[-11].sval);
                                                                                       NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                                       if (ambitoVar.equals("")) {
                                                                                            agregarErrorSemantico("La variable '" + yyvsp[-11].sval + "' no fue declarada");
                                                                                            idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                                       }
                                                                                       else {
                                                                                             Token t = TablaSimbolos.getToken(yyvsp[-11].sval + ":" + ambitoVar);
                                                                                             if (!t.getTipo().equals(ENTERO)) {
                                                                                                    agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                                                    idAsignacion = new NodoHoja("error semantico"); /*??*/
                                                                                             }
                                                                                             else {
                                                                                                    idAsignacion = new NodoHoja(yyvsp[-11].sval + ":" + ambitoVar);
                                                                                             }
                                                                                       }

                                                                                       Nodo asignacion = new NodoComun("ASIGNACION", idAsignacion, (Nodo)yyvsp[-9].obj); /*Cambie sval x obj*/
                                                                                       Nodo incremento = new NodoComun("INCREMENTO", (Nodo)yyvsp[-5].obj, (Nodo)yyvsp[-4].obj); /*Idem*/
                                                                                       Nodo condicion = (Nodo)yyvsp[-7].obj;
                                                                                       Nodo iteradorCondicion = (Nodo)yyvsp[-1].obj;

                                                                                       Nodo asgnacionIncremento = new NodoComun("ASIGNACION E INCREMENTO", asignacion, incremento);
                                                                                       Nodo condiciones = new NodoComun("ASIGNACION E INCREMENTO", condicion, iteradorCondicion);

                                                                                       yyval.obj = new NodoComun ("ENCABEZADO FOR", asgnacionIncremento, condiciones);

                                                                                       AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");
                                                                                       }
break;
case 32:
#line 152 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
#line 153 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
#line 154 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
#line 155 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 36:
#line 159 "gramatica.y"
{yyval.obj = new NodoHoja("UP");}
break;
case 37:
#line 160 "gramatica.y"
{yyval.obj = new NodoHoja("DOWN");}
break;
case 38:
#line 164 "gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,yyvsp[-2].sval);
                              Nodo asignacion = null;
                              if (ambitoVar.equals(""))
                                  agregarErrorSemantico("La variable '" + yyvsp[-2].sval + "' no fue declarada");
                              else {
                                  Token t = TablaSimbolos.getToken(yyvsp[-2].sval + ":" + ambitoVar);
                                  if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))){
                                    agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")" );
                                    asignacion = new NodoHoja("error semantico");
                                  }else {
                                    NodoHoja id = new NodoHoja(yyvsp[-2].sval +":"+ambitoVar);
                                    asignacion= new NodoComun(yyvsp[-1].sval ,id, (Nodo)yyvsp[0].obj);
                                  }
                              }
                              yyval.obj = asignacion;
                            }
break;
case 40:
#line 181 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 42:
#line 186 "gramatica.y"
{ String ambitoVar = buscarAmbito(ambito,yyvsp[0].sval);
           if (ambitoVar.equals(""))
                agregarErrorSemantico("El tipo '" + yyvsp[0].sval + "' no fue declarado");
           else {
            Token t = TablaSimbolos.getToken(yyvsp[0].sval + ":" + ambitoVar);
            if (t.getUso() == null || !t.getUso().equals("tipo"))
                yyerror("El identificador '" + yyvsp[0].sval + "' no es un tipo definido");
            else {
                tipoActual = yyvsp[0].sval;
            }
            }
         }
break;
case 43:
#line 201 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 44:
#line 202 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 45:
#line 206 "gramatica.y"
{varDeclaradas.add(yyvsp[0].sval);}
break;
case 46:
#line 207 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 47:
#line 208 "gramatica.y"
{varDeclaradas.add(yyvsp[0].sval);}
break;
case 48:
#line 212 "gramatica.y"
{hasReturn = false;
                String idFuncion = yyvsp[0].sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (!TablaSimbolos.existeSimbolo(idFuncion + ":" + ambito)){
                    t.getLexema().setLength(0);
                    t.getLexema().append(idFuncion).append(":").append(ambito); /*aca agrega una vez el ambito*/
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
                 NodoComun encabezado = new NodoComun(idFuncion + ":" + ambito);
                 encabezado.setTipo(tipoActual);
                 addAmbito(idFuncion);
                 yyval.obj = encabezado;
                 }
break;
case 49:
#line 233 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 50:
#line 237 "gramatica.y"
{ if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         Nodo parametro = (Nodo)yyvsp[-3].obj;
                                                         Token t = TablaSimbolos.getToken(parametro.getNombre());
                                                         if (!TablaSimbolos.existeSimbolo(parametro.getNombre() + ":" + ambito)){
                                                             t.getLexema().setLength(0);
                                                             t.getLexema().append(parametro.getNombre()).append(":").append(ambito);
                                                             t.setAmbito(ambito);
                                                             t.setUso("parametro");
                                                             t.setTipo(tipoActual);
                                                             TablaSimbolos.removeToken(parametro.getNombre());
                                                             TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                                         }
                                                         NodoComun funcion = (NodoComun)yyvsp[-5].obj; /*Encabezado con nombre funcion, este tiene el tipo*/

                                                         funcion.setIzq(parametro); /*Parametro*/
                                                         funcion.setDer((Nodo)yyvsp[0].obj); /*Cuerpo funcion*/

                                                         funcionesDeclaradas.put(funcion.getNombre(),funcion);
                                                         removeAmbito();
                                                         }
break;
case 52:
#line 259 "gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 53:
#line 260 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 54:
#line 264 "gramatica.y"
{
               Token t = TablaSimbolos.getToken(yyvsp[0].sval);
               if (t != null){
                   t.getLexema().setLength(0);
                   t.getLexema().append(yyvsp[0].sval).append(":").append(ambito);
                   t.setAmbito(ambito);
                   t.setUso("parametro");
                   t.setTipo(tipoActual);
                   TablaSimbolos.removeToken(yyvsp[0].sval);
                   TablaSimbolos.addSimbolo(String.valueOf(t.getLexema()),t);
               }
              Nodo param = new NodoHoja(yyvsp[0].sval);
              param.setTipo(yyvsp[-1].sval);
              yyval.obj = param;
            }
break;
case 55:
#line 279 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 59:
#line 292 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);}
break;
case 60:
#line 293 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 61:
#line 294 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 62:
#line 295 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio");}
break;
case 63:
#line 300 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo) yyvsp[-1].obj, (Nodo) yyvsp[0].obj);}
break;
case 64:
#line 301 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 65:
#line 306 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           if (!inIF){
                                hasReturn = true;
                           }
                           yyval.obj = new NodoComun("RETURN", (Nodo)yyvsp[-1].obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 66:
#line 317 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(yyvsp[-2].sval);
                            Nodo nIzq = new NodoHoja(yyvsp[-2].sval, tIzq);

                            Token tDer = TablaSimbolos.getToken(yyvsp[0].sval);
                            Nodo nDer = new NodoHoja(yyvsp[0].sval, tIzq);

                            yyval.obj = controlarTipos(nIzq,yyvsp[-1].sval,nDer);
                          }
break;
case 67:
#line 326 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(yyvsp[-2].sval);
                              Nodo nIzq = new NodoHoja(yyvsp[-2].sval, tIzq);

                              Token tDer = TablaSimbolos.getToken(yyvsp[0].sval);
                              Nodo nDer = new NodoHoja(yyvsp[0].sval, tIzq);

                              yyval.obj = controlarTipos(nIzq,yyvsp[-1].sval,nDer);
                             }
break;
case 68:
#line 334 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 69:
#line 335 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 70:
#line 336 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
#line 340 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(yyvsp[-2].sval);
                         Nodo nIzq = new NodoHoja(yyvsp[-2].sval, tIzq);

                         Token tDer = TablaSimbolos.getToken(yyvsp[0].sval);
                         Nodo nDer = new NodoHoja(yyvsp[0].sval, tIzq);

                         yyval.obj = controlarTipos(nIzq,yyvsp[-1].sval,nDer);
                        }
break;
case 72:
#line 348 "gramatica.y"
{ Token tIzq = TablaSimbolos.getToken(yyvsp[-2].sval);
                           Nodo nIzq = new NodoHoja(yyvsp[-2].sval, tIzq);

                           Token tDer = TablaSimbolos.getToken(yyvsp[0].sval);
                           Nodo nDer = new NodoHoja(yyvsp[0].sval, tIzq);

                           yyval.obj = controlarTipos(nIzq,yyvsp[-1].sval,nDer);
                          }
break;
case 73:
#line 356 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 74:
#line 357 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 75:
#line 358 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 76:
#line 362 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[0].sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La variable '" + yyvsp[0].sval + "' no fue declarada");
            Nodo aux = new NodoHoja(yyvsp[0].sval);
            yyval.obj = aux;
        }
        else {
            Token t = TablaSimbolos.getToken(yyvsp[0].sval + ":" + ambitoVar);
            if (!(t.getUso().equals("variable") || t.getUso().equals("parametro")))
                agregarErrorSemantico("'" + yyvsp[0].sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                Nodo aux = new NodoHoja(yyvsp[0].sval+":"+ambitoVar, t);
                yyval.obj = aux;
                TablaSimbolos.removeToken(yyvsp[0].sval);
            }
        }
        }
break;
case 77:
#line 379 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                t.setValor(yyvsp[0].sval);
                t.setUso("constante");
                yyval.obj = new NodoHoja(yyvsp[0].sval,t);
                }
break;
case 78:
#line 384 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 79:
#line 385 "gramatica.y"
{    String ambitoVar = buscarAmbito(ambito,yyvsp[-3].sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + yyvsp[-3].sval + "' no fue declarada");
                                    yyval.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken(yyvsp[-3].sval + ":" + ambitoVar);
                                    String tipo = t.getTipo();
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja(yyvsp[-3].sval + yyvsp[-2].sval + yyvsp[-1].sval + yyvsp[0].sval);
                                        nodo.setTipo(tipoTriple);
                                        yyval.obj = nodo;
                                    }
                                    else {
                                        agregarErrorSemantico("La variable '" + yyvsp[-3].sval + "' no es de un tipo TRIPLE definido");
                                        yyval.obj = new NodoHoja("error");
                                    }
                                }
                             String index = TablaSimbolos.getToken(yyvsp[-1].sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3"))))
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 yyval.obj = new NodoHoja("error");
                            }
break;
case 80:
#line 409 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[0].sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + yyvsp[0].sval + "' no fue declarada");
                         yyval.obj = new NodoHoja("error");
                     }
                     else {
                         Token t = TablaSimbolos.getToken(yyvsp[0].sval + ":" + ambitoVar);
                         if (!t.getUso().equals("variable"))
                             agregarErrorSemantico("'" + yyvsp[0].sval + "' no es una variable. Es un/a " + t.getUso());
                         else {
                             yyval.obj = new NodoHoja(yyvsp[0].sval + ":" + ambitoVar,t);
                             TablaSimbolos.removeToken(yyvsp[0].sval);
                         }
                     }
                     }
break;
case 81:
#line 424 "gramatica.y"
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
case 82:
#line 438 "gramatica.y"
{yyval.obj = new NodoHoja("hola");}
break;
case 83:
#line 442 "gramatica.y"
{String idTipo = yyvsp[0].sval;
                                         Token t = TablaSimbolos.getToken(idTipo);
                                         if (!TablaSimbolos.existeSimbolo(idTipo + ":" + ambito)){
                                            t.getLexema().setLength(0);
                                            t.getLexema().append(idTipo).append(":").append(ambito);
                                            t.setAmbito(ambito);
                                            t.setUso("tipo");
                                            t.setTipo(yyvsp[-2].sval);
                                            TablaSimbolos.removeToken(idTipo);
                                            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                            tiposDeclarados.put(yyvsp[0].sval, yyvsp[-2].sval);
                                            }
                                         else {
                                            TablaSimbolos.removeToken(idTipo);
                                            variableYaDeclarada(idTipo);
                                         }
                                         }
break;
case 84:
#line 459 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 85:
#line 460 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 86:
#line 461 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 87:
#line 462 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 88:
#line 463 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 89:
#line 467 "gramatica.y"
{
                            String ambitoVar = buscarAmbito(ambito,yyvsp[-3].sval);
                             if (ambitoVar.equals(""))
        agregarErrorSemantico("La funcion '" + yyvsp[-3].sval + "' no fue declarada");
        else {
        if (funcionesDeclaradas.containsKey(yyvsp[-3].sval + ":" + ambitoVar)){
            Nodo exp = (Nodo)yyvsp[-1].obj;
            Token copiaValor = new Token(exp.getToken());
            NodoComun funcion = funcionesDeclaradas.get(yyvsp[-3].sval + ":" + ambitoVar);
            yyval.obj = generarLlamadoFuncion(funcion,copiaValor);
        }
        else {
            agregarErrorSemantico("La funcion '" + yyvsp[-3].sval + "' no fue declarada");
        }
     }
        }
break;
case 90:
#line 483 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 91:
#line 484 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 92:
#line 485 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
break;
case 94:
#line 490 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 95:
#line 494 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 96:
#line 495 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 97:
#line 496 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 98:
#line 500 "gramatica.y"
{inIF=true; yyval=yyvsp[0];}
break;
case 99:
#line 504 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-1].obj);
                                                                                                                                              Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                              yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-4].obj, cuerpo);}
break;
case 100:
#line 507 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; yyval.obj = new NodoComun("CUERPO", (Nodo)yyvsp[-1].obj);
                                                                                                                                          Nodo cuerpo = (Nodo)yyval.obj;
                                                                                                                                          yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-4].obj, cuerpo);}
break;
case 101:
#line 512 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false;  NodoComun nThen = new NodoComun("THEN", (Nodo)yyvsp[-3].obj);
                                                                                                                                                                          NodoComun nElse = new NodoComun("ELSE", (Nodo)yyvsp[-1].obj);
                                                                                                                                                                          Nodo cuerpo  = new NodoComun("CUERPO", nThen, nElse);
                                                                                                                                                                          yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-6].obj,cuerpo);}
break;
case 102:
#line 517 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; yyval.obj = NodoComun nThen = new NodoComun("THEN", (Nodo)yyvsp[-3].obj);
                                                                                                                                                                    NodoComun nElse = new NodoComun("ELSE", (Nodo)yyvsp[-1].obj);
                                                                                                                                                                    Nodo cuerpo  = new NodoComun("CUERPO", nThen, nElse);
                                                                                                                                                                    yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-6].obj,cuerpo);}
break;
case 103:
#line 522 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("THEN", (Nodo)yyvsp[-3].obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("ELSE", (Nodo)yyvsp[-1].obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("CUERPO", nThen, nElse);
                                                                                                                                                                   yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-6].obj,cuerpo);}
break;
case 104:
#line 527 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("THEN", (Nodo)yyvsp[-3].obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("ELSE", (Nodo)yyvsp[-1].obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("CUERPO", nThen, nElse);
                                                                                                                                                                   yyval.obj = new NodoComun("IF", (Nodo)yyvsp[-6].obj,cuerpo);}
break;
case 105:
#line 531 "gramatica.y"
{yyerror("Falta THEN en IF");}
break;
case 106:
#line 532 "gramatica.y"
{yyerror("Falta ELSE en IF");}
break;
case 107:
#line 533 "gramatica.y"
{yyerror("Falta END_IF en IF");}
break;
case 108:
#line 538 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 109:
#line 539 "gramatica.y"
{yyval = yyvsp[-1]; yyval.hasReturn = true;}
break;
case 110:
#line 543 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 111:
#line 544 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 112:
#line 545 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 113:
#line 546 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 114:
#line 550 "gramatica.y"
{yyval = new NodoComun("SENTENCIA", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);}
break;
case 115:
#line 551 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 116:
#line 556 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 117:
#line 557 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 118:
#line 558 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 119:
#line 559 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 120:
#line 560 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 121:
#line 561 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 122:
#line 565 "gramatica.y"
{yyval.obj = new NodoComun(yyvsp[-1].sval, (Nodo)yyvsp[-2].obj, (Nodo)yyvsp[0].obj);}
break;
case 123:
#line 566 "gramatica.y"
{ yyval.obj = new NodoComun(yyvsp[-3].sval, (Nodo)yyvsp[-5].obj, (Nodo)yyvsp[-3].obj);
                                                                                    AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
                                                                                  }
break;
case 124:
#line 570 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 125:
#line 575 "gramatica.y"
{yyval = new NodoComun("SENTENCIA", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[0].obj);}
break;
case 126:
#line 579 "gramatica.y"
{yyval = new NodoComun("SENTENCIA", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[0].obj);}
break;
case 127:
#line 580 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 128:
#line 581 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 129:
#line 585 "gramatica.y"
{   yyval.obj = new NodoComun("OUTF", new NodoHoja(yyvsp[-1].sval));
                            Token t = TablaSimbolos.getToken(yyvsp[-1].sval); /*Obtenemos el token, faltaba esto*/
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 130:
#line 591 "gramatica.y"
{   yyval.obj = new NodoComun("OUTF", new NodoHoja(yyvsp[-1].sval));
                                 Token t = TablaSimbolos.getToken(yyvsp[-1].sval); /*Obtenemos el token, faltaba esto*/
                                 t.setUso("mensaje");
                                 t.setTipo("cadena");
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }
break;
case 131:
#line 597 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 1589 "y.tab.c"
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
