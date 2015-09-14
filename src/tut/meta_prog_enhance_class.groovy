package tut

import static java.lang.Math.*

import spock.lang.Specification

def setupComplex () {
  Complex.metaClass.plus = { Complex complexNum -> delegate.add(complexNum) }
  Complex.metaClass.minus = { Complex complexNum -> delegate.subtract(complexNum) }
  Complex.metaClass.div = { Complex complexNum -> delegate.divide(complexNum) }
  Complex.metaClass.negative = { Complex complexNum -> delegate.negate(complexNum) }
  Complex.metaClass.power = { Complex complexNum -> delegate.pow(complexNum) }
  Double.metaClass.power = { Complex complexNum -> (new Complex(delegate, 0)).pow(complexNum) }
}

def 'minus method aliases to subtract'() {
  given:
  Complex first = new Complex(1.0, 3.0)
  Complex second = new Complex(2.0, 5.0)

  expect:
  new Complex(1.0, 2.0) == second - first

}
