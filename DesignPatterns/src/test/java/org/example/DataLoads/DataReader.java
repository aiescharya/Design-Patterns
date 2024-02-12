package org.example.DataLoads;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.graalvm.compiler.core.common.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {
    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        String jsonContents=FileUtils.readFileToString(new File("reservationDetails.json"), StandardCharsets.UTF_8);
        List<HashMap<String,String>> data=mapper.readValue(jsonContents,new TypeReference<List<HashMap<String,String>>>(){});

        return data;
    }
}
