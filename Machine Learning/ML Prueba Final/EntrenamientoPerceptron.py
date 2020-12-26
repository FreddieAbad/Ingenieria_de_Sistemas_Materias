import pandas as pd 
from  matplotlib import pyplot as plt
import numpy as np 
from scipy.interpolate import interp1d
import matplotlib.pyplot as plt
from matplotlib.colors import ListedColormap

class Perceptron:
    
    def __init__(self, eta=0.6, n_iter=10):
        self.eta = eta
        self.n_iter = n_iter
 
    def fit(self, X, y):
       
        self.w_ = np.zeros(1 + X.shape[1])
        self.errors_ = []
 
        for _ in range(self.n_iter):
            errors = 0
            for xi, target in zip(X, y):
                update = self.eta * (target - self.predict(xi))
                self.w_[1:] += update * xi
                self.w_[0] += update
                errors += int(update != 0.0)
 #               if(errors==self.eta):
 #                   break
            self.errors_.append(errors)
        return self
 
    def predict(self, X):
        
        phi = np.where(self.net_input(X) >= 0.0, 1, -1)
        return phi
 
    def net_input(self, X):

        z = np.dot(X, self.w_[1:]) + self.w_[0]
        return z

def plot_decision_regions(X, y, classifier, resolution=0.02):
    # setup marker generator and color map
    markers = ('s', 'x', 'o', '^', 'v')
    colors = ('red', 'blue', 'lightgreen', 'gray', 'cyan')
    cmap = ListedColormap(colors[:len(np.unique(y))])
    # plot the decision surface
    x1_min, x1_max = X[:, 0].min() - 1, X[:, 0].max() + 1
    x2_min, x2_max = X[:, 1].min() - 1, X[:, 1].max() + 1
    xx1, xx2 = np.meshgrid(np.arange(x1_min, x1_max, resolution),
    np.arange(x2_min, x2_max, resolution))
    Z = classifier.predict(np.array([xx1.ravel(), xx2.ravel()]).T)
    Z = Z.reshape(xx1.shape)
    plt.contourf(xx1, xx2, Z, alpha=0.4, cmap=cmap)
    plt.xlim(xx1.min(), xx1.max())
    plt.ylim(xx2.min(), xx2.max())
    # plot class samples
    for idx, cl in enumerate(np.unique(y)):
        plt.scatter(x=X[y == cl, 0], y=X[y == cl, 1],
            alpha=0.8, c=cmap(idx),
            marker=markers[idx], label=cl)






data=pd.read_csv('C.csv',header=1,delim_whitespace=True)
x=data.ix[:,0] #todos los datos de x seran los primeros datos
y=data.ix[:,1] #1 es seguda columna
print(data)
print(x)
print(y)
plt.plot(x,y,'ro')  #grafica datos
plt.ylabel('X1') #etiquetas
plt.xlabel('X2')
plt.show()


xx=data.ix[:,0] #todos los datos de x seran los primeros datos
yy=data.ix[:,2] #1 es seguda columna
plt.plot(xx,yy,'ro')  #grafica datos
plt.ylabel('X1') #etiquetas
plt.xlabel('X3')
plt.show()


xxx=data.ix[:,1] #todos los datos de x seran los primeros datos
yyy=data.ix[:,2] #1 es seguda columna
plt.plot(xxx,yyy,'ro')  #grafica datos
plt.ylabel('X1') #etiquetas
plt.xlabel('X2')
plt.show()

puntos=list(set(x + y))


#Entrenamiento de Perceptron






#Entrenamiento Patron X1 con patron X3
coordenadas=data.iloc[1:359, [0, 2]].values
etiquetas=data.iloc[1:359, 3].values
ETIQUETAS1=etiquetas
ETIQUETAS2=etiquetas
etiquetas = np.where(etiquetas == 'A', -1, 1)
ETIQUETAS1 = np.where(ETIQUETAS1 == 'B', -1, 1)
ETIQUETAS2 = np.where(ETIQUETAS2 == 'C', -1, 1)
ppn = Perceptron(eta=0.1, n_iter=15)
ppn.fit(coordenadas, etiquetas)
plt.plot(range(1, len(ppn.errors_) + 1), ppn.errors_, marker='^')
plt.xlabel('Iteraciones')
plt.ylabel('Numero de clasificaciones erroneas')
plt.tight_layout()
plt.show()



plot_decision_regions(coordenadas, etiquetas, classifier=ppn)
plt.xlabel('Patron X1')
plt.ylabel('Patron X3')
plt.legend(loc='upper left')
plt.show()

ppn.fit(coordenadas, ETIQUETAS1)
plot_decision_regions(coordenadas, ETIQUETAS1, classifier=ppn)
plt.xlabel('Patron X2')
plt.ylabel('Patron X3')
plt.legend(loc='upper left')
plt.show()

ppn.fit(coordenadas, ETIQUETAS2)
plot_decision_regions(coordenadas, ETIQUETAS2, classifier=ppn)
plt.xlabel('Patron X1')
plt.ylabel('Patron X2')
plt.legend(loc='upper left')
plt.show()



#Entrenamiento Patron X2 con patron X3
coordenadas=data.iloc[1:359, [1, 2]].values
etiquetas=data.iloc[1:359, 3].values
ETIQUETAS1=etiquetas
ETIQUETAS2=etiquetas
etiquetas = np.where(etiquetas == 'A', -1, 1)
ETIQUETAS1 = np.where(ETIQUETAS1 == 'B', -1, 1)
ETIQUETAS2 = np.where(ETIQUETAS2 == 'C', -1, 1)
ppn = Perceptron(eta=0.1, n_iter=15)
ppn.fit(coordenadas, etiquetas)
plt.plot(range(1, len(ppn.errors_) + 1), ppn.errors_, marker='^')
plt.xlabel('Iteraciones')
plt.ylabel('Numero de clasificaciones erroneas')
plt.tight_layout()
plt.show()



plot_decision_regions(coordenadas, etiquetas, classifier=ppn)
plt.xlabel('Patron X1')
plt.ylabel('Patron X3')
plt.legend(loc='upper left')
plt.show()

ppn.fit(coordenadas, ETIQUETAS1)
plot_decision_regions(coordenadas, ETIQUETAS1, classifier=ppn)
plt.xlabel('Patron X2')
plt.ylabel('Patron X3')
plt.legend(loc='upper left')
plt.show()

ppn.fit(coordenadas, ETIQUETAS2)
plot_decision_regions(coordenadas, ETIQUETAS2, classifier=ppn)
plt.xlabel('Patron X1')
plt.ylabel('Patron X2')
plt.legend(loc='upper left')
plt.show()


#Entrenamiento Patron X1 con patron X2
coordenadas=data.iloc[1:359, [0, 1]].values
etiquetas=data.iloc[1:359, 3].values
ETIQUETAS1=etiquetas
ETIQUETAS2=etiquetas
etiquetas = np.where(etiquetas == 'A', -1, 1)
ETIQUETAS1 = np.where(ETIQUETAS1 == 'B', -1, 1)
ETIQUETAS2 = np.where(ETIQUETAS2 == 'C', -1, 1)
ppn = Perceptron(eta=0.1, n_iter=15)
ppn.fit(coordenadas, etiquetas)
plt.plot(range(1, len(ppn.errors_) + 1), ppn.errors_, marker='^')
plt.xlabel('Iteraciones')
plt.ylabel('Numero de clasificaciones erroneas')
plt.tight_layout()
plt.show()



plot_decision_regions(coordenadas, etiquetas, classifier=ppn)
plt.xlabel('Patron X1')
plt.ylabel('Patron X3')
plt.legend(loc='upper left')
plt.show()

ppn.fit(coordenadas, ETIQUETAS1)
plot_decision_regions(coordenadas, ETIQUETAS1, classifier=ppn)
plt.xlabel('Patron X2')
plt.ylabel('Patron X3')
plt.legend(loc='upper left')
plt.show()

ppn.fit(coordenadas, ETIQUETAS2)
plot_decision_regions(coordenadas, ETIQUETAS2, classifier=ppn)
plt.xlabel('Patron X1')
plt.ylabel('Patron X2')
plt.legend(loc='upper left')
plt.show()

