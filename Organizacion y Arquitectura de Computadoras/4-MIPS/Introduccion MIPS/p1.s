		.data 						# *** SEGMENTO DE DATOS ***
valor: 	.word 8 9 10 11 			# Defino array 4 palabras (decimal).
									# valores[2] es 10 = 0xa
		.byte 0x1a,0x0b,10 			# Defino los 3 primeros bytes de la
									# siguiente palabra (hex. y dec.).
		.align 2 					# Para que el siguiente dato en mem.
									# esté alineado en palabra
		.ascii "Hola" 				# Cadena de caracteres
		.asciiz",MIPS" 				# Cadena de caracteres terminada
									# con el caracter nulo.
		.align 2 					# Las dos cadenas anteriores, junto
									# con el NULL final, ocupan 10 bytes,
									# por lo que alineo el siguiente dato
									# para que empieze en una palabra
id:		.word 1 					# Usado como índice del array "valor"
#---------------------------------------------------------------------------
		.text 							# *** SEGMENTO DE TEXTO ***
		.globl main 					# Etiqueta main visible a otros ficheros
main: 								# Rutina principal
		lw $s0,valor($zero) 			# Carga en $s0 valor[0]
										# También vale: lw $s0,valor
		lw $s4,id 						# En $s4 ponemos el índice del array
		mul $s5,$s4,4 					# En $s5 ponemos id*4
		lw $s1,valor($s5) 				# Carga en $s1 valor[1]
		add $s4,$s4,1 					# Incrementamos el índice del array
		mul $s5,$s4,4
		lw $s2,valor($s5) 				# Carga en $s2 valor[2]
		add $s4,$s4,1 					# Incrementamos el índice del array
		mul $s5,$s4,4
		lw $s3,valor($s5) 				# Carga en $s3 valor[3]
		syscall
