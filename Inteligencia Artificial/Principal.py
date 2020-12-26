"""
import psycopg2, psycopg2.extras
import pandas as pd
from sqlalchemy import create_engine
from Nodo import *
import random
"""
from manejoBD import *
from Nodo import *
from Busqueda import *
import time
import numpy as np
#Opciones Granfo Random o subir desde Archiv xls
def generacionGrafo():
    print("""
        1. Grafo Randomico
        2. Ingresar/Almacenar BD desde archivo
        3. Menu
        """)
    opc=int(input("\t>>"))
    if opc==1:
        size=int(input("\tNumero de Nodos a Generar:"))
        while (size<3):
            generacionGrafo()
        grafo=grafoAleatorio(size)
        return grafo
    elif opc==2:
        file=input("\tNombre Archivo>>")
        distancias=lecturaArchivos(2)
        engine = create_engine('postgresql://postgres:admin@localhost:5432/grafos') 
        resultado=insertarTabla(2,engine,distancias,distancias,distancias)
        grafoDArchivo=DataframeToGraph(resultado) 
        return grafoDArchivo
    else: 
        main()
def generacionGrafoComparativa():
    size=int(input("\tNumero de Nodos a Generar:"))
    while (size<3):
        generacionGrafoComparativa()
    grafo=grafoAleatorio(size)
    #print(grafo)
    #   grafo
    
    #file=input("\tNombre Archivo>>")
    distancias=lecturaArchivos(2)
    engine = create_engine('postgresql://postgres:admin@localhost:5432/grafos') 
    resultado=insertarTabla(2,engine,distancias,distancias,distancias)
    grafoDArchivo=DataframeToGraph(resultado) 
    lista=[grafo,grafoDArchivo]
    return lista
            
def main():
    print("""
        Metodos de Busqueda IA
        1. Metodos de Busqueda
        2. Comparativa Algoritmos
        3. Salir
    """)
    opc=int(input("\t>>"))
    opciones(opc)

def imprimirLista(lista):
    aux=" "
    for i in range(len(lista)):
        aux=aux+"-"+str(lista[i])
    print(aux)    
def metBusqueda(opc):
    if opc==1:
        p,grafo=generacionGrafo()
        inicio = grafo[2].idNodo
        meta = grafo[5].idNodo
        print("\n\t\tMetodo de Busqueda BFS")
        print("\tElementos a Buscar: \nNodo Inicio(id-Nombre):", grafo[2].nombre, grafo[2].idNodo, "\tNodo Meta(id-Nombre):", grafo[5].nombre,grafo[5].idNodo)
        tinicio = time.time()
        print("\tRutas para la Busqueda: \n\n", list(bfs(grafo, inicio, meta)))
        tfinal  = time.time()
        print("\tRuta mas Corta de Busqueda:\n\n", caminoCortoBFS(grafo, inicio, meta))
        camCorto=caminoCortoBFS(grafo, inicio, meta)
        #imprimirLista(camCorto)
        print("Tiempo Calculo: %.20f "% abs(tinicio-tfinal))
        main()
        
    elif opc==2:
        p,grafo=generacionGrafo()
        inicio = grafo[2].idNodo
        meta = grafo[5].idNodo
        print("Metodo de Busqueda DFS")
        print("\tElementos a Buscar: \nNodo Inicio(id-Nombre):", grafo[2].nombre, grafo[2].idNodo, "\tNodo Meta(id-Nombre):", grafo[5].nombre,grafo[5].idNodo)
        tinicio = time.time()
        print("Rutas de Busqueda:\n\t", list(dfs(grafo, inicio, meta)))
        tfin = time.time()
        print("Ruta de Busqueda mas Corta:\n\t", caminoCortoDFS(grafo, inicio, meta))
        print("Tiempo Calculo: %.20f "% abs(tinicio-tfin))
        main()
        
    elif opc==3:
        tinicio = time.time()
        p,grafo=generacionGrafo()
        inicio = grafo[2].idNodo
        meta = grafo[5].idNodo
        print("\tElementos a Buscar: \nNodo Inicio(id-Nombre):", grafo[2].nombre, grafo[2].idNodo, "\tNodo Meta(id-Nombre):", grafo[5].nombre,grafo[5].idNodo)
        print("Existe Camino(T/F): ",IDDFS(grafo,inicio, meta, p))
        tfin = time.time()
        print("Ruta de Busqueda mas Corta:\n\t", caminoCortoIDS(grafo, inicio, meta,p))
        print("Tiempo Calculo: %.20f "% abs(tinicio-tfin))
        
        main()
        
    elif opc==4:
        tinicio=time.time()
        p,grafo=generacionGrafo()
        inicio = grafo[2].idNodo
        meta = grafo[5].idNodo
        path,encontrados=UCS(grafo[0], [inicio,meta])
        print("\tElementos a Buscar: \nNodo Inicio(id-Nombre):", grafo[2].nombre, grafo[2].idNodo, "\tNodo Meta(id-Nombre):", grafo[5].nombre,grafo[5].idNodo)
        tfinal=time.time()
        print(f"\nCamino entre Nodos:\n {path}")
        print(f"\nNodos Encontrados:\n {encontrados}")
        print("Tiempo Calculo: %.20f "% abs(tinicio-tfinal))
        main()
        
    elif opc==5:
        grafo=generacionGrafo()
        main()
    elif opc==6:
        p,grafo=generacionGrafo()
        inicio = grafo[2].idNodo
        meta = grafo[5].idNodo
        tinicio = time.time()
        camino,encontrados=HC(grafo[0])
        tfinal=time.time()
        print(f"\nCamino entre Nodos:\n {camino}")
        print(f"\nNodos Encontrados:\n {encontrados}")
        print("Tiempo Calculo: %.20f "% abs(tinicio-tfinal))
        main()
    elif opc==7:
        p,grafo=generacionGrafo()
        inicio = grafo[2].idNodo
        meta = grafo[5].idNodo
        tinicio = time.time()
        path,encontrados=PrimeroMejor(grafo[0])
        print(f"\nCamino entre Nodos:\n {path}")
        tfinal=time.time()
        print(f"\nNodos Encontrados:\n {encontrados}")
        print("Tiempo Calculo: %.20f "% abs(tinicio-tfinal))
        main()
    elif opc==8:
        p,grafo=generacionGrafo()
        inicio = grafo[2].idNodo
        meta = grafo[5].idNodo
        tinicio = time.time()
        path,encontrados=Avara(grafo[0], [inicio,meta]) 
        print(f"\nCamino entre Nodos:\n {path}")
        tfinal=time.time()
        print(f"\nNodos Encontrados:\n {encontrados}") 
        print("Tiempo Calculo: %.20f "% abs(tinicio-tfinal))
        main()
    elif opc==9:
        p,grafo=generacionGrafo()
        inicio = grafo[2].idNodo
        meta = grafo[5].idNodo
        tinicio = time.time()
        path,encontrados=AE(grafo[0])
        print(f"\nCamino entre Nodos:\n {path}")
        tfinal=time.time()
        print(f"\nNodos Encontrados:\n {encontrados}")
        print("Tiempo Calculo: %.20f "% abs(tinicio-tfinal))
        main()
    else:
        main()

def numPromHijos(nodoRaiz):
    cola = {}
    visitado = []
    nodosEncontrados = []       
    cola[nodoRaiz] = nodoRaiz.peso
    nHijos={}
    while len(cola):
        nodoActual = min(cola, key=cola.get)  # 'min' or 'max' 
        visitado.append(nodoActual)
        id=nodoActual.idNodo
        tam=len(nodoActual.hijos)
        nHijos.update({id:tam}) 
        for nodoHijo in nodoActual.hijos:
            if nodoHijo not in visitado:
                aux=str(nodoHijo.idNodo) + "-"+ str(nodoActual.idNodo)
                cola[nodoHijo] = nodoHijo.peso + nodoActual.pesoHijos[nodoHijo] 
        if (nodoActual.peso == 0):
            nodosEncontrados.append(nodoActual.idNodo)
     
        del cola[nodoActual]
    print(nHijos)
    l=list(nHijos.values())
    nHij=np.mean(l)
    nHij=int(round(nHij))
    return nHij   
    
    
def comparativa():
    p=13
    #p,grafo=grafoAleatorio(size)
    size=1234
    p,grafo=grafoAleatorio(size)
    de=p #Profundidad
    #b=n #Numero Hijos Promedio
    
    distancias=lecturaArchivos(2)
    engine = create_engine('postgresql://postgres:admin@localhost:5432/grafos') 
    resultado=insertarTabla(2,engine,distancias,distancias,distancias)
    grafoDArchivo=DataframeToGraph(resultado) 
    
    inicio = grafo[2].idNodo
    meta = grafo[5].idNodo
    
    #BFS
    tinicio = time.time()
    list(bfs(grafo, inicio, meta))
    caminoCortoBFS(grafo, inicio, meta)
    tfinal  = time.time()
    tPromBFS=abs(tinicio-tfinal)
    #print("\tTiempo Calculo: %.20f "% abs(tinicio-tfinal))
    
   
    #print("\t\t Metodo de Busqueda DFS")
    tinicio = time.time()
    list(dfs(grafo, inicio, meta))
    caminoCortoDFS(grafo, inicio, meta)
    tfinal = time.time()
    tPromDFS=abs(tinicio-tfinal)
    #print("\tTiempo Calculo: %.20f "% abs(tinicio-tfinal))
    
    
    
    #print("\t\t Metodo Profundidad Iterativa")
    tinicio = time.time()
    IDDFS(grafo,inicio, meta, p)
    caminoCortoIDS(grafo, inicio, meta,p)
    tfinal = time.time()
    tPromIDS=abs(tinicio-tfinal)
    
    #UCS
    tinicio=time.time()
    path,encontrados=UCS(grafo[0], [inicio,meta])
    tfinal=time.time()
    tPromUCS=abs(tinicio-tfinal)

    #HC
    tinicio = time.time()
    camino,encontrados=HC(grafo[0])
    tfinal=time.time()
    tPromHC=abs(tinicio-tfinal)
    
    #PrimeroMejor
    tinicio = time.time()
    path,encontrados=PrimeroMejor(grafo[0])
    tfinal=time.time()
    tPromPM=abs(tinicio-tfinal)
    
    #Avara
    tinicio = time.time()
    path,encontrados=Avara(grafo[0], [inicio,meta]) 
    tfinal=time.time()
    tPromAv=abs(tinicio-tfinal)
    
    #A* 
    tinicio = time.time()
    path,encontrados=AE(grafo[0])
    
    tfinal=time.time()
    tPromAE=abs(tinicio-tfinal)
    d=de                                #Profundidad
    nHijos=numPromHijos(grafo[0])
    b=nHijos                            #Numero Hijos Promedio    
    print("""
        \n\t\t\tTABLA COMPARATIVA METODOS DE BUSQUEDA\n
    """)
    print("""
        MET. BUSQUEDA             Tiempo Calculo Comp.        Complejidad Esp.        Complejidad Temp.    
    """)
    print("\tMetodo BFS\t\t %.20f \t\t %.2f \t\t\t %.2f"%(tPromBFS,b^d,b^d))
    print("\tMetodo DFS\t\t %.20f \t\t %.2f \t\t\t %.2f"%(tPromDFS,b^d,b*d))
    print("\tMetodo IDS\t\t %.20f \t\t %.2f \t\t\t %.2f"%(tPromIDS,b^d,b))
    print("\tMetodo UCS\t\t %.20f \t\t %.2f \t\t\t %.2f"%(tPromUCS,b^d,b^d))
    print("\tMetodo HC\t\t %.20f \t\t %.2f \t\t\t %.2f"%(tPromHC,b^d,b^(d+1)))
    print("\tMetodo PrimeroMejor\t %.20f \t\t %.2f \t\t\t %.2f" %(tPromPM,b^d,b^(d+1)))
    print("\tMetodo AE\t\t %.20f \t\t %.2f \t\t\t %.2f"%(tPromAE,b^d,b^d))
    print("\tMetodo Avara\t\t %.20f \t\t %.2f \t\t\t %.2f"%(tPromAv,b^d,b^d))
    print("\n\n\n")
    """
    print("TABLA COMPARATIVA METODOS DE BUSQUEDA Carga Archivos")
    print("\t\t Metodo BFS")
    
    distancias=lecturaArchivos(2)
    engine = create_engine('postgresql://postgres:admin@localhost:5432/grafos') 
    resultado=insertarTabla(2,engine,distancias,distancias,distancias)
    p,grafoDArchivo=DataframeToGraph(resultado) 
    grafo=grafoDArchivo
    tinicio = time.time()
    inicio = grafo[2].idNodo
    meta = grafo[5].idNodo
    list(bfs(grafo, inicio, meta))
    camino_corto_bfs(grafo, inicio, meta)
    tfinal  = time.time()
    print("\t Tiempo Calculo: %.20f "% abs(tinicio-tfinal))
    
   
    print("\t\t Metodo de Busqueda DFS")
    tinicio = time.time()
    list(dfs(grafo, inicio, meta))
    camino_corto_dfs(grafo, inicio, meta)
    tfin = time.time()
    print("\t Tiempo Calculo: %.20f "% abs(tinicio-tfin))
    
    
    
    print("\t\t Metodo Profundidad Iterativa")
    tinicio = time.time()
    IDDFS(grafo,inicio, meta, p)
    camino_corto_IDDFS(grafo, inicio, meta,p)
    tfin = time.time()
    print("\t Tiempo Calculo: %.20f "% abs(tinicio-tfin))
    """
    main()
def opciones(opciones):
    
    if opciones==1:
        print("""
            Metodos de Busqueda IA
            1. Amplitud 
            2. Profundidad
            3. Profundidad Iterativa
            4. Costo Uniforme 
            5. Bidireccional
            6. Hill Climbing
            7. Best First
            8. Avara
            9. A*
            10. Menu
            """)
        metOpc=int(input("\t>>"))
        metBusqueda(metOpc)
    elif opciones==2:
        comparativa()
    elif opciones==3:
        raise SystemExit 
    else:
        main()
main()