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
_1 dd 1
_2 dd 2
_3 dd 3
_y@main dd ?
_5 dd 5
_t1@main dd ?,?,?
_z@main dd ?
_i@main@f3 dd ?
_@aux3 dd ?
_@aux2 dd ?
_@aux1 dq ?
_x@main dd ?
limite_float dq 3.4e38
@print2 db "i es igual a 1", 10, 0 

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
f3@main:
PUSH EBP
MOV EBP, ESP
MOV EAX, [EBP + 8]
MOV _i@main@f3,EAX
MOV EAX, _x@main
CMP EAX, _3
JLE  label1
invoke printf, cfm$("%d\n"), [_i@main@f3]
JMP label2
label1:
MOV EAX, _1
MOV _i@main@f3, EAX
invoke printf, addr @print2
invoke printf, cfm$("%d\n"), [_i@main@f3]
label2:
MOV EAX, _5
MOV _x@main, EAX
MOV EAX, _x@main
POP EBP 
ret 

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
ADD ESP, 8
MOV [_t1@main + 0], EAX
invoke printf, cfm$("%d\n"), [_y@main]
invoke printf, cfm$("%d\n"), [_t1@main + 0]
invoke ExitProcess, 0 
end start