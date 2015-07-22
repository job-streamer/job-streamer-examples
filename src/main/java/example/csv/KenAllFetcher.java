package example.csv;


import org.slf4j.Logger;

import javax.batch.api.AbstractBatchlet;
import javax.batch.api.BatchProperty;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author kawasima
 */
@Named("KenAllFetcher")
@Dependent
public class KenAllFetcher extends AbstractBatchlet {
    @Inject
    private Logger logger;

    @Override
    public String process() throws Exception {
        logger.info("Start process");
        Path workDir = Paths.get("csvwork");
        if (!Files.exists(workDir)) {
            Files.createDirectory(workDir);
        }

        Path zipPath = workDir.resolve("42nagasa.zip");
        if (!Files.exists(zipPath)) {
            URI uri = URI.create("http://www.post.japanpost.jp/zipcode/dl/kogaki/zip/42nagasa.zip");
            try (InputStream in = uri.toURL().openStream()) {
                Files.copy(in, zipPath);
            }
        }
        logger.info("End process");

        return "COMPLETED";
    }

}
