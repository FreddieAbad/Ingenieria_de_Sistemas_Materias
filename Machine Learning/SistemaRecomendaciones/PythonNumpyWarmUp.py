
# coding: utf-8
# Útil para manipulaciones matriciales, como producto de punto y transposición

from numpy import *

# Declarar e inicializar una matriz numérica 2d (solo llámala matriz, por simplicidad)
# Así es como organizaremos nuestros datos. muy simple y fácil de manipular.
data = array([[1, 2, 3], [1, 2, 3]])
print data


# Get dimensions of matrix

data.shape

# Declare and initialize a matrix of zeros

zeros_matrix = zeros((1,2))
print zeros_matrix

# Declare and initialize a matrix of ones

ones_matrix = ones((1,2))
print ones_matrix


# Declare and initialize a matrix of random integers from 0-10

rand_matrix = random.randint(10, size = (10, 5))
print rand_matrix

# Declare and initialize a column vector

col_vector = random.randint(10, size = (10, 1))
print col_vector

# Access and print the first element of the column vector

print col_vector[0]

# Change the first element of the column vector

col_vector[0] = 100
print col_vector

# Access and print the first element of rand_matrix
print rand_matrix[0, 0]

# Access and print the all rows of first column of rand_matrix
print rand_matrix[:, 0:1]

# Access and print the all columns of first row of rand_matrix
print rand_matrix[0:1, :]

# Access the 2nd, 3rd and 5th columns fo the first row rand_matrix
# Get the result in a 2d numpy array
cols = array([[1,2,3]])
print rand_matrix[0, cols]

# Flatten a matrix
flattened = rand_matrix.T.flatten()
print flattened

# Dot product
rand_matrix_2 = random.randint(10, size = (5,2))
dot_product = rand_matrix.dot(rand_matrix_2)
print dot_product


# In[ ]: