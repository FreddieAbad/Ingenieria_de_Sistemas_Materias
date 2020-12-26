% FACTORIZACION lU CROULT
clc;
clear;
format long;%max cap de la maquina

A=input('Matriz A =');

[n,m]=size(A);
%C=[A,b];
% la matriz C es la matriz aumentada [Ab]

if n==m 
    for k=1:n
        u(k,k)=1; 
        suma=0;
        for p=1:k-1
            suma=suma+L(k,p)*u(p,k);
        end
        L(k,k)=(A(k,k)-suma); 
        
        for i=k+1:n
            suma=0;
            for r=1:k-1
                suma=suma+L(i,r)*u(r,k);
            end
            L(i,k)=(A(i,k)-suma); %Matriz L
        end
        for j=k+1:n
            suma=0;
            for s=1:k-1
                suma=suma+L(k,s)*u(s,j);
            end
            u(k,j)=(A(k,j)-suma)/L(k,k); %Matriz U
        end
    end
    fprintf('Descomposicion Crout');
    fprintf('\n Matriz L:\n')
    disp(L)
    fprintf('\n Matriz U:\n')
    disp(u) 
else
    fprintf('\nLa matriz debe ser cuadrada para factorizar mediante LU Crout\n');
    
end


