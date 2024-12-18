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
_res2@main dd ?
_q@main dd ?
_param@main@devuelvoUno dd ?
_1 dd 1
_5 dd 5
_9 dd 9
_asd@main dd ?
_soyNueve@main@devuelvoUno dd ?
_res1@main dd ?
_@aux3 dd ?
_@aux2 dd ?
_@aux1 dd ?
_10 dd 10
limite_float dq 3.4e38
@print1 db "soyNueve:", 10, 0 
@print3 db "noSoyNueve:", 10, 0 
@print5 db "asd:", 10, 0 
@print7 db "res1:", 10, 0 
@print9 db "q:", 10, 0 
@print11 db "res2:", 10, 0 

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
devuelvoUno@main:
PUSH EBP
MOV EBP, ESP
MOV EAX, [EBP + 8]
MOV _param@main@devuelvoUno, EAX
MOV EAX, _9
MOV _soyNueve@main@devuelvoUno, EAX
invoke printf, addr @print1
invoke printf, cfm$("%d\n"), [_soyNueve@main@devuelvoUno]
MOV EAX, _param@main@devuelvoUno
MOV _soyNueve@main@devuelvoUno, EAX
invoke printf, addr @print3
invoke printf, cfm$("%d\n"), [_soyNueve@main@devuelvoUno]
MOV EAX, _1
MOV _param@main@devuelvoUno, EAX
MOV EAX, _param@main@devuelvoUno
POP EBP 
ret 

start:
MOV EAX, _10
MOV _asd@main, EAX
MOV EAX, _5
MOV _q@main, EAX
invoke printf, addr @print5
invoke printf, cfm$("%d\n"), [_asd@main]
MOV EAX, _asd@main
PUSH EAX
CALL devuelvoUno@main
ADD ESP, 4
MOV _res1@main, EAX
invoke printf, addr @print7
invoke printf, cfm$("%d\n"), [_res1@main]
invoke printf, addr @print9
invoke printf, cfm$("%d\n"), [_q@main]
MOV EAX, _q@main
PUSH EAX
CALL devuelvoUno@main
ADD ESP, 4
MOV _res2@main, EAX
invoke printf, addr @print11
invoke printf, cfm$("%d\n"), [_res2@main]
invoke ExitProcess, 0 
end start