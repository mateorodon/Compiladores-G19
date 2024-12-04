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
OverflowSumaDouble db "Se produjo un un overflow en la suma de doubles.", 0 
error db "Error", 0 
printMensaje db "Print", 0 
_2 dd 2
_3 dd 3
_@aux4 dd ?
_@aux3 dd ?
_@aux2 dd ?
_@aux1 dd ?
@print1 db "2 < 3", 10, 0 
@print2 db "2 >= 3", 10, 0 
@print3 db "2 = 3", 10, 0 
@print4 db "2 != 3", 10, 0 
@print5 db "2 != 3", 10, 0 
@print6 db "2 = 3", 10, 0 
@print7 db "2 >= 3", 10, 0 
@print8 db "2 < 3", 10, 0 

.code
handle_autoinvocacion: 
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
handle_negativos: 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
handle_overflow: 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
start:
MOV EAX, _2
CMP EAX, 3
JGE  label1
invoke printf, addr @print1
JMP label2
label1:
invoke printf, addr @print2
label2:
MOV EAX, _2
CMP EAX, 3
JNE  label3
invoke printf, addr @print3
JMP label4
label3:
invoke printf, addr @print4
label4:
MOV EAX, _2
CMP EAX, 3
JE  label5
invoke printf, addr @print5
JMP label6
label5:
invoke printf, addr @print6
label6:
MOV EAX, _2
CMP EAX, 3
JL  label7
invoke printf, addr @print7
JMP label8
label7:
invoke printf, addr @print8
label8:
invoke ExitProcess, 0 
end start