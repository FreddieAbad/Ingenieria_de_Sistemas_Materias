# Import modules
# For numerical division
from __future__ import division
# For data manipulation
import pandas as pd
# For matrix operations
import numpy as np

# For regular expression (text cleaning)
import re


# Load data set and display a few observations
data_comments = pd.read_csv('YoutubeComments.csv',error_bad_lines=False)
print(data_comments)
# Create column labels
data_comments.columns = ["content","label"]
data_comments.head()

# Show spam comments in data
# DO NOT GO ON THE LINKS BELOW!!!
print (data_comments["content"][data_comments["label"] == 1])

# Add another column with corresponding comment length
data_comments['length'] = data_comments['content'].map(lambda text: len(text))

# Summary statistics (mean, stdev, min, max)
data_comments[["label","length"]].describe()



# Let's split data into training and test set (75% training, 25% test)

# Set seed so we get same random allocation on each run of code
np.random.seed(2017)

# Add column vector of randomly generated numbers form U[0,1]
data_comments["uniform"] = np.random.uniform(0,1,len(data_comments.index)) 

# About 75% of these numbers should be less than 0.75
data_comments_train = data_comments[data_comments["uniform"] < 0.75]

# About 25% of these numbers should be more than 0.75
data_comments_test = data_comments[data_comments["uniform"] > 0.75]

# Check that both training and test data have both spam and ham comments
data_comments_train["label"].describe()



# Test data summary statistics
data_comments_test["label"].describe()

# Join all the comments into a big list
training_list_words = "".join(data_comments_train.iloc[:,0].values)

# Split the list of comments into a list of unique words
train_unique_words = set(training_list_words.split(' '))

# Number of unique words in training 
vocab_size_train = len(train_unique_words)

# Description of summarized comments in training data
print('Unique words in training data: %s' % vocab_size_train)
print('First 5 words in our unique set of words: \n % s' % list(train_unique_words)[1:6])

# Only keep letters and numbers
train_unique_words = [re.sub(r'[^a-zA-Z0-9]','', words) for words in train_unique_words]

# Convert to lower case and get unique set of words
train_unique_words = set([words.lower() for words in train_unique_words])

# Number of unique words in training 
vocab_size_train = len(train_unique_words)

# Description of summarized comments in training data
print('Unique words in processed training data: %s' % vocab_size_train)
print('First 5 words in our processed unique set of words: \n % s' % list(train_unique_words)[1:6])

# Dictionary with comment words as "keys", and their label as "value"
trainPositive = dict()
trainNegative = dict()

# Intiailize classes
positiveTotal = 0
negativeTotal = 0

# Initialize Prob. of
pSpam = 0.0
pNotSpam = 0.0

# Laplace smoothing
alpha = 1
#def initialize_dicts():

# Initialize dictionary of words and their labels   
for word in train_unique_words:
    
    # Classify all words for now as ham (legitimate)
    trainPositive[word] = 0
    trainNegative[word] = 0
# Count number of times word in comment appear in spam and ham comments
def processComment(comment,label):
    global positiveTotal
    global negativeTotal
    
    # Split comments into words
    comment = comment.split(' ')
    
    # Go over each word in comment
    for word in comment:
        
        # ham commments
        if(label == 0 and word != ' '):
            
            # Increment number of times word appears in ham comments
            trainNegative[word] = trainNegative.get(word,0)+1
            negativeTotal += 1
            
        # spam comments
        elif(label == 1 and word != ' '):
            
            # Increment number of times word appears in spam comments
            trainPositive[word] = trainPositive.get(word,0)+1
            positiveTotal += 1

# Define Prob(word|spam) and Prob(word|ham)
def conditionalWord(word,label):
    
    # Laplace smoothing parameter
    global alpha
    
    # word in ham comment
    if(label == 0):
        # Compute Prob(word|ham)
        return (trainNegative.get(word,0)+alpha)/(float)(negativeTotal+alpha*vocab_size_train)
    
    # word in spam comment
    else:
        
        # Compute Prob(word|ham)
        return (trainPositive.get(word,0)+alpha)/(float)(positiveTotal+alpha*vocab_size_train)

# Define Prob(spam|comment) or Prob(ham|comment)
def conditionalComment(comment,label):
    
    # Initialize conditional probability
    prob_label_comment = 1.0
    
    # Split comments into list of words
    comment = comment.split(' ')
    
    # Go through all words in comments
    for word in comment:
        
        # Compute value proportional to Prob(label|comment)
        # Conditional indepdence is assumed here
        prob_label_comment *= conditionalWord(word,label)
    
    return prob_label_comment

# Train naive bayes by computing several conditional probabilities in training data
def train():
    
    print('Starting training')
    global pSpam
    global pNotSpam

    # Initiailize 
    total = 0
    numNegative = 0
    
    # Go over each comment in training data
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
    
    print('Training is now finished')


# Run naive bayes
train()

# Classify comment are spam or ham
def classify(comment):
    
    global pSpam
    global pNotSpam
    
    # Compute value proportional to Pr(comment|ham)
    isNegative = pSpam * conditionalComment(comment,0)
    
    # Compute value proportional to Pr(comment|spam)
    isPositive = pNotSpam * conditionalComment(comment,1)
    
    # Output True = spam, False = ham
    return (isNegative < isPositive)
# Initialize spam prediction in test data
prediction_test = []

# Get prediction accuracy on test data
for comment in data_comments_test["content"]:

    # Classify comment 
    prediction_test.append(classify(comment))

# Check accuracy
test_accuracy = np.mean(np.equal(prediction_test, data_comments_test["label"]))

#print prediction_test
print("Proportion of comments classified correctly on test set: %s" % test_accuracy)
# spam
classify("Guys check out my new chanell")
# spam
classify("I have solved P vs. NP, check my video https://www.youtube.com/watch?v=dQw4w9WgXcQ")
# ham
classify("I liked the video")
# ham
classify("Its great that this video has so many views")
# Compute tfidf(word, comment, data)
def TFIDF(comment, train):
    
    # Split comment into list of words
    comment = comment.split(' ')
    
    # Initiailize tfidf for given comment
    tfidf_comment = np.zeros(len(comment))
    
    # Initiailize number of comments containing a word
    num_comment_word = 0
    
    # Intialize index for words in comment
    word_index = 0
    
    # Go over all words in comment
    for word in comment:
        
        # Compute term frequence (tf)
        # Count frequency of word in comment
        tf = comment.count(word)
        
        # Find number of comments containing word
        for text in train["content"]:
            
            # Increment word counter if word found in comment
            if text.split(' ').count(word) > 0:
                num_comment_word += 1
        
        # Compute inverse document frequency (idf)
        # log(Total number of comments/number of comments with word)
        idf = np.log(len(train.index)/num_comment_word)
        
        # Update tf-idf weight for word
        tfidf_comment[word_index] = tf*idf
        
        # Reset comment containing word counter
        num_comment_word = 0
        
        # Move onto next word in comment
        word_index += 1
        
    return tfidf_comment


TFIDF("Check out my new music video plz",data_comments_train)

