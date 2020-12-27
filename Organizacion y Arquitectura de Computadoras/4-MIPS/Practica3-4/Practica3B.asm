# PRAC_3B.S
    .data
X:  .word   5
Y:  .byte   3
Z:  .word   6
s:  .asciiz "Hola\n"
a:  .word   10,3,5,2,6
    #-----------------------#
    .text
    .globl main
main:
    #-----------------------# Voy a leer en un registro un elemento
                            # del array "a", el elemento a[2]
    li $s0,2                # i=2 : Índice del elemento del array "a"
    la $s1,a                # p=&a[0]=a, dirección base del array "a"
    mul $t0,$s0,4           # $t0 tiene el desplazamiento (en bytes)
                            # del elemento a[i] del array
    add $t1,$s1,$t0         # $t1=p+4*i $t1 tiene la dirección del
                            # elemento a[i] del array
    lw $t2,0($t1)           # $t2 tiene el elemento a[i]
    lw $s0,X                # Los datos etiquetados con X,Y,Z no están
    lb $s1,Y                # alineados. Para poder cargarlos en los
    lw $s2,Z                # registros, usamos la instrucción "lw"
                            # cuando es una palabra, y "lb" si es un byte
    #-----------------------# Fin del programa
    li $v0,10
    syscall 