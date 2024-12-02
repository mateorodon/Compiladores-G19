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
@aux7 dd ?
@aux11 dd ?
@aux6 dd ?
@aux12 dd ?
@aux5 dd ?
@aux13 dd ?
@aux4 dd ?
@aux14 dd ?
_b@main dd ?
_a@main dd ?
@aux9 dd ?
@aux8 dd ?
@aux10 dd ?
@aux15 dd ?
@aux16 dd ?
_3.0 dd 3.0
_10.0 dd 10.0
@aux3 dd ?
@aux2 dd ?
_c@main dd ?
@aux1 dd ?
@print1 db [_c@main], 0 
@print2 db [_c@main], 0 
@print3 db [_c@main], 0 
@print4 db [_c@main], 0 
@print5 db [_c@main], 0 
@print6 db [_c@main], 0 
@print7 db [_c@main], 0 
@print8 db [_c@main], 0 
@print9 db [_c@main], 0 
@print10 db [_c@main], 0 
@print11 db [_c@main], 0 
@print12 db [_c@main], 0 
@print13 db [_c@main], 0 
@print14 db [_c@main], 0 
@print15 db [_c@main], 0 
@print16 db [_c@main], 0 

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK 
invoke ExitProcess, 0 
start:
FLD _10.0
FST _a@main
FLD _3.0
FST _b@main
FLD _a@main
FADD _b@main
JS errorSumaDouble
FST _c@main
invoke MessageBox, NULL, addr @print1, addr @print1, MB_OK
FLD _a@main
FSUB _b@main
FST _c@main
invoke MessageBox, NULL, addr @print2, addr @print2, MB_OK
FLD _a@main
FMUL _b@main
FST @aux3
FST _c@main
invoke MessageBox, NULL, addr @print3, addr @print3, MB_OK
FLD _b@main
FSUB _b@main
FTST FLD _a@main
FDIV _b@main
FST @aux4
FST _c@main
invoke MessageBox, NULL, addr @print4, addr @print4, MB_OK
FLD _a@main
FADD _3.0
JS errorSumaDouble
FST _c@main
invoke MessageBox, NULL, addr @print5, addr @print5, MB_OK
FLD _a@main
FSUB _3.0
FST _c@main
invoke MessageBox, NULL, addr @print6, addr @print6, MB_OK
FLD _a@main
FMUL _3.0
FST @aux7
FST _c@main
invoke MessageBox, NULL, addr @print7, addr @print7, MB_OK
FLD _3.0
FSUB _3.0
FTST FLD _a@main
FDIV _3.0
FST @aux8
FST _c@main
invoke MessageBox, NULL, addr @print8, addr @print8, MB_OK
FLD _10.0
FADD _b@main
JS errorSumaDouble
FST _c@main
invoke MessageBox, NULL, addr @print9, addr @print9, MB_OK
FLD _10.0
FSUB _b@main
FST _c@main
invoke MessageBox, NULL, addr @print10, addr @print10, MB_OK
FLD _10.0
FMUL _b@main
FST @aux11
FST _c@main
invoke MessageBox, NULL, addr @print11, addr @print11, MB_OK
FLD _b@main
FSUB _b@main
FTST FLD _10.0
FDIV _b@main
FST @aux12
FST _c@main
invoke MessageBox, NULL, addr @print12, addr @print12, MB_OK
FLD _10.0
FADD _3.0
JS errorSumaDouble
FST _c@main
invoke MessageBox, NULL, addr @print13, addr @print13, MB_OK
FLD _10.0
FSUB _3.0
FST _c@main
invoke MessageBox, NULL, addr @print14, addr @print14, MB_OK
FLD _10.0
FMUL _3.0
FST @aux15
FST _c@main
invoke MessageBox, NULL, addr @print15, addr @print15, MB_OK
FLD _3.0
FSUB _3.0
FTST FLD _10.0
FDIV _3.0
FST @aux16
FST _c@main
invoke MessageBox, NULL, addr @print16, addr @print16, MB_OK
invoke ExitProcess, 0 
end start