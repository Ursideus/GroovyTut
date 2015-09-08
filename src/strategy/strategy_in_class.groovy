package strategy

class Equipment {
    def calculator

    Equipment(calc) {
        calculator = calc
    }

    def calculate() {
        println('Running calculate()')
        calculator()
    }
}

def eq1 = new Equipment({ println('calculator 1') })

eq1.calculate()

def anotherCalculator = {
    println('another calculator')
}

def eq2 = new Equipment(anotherCalculator)
def eq3 = new Equipment(anotherCalculator)

eq2.calculate()
eq3.calculate()
