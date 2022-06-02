package vs.schedulerprofile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Profile("dev")
@Component
public class DevTimeScheduler implements CommonScheduler {

    private static final Logger log = LoggerFactory.getLogger(DevTimeScheduler.class);

    @Scheduled(fixedRate = 2000)
    public void dev() {
        log.info("Only on DEV profile: {}", LocalDateTime.now());
    }

    @Scheduled(fixedRate = 3500)
    @Override
    public void uploadDocuments() {
        log.info("DEV - Uploading documents");
    }

    @Scheduled(fixedRate = 4200)
    @Override
    public void createReporting() {
        log.info("DEV - Creating report");
    }

    @Scheduled(fixedRate = 4800)
    @Override
    public void trainDevelopers() {
        log.info("DEV - Developer training");
    }
}
