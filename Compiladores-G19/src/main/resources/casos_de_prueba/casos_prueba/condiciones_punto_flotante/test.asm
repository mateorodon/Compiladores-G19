.386 
.model flat, stdcall 
option casemap :none  
include \masm32\include\windows.inc 
include \masm32\include\kernel32.inc 
include \masm32\include\masm32.inc  
includelib \masm32\lib\kernel32.lib 
includelib \masm32\lib\masm32.lib
include \masm32\include\user32.inc 
includelib \masm32\lib\user32.lib 
include \masm32\include\masm32rt.inc 
dll_dllcrt0 PROTO C 
printf PROTO C : VARARG 

.data
AutoinvocacionFunciones db "Una funcion no puede llamarse a si misma.", 0 
OperacionEnteroNegativo db "El resultado de la operacion no puede ser negativo.", 0 
OverflowSumaFlotantes db "Se produjo un un overflow en la suma de flotantes.", 0 
error db "Error", 0 
printMensaje db "Print", 0 
_@aux4 dq ?
_2_0 dq 2.0
_3_0 dq 3.0
_4_0 dq 4.0
_@aux3 dq ?
_@aux2 dq ?
_@aux1 dq ?
limite_float dq 3.4e38
@print1 db "2.0 < 3.0", 10, 0 
@print2 db "2.0 >= 3.0", 10, 0 
@print3 db "4.0 = 3.0", 10, 0 
@print4 db "4.0 != 3.0", 10, 0 
@print5 db "4.0 != 3.0", 10, 0 
@print6 db "4.0 = 3.0", 10, 0 
@print7 db "4 >= 3", 10, 0 
@print8 db "4 < 3", 10, 0 

.code
handle_autoinvocacion: 
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
handle_negativos: 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
handle_overflow: 
invoke MessageBox, NULL, addr OverflowSumaFlotantes, addr error, MB_OK 
invoke ExitProcess, 0 
start:
FLD _3_0
FCOM _2_0
FSTSW AX 
SAHF 
JG label1
invoke printf, addr @print1
JMP label2
label1:
invoke printf, addr @print2
label2:
FLD _4_0
FCOM _3_0
FSTSW AX 
SAHF 
JNE label3
invoke printf, addr @print3
JMP label4
label3:
invoke printf, addr @print4
label4:
FLD _4_0
FCOM _3_0
FSTSW AX 
SAHF 
JE label5
invoke printf, addr @print5
JMP label6
label5:
invoke printf, addr @print6
label6:
FLD _4_0
FCOM _3_0
FSTSW AX 
SAHF 
JL label7
invoke printf, addr @print7
JMP label8
label7:
invoke printf, addr @print8
label8:
invoke ExitProcess, 0 
end start