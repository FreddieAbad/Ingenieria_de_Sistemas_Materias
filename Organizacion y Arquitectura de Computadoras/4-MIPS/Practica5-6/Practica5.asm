.data 
array: .word 2,4,0,5,1,8
salto: .asciiz "\n"
.text
.globl main
main:
	# Direccionamiento por registro
	la $t0,array
	lw $t0,0($t0)
	li $v0, 1 #Print
	add $a0 , $zero , $t0
	syscall 
	
	li $v0 , 4
	la $a0 , salto
	syscall 
	
	#Direccionamiento por valor
	lw $t0,268500992
	li $v0, 1 #Print
	add $a0 , $zero , $t0
	syscall
	
	li $v0 , 4
	la $a0 , salto
	syscall
	
	#Direccionamiento por valor (registro)
	la $t0,array
	lw $t0,8($t0)
	li $v0, 1 #Print
	add $a0 , $zero , $t0
	syscall
	
	li $v0 , 4
	la $a0 , salto
	syscall
	
	#Direccionamiento por identificador
	lw $t0,array
	li $v0, 1 #Print
	add $a0 , $zero , $t0
	syscall
	
	li $v0 , 4
	la $a0 , salto
	syscall
	
	#Direccionamiento +/- valor
	lw $t0,array+8
	li $v0, 1 #Print
	add $a0 , $zero , $t0
	syscall
	
	li $v0 , 4
	la $a0 , salto
	syscall
	
	#Direccionamiento por identificador (registro)
	la $t0,20
	lw $t0,array($t0)
	li $v0, 1 #Mando a Imprimir
	add $a0 , $zero , $t0
	syscall
	
	li $v0 , 4
	la $a0 , salto
	syscall
	
	#Direccionamiento por identificador +/- valor
	#registro
	la $t0,4
	lw $t0,array+12($t0)
	li $v0, 1 #Mando a Imprimir
	add $a0 , $zero , $t0
	syscall