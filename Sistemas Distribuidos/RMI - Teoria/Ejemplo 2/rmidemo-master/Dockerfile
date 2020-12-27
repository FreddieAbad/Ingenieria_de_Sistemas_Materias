FROM openjdk:8-jdk 
 
ENV APP_FOLDER=/app \ 
    CLASSES_FOLDER=build/classes 
 
ENV ALICE=$APP_FOLDER/Alice \ 
    BOB=$APP_FOLDER/Bob \ 
    INTERFACES=$APP_FOLDER/interfaces 
 
ENV ALICE_CLASSPATH=$ALICE/$CLASSES_FOLDER \ 
    BOB_CLASSPATH=$BOB/$CLASSES_FOLDER \ 
    INTERFACES_CLASSPATH=$INTERFACES/$CLASSES_FOLDER 
 
ENV CLASSPATH=$CLASSPATH:$INTERFACES_CLASSPATH:$ALICE_CLASSPATH:$BOB_CLASSPATH 
COPY Alice/src/ $ALICE/src/ 
COPY Bob/src/ $BOB/Bob/src/ 
COPY interfaces/src/ $INTERFACES/src/ 
ADD Alice/start.sh /startAlice.sh 
ADD Bob/start.sh /startBob.sh 
 
RUN mkdir -p $INTERFACES_CLASSPATH && \ 
    find -path "*$INTERFACES*" -name "*.java" | xargs javac -d $INTERFACES_CLASSPATH && \ 
    mkdir -p $ALICE_CLASSPATH && \ 
    find -path "*$ALICE*" -name "*.java" | xargs javac -d $ALICE_CLASSPATH && \ 
    mkdir -p $BOB_CLASSPATH && \ 
    find -path "*$BOB*" -name "*.java" | xargs javac -d $BOB_CLASSPATH 

CMD ["rmiregistry"] 