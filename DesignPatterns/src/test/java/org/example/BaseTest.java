package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.graalvm.compiler.core.common.type.TypeReference;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    public WebDriver initializeDriver()
    {
        System.setProperty("webdriver.chrome.driver","//C://Users//aiescharya.gunasekar//Downloads//chromedriver");
        WebDriver driver=new ChromeDriver();
        return driver;
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        String jsonContents= FileUtils.readFileToString(new File(jsonFilePath);
        List<HashMap<String,String>> data=mapper.readValue(jsonContents,new TypeReference<List<HashMap<String,String>>>(){});

        return data;
    }
}
