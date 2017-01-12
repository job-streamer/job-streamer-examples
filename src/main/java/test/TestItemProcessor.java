package test;


import javax.batch.api.chunk.ItemProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestItemProcessor implements ItemProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(TestItemProcessor.class);
    
    @Override
    public Object processItem(Object item) throws Exception {
        LOG.info("TestItemProcessor called");
        return null;
    }
}
