package tut

public interface Account {
    double deposit(BigDecimal amount);
    double withdraw(BigDecimal amount);
    double getBalance();
    Integer getId();
}

import groovy.transform.Canonical

@Canonical
class GroovyAccount implements Account {
    Integer Id
    BigDecimal balance

    double deposit(BigDecimal amount) {
        balance += amount
    }

    double withdraw(BigDecimal amount) {
        deposit(-amount)
    }

    double getBalance() { balance }
}

// Tuple constructor
def gAccount = new GroovyAccount(10, 0)
gAccount.deposit(100)
// Map based constructor
def otherAccount = new GroovyAccount(Id: 111, balance: 50)
otherAccount.deposit(30)
