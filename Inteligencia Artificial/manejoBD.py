import psycopg2, psycopg2.extras
import pandas as pd
from sqlalchemy import create_engine
from Nodo import *
import random    
import psycopg2, psycopg2.extras
import sqlalchemy as sqlalchemy
from Busqueda import *
import numpy as np

def conexionBD():    
    try: 
        conn = psycopg2.connect(database='grafos',user='postgres',password='admin', host='localhost')
    except:
        print("Conexion fallida")
    cur = conn.cursor()
    data=cur.execute("""SELECT * FROM "Nodos" """)
    print(data)
    return data
    
engine = create_engine('postgresql://postgres:admin@localhost:5432/grafos') 

def lecturaArchivos(bandera,nombreArchivo='Ecuador_Distancias.xls',nombreAristas='aristas.txt', nombreNodos='nodos.txt'):
    if bandera==1:    
        nodos  = pd.read_csv(nombreNodos, sep=",", header=None, encoding='latin-1')
        aristas = pd.read_csv(nombreAristas , sep=",", header=None, encoding='latin-1')
        return [aristas,nodos]
    else:
        dfs = pd.read_excel(nombreArchivo, sheet_name="CUADRO DE DISTANCIAS")
        return dfs

    
def insertarTabla(bandera,engine,Nodos,Aristas,Distancias):
    try:
        conn = psycopg2.connect(database = "grafos", user = "postgres", password = "admin", host = "localhost", port = "5432")
    except:
        print("Conexion Fallida") 
    
    if bandera==1:
        cur = conn.cursor()
        Nodos.to_sql('Nodos', engine,if_exists='replace')
        Aristas.to_sql('Aristas',engine,if_exists='replace', 
                        dtype={'id': sqlalchemy.types.BIGINT, 
                        'ciudad':  sqlalchemy.types.VARCHAR(length=255),
                        'idHijo': sqlalchemy.types.BIGINT,
                        'distancia': sqlalchemy.types.BIGINT})
        conn.commit() 
        conn.close()
        cur.close()
    else:
        cur = conn.cursor()
        ##Tratamiento Pandas para que los datos sean un solo tipo de dato
        d=Distancias.iloc[:,2:].applymap(np.float)#Distancias.columns[2:]
        d=d.applymap(lambda x: round(x,3))
        result = pd.concat([Distancias.iloc[:,0:2], d], axis=1)      
        result.to_sql('Distancias', engine,if_exists='replace')
        conn.commit() 
        conn.close()
        cur.close()
        #print(result)
        return result

def leerDatos(engine):
    dfValores = pd.read_sql_query("""SELECT * FROM "Nodos" """,con=engine)
    dfRelaciones = pd.read_sql_query("""SELECT * FROM "Aristas" """,con=engine)
    return [dfValores,dfRelaciones]

class MyClass:

    def __init__(self, my_dataframe):
        self.my_dataframe = my_dataframe

    def __str__(self):
        return self.my_dataframe.to_string()

    def toGraph(self):
        g=Graph()
        g.tnode(self.my_dataframe.size)
        for i in range(self.my_dataframe.size):
            #print(self.my_dataframe.loc[i][0],'-',self.my_dataframe.loc[i][1],'-',self.my_dataframe.loc[i][2],'-',self.my_dataframe.loc[i][3])
            #print(int(float(" ".join(self.my_dataframe.loc[i][0]))), int(float(" ".join(self.my_dataframe.loc[i][2]))),int(float(" ".join(self.my_dataframe.loc[i][3]))))
            #print([self.my_dataframe.loc[i][3].replace(' ','').astype(float) for col in self.my_dataframe], axis=1)
            #print((self.my_dataframe.loc[i][3].split()))
            print(int(float(self.my_dataframe.loc[i][0])), int(float(self.my_dataframe.loc[i][2])),int(float(self.my_dataframe.loc[i][3])))

def DataframeToGraph(result):
    nodoI=list(result['No.'])                           #nodo con lista de nodos inicio - identificados de la siguiente lista nodoI
    nodoN=list(result['CIUDAD'])                        #nodo con nombres de ciudades
    nodoP=random.sample(range(1, 101), len(nodoI))      #nodo de pesos    
    nodoF=list(result)                                  #nodo con nodos vecinos
    nodoF=nodoF[2:]
    grafoIngreso=[]           
    """
    REVISAR
    for j in range(len(nodoF)):
        for i in range(len(result)):
            grafoIngreso.append(Nodo(nodoI[j],nodoN[j],random.randint(1,100)))
            #g.addEdge(nodoI[j],nodoF[j],result[nodoF[j]].values[i])
    """
    for x in range(len(nodoF)):
        grafoIngreso.append(Nodo(nodoI[x],nodoN[x],nodoP[x]))
    raiz=grafoIngreso[random.randint(1,3)]
    for nodo in grafoIngreso:
        for i in range(random.randint(1,3)):
            ran = random.choice(grafoIngreso)
            if ran != nodo and ran not in nodo.hijos and ran != raiz:
                nodo.agregarHijo(ran)
                nodo.agregarAristas(ran.idNodo,nodo.idNodo,result.iloc[nodoI[i]][nodoF[i]])
                ran.agregarPadre(nodo)
            ran = random.choice(grafoIngreso)
            if ran != nodo and nodo != raiz and nodo in ran.hijos:
                nodo.agregarPadre(ran)
    return [13,grafoIngreso]
    """  
    REVISAR
    for j in range(len(nodoF)):
        for i in range(len(result)):
            
        
            g.addEdge(nodoI[j],nodoF[j],result[nodoF[j]].values[i])
    """    
distancias=lecturaArchivos(2)
resultado=insertarTabla(2,engine,distancias,distancias,distancias)
    
    
    
    
    
    
    
    
    
    
    
"""   
def ingresoGrafo(result):
    REVISAR
    grafo = [Nodo(str(x+1)) for x in range(10)]
    raiz=grafo[random.randint(1,3)]
	for nodo in grafo:
		for i in range(random.randint(1,3)):
			ran = random.choice(grafo)
			if ran != nodo and ran not in nodo.hijos and ran != raiz:
				nodo.agregarHijo(ran)
				ran.agregarPadre(nodo)
			ran = random.choice(grafo)
			if ran != nodo and nodo != raiz and nodo in ran.hijos:
				nodo.agregarPadre(ran)
	return grafo


    
    grafo = [Nodo(str(x+1)) for x in range(10)]
    raiz=grafo[random.randint(1,3)]
	for nodo in grafo:
		for i in range(random.randint(1,3)):
			ran = random.choice(grafo)
			if ran != nodo and ran not in nodo.hijos and ran != raiz:
				nodo.agregarHijo(ran)
				ran.agregarPadre(nodo)
			ran = random.choice(grafo)
			if ran != nodo and nodo != raiz and nodo in ran.hijos:
				nodo.agregarPadre(ran)
	return grafo
"""



















"""
def crearGrafo(MyClass):
    g = Graph()
    g.tnode(10)

    g.addEdge(0, 1, 1); g.addEdge(0, 2, 1); g.addEdge(1, 3, 3);
    g.addEdge(2, 5, 2); g.addEdge(3, 6, 4); g.addEdge(3, 5, 2);
    g.addEdge(4, 6, 1); g.addEdge(4, 7, 5); g.addEdge(5, 4, 4);
    g.addEdge(6, 7, 1); g.addEdge(5, 0, 3); g.addEdge(5, 8, 1);
    g.addEdge(8, 4, 1); g.addEdge(8, 9, 3); g.addEdge(9, 7, 1);

    g.UCS(0,7)
    print(g)
    g.all_paths()

    g.optimal_path()
"""