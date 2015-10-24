package uawebchallenge.semifinalviii

import grails.converters.JSON

class AuthController {

    RegistrationService registrationService

    def signup() {
       response.setHeader("Access-Control-Allow-Origin", "*");
       try {
            if(params.name && params.email && params.password && params.confirmPassword && params.category) {
                def isExist = User.findByEmail(params.email)
                if (!isExist){
                    def user = new User (name: params.name, email: params.email, password: params.password.encodeAsMD5().toString(), status: User.STATUS_WAITING_CONFIRMATION_EMAIL, category: (params.category == 'individual')?User.CATEGORY_INDIVIDUAL:User.CATEGORY_ENTITY ).save(flush: true, failOnError: true)
                    registrationService.create(user.id.toInteger(), user.email, user.name)
                    render(status: 200, contentType: "text/json", text: [status: "success", data: user, message: ""] as JSON)
                }else {
                    response.setHeader("Access-Control-Expose-Headers", "error");
                    response.setHeader("error",([message: "User with this email already exists!"] as JSON).toString());
                    render(status: 415, contentType: "text/json", text: [status: "error", data: "", message: "User with this email already exists!"] as JSON)
                }

            }else {
                render(status: 415, contentType: "text/json", text: [status: "error", data: "", message: "Not enough parameters!"] as JSON)
            }
        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some internal error happened on server!"] as JSON)
        }
    }

    def signin() {
        println params
        request.contentType
        response.setHeader("Access-Control-Expose-Headers", "keys");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "PUT");
        response.setHeader("keys","rewrwrwe");
        //response.setHeader("keys",([userId: 2, secret: "23fgkgzg7"] as JSON).toString());
        render(status: 200, contentType: "text/json", text: [status: "success", data: "", message: ""] as JSON)
    }

}
