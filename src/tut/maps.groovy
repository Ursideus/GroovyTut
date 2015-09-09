package tut

def map = [a:1, b:2, 'c':3]
map.put('c', 4)
map['e'] = 65
map.f = 7
println map
//-> would cause Exception since, dot overloaded to get by key
//println map.class.name
println map.getClass().name



