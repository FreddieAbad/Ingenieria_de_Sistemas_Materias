import pyaudio as p
import wave as w
import numpy as np
import future
import librosa
import librosa.display
import IPython.display
import matplotlib.pyplot as plt
import pandas as pd
import os
import glob
from keras.models import Sequential
from keras.layers import Dense, Dropout

FORMAT=p.paInt16
CHANNELS=2
RATE=44100 #sampling frequency rate
CHUNK=1024
RECORD_SECONDS=2
WAVE_OUTPUT_FILENAME="authentic.wav"

#start recording
audio=p.PyAudio()
stream=audio.open(format=FORMAT,channels=CHANNELS,rate=RATE,input=True,output=True,frames_per_buffer=CHUNK)
#for 1st input
print("Ingreso audio original n...1")
frames=[]
for j in range(0,int(RATE/CHUNK * RECORD_SECONDS)):
    data=stream.read(CHUNK)
    frames.append(data)
print("Ingreso de audio terminado")

#stop recording 
stream.stop_stream()
stream.close()
audio.terminate()

#save file
waveFile = w.open(WAVE_OUTPUT_FILENAME, 'wb')
waveFile.setnchannels(CHANNELS)
waveFile.setsampwidth(audio.get_sample_size(FORMAT))
waveFile.setframerate(RATE)
waveFile.writeframes(b''.join(frames))
waveFile.close()


#load audio file
audio_path=WAVE_OUTPUT_FILENAME
X,sr=librosa.load(audio_path,res_type='kaiser_fast')

#audio signal
#plt.figure(figsize=(12,4))
fig1=plt.figure(figsize=(12,15))
plt.subplot(4, 1, 1)
librosa.display.waveplot(X, sr=sr)
#plt.suptitle("Figure 1:",fontsize=18)
#generate mfcc
mfcc=librosa.feature.mfcc(y=X,sr=sr,n_mfcc=128)
df=mfcc

#sleep
#time.sleep(1.2)

for i in range(1):
    audio=p.PyAudio()
    stream=audio.open(format=FORMAT,channels=CHANNELS,rate=RATE,input=True,output=True,frames_per_buffer=CHUNK)
    print("Ingreso audio n...",(i+2))
    frames=[]
    for j in range(0,int(RATE/CHUNK * RECORD_SECONDS)):
        data=stream.read(CHUNK)
        frames.append(data)
    print("Ingreso audio terminado...")

    #stop recording 
    stream.stop_stream()
    stream.close()
    audio.terminate()
    
    #save file
    waveFile = w.open(WAVE_OUTPUT_FILENAME, 'wb')
    waveFile.setnchannels(CHANNELS)
    waveFile.setsampwidth(audio.get_sample_size(FORMAT))
    waveFile.setframerate(RATE)
    waveFile.writeframes(b''.join(frames))
    waveFile.close()
    
    
    #load audio file
    audio_path=WAVE_OUTPUT_FILENAME
    X,sr=librosa.load(audio_path,res_type='kaiser_fast')
    #audio signal
    #plt.figure(figsize=(12,4))
    #fig2=plt.figure(figsize=(12,4))

    plt.subplot(4, 1, 2)
    librosa.display.waveplot(X, sr=sr)
    #plt.suptitle("Figure 2:",fontsize=18)
    #generate mfcc
    mfcc=librosa.feature.mfcc(y=X,sr=sr,n_mfcc=128)
    df=np.concatenate((df,mfcc),axis=0)

    #time.sleep(1.2)

IPython.display.Audio(data=X,rate=sr)

label=[]
for i in range(0,256):
    label.append(1)
label= np.array(label)

#Another person
FORMAT=p.paInt16
CHANNELS=2
RATE=44100 #sampling frequency rate
CHUNK=1024
RECORD_SECONDS=2
WAVE_OUTPUT_FILENAME="another.wav"

#start recording
audio=p.PyAudio()
stream=audio.open(format=FORMAT,channels=CHANNELS,rate=RATE,input=True,frames_per_buffer=CHUNK)
print("Ingreso audio ...")
frames=[]
for i in range(0,int(RATE/CHUNK * RECORD_SECONDS)):
    data=stream.read(CHUNK)
    frames.append(data)
print("Ingreso audio terminado...")

#stop recording 
stream.stop_stream()
stream.close()
audio.terminate()

waveFile = w.open(WAVE_OUTPUT_FILENAME, 'wb')
waveFile.setnchannels(CHANNELS)
waveFile.setsampwidth(audio.get_sample_size(FORMAT))
waveFile.setframerate(RATE)
waveFile.writeframes(b''.join(frames))
waveFile.close()

audio_path= WAVE_OUTPUT_FILENAME
X_1,sr_1=librosa.load(audio_path,res_type='kaiser_fast')
#display in notebook
IPython.display.Audio(data=X_1,rate=sr_1)

#plt.figure(figsize=(12,4))
#fig3=plt.figure(figsize=(12,4))
plt.subplot(4, 1, 3)
librosa.display.waveplot(X_1, sr=sr_1)
#plt.suptitle("Figure 3:",fontsize=18)
X_another=librosa.feature.mfcc(y=X_1,sr=sr_1,n_mfcc=128)
X_another.shape
df=np.concatenate((df,X_another),axis=0)

y_another=[]
for i in range(0,128):
    y_another.append(0)
y_another=np.array(y_another)

label=np.concatenate((label,y_another),axis=0)
#modelos deep learning
def create_model():
    #build model
    model=Sequential()
    model.add(Dense(256,input_dim=87,activation='relu'))
    model.add(Dropout(0.3))
    model.add(Dense(128,activation='relu'))
    model.add(Dropout(0.3))
    model.add(Dense(64, init='uniform', activation='relu'))
    model.add(Dropout(0.3))
    model.add(Dense(2,activation='softmax'))
    model.compile(loss='sparse_categorical_crossentropy', metrics=['accuracy'], optimizer='adam')
    model.summary()
    return model
model=create_model()

from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test = train_test_split(df,label,test_size=0.2,random_state=21)
print(X_train.shape,y_train.shape,X_test.shape,y_test.shape)
model.fit(X_train,y_train,validation_data=(X_test,y_test),batch_size=5,epochs=20)

#TESTING

FORMAT=p.paInt16
CHANNELS=2
RATE=44100 #sampling frequency rate
CHUNK=1024
RECORD_SECONDS=2
WAVE_OUTPUT_FILENAME="test.wav"
audio=p.PyAudio()

#start recording
stream=audio.open(format=FORMAT,channels=CHANNELS,rate=RATE,input=True,frames_per_buffer=CHUNK)
print("Ingreso audio ...")
frames=[]
for i in range(0,int(RATE/CHUNK * RECORD_SECONDS)):
    data=stream.read(CHUNK)
    frames.append(data)
print("Ingreso audio terminado...")

#stop recording 
stream.stop_stream()
stream.close()
audio.terminate()

waveFile = w.open(WAVE_OUTPUT_FILENAME, 'wb')
waveFile.setnchannels(CHANNELS)
waveFile.setsampwidth(audio.get_sample_size(FORMAT))
waveFile.setframerate(RATE)
waveFile.writeframes(b''.join(frames))
waveFile.close()

#load audio file
audio_path= WAVE_OUTPUT_FILENAME
X_2,sr_2=librosa.load(audio_path,res_type='kaiser_fast')
#display in notebook
IPython.display.Audio(data=X_2,rate=sr_2)

#plt.figure(figsize=(12,4))
#fig4=plt.figure(figsize=(12,4))

plt.subplot(4, 1, 4)
librosa.display.waveplot(X_2, sr=sr_2)
#plt.suptitle("Figure 4:",fontsize=18)
plt.tight_layout()
X_user_test=librosa.feature.mfcc(y=X_2,sr=sr_2,n_mfcc=128)
X_user_test.shape

y_user_test=[]
for i in range(0,128):
    y_user_test.append(1)
score=model.evaluate(X_user_test,y_user_test,verbose=0)
if score[1]>0.75:
    print("Voz reconocida")
    print("Usuario 1")
else:
    print("Voz reconocida")
    print("Usuario 2")
plt.show()
"""
from keras.wrappers.scikit_learn import KerasClassifier
estimator = KerasClassifier(build_fn=create_model, epochs=200, batch_size=5, verbose=0)
from sklearn.model_selection import KFold
from sklearn.model_selection import cross_val_score
kfold = KFold(n_splits=10, shuffle=True, random_state=2)
results = cross_val_score(estimator, X_user_test, y_user_test, cv=kfold)
print("Baseline: %.2f%% (%.2f%%)" % (results.mean()*100, results.std()*100))
"""
