package goit.jdbc.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static goit.jdbc.storage.SQLFile.getSqlFromFile;

public class DatabaseInitService {


     private static void initialiseDatabase (Database database)  {
        String sql= getSqlFromFile(Prefs.INIT_DB_SQL_FILE_PATH);
        try (Connection connection =database.getConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }


    public static void main(String[] args) {
         Database database=Database.getInstance();
            initialiseDatabase (database);
    }
}
