package uawebchallenge.semifinalviii

import grails.converters.JSON


class UserController {

    RegistrationService registrationService
    UserService userService

    def index() { }


    def list() {
        def list = User.list()
        try {
            render(status: 200, contentType: "text/json", text: [status: "success", data: list, message: ""] as JSON)
        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some internal error happened on server!"])
        }
    }

    def save() {
        try {
            def params = request.JSON
            if(params.name && params.email && params.password) {
                def isExist = User.findByEmail(params.email)
                if (!isExist){
                    def user = new User (name: params.name, email: params.email, password: params.password.encodeAsMD5().toString(), status: User.STATUS_WAITING_CONFIRMATION_EMAIL, description: params.description).save(flush: true, failOnError: true)
                    registrationService.create(user.id.toInteger(), user.email, user.name)
                    render(status: 201, contentType: "text/json", text: [status: "success", data: user, message: ""] as JSON)
                }else {
                    render(status: 409, contentType: "text/json", text: [status: "error", data: "", message: "User with this email already exists!"] as JSON)
                }

            }else {
                render(status: 400, contentType: "text/json", text: [status: "error", data: "", message: "Not enough parameters!"] as JSON)
            }
        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some internal error happened on server!"] as JSON)
        }

    }

    def show() {
        try {
            def user = User.get(params.id)
            if(user){
                render(status: 200, contentType: "text/json", text: [status: "success", data: user, message: ""] as JSON)
            } else {
                render(status: 404, contentType: "text/json", text: [status: "error", date: "", message: "User not fount by id!"] as JSON)
            }

        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some internal error happened on server!"])
        }
    }

    def update() {
         try {
             def user = User.get(params.id)
             if(user){
                 if (request.JSON.name){ user.name = request.JSON.name}
                 if (request.JSON.email){ user.name = request.JSON.email}
                 if (request.JSON.password){ user.name = request.JSON.password}
                 if (request.JSON.description){ user.name = request.JSON.description}
                 if (request.JSON.status){ user.name = request.JSON.status}
                  user.dateMofified = new Date()
                    user.save(flush: true, failOnError: true)
                 render(status: 202, contentType: "text/json", text: [status: "success", data: user, message: "User updated!"] as JSON)
             } else {
                 render(status: 404, contentType: "text/json", text: [status: "error", data: "", message: "User not fount by id!"] as JSON)
             }
         }catch(Exception e) {
             render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some internal error happened on server!"])
         }
    }

    def delete() {
        try {
            def user = User.get(params.id)
            if(user){
                user.delete(flush: true)
                render(status: 202, contentType: "text/json", text: [status: "success", data: "", message: "User deleted!"] as JSON)
            } else {
                render(status: 404, contentType: "text/json", text: [status: "error", data:"", message: "User not fount by id!"] as JSON)
            }
        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some internal error happened on server!"])
        }
    }

    def signin() {
        try {
            def params = request.JSON

            if(params.email && params.password){
                def signinUser = userService.signin(params.email, params.password)
                if(signinUser) {
                    render(status: 200, contentType: "text/json", text: [status: "success", data: "", message: "User signin in system!"] as JSON)
                }else{
                    render(status: 403, contentType: "text/json", text: [status: "error", data: "", message: "Wrong password or email!"] as JSON)

                }
            }else{
                render(status: 400, contentType: "text/json", text: [status: "error", data: "", message: "Not enough parameters!"] as JSON)
            }

        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some internal error happened on server!"])
        }
    }

}
