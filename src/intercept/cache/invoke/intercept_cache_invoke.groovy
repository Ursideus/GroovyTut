package intercept.cache.invoke

class Human {
    def activities = ['Football', 'Tennis']
    def methodMissing(String name, args) {
        println "intercepting $name"
        if (name.startsWith('play')) {
            def activity = name.split('play')[1]
            if (activities.contains(activity)) {
                def impl = { Object[] theArgs -> println "I like playing $activity" }
                getMetaClass()."$name" = impl
                return impl(args)
            }
        }
        throw new MissingMethodException(name, this.class, args)
    }
}

Human max = new Human()

max.playTennis()
max.playFootball()
max.playSnowball()