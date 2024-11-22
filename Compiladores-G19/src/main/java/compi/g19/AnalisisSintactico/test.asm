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

.data
AutoinvocacionFunciones db "Una funcion no puede llamarse a si misma.", 0 
OperacionEnteroNegativo db "El resultado de la operacion no puede ser negativo.", 0 
OverflowSumaDouble db "Se produjo un un overflow en la suma de doubles.", 0 
error db "Error", 0 
printMensaje db "Print", 0 
_1 dd 1
_1.0 dd 1.0
@aux1 dd ?
_x@main dd ?

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
f1@main:
PUSH EBP
MOV EBP, ESP
MOV EAX, [EBP + 8]
MOV EAX, _1
MOV _a@main@f1, EAX
MOV EAX, _a@main@f1
ret 
JMP errorFun
start:
FLD _1.0
FST _x@main
MOV EAX, _x@main
PUSH EAX
FLD [ESP]
FISTP [ESP]
CALL f1@main
ADD ESP, 4
invoke ExitProcess, 0 
end start