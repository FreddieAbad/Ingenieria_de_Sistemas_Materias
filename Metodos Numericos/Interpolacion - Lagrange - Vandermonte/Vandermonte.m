%INTERPOLACION VANDERMONDE

x=input('Ingrese los valores en x []: ');
y=input('Ingrese los valores en y []: ');


A=vander(x);
A=fliplr(vander(x));
C=(inv(A))*(y');
C=C';
fprintf('Matriz Vandermonde: \n');
disp(A);
fprintf('Coeficientes Interpolacion: \n');
disp(C);
