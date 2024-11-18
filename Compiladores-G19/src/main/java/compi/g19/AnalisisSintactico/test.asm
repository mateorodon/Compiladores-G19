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
_m:main db ?
_4 db 4
_5 db 5
_8 db 8
@print1 db "hola", 0 

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
main:
MOV EAX , 8
MOV rr:main, EAX
MOV EAX, rr:main
CMP EAX, 4
JLE label1
MOV EAX, 2
ADD EAX, 1
MOV @aux2, EAX
MOV EAX , @aux2
MOV rr:main, EAX
JMP label2
label1:
MOV EAX , 2
MOV rr:main, EAX
label2:

invoke MessageBox, NULL, addr @print1, addr printMensaje, MB_OK
MOV EAX , 6
MOV m:main, EAX
MOV EAX, m:main
CMP EAX, 5
JGE label3
JMP label4:
label3:
MOV EAX , 2
MOV m:main, EAX
MOV EAX, m:main
ADD EAX, 1
MOV @aux3, EAX
JMP label3
label4:
invoke ExitProcess, 0 
end main