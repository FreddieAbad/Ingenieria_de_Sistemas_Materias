%Descomposicion LU
A=input('Agregue la matriz A : ');

L = zeros(size(A));
U = zeros(size(A));
[filas, columnas] = size(A);

for j=1:columnas
  for i=1:filas

    if i<=j
      U(i,j) = A(i,j);
      for k=1:i-1
        U(i,j) = U(i,j) - L(i,k)*U(k,j);
      end
    end    

    if j<=i
      L(i,j) = A(i,j);
      for k=1:j-1
        L(i,j) = L(i,j) - L(i,k)*U(k,j);
      end
      L(i,j) = L(i,j)/U(j,j);
    end
  end
end
fprintf('\n\tResultados\n\nMatriz L : \n');
disp(L);
fprintf('\nMatriz U : \n');
disp(U);