
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

df = pd.read_csv('muestra.csv' , header=None)
y = df.iloc[1:2000, 0].values #ids
var=df.loc[0,1:100].values #nombres variables
X = df.iloc[1:2000, :100].values
X=convertFlo(X)
variables=var.tolist()
labels=convertL(y.tolist())

df=pd.DataFrame(X,columns=variables, index=labels)
row_dist=pd.DataFrame(squareform(pdist(df,metric='euclidean')),columns=labels,index=labels)
row_clusters = linkage(df.values, metric='euclidean', method='complete')
clusters=pd.DataFrame(row_clusters,
                     columns=['row label 1', 'row label 2',
                              'distance', 'no. of items in clust.'],
                     index=['cluster %d' % (i + 1) 
                            for i in range(row_clusters.shape[0])])
row_dendr = dendrogram(row_clusters, 
                       labels=labels,
                       )
plt.tight_layout()
plt.ylabel('Euclidean distance')
plt.xlabel('Cluster')
plt.savefig('11_11.png', dpi=300, 
           bbox_inches='tight')
plt.show()