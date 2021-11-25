package app.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionSubscribeEvent

@Component
class WebsocketEventListener {

    private def Logger logger = LoggerFactory.getLogger WebsocketEventListener

    /*@EventListener
    def eventListener(SessionSubscribeEvent event) {
        logger.info "An Event happened with event: {}", event
    }*/

}
