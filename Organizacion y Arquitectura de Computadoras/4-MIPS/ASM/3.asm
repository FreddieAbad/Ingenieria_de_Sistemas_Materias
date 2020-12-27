		.data
n: 		.word    0x2
m:		.word    0x3
r:		.space  4

		.text
		.globl   main
main:
		la	$t5, n	 
		lw	$t0, 0($t5)	 
		la	$t5, m	 
		lw	$t1, 0($t5)	 
		addu	$t2, $t0, $t1	 
		la	$t5, r		
		sw	$t2, 0($t5)

		li	$v0, 10
		syscall
