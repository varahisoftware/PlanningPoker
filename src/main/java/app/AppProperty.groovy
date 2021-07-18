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
    String appName

    @Value('${app.admin.user:system}')
    String appAdminUser

    @Value('${app.admin.password:system}')
    transient String appAdminPassword

    @Override
    String toString() {
        return gson.toJson(this)
    }

}
