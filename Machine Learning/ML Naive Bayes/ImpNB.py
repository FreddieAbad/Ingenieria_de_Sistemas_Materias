from __future__ import division
import pandas as pd
import numpy as np
import re

#sep='\t' asume que el separador es una tab y no un espacio 
data_comments =pd.read_csv('YoutubeComments.csv', sep='\t')

#creo una column_label
data_comments.columns = ["content","label"]
data_comments.head()

print(data_comments["content"][data_comments["label"] == 1]) #spam
#comentarios spam no se relacionan con el video 
#promedio son 96 caracteres o 15 palabras
# Agrego columna con longitud de comentario
data_comments['length'] = data_comments['content'].map(lambda text: len(text))

# Resumen estadistica (mean, stdev, min, max)
print (data_comments[["label","length"]].describe())
 
 #entreno 75% de la data y pruebo el 25%
 #Establezco semilla para siempre tener la misma seleccion aleatoria
np.random.seed(2017)

#Agrego vector columna de numeros generados aleatoriamente de U[0,1]
data_comments["uniform"] = np.random.uniform(0,1,len(data_comments.index)) 

data_comments_train = data_comments[data_comments["uniform"] < 0.75]

data_comments_test = data_comments[data_comments["uniform"] > 0.75]

#verificacion de que train data tenga spam & ham
print (data_comments_train["label"].describe())

print(data_comments_test["label"].describe())

# UNo en una sola lista comentarios
training_list_words = "".join(data_comments_train.iloc[:,0].values)

#Divido comentarios en lista de palabras unicas
train_unique_words = set(training_list_words.split(' '))

#Numero de palabras unicas en entrenamiento
vocab_size_train = len(train_unique_words)

#Descripcion de comentarios resumidos en datos de train
#print('Palabras unicas en datos train procesados: %s' % vocab_size_train)
print('\t\t\tPrimeras 5 palabras en conjunto unico procesado de palabras: \n % s' % list(train_unique_words)[1:6])
# Diccionario con palabras de comentario como "claves", y su etiqueta como "valor"
trainPositive = dict()
trainNegative = dict()

#Inicializar clases
positiveTotal = 0
negativeTotal = 0

# Initialize Prob. of
pSpam = 0.0
pNotSpam = 0.0

# Laplace smoothing/suavizado
alpha = 1


# Inicializo dictionario de palabras y sus etiquetas    
for word in train_unique_words:
    # Clasifico todas las palabras como ham
    trainPositive[word] = 0
    trainNegative[word] = 0

#Cuenta numero veces palabra aparece en  spam and ham comments
def processComment(comment,label):
    global positiveTotal
    global negativeTotal
    
    # Divido comentarios into words
    comment = comment.split(' ')
    
    # Revisa cada palabra en el comentario
    for word in comment:
        
        # ham commments
        if(label == 0 and word != ' '):
            
            # Incrementa numero veces qe palabra aparece in ham comments
            trainNegative[word] = trainNegative.get(word,0)+1
            negativeTotal += 1
            
        # spam comments
        elif(label == 1 and word != ' '):
            
            # Increment number of times word appears in spam comments
            trainPositive[word] = trainPositive.get(word,0)+1
            positiveTotal += 1


# Defino Prob(word|spam) and Prob(word|ham)
def conditionalWord(word,label):
    
    # Parametro de suavizado de Laplace smoothing 
    global alpha
    
    # palabra in ham comment
    if(label == 0):
        # Computo Prob(word|ham)
        return (trainNegative.get(word,0)+alpha)/(float)(negativeTotal+alpha*vocab_size_train)
    
    # palabra en comentario spam 
    else:
        
        # Compute Prob(word|ham)
        return (trainPositive.get(word,0)+alpha)/(float)(positiveTotal+alpha*vocab_size_train)

# Defino Prob(spam|comment) or Prob(ham|comment)
def conditionalComment(comment,label):
    
    # Inicio probabilidad condicional
    prob_label_comment = 1.0
    
    # Split comments into list of words
    comment = comment.split(' ')
    
    # Revisa todas las palabras en los comentarios
    for word in comment:
        
        # Calculo el valor proporcional a Prob(label|comment)
        # Independencia condicional es asumida aqui
        prob_label_comment *= conditionalWord(word,label)
    
    return prob_label_comment

# Entrenar naive bayes mediante el cálculo de varias probabilidades condicionales en los datos de entrenamiento
def train():
    
    print('Empieza el entrenamiento')
    global pSpam
    global pNotSpam

    # Inicializa
    total = 0
    numNegative = 0
    
	# Revise cada comentario en los datos de entrenamiento
    for idx, comment in data_comments_train.iterrows():
        
        # Comment is ham 
        if comment.label == 0:
            
            # Increment ham comment counter
            numNegative += 1
        
        # Increment comment number
        total += 1
        
        # Update dictionary of ham and spam comments
        processComment(comment.content,comment.label)
    
    # Compute prior probabilities, P(spam), P(ham)
    pSpam = numNegative/float(total)
    pNotSpam = (total - numNegative)/float(total)
    
    print('Entrenamiento a terminado')

train()
# Clasifica comentarios como spam o ham
def classify(comment):
    
    global pSpam
    global pNotSpam
    
    # Calcular el valor proporcional a Pr(comment|ham)
    isNegative = pSpam * conditionalComment(comment,0)
    
    # Calcular el valor proporcional a Pr(comment|spam)
    isPositive = pNotSpam * conditionalComment(comment,1)
    
    # Output True = spam, False = ham
    return (isNegative < isPositive)
# Inicia prediccion de spam en test data
prediction_test = []

#Obtenga precisión de predicción en los datos de prueba
for comment in data_comments_test["content"]:

    # Classifacion de comentarios
    prediction_test.append(classify(comment))

# COmprobar la precision o accuracy
test_accuracy = np.mean(np.equal(prediction_test, data_comments_test["label"]))

#print prediction_test
print("Proporción de comentarios clasificados correctamente en el conjunto de prueba: %s" % test_accuracy)
#spam
print("Algoritmo Predictivo - Spam = True Ham = False - ")
print(classify("Guys check out my new chanell"))
#spam
print(classify("I have solved P vs. NP, check my video https://www.youtube.com/watch?v=dQw4w9WgXcQ"))
#ham
print(classify("I liked the video"))
#ham
print(classify("Its great that this video has so many views"))

print(classify("Agregame a este numero "))