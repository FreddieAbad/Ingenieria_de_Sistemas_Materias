%Metodo de potencias 
clear all; close all; clc;
A=input('Ingrese la matriz A de  coeficientes [] : '); %[a11 a12 a13; a21 a22 a23;a31 a32 a33];
disp(A);
x=input('Ingrese la matriz X [] : ');
disp(x);
i=1;
ef=100;
efaux=100;
errores=[100 100 100];
tol=0.0001;
xmax=max(x);
aux=x';
while (ef>tol) 
    y1=(A*aux);
    ym1=max(y1);
    x1=y1./aux;
    
  
    
    for n = 1:length(errores)
      errores(n)=abs((y1(n)-aux(n))/y1(n));
    end
    ef=max(errores(:));
    
  
    fprintf("\ṇ⨪------------⨪------------\nIteracion: %i ",i);
    fprintf("\nVector AutoValores");
    disp(x1');
    fprintf("\nError: %f\n",ef);
    
    aux=y1;
    xmax=ym1;
    i=i+1;
    if(efaux==ef)
      fprintf("Valor encontrado: %f. \n",max(x1(:)));
      break;
    end
    efaux=ef;
    
end

