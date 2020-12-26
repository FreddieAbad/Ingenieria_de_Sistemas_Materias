from Nodo import *
import random
import string
import random
import itertools

def randomNumGen(low, high):
    while True:
        yield random.randrange(low, high)

def randomWordGen(size=6, chars=string.ascii_uppercase + string.digits):
    return ''.join(random.choice(chars) for x in range(size))

def grafoAleatorio(size):
    gen = randomNumGen(0, size)
    nodoI = list(itertools.islice(gen, size))
    grafo = [Nodo(str(nodoI[x]),randomWordGen(),nodoI[x]) for x in range(1,size)]
    raiz=grafo[random.randint(1,3)]
    p=[]
    for nodo in grafo:
        for i in range(random.randint(1,3)):
            ran = random.choice(grafo)
            if ran != nodo and ran not in nodo.hijos and ran != raiz:
                nodo.agregarHijo(ran)
                nodo.agregarAristas(ran.idNodo,nodo.idNodo,random.randint(1,size))
                ran.agregarPadre(nodo)
            ran = random.choice(grafo)
            if ran != nodo and nodo != raiz and nodo in ran.hijos:
                nodo.agregarPadre(ran)
        p.append(nodo.depth)
    profundidad=max(p)
    return [profundidad,grafo]

#p,grafo=grafoAleatorio(123)
    
"""
Algoritmo Busqueda Amplitud BFS
""" 

def bfs(grafo, inicio, meta):
    cola = [(inicio, [inicio])]
    visitado=set()
    while cola:
        vertice, ruta = cola.pop(0)
        visitado.add(vertice)
        for nodo in grafo[int(vertice)-1].hijos:
            if nodo.idNodo == meta:
                yield ruta + [nodo]
            else:
                if nodo.idNodo not in visitado:
                    visitado.add(nodo.idNodo)
                    cola.append((nodo.idNodo, ruta + [nodo.idNodo]))
                   
def caminoCortoBFS(grafo, inicio, meta):
    try:
        return next(bfs(grafo, inicio, meta))
    except StopIteration:
        return None
"""
    Algoritmo busqueda DFS
""" 

"""
    Algoritmo Busqueda Profundidad DFS
"""          
def dfs(grafo, inicio, meta):
    cola = [(inicio, [inicio])]
    visitado=set()
    while cola:
        vertice, ruta = cola.pop()
        visitado.add(vertice)
        for nodo in grafo[int(vertice)-1].hijos:# - set(ruta)
            
            if nodo.idNodo == meta:
                yield ruta + [nodo]
            else:
                if nodo.idNodo not in visitado:
                    visitado.add(nodo.idNodo)
                    cola.append((nodo.idNodo, ruta + [nodo.idNodo]))

def caminoCortoDFS(grafo, inicio, meta):
    try:
        return next(dfs(grafo, inicio, meta))
    except StopIteration:
        return None
        
"""
    Algoritmo busqueda Profundidad Iterativa IDS 
    DLS: Profundidad Limitada
    IDDFS: Profunda Búsqueda Profundizante Iterativa 
"""        

def DLS(grafo,inicio,meta,maxProfundidad): 
    cola = [(inicio, [inicio])]
    visitado=set()
    if inicio == meta : 
        return True
    if maxProfundidad <= 0 : 
        return False
    while cola:
        vertice, ruta = cola.pop()
        visitado.add(vertice)
        for nodo in grafo[int(inicio)-1].hijos: 
            if(DLS(grafo,nodo.idNodo,meta,maxProfundidad-1)): 
                yield ruta + [nodo]
                return True
        if nodo.idNodo not in visitado:
            visitado.add(nodo.idNodo)
            cola.append((nodo.idNodo, ruta + [nodo.idNodo]))
        return False

def caminoCortoIDS(grafo, inicio, meta, maxProfundidad):
    try:
        return next(DLS(grafo, inicio, meta,maxProfundidad))
    except StopIteration:
        return None  

def IDDFS(grafo,src, target, maxProfundidad): 
    for i in range(maxProfundidad): 
        if (DLS(grafo,src, target, i)): 
            return True
    return False

"""
    Algoritmo Coste Uniforme - UCS Uniform Cost Search
"""    
def UCS(nodoRaiz, nodosIF):
    #nodosIF =[str(Nodo Inicio),str(Nodo Fin)]
    cola = {}
    visitados = []
    encontrados = []
    cola[nodoRaiz] = 0
    while (len(cola) and (len(encontrados) != len(nodosIF))):
        nodoActual = max(cola, key=cola.get)  # 'min' or 'max'  
        visitados.append(nodoActual)
        for nodoHijo in nodoActual.hijos:
            if nodoHijo not in visitados:
                cola[nodoHijo] = nodoActual.pesoHijos[nodoHijo] + cola[nodoActual]
        if (nodoActual.idNodo in nodosIF): 
            encontrados.append(nodoActual.idNodo) 
        del cola[nodoActual]
    return (visitados, encontrados)    
    
def HC(nodoRaiz):
    cola = {}
    visitado = []
    metaFin = []        
    cola[nodoRaiz] = nodoRaiz.peso    
    while len(cola):
        nodoActual = min(cola, key=cola.get)  # 'min' or 'max' 
        cola = {}
        visitado.append(nodoActual)
        for nodoHijo in nodoActual.hijos:
            if nodoHijo not in visitado:
                cola[nodoHijo] = nodoHijo.peso
        if (nodoActual.peso == 0):
            metaFin.append(nodoActual.nombre)         
    return (visitado, metaFin)    
    
def PrimeroMejor(nodoRaiz):
    cola = {}
    visitado = []
    nodosEncontrados = []
    cola[nodoRaiz] = nodoRaiz.peso
    while len(cola):
        nodoActual = min(cola, key=cola.get)  # 'min' or 'max' 
        #cola = {}
        visitado.append(nodoActual)
        for nodoHijo in nodoActual.hijos:
            if nodoHijo not in visitado:
                cola[nodoHijo] = nodoHijo.peso
        if (nodoActual.peso == 0):
            nodosEncontrados.append(nodoActual.idNodo)
        del cola[nodoActual]
    return (visitado, nodosEncontrados)    
    
def AE(nodoRaiz):
    cola = {}
    visitado = []
    nodosEncontrados = []       
    cola[nodoRaiz] = nodoRaiz.peso
    while len(cola):
        nodoActual = min(cola, key=cola.get)  # 'min' or 'max' 
        visitado.append(nodoActual)
        for nodoHijo in nodoActual.hijos:
            if nodoHijo not in visitado:
                aux=str(nodoHijo.idNodo) + "-"+ str(nodoActual.idNodo)
                #print(nodoHijo.idNodo,nodoActual.idNodo,nodoActual.edges[aux])
                #cola[nodoHijo] = nodoHijo.peso + nodoActual.pesoHijos[nodoHijo] +nodoActual.edges[aux]   Heuristica con Peso y Arista
                cola[nodoHijo] = nodoHijo.peso + nodoActual.pesoHijos[nodoHijo] 
        if (nodoActual.peso == 0):
            nodosEncontrados.append(nodoActual.idNodo)
        del cola[nodoActual]
    return (visitado, nodosEncontrados)        
    
def Avara(nodoRaiz,nodosB):
    cola = {}
    visitado = []
    nodosEncontrados = []
    cola[nodoRaiz] = nodoRaiz.peso
    while len(cola):
        nodoActual = min(cola, key=cola.get)  # 'min' or 'max' 
        visitado.append(nodoActual)
        for nodoHijo in nodoActual.hijos:
            if nodoHijo not in visitado:
                # cola[nodoHijo] = nodoHijo.peso + nodoActual.pesos[nodoHijo] + cola[nodoActual]
                cola[nodoHijo] = nodoHijo.peso
        if (nodoActual.peso == 0):
            nodosEncontrados.append(nodoActual.idNodo)
        del cola[nodoActual]
    return (visitado, nodosEncontrados)       

    
    
    
    
""" 
Exito AE
prof,grafo=grafoAleatorio(124)
inicio = grafo[2].idNodo
meta = grafo[5].idNodo
path,encontrados=AE(grafo[0]) 
print(f"\nCamino entre Nodos:\n {path}")
print(f"\nNodos Encontrados:\n {encontrados}")    
   
"""   
 

 

"""
Prueba Exitosa de UCS

prof,grafo=grafoAleatorio(1234)
inicio = grafo[2].idNodo
meta = grafo[5].idNodo
#UCS(n1, ["N6", "N2"]) Ingreso de funcion ejemplo
path,encontrados=UCS(grafo[0], [inicio,meta])
print(f"\nCamino entre Nodos:\n {path}")
print(f"\nNodos Encontrados:\n {encontrados}")
"""




"""
Prueba Exitosa de HC
    
prof,grafo=grafoAleatorio(1234)
inicio = grafo[2].idNodo
meta = grafo[5].idNodo
path,encontrados=HC(grafo[0])
print(f"\nCamino entre Nodos:\n {path}")
print(f"\nNodos Encontrados:\n {encontrados}")
"""


"""
Prueba Exitosa de PrimeroMejor
   
prof,grafo=grafoAleatorio(124)
inicio = grafo[2].idNodo
meta = grafo[5].idNodo
path,encontrados=PrimeroMejor(grafo[0])
print(f"\nCamino entre Nodos:\n {path}")
print(f"\nNodos Encontrados:\n {encontrados}")
"""    

    
    
"""
Prueba Exitosa de A *

prof,grafo=grafoAleatorio(124)
inicio = grafo[2].idNodo
meta = grafo[5].idNodo
path,encontrados=AE(grafo[0])
print(f"\nCamino entre Nodos:\n {path}")
print(f"\nNodos Encontrados:\n {encontrados}")
"""



















def IDS(nodoRaiz, nodosMeta, maxNivel=3):
    visitados = []
    encontrados = []
    nodoActual = None
    nivelActual = 0
    #isDone = False
    visitados.append(nodoRaiz)
    if (nodoRaiz.idNodo in nodosMeta):
        encontrados.append(nodoRaiz.idNodo)
    if len(encontrados) == len(nodosMeta):
        return (visitados, encontrados)
    nivelActual += 1
    while nivelActual <= maxNivel:        
        queue = []
        encontrados = []            
        for nodo in visitados:
            for nodoHijo in nodo.hijos:
                if nodoHijo not in visitados:
                        queue.append(nodoHijo)
        temp_a = queue[:]
        queue = visitados[:]
        queue.extend(temp_a)
        """
        print(f"\nSearching... {nodosMeta} in {nodoRaiz.idNodo}")
        print(f"Level {nivelActual}")
        print(f"Queue \t\t Current")
        print(f"{list(map(lambda nodo: nodo.idNodo, queue))}") 
        """    
        iVisited = []
        for nodo in queue:
            if nodo not in visitados:
                visitados.append(nodo)
            iVisited.append(nodo)
            queue = [item for item in queue if item not in iVisited]
            if (nodo.idNodo in nodosMeta):
                encontrados.append(nodo.idNodo)
        nivelActual += 1
    return (visitados, encontrados)
"""   
prof,grafo=grafoAleatorio(124)
inicio = grafo[2].idNodo
meta = grafo[5].idNodo
path,encontrados=IDS(grafo[0], [inicio,meta], 2) 
print(f"\nCamino entre Nodos:\n {path}")
print(f"\nNodos Encontrados:\n {encontrados}")

"""