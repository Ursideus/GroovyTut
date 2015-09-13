package tut


Expando expando = new Expando()  // a basic class with no properties of methods
expando.name = 'Fido'            // Adds prop to instance
expando.speak = { "$name says woof" }  // Adds method to instance

expando.speak()


class Dog {}

Dog.metaClass.name = 'Phydeaux'  // Adds prop to metaClass
Dog.metaClass.speak = { msg = 'woof' -> "$name says $msg" }  // Adds method to metaClass with default value
Dog.metaClass.bark = { -> "$name says $msg" }  // Adds method to metaClass with no arguments

Dog dog = new Dog()
println dog.spaek()
dog.name = 'Rover'
println dog.spaek()
