.data
str1:   .asciiz String: "
strTest:.space 20
str2:   .asciiz "Length: "
    .text
    .globl main

main:  
    addiu   $sp, $sp, -4            # save space
    sw      $ra, 0($sp)             # push $ra
    la      $a0, str1               # print(str1)
    li      $v0, 4
    syscall
    li      $a1, 20                 # read strTes
    la      $a0, strTest
    li      $v0, 8
    syscall
    jal     strlen                  # call strlen
    move    $t0, $v0                # save result to $t0
    la      $a0, str2               # print str2
    li      $v0, 4
    syscall
    move    $a0, $t0                # print result
    li      $v0, 1
    syscall
    lw      $ra, 0($sp)             # restore $ra
    addiu   $sp, $sp, 4             # restore $sp
    jr      $ra
strlen:
    li      $v0, 0                  # len = 0

while:  lb      $t0, ($a0)              # get char
    beqz    $t0, wh_end             # if(char == '\0') --> end while
    addi    $v0, $v0, 1             # len++
    addiu   $a0, $a0, 1             # *s++
    j       while
wh_end:
    jr      $ra