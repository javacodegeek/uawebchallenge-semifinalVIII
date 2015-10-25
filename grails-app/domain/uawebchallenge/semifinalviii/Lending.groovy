package uawebchallenge.semifinalviii

class Lending {

    Integer userId
    String name
    String link
    String cssStyle
    String page
    String token
    Date dateCreated = new Date()
    Date dateModified = new Date()

    static constraints = {
        userId(nullable: false, blank: false)
        name(nullable: false, blank: false)
        link(nullable: true, blank: true)
        cssStyle(nullable: true, blank: true)
        page(nullable: true, blank: true)
        token(nullable: false, blank: false)
        dateCreated(nullable: false, blank: false)
        dateModified(nullable: false, blank: false)

    }

    static mapping = {
        version false
        userId column: 'user_id'
        name column: 'name'
        link column: 'link'
        cssStyle column: 'css_style', sqlType: "Text"
        page column: 'page', sqlType: "Text"
        token column: 'false'
        dateCreated column: 'date_created'
        dateModified column: 'date_modified'
    }
}
