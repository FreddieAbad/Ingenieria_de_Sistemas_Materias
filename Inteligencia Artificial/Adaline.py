import matplotlib.pyplot as plt
import numpy as np

dataset = [
            [0, 0, 0, 1, 1],
            [0, 0, 1, 0, 2],
            [0, 0, 1, 1, 3],
            [0, 1, 0, 0, 4],
            [0, 1, 0, 1, 5],
            [0, 1, 1, 0, 6],
            [0, 1, 1, 1, 7],
            [1, 0, 0, 0, 8],
            [1, 0, 0, 1, 9],
            [1, 0, 1, 0, 10],
            [1, 0, 1, 1, 11],
            [1, 1, 0, 0, 12],
            [1, 1, 0, 1, 13],
            [1, 1, 1, 0, 14],
            [1, 1, 1, 1, 15],
           ]
training = dataset[:-8]
training.append(dataset[-1])
test = dataset[7:-1]

W = np.random.rand(4)
r = 0.1
t = 0
def activation_function(X, W, t):
    dx = X[-1]
    x = X[:-1]
    y = np.sum(x * W) + t
    return y
def error(data, W, t):
    errors = []
    for row in data:
        y = activation_function(row, W, t)
        dx = row[-1]
        e_i = dx - y
        errors.append(e_i**2)
    return sum(errors)
def calculate(data, max_iter, r, W, t, show_pesos):
    errors = []
    for i in range(max_iter):
        errors.append(error(data, W, t))
        for row in data:
            y = activation_function(row, W, t)
            x = row[:-1]
            dx = row[-1]
            e_i = dx - y
            if show_pesos:
                print(f"[{i}] - pesos: {W}, t: {t}")
            x_float =  np.array(x)
            #print(e_i, r, x)
            W = W + e_i * r * x_float
    return W, errors
def show(data, W, t):
    for row in data:
        y = activation_function(row, W, t)
        dx = row[-1]
        print(f"({row[0]} {row[1]} {row[2]} {row[3]}) : {dx} =? {y}")
max_iter = 10
W, errors = calculate(training, 100, r, W, t, False)

len(errors)
show(test, W, t)
error(test, W, t)
plt.plot(range(len(errors)), errors)
#plt.axis([0, 50, 0, 1e-8])
plt.axis([0, 50, 0, 150])
plt.show()
