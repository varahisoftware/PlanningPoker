package app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
public class AppInit {

    public static void main(String[] args) {
        log.info("Application Starting");
        ConfigurableApplicationContext appContext = SpringApplication.run(AppConf.class, args);
        log.info("-----------------------------------");
        log.info("Application is Started successfully");
        log.info("-----------------------------------");
        AppProperty appProperty = appContext.getBean(AppProperty.class);
        log.info("Application is started with {}: {}", appProperty.getClass().getName(), appProperty);
    }

}
