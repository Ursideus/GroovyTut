package mastering.groovy

trait Extra {
    String extra() { 'I am extra method' }
}

class Something {
    String doSomething() { 'something' }
}

def someThing = new Something() as Extra
assert someThing.doSomething() == 'something'
assert someThing.extra() == 'I am extra method'

// Multiple traits at runtime
trait T1 {
    String methodT1() { 'method T1' }
}

trait T2 {
    String methodT2() { 'method T2' }
}

class MyClass {}

def myClass = new MyClass()
def myClassWithTraits = myClass.withTraits(T1, T2)

assert myClassWithTraits.methodT1() == 'method T1'
assert myClassWithTraits.methodT2() == 'method T2'

println myClass.class.name
println myClassWithTraits.class.name



