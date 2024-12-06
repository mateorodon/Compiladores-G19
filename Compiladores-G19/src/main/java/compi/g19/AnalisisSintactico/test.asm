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
_@aux5 dd ?
_@aux4 dd ?
_0 dd 0
_1 dd 1
_2 dd 2
_3 dd 3
_4 dd 4
_j@main dd ?,?,?
_5 dd 5
_@aux3 dd ?
_@aux2 dd ?
_rr@main dd ?
_@aux1 dd ?
_10 dd 10
limite_float dq 3.4e38
@print2 db "fin del programa", 10, 0 

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
MOV EAX, _2
SUB EAX, _10
JS handle_negativos
MOV _rr@main, EAX
MOV EAX, _rr@main
MOV [_j@main + 4], EAX
MOV EAX, _3
CMP EAX, _2
JL  label1
MOV EAX, _2
CMP EAX, _1
JL  label1
MOV EAX, _1
CMP EAX, _0
JL  label1
invoke printf, cfm$("%d\n"), [_rr@main]
JMP label2
label1:
MOV EAX, _2
MOV _rr@main, EAX
label2:
MOV EAX, _3
CMP EAX, _2
JGE  label3
MOV EAX, _4
MOV _rr@main, EAX
JMP label4
label3:
MOV EAX, _3
MOV _rr@main, EAX
label4:
MOV EAX, _5
MOV _rr@main, EAX
invoke printf, addr @print2
invoke ExitProcess, 0 
end start