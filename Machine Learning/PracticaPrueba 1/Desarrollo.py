import pandas as pd 
from  matplotlib import pyplot as plt
#para ajuste lineal
import numpy as np 
from scipy.interpolate import interp1d

data=pd.read_csv('VC.txt',header=1,delim_whitespace=True)
x=data.ix[:,0] #todos los datos de x seran los primeros datos
y=data.ix[:,1] #1 es seguda columna
print(data)
print(x)
print(y)
plt.plot(x,y,'ro')  #grafica datos
plt.ylabel('carreras') #etiquetas
plt.xlabel('turnos al bat')

'''
coeficientes=np.polyfit(x,y,1) #ajuste en polinomio de 1 grado
polinomio=np.poly1d(coeficientes) #toma coeficientes y usa para recta 
print(polinomio)
f=interp1d(x,y,1)
print(f(330)) #valor en f de 330
ys=polinomio(x)
plt.plot(x,ys,'g^')
plt.plot(x,ys) #linea
plt.show()
yc=polinomio(600)
print(yc)

df = pd.DataFrame(np.random.randn(20, 6)) #matriz randomica
'''