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
_@aux4 dd ?
_q@main@autoinvocacion dd ?
_d@main@autoinvocacion dd ?
_2 dd 2
_y@main dd ?
_3 dd 3
_4 dd 4
_@aux3 dd ?
_@aux2 dd ?
_@aux1 dd ?
_x@main dd ?
limite_float dq 3.4e38
@print4 db "if true", 10, 0 
@print5 db "if false", 10, 0 

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
autoinvocacion@main:
PUSH EBP
MOV EBP, ESP
MOV EAX, [EBP + 8]
MOV _d@main@autoinvocacion, EAX
MOV EAX, _2
MOV _d@main@autoinvocacion, EAX
MOV EAX, _3
CMP EAX, _2
JGE  label1
JMP handle_autoinvocacion
label1:

MOV EAX, _d@main@autoinvocacion
POP EBP 
ret 

start:
MOV EAX, _2
MOV _x@main, EAX
invoke printf, cfm$("%d\n"), [_x@main]
MOV EAX, _4
MOV _x@main, EAX
MOV EAX, _x@main
PUSH EAX
CALL autoinvocacion@main
ADD ESP, 4
MOV _y@main, EAX
invoke printf, cfm$("%d\n"), [_y@main]
invoke printf, cfm$("%d\n"), [_x@main]
MOV EAX, _3
CMP EAX, _2
JGE  label2
invoke printf, addr @print4
JMP label3
label2:
invoke printf, addr @print5
label3:
invoke ExitProcess, 0 
end start