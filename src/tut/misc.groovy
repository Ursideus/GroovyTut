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


