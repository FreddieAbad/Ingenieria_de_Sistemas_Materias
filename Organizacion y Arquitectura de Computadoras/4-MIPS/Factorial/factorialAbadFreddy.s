##Programa SPIM Factorial
##Nombre: Freddy L. Abad L.
##El siguiente programa cumple con las condiciones del factorial, sin embargo se cumple de 1 a 31, en el numero 32 hay desbordamiento, y los valores se muestran
##con signo negativo
.data
    mensajeIngreso:  .asciiz "\n\t\tTrabajo 2 SPIM\n\nEstudiante: Freddy L. Abad L.\n\nIngrese un numero: "
    mensajeResulto:  .ascii "\nFactorial: "
    numero:      .word   0
    numeroFactorial:      .word   0 

.text
    .globl main
    main: 
        #Lectura de datos
        li  $v0, 4
        la  $a0, mensajeIngreso
        syscall

        li  $v0, 5
        syscall

        sw  $v0, numero

        #Llamada a funcion factorial
        lw  $a0, numero
        jal funcionFactorial
        sw  $v0, numeroFactorial
        #Muestra de resulados
        li  $v0, 4
        la  $a0, mensajeResulto
        #Llamada a sistema
        syscall
        
        li  $v0, 1
        lw  $a0, numeroFactorial
        syscall

        #Fin del Programa
        li  $v0, 10
        syscall

#---------------------------------------------------------------------------------------------------------------------
#-----------------------------------------Funcion para encontrar un factorial-----------------------------------------
#---------------------------------------------------------------------------------------------------------------------

.globl funcionFactorial
funcionFactorial: 
                subu    $sp, $sp, 8
                sw      $ra, ($sp)
                sw      $s0, 4($sp)

                #Caso Base 
                li  $v0, 1
                beq $a0, 0, sumaValoresFactorial

                #Llamada a funcionFactorial con un numero menor (numero - 1)
                move    $s0, $a0
                sub     $a0, $a0, 1
                jal funcionFactorial
                
                #Multiplicacion de los valores, esencia de la funcionFactorial 
                mul     $v0, $s0, $v0
                
                sumaValoresFactorial:
                                lw  $ra, ($sp)
                                lw  $s0, 4($sp)
                                addu    $sp, $sp, 8
                                jr  $ra 
