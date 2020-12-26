import random
class Nodo():
    #def __init__(self, idNodo):
    def __init__(self, idNodo,nombre,peso):
        self.idNodo = idNodo
        self.nombre= nombre
        self.padres = set()
        self.hijos = set()
        self.pesoHijos={}
        self.peso=peso
        self.depth=1
        self.edges = {}
        self.weights = set()

    def agregarPadre(self, nodo):
        self.padres.add(nodo)

    def agregarHijo(self, nodo):
        self.depth=self.depth+1
        self.hijos.add(nodo)
        a=random.randint(1,100)
        self.pesoHijos.update({nodo:a})#4

    def agregarAristas(self,u,v,c):
        idA= str(u) + "-"+ str(v)
        dic2={idA:c}
        self.edges.update(dic2)
        #self.edges.add(nodo)
    
    def calcular_costo(self):
        return self.peso

    def conseguirDistanciaArista(self):        
        return self.edges
        
    def vecinos(self, nodoo):
        return self.edges[nodo]

    def get_cost(self, from_node, to_node):
        return self.weights[(from_node + to_node)]
        
    def esRaiz(self):
        return True if self.padres else False

    def __repr__(self):
        return str(self.idNodo) #'\n\n\tID: %s \n\tNombre: %s \n\tPeso: %s \n\tAristas: %s' % (self.idNodo, self.nombre,self.peso,self.edges)
        #return '%s' % (self.edges)
        
    def __int__(self):
        return int(self.idNodo)
        