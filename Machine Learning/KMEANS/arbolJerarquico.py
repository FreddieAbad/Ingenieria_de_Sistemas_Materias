

import pandas as pd 
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from scipy.cluster.hierarchy import linkage
from scipy.spatial.distance import pdist, squareform
from scipy.cluster.hierarchy import dendrogram

def convert(obj):
    if isinstance(obj, str):
        return obj
    else: return str(obj)
def converInt(obj):
    if isinstance(obj, str):
        return float(obj)
    else: return obj
 
def convertL(lista):
    lista2=[]
    for element in lista:
        lista2.append(convert(element))
    return lista2
def convertFlo(lista):
    lista1=[]
    lista2=[]
    for element in lista:
        lista2=[]
        for i in element:
            lista2.append(converInt(i))
        lista1.append(lista2)
    return lista1

df = pd.read_csv('dataset.csv' , header=None)
y = df.iloc[1:2000, 0].values #ids
var=df.loc[0,1:100].values #nombres variables
X = df.iloc[1:2000, :100].values
X=convertFlo(X)
variables=var.tolist()
labels=convertL(y.tolist())
#print(labels)
print(len(variables))
print(len(labels))
print(len(X))
#variables = ['X', 'Y', 'Z']
#labels = ['ID_0', 'ID_1', 'ID_2', 'ID_3', 'ID_4']
#X = np.random.random_sample([5, 3])*10
#print (Y)
#df = pd.DataFrame(X, columns=variables, index=labels)
df=pd.DataFrame(X,columns=variables, index=labels)
print(df)
row_dist=pd.DataFrame(squareform(pdist(df,metric='euclidean')),columns=labels,index=labels)
print (row_dist)

row_clusters = linkage(df.values, metric='euclidean', method='complete')
clusters=pd.DataFrame(row_clusters,
             columns=['row label 1', 'row label 2',
                      'distance', 'no. of items in clust.'],
             index=['cluster %d' % (i + 1) 
                    for i in range(row_clusters.shape[0])])

print(row_clusters)
print ("clusters")
print (clusters)

# make dendrogram black (part 1/2)
# set_link_color_palette(['black'])

row_dendr = dendrogram(row_clusters, 
                       labels=labels,
                       # make dendrogram black (part 2/2)
                       # color_threshold=np.inf
                       )
plt.tight_layout()
plt.ylabel('Euclidean distance')
#plt.savefig('images/11_11.png', dpi=300, 
#            bbox_inches='tight')
plt.show()