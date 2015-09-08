package functional

def factorial(n) {
    (1..n).inject(1) { fact, e -> fact * e }
}

println factorial(17)


