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
_rr:main db ?
_1 db 1
_2 db 2
_8 db 8

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
p:main:
MOV EAX, m:main:p
ADD EAX, 2
MOV @aux1, EAX
MOV m:main:p ,@aux1
MOV EAX, m:main:p
MOV @aux2, EAX
ret 
JMP errorFun
main:
MOV EAX, 2
ADD EAX, 1
MOV @aux3, EAX
MOV rr:main ,@aux3
MOV EAX ,2
MOV t1[1], EAX
MOV EAX, t1[1]
IMUL EAX, 8
MOV @aux4, EAX
MOV rr:main ,@aux4
MOV EAX, rr:main
MOV EAX, rr:main
call p:main
invoke ExitProcess, 0 
end main