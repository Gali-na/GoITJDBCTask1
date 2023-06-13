package goit.jdbc.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SQLFile {
    public static  String getSqlFromFile(String filePath) {
        String sql="";
        try {
            sql=String.join("\n", Files.readAllLines(Paths.get(filePath) ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sql;
    }

}
