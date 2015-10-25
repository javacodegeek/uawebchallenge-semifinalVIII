package uawebchallenge.semifinalviii

import grails.transaction.Transactional

@Transactional
class UbbcacheService {

    def set(String link, String data) {
        def ubbcache = Ubbcache.findByProjectLink(link)
        if(!ubbcache){
            new Ubbcache(name: "UBB_CACHE_LINK_DATA", data: data, projectLink: link).save(flush: true, failOnError: true)
                return true
        }else {
            ubbcache.dateModified = new Date()
            ubbcache.data = data
            ubbcache.save(flush: true, failOnError: true)
                return true
        }
    }


    def get(String link) {
        def ubbcache = Ubbcache.findByProjectLink(link)
        if(ubbcache){
            return ubbcache?.data
        }else {
            return false
        }
    }

    def invalidate(String link){
        def ubbcache = Ubbcache.findByProjectLink(link)
        if(ubbcache){
            ubbcache.delete()
            return true
        }else {
            return false
        }
    }

}
