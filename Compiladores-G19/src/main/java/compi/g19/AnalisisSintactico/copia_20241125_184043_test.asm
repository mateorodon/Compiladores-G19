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

.data
AutoinvocacionFunciones db "Una funcion no puede llamarse a si misma.", 0 
OperacionEnteroNegativo db "El resultado de la operacion no puede ser negativo.", 0 
OverflowSumaDouble db "Se produjo un un overflow en la suma de doubles.", 0 
error db "Error", 0 
printMensaje db "Print", 0 
_1 dd 1
@aux6 dd ?
_2 dd 2
@aux5 dd ?
@aux4 dd ?
_4 dd 4
_i@main dd ?
_m@main dd ?
@aux3 dd ?
@aux2 dd ?
@aux1 dd ?

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
start:
MOV EAX, _1
MOV _m@main, EAX
MOV EAX, m@main
label2:
CMP EAX, 2
JL  label1
JMP label4:
label1:
MOV EAX, m@main
CMP EAX, 1
JG  label3
JMP label4:
label3:
MOV EAX, _1
MOV _m@main, EAX
MOV EAX, m@main
label6:
CMP EAX, 2
JL  label5
JMP label8:
label5:
MOV EAX, m@main
CMP EAX, 1
JG  label3
MOV EAX, m@main
CMP EAX, 1
JG  label7
JMP label8:
label7:
MOV EAX, _2
MOV _i@main, EAX
MOV EAX, _m@main
ADD EAX, _1
MOV @aux1, EAX
MOV _m@main, @aux1
MOV EAX, _m@main
ADD EAX, _1
MOV @aux4, EAX
MOV _m@main, @aux4
JMP label6
label8:
MOV EAX, _4
MOV _i@main, EAX
MOV EAX, _m@main
ADD EAX, _1
MOV @aux1, EAX
MOV _m@main, @aux1
MOV EAX, _m@main
ADD EAX, _1
MOV @aux4, EAX
MOV _m@main, @aux4
JMP label6
label4:
invoke ExitProcess, 0 
end start