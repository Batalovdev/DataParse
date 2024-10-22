package struct.parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        try {
            String data = getDataFromFile("src/data/iris.json");
          System.out.println(data);
            JSONParser parser = new JSONParser();
            JSONArray arr = (JSONArray) parser.parse(data);
            for(Object item:arr) {
                JSONObject jsonObj = (JSONObject) item;
                System.out.println(jsonObj.get("species"));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    static String getDataFromFile(String path){
        StringBuilder builder = new StringBuilder();
        try{
            List<String> lines = Files.readAllLines(Paths.get(path));
            for(String line: lines){
                builder.append(line);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return builder.toString();
    }
}