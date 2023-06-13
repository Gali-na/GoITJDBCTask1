package goit.jdbc.storage;

import java.util.ResourceBundle;

public class Prefs {
    private static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("database");
    }

    public static final String DB_JDBS_CONECTION_URL = getResourceBundle().getString("dbURL");
    public static final String INIT_DB_SQL_FILE_PATH = getResourceBundle().getString("init_db");
    public static final String POPULATE_DB_SQL_FILE_PATH = getResourceBundle().getString("populate_db");
    public static final String FIND_LONGEST_PROJECT_SQL_QUERY = getResourceBundle().getString("find_longest_project");
    public static final String FIND_MAX_PROJECTS_CLIENTS_SQL_QUERY = getResourceBundle().getString("find_max_projects_client");

    public static final String FIND_MAX_SALARY_WORKER_SQL_QUERY = getResourceBundle().getString("find_max_salary_worker");
    public static final String FIND_MAX_YOUNGEST_ELDEST_WORKERS_SQL_QUERY = getResourceBundle().getString("find_youngest_eldest_workers");
    public static final String GET_PROJECTS_PRICE = getResourceBundle().getString("print_project_prices");
}
