# PRAC_3A.S
	    .data
string: .asciiz "Esto es una cadena\n"
item: 	.word 99
array: 	.word 11,22,33,44,55,66,77,88,99
#-----------------------#
	.text
	.globl main
main:
	#-----------------------#(1)
	la $a0,string			#Se carga en $a0 la cadena
	li $v0,4 			#Imprime una cadena en la consola
	syscall				
	#-----------------------#(2)
	lw $a0,item			#Se carga en $a0 lo que este en item
	li $v0,1			#Imprime un entero en la consola (lo que contiene $a0)
	syscall
	#-----------------------#(3)
	li $v0,5			#Sirve para leer un entero por teclado 
	syscall
	#-----------------------#(4)
	li $v0,8			#Leer una cadena desde teclado
	la $a0,string			#Asigna lo que se ingresa por teclado a la variable string('Esto es una cadena\n')
	li $a1,9			#Limita el tama�o del buffer
	syscall
	li $v0,4			#Imprime la cadena
	syscall
	#-----------------------#(5)
	li $t0,3			#Cargar en el temporal $t0 en valor 3
	li $t1,4			#Cargar en el temporal $t1 en valor 4
	mul $t2,$t1,$t0			#Multiplicar y guardar en temporal $t2 la multiplicaci�n de $t0 * $t1
	lw $a0,array($t2)		#Cargar en el registro $a0 lo que contenga el array en la posici�n %t2
	li $v0,1			#Imprime lo que esta en el registro $a0
	syscall
	#-----------------------#(6)
	li $v0,10			#Detiene el programa
	syscall