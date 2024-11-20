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
_identificadormu:main db ?
_x:main:f3 dq ?
_x:main db ?
_2 db 2
_1.0 dq 1.0
_2.0 dq 2.0
_0.3 dq 0.3
_1.2 dq 1.2
_i:main db ?
_10 db 10
@print1 db "en el for", 0 

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
f3:main:
FLD 1.2
FST x:main:f3
FLD x:main:f3
FCOM 1.0
JGE label1
MOV EAX ,1
MOV i:main, EAX
MOV EAX, i:main
CMP EAX, 10
JGE label2
JMP label3:
label2:
invoke MessageBox, NULL, addr @print1, addr printMensaje, MB_OK
MOV EAX, i:main
ADD EAX, 1
MOV @aux2, EAX
JMP label2
label3:
JMP label5
label4:
label5:

FLD x:main:f3
FST @aux4
ret 
 JMP AutoinvocacionFunciones

main:
MOV EAX, x:main
MOV EAX, x:main
call f3:main
invoke ExitProcess, 0 
end main