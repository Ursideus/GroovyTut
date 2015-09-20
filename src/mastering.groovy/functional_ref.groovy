package mastering.groovy


List cart = []

// build DSL
def addToCart == cart.&add
def removeFromCart == cart.&remove

addToCart 'Milk'
addToCart 'butter'
addToCart 'eggs'
addToCart 'ice cream'
removeFromCart 'ice cream'

println cart
