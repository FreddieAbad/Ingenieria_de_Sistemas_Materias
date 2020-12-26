%Algoritmo eliminacion gaussiana simple
A= input ('Matriz Valores A: ')
b= input ('Vector B (independientes): ')
[n, q]=size(A);

for i=1:n-1;
    for k=i+1:n ;
        m=A(k,i)/A(i,i);
        for j= i+1:n;
            A(k,j)= A(k,j)-m*A(i,j);
        end
        A(k,i)=0;
        b(k)=b(k)-m*b(i);
    end
end
x=zeros(n,1);
fprintf('Matriz A:\n');
disp(A);
fprintf('Vector B: \n');
disp(b);
for i=n:-1:1;
    aux=0;
    for j=i+1:n
        aux=aux+A(i,j)*x(j);
    end
    x(i)=(b(i)-aux)/A(i,i);
end
fprintf('\nResultados:');
for(i=1:n)
  fprintf('\nx%d:%f\n',i,x(i));
end  