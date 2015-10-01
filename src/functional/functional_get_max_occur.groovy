
def myCollection = [0, 3, 1, 3, 4, 10, 3, 7, 2, 3, 11, 3]
def myMap = [0:1, 3:5, 1:1, 4:1, 10:1, 7:1, 2:1, 11:1]
def id = 10
def Map collectionToMap(coll) {
    coll.collectEntries{[it, it]}
}

Map funcCollToMap(coll) {
    coll.inject([:]) {map, item -> map['item'] ? map.item.value = map['item'].value + 1 : map << [(item): 1]}
}

//println collectionToMap( myCollection )
//println funcCollToMap( myCollection )
//println myCollection.countBy { it }
//println myCollection.countBy { it }.max { it.value }
println myMap[id]
