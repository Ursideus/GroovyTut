package tut

List numbs = [3, 1, 4, 1, 5, 9]
def res = numbs.collect { it * 2 }       // Map
        .findAll { it % 3 == 0 }  // Filter
        .sum()                   // Reduce
println("Map/R res==$res")

// OR
// Apply to each element
println(numbs*.floatValue())

