package uawebchallenge.semifinalviii

import grails.converters.JSON

class LendingController {

    def list() {
        try {
            def list = Lending.list()
            render(status: 200, contentType: "text/json", text: [status: "success", data: list, message: ""] as JSON)
        }catch (Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some error happened on server!"] as JSON)

        }
    }

    def save() {
        if(params.userId && params.name && params.token) {
              def Lending = new Lending(userId: params.userId,
                                        name: params.name,
                                        projectLink: params.projectLink,
                                        cssStyle: params.cssStyle,
                                        page: params.page,
                                        token: new Date().getTime().encodeAsMD5().toString()).save(flush: true, failOnError: true)
            render(status: 200, contentType: "text/json", text: [status: "success", data: Lending, message: ""] as JSON)
        }else{
            render(status: 400, contentType: "text/json", text: [status: "error", data: "", message: "Not enough params!"] as JSON)
        }
    }

    def show() { }

    def update() { }

    def delete() { }
}
