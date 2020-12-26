function [y] = MetodoBiseccion(f,a,b,tolerancia)
%Calcula Metodo Biseccion
cc=zeros(1,10);
ccfuncion=zeros(1,10);
e=100;
k=1;
contador=0;
while tolerancia<e
    c=(a+b)/2;
    e=abs((b-a)/2);
    cc(k)=c;
    ccfuncion(k)=f(c);
    A(k,:)=[k a b c f(c) e];
    if f(a)*f(c)<0
        b=c;
    else
        a=c;
    end
    k=k+1;
end
disp('Iteracion en la que cumple la tolerancia:')
iteracion=k;
disp(iteracion)
for k=1:iteracion
    plot(cc,ccfuncion,'rx');
    grid on
    axis on
    drawnow
end

%fprintf('\t\tPROGRESIONES DE RAICES \n \t\tk \t\ta \t\tb \t\tc \t\tf(c) \t\terror \n')
%disp(A)
fprintf('Raiz por Metodo de Biseccion:\n c=%8.5f\n',c)
fprintf('f(c)=%8.5f\n',f(c))
fprintf('error=%8.5f\n',e)
end

