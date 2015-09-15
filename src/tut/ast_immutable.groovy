package tut

import groovy.transform.Immutable


@Immutable
class Point {
  BigDecimal x
  BigDecimal y
}



Point p1 = new Point(x: 5.0, y: 3.5)  // Map based constructor
Point p2 = new Point(2.0, 4.0)        // Tupel constructor

def xValue = p1.@x                    // Access private value directly (not getter)
