# importando pandas, numpy y matplotlib
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn import datasets
from sklearn.datasets import make_classification
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn import tree
from subprocess import check_call
import prueba1
# importando los datasets de sklearn

data=pd.read_csv('entrenamiento.csv',header=None,delim_whitespace=False)
data2=pd.read_csv('prueba.csv',header=None,delim_whitespace=False)

#print(data)
train, test=train_test_split(data,stratify=data[6],test_size=0.25 )
print(train)

x=data[range(6)]
y=data[6]
x=pd.get_dummies(x)
y=pd.get_dummies(y)

x2=pd.get_dummies(data2[range(5)])
y2=pd.get_dummies(data2[5])

ad = DecisionTreeClassifier(criterion='entropy')#, max_depth=6) # Creando el modelo
ad.fit(x,y) # Ajustando el modelo
ad.fit(x2,y2)
#generando archivo para graficar el arbol
nombre="Profundidad.dot"	
with open(nombre, 'w') as archivo_dot:
	tree.export_graphviz(ad, out_file = archivo_dot)

check_call(['dot','-Tpng',nombre,'-o',nombre+'.png'])


nombre="Profundidad maxima E.dot"	
with open(nombre, 'w') as archivo_dot:
	tree.export_graphviz(ad, out_file = archivo_dot)

check_call(['dot','-Tpng',nombre,'-o',nombre+'.png'])




'''

# evaluate algorithm
n_folds = 5
max_depth = 5
min_size = 10
scores = prueba1.evaluate_algorithm(data, prueba1.decision_tree, n_folds, max_depth, min_size)
print('Scores: %s' % scores)
print('Mean Accuracy: %.3f%%' % (sum(scores)/float(len(scores))))

'''
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