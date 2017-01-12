package test;

import java.util.Properties;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@Dependent
public class TestBatchlet extends AbstractBatchlet{
    private static final Logger LOG = LoggerFactory.getLogger(TestBatchlet.class);

    @Any
    @Inject
    JobContext jobContext;
    
    @Any
    @Inject
    StepContext stepContext;

    @Override
    public String process() {
        Properties stepProperties = stepContext.getProperties();
        LOG.info(stepContext.getStepName() + "is executing");
        return stepProperties.getProperty("status");
    }
}
