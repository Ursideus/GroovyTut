package tut

// Java static method to groovy instance method
println Math.abs(-4)  // the "Java way", static method
println ((-4).abs())  // the "groovy way", instance method

// Encoding
String encodedStr = 'abcde'.bytes.encodeBase64()   // bytes runs methos getBytes()
new String(encodedStr.decodeBase64())

// capitalize string
String str = 'this is a string'
str.split()*.capitalize().join(' ')  // star is spread operator/'for each'
