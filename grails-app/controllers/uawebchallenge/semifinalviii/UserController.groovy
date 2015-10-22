package uawebchallenge.semifinalviii

import grails.converters.JSON


class UserController {

    def index() { }

    def save() {

    }

    def list() {
        def list = User.list()
        try {
            render(status: 200, contentType: "text/json", text: [status: "success", data: list] as JSON)
        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", message: "Some internal error happened on server!"])
        }
    }
}
