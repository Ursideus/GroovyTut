package strategy

def calculatePricesTotal(prices, selector) {
    def total = 0
    for (price in prices) {
        if (selector(price))
            total += price
    }
    total
}

def calcPricesTotal(Collection prices,  selector) {
    def total = 0
    prices.collect { price ->
        if (selector(price))
            total += price
    }
    total
}

def prices = [10, 20, 30, 35, 40, 45, 50]

println calculatePricesTotal(prices) { true } //Total all Prices
println calcPricesTotal(prices) { true } //Total all Prices

println calculatePricesTotal(prices) { it > 35 } //Total only prices > 35
println calcPricesTotal(prices) { it > 35 } //Total only prices > 35

println calculatePricesTotal(prices) { it < 35 } //Total only prices < 35
println calcPricesTotal(prices) { it < 35 } //Total only prices < 35
