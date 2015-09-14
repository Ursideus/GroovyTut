package tut

import java.text.NumberFormat

Number.metaClass.asCurrency = { ->
  NumberFormat numFormat = NumberFormat.getCurrencyInstance()
  numFormat.format(delegate)
}

Number.metaClass.asCurrency = { Locale locale ->
  NumberFormat numFormat = NumberFormat.getCurrencyInstance(locale)
  numFormat.format(delegate)
}

def amount  = 123456.7890
Locale.default = Locale.US
assert amount.asCurrency()
println amount.asCurrency()

// ->

class CurrencyCategory {
  static String asCurrency(Number amount) {       // argument
    NumberFormat.currencyInstance.format(amount)
  }

  static String asCurrency(Number amount, Locale locale) {
    NumberFormat.currencyInstance(locale).format(amount)
  }

}

use(CurrencyCategory) {       // asCurrency() method only exista in the closure
  def amount = 123456.7890
  println amount.asCurrency()
  println amount.asCurrency(Locale.FRANCE)
  println amount.asCurrency(new Locale('da', 'KD'))
}
