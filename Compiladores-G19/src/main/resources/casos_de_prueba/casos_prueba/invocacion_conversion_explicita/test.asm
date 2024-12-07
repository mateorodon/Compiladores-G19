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
_5_0 dq 5.0
_res@main dq ?
_param@main@f1 dq ?
_@aux3 dq ?
_@aux2 dq ?
_rr@main dd ?
_@aux1 dq ?
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
FSTP _param@main@f1
invoke printf, cfm$("%.20Lf\n"), [_param@main@f1]
FLD _param@main@f1
FADD _5_0
FLD limite_float
FCOM ST(1)
FSTSW AX
SAHF 
JBE handle_overflow
FSTP ST(0)
FST _param@main@f1
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_param@main@f1]
FLD _param@main@f1
POP EBP 
ret 

start:
MOV EAX, _2
MOV _rr@main, EAX
MOV EAX, _rr@main
PUSH EAX
FILD DWORD PTR [ESP]
FSTP QWORD PTR [ESP]
CALL f1@main
ADD ESP, 8
FST _res@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_res@main]
invoke printf, cfm$("%d\n"), [_rr@main]
invoke ExitProcess, 0 
end start