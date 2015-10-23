package uawebchallenge.semifinalviii

import grails.util.Holders as CH
import grails.transaction.Transactional

@Transactional
class EmailService {

   def send(String from,  String to, String subject, String text) {
       try {
           ['bash', '-c', "curl -s --user 'api:${CH.config.mailgun.secretApiKey}' ${CH.config.mailgun.baseUrl}/${CH.config.mailgun.domain}/messages -F from=$from -F to=$to -F subject=$subject -F text=$text"].execute()
           return true
       }catch(Exception e){
            return false
       }
   }

}
