package uawebchallenge.semifinalviii

import grails.transaction.Transactional
import grails.util.Holders as CH

@Transactional
class LendingService {

    def getLendingLink(Integer lendingId) {
        def lending = Lending.get(lendingId)
        if(lending){
            def link = CH.config.domain + /lending/ + lending.token
                return link
        }else{
            return false
        }
    }

    def getPayNums(String link){
        try {
                def proccesstext = ['bash', '-c', "curl $link"].execute().text

                def need_pay_block = proccesstext.find(/(<div id=\"need_pay\">)(.*)(div>)/)
                need_pay_block = need_pay_block.replaceAll(" ","")
                def num = need_pay_block.findAll(/(\d)+/)
                def need_sum = (num[0] + num[1] + num[2])

                def total_pay_block = proccesstext.find(/<b>(.*)<\/b> грн.<\/em>/)
                total_pay_block = total_pay_block.replaceAll(" ","")
                def num_2 = total_pay_block.find(/(\d)+/)
                  return [totalsum: num_2.toInteger(), needsum: need_sum.toInteger()]
        }catch(Exception e){
            return false
        }

    }
}
