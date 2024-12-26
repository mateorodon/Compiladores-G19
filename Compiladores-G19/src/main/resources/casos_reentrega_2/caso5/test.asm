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
_@aux6 dq ?
_@aux5 dq ?
_@aux4 dq ?
_a@main@f1 dq ?
_a@main@f2 dq ?
_3_4 dq 3.4
_4_5 dq 4.5
_@aux3 dq ?
_@aux2 dq ?
_@aux1 dq ?
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
f2@main:
PUSH EBP
MOV EBP, ESP
FLD QWORD PTR [EBP + 8]
FSTP _a@main@f2
FLD _a@main@f2
FMUL _4_5
FST _@aux3
FLD _@aux3
SUB ESP, 8
FSTP QWORD PTR [ESP]
CALL f1@main
ADD ESP, 8
FLD _a@main@f2
POP EBP 
ret 

f1@main:
PUSH EBP
MOV EBP, ESP
FLD QWORD PTR [EBP + 8]
FSTP _a@main@f1
JMP handle_autoinvocacion
FLD _a@main@f1
POP EBP 
ret 

start:
FLD _3_4
SUB ESP, 8
FSTP QWORD PTR [ESP]
CALL f1@main
ADD ESP, 8
invoke ExitProcess, 0 
end start