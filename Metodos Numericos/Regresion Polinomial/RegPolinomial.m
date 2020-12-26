%Regresion Polinomial
clear all, clc, close all, format compact
% coordenadas
x=[0 1 2 3 4 5];
y=[2.1 7.7 13.6 27.2 40.9 61.1];

% grafico de puntos
plot(x, y, 'ro', 'linewidth', 2)
hold on 
% regresion polinomial usando polyfit
p2 = polyfit(x, y, 2)
p4 = polyfit(x, y, 4)
p5 = polyfit(x, y, 5) 
% valores para test
xc = 1 : .1 : 10; 
% regresion en 2do grado
y2 = polyval(p2, xc);
plot(xc, y2, 'g.-') 
% regresion en 4to grado
y4 = polyval(p4, xc);
plot(xc, y4, 'linewidth', 4) 
% regresion en 5to grado
y5 = polyval(p5, xc);
plot(xc, y5, 'k.', 'linewidth', 5)
grid
legend('datos originales', 'regresion 2do orden', 'regresion 4do orden', 'regresion 5do orden');


xinput=input('Ingrese los valores de x [] : ');
yinput=input('Ingrese los valores de y [] : ');
plot(x, y, 'ro', 'linewidth', 2);
hold on ;
n=input('Ingrese el grado del polinomio: ');
p2 = polyfit(x, y, n);
disp(p2);
% regresion en n grado
yn = polyval(p2, xc);
plot(xc, yn, 'g.-'); 