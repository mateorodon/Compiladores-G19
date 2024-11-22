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
_y@main@f1 dd ?
@aux6 dd ?
@aux5 dd ?
@aux4 dd ?
_2 dd 2
_3 dd 3
_y@main dd ?
_4 dd 4
_f@main dd ?
_3.0 dd 3.0
@aux3 dd ?
@aux2 dd ?
@aux1 dd ?
_x@main dd ?
@print1 db [_x@main], 0 
@print2 db "bye bye", 0 
@print3 db [_f@main], 0 

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
MOV EAX, _z@main@f1
ADD EAX, _4
MOV _y@main@f1, EAX
MOV EAX, _3
MOV _z@main@f1, EAX
MOV EAX, _z@main@f1
ret 
JMP errorFun
start:
MOV EAX, _2
SUB EAX, _3
JS OperacionEnteroNegativo
MOV _x@main, EAX
MOV EAX, _x@main
PUSH EAX
CALL f1@main
ADD ESP, 4
MOV EAX, _2
ADD EAX, _@aux4
MOV _x@main, EAX
MOV EAX, _x@main
PUSH EAX
CALL f1@main
ADD ESP, 4
MOV _y@main, EAX
invoke MessageBox, NULL, addr @print1, addr @print1, MB_OK
invoke MessageBox, NULL, addr @print2, addr @print2, MB_OK
FLD _3.0
FST _f@main
invoke MessageBox, NULL, addr @print3, addr @print3, MB_OK
invoke ExitProcess, 0 
end start