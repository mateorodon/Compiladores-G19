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
_aa@main dq ?
_3450_0 dq 3450.0
_b@main dq ?
_a@main@f1 dd ?
_5_0 dq 5.0
_@aux3 dd ?
_@aux2 dq ?
_@aux1 dd ?
_x@main dd ?
limite_float dq 3.4e38

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
f1@main:
PUSH EBP
MOV EBP, ESP
FLD _aa@main
FCOM _b@main
FSTSW AX 
SAHF 
JGE label1
JMP handle_autoinvocacion
label1:

FLD _a@main@f1
POP EBP 
ret 

start:
FLD _3450_0
FST _aa@main
FSTP ST(0)
FLD _5_0
FST _b@main
FSTP ST(0)
CALL f1@main
ADD ESP, 4
MOV _x@main, EAX
invoke ExitProcess, 0 
end start