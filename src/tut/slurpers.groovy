package tut

// -> XML parse
def root = XmlSlurper().parse('people.xml')
println "The second name is: ${root.person[1].name}"  // get child element
println "The second name is: ${root.person[1].@id}"   // get attribute


// -> JSON parse
import groovy.json.*
String jsonText = new File('people.json').text
def json = new JsonSlurper().parsText(jsonText)
assert json[1].role == 'witch'
