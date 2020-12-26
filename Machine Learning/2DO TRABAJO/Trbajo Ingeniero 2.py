# importando pandas, numpy y matplotlib
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# importando los datasets de sklearn
from sklearn import datasets
from sklearn.datasets import make_classification
data=pd.read_csv('trainTrabajo2.csv',header=None,delim_whitespace=False)
print(data)

from sklearn.model_selection import train_test_split
train, test=train_test_split(data,stratify=data[6],test_size=0.25 )
print(train)
print('==\n',test)
print(data[range(6)])
x=data[range(6)]
y=data[6]

#z=pd.get_dummies()
print(get_dummies(data))






from sklearn.tree import DecisionTreeClassifier
from sklearn import tree

ad = DecisionTreeClassifier(criterion='entropy', max_depth=5) # Creando el modelo
ad.fit(x,y) # Ajustando el modelo

#generando archivo para graficar el arbol
with open("mi_arbol123.dot", 'w') as archivo_dot:
    tree.export_graphviz(ad, out_file = archivo_dot)












'''
X, y = datasets.make_classification(1000, 20, n_informative=3)

print("[",X,"]")
print("(",y,")")


from sklearn.tree import DecisionTreeClassifier
from sklearn import tree

ad = DecisionTreeClassifier(criterion='entropy', max_depth=5) # Creando el modelo
ad.fit(X, y) # Ajustando el modelo

#generando archivo para graficar el arbol
with open("mi_arbol123.dot", 'w') as archivo_dot:
    tree.export_graphviz(ad, out_file = archivo_dot)
'''