package delegation

class Worker {
    def work() { println('working...') }
}

class ExpertWorker {
    def work() { println('expert working...') }
    def analyze() { println('expert analyzing') }
}

class Manager {
    @Delegate Worker worker = new Worker()
    @Delegate ExpertWorker expert = new ExpertWorker()
}

def manager = new Manager()
manager.work()
manager.analyze()
