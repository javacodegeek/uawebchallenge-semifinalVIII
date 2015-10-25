package uawebchallenge.semifinalviii

class Ubbcache {

    String name
    String projectLink
    String data
    Date dateCreated = new Date()
    Date dateModified = new Date()

    static constraints = {
        name(nullable: false, blank: false)
        projectLink(nullable: false, blank: false)
        data(nullable: true, blank: true)
        dateCreated(nullable: false, blank: false)
        dateModified(nullable: false, blank: false)
    }

    static mapping = {
        name column: 'name'
        projectLink column: 'project_link'
        data column: 'data', sqlType: "Text"
        dateCreated column: 'date_created'
        dateModified column: 'date_modified'
    }
}
