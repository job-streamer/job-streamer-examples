package example.param;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Named
@Dependent
public class ParameterizedBatchlet extends AbstractBatchlet{
    private static final Logger LOG = LoggerFactory.getLogger("job-streamer");

    @Any
    @Inject
    JobContext jobContext;

    @Override
    public String process() throws Exception {
        Properties jobProperties = jobContext.getProperties();
        LOG.info("jobProperties=" + jobProperties);
        String dateStr = jobProperties.getProperty("date");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        LOG.info("Argument['date']=" + date);
        return "Processed";
    }
}
