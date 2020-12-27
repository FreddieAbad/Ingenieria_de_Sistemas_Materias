		.data
n: 		.word    0x2
m:		.word    0x3
r:		.space  4

		.text
		.globl   main
main:
		lw	$t0, n	  
		lw	$t1, m	  
		addu	$t2, $t0, $t1	  
		sw	$t2, r

		li	$v0, 10
		syscall
