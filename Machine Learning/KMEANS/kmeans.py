from __future__ import print_function

from sklearn.datasets import make_blobs
from sklearn.cluster import KMeans
from sklearn.metrics import silhouette_samples, silhouette_score

import matplotlib.pyplot as plt
import matplotlib.cm as cm
import numpy as np


import random
import csv as csv
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from matplotlib.colors import ListedColormap
from mpl_toolkits.mplot3d import Axes3D

from sklearn.metrics import f1_score
import warnings
import sklearn.exceptions
warnings.filterwarnings("ignore", category=sklearn.exceptions.UndefinedMetricWarning)

	
#------------------------------------------------------------------------------

#def escribirDatos(nombreArchivo,x,y,yDeseado):
def escribirDatos(nombreArchivo,idCanciones,artista,y,yDeseado):
    datapoints=[['idCancion','Artista','Genero','NumCluster']]

    for a,b,c,d, in zip(idCanciones,artista,y,yDeseado):
        datapoints.append([a,b,c,d])
    
    with open(nombreArchivo+".csv", "wb") as f:
        writer = csv.writer(f)
        writer.writerows(datapoints)
    


df = pd.read_csv('dataset.csv' , header=None)
idCanciones = df.iloc[1:2000, 0].values
idArtista = df.iloc[1:2000, 519].values
y = df.iloc[1:2000, 520].values
X = df.iloc[1:2000, 1:519].values



from sklearn.cluster import KMeans
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import f1_score
from sklearn.metrics import accuracy_score
import numpy as np
from sklearn.model_selection import train_test_split
#X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=42)
X_train, X_test, y_train, y_test,artista_train,artista_test,cancion_train,cancion_test = train_test_split(X, y,idArtista,idCanciones, test_size=0.33, random_state=42)

#X, y = make_blobs(n_samples=500,n_features=2,centers=4,
#                  cluster_std=1,center_box=(-10.0, 10.0),shuffle=True,random_state=1)  # For reproducibility


modeloGanador=KMeans(n_clusters=1, random_state=10)  #Creación de variable que almacenará el mejor modelo
puntaje=0
numMuestra=15
valorInicial=2
salto=1
myList = list(range(valorInicial,(numMuestra*salto)+valorInicial))          #Creando lista de numeros de clusteres
lista = filter(lambda x: x % salto == 0, myList)        #Subconjunto Pares
#neighbors = myList

distortions=[]
for i in lista:
    clusterer = KMeans(n_clusters=i, random_state=10)  #Creación de Kmeans
    cluster_labels = clusterer.fit_predict(X_train)     #Muestra las marcas de los clusters
    
    silhouette_avg = silhouette_score(X_train, cluster_labels)  #Se obtiene el puntaje del cluster
    
    print("Para n_clusters =", i,
          "El promedio del score de la silueta es: ", silhouette_avg)
    #if(silhouette_avg>puntaje):    
    distortions.append(clusterer.inertia_)    #Obtencion de distorcsiones
    if(i==8):
        puntaje=silhouette_avg
        modeloGanador=clusterer

plt.plot(range(valorInicial,(numMuestra*salto)+valorInicial,salto),distortions, marker='o')
plt.xlabel('Numero de clusters')
plt.ylabel('Distorsion')
plt.show()

fig, (ax1) = plt.subplots(1)
fig.set_size_inches(10, 7) #Configura el tamaño del plot
ax1.set_xlim([-1, 1]) #Configura limite de ejeX
ax1.set_ylim([0, len(X_train) + (modeloGanador.n_clusters + 1) * 10]) #Configura limite de ejeY


    # Compute the silhouette scores for each sample
yObtenido=modeloGanador.predict(X_test)
escribirDatos("Resultado",cancion_test,artista_test,y_test,yObtenido)

cluster_labels = modeloGanador.fit_predict(X_train)


silhouette_avg = silhouette_score(X_train, cluster_labels)
#print(silhouette_avg)
sample_silhouette_values = silhouette_samples(X_train, cluster_labels)    
y_lower = 10
for i in range(modeloGanador.n_clusters):
        # Aggregate the silhouette scores for samples belonging to
        # cluster i, and sort them
    ith_cluster_silhouette_values = sample_silhouette_values[cluster_labels == i]
    ith_cluster_silhouette_values.sort() #ordena los scores de cada dato

    size_cluster_i = ith_cluster_silhouette_values.shape[0]
    y_upper = y_lower + size_cluster_i

    color = cm.spectral(float(i) / modeloGanador.n_clusters)
    ax1.fill_betweenx(np.arange(y_lower, y_upper),
                          0, ith_cluster_silhouette_values,
                          facecolor=color, edgecolor=color, alpha=0.7)

        
    ax1.text(-0.05, y_lower + 0.5 * size_cluster_i, str(i)) #Ajusta el alto de los tags de cada clusters

        # Compute the new y_lower for next plot
    y_lower = y_upper + 10  # 10 for the 0 samples

ax1.set_title("The silhouette plot for the various clusters.")
ax1.set_xlabel("The silhouette coefficient values")
ax1.set_ylabel("Cluster label")

    # The vertical line for average silhouette score of all the values
ax1.axvline(x=silhouette_avg, color="red", linestyle="--")

ax1.set_yticks([])  # Clear the yaxis labels / ticks
ax1.set_xticks([-1,-0.8,-0.6,-0.4,-0.2, 0, 0.2, 0.4, 0.6, 0.8, 1])

    
plt.suptitle(("Silhouette analysis for KMeans clustering on sample data "
                 "with n_clusters = %d" % modeloGanador.n_clusters),
                 fontsize=14, fontweight='bold')

plt.show()
print ("Modelo Ganador: ",modeloGanador)
print("puntaje obtenido: ", puntaje)