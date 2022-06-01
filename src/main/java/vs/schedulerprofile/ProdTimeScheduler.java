package vs.schedulerprofile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Profile("prod")
@Component
public class ProdTimeScheduler {

    private static final Logger log = LoggerFactory.getLogger(ProdTimeScheduler.class);

    @Scheduled(fixedRate = 2000)
    public void dev() {
        log.info("Only on PROD profile: {}", LocalDateTime.now());
    }

}
