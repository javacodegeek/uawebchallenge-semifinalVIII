package uawebchallenge.semifinalviii

class User {

    public static final  String STATUS_ACTIVE = 1
    public static final  String STATUS_WAITING_CONFIRMATION_EMAIL = 1
    public static final  String STATUS_BLOCKED = 3

    String name
    String description
    String email
    Date dateCreated = new Date()
    Date dateMofified = new Date()
    String status

    static constraints = {
        name(nullable: false, blank: false)
        description(nullable: true, blank: true)
        email(nullable: false, blank: false, unique: true)
        dateCreated(nullable: false)
        dateMofified(nullable: false)
        name(nullable: false, blank: false)

    }

    static mapping = {
        version false
        name column: 'name', index: 'User_name_Idx'
        description column: 'description'
        email column: 'email'
        dateCreated column: 'date_created'
        dateMofified column: 'date_modified'
        status column: 'status'

    }

}


