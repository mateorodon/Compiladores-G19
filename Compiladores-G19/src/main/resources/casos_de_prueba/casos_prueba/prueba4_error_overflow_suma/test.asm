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
_@aux4 dq ?
_b@main dq ?
_2_0 dq 2.0
_3_0 dq 3.0
_a@main dq ?
_10_0 dq 10.0
_3_4000002E38 dq 3.4000002E38
_@aux3 dq ?
_@aux2 dq ?
_c@main dq ?
_@aux1 dq ?
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
FST _a@main
FSTP ST(0)
FLD _3_0
FST _b@main
FSTP ST(0)
FLD _a@main
FADD _b@main
FLD limite_float
FCOM ST(1)
FSTSW AX
SAHF 
JBE handle_overflow
FSTP ST(0)
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _a@main
FADD _b@main
FLD limite_float
FCOM ST(1)
FSTSW AX
SAHF 
JBE handle_overflow
FSTP ST(0)
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _3_0
FADD _2_0
FLD limite_float
FCOM ST(1)
FSTSW AX
SAHF 
JBE handle_overflow
FSTP ST(0)
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _3_4000002E38
FADD _3_4000002E38
FLD limite_float
FCOM ST(1)
FSTSW AX
SAHF 
JBE handle_overflow
FSTP ST(0)
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
invoke ExitProcess, 0 
end start