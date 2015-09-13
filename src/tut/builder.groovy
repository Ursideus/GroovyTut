package tut

//-> Build XML
def builder = new groovy.xml.MarkupBuilder()
builder.people {       // create element
    person(id: 1) {    // create attribute
        name: 'Buffy'  // create element
    }
    person(id: 2) {
        name: 'Willow'
    }
}


//-> Build JSON
import groovy.json.*

def jsonBuilder = new JsonBuilder()
jsonBuilder([name: 'Buffy', role: 'slayer'], [name: 'Willow', role: 'witch'])

println jsonBuilder.toString()
assert jsonBuilder.toString() == '[{"name":"Buffy","role":"slayer"},{"name":"Willow","role":"witch"}]'
