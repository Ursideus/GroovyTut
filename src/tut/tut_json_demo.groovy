package tut

import groovy.json.JsonSlurper

String baseUrl = 'http://api.icndb.com/jokes/random?'
def queryString = [limotTo: '[nerdy]', firstName: 'Mr.', lastName: 'Big'].collect {
    k, v -> "$k=$v"
}.join('&')

def requestUrl = "$baseUrl$queryString"
String jsonResultTxt = requestUrl.toURL().text
def jsonResult = new JsonSlurper().parseText(jsonResultTxt)

println queryString
println jsonResult.value.joke