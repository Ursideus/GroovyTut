package functional

def ages = [1, 2, 3, 4, 5, 6]

def total = ages.inject(0, { carry, age -> carry + age })

println "Total is $total"


println ages.collect { it * 2 }
