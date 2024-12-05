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
_@aux7 dq ?
_@aux11 dq ?
_@aux6 dq ?
_@aux12 dq ?
_@aux5 dq ?
_@aux13 dq ?
_@aux4 dq ?
_@aux14 dq ?
_b@main dq ?
_a@main dq ?
_@aux9 dq ?
_@aux8 dq ?
_@aux10 dq ?
_@aux15 dq ?
_@aux16 dq ?
_3_0 dq 3.0
_10_0 dq 10.0
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
FSUB _b@main
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _a@main
FMUL _b@main
FST _@aux3
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _a@main
FDIV _b@main
FST _@aux4
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _a@main
FADD _3_0
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
FSUB _3_0
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _a@main
FMUL _3_0
FST _@aux7
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _a@main
FDIV _3_0
FST _@aux8
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _10_0
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
FLD _10_0
FSUB _b@main
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _10_0
FMUL _b@main
FST _@aux11
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _10_0
FDIV _b@main
FST _@aux12
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _10_0
FADD _3_0
FLD limite_float
FCOM ST(1)
FSTSW AX
SAHF 
JBE handle_overflow
FSTP ST(0)
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _10_0
FSUB _3_0
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _10_0
FMUL _3_0
FST _@aux15
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
FLD _10_0
FDIV _3_0
FST _@aux16
FST _c@main
FSTP ST(0)
invoke printf, cfm$("%.20Lf\n"), [_c@main]
invoke ExitProcess, 0 
end start