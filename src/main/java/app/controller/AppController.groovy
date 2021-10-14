package app.controller

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Slf4j
@Controller
public class AppController {

    @GetMapping("/")
    def home() {
        log.info "Hi Krishna"
        "index"
    }

}
