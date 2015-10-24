package uawebchallenge.semifinalviii

import grails.transaction.Transactional
import grails.converters.JSON


@Transactional
class UserService {

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
