package tut

import java.util.logging.Logger

import groovy.transform.InharitConstructors
import java.util.logging.Level

// Extend the level type
@InheritConstructors
class CustomLevel extend Level {
}

// the interception method
Logger.metaClass.methodMissing = { String name, args ->
  println "inside methodMissing with $name"
  int val = Level.WARNING.intValue() +
                  (Level.SEVERE.intValue() - Level.WARNING.intValue()) * Math.random()
  def level = new CustomLevel(name.toUpperCase(), val)
  def impl = { Object... varArgs ->
    delegate.log(level, varArgs[0])
  }
  Logger.metaClass."$name" = impl   // hot wire implementation
  impl(args)
}

// test interceptor method
Logger log = Logger.getLogger(this.class.name)
log.wtf 'no effin way'
log.whoa 'really, dude'
log.rofl "you'r kidding"
log.whatever 'whatever'


// -> simple Decorator kind of meta class
Logger.metaClass.fyi = { msg -> delegate.info msg }
Logger.metaClass.omg = { msg -> delegate.severe msg }

Logger log = Logger.getLogger(this.calsss.name)
log.fyi 'fyi message'
log.omg 'omg message'
