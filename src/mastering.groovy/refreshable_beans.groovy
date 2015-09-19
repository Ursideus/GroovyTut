import groovy.transform.CompileStatic

class MortgageApplication {
    BigDecimal amount
    BigDecimal rate
    int years
}

interface MortgageEvaluator {
    boolean approve(MortgageApplication mortgageApplication)
}

@CompileStatic
class GroovyEvaluator implements MortgageEvaluator {
    boolean approve(MortgageApplication mortgageApplication) {
        true
    }
}


class MortgageApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext('/src/main/resources/applicationContext.xml')
        MortgageEvaluator evaluator = null
        boolean ok

        for (int ii=0; ii < 10; ii++) {
            eval = (MortgageEvaluator) ctx.getBean('groovyEvaluator')
            ok = eval.approve(null)
            println ok ? 'approved': 'denied'

            try {
                Thread.sleep(1000)
            } catch (InterruptedException intException) {
                intException.printStackTrace()

            }
        }

        ((FileSystemXmlApplicationContext) ctx).close()
    }
}