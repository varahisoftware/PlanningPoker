package app.controller

import org.hibernate.Session
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AppController {

    def log = LoggerFactory.getLogger AppController

    @GetMapping("/")
    def home(Session session) {
        log.info "Landing Page"
        "Index"
    }

}
