package tut

class Person {
    String first
    String last
}

Person pers = new Person()
pers.first = 'Mr'
pers.setLast('Big')

println("${pers.getFirst()} ${pers.getLast()}")

Person otherPers = new Person(first: 'No', last: 'Body')

println("${otherPers.getFirst()} ${otherPers.getLast()}")

