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
_15 dd 15
_e@main dd ?,?,?
_aa@main@f1 dq ?
_g@main dd ?,?,?
_1 dd 1
_2 dd 2
_3 dd 3
_5 dd 5
_5_0 dq 5.0
_@aux2 dq ?
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
FLD QWORD PTR [EBP + 8]
FSTP _aa@main@f1
FLD _aa@main@f1
FCOM _b@main
FSTSW AX 
SAHF 
JAE label1
JMP handle_autoinvocacion
label1:

MOV EAX, _3
MOV [_e@main + 0], EAX
MOV EAX, _5
MOV [_e@main + 4], EAX
MOV EAX, _10
MOV [_e@main + 8], EAX
MOV EAX, [_e@main + 0]
MOV EBX, [_e@main + 4]
MOV EDX, [_e@main + 8]
POP EBP 
ret 

start:
FLD _3450_0
FST _aa@main
FSTP ST(0)
FLD _5_0
FST _b@main
FSTP ST(0)
FLD _aa@main
SUB ESP, 8
FSTP QWORD PTR [ESP]
CALL f1@main
MOV [_e@main + 0], EAX
MOV [_e@main + 4], EBX
MOV [_e@main + 8], EDX
MOV EAX, _15
MOV [_e@main + 8], EAX
invoke printf, cfm$("%d\n"), [_e@main + 0]
invoke printf, cfm$("%d\n"), [_e@main + 4]
invoke printf, cfm$("%d\n"), [_e@main + 8]
FLD _aa@main
SUB ESP, 8
FSTP QWORD PTR [ESP]
CALL f1@main
MOV [_g@main + 0], EAX
MOV [_g@main + 4], EBX
MOV [_g@main + 8], EDX
invoke printf, cfm$("%d\n"), [_g@main + 0]
invoke printf, cfm$("%d\n"), [_g@main + 4]
invoke printf, cfm$("%d\n"), [_g@main + 8]
invoke ExitProcess, 0 
end start