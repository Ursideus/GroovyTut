package tut

String baseUrl = 'https://maps.googleapis.com/maps/api/geocode/xml?'
def encodedAddress = ['125 Main', 'Big City', 'NA'].collect {
    URLEncoder.encode(it, 'UTF-8')
}.join(',')

def queryStr = "address=$encodedAddress"
def requestUrl = "$baseUrl$queryStr"
def result = requestUrl.toURL().text
def root = new XmlSlurper().parse(requestUrl)
def location = root.result[0].geometry.location

println encodedAddress
println requestUrl
println result
println "${location.lat},${location.lng}"