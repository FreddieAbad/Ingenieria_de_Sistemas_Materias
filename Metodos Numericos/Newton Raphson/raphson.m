function [cero,k]=raphson(funcion,x0,tol,niter)
%Sintaxis: [cero,k]=raphson(funcion,x0,tol,niter)
%Descripción: devuelve el valor de una de las raices de una función
%Argumentos de Entrada:
%funcion:   ingresar una función con respecto a x en cadena de texto
%x0:        ingresar un valor de x inicial
%tol:         ingresar la tolerancia
%niter:  ingresar el número máximo de iteraciones que se quieren permitir 
%Argumentos de Salida:
%k:         devuelve elnumero de iteraciones realizadas
%cero:      devuelve el valor de una raiz
%Ejemplo:
%   [x,k]=raphson('x+x^4-5',-10,0.0001,100)
%   x = -1.6030
%   k = 10
syms x;
x1=-5:1:100;
fg=exp(-x1)-x1;

f=inline(funcion);
df=inline(diff(char(f),x));
aux=x0;
x0=x0-f(x0)/df(x0);
k=0;
plot(fg);
fprintf('xi\t\t\tf(xi)\t\t\tE\n');
if f(aux)~=0
    while abs(x0-aux)>tol & k<niter
        aux=x0;
        x0=x0-f(x0)/df(x0);
        k=k+1;
        fprintf('%d\t%d\t%d\n',x0,f(x0),((x0-aux)/x0)*100);
        plot(f(x0),x0,'rx');
        hold all;
    end
    if abs(x0-aux)<tol & k<niter
        cero=x0;
    else
        cero='superado el numero de iteraciones';
    end

else
    k=0;
    cero=aux;
end