package tut

class Department {
    Manager boss
}

class Manager {
    String name
}

def dep = new Department(boss: new Manager(name: "Mr. Big"))
def emptyDep = new Department()

println dep?.boss?.name
// -> with NPE guard
// Safe navigation , if not null
println emptyDep?.boss?.name


// -> Spaceship operator
def x = 3
def y = 7
def z = 11

println x <=> y
println z <=> z
println z <=> x

// -> Elvis operator
class User {
    String name
}

def user = new User()

displayName = user.name ? user.name : 'Anonymous'
// -> Instead use Elvis operator
displayName = user.name ?: 'Anonymous'
