package tut

List nums = [1, 2, 3, 4, 5, 6, 7]

nums.each {
    println it
}
nums.eachWithIndex { int entry, int idx ->
    println "nums[$idx]== $entry"
}

Map map = [a: 1, b: 2, c: 3]
map.each {
    println "m[${it.key}]==${it.value}"
}
map.each { k, v ->
    println "m[$k]==$v"
}

20.downto(3) { println it }




















