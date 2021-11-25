package app

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppProperty implements Serializable {

    @Autowired
    private transient Gson gson

    @Value('${app.name:Not Available}')
    def appName

    @Value('${app.admin.user:system}')
    def appAdminUser

    @Value('${app.admin.password:system}')
    transient def appAdminPassword

    @Value('${session.communication.topic.prefix}')
    def sessionCommunicationTopicPrefix

    @Value('${user.communication.topic.prefix}')
    def userCommunicationTopicPrefix

    @Override
    String toString() {
        return gson.toJson(this)
    }

}
