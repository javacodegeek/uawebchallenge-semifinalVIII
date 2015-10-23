package uawebchallenge.semifinalviii

class Registration {

    Integer userId
    String description
    String token
    Date dateCreated = new Date()
    Date dateModified = new Date()


    static constraints = {
        userId(nullable: false, blank: false)
        description(nullable: true, blank: true)
        token(nullable: false, blank: false)
        dateCreated(nullable: false)
        dateModified(nullable: false)

    }

    static mapping = {
        version false
        userId column: 'user_id'
        description column: 'description'
        token column: 'token'
        dateCreated column: 'date_created'
        dateModified column: 'date_modified'
    }
}
