package uawebchallenge.semifinalviii

class Registration {

    Integer userId
    String description
    Date dateCreated = new Date()
    Date dateModified = new Date()


    static constraints = {
        userId(nullable: false, blank: false)
        description(nullable: true, blank: true)
        dateCreated(nullable: false)
        dateModified(nullable: false)

    }

    static mapping = {
        version false
        userId column: 'user_id'
        description column: 'description'
        dateCreated column: 'date_created'
        dateModified column: 'date_modified'
    }
}
