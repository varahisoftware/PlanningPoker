package app.controller

import app.AppProperty
import app.definition.Message
import app.util.UUID
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageExceptionHandler
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.annotation.SendToUser
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class PlanningPokerController {

    def log = LoggerFactory.getLogger PlanningPokerController
    def sessionIdToLatestJIRA = [:]

    @Autowired
    private AppProperty appProperty
    @Autowired
    private SimpMessagingTemplate template

    @GetMapping("/StartSession")
    def startSession(Model model) {
        String uuid = UUID.generate()
        log.info "The UUID is: " + uuid
        model.addAttribute "planningPokerUUID", uuid
        "StartSession"
    }

    @GetMapping("/JoinSession")
    def joinSession(Model model) {
        "JoinSession"
    }

    @PostMapping("/submitJIRA")
    def submitJIRA(Model model, String planningPokerUUID, String jira) {
        log.info "The PlanningPokerSessionId is: {} and JIRA is: {} ", planningPokerUUID, jira
        // model.addAttribute "planningPokerUUID", planningPokerUUID
        def message = new Message(Message.Persona.SCRUM_MASTER, Message.Persona.PARTICIPANT, planningPokerUUID, Message.Type.JIRA, jira)
        sessionIdToLatestJIRA[planningPokerUUID] = jira
        template.convertAndSend(appProperty.sessionCommunicationTopicPrefix + planningPokerUUID + appProperty.sessionCommunicationToParticipant, message.toString())
        "Index"
    }

    @SubscribeMapping("/planningPoker/session/{id}/to/participant")
    def planningPokerSessionIdToParticipant(@DestinationVariable String id) {
        log.info "A new subscriber on id: {}", id
        if (sessionIdToLatestJIRA.containsKey(id)) {
            def message = new Message(Message.Persona.SCRUM_MASTER, Message.Persona.PARTICIPANT, id, Message.Type.JIRA, sessionIdToLatestJIRA[id])
            message.toString()
        }
    }

    @SubscribeMapping("/planningPoker/session/{id}/to/scrum")
    def planningPokerSessionIdToScrum(@DestinationVariable String id) {
        log.info "A new subscriber on id: {}", id
        "Scrum Master Subscribed to Subscribed to: " + appProperty.sessionCommunicationTopicPrefix + id + appProperty.sessionCommunicationToParticipant
    }

    @MessageExceptionHandler
    @SendToUser("/topic/error")
    def handleException(Exception ex) {
        log.error "Post not found", ex
        "The requested post was not found"
    }

    /* @Scheduled(fixedDelay = 1000L)
     def method() {
         def message = new Message(Message.Persona.SCRUM_MASTER, Message.Persona.PARTICIPANT, "krishna", Message.Type.JIRA, "Fixed JIRA")
         template.convertAndSend appProperty.sessionCommunicationTopicPrefix + "krishna" + appProperty.sessionCommunicationToParticipant, message
         //TODO: Make this Specific JIRA for Specific Subscriber
     }*/


}
