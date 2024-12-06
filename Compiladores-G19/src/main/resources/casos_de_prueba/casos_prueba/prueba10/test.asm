.386 
.model flat, stdcall 
option casemap :none  
include \masm32\include\windows.inc 
include \masm32\include\kernel32.inc 
include \masm32\include\masm32.inc  
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
_@aux7 dd ?
_@aux6 dd ?
_@aux5 dd ?
_@aux4 dd ?
_a@main dd ?
_1 dd 1
_2 dd 2
_y@main dd ?
_3 dd 3
_4 dd 4
_i@main dd ?
_6 dd 6
_z@main dd ?
_8 dd 8
_@aux3 dd ?
_@aux2 dd ?
_@aux1 dd ?
_x@main dd ?
_10 dd 10
limite_float dq 3.4e38
@print4 db "en el for", 10, 0 
@print6 db "afuera del for", 10, 0 

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
MOV EAX, _3
MOV _x@main, EAX
invoke printf, cfm$("%d\n"), [_x@main]
MOV EAX, _2
MOV _y@main, EAX
invoke printf, cfm$("%d\n"), [_y@main]
MOV EAX, _x@main
ADD EAX, _y@main
MOV _z@main, EAX
invoke printf, cfm$("%d\n"), [_z@main]
MOV EAX, _6
MOV _a@main, EAX
MOV EAX, _1
MOV _i@main, EAX
MOV EAX, _i@main
label2:
CMP EAX, _10
JL  label1
JMP label4
label1:
MOV EAX, _a@main
CMP EAX, _10
JLE  label3
JMP label4
label3:
invoke printf, addr @print4
MOV EAX, _a@main
ADD EAX, _1
MOV _a@main, EAX
invoke printf, cfm$("%d\n"), [_a@main]
MOV EAX, _i@main
ADD EAX, _1
MOV _i@main, EAX
JMP label2
label4:
invoke printf, addr @print6
MOV EAX, _2
IMUL EAX, _8
MOV _@aux6, EAX
MOV EAX, _4
ADD EAX, _@aux6
MOV _z@main, EAX
invoke printf, cfm$("%d\n"), [_z@main]
invoke ExitProcess, 0 
end start