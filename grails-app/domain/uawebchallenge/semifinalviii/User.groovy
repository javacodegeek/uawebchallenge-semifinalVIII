package uawebchallenge.semifinalviii

class User {

    public static final  Integer STATUS_ACTIVE = 1
    public static final  Integer STATUS_WAITING_CONFIRMATION_EMAIL = 1
    public static final  Integer STATUS_BLOCKED = 3
    public static final  Integer STATUS_DECLINE_CONFIRMATION_EMAIL = 4

    public static final  Integer CATEGORY_PERSONAL = 1
    public static final  Integer CATEGORY_organization = 2


    String name
    String description
    String email
    String password
    Date dateCreated = new Date()
    Date dateMofified = new Date()
    Integer status
    Integer category

    static constraints = {
        name(nullable: false, blank: false)
        description(nullable: true, blank: true)
        email(nullable: false, blank: false, unique: true)
        password(nullable: false, blank: false)
        dateCreated(nullable: false)
        dateMofified(nullable: false)
        status(nullable: false, blank: false)
        category(nullable: true, blank: true)

    }

    static mapping = {
        table "applicationuser"
        version false
        name column: 'name', index: 'User_name_Idx'
        description column: 'description'
        email column: 'email'
        password column: 'password'
        dateCreated column: 'date_created'
        dateMofified column: 'date_modified'
        status column: 'status'
        category column: 'category'

    }

}


