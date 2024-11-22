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
_2 db 2
_3 db 3
_i:main db ?
@print1 db "HOLA", 0 

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
main:
MOV EAX, 1
MOV i:main, EAX
MOV EAX, i:main
label2:
CMP EAX, 3
JL label1
JMP label4:
label1:
MOV EAX, i:main
CMP EAX, 2
JL label3
JMP label4:
label3:
invoke MessageBox, NULL, addr @print1, addr printMensaje, MB_OK
MOV EAX, i:main
ADD EAX, 1
MOV @aux1, EAX
MOV i:main, @aux1
JMP label2
label4:
invoke ExitProcess, 0 
end main