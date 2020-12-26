x=-10:1:20;
f=(x.^2)-15;
plot(x,f);
grid on
axis on

a=input('Introduzca el valor de a: ');
b=input('Introduzca el valor de b: ');
cont=input('Introduzca la tolerancia: ');

drawnow
pause(0.3);
MetodoBiseccion(inline('x^2-15'),a,b,cont);