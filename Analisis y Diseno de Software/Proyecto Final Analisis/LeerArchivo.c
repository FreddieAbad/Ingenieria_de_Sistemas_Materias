void leerArchivo() {
    /* Archivos de Texto*/
    FILE *multiplicando;
    FILE *multiplicador;
    int multiplicandoLeido, multiplicadorLeido;

    multiplicando = fopen("texto.txt", "r");

    while ( !feof(multiplicando) )
    {
        /* Almacenar cada entero */
        fscanf (multiplicando, "%d", &multiplicandoLeido); // Leer el multiplicando
        fgetc(multiplicando); // Leer el espacio
	}

    fclose(multiplicando);
}
