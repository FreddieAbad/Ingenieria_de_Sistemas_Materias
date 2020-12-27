	.text
	.globl   main
main:
	li   	$v0,  5		
	syscall	
	move  	$t0, $v0
	
	li   	$v0,  5		
	syscall	
	move  	$t1, $v0
		
	seq 	$t2, $t0, $t1
	
	beq  	$t2, 1, printEq	
	beq  	$t2, $0, printNe
	
printEq:
	la  	$a0,  strEq
	j  	print

printNe:
	la  	$a0, strNe
	j  	print

print:
	li   	$v0,  4
	syscall	

	li  	$v0, 10
	syscall

	.data
strEq:	.asciiz "Es igual"
strNe:	.asciiz "No es igual"