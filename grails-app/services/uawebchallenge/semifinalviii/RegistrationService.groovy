package uawebchallenge.semifinalviii

import grails.transaction.Transactional

@Transactional
class RegistrationService {

    EmailService emailService

    def create(Integer userId,  String userEmail, String userName) {
        try {
            def Registration = new Registration(userId: userId, description: "", token: new Date().getTime().encodeAsMD5().toString()).save(flush: true, failOnError: true)
            emailService.send("Administration <info@uwcua.com>", userEmail, "Registration confirmation", "Hello $userName, you registrated on landing constructor site. Thank you.")
            return Registration
        }catch(Exception e){
            return false
        }
    }

}
