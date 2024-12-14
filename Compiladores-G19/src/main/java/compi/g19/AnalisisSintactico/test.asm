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
_1 dd 1
_a@main@f1 dq ?
_2 dd 2
_3 dd 3
_5 dd 5
_@aux2 dd ?
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
FLD QWORD PTR [EBP + 8]
FSTP _a@main@f1
MOV EAX, _2
CMP EAX, _3
JGE  label1
MOV EAX, _1
POP EBP 
ret 
label1:

MOV EAX, _5
POP EBP 
ret 

start:
invoke ExitProcess, 0 
end start