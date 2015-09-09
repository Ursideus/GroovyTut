package tut

import java.awt.List

def map = [a:1, b:2, 'c':3]
map.put('c', 4)
map['e'] = 65
map.f = 7
println map
//-> would cause Exception since, dot overloaded to get by key
//println map.class.name
println map.getClass().name


def nums = [1, 2, 3, 4, 5, 6, 7, 8] as LinkedList
println nums
println nums.class.name

def otherNums = [8, 7, 6, 5, 4, 3, 2, 1] as SortedSet
println otherNums
println otherNums.class.name

def strings = 'this is a list of strings'.split()
println strings
println strings.class.name

//List strs = 'this is a list of strings'.split()
//println strs
//println strs.class.name

List otherOtherNums = [1, 2, 3, 4, 5, 6, 7, 8, 'abc']
println otherOtherNums
println otherOtherNums.class.name
