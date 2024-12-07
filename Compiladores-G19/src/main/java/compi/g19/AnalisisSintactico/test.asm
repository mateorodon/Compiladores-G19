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
_1 dd 1
_2 dd 2
_1_0 dq 1.0
_t2@main dd ?,?,?
_10_0 dq 10.0
_55_0 dq 55.0
_basico@main dq ?
limite_float dq 3.4e38

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
FLD _10_0
FSTP [_t2@main + 0]
FLD _55_0
FSTP [_t2@main + 4]
FLD [_t2@main + 0]
sub esp, 8
FSTP qword ptr [esp]
invoke printf, cfm$("%.20Lf\n"), qword ptr [esp]
add esp, 8
FLD [_t2@main + 4]
sub esp, 8
FSTP qword ptr [esp]
invoke printf, cfm$("%.20Lf\n"), qword ptr [esp]
add esp, 8
FLD _1_0
FST _basico@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_basico@main]
invoke ExitProcess, 0 
end start