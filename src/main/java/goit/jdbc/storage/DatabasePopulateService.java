package goit.jdbc.storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static goit.jdbc.storage.SQLFile.getSqlFromFile;

public class DatabasePopulateService {

    private static void populateDatabase(Database database) {
        String sql= getSqlFromFile(Prefs.POPULATE_DB_SQL_FILE_PATH);
        try (Connection connection =database.getConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Database database=Database.getInstance();
        populateDatabase(database);
    }

}
