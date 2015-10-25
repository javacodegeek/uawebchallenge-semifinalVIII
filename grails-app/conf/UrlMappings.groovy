class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

       // "/"(redirect: "/theme.html/#/theme")
        "500"(view:'/error')

        def apiVersion = "v1"

        name restEntityList: "/api/$apiVersion/$controller"(parseRequest: true) {
            action = [GET: "list", POST: "save"]
        }

        name restEntity: "/api/$apiVersion/$controller/$id"(parseRequest: true) {
            action = [GET: "show", PUT: "update", POST: "update", DELETE: "delete"]
            constraints {
                id matches: /\d+/
            }
        }





        "/api/auth/registration"(controller: "auth", action: "signup")
        "/api/auth/login"(controller: "auth", action: "signin")
        "/api/auth/getSecret"(controller: "auth", action: "getSecret")

        "/api/$apiVersion/getprojectmoney"(controller: "lending", action: "ubbProjectData")
        "/api/$apiVersion/lending/link"(controller: "lending", action: "getLink")




	}
}
