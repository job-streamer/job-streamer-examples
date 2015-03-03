/*
 * Copyright (c) 2015 tie199026.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    tie199026 - initial API and implementation and/or initial documentation
 */
package example.csv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.batch.api.chunk.AbstractItemReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author kawasima
 */
public class ZipReader extends AbstractItemReader {
    private static final Path ZIP_PATH = Paths.get("csvwork", "42nagasa.zip");
    private static final String[] HEADER = {
        "JIS_CD", "OLD_POSTAL_CD", "POSTAL_CD",
        "PREFECTURE_KANA", "CITY_KANA", "TOWN_KANA",
        "PREFECTURE_NAME", "CITY_NAME", "TOWN_NAME",
        "A", "B", "C", "D", "E", "F"
    };
    private Iterator<CSVRecord> csvIter;
    private CSVParser parser;
    
    @Override
    public void open(Serializable checkpoint) throws Exception {
        ZipFile zipFile = new ZipFile(ZIP_PATH.toFile());
        ZipEntry csvEntry = zipFile.getEntry("42NAGASA.csv");
        InputStreamReader reader = new InputStreamReader(zipFile.getInputStream(csvEntry), Charset.forName("Windows-31J"));
        parser = CSVFormat.RFC4180
                .withHeader(HEADER)
                .parse(reader);
        csvIter = parser.iterator();
    }
    
    @Override
    public void close() throws Exception {
        if (parser != null && !parser.isClosed()) {
            parser.close();
        }
    }
    
    @Override
    public Object readItem() throws Exception {
        if (csvIter.hasNext()) {
            return csvIter.next();
        } else {
            return null;
        }
    }
    
}
