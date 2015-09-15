package tut

println 'Sum numbers with looping, enter numbers'
System.in.eachLine { line ->
  if (!line) System.exit(0)
  println line.split()*.toBigDecimal().sum()
}
