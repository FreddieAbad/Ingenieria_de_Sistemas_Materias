        .MODEL SMALL
        .CODE
        PROGRAMA:

        MOV AX,1382H
        MOV DS,AX
        MOV AX,0020H
        MOV CX,AX
        MOV AH,3CH
        MOV DX,0300H
        INT 21H
        MOV BX,AX
        MOV AH,40H
        MOV CX,0007H
        MOV DX,0200H
        INT 21H
            
        MOV AH,4CH
        INT 21H
        .STACK
        END PROGRAMA
        
