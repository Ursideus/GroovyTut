package mastering.groovy

// Java 8 functional Interfaces
// Interface Consumer<T> : Method accept(T t)
// Interface Supplier<T> : Method get()
// Interface Predicate<T> : Methods isEqual(Object targetRef), negate(), or(Predicate<? super T> other), test(T t)

// define closure
def add = { x, y -> x + y}

assert add.call(3,4) == 7
assert add(3,4) == 7
assert add('abc', 'def') == 'abcdef'

Date now = new Date()
Date then = add(now + 3)
assert then - now == 3

// Define a closure w/ variable number of untyped args
def addAll = { ... values -> values.sum() }  // a collection of arguments

assert addAll(1, 2, 3) == 6
assert addAll('a', 'b') == 'ab'

// add default args
def mult = { x, y=3 -> x * y }

assert mult(3, 4) == 12
assert mult(3) == 9

// curry
def add3 = add.curry(3)  // replace leftmost var with constant
assert add3(4) == 7

def times2 = mult.rcurry(2)  // replace rightmost var with constant
assert times2(2) == 4
assert times2('abc') == 'abcabc'

