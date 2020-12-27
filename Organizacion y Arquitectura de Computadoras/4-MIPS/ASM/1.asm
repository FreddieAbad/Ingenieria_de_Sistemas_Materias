	.text
	.globl   main
main:
	ori	$t0, $0, 0x2	
	ori	$t1, $0, 0x3
	addu	$t2, $t0, $t1

	li	$v0, 10
	syscall
	

