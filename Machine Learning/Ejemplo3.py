from pandas import read_csv

iris = read_csv('iris.csv')

for value in iris.PetalLength.values:
    if value < 2:
        print('Iris setosa')
    else:
        print('Iris virginica o Iris versicolor')
