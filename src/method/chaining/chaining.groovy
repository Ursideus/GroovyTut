package method.chaining

class Mailer {
    def to(addr) { println('to...'); this }
    def from(addr) { println('from...'); this }
    def subject(subject) { println('subject...'); this }
    def body(msg) { println('body...'); this }
    static def send() { println('sending...'); }
}


// Chaining
new Mailer()
        .to('someone@bigsite.com')
        .from('me2@smallsite.com')
        .subject('very important issue')
        .body('...long text...')
        .send()



