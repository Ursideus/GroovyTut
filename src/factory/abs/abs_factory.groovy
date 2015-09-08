package factory.abs

class Book {
    String title
    int pages
}

class CD {
    String title
    int volume
}

def create(klass, properties) {
    def instance = klass.newInstance()
    properties.each { name, value ->
        instance."$name" = value
    }
    instance
}

println create(Book, [title: 'who am I' , pages: 96]).dump()
println create(CD, [title: 'Play on', volume: 2]).dump()