package uawebchallenge.semifinalviii

class User {

    String name
    String description
    String email
    Date dateCreated = new Date()
    Date dateMofified = new Date()

    static constraints = {
        name(nullable: false, blank: false)
        description(nullable: true, blank: true)
        email(nullable: false, blank: false, unique: true)
        dateCreated(nullable: false)
        dateMofified(nullable: false)
    }

    static mapping = {
        version false
        name column: 'name', index: 'User_name_Idx'
        description column: 'description'
        email column: 'email'
        dateCreated column: 'date_created'
        dateMofified column: 'date_modified'
    }

}


