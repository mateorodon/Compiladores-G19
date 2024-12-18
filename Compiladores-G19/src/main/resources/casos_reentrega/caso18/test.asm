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
_aa@main dq ?
_3450_0 dq 3450.0
_b@main dq ?
_e@main dd ?,?,?
_aa@main@f1 dq ?
_1 dd 1
_3 dd 3
_5_0 dq 5.0
_@aux2 dq ?
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
FSTP _aa@main@f1
FLD _aa@main@f1
FCOM _b@main
FSTSW AX 
SAHF 
JGE label1
JMP handle_autoinvocacion
label1:

MOV EAX, _3
MOV [_e@main + 0], EAX
FLD _e@main
POP EBP 
ret 

start:
FLD _3450_0
FST _aa@main
FSTP ST(0)
FLD _5_0
FST _b@main
FSTP ST(0)
MOV ECX, 3
MOV ESI, _g@main
MOV EDI, _e@main
COPIA_INICIO_0:
FLD QWORD PTR [ESI]
FSTP QWORD PTR [EDI]
ADD ESI, 4
ADD EDI, 4
LOOP COPIA_INICIO_0
COPIA_FIN_1:
invoke ExitProcess, 0 
end start