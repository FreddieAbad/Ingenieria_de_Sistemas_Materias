import random
import csv as csv
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.colors import ListedColormap
from mpl_toolkits.mplot3d import Axes3D

       
def missclasification_graph(neighbors,MSE):
	plt.plot(neighbors, MSE)
	plt.xlabel('Numero de Vecinos K')
	plt.ylabel('Clasificacion Erronea')
	plt.show()


from sklearn.metrics import f1_score
import warnings
import sklearn.exceptions
warnings.filterwarnings("ignore", category=sklearn.exceptions.UndefinedMetricWarning)

def medirRendimiento(y_test,pred,X,y):	
	print("Rendimiento Accuracy 1: ",knn.score(X,y))
	print("Rendimiento Accuracy Int: ",accuracy_score(y_test, pred, normalize=False))
	print("Rendimiento Accuracy Float: ",accuracy_score(y_test, pred))
	print("Rendimiento Macro: ",f1_score(y_test, pred, average='macro'))  
	print("Rendimiento Micro: ",f1_score(y_test, pred, average='micro'))  
	print("Rendimiento weighted: ",f1_score(y_test, pred, average='weighted'))  
	print("Rendimiento None: ",f1_score(y_test, pred, average=None)) 
	
#------------------------------------------------------------------------------


df = pd.read_csv('muestra.csv' , header=None)
y = df.iloc[1:15000, 519].values
X = df.iloc[1:15000, 1:250].values


from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import f1_score
from sklearn.metrics import accuracy_score
import numpy as np
from sklearn.model_selection import train_test_split

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=42)

#Crossvalidation
from sklearn import datasets, linear_model
from sklearn.model_selection import cross_val_score

myList = list(range(1,50))          #Creando lista de numeros impares para KNN
neighbors = filter(lambda x: x % 2 != 0, myList)        #Subconjunto Impares
cv_scores = []          #Lista vacia que tendra Puntajes CV

for k in neighbors:
    knn = KNeighborsClassifier(n_neighbors=k,p=2,metric='minkowski')       #Creacion de instancia de knn
    scores = cross_val_score(knn, X_train, y_train, cv=10, scoring='accuracy')#Validacion Cruzada 10 veces
    cv_scores.append(scores.mean())

MSE = [1 - x for x in cv_scores]        #Se obtiene error de clasificacion
#print (MSE)

optimal_k = neighbors[MSE.index(min(MSE))]      #Determinar el mejor k
print ("El numero optimo de vecinos es %d" % optimal_k)

#Grafica Error vs k
missclasification_graph(neighbors,MSE)

knn = KNeighborsClassifier(n_neighbors=optimal_k,p=2,metric='minkowski')
knn.fit(X, y)
pred = knn.predict(X_test)      #test
print("PREDICCION",pred)
medirRendimiento(y_test,pred,X,y)





