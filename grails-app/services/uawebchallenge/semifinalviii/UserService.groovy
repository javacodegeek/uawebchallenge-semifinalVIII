package uawebchallenge.semifinalviii

import grails.transaction.Transactional
import grails.converters.JSON


@Transactional
class UserService {

    def signin(String email, String password) {
        def user = User.findByEmail(email)
        if(user){
            if(user.password == password.encodeAsMD5().toString()){
                println 788
                return user
            }else {
                return false
            }
        }else {
            return false
        }
    }
}
