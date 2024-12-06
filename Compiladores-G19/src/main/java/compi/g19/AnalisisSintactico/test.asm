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
_1_0 dq 1.0
_res@main dd ?
_param@main@f1 dd ?
_flotante@main dq ?
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
f1@main:
PUSH EBP
MOV EBP, ESP
MOV EAX, [EBP + 8]
MOV _flotante@main, EAX
MOV EAX, _10
MOV _param@main@f1, EAX
MOV EAX, _param@main@f1
POP EBP 
ret 

start:
FLD _1_0
FST _flotante@main
FSTP ST(0)
MOV EAX, _flotante@main
PUSH EAX
FLD QWORD PTR [ESP]
FISTP DWORD PTR [ESP]
CALL f1@main
ADD ESP, 4
MOV EAX, _@aux2
MOV _res@main, EAX
invoke printf, cfm$("%d\n"), [_res@main]
invoke ExitProcess, 0 
end start