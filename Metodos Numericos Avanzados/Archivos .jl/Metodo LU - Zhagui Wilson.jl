#Librerias
using LinearAlgebra

#Generar Matrices Aleatorias
A = randn(10,10)
B = randn(100,100)
C = randn(1000,1000)
D = randn(10000,10000)

L,U,p = lu(A)
#Costo Computacional
@time lu(A);

function luDoolitle(A)
    L = zeros(size(A));
    U = zeros(size(A));
    n=size(A)
    filas = n[1]
    columnas = n[2];

    for j=1:columnas
      for i=1:filas

        if i<=j
          U[i,j] = A[i,j];
          for k=1:i-1
            U[i,j] = U[i,j] - L[i,k]*U[k,j];
          end
        end    

        if j<=i
          L[i,j] = A[i,j];
          for k=1:j-1
            L[i,j] = L[i,j] - L[i,k]*U[k,j];
          end
          L[i,j] = L[i,j]/U[j,j];
        end
      end
    end
    #Impresion de las Matrices Resultantes
    ##Agregar codigo impresion##
end

##Codigo Impresion
"""
    println("\n\tResultados\n\nMatriz L : \n");
    println(L);
    println("\nMatriz U : \n");
    println(U);
"""

#Costo Computacional
println("Costo Computacional - Algoritmo Implementado")
@time luDoolitle(A)
println("Costo Computacional - Funcion de Libreria")
@time lu(A)


#Tiempo de Ejecucion 
println("#Costo Computacional - Algoritmo Implementado")
@time luDoolitle(B)
println("#Costo Computacional - Funcion de Libreria")
@time lu(B)

#Costo Computacional
println("Costo Computacional - Algoritmo Implementado")
@time luDoolitle(C)
println("Costo Computacional - Funcion de Libreria")
@time lu(C)

#Costo Computacional
println("Costo Computacional - Algoritmo Implementado")
@time luDoolitle(D)
println("Costo Computacional - Funcion de Libreria")
@time lu(D)



function luCrout(A)
    L = zeros(size(A));
    u = zeros(size(A));
    nM=size(A);
    n = nM[1];
    m = nM[2];
    
    if n==m 
        for k=1:n
            u[k,k]=1; 
            suma=0;
            for p=1:k-1
                suma=suma+L[k,p]*u[p,k];
            end
            L[k,k]=A[k,k]-suma; 

            for i=k+1:n
                suma=0;
                for r=1:k-1
                    suma=suma+L[i,r]*u[r,k];
                end
                L[i,k]=A[i,k]-suma; 
            end
            for j=k+1:n
                suma=0;
                for s=1:k-1
                    suma=suma+L[k,s]*u[s,j];
                end
                u[k,j]=A[k,j]-suma/L[k,k]; 
            end
        end
        
    else
        println("\nLa matriz debe ser cuadrada para factorizar mediante LU Crout\n");
    end
end

##Codigo Impresion
"""
        println("Descomposicion Crout");
        println("\n Matriz L:\n")
        println(L)
        println("\n Matriz U:\n")
        println(u) 
"""

#Costo Computacional 
println("Costo Computacional - Algoritmo Implementado")
@time luCrout(A)
println("Costo Computacional - Funcion de Libreria")
@time lu(A)

#Costo Computacional 
println("Costo Computacional - Algoritmo Implementado")
@time luCrout(A)
println("Costo Computacional - Funcion de Libreria")
@time lu(A)

#Costo Computacional
println("Costo Computacional - Algoritmo Implementado")
@time luCrout(B)
println("Costo Computacional - Funcion de Libreria")
@time lu(B)

#Costo Computacional
println("Costo Computacional - Algoritmo Implementado")
@time luCrout(C)
println("Costo Computacional - Funcion de Libreria")
@time lu(C)

#Costo Computacional
println("Costo Computacional - Algoritmo Implementado")
@time luCrout(D)
println("Costo Computacional - Funcion de Libreria")
@time lu(D)


