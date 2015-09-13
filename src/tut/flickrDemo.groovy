package tut

import groovy.json.*

String key = new File('flickr_key.txt').text
String endPoint = 'https://api.flickr.com/services/rest?'
def params = [ method: 'flickr.photo.search',
               api_key: key,
               format: 'json',
               tags: 'cat',
               nojsoncallback: 1,
               media: 'photos',
               per_page: 6 ]

// Build the url and download data
//def queryStr = params.collect { k,v -> "$k=$v" }.join('&')
def queryStr = params.collect { it }.join('&')
String jsonTxt = "$endPoint$queryStr".toURL().text

// Write json to File
File file = new File('cats.json')
if (file) file.delete()
file << JsonOutput.prettyPrint(jsonTxt)
println JsonOutput.prettyPrint(jsonTxt)
