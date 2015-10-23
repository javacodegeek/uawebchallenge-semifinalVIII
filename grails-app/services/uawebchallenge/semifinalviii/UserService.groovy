package uawebchallenge.semifinalviii

import grails.transaction.Transactional


@Transactional
class UserService {

    def signin(String email, String password) {
        User.findByEmail(email)
        if(User){
            if(User.password == password.encodeAsMD5().toString()){
                return User
            }else {
                return false
            }
        }else {
            return false
        }
    }
}
