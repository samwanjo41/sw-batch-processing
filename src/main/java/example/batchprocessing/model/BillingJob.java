package example.batchprocessing.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobRepository;

import java.time.LocalDateTime;

public class BillingJob implements Job {

    private JobRepository jobRepository;
    private static final Logger logger = LoggerFactory.getLogger(BillingJob.class);

    public BillingJob(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public String getName() {
        return "BillingJob";
    }

    @Override
    public void execute(JobExecution execution) {

        JobParameters jobParameters = execution.getJobParameters();
        String inputFile = jobParameters.getString("input.file");
        try {
            logger.info("processing billing information from file {}", inputFile);
            execution.setStatus(BatchStatus.COMPLETED);
            execution.setExitStatus(ExitStatus.COMPLETED.addExitDescription("processing success"));
            execution.setEndTime(LocalDateTime.now());
        } catch (Exception exception) {
            execution.addFailureException(exception);
            execution.setStatus(BatchStatus.COMPLETED);
            execution.setExitStatus(ExitStatus.FAILED.addExitDescription(exception.getMessage()));
            execution.setEndTime(LocalDateTime.now());
        } finally {
            this.jobRepository.update(execution);
        }


    }
}