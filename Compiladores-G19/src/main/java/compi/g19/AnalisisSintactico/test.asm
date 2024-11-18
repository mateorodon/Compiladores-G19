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
m:
JMP errorFun
main:
MOV EAX, 2
ADD EAX, 1
MOV @aux1, EAX
MOV EAX , @aux1
MOV rr:main, EAX
invoke ExitProcess, 0 
end main