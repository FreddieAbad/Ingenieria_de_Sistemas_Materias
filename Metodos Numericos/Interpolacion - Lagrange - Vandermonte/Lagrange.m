format short;
%x=[1 4 9];
%y=[4 -1 -8];
x=input('Ingrese el vector de valores de X [] : ');
y=input('Ingrese el vector de valores de Y [] : ');
n1=length(x);
n=n1-1;
L=zeros(n1,n1);
for k=1:n+1
    V=1;
    for j=1:n+1
        if k~=j;
            V=conv(V,poly(x(j)))/(x(k)-x(j));
        end
    end
    L(k,:)=V;
end
C=y*L;
fprintf('\nVector de Coeficientes de Interpolacion\n');
disp(C);