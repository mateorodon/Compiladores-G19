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
_@aux6 dd ?
_@aux5 dd ?
_@aux4 dd ?
_1 dd 1
_2 dd 2
_3 dd 3
_4 dd 4
_i@main dd ?
_j@main dd ?
_m@main dd ?
_6 dd 6
_@aux3 dd ?
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
start:
MOV EAX, _3
SUB EAX, _4
JS handle_negativos
MOV _i@main, EAX
MOV EAX, _1
MOV _j@main, EAX
MOV EAX, _i@main
CMP EAX, _6
JL  label1
MOV EAX, _j@main
CMP EAX, _2
JL  label1
MOV EAX, _2
MOV _i@main, EAX
JMP label2
label1:
MOV EAX, _1
MOV _i@main, EAX
MOV EAX, _1
MOV _m@main, EAX
MOV EAX, _m@main
label4:
CMP EAX, _2
JL  label3
JMP label6
label3:
MOV EAX, _m@main
CMP EAX, _1
JG  label5
JMP label6
label5:
MOV EAX, _2
MOV _i@main, EAX
MOV EAX, _m@main
ADD EAX, _1
MOV _m@main, EAX
JMP label4
label6:
label2:
invoke ExitProcess, 0 
end start