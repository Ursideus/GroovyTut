package mastering.groovy

import jdk.nashorn.internal.ir.annotations.Immutable

// Define immutable class
@Immutable class Customer {
    String first, last
    int age
    Date since
    Collection favItems
}

def now = new Date()
def cust1 = new Customer(first: 'Some', last: 'Name', age: 15, since: now, favItems: ['Books', 'Games'])
def cust2 = new Customer('Some', 'Name', 15, now, ['Books', 'Games'])
assert  cust1 == cust2

def nums = [3, 1, 4, 1, 5, 9, 2, 6, 5] as SortedSet
// Create immutable collection on creation
def immutableNums = nums.asImmutable()
immutableNums << [7, 8]
immutableNums << 7