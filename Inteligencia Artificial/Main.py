from Nodo import *
from Busqueda import *
import random

"""
def DFS(grafo, nodo):
    visitado, stack = set(), [nodo]
    while stack:
        vertice = stack.pop()
        if vertice not in visitado:
            visitado.add(vertice)
            stack.extend(grafo[vertice] - visitado)
            print(vertice)
            print(vertice)
    return visitado


def dfs_paths_recursive(graph, start, goal, path=None):
    if path is None:
        path = [start]
    if start == goal:
        yield path
    for next in graph[start] - set(path):
        yield from dfs_paths(graph, next, goal, path + [next])
    return path


def dfs_paths(graph, start, goal):
    stack = [(start, [start])]
    while stack:
        (vertex, path) = stack.pop()
        for next in graph[vertex] - set(path):
            if next == goal:
                yield path + [next]
            else:
                stack.append((next, path + [next]))



def bfs(grafo, start, meta):
    queue = [(start, [start])]
    visitado=set()
    while queue:
        vertice, ruta = queue.pop(0)
        visitado.add(vertice)
        for nodo in grafo[int(vertice)-1].hijos:
            if nodo.idNodo == meta:
                yield ruta + [nodo]
            else:
                if nodo.idNodo not in visitado:
                    visitado.add(nodo.idNodo)
                    queue.append((nodo.idNodo, ruta + [nodo.idNodo]))
"""
grafo = grafoAleatorio()
inicio = grafo[2].idNodo
meta = grafo[5].idNodo
print(grafo)
print("\nMetodo de Busqueda BFS")
print("Elementos a Buscar: \nInicio:", grafo[2].idNodo, "\tMeta:", grafo[5].idNodo)
print("Rutas para la Busqueda: ", list(bfs(grafo, inicio, meta)))
print("Ruta mas Corta de Busqueda", camino_corto_bfs(grafo, inicio, meta))

print("Metodo de Busqueda DFS")
print("Rutas de Busqueda:", list(dfs(grafo, inicio, meta)))
print("Ruta de Busqueda mas Corta:", camino_corto_dfs(grafo, inicio, meta))

#Profundidad Iterativa
maxDepth=4 #necesito saber la profundidad - si mando una cifra mayo no  hay problema
#meta=str(100) si funciona cuando no encuentra el valor
print(type(str(100)), grafo[5].idNodo)
print(">>",IDDFS(grafo,inicio, meta, maxDepth))

#print(ucs(grafo, inicio, meta))
search(grafo, inicio, meta)
#costo=CostoUniforme(grafo)    
#falta completar
#print(ucs(grafo,inicio,meta))
