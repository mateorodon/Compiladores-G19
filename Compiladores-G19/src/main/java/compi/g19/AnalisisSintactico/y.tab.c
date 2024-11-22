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
   38,   38,   38,   38,   38,   35,   35,   39,   39,   39,
   39,   39,   39,   19,   40,   41,   42,   43,   19,   19,
   33,   44,   44,   44,   12,   12,   12,
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
    3,    4,    2,    2,    1,    3,    2,    1,    1,    1,
    1,    1,    1,    3,    0,    0,    0,    0,   11,    1,
    3,    3,    1,    1,    4,    4,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,   99,    0,    0,    0,   44,   45,
    0,    0,    7,    0,    0,    0,   13,   14,   15,   16,
   17,   18,   19,   42,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   24,   25,    0,
    4,    6,    8,    9,   48,    0,    0,    0,    0,    2,
   41,    0,   78,    0,   79,    0,    0,   74,  134,   92,
    0,    0,    0,    0,    0,    1,    0,  137,    0,    0,
    0,    0,    0,    0,    0,  130,    0,  125,    0,    0,
   49,   47,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   82,    0,    0,    0,    0,   90,    0,   91,
    0,    0,  135,  136,    0,   88,    0,    0,   36,    0,
    0,    0,    0,   23,   22,    0,    0,    0,  118,  119,
  120,  123,  122,  121,    0,   46,    0,   55,    0,    0,
    0,    0,    0,    0,   70,    0,   71,    0,   75,   72,
   76,   73,    0,    0,    0,   87,    0,   86,   89,   98,
    0,    0,   21,   20,   96,   37,   38,    0,    0,    0,
  126,    0,    0,    0,   65,    0,    0,    0,    0,    0,
    0,  115,    0,    0,    0,    0,   80,    0,    0,    0,
   85,   84,  117,   97,    0,    0,    0,    0,    0,    0,
    0,   54,   64,    0,   62,   51,    0,    0,    0,    0,
    0,  113,    0,  114,    0,   83,   93,  116,    0,    0,
    0,    0,    0,    0,    0,   60,    0,   53,    0,  110,
   95,    0,   94,  100,    0,    0,  101,    0,  111,    0,
    0,    0,    0,    0,    0,    0,    0,   66,   52,    0,
    0,    0,    0,  109,  107,  112,  106,    0,    0,   35,
    0,  127,    0,  102,  104,  105,  103,   32,    0,   34,
    0,   33,   31,  128,    0,  129,
};
short yydgoto[] = {                                       3,
   12,   13,   14,   15,   16,   47,   17,   18,   19,   20,
   21,   22,   23,   37,  114,   38,   39,   40,   79,  159,
   80,   24,   25,   87,  166,  217,   88,   89,  167,  199,
   57,   58,   63,  224,  175,   26,  200,  176,  125,  117,
  189,  261,  265,   64,
};
short yysindex[] = {                                   -140,
  354,  417,    0,  -32,    0,  417,  -24,   -2,    0,    0,
  -15,  256,    0,  -31,  -29, -220,    0,    0,    0,    0,
    0,    0,    0,    0,   56,   72,  370,   34,  103, -143,
  385,  -38,   58, -198, -137, -122,  131,    0,    0,   -9,
    0,    0,    0,    0,    0, -100,  -42,   -7,   -5,    0,
    0,  -17,    0, -129,    0,    6,   98,    0,    0,    0,
  106,  140,  151,  169,  113,    0,  167,    0,  122, -198,
  -52,  155,  -39,  -37,  303,    0,   -5,    0,  195,  134,
    0,    0,   -1,    0,   -8,    7,  229,  232,  238,  246,
   27,  202,    0,   80,  119,  126,  162,    0,  117,    0,
  117,   43,    0,    0,  -43,    0,   48,   55,    0,  -32,
 -175,  346,  257,    0,    0,   35,  164,  -79,    0,    0,
    0,    0,    0,    0,  117,    0,  394,    0,   52,   57,
 -114,  298,  235,   73,    0,   98,    0,   98,    0,    0,
    0,    0,  359,    6,  117,    0,   53,    0,    0,    0,
  280,  437,    0,    0,    0,    0,    0, -223,   85,    6,
    0,   89,    6,  318,    0,   94,  394,  311,  394,  394,
    0,    0,  325,  -73,  440,  133,    0,  292,  360,    6,
    0,    0,    0,    0,  347,  363,  -18,  369,  399,  384,
  117,    0,    0,  393,    0,    0,  186,  397,  402,  -88,
  227,    0,  277,    0,  439,    0,    0,    0,  418,  407,
   -5,  427,  -49,  431,  396,    0,  208,    0,    0,    0,
    0,  325,    0,    0,  325,  428,    0, -159,    0,  220,
 -159,   -5,  454,  457,   -5,  459,   -5,    0,    0, -159,
 -159, -159, -159,    0,    0,    0,    0,  461,   -5,    0,
  463,    0,  464,    0,    0,    0,    0,    0,  467,    0,
  164,    0,    0,    0,  470,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0, -170,    0,    0,    0,    0,    0,    0,
    0,  512,    0,  174,  189,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  514,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  475,  204,    0,    0,    0,
    0,    1,    0,    0,    0,  116,   47,    0,    0,    0,
  472,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -12,    0,    0,  481,    0,    0,    0,
    0,   24,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  260,    0,    0,    0,
    0,    0,    0,    0,    0,   70,    0,   93,    0,    0,
    0,    0,    0,  125,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  472,
    0,    0,  -41,    0,    0,    0,  265,    0,  260,  260,
  149,    0,    0,    0,    0,    0,    0,    0,    0,  139,
    0,    0,    0,    0,    0,  -36,  -35,  -21,    0,  141,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  225,
    0,    0,    0,    0,    0,    0,    0,    0,  253,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  159,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   97,  424,    0,  432,  -33,    0,    0,    0,    0,  441,
    0,    0,    0,  503,  -48,    0,    0,    0,  348,  -85,
   25,   71,    0,  415,   32,    0,    0,    0,    0,  -47,
  261,  389, -103,  -55, -102,    0, -184, -147,  335,    0,
    0,    0,    0,    0,
};
#define YYTABLESIZE 716
short yytable[] = {                                     124,
   77,   83,   68,  112,   27,   30,   54,   29,  152,  107,
  122,  124,  123,  161,   86,   32,  228,  124,  147,   29,
  231,  211,   29,   81,   36,  201,  115,   43,   56,   44,
   78,   56,  162,   85,   78,   54,   45,  240,  186,   54,
  242,   77,   77,   77,   77,   77,   69,   77,   94,   77,
   95,   46,   56,   61,  156,  157,   69,   34,   30,   77,
   77,   77,   77,  154,   81,   81,   81,   81,   81,   67,
   81,  203,  187,   91,  241,    9,   10,  243,   54,  168,
  150,  110,   81,   81,   81,   81,   43,   69,    5,   69,
   69,   69,   68,  158,    7,   48,  221,   86,   27,   62,
   11,   43,   31,   71,   72,   69,   69,   69,   69,  223,
   67,   49,   67,   67,   67,   39,    1,   70,   65,  194,
   73,  168,  168,  143,   54,  144,    2,   92,   67,   67,
   67,   67,   93,   68,   35,   68,   68,   68,   40,   96,
  105,  160,   84,   60,   97,  227,   98,   54,   94,  163,
   95,   68,   68,   68,   68,  230,   81,  264,  108,    9,
   10,   54,  104,   54,   94,  131,   95,  221,  132,  180,
   54,   75,  245,   11,   39,  247,   94,  222,   95,   99,
  223,   28,  202,  110,  254,  255,  256,  257,   10,   57,
    5,  100,   59,  122,  124,  123,    7,   40,  156,  157,
  196,  197,   11,   12,  106,  102,   54,  103,   54,  119,
  120,  121,  101,  146,   82,  215,  108,  108,   52,  110,
   27,   30,  109,   53,   67,   28,    5,   27,   30,  111,
   27,   30,    7,   27,   30,   29,  124,  124,   11,   27,
   30,   35,   29,  210,   43,   29,   76,   52,   29,   84,
   76,   52,   53,  118,   29,  126,   53,   77,  127,   77,
   77,   77,   12,  128,   77,   26,    9,   10,   77,  129,
   77,   77,  130,   77,   77,   77,   77,   33,   77,   77,
   81,  131,   81,   81,   81,  160,  132,   81,  133,   51,
   52,   81,  134,   81,   81,   53,   81,   81,   81,   81,
  145,   81,   81,   69,  148,   69,   69,   69,  181,  182,
   69,  149,  156,  157,   69,  155,   69,   69,  169,   69,
   69,   69,   69,  170,   69,   69,   67,  177,   67,   67,
   67,    9,   10,   67,  178,  135,   52,   67,  183,   67,
   67,   53,   67,   67,   67,   67,  188,   67,   67,   68,
  190,   68,   68,   68,  136,  138,   68,  191,   59,   52,
   68,  192,   68,   68,   53,   68,   68,   68,   68,  195,
   68,   68,   39,   52,  137,   52,    9,   10,   53,   39,
   53,  139,   52,   39,  206,   39,   39,   53,   39,   39,
   39,   39,  119,  120,  121,   40,   90,   28,  205,  179,
  207,   94,   40,   95,   28,  208,   40,   28,   40,   40,
   28,   40,   40,   40,   40,  108,   28,  141,   52,   59,
   52,  209,  108,   53,  116,   53,  108,  212,  108,  108,
   11,  108,  108,  108,  108,   42,  238,   11,   94,  213,
   95,   11,  214,   11,   11,   10,   11,   11,   11,   11,
   42,  216,   10,  218,   42,  219,   10,  232,   10,   10,
  220,   10,   10,   10,   10,  233,  235,   12,   55,   55,
  237,   12,   55,   12,   12,  239,   12,   12,   12,   12,
   55,   26,  221,  110,  140,  142,  244,  246,   26,   55,
    5,   26,  225,  249,   26,  223,    7,  250,  252,  164,
   26,  258,   11,  260,  262,  113,  113,  263,  109,  117,
  266,    5,    4,    3,   50,  133,  117,   55,  109,    5,
  117,  109,  117,   41,   58,    7,    8,   63,  117,    9,
   10,   11,   61,  110,   55,   55,   55,   55,   74,   55,
    5,   55,  151,  113,  229,  171,    7,  236,    0,  164,
  165,    0,   11,  172,  110,    0,    0,   55,  234,  110,
    0,    5,  173,  151,  174,   55,    5,    7,    0,  111,
    0,    0,    7,   11,    0,    0,    0,    0,   11,  248,
  172,  110,  251,  185,  253,   55,    0,    0,    5,    0,
  193,  174,  165,  165,    7,    0,  259,  164,    0,    0,
   11,  153,  110,    0,  198,  151,  185,    0,    0,    5,
    4,    0,  111,    0,    0,    7,    0,    5,    0,    0,
    6,   11,    0,    7,    8,    0,    4,    9,   10,   11,
    0,   55,  226,    5,  185,    0,  226,   50,    0,    7,
    8,    4,    0,    9,   10,   11,    0,    0,    5,    0,
    4,   55,   66,  198,    7,    8,  198,    5,    9,   10,
   11,    0,    0,    7,    8,    0,  164,    9,   10,   11,
    0,    0,   55,    4,    0,   55,    0,   55,    0,    0,
    5,    0,    0,    0,    0,    0,    7,    8,    0,   55,
    9,   10,   11,  110,    0,  110,  110,    0,    0,    0,
    5,   55,    5,    5,  184,    0,    7,  204,    7,    7,
    0,  164,   11,    0,   11,   11,
};
short yycheck[] = {                                      41,
    0,   44,   41,   41,   41,   41,   45,   40,  111,   62,
   60,   61,   62,  117,   48,   40,  201,   59,   62,   41,
  205,   40,   40,    0,   40,  173,   75,   59,   41,   59,
   40,   44,  118,   41,   40,   45,  257,  222,  262,   45,
  225,   41,   42,   43,   44,   45,    0,   47,   43,   59,
   45,  272,   28,   29,  278,  279,   32,   60,   91,   59,
   60,   61,   62,  112,   41,   42,   43,   44,   45,    0,
   47,  174,  158,   91,  222,  274,  275,  225,   45,  127,
  256,  257,   59,   60,   61,   62,  257,   41,  264,   43,
   44,   45,    0,   59,  270,   40,  256,  131,    2,   29,
  276,  272,    6,   33,   34,   59,   60,   61,   62,  269,
   41,   40,   43,   44,   45,    0,  257,   60,  262,  167,
  258,  169,  170,   99,   45,  101,  267,  257,   59,   60,
   61,   62,  262,   41,  257,   43,   44,   45,    0,   42,
   70,  117,  257,   41,   47,  201,   41,   45,   43,  125,
   45,   59,   60,   61,   62,  203,  257,  261,    0,  274,
  275,   45,   41,   45,   43,   41,   45,  256,   44,  145,
   45,   41,  228,    0,   59,  231,   43,  266,   45,   40,
  269,   41,  256,  257,  240,  241,  242,  243,    0,   41,
  264,   41,   44,   60,   61,   62,  270,   59,  278,  279,
  169,  170,  276,    0,  257,   93,   45,   41,   45,  259,
  260,  261,   44,  257,  257,  191,   62,   59,  257,  257,
  257,  257,  262,  262,  263,  258,  264,  264,  264,  267,
  267,  267,  270,  270,  270,  257,  278,  279,  276,  276,
  276,  257,  264,  262,  257,  267,  256,  257,  270,  257,
  256,  257,  262,   59,  276,  257,  262,  257,  267,  259,
  260,  261,   59,  257,  264,   41,  274,  275,  268,   41,
  270,  271,   41,  273,  274,  275,  276,  280,  278,  279,
  257,   44,  259,  260,  261,  261,   41,  264,  262,  256,
  257,  268,   91,  270,  271,  262,  273,  274,  275,  276,
  258,  278,  279,  257,  257,  259,  260,  261,  256,  257,
  264,  257,  278,  279,  268,   59,  270,  271,  267,  273,
  274,  275,  276,  267,  278,  279,  257,   93,  259,  260,
  261,  274,  275,  264,  262,  256,  257,  268,   59,  270,
  271,  262,  273,  274,  275,  276,  262,  278,  279,  257,
  262,  259,  260,  261,   94,   95,  264,   40,  256,  257,
  268,  268,  270,  271,  262,  273,  274,  275,  276,   59,
  278,  279,  257,  257,  256,  257,  274,  275,  262,  264,
  262,  256,  257,  268,   93,  270,  271,  262,  273,  274,
  275,  276,  259,  260,  261,  257,   49,  257,  266,   41,
   41,   43,  264,   45,  264,   59,  268,  267,  270,  271,
  270,  273,  274,  275,  276,  257,  276,  256,  257,  256,
  257,   59,  264,  262,   77,  262,  268,   59,  270,  271,
  257,  273,  274,  275,  276,   12,   41,  264,   43,   41,
   45,  268,   59,  270,  271,  257,  273,  274,  275,  276,
   27,   59,  264,  268,   31,   59,  268,   40,  270,  271,
   59,  273,  274,  275,  276,   59,   40,  264,   28,   29,
   40,  268,   32,  270,  271,  268,  273,  274,  275,  276,
   40,  257,  256,  257,   96,   97,   59,  268,  264,   49,
  264,  267,  266,   40,  270,  269,  270,   41,   40,  273,
  276,   41,  276,   41,   41,   74,   75,   41,  256,  257,
   41,    0,  257,    0,   40,   44,  264,   77,  266,  264,
  268,  269,  270,  268,   44,  270,  271,  268,  276,  274,
  275,  276,  268,  257,   94,   95,   96,   97,   36,   99,
  264,  101,  111,  112,  268,  131,  270,  213,   -1,  273,
  127,   -1,  276,  256,  257,   -1,   -1,  117,  211,  257,
   -1,  264,  265,  132,  267,  125,  264,  270,   -1,  267,
   -1,   -1,  270,  276,   -1,   -1,   -1,   -1,  276,  232,
  256,  257,  235,  152,  237,  145,   -1,   -1,  264,   -1,
  167,  267,  169,  170,  270,   -1,  249,  273,   -1,   -1,
  276,  256,  257,   -1,  173,  174,  175,   -1,   -1,  264,
  257,   -1,  267,   -1,   -1,  270,   -1,  264,   -1,   -1,
  267,  276,   -1,  270,  271,   -1,  257,  274,  275,  276,
   -1,  191,  201,  264,  203,   -1,  205,  268,   -1,  270,
  271,  257,   -1,  274,  275,  276,   -1,   -1,  264,   -1,
  257,  211,  268,  222,  270,  271,  225,  264,  274,  275,
  276,   -1,   -1,  270,  271,   -1,  273,  274,  275,  276,
   -1,   -1,  232,  257,   -1,  235,   -1,  237,   -1,   -1,
  264,   -1,   -1,   -1,   -1,   -1,  270,  271,   -1,  249,
  274,  275,  276,  257,   -1,  257,  257,   -1,   -1,   -1,
  264,  261,  264,  264,  268,   -1,  270,  268,  270,  270,
   -1,  273,  276,   -1,  276,  276,
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
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables END",
"cuerpo_if_bloque : BEGIN list_sentencias_ejecutables sentencia_return END",
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
#line 811 "gramatica.y"
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
static Map<String,String> tiposDeclarados = new HashMap<>();
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
    AnalizadorLexico.agregarErrorSintactico(error);
}

public static void addAmbito(String ambitoActual){
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

public static boolean noHayErrores(){
    return erroresSemanticos.isEmpty() && errorSintactico.isEmpty() && errorLexico.isEmpty();
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

private Nodo generarLlamadoFuncion(NodoComun funcion, Nodo copia){
    NodoComun salida = null;
    if (funcion != null){
        Nodo param = funcion.getIzq();
        if (param.getTipo().equals(copia.getTipo())){
            param.setNombre(copia.getNombre());
            salida = new NodoComun(funcion.getNombre(),param,funcion.getDer());
            salida.setUso("llamado");
        }
        else {
            agregarErrorSemantico("El tipo del parametro real no coincide con el del parametro formal");
            return new NodoHoja("error");
        }
    }
    return salida;
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
#line 663 "y.tab.c"
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
#line 22 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio el programa"); raiz = new NodoComun("PROGRAMA", (Nodo)yyvsp[-1].obj);}
break;
case 2:
#line 23 "gramatica.y"
{yyerror("El programa debe tener un nombre");}
break;
case 3:
#line 24 "gramatica.y"
{yyerror("Falta delimitador END del programa");}
break;
case 4:
#line 25 "gramatica.y"
{yyerror("Falta delimitador BEGIN del programa");}
break;
case 5:
#line 26 "gramatica.y"
{yyerror("Faltan los delimitadores del programa");}
break;
case 6:
#line 29 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo)yyvsp[-1].obj, (Nodo)yyvsp[0].obj);}
break;
case 7:
#line 30 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 8:
#line 34 "gramatica.y"
{yyval.obj = new NodoHoja("Sentencia Declarativa");}
break;
case 9:
#line 35 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 10:
#line 36 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 11:
#line 37 "gramatica.y"
{yyerror("Las sentencias deben terminar con ;");}
break;
case 12:
#line 41 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");
                         for (String var: varDeclaradas){
                            Token t = TablaSimbolos.getToken(var);
                            if (!TablaSimbolos.existeSimbolo(var + ":" + ambito)){
                                String tipo = t.getTipo();
                                if (tipo != null){
                                    if (tipo.toLowerCase().equals(tipoActual.toLowerCase()))
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya esta declarada");
                                    else
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya estaba declarada. Se cambio su tipo a " + tipoActual);
                                }
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
#line 68 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
break;
case 14:
#line 69 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
break;
case 15:
#line 73 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio una asignacion"); yyval=yyvsp[0];}
break;
case 16:
#line 74 "gramatica.y"
{yyval = yyvsp[0]; AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 17:
#line 75 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 18:
#line 76 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 19:
#line 77 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 20:
#line 82 "gramatica.y"
{ yyval.obj = new NodoComun("For",(Nodo)yyvsp[-2].obj,(Nodo)yyvsp[0].obj);}
break;
case 21:
#line 83 "gramatica.y"
{yyerror("Falta cuerpo del FOR");}
break;
case 22:
#line 84 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 23:
#line 85 "gramatica.y"
{yyerror("Falta parentensis en el FOR");}
break;
case 24:
#line 89 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 25:
#line 90 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 26:
#line 94 "gramatica.y"
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
#line 102 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 28:
#line 103 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 29:
#line 104 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 30:
#line 105 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 31:
#line 109 "gramatica.y"
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
#line 126 "gramatica.y"
{yyerror("Falta UP/DOWN en el FOR");}
break;
case 33:
#line 127 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 34:
#line 128 "gramatica.y"
{yyerror("Falta ';' en el FOR");}
break;
case 35:
#line 129 "gramatica.y"
{yyerror("Falta constante después de UP/DOWN en el FOR");}
break;
case 36:
#line 133 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[-2].sval);
                                        NodoHoja idAsignacion = null;
                                        if (!ambitoVar.equals("")) {
                                            Token t = TablaSimbolos.getToken(yyvsp[-2].sval + ":" + ambitoVar);
                                            idAsignacion = new NodoHoja(yyvsp[-2].sval + ":" + ambitoVar, t);
                                        }
                                        else {
                                            Token t = new Token();
                                            t.setTipo(ENTERO);
                                            t.getLexema().setLength(0);
                                            t.getLexema().append(yyvsp[-2].sval).append(":").append(ambito);
                                            t.setAmbito(ambito);
                                            t.setUso("variable");
                                            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                            idAsignacion = new NodoHoja(yyvsp[-2].sval + ":" + ambito, t);
                                        }
                                        NodoHoja constante = new NodoHoja(yyvsp[0].sval, TablaSimbolos.getToken(yyvsp[0].sval));
                                        yyval.obj = new NodoComun(yyvsp[-1].sval, idAsignacion, constante);
                                        TablaSimbolos.removeToken(yyvsp[-2].sval);
                                        }
break;
case 37:
#line 156 "gramatica.y"
{yyval.obj = new NodoHoja("Up");}
break;
case 38:
#line 157 "gramatica.y"
{yyval.obj = new NodoHoja("Down");}
break;
case 39:
#line 161 "gramatica.y"
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
                                        t.getLexema().append(yyvsp[-2].sval).append(":").append(ambito);
                                        t.setAmbito(ambito);
                                        t.setUso("variable");
                                        TablaSimbolos.removeToken(yyvsp[-2].sval);
                                        TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                  }
                              }
                              else {
                                  t = TablaSimbolos.getToken(yyvsp[-2].sval + ":" + ambitoVar);
                              }
                              if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))){
                                    agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")" );
                                    yyval.obj = new NodoHoja("error");
                              }
                              else {
                                    NodoHoja id = new NodoHoja(t.getLexema().toString(),t);
                                    yyval.obj = new NodoComun(yyvsp[-1].sval ,id, (Nodo)yyvsp[0].obj);
                              }
                              TablaSimbolos.removeToken(yyvsp[-2].sval);
                            }
break;
case 40:
#line 192 "gramatica.y"
{
                                                String ambitoVar = buscarAmbito(ambito,yyvsp[-5].sval);
                                                if (ambitoVar.equals("")){
                                                    agregarErrorSemantico("La variable '" + yyvsp[-5].sval + "' no fue declarada");
                                                    yyval.obj = new NodoHoja("error");
                                                }
                                                else {
                                                    Token t = TablaSimbolos.getToken(yyvsp[-5].sval + ":" + ambitoVar);
                                                    String tipo = t.getTipo();
                                                    if (tiposDeclarados.containsKey(tipo)){
                                                        String tipoTriple = tiposDeclarados.get(tipo);
                                                        NodoHoja nodo = new NodoHoja(yyvsp[-5].sval + yyvsp[-4].sval + yyvsp[-3].sval + yyvsp[-2].sval, t);
                                                        /*nodo.setTipo(tipoTriple);*/
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
#line 221 "gramatica.y"
{yyerror("Falta parte derecha de la asignacion");}
break;
case 43:
#line 226 "gramatica.y"
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
            TablaSimbolos.removeToken(yyvsp[0].sval);
         }
break;
case 44:
#line 242 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 45:
#line 243 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 46:
#line 247 "gramatica.y"
{varDeclaradas.add(yyvsp[0].sval);}
break;
case 47:
#line 248 "gramatica.y"
{yyerror("Las variables deben estar separadas por comas");}
break;
case 48:
#line 249 "gramatica.y"
{varDeclaradas.add(yyvsp[0].sval);}
break;
case 49:
#line 253 "gramatica.y"
{hasReturn = false;
                enFuncion = true;
                funcionActual = yyvsp[0].sval;
                String idFuncion = yyvsp[0].sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (t.getTipo() == null){
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
#line 282 "gramatica.y"
{yyerror("La funcione debe tener nombre"); hasReturn = false;}
break;
case 51:
#line 286 "gramatica.y"
{ if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
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
break;
case 53:
#line 301 "gramatica.y"
{yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
break;
case 54:
#line 302 "gramatica.y"
{yyerror("La función debe tener parámetro");removeAmbito();}
break;
case 55:
#line 306 "gramatica.y"
{
               Token t = TablaSimbolos.getToken(yyvsp[0].sval);
               if (t != null){
                   if (t.getTipo() != null)
                        AnalizadorLexico.agregarWarning("La variable '" + yyvsp[0].sval + "' ya esta declarada");
                   t.getLexema().setLength(0);
                   t.getLexema().append(yyvsp[0].sval).append(":").append(ambito);
                   t.setAmbito(ambito);
                   t.setUso("parametro");
                   t.setTipo(tipoActual);
                   TablaSimbolos.removeToken(yyvsp[0].sval);
                   TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
               }
              Nodo param = new NodoHoja(t.getLexema().toString() + ambito, t);
              param.setTipo(tipoActual);
              yyval.obj = param;
            }
break;
case 56:
#line 323 "gramatica.y"
{yyerror("El parametro debe tener su tipo");}
break;
case 60:
#line 336 "gramatica.y"
{  yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);
                                                    hasReturn = true;}
break;
case 61:
#line 338 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 62:
#line 339 "gramatica.y"
{yyval=yyvsp[-1]; hasReturn = true;}
break;
case 63:
#line 340 "gramatica.y"
{yyerror("El cuerpo de la funcion no puede ser vacio");}
break;
case 64:
#line 345 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-1].obj, (Nodo) yyvsp[0].obj);}
break;
case 65:
#line 346 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 66:
#line 351 "gramatica.y"
{if (ambito.length() < 5){  /*si es menor es que es main*/
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           yyval.obj = new NodoComun("Return", (Nodo)yyvsp[-1].obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
break;
case 67:
#line 359 "gramatica.y"
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
#line 371 "gramatica.y"
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
#line 383 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 70:
#line 384 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 71:
#line 385 "gramatica.y"
{yyerror("Se esperaba un termino");}
break;
case 72:
#line 389 "gramatica.y"
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
#line 401 "gramatica.y"
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
#line 413 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 75:
#line 414 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 76:
#line 415 "gramatica.y"
{yyval.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
break;
case 77:
#line 419 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[0].sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La variable '" + yyvsp[0].sval + "' no fue declarada");
            Nodo aux = new NodoHoja("error");
            yyval.obj = aux;
        }
        else {
            Token t = TablaSimbolos.getToken(yyvsp[0].sval + ":" + ambitoVar);
            if (!(t.getUso().equals("variable") || t.getUso().equals("parametro")))
                agregarErrorSemantico("'" + yyvsp[0].sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                Nodo aux = new NodoHoja(yyvsp[0].sval+":"+ambitoVar, t);
                yyval.obj = aux;
            }
        }
        TablaSimbolos.removeToken(yyvsp[0].sval);
        }
break;
case 78:
#line 436 "gramatica.y"
{Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                t.setValor(yyvsp[0].sval);
                t.setUso("constante");
                yyval.obj = new NodoHoja(yyvsp[0].sval,t);
                }
break;
case 79:
#line 441 "gramatica.y"
{yyval = yyvsp[0]; AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
break;
case 80:
#line 442 "gramatica.y"
{    String ambitoVar = buscarAmbito(ambito,yyvsp[-3].sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + yyvsp[-3].sval + "' no fue declarada");
                                    yyval.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken(yyvsp[-3].sval + ":" + ambitoVar);
                                    String tipo = yyvsp[-3].sval;
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja(yyvsp[-3].sval + yyvsp[-2].sval + yyvsp[-1].sval + yyvsp[0].sval, t);
                                        nodo.setTipo(tipoTriple);
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
#line 468 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[0].sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + yyvsp[0].sval + "' no fue declarada");
                         yyval.obj = new NodoHoja("error");
                     }
                     else {
                         Token t = TablaSimbolos.getToken(yyvsp[0].sval + ":" + ambitoVar);
                         if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))){
                             agregarErrorSemantico("'" + yyvsp[0].sval + "' no es una variable. Es un/a " + t.getUso());
                             yyval.obj = new NodoHoja("error");
                         }
                         else {
                             yyval.obj = new NodoHoja(yyvsp[-1].sval + yyvsp[0].sval + ":" + ambitoVar,t);
                         }
                     }
                     TablaSimbolos.removeToken(yyvsp[0].sval);
                     }
break;
case 82:
#line 485 "gramatica.y"
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
#line 499 "gramatica.y"
{String ambitoVar = buscarAmbito(ambito,yyvsp[-3].sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + yyvsp[-3].sval + "' no fue declarada");
                                    yyval.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken(yyvsp[-3].sval + ":" + ambitoVar);
                                    String tipo = yyvsp[-4].sval;
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja(yyvsp[-4].sval + yyvsp[-3].sval + yyvsp[-2].sval + yyvsp[-1].sval + yyvsp[0].sval, t);
                                        nodo.setTipo(tipoTriple);
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
#line 528 "gramatica.y"
{String idTipo = yyvsp[0].sval;
                                         Token t = TablaSimbolos.getToken(idTipo);
                                         if (t.getTipo() == null){
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
                                         else {
                                            agregarErrorSemantico("La variable '" + idTipo + "' ya fue declarada");
                                            yyval.obj = new NodoComun("error");
                                         }
                                         }
break;
case 85:
#line 551 "gramatica.y"
{yyerror("Falta ID al final de la declaracion de tipo");}
break;
case 86:
#line 552 "gramatica.y"
{yyerror("Falta diamante (<) en la declaracion de tipo");}
break;
case 87:
#line 553 "gramatica.y"
{yyerror("Falta diamante (>) en la declaracion de tipo");}
break;
case 88:
#line 554 "gramatica.y"
{yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
break;
case 89:
#line 555 "gramatica.y"
{yyerror("Falta TRIPLE en la declaracion de tipo");}
break;
case 90:
#line 559 "gramatica.y"
{
        AnalizadorLexico.agregarEstructura("Se reconocio invocacion a funcion");
        String ambitoVar = buscarAmbito(ambito,yyvsp[-3].sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La funcion '" + yyvsp[-3].sval + "' no fue declarada");
            yyval.obj = new NodoHoja("error");
        }
        else {
            if (enFuncion && funcionActual.equals(yyvsp[-3].sval)){
                agregarErrorSemantico("La funcion '" + yyvsp[-3].sval + "' no puede autoinvocarse");
                yyval.obj = new NodoHoja("error");
            }
            else {
                if (funcionesDeclaradas.containsKey(yyvsp[-3].sval + ":" + ambitoVar)){
                    Nodo exp = (Nodo)yyvsp[-1].obj;
                    NodoComun funcion = funcionesDeclaradas.get(yyvsp[-3].sval + ":" + ambitoVar);
                    yyval.obj = generarLlamadoFuncion(funcion,exp);
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
#line 585 "gramatica.y"
{yyerror("La funcion no puede tener mas de un parametro");}
break;
case 92:
#line 586 "gramatica.y"
{yyerror("La funcion debe tener un parametro");}
break;
case 93:
#line 587 "gramatica.y"
{
            AnalizadorLexico.agregarEstructura("Se reconocio conversion");
            String ambitoVar = buscarAmbito(ambito,yyvsp[-6].sval);
            if (ambitoVar.equals("")){
                agregarErrorSemantico("La funcion '" + yyvsp[-6].sval + "' no fue declarada");
                yyval.obj = new NodoHoja("error");
            }
            else {
                if (enFuncion && funcionActual.equals(yyvsp[-6].sval)){
                    agregarErrorSemantico("La funcion '" + yyvsp[-6].sval + "' no puede autoinvocarse");
                    yyval.obj = new NodoHoja("error");
                }
                else {
                    if (funcionesDeclaradas.containsKey(yyvsp[-6].sval + ":" + ambitoVar)){
                        Nodo exp = (Nodo)yyvsp[-2].obj;
                        exp.setTipo(yyvsp[-4].sval);
                        NodoComun funcion = funcionesDeclaradas.get(yyvsp[-6].sval + ":" + ambitoVar);
                        yyval.obj = generarLlamadoFuncion(funcion,exp);
                    }
                    else {
                        agregarErrorSemantico("La funcion '" + yyvsp[-6].sval + "' no fue declarada");
                        yyval.obj = new NodoHoja("error");
                    }
                }
            }
            TablaSimbolos.removeToken(yyvsp[-6].sval);
        }
break;
case 95:
#line 618 "gramatica.y"
{yyerror("La sentencia IF deben terminar con END_IF");}
break;
case 96:
#line 622 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 97:
#line 623 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 98:
#line 624 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
break;
case 99:
#line 628 "gramatica.y"
{inIF=true; yyval=yyvsp[0];}
break;
case 100:
#line 632 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; Nodo cuerpo = new NodoComun("Cuerpo",(Nodo)yyvsp[-1].obj);
                                                                                                                                              yyval.obj = new NodoComun("If", (Nodo)yyvsp[-4].obj, cuerpo);}
break;
case 101:
#line 634 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)yyvsp[-1].obj);
                                                                                                                                          yyval.obj = new NodoComun("If", (Nodo)yyvsp[-4].obj, cuerpo);}
break;
case 102:
#line 638 "gramatica.y"
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
#line 648 "gramatica.y"
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
#line 658 "gramatica.y"
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
#line 669 "gramatica.y"
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
#line 679 "gramatica.y"
{yyerror("Falta THEN en IF");}
break;
case 107:
#line 680 "gramatica.y"
{yyerror("Falta ELSE en IF");}
break;
case 108:
#line 681 "gramatica.y"
{yyerror("Falta END_IF en IF");}
break;
case 109:
#line 686 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 110:
#line 687 "gramatica.y"
{yyval = yyvsp[-1]; cantReturns++;}
break;
case 111:
#line 691 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 112:
#line 692 "gramatica.y"
{yyval = yyvsp[-2]; cantReturns++;}
break;
case 113:
#line 693 "gramatica.y"
{yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
break;
case 114:
#line 694 "gramatica.y"
{yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
break;
case 115:
#line 695 "gramatica.y"
{yyerror("Se esperaba BEGIN y END por sentencias multiples");}
break;
case 116:
#line 699 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);}
break;
case 117:
#line 700 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 118:
#line 705 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 119:
#line 706 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 120:
#line 707 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 121:
#line 708 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 122:
#line 709 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 123:
#line 710 "gramatica.y"
{yyval.obj = new NodoHoja(yyvsp[0].sval);}
break;
case 124:
#line 714 "gramatica.y"
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
case 125:
#line 728 "gramatica.y"
{inList1 = true;}
break;
case 126:
#line 728 "gramatica.y"
{inList1 = false;}
break;
case 127:
#line 728 "gramatica.y"
{inList2 = true;}
break;
case 128:
#line 728 "gramatica.y"
{inList2 = false;}
break;
case 129:
#line 729 "gramatica.y"
{ NodoComun salida = new NodoComun(yyvsp[-5].sval);
      AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
      if (expresiones1.size() == expresiones2.size()){
            Nodo aux;
            for (int i = 0; i < expresiones1.size(); i++) {
                Nodo exp1 = expresiones1.get(i);
                Nodo exp2 = expresiones2.get(i);
                if (!(exp1.getTipo().equals(exp2.getTipo()))){
                    agregarErrorSemantico("Las expresiones en la posicion " + i + " no tienen el mismo tipo");
                    aux = new NodoHoja("error");
                    }
                else {
                    aux = new NodoComun(yyvsp[-5].sval, exp1, exp2);
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
case 130:
#line 761 "gramatica.y"
{yyerror("Falta comparador en la condicion");}
break;
case 131:
#line 766 "gramatica.y"
{
    if (inList1)
            expresiones1.add((Nodo)yyvsp[0].obj);
        if (inList2)
            expresiones2.add((Nodo)yyvsp[0].obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[0].obj);
    }
break;
case 132:
#line 776 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)yyvsp[0].obj);
    if (inList2)
        expresiones2.add((Nodo)yyvsp[0].obj);
    yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[0].obj);
    }
break;
case 133:
#line 783 "gramatica.y"
{
    if (inList1)
        expresiones1.add((Nodo)yyvsp[0].obj);
    if (inList2)
        expresiones2.add((Nodo)yyvsp[0].obj);
    yyval = yyvsp[0];
    }
break;
case 134:
#line 790 "gramatica.y"
{yyerror("Falta expresion en pattern matching");}
break;
case 135:
#line 794 "gramatica.y"
{   Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            yyval.obj = new NodoComun("Outf", new NodoHoja(yyvsp[-1].sval, t));
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
break;
case 136:
#line 800 "gramatica.y"
{   Nodo exp = (Nodo)yyvsp[-1].obj;
                                 Token t = new Token(exp.getToken());
                                 t.setUso("mensaje");
                                 t.setTipo("cadena");
                                 yyval.obj = new NodoComun("Outf", new NodoHoja(exp.getNombre(),t));
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }
break;
case 137:
#line 807 "gramatica.y"
{yyerror("Falta de parametro en funcion OUTF");}
break;
#line 1852 "y.tab.c"
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
