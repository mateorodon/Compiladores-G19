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
_@aux7 dd ?
_@aux6 dd ?
_@aux5 dd ?
_@aux4 dd ?
_a@main dd ?
_@aux9 dd ?
_@aux8 dd ?
_d@main dq ?
_@aux3 dd ?
_@aux2 dd ?
_c@main dq ?
_@aux1 dd ?
_@aux11 dq ?
_@aux12 dq ?
_@aux13 dq ?
_@aux14 dq ?
_b@main dd ?
_@aux10 dd ?
_@aux15 dq ?
_1 dd 1
_2 dd 2
_1_0 dq 1.0
_3 dd 3
_2_0 dq 2.0
_4 dd 4
_5 dd 5
_3_5 dq 3.5
limite_float dq 3.4e38
@print1 db "a =", 10, 0 
@print3 db "b =", 10, 0 
@print5 db "c =", 10, 0 
@print7 db "d =", 10, 0 
@print9 db "(2,3,4) < (3,4,5)", 10, 0 
@print10 db "(2,3,4) >= (3,4,5)", 10, 0 
@print11 db "(2,3,4) < (3,3,5)", 10, 0 
@print12 db "(2,3,4) >= (3,3,5)", 10, 0 
@print13 db "(a,b) = (1,2)", 10, 0 
@print14 db "(a,b) != (1,2)", 10, 0 
@print15 db "(a,b) <= (a,b)", 10, 0 
@print16 db "(a,b) > (a,b)", 10, 0 
@print17 db "(c, d) >= (c, 2.0)", 10, 0 
@print18 db "(c, d) < (c, 2.0)", 10, 0 
@print19 db "(3.5, d) < (3.5, 2.0)", 10, 0 
@print20 db "(3.5, d) >= (3.5, 2.0)", 10, 0 
@print21 db "3.5 <= 3.5", 10, 0 
@print22 db "3.5 > 3.5", 10, 0 

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
MOV EAX, _1
MOV _a@main, EAX
MOV EAX, _2
MOV _b@main, EAX
FLD _1_0
FST _c@main
FSTP ST(0)
FLD _2_0
FST _d@main
FSTP ST(0)
invoke printf, addr @print1
invoke printf, cfm$("%d\n"), [_a@main]
invoke printf, addr @print3
invoke printf, cfm$("%d\n"), [_b@main]
invoke printf, addr @print5
invoke printf, cfm$("%.20Lf\n"), [_c@main]
invoke printf, addr @print7
invoke printf, cfm$("%.20Lf\n"), [_d@main]
MOV EAX, _2
CMP EAX, _3
JGE  label1
MOV EAX, _3
CMP EAX, _4
JGE  label1
MOV EAX, _4
CMP EAX, _5
JGE  label1
invoke printf, addr @print9
JMP label2
label1:
invoke printf, addr @print10
label2:
MOV EAX, _2
CMP EAX, _3
JGE  label3
MOV EAX, _3
CMP EAX, _3
JGE  label3
MOV EAX, _4
CMP EAX, _5
JGE  label3
invoke printf, addr @print11
JMP label4
label3:
invoke printf, addr @print12
label4:
MOV EAX, _a@main
CMP EAX, _1
JNE  label5
MOV EAX, _b@main
CMP EAX, _2
JNE  label5
invoke printf, addr @print13
JMP label6
label5:
invoke printf, addr @print14
label6:
MOV EAX, _a@main
CMP EAX, _a@main
JG  label7
MOV EAX, _b@main
CMP EAX, _b@main
JG  label7
invoke printf, addr @print15
JMP label8
label7:
invoke printf, addr @print16
label8:
FLD _c@main
FCOM _c@main
FSTSW AX 
SAHF 
JL label9
FLD _d@main
FCOM _2_0
FSTSW AX 
SAHF 
JL label9
invoke printf, addr @print17
JMP label10
label9:
invoke printf, addr @print18
label10:
FLD _3_5
FCOM _3_5
FSTSW AX 
SAHF 
JGE label11
FLD _d@main
FCOM _2_0
FSTSW AX 
SAHF 
JGE label11
invoke printf, addr @print19
JMP label12
label11:
invoke printf, addr @print20
label12:
FLD _3_5
FCOM _3_5
FSTSW AX 
SAHF 
JG label13
invoke printf, addr @print21
JMP label14
label13:
invoke printf, addr @print22
label14:
invoke ExitProcess, 0 
end start