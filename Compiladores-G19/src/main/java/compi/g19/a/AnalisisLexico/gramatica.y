%token ID ASIGNACION MAYORIGUAL MENORIGUAL DISTINTO CONSTANTE CADENA IF THEN ELSE BEGIN END END_IF OUTF TYPEDEF FUN RET ULONGINT SINGLE FOR OR UP DOWN TRIPLE
%%

%start programa

programa: nombre_programa statement_block ;

nombre_programa:
    ID { System.out.println("Nombre del programa: " + $1); }
    ;

statement_block:
    BEGIN statement_list END
    ;

statement_list:
    statement ';' ;
    | statement statement_list
    ;

statement: ID ;

%%

//codigo