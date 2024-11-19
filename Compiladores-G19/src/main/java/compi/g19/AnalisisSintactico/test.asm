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

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
p:main:
MOV EAX , 2
MOV m:main:p, EAX
MOV EAX, m:main:p
MOV @aux1, EAX
ret 
JMP errorFun
main:
MOV EAX, 2
ADD EAX, 1
MOV @aux2, EAX
MOV EAX , @aux2
MOV rr:main, EAX
MOV EAX , 2
MOV m:main:p, EAX
MOV EAX, m:main:p
MOV @aux3, EAX
ret 
MOV EAX , 2
MOV m:main:p, EAX
MOV EAX, m:main:p
MOV @aux3, EAX
ret 
call p:main
invoke ExitProcess, 0 
end main