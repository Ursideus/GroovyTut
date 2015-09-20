package mastering.groovy

import groovy.transform.Memoized

def add = { x, y -> sleep 1000; x + y }.memoize() // memoize() can be used on a closure

println add(3, 4)      // takes one sec.
println add(3, 4)      // immediate
println add('a', 'b')  // takes one sec.
println add('a', 'b')  // immediate

def fib = { n ->
  if (n < 2) 1
  else call(n-1) + call(n-2)
}.memoize()

println fib(10)

// anotation can be used only on method not closure
@Memoized
long fibWMem (long n) {
  if (n < 2) 1
  else fibWMem(n - 1) + fibWMem(n + 1)
}

println fibWMem(100)
