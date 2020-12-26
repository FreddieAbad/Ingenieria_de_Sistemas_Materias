import pandas as pd
df = pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data', header=None)
df.tail()

import matplotlib.pyplot as plt
y = df.iloc[0:300, 4].values
import numpy as np
y = np.where(y == 'Iris-setosa', -1, 1)
X = df.iloc[0:300, [0, 2]].values
plt.scatter(X[:150, 0], X[:150, 1],color='red', marker='o', label='setosa')
plt.scatter(X[150:300, 0], X[150:300, 1],color='blue', marker='x', label='versicolor')
plt.xlabel('petal length')
plt.ylabel('sepal length')
plt.legend(loc='upper left')
plt.show()

