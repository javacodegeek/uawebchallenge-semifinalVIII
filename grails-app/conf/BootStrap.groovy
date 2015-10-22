import uawebchallenge.semifinalviii.User

class BootStrap {

    def init = { servletContext ->
       if(!User.count()){
           new User(name: "Evgeniy Safronov", email: "evgeniy.safronov@outlook.com", password: "202cb962ac59075b964b07152d234b70", status: User.STATUS_ACTIVE).save(flush: true, failOnError: true)
           new User(name: "Ivan Ivanov", email: "ivan.ivanov@outlook.com", password: "202cb962ac59075b964b07152d234b70", status: User.STATUS_ACTIVE).save(flush: true, failOnError: true)
           new User(name: "Petr Dementiev", email: "petr.dementiev@outlook.com", password: "202cb962ac59075b964b07152d234b70", status: User.STATUS_ACTIVE).save(flush: true, failOnError: true)
           new User(name: "Aragorn", email: "ara@outlook.com", password: "202cb962ac59075b964b07152d234b70", status: User.STATUS_ACTIVE).save(flush: true, failOnError: true)
       }
    }
    def destroy = {
    }
}
