package mastering.groovy

// Traits can have properties
trait Named {
  String name
}

class NamedPerson implements Named {}

def person = new NamedPerson(name: 'Dan')

assert person.name == 'Dan'
assert person.getName() == 'Dan'

// Multiple traits
trait Flying {
  String fly() { 'I am flying' }
}

trait Speaking {
  String speak() { 'I am Speaking' }
}

class Duck implements Flying, Speaking {}

def duck = new Duck()
assert duck.fly() == 'I am flying'
assert duck.speak() == 'I am Speaking'

// resolve conflicts
trait A {
  String exec { 'A' }
}

trait B {
  String exec { 'B' }
}

class C implements A, B {}

class D implements A, B {
  // override W/ custom implementation
  String exec() {
    A.super.exec()
  }
}
