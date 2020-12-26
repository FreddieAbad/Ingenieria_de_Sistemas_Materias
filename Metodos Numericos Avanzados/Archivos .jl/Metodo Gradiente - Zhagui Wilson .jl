using Gadfly
using Distributions
using Colors

function df(x, y, b)
    sum(- (y - x*b)' * x)
end

function metodogradiente()
   rnorm = Normal()
   x = rand(rnorm, 100)
   y = x * 2 + rand(rnorm, 100)
   b    = 0.0
   bold = 1.0
   bvals = Float64[]
   while (sum(abs(b - bold)) > 1e-10)
       push!(bvals, b)
       bold = b
       der = df(x, y, bold)
       b   =  b - 0.001 * der
   end
   plot(Guide.title("Valor Real: 2, Valor Aproximado: " * string(b)),
        layer(x=x, y=y, Geom.point()),
        layer(x=x,y=x*bvals[1], Geom.line()),
        layer(x=x,y=x*bvals[5], Geom.line()),
        layer(x=x,y=x*b, Geom.line()))
end

metodogradiente()

#Costo Computacional
@time metodogradiente();

using Optim, Base.MathConstants
f(x) = (x[1] - 1) * (x[1] - 1) * e^(-x[2]^2) + x[2] * (x[2] + 2) * e^(-2 * x[1]^2)
println(optimize(f, [0.1, -1.0], GradientDescent()))

#Costo Computacional
@time GradientDescent();


