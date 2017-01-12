package test;

import javax.batch.api.chunk.AbstractItemReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestItemReader extends AbstractItemReader {
    private static final Logger LOG = LoggerFactory.getLogger(TestItemReader.class);
    
    @Override
    public Object readItem() throws Exception {
        LOG.info("TestItemReader called");
        return null;
    }
}
