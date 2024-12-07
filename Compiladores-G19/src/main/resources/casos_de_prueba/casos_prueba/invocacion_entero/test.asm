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
_2 dd 2
_@aux5 dd ?
_@aux4 dd ?
_5 dd 5
_res@main dd ?
_param@main@f1 dd ?
_@aux3 dd ?
_@aux2 dd ?
_rr@main dd ?
_@aux1 dd ?
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
MOV EAX, [EBP + 8]
MOV _param@main@f1,EAX
MOV EAX, _param@main@f1
ADD EAX, _5
MOV _param@main@f1, EAX
invoke printf, cfm$("%d\n"), [_param@main@f1]
MOV EAX, _param@main@f1
POP EBP 
ret 

start:
MOV EAX, _2
MOV _rr@main, EAX
MOV EAX, _rr@main
PUSH EAX
CALL f1@main
ADD ESP, 4
MOV _res@main, EAX
invoke printf, cfm$("%d\n"), [_res@main]
invoke printf, cfm$("%d\n"), [_rr@main]
MOV EAX, _rr@main
ADD EAX, _2
MOV _rr@main, EAX
MOV EAX, _rr@main
PUSH EAX
CALL f1@main
ADD ESP, 4
MOV _res@main, EAX
invoke printf, cfm$("%d\n"), [_res@main]
invoke printf, cfm$("%d\n"), [_rr@main]
invoke ExitProcess, 0 
end start