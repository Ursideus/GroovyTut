package tut

List strings = 'this is a list of strings'.split()
println strings.count { it ==~ /\w{4}/ }   // candel operator
println strings.count { it =~ /\w{4}/ }    // fire cracker operator
