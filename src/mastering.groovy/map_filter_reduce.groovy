package mastering.groovy

List nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]

assert 36 == nums.collect { it * 2 }          // Map
                 .findAll { it % 3 == 0 }     // Filter
                 .sum()                       // Reduce

List cities = ['Boston', 'New York', 'London', 'Hyderabad']

assert cities.collect { String it -> it.toUpperCase() }  // Explicit argument type
             .sort()                       // sort by lexical
             .join(', ') == 'BOSTON, HYDERABAD, LONDON, NEW YORK'

println cities.collect { it.toUpperCase() }
        .sort( { it.size() })               // sort by size
        .join(', ') == 'BOSTON, HYDERABAD, LONDON, NEW YORK'
