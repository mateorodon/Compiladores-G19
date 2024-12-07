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
_2 dd 2
_y@main dq ?
_4 dd 4
_2_0 dq 2.0
_@aux2 dd ?
_@aux1 dd ?
_x@main dd ?
_10 dd 10
limite_float dq 3.4e38
@print1 db "hola", 10, 0 

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
MOV EAX, _4
IMUL EAX, _2
MOV _@aux1, EAX
MOV EAX, _10
SUB EAX, _@aux1
JS handle_negativos
MOV _x@main, EAX
FLD _2_0
FST _y@main
FSTP ST(0)
invoke printf, addr @print1
invoke printf, cfm$("%d\n"), [_x@main]
invoke printf, cfm$("%.20Lf\n"), [_y@main]
invoke ExitProcess, 0 
end start