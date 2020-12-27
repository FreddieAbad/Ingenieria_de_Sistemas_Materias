.data
    prmpt: .asciiz "Ingrese un Entero Positivo: "
    nl: 	.asciiz "\n"
            .align 2
    name:	.asciiz "\t\tPractica 9\nFactorial Iterativo\n\n"
            .align 2
    lomsg:	.asciiz "! es :"
            .align 2
    space:	.asciiz	"   "
            .align 2
.text
            .globl 	main

main: 	
        #li     $v0,4
        #la     $a0, prmpt
        #syscall
        #li     $v0,5
        #syscall
        move    $t0,$v0
        li		$a3,9			
		li 		$t0,1
		la 		$a0,name		#las llamadas al sistema usan a0 para argumento, y v0 para que el valor devuelto pase al sistema
		li 		$v0,4
		syscall
		move	$a0,$a3
		li		$v0,1
		syscall
		ble		$a3,1,print
loop: 	mult	$t0,$a3 		
		mflo	$t0
		mfhi	$t2

		mult	$t1,$a3
		mflo	$t3
		addiu	$a3,-1 			
		bge		$a3,2,loop
		
print:  
		la 		$a0,lomsg
		li 		$v0,4
		syscall
		move 	$a0,$t0
		li 		$v0,1
		syscall

Exit: 	li 		$v0,10
		syscall
