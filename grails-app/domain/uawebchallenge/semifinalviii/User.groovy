package uawebchallenge.semifinalviii

class User {

    String identifier;
    String name
    String description
    String email
    Date dateCreated = new Date()
    Date dateMofified = new Date()

    static constraints = {
        identifier(nullable: false, unique: true)
        name(nullable: false, blank: false)
        description(nullable: true, blank: true)
        email(nullable: false, blank: false, unique: true)
        dateCreated(nullable: false)
        dateMofified(nullable: false)
    }

    static mapping = {
        version false
        identifier column: 'identifier', index: 'User_identifier_Idx'
        name column: 'name'
        description column: 'description'
        email column: 'email'
        dateCreated column: 'date_created'
        dateMofified column: 'date_modified'
    }

}


