package method.chaining

class MailerNew {
    def to(addr) { println('to...') }
    def from(addr) { println('from...') }
    def sub(subject) { println('subject...') }
    def body(msg) { println('body...') }
    def static send(props) {
        MailerNew mailer = new MailerNew()
        mailer.with props
        println('sending...')
    }
}

MailerNew.send {
    to 'vip@noname.com'
    from 'noname@vip.com'
    sub 'Important issue'
    body '...message...'
}