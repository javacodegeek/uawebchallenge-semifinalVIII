package uawebchallenge.semifinalviii

import grails.transaction.Transactional

@Transactional
class AuthServerService {

    RegistrationService registrationService

    def signup(String name, String email, String password) {
        try {
                def isExist = User.findByEmail(email)
                if (!isExist){
                    def user = new User (name: name, email: email, password: password.encodeAsMD5().toString(), status: User.STATUS_WAITING_CONFIRMATION_EMAIL).save(flush: true, failOnError: true)
                    registrationService.create(user.id.toInteger(), user.email, user.name)
                    return user
                }else {
                        return false
                }

        }catch(Exception e) {
                return false
        }
    }
}
