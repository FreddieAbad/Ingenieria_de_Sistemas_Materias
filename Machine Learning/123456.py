import pandas as p
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from matplotlib.colors import ListedColormap
from mpl_toolkits.mplot3d import Axes3D
from matplotlib.colors import ListedColormap
import matplotlib.patches as mpatches
df = pd.read_csv('C.csv', header=None)
df.tail()
y1 = df.iloc[1:360, 3].values
y=[]
for j in y1:
   if(j=='A'):
      y.append(1)
   elif(j=='B'):
      y.append(-1)
   else:
       y.append(2)
def graficar_puntos2D(X,y,nombre_eje1, nombre_eje2):
    cont = 0
    for j in y:
        if(j==1):
            plt.scatter(X[cont,0], X[cont, 1],color='red', marker='o')
        elif(j==-1):
            plt.scatter(X[cont,0],X[cont, 1], color='blue', marker='*')
        else:
            plt.scatter(X[cont, 0], X[cont, 1], color='black', marker='+')
        cont = cont+1
    plt.xlabel(nombre_eje1)
    plt.ylabel(nombre_eje2)
    plt.plot(1, linestyle='-', color='red', label="o Clase A")
    plt.plot(1, linestyle='-', color='blue', label="* Clase B")
    plt.plot(1, linestyle='-', color='black', label="+ Clase C")
    plt.legend(loc="lower right")
    plt.show()
def graficar3D(y,x1,x2,x3):
    fig = plt.figure()
    ax = fig.add_subplot(1, 1, 1, projection='3d')
    cont = 0
    for i in y:
        if(i == 1):
            ax.scatter(x1[cont],x2[cont],x3[cont], c='red', marker='o')
        elif(i == -1):
            ax.scatter(x1[cont], x2[cont], x3[cont], c='blue', marker='*')
        else:
            ax.scatter(x1[cont], x2[cont], x3[cont], c='black', marker='+')
        cont = cont+1
    ax.set_xlabel('x1')
    ax.set_xlabel('x2')
    ax.set_xlabel('x3')
    plt.show()
X = df.iloc[1:360, [0, 1]].values
graficar_puntos2D(X,y,'x1','x2')
X = df.iloc[1:360, [1, 2]].values
graficar_puntos2D(X,y,'x2','x3')
x1 = list(map(float,(df.iloc[1:360, 0].values)))
x2 = list(map(float,(df.iloc[1:360, 1].values)))
x3 = list(map(float,(df.iloc[1:360, 2].values)))
graficar3D(y,x1,x2,x3)
