package mastering.groovy

// traits: like interface but with implementation
trait FlyingAbility {
  String fly() { 'I am flying' }
}

class Bird implements FlyingAbility {}

Bird bird = new Bird()
assert bird.fly() == 'I am flying'

// Trait with abstract method
trait Greetable {
  abstract String name()
  String greeting() { "Hellow, ${name()}!"}
}

class Person implements Greetable {
  String name() { 'Dan'}
}

Person pers = new Person()
assert pers.greeting() == 'Hellow, Dan'
