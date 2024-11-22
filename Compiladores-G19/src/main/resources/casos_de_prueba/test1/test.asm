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
@aux4 dd ?
_1 dd 1
_2 dd 2
_y@main dd ?
_3 dd 3
_5 dd 5
_t1@main dd ?,?,?
_z@main dd ?
@aux3 dd ?
@aux2 dd ?
@aux1 dd ?
_x@main dd ?
@print1 db [_i@main@f3], 0 

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
f3@main:
PUSH EBP
MOV EBP, ESP
MOV EAX, [EBP + 8]
MOV EAX, x@main
CMP EAX, 3
JLE label1
invoke MessageBox, NULL, addr @print1, addr @print1, MB_OK
JMP label2
label1:
label2:

MOV EAX, _5
MOV _x@main, EAX
MOV EAX, _i@main@f3
ret 
JMP errorFun
start:
MOV EAX, _3
MOV _x@main, EAX
MOV EAX, _2
MOV _y@main, EAX
MOV EAX, _x@main
ADD EAX, _y@main
MOV _z@main, EAX
MOV EAX, _y@main
PUSH EAX
CALL f3@main
ADD ESP, 4
MOV EAX, @aux4
MOV [_t1@main + 0], EAX
invoke ExitProcess, 0 
end start