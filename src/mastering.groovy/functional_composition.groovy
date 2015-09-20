package mastering.groovy

def add3 = { it + 3 }
def tims2 = { it * 2 }

def times3Add3 = add2 << times2

assert 13 == times3Add3(5)
assert 13 == add3(times2(5))
assert 13 == (times2 >> add3)(5) // revesrs composition

def add3times2 = times3 << add3
assert 16 == add3times2(5)
assert 16 == times2(add3(5))
