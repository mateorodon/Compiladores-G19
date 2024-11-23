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
@aux6 dd ?
@aux5 dd ?
@aux4 dd ?
_a@main dd ?
_2 dd 2
_y@main dd ?
_3 dd 3
_4 dd 4
_i@main dd ?
_6 dd 6
_z@main dd ?
_8 dd 8
@aux3 dd ?
@aux2 dd ?
@aux1 dd ?
_x@main dd ?
_10 dd 10
@print1 db "en el for", 0 
@print2 db [_z@main], 0 

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
start:
MOV EAX, _3
MOV _x@main, EAX
MOV EAX, _2
MOV _y@main, EAX
MOV EAX, _x@main
ADD EAX, _y@main
MOV _z@main, EAX
MOV EAX, _6
MOV _a@main, EAX
MOV _i@main, EAX
MOV EAX, i@main
label2:
CMP EAX, 10
JL  label1
JMP label4:
label1:
MOV EAX, a@main
CMP EAX, 10
JG  label3
JMP label4:
label3:
invoke MessageBox, NULL, addr @print1, addr @print1, MB_OK
MOV EAX, _i@main
ADD EAX, _1
MOV @aux2, EAX
MOV _i@main, @aux2
JMP label2
label4:
MOV EAX, _2
IMUL EAX, _8
MOV @aux5, EAX
MOV EAX, _4
ADD EAX, _@aux5
MOV _z@main, EAX
invoke MessageBox, NULL, addr @print2, addr @print2, MB_OK
invoke ExitProcess, 0 
end start