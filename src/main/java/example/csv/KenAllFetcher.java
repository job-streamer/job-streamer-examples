package example.csv;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.batch.api.AbstractBatchlet;

/*
 * Copyright (c) 2015 kawasima.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */

/**
 *
 * @author kawasima
 */
public class KenAllFetcher extends AbstractBatchlet {

    @Override
    public String process() throws Exception {
        Path workDir = Paths.get("csvwork");
        if (Files.exists(workDir)) {
            Files.createDirectory(workDir);
        }
        
        Path zipPath = workDir.resolve("42nagasa.zip");
        if (!Files.exists(zipPath)) {
            URI uri = URI.create("http://www.post.japanpost.jp/zipcode/dl/kogaki/zip/42nagasa.zip");
            try (InputStream in = uri.toURL().openStream()) {
                Files.copy(in, zipPath);
            }
        }
        
        return "COMPLETED";
    }
    
}
