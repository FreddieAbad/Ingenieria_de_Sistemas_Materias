        ;CAPTURA DE TECLADO SIN ECO
        ;CREACION DE UN ARCHIVO
        ;GRABACION EN ARCHIVO DE LOS DATOS CAPTURADOS

        .MODEL SMALL
        .CODE         
        PROGRAMA:

        ;........ESCRIBE LA PALABRA CLAVE......
        MOV AH,02H
        MOV DL,43H
        INT 21H
        MOV DL,6CH
        INT 21H
        MOV DL,61H
        INT 21H
        MOV DL,76H
        INT 21H
        MOV DL,65H
        INT 21H
        MOV DL,3AH
        INT 21H
        ;.........................

        ;CAPTURA DE TECLADO E IMPRESION DEL ASTERISCO
        ;TECLAS PULSADAS SE GRABAN DESDE 1377:0200 EN ADELANTE
        ;SE CAPTURAN 7 PULSACIONES

        MOV AX,1377H
        MOV DS,AX
        MOV DL,2AH ;EL HEXADECIMAL DEL ASTERISCO ES 2A
        MOV AH,07H
        INT 21H
        MOV BX,0200H
        MOV [BX],AL
        MOV AH,02H
        INT 21H    ;SE IMPRIME EL ASTERISCO
        MOV AH,07H
        INT 21H
        MOV BX,0201H
        MOV [BX],AL
        MOV AH,02H
        INT 21H
        MOV AH,07H
        INT 21H
        MOV BX,0202H
        MOV [BX],AL
        MOV AH,02H
        INT 21H
        MOV AH,07H
        INT 21H
        MOV BX,0203H
        MOV [BX],AL
        MOV AH,02H
        INT 21H
        MOV AH,07H
        INT 21H
        MOV BX,0204H
        MOV [BX],AL
        MOV AH,02H
        INT 21H
        MOV AH,07H
        INT 21H
        MOV BX,0205H
        MOV [BX],AL
        MOV AH,02H
        INT 21H
        MOV AH,07H
        INT 21H
        MOV BX,0206H
        MOV [BX],AL
        MOV AH,02H
        INT 21H

        ;COLOCACION DEL NOMBRE EN LA POSICION 0300
        ;EL NOMBRE ES REGI1.TXT

        MOV AX,4552H
        MOV BX,0300H
        MOV [BX],AX
        MOV AX,4947H
        MOV BX,0302H
        MOV [BX],AX
        MOV AX,2E31H
        MOV BX,0304H
        MOV [BX],AX
        MOV AX,5854H
        MOV BX,0306H
        MOV [BX],AX
        MOV AX,0054H
        MOV BX,0308
        MOV [BX],AX

        ;CREACION DE ARCHIVO CON EL NOMBRE DE LA 0300
        MOV AX,0000H
        MOV CX,AX
        MOV AH,3CH
        MOV DX,0300H
        INT 21H

        ;GRABACION DE LOS DATOS DE LA POSICION 0200 HACIA EL ARCHIVO
        MOV BX,AX
        MOV AH,40H
        MOV CX,0007H  ;SE GRABARAN 7 DATOS
        MOV DX,0200H
        INT 21H

        MOV AH,4CH
        INT 21H
        .STACK
        END PROGRAMA
        
