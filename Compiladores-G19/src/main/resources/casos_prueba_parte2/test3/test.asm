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
_y:main db ?
_z:main db ?
_1 db 1
_x:main db ?
_2 db 2
_3 db 3
_2.0 dq 2.0
@print1 db "z:main:f3", 0 

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
f3:main:
MOV EAX, x:main
CMP EAX, 3
JLE label1
invoke MessageBox, NULL, addr @print1, addr printMensaje, MB_OK
JMP label2
label1:
label2:

MOV EAX, 2
ADD EAX, 2
MOV @aux3, EAX
MOV EAX, @aux3
MOV @aux2, EAX
ret 
JMP errorFun
main:
MOV EAX ,3
MOV x:main, EAX
MOV EAX ,2
MOV y:main, EAX
MOV EAX, x:main
ADD EAX, y:main
MOV @aux4, EAX
MOV EAX ,@aux4
MOV z:main, EAX
MOV EAX, y:main
MOV EAX, y:main
call f3:main
MOV EAX, y:main
MOV EAX, y:main
call f3:main
FLD 2.0
FST t1[1]
MOV EAX ,t1[1]
MOV x:main, EAX
invoke ExitProcess, 0 
end main