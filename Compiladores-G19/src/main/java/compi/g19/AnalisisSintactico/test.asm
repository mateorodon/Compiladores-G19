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
_soyNueve@main@devuelvoDiez dd ?
_1 dd 1
_param@main@devuelvoDiez dd ?
_res@main dd ?
_9 dd 9
_asd@main dd ?
_@aux2 dd ?
_@aux1 dd ?
_10 dd 10
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
devuelvoDiez@main:
PUSH EBP
MOV EBP, ESP
MOV EAX, [EBP + 8]
MOV EAX, _9
MOV _soyNueve@main@devuelvoDiez, EAX
MOV EAX, _1
MOV _param@main@devuelvoDiez, EAX
MOV EAX, _param@main@devuelvoDiez
ret 

start:
MOV EAX, _10
MOV _asd@main, EAX
MOV EAX, _asd@main
PUSH EAX
CALL devuelvoDiez@main
ADD ESP, 4
MOV _res@main, EAX
invoke printf, cfm$("%d\n"), [_res@main]
invoke ExitProcess, 0 
end start