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
@aux5 dd ?
@aux4 dd ?
_0 dd 0
_1 dd 1
_2 dd 2
_3 dd 3
_4 dd 4
_j@main dd ?,?,?
_5 dd 5
@aux3 dd ?
@aux2 dd ?
_rr@main dd ?
@aux1 dd ?
_10 dd 10
@print1 db [_rr@main], 0 
@print2 db "fin del programa", 0 

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
start:
MOV EAX, _2
SUB EAX, _10
JS OperacionEnteroNegativo
MOV _rr@main, EAX
MOV EAX, rr@main
MOV [_j@main + 4], EAX
MOV EAX, 3
CMP EAX, 2
JL label1
MOV EAX, 2
CMP EAX, 1
JL label1
MOV EAX, 1
CMP EAX, 0
JL label1
invoke MessageBox, NULL, addr @print1, addr @print1, MB_OK
JMP label2
label1:
MOV EAX, _2
MOV _rr@main, EAX
label2:
MOV EAX, 3
CMP EAX, 2
JGE label3
MOV EAX, _4
MOV _rr@main, EAX
JMP label4
label3:
MOV EAX, _3
MOV _rr@main, EAX
label4:
MOV EAX, _5
MOV _rr@main, EAX
invoke MessageBox, NULL, addr @print2, addr @print2, MB_OK
invoke ExitProcess, 0 
end start