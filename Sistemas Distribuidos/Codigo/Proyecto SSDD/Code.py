#! bin/src/python
# -*- coding: utf-8 -*-


# 0°   ->  0.5ms
# 90°  ->  1.5ms
# 180° ->  2.5ms

#  pin2   -> positivo 5V
#  pin4   -> positivo 5V
#  pin6   -> ground
#  pin7   -> señal base
#  pin11  -> señal codo
#  pin13  -> señal brazo
#  pin15  -> señal pinza

# Imagen pines raspberrypi https://az835927.vo.msecnd.net/sites/iot/Resources/images/PinMappings/RP2_Pinout.png
 

import RPi.GPIO as GPIO
import time
 
GPIO.setmode(GPIO.BOARD)

# 7,11,13,15 son los pines de Señal que se van a utilizar

GPIO.setup(7,GPIO.OUT)
GPIO.setup(11,GPIO.OUT)
GPIO.setup(13,GPIO.OUT)
GPIO.setup(15,GPIO.OUT)

# 0°    2,5 %
# 15°   3,33 %
# 30°   4,16 %
# 45°   5 %
# 60°   5,83 %
# 75°   6,66 %
# 90°   7,5 %
# 105°  8,33 %
# 120°  9,16 %
# 135°  10 %
# 150°  10,83 %
# 165°  11,66 %
# 180°  12,5 %


    
def base_moveB():
    p7 = GPIO.PWM(7,50)
    p7.start(7.5)
    p7.ChangeDutyCycle(8.5)
    time.sleep(0.25)
    p7.stop()

def base_moveA():
    p7 = GPIO.PWM(7,50)
    p7.start(7.5)
    p7.ChangeDutyCycle(5.83)
    time.sleep(0.2)
    p7.stop()

def base_centrar():
    p7 = GPIO.PWM(7,50)
    p7.start(7.5)
    p7.ChangeDutyCycle(7.5)
    time.sleep(0.25)
    p7.stop()


# Codos  45 -> 90
def codo_90():
    p13 = GPIO.PWM(13,50)
    p13.start(7.5)
    p13.ChangeDutyCycle(7.5)
    time.sleep(0.25)
    p13.stop()

def codo_70():
    p13 = GPIO.PWM(13,50)
    p13.start(7.5)
    p13.ChangeDutyCycle(6)
    time.sleep(0.25)
    p13.stop()

def codo_45():
    p13.start(7.5)
    p13.ChangeDutyCycle(5)
    time.sleep(0.25)
    p13.stop()
    
def brazo_arriba():
    #    - 
    p11 = GPIO.PWM(11,50)
    p11.start(7.5)
    p11.ChangeDutyCycle(2.5)
    time.sleep(.25)
    p11.stop()
    
def brazo_abajo():
    p11 = GPIO.PWM(11,50)
    p11.start(7.5)
    p11.ChangeDutyCycle(10)
    time.sleep(.09)
    p11.stop()

def pinza_sujeta():
    p15 = GPIO.PWM(15,50)
    p15.start(7.5)
    p15.ChangeDutyCycle(3.0)
    time.sleep(.25)
    p15.stop()
    
def pinza_abre():
    p15 = GPIO.PWM(15,50)
    p15.start(7.5)
    p15.ChangeDutyCycle(4.5)
    time.sleep(.25)
    p15.stop()

def va():
    pinza_abre()
    time.sleep(2)
    pinza_sujeta()
    time.sleep(1)
    brazo_arriba()
    time.sleep(1)
    base_moveB()
    time.sleep(1)
    brazo_abajo()
    time.sleep(1)
    pinza_abre()

def viene():
    pinza_sujeta()
    time.sleep(1)
    brazo_arriba()
    time.sleep(1)
    base_moveA()
    time.sleep(1)
    brazo_abajo()

def reiniciar():
    base_moveA()
    time.sleep(1)
    brazo_abajo()
    time.sleep(1)

try:
    reiniciar()
    for i in range(0,5):           
        va()
        time.sleep(2)
        viene()
        time.sleep(2)
        
except KeyboardInterrupt:
    GPIO.cleanup()
    

