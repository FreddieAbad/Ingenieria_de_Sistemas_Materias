# PRAC_7.S
        .text
        .globl main
main:   la $a1,si           # $a1 tiene si = dirección base
                            # de la cadena "texto"
        jal strlen          # Devuelve en $v0 la longitud de
                            # la cadena que hay en $a1
        move $t0,$v0        # Imprimo información de la longitud
        la $a0,nota1
        li $v0,4
        syscall
        la $a0,si
        li $v0,4
        syscall
        la $a0,nota2
        li $v0,4
        syscall
        move $a0,$t0
        li $v0,1
        syscall
        la $a0,nota3
        li $v0,4
        syscall
        la $a1, si          # $a1 tiene si = dirección base
                            # de la cadena "texto"
        la $a0, so          # $a0 tiene so = dirección base
                            # para la futura cadena
        jal strcpy          # Copio en so la cadena que hay en si
        la $a0, so          # Consola muestra la cadena
        li $v0, 4           # que hay en so
        syscall
        li $v0, 10          # Fin del programa
        syscall
        #-----------------------#
    strcpy: lb $t0,0($a1)   # strcpy -- copia la cadena
        addi $a1,$a1,1      # apuntada por $a1 a la
        sb $t0,0($a0)       # localidad apuntada por $a0
        addi $a0,$a0,1
        bnez $t0,strcpy
        jr $ra
        #-----------------------#
    strlen: li $v0,0        # strlen -- calcula la longitud
    str0: lb $t0,0($a1)     # de la cadena apuntada
        beqz $t0,str1       # por $a1
        addi $v0,$v0,1
        addi $a1,$a1,1
        b str0
    str1: jr $ra
        #-----------------------#
        .data
    nota1: .asciiz "Longitud de ("
    nota2: .asciiz ") = "
    nota3: .asciiz "\n"
    si: .asciiz "texto"
    so: .space 80