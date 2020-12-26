# coding: utf-8


from numpy import *
import numpy as np

# define la cantidad de películas en el 'database'

num_movies = 10

# definir el numero de usuarios en el 'database'

num_users = 5

# inicializar aleatoriamente algunas clasificaciones de películas
# una matriz 10 X 5 

ratings = random.randint(11, size = (num_movies, num_users))

print ("Calificaciones por pelicula")
print ("Generado Aleatoriamente por la funcion Random.randit()")
print (ratings)

# crear una matriz lógica (matriz que representa si se realizó una calificación, o no)
#! = es el operador lógico no
print("\n Calificaciones (Matriz Logica  de Recomendaciones)")

hombre_calificacion = (ratings != 0) * 1

print (hombre_calificacion)

# Esto es lo que sucede si no multiplicamos por 1
print("Calificaciones Logicas")
print (ratings != 0)


# Obtenga las dimensiones de una matriz usando la propiedad de forma
ratings.shape

hombre_calificacion.shape

# Vamos a hacer algunas clasificaciones. 
#Un vector de columna de 10 X 1 para almacenar todas las clasificaciones que hago
rankeo_usuario = zeros((num_movies, 1))
print("Rankeo usuario alterno nuevo (inicializara con 0's)")
print (rankeo_usuario)

# Califico 3 películas

rankeo_usuario[0] = 8
rankeo_usuario[4] = 7
rankeo_usuario[7] = 3
print("Rankeo usuario alterno (Algunas Calificaciones)")
print (rankeo_usuario)

# Actualizar calificaciones y hombre_calificacion
ratings = append(rankeo_usuario, ratings, axis = 1)
# Actualizar la matriz logica con las calificaciones
hombre_calificacion = append(((rankeo_usuario != 0) * 1), hombre_calificacion, axis = 1)
print ("Calificaciones Actualizadas")
print (ratings)

ratings.shape

hombre_calificacion
print ("Calificaciones Actualizadas (Matriz Logica Actualizada)")
print (hombre_calificacion)

hombre_calificacion.shape

# Explicación simple de lo que significa normalizar un conjunto de datos
a = [10, 20, 30]
aSum = sum(a)
aMean = aSum / 3
print("Normalizacion Ejemplo 1")
print (aMean)
print("Normalizacion Ejemplo 2")
aMean = mean(a)
print (aMean)

a = [10 - aMean, 20 - aMean, 30 - aMean]
print ("Normalizacion (Promedio sera 0,Varianza sera 1)")
print (a)

# una función que normaliza un conjunto de datos
def normalize_ratings(ratings, hombre_calificacion):
    num_movies = ratings.shape[0]    
    ratings_mean = zeros(shape = (num_movies, 1))
    ratings_norm = zeros(shape = ratings.shape)
    for i in range(num_movies): 
		# Obtener todos los índices donde hay un 1
        idx = where(hombre_calificacion[i] == 1)[0]
		# Calcular la calificación promedio de la película ith solo de los usuarios que dieron una calificación
        ratings_mean[i] = mean(ratings[i, idx])
        ratings_norm[i, idx] = ratings[i, idx] - ratings_mean[i]
    return ratings_norm, ratings_mean

# Normalizar las calificaciones

ratings, ratings_mean = normalize_ratings(ratings, hombre_calificacion)

# Actualizar algunas variables clave ahora

num_users = ratings.shape[1]
num_features = 3

# Explicación simple de lo que significa 'vectorizar' una regresión lineal

X = array([[1, 2], [1, 5], [1, 9]])
Theta = array([[0.23], [0.34]])
print ("Vectorizar una regresion Lineal")
print (X)
print ("Vectorizar una regresion Lineal Theta")
print (Theta)
print ("Vectorizar una regresion Lineal 3")
Y = X.dot(Theta)
print (Y)

# Inicializo parametros theta (user_prefs), X (movie_features)

movie_features = random.randn( num_movies, num_features )
user_prefs = random.randn( num_users, num_features )
initial_X_and_theta = r_[movie_features.T.flatten(), user_prefs.T.flatten()]
print ("Caracteristicas de peliculas")
print (movie_features)
print ("Preferencia de usuario")
print (user_prefs)
print("X y theta inicial")
print (initial_X_and_theta)

initial_X_and_theta.shape

movie_features.T.flatten().shape

user_prefs.T.flatten().shape

initial_X_and_theta

def unroll_params(X_and_theta, num_users, num_movies, num_features):
	# Recuperar las matrices X y theta de X_and_theta, en función de sus dimensiones (num_features, num_movies, num_movies)
	# Obtenga las primeras 30 (10 * 3) filas en el vector de columna de 48 X 1
	first_30 = X_and_theta[:num_movies * num_features]
	# Remodelar este vector de columna en una matriz de 10 X 3
	X = first_30.reshape((num_features, num_movies)).transpose()
	# Obtenga el resto de los 18 números, después de los primeros 30
	last_18 = X_and_theta[num_movies * num_features:]
	# Remodelar este vector de columna en una matriz de 6 X 3
	theta = last_18.reshape(num_features, num_users ).transpose()
	return X, theta

def calculate_gradient(X_and_theta, ratings, hombre_calificacion, num_users, num_movies, num_features, reg_param):
	X, theta = unroll_params(X_and_theta, num_users, num_movies, num_features)
	
	# se multiplica por hombre_calificacion porque solo queremos considerar las observaciones para las cuales se otorgó una calificación
	difference = X.dot( theta.T ) * hombre_calificacion - ratings
	X_grad = difference.dot( theta ) + reg_param * X
	theta_grad = difference.T.dot( X ) + reg_param * theta
	
	# envolver los degradados de nuevo en un vector de columna 
	return r_[X_grad.T.flatten(), theta_grad.T.flatten()]

def calculate_cost(X_and_theta, ratings, hombre_calificacion, num_users, num_movies, num_features, reg_param):
	X, theta = unroll_params(X_and_theta, num_users, num_movies, num_features)
	
	# se multiplica (element-wise) by hombre_calificacion porque solo queremos considerar las observaciones para las cuales se otorgó una calificación
	cost = sum( (X.dot( theta.T ) * hombre_calificacion - ratings) ** 2 ) / 2
	# '**' means an element-wise power
	regularization = (reg_param / 2) * (sum( theta**2 ) + sum(X**2))
	return cost + regularization

# Importar estos para optimizaciones avanzadas (como pendiente de gradiente)

from scipy import optimize

# parámetro de regularización

reg_param = 30

# realizar descenso de gradiente, encontrar el costo minimo (sum of squared errors) y valores optimos de X (movie_features) and Theta (user_prefs)
#algoritmo de optimización avanzado para encontrar el minimo global mediante actualizacion de x, theta 
minimized_cost_and_optimal_params = optimize.fmin_cg(calculate_cost, fprime=calculate_gradient, x0=initial_X_and_theta, 								args=(ratings, hombre_calificacion, num_users, num_movies, num_features, reg_param), 								maxiter=100, disp=True, full_output=True ) 

cost, optimal_movie_features_and_user_prefs = minimized_cost_and_optimal_params[1], minimized_cost_and_optimal_params[0]

# desenrollar una vez más

movie_features, user_prefs = unroll_params(optimal_movie_features_and_user_prefs, num_users, num_movies, num_features)
print("Desenrollar Caracteristicas de Peliculas")
print (movie_features)
print ("Desenrollar Preferencias de Usuario")
print (user_prefs)

# Hacer algunas predicciones (recomendaciones de películas). Producto de punto
all_predictions = movie_features.dot( user_prefs.T )
print ("Predicciones en base de recomendaciones, mediante producto punto")
print (all_predictions)

# volver a agregar el vector de columnas ratings_mean a las predicciones
predictions_for_nikhil = all_predictions[:, 0:1] + ratings_mean
print ("Predicciones del Usuario")
print (np.around(predictions_for_nikhil, decimals=2))
print ("Rankeo Usuario")

print (np.around(rankeo_usuario))


#https://nikhilwins.wordpress.com/2015/09/18/movie-recommendations-how-does-netflix-do-it-a-9-step-coding-intuitive-guide-into-collaborative-filtering/

#https://www.youtube.com/playlist?list=PLseNcwx1RJ4WdgtrMTXndw4B4nlf4-pgS