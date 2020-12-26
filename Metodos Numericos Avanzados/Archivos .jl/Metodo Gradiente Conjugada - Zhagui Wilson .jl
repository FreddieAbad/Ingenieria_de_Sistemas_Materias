using LinearAlgebra
using Optim
f(x) = (1.0 - x[1])^2 + 100.0 * (x[2] - x[1]^2)^2
function g!(storage, x)
    storage[1] = -2.0 * (1.0 - x[1]) - 400.0 * (x[2] - x[1]^2) * x[1]
    storage[2] = 200.0 * (x[2] - x[1]^2)
end

optimize(f, g!, zeros(2), ConjugateGradient())

#Costo Computacional
@time optimize(f, g!, zeros(2), ConjugateGradient());
