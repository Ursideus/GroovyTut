package mastering.groovy

import java.util.stream.Stream

[3, 1, 4, 1, 5, 9].stream()
        .map( { it * 3 } )         // equivalent to groovy collect
        .filter( { it % 2 == 0 } ) //
        .forEach( { println it } ) // takes consumer lambda/closure


println Stream.generate(Math.&random)
        .limit(1000)
        .mapToInt( { (int) (it * 100) } )
        .filter( { it % 3 == 0} )
        .summaryStatistics()
