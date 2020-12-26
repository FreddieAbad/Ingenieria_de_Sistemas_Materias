from __future__ import division
import pandas as pd
import numpy as np
from sklearn.metrics import f1_score


#sep='\t' asume que el separador es una tab y no un espacio 
data_comments =pd.read_csv('YoutubeCommentsSpam.csv')

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

#Cuenta numero veces palabra aparece en comentarios spam y ham 
def processComment(comment,label):
    global positiveTotal
    global negativeTotal
        # Divido comentarios into words
    comment = comment.split(' ')
    
    # Revisa cada palabra en el comentario
    for word in comment:
        
        # Comentarios Ham
        if(label == 0 and word != ' '):
            
            # Incrementa numero veces que palabra aparece en comentarios ham
            trainNegative[word] = trainNegative.get(word,0)+1
            negativeTotal += 1
            
        # Comentarios Spam
        elif(label == 1 and word != ' '):
            
            # Incrementa numero veces que palabra aparece en comentarios spam
            trainPositive[word] = trainPositive.get(word,0)+1
            positiveTotal += 1



def conditionalWord(word,label):    # Obtiene Prob(word|spam) and Prob(word|ham)
    
    global alpha        # Parametro de suavizado de Laplace smoothing 
    
    if(label == 0):      # palabra encontrada en comentario ham
        # Obtencion de  Prob(word|ham)
        return (trainNegative.get(word,0)+alpha)/(float)(negativeTotal+alpha*vocab_size_train)
    
    else:       # palabra encontrada en comentario spam 
        # Obentcion de Prob(word|ham)
        return (trainPositive.get(word,0)+alpha)/(float)(positiveTotal+alpha*vocab_size_train)


def conditionalComment(comment,label):  # Define Prob(spam|comment) or Prob(ham|comment)
    prob_label_comment = 1.0    # Inicio probabilidad del comentario
    comment = comment.split(' ') # Separa el comentario en una lista de palabras
    
    for word in comment:    # Revisa todas las palabras en los comentarios
        # Calculo el valor proporcional a Prob(label|comment) basándose en 
        # la multiplicación de la probabilidades P(palabra|label) de las palabras del comentario
        prob_label_comment *= conditionalWord(word,label)    
    return prob_label_comment

# Entrenar naive bayes mediante el cálculo de varias probabilidades condicionales en los datos de entrenamiento
def train():    
    print('Empieza el entrenamiento')
    global pSpam
    global pNotSpam

    # Inicializa variables
    total = 0           #Número de comentarios leidos
    numNegative = 0     #Número de comentarios clasificados como ham
       
    for idx, comment in data_comments_train.iterrows():# Revisa cada comentario en los datos de entrenamiento
        if comment.label == 0:       # Comentario es ham
            numNegative += 1        # Incrementa el número de comentarios ham
        total += 1          # Aumenta el número de comentarios leidos
        
        # Actualiza el numero de veces que cada palabar aparece en un comentario ham y spam
        processComment(comment.content,comment.label)
    
    # Determina las probabilidades P(spam), P(ham)
    pSpam = numNegative/float(total)
    pNotSpam = (total - numNegative)/float(total)
    
    print('Entrenamiento a terminado')

train()

def classify(comment): # Clasifica un comentario como spam o ham
    
    global pSpam
    global pNotSpam
    
    # Calcular el valor proporcional a Pr(comment|ham)
    isNegative = pSpam * conditionalComment(comment,0)
    
    # Calcular el valor proporcional a Pr(comment|spam)
    isPositive = pNotSpam * conditionalComment(comment,1)
    
    if(isNegative < isPositive): # Compara probabilidades. Salida 1 = spam, 0 = ham
        return 1
    else:
        return 0
    
    

prediction_test = []


for comment in data_comments_test["content"]:#Se obtiene la clasificación en los datos de prueba    
    prediction_test.append(classify(comment)) # Classifacion de comentarios

# COmprobar la precision o accuracy

def medirRendimiento(y_test,pred):
	test_accuracy = np.mean(np.equal(pred,y_test))    
	print("Proporción de comentarios clasificados correctamente (Accuracy): %s" % test_accuracy)
	print("Rendimiento Macro: %s" % f1_score(y_test, pred, average='macro'))  
	print("Rendimiento Micro: %s" % f1_score(y_test, pred, average='micro'))  
	print("Rendimiento weighted: %s" % f1_score(y_test, pred, average='weighted'))  
	print("Rendimiento None: %s" % f1_score(y_test, pred, average=None)) 



print("\nMEDIDAS DE RENDIMIENTO")
medirRendimiento(data_comments_test["label"],prediction_test)

print("\nEVALUACION DE MENSAJES")
print("Algoritmo Predictivo - Spam = 1 No Spam = 0 ")
print("Mensaje: 'Guys check out my new chanell' \tClasificacion: %s" %classify("Guys check out my new chanell"))
print("Mensaje: 'I have solved P vs. NP, check my video https://www.youtube.com/watch?v=dQw4w9WgXcQ' \tClasificacion: %s" %classify("I have solved P vs. NP, check my video https://www.youtube.com/watch?v=dQw4w9WgXcQ"))
print("Mensaje: 'I liked the video' \tClasificacion: %s" %classify("I liked the video"))
print("Mensaje: 'Its great that this video has so many views' \tClasificacion: %s" % classify("Its great that this video has so many views"))
print("Mensaje: 'Agregame a este numero' \tClasificacion: %s" %classify("Agregame a este numero "))
print("Mensaje: 'You won a car in Cuenca Ecuador' \tClasificacion: %s" %classify("You won a car in Cuenca Ecuador"))
print("Mensaje: 'You drive a car in Cuenca Ecuador' \tClasificacion: %s" %classify("You drive a car in Cuenca Ecuador"))

######################### PRUEBA DE EVALUACION DE SCORE #######################
###############################################################################



