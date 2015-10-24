package uawebchallenge.semifinalviii

import grails.transaction.Transactional
import grails.converters.JSON


@Transactional
class UserService {

    def signin(String email, String password) {
        def user = User.findByEmail(email)
        if(user){
            if(user.password == password.encodeAsMD5().toString()){
                return user
            }else {
                return false
            }
        }else {
            return false
        }
    }

    def buidUserLess(User u){
        if(u instanceof User){
            def response = [:]
            response.id = u.id
            response.name = u.name
            response.email = u.email
            response.description = u.description
            response.dateCreated = u.dateCreated
            response.dateMofified = u.dateMofified
            return response
        }else{
            return []
        }

    }
}
