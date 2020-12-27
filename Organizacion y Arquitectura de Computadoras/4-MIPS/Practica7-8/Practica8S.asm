# PRAC_8.S
        .text
        .globl main
main:   #-----------------------#
        # (0)
        #-----------------------#
        subu $sp,$sp,32 # La rutina main crea su marco de pila
        sw $ra,20($sp) # Mem[$sp+20]=$ra. Guardo direcc. de vuelta
        sw $fp,16($sp) # Mem[$sp+16]=$fp. Guardo $fp antiguo.
        # Estas posiciones de memoria van separadas
        # por 4 Bytes (estamos almacenando palabras)
        addu $fp,$sp,32 # $fp=$sp+32. $fp apunta al comienzo del
        # marco de pila (donde estaba $sp antes)
        #-----------------------#
        # (1)
        #-----------------------#
        li $a0,3 # Pongo argumento (n=3) en $a0
        jal fact # Llama fact, almacena en $ra dir. sig. inst.
        #-----------------------#
        move $a0,$v0 # En $v0 está el resultado. Lo imprimo
        li $v0,1 # en la consola.
        syscall
        #-----------------------#
        lw $ra,20($sp) # Restauro registros
        lw $fp,16($sp)
        addu $sp,$sp,32
        #-----------------------#
        # (10)
        #-----------------------#
        j $ra
        fact:   #=======================# # Rutina 'fact'
                subu $sp,$sp,32 # Crea marco de pila
                sw $ra,20($sp)
                sw $fp,16($sp)
                addu $fp,$sp,32
                sw $a0,0($fp) # Guardo argumento $a0 en marco de pila (n)
                #-----------------------#
                # (2),(3),(4),(5)
                #-----------------------#
                lw $v0,0($fp)
                bgtz $v0,$L2
                li $v0,1
                j $L1
        $L2:    lw $v1,0($fp)
                subu $v0,$v1,1
                move $a0,$v0
                jal fact
                lw $v1,0($fp)
                mul $v0,$v0,$v1
        $L1:    lw $ra,20($sp)
                lw $fp,16($sp)
                addu $sp,$sp,32
                #-----------------------#
                # (6),(7),(8),(9)
                #-----------------------#
                j $ra
                #-----------------------#