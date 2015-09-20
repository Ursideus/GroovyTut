package mastering.groovy

List nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]

assert nums.sum() ==
           // result of iteration is the next acc value
           // if has two arguments, firs is initial value for acc, second is the closure
           // if has only one argument, initial value is first from the collection
           nums.inject { acc, val ->
                acc + val
           }

List strings = 'this is a list of strings'.split()
List sorted = strings.sort(false)
println sorted
sorted.inject { prev, curr ->
    println "prev=$prev, curr=$curr"
    assert prev <= curr
    curr // the new prev
}
// w\ initial value
sorted.inject('') { prev, curr ->
    println "prev=$prev, curr=$curr"
    assert prev <= curr
    curr // the new prev
}