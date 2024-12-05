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
_@aux7 dd ?
_@aux11 dd ?
_@aux6 dd ?
_@aux12 dd ?
_@aux5 dd ?
_@aux4 dd ?
_b@main dd ?
_a@main dd ?
_@aux9 dd ?
_@aux8 dd ?
_@aux10 dd ?
_3 dd 3
_@aux3 dd ?
_@aux2 dd ?
_c@main dd ?
_@aux1 dd ?
_10 dd 10

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
MOV EAX, _10
MOV _a@main, EAX
MOV EAX, _3
MOV _b@main, EAX
MOV EAX, _a@main
ADD EAX, _b@main
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
MOV EAX, _a@main
SUB EAX, _b@main
JS handle_negativos
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
MOV EAX, _a@main
IMUL EAX, _b@main
MOV _@aux3, EAX
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
CMP _b@main, 0
MOV EAX, _a@main
IDIV _b@main
MOV _@aux4, EAX
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
MOV EAX, _a@main
ADD EAX, _3
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
MOV EAX, _a@main
SUB EAX, _3
JS handle_negativos
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
MOV EAX, _a@main
IMUL EAX, _3
MOV _@aux7, EAX
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
CMP _3, 0
MOV EAX, _a@main
IDIV _3
MOV _@aux8, EAX
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
MOV EAX, _10
ADD EAX, _b@main
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
MOV EAX, _10
SUB EAX, _b@main
JS handle_negativos
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
MOV EAX, _10
IMUL EAX, _b@main
MOV _@aux11, EAX
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
CMP _b@main, 0
MOV EAX, _10
IDIV _b@main
MOV _@aux12, EAX
MOV _c@main, EAX
invoke printf, cfm$("%d\n"), [_c@main]
invoke ExitProcess, 0 
end start