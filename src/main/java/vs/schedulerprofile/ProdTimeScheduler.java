package vs.schedulerprofile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Profile("prod")
@Component
public class ProdTimeScheduler implements CommonScheduler, ProductionScheduler {

    private static final Logger log = LoggerFactory.getLogger(ProdTimeScheduler.class);

    @Scheduled(fixedRate = 2000)
    public void dev() {
        log.info("Only on PROD profile: {}", LocalDateTime.now());
    }

    @Scheduled(fixedRate = 3500)
    @Override
    public void uploadDocuments() {
        log.info("PROD - Uploading documents");
    }

    @Scheduled(fixedRate = 4200)
    @Override
    public void createReporting() {
        log.info("PROD - Creating report");
    }

    @Scheduled(fixedRate = 4800)
    @Override
    public void trainDevelopers() {
        log.info("PROD - Developer training");
    }

    @Scheduled(fixedRate = 5000)
    @Override
    public void createMonthlyReporting() {
        log.info("PROD - Creating montly report");
    }
}
