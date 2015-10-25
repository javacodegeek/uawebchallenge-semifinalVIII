package uawebchallenge.semifinalviii

class Lending {

    Integer userId
    String name
    String projectLink
    String cssStyle
    String page
    String token
    Integer needMoney = 0
    Integer totalMoney = 0
    Date dateCreated = new Date()
    Date dateModified = new Date()

    static constraints = {
        userId(nullable: false, blank: false)
        name(nullable: false, blank: false)
        projectLink(nullable: true, blank: true)
        cssStyle(nullable: true, blank: true)
        page(nullable: true, blank: true)
        token(nullable: false, blank: false)
        needMoney(nullable: false, blank: false)
        totalMoney(nullable: false, blank: false)
        dateCreated(nullable: false, blank: false)
        dateModified(nullable: false, blank: false)

    }

    static mapping = {
        version false
        userId column: 'user_id'
        name column: 'name'
        projectLink column: 'project_link'
        cssStyle column: 'css_style', sqlType: "Text"
        page column: 'page', sqlType: "Text"
        token column: 'token'
        needMoney column: 'need_money'
        totalMoney column: 'total_money'
        dateCreated column: 'date_created'
        dateModified column: 'date_modified'
    }
}
