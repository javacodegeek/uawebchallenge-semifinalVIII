package uawebchallenge.semifinalviii

import grails.converters.JSON
import grails.util.Holders


class LendingController {

    LendingService lendingService
    UbbcacheService ubbcacheService

    def list() {
        try {
            def list = Lending.list()
            render(status: 200, contentType: "text/json", text: [status: "success", data: list, message: ""] as JSON)
        }catch (Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some error happened on server!"] as JSON)

        }
    }

    def save() {

        def params = request.JSON

        if(params.userId && params.name) {
              def Lending = new Lending(userId: params.userId,
                                        name: params.name,
                                        projectLink: params?.projectLink,
                                        cssStyle: params?.cssStyle,
                                        page: params?.page,
                                        token: new Date().getTime().encodeAsMD5().toString(),
                                        needMoney: params?.needMoney.toInteger(),
                                        totalMoney: params?.totalMoney.toInteger(),).save(flush: true, failOnError: true)
            render(status: 200, contentType: "text/json", text: [status: "success", data: Lending, message: ""] as JSON)
        }else{
            render(status: 400, contentType: "text/json", text: [status: "error", data: "", message: "Not enough params!"] as JSON)
        }
    }

    def show() {
        try {
            def lending = Lending.get(params.id)
            if(lending){
                render(status: 200, contentType: "text/json", text: [status: "success", data: lending, message: ""] as JSON)
            } else {
                render(status: 404, contentType: "text/json", text: [status: "error", date: "", message: "Lending not fount by id!"] as JSON)
            }

        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some internal error happened on server!"])
        }
    }

    def update() {
        try {
            def lending = Lending.get(params.id)
            if(lending){
                if (request.JSON.name){ lending.name = request.JSON.name}
                if (request.JSON.projectLink){ lending.name = request.JSON.projectLink}
                if (request.JSON.cssStyle){ lending.name = request.JSON.cssStyle}
                if (request.JSON.page){ lending.name = request.JSON.page}
                if (request.JSON.needMoney){ lending.name = request.JSON.needMoney.toInteger()}
                if (request.JSON.totalMoney){ lending.name = request.JSON.totalMoney.toInteger()}
                lending.dateMofified = new Date()
                lending.save(flush: true, failOnError: true)
                render(status: 202, contentType: "text/json", text: [status: "success", data: user, message: "Lending updated!"] as JSON)
            } else {
                render(status: 404, contentType: "text/json", text: [status: "error", data: "", message: "Lending not fount by id!"] as JSON)
            }
        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Lending internal error happened on server!"])
        }
    }

    def delete() {
        try {
            def lending = Lending.get(params.id)
            if(lending){
                lending.delete(flush: true)
                render(status: 202, contentType: "text/json", text: [status: "success", data: "", message: "Lending deleted!"] as JSON)
            } else {
                render(status: 404, contentType: "text/json", text: [status: "error", data:"", message: "Lending not fount by id!"] as JSON)
            }
        }catch(Exception e) {
            render(status: 500, contentType: "text/json", text: [status: "error", data: "", message: "Some internal error happened on server!"])
        }
    }


    def getLink(){
        if(params.lendingId) {
            def lendinglink = lendingService.getLendingLink(params.lendingId.toInteger())

            if(lendinglink){
                render(status: 200, contentType: "text/json", text: [status: "success", data: lendinglink, message: ""] as JSON)
            }else{
                render(status: 400, contentType: "text/json", text: [status: "error", data: "", message: "wrong data"] as JSON)
            }

        }else{
            render(status: 400, contentType: "text/json", text: [status: "error", data: "", message: "Not enough params!"] as JSON)
        }
    }

    def ubbProjectData(){

        if(params.url) {

            def resp = ubbcacheService.get(params.url)
            if(!resp){
                resp = lendingService.getPayNums(params.url)
                ubbcacheService.set(params.url, (resp as JSON).toString())
            }

            if(resp){
                render(status: 200, contentType: "text/json", text: [status: "success", data: resp, message: ""] as JSON)
            }else{
                render(status: 400, contentType: "text/json", text: [status: "error", data: "", message: "wrong data in request"] as JSON)
            }

        }else{
            render(status: 400, contentType: "text/json", text: [status: "error", data: "", message: "Not enough params!"] as JSON)
        }


    }
}
