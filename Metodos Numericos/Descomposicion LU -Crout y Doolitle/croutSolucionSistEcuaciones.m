% Solucion Sistemas de Ecuaciones por Metodo Crout
clc;
clear;
format long;%max cap de la maquina
fprintf('Solucion Sistemas de Ecuaciones por Metodo Crout\n');
A=input('Matriz A =');
b=input('Vector B(independientes) =');
b=b';
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
    
    memoriau=1; %Para encontrar determinante de U
    memoriaL=1; %Para encontrar determinante de L
    for i=1:n
        memoriaL=memoriaL*L(i,i); 
    end
    producto=memoriaL*memoriau;  %Para encontrar determinante total
    
    if producto~=0
      for i=1:n
        suma=0;
        for p=1:i-1
          suma=suma+L(i,p)*z(p);
        end
        z(i)=(b(i)-suma)/L(i,i); %Vector Z
      end
      for i=n:-1:1
        suma=0;
        for p=(i+1):n
          suma = suma+u(i,p)*x(p);
        end
        x(i)=(z(i)-suma)/u(i,i); %Soluciones
      end    
    else
        fprintf('\nDet=0, el sistema tiene infinita o ninguna solucion\n')
    end
end


fprintf('\n\nResultados:\n');
for i=1:n
    fprintf('x%g = %f\n',i,x(1,i));
end
