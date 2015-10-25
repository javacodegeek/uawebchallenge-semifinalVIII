package uawebchallenge.semifinalviii

import grails.transaction.Transactional
import grails.util.Holders as CH

@Transactional
class LendingService {

    def getLendingLink(Integer lendingId) {
        def lending = Lending.get(lendingId)
        if(lending){
            def link = CH.config.domain + /lending/ + lending.token
                return link
        }else{
            return false
        }
    }
}
