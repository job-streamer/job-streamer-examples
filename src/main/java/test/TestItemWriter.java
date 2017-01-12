package test;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestItemWriter extends AbstractItemWriter {
    private static final Logger LOG = LoggerFactory.getLogger(TestItemWriter.class);
    
    @Override
    public void writeItems(List<Object> items){
        LOG.info("TestItemWriter called");
    }
}
