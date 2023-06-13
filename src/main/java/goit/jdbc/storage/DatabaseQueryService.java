package goit.jdbc.storage;

import goit.jdbc.model.MaxProjectCountClient;
import goit.jdbc.model.ProjectDuration;
import goit.jdbc.model.ProjectsPrice;
import goit.jdbc.model.Worker;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static Database database = Database.getInstance();

    public static void main(String[] args) {
        getProjectPrices();
    }

    public static List<ProjectDuration> findLongestProject() {
        String sql = SQLFile.getSqlFromFile(Prefs.FIND_LONGEST_PROJECT_SQL_QUERY);

        List<ProjectDuration> longestProject = new ArrayList<>();
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    ProjectDuration project = new ProjectDuration();
                    project.setNameProject(resultSet.getString(1));
                    project.setProjectDurationMonths(resultSet.getInt(2));
                    longestProject.add(project);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return longestProject;
    }

    public static List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> listProjectsMaxCountClient = new ArrayList<>();
        String sql = SQLFile.getSqlFromFile(Prefs.FIND_MAX_PROJECTS_CLIENTS_SQL_QUERY);
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
                    maxProjectCountClient.setName(resultSet.getString(1));
                    maxProjectCountClient.setProjectCount(resultSet.getInt(2));
                    listProjectsMaxCountClient.add(maxProjectCountClient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProjectsMaxCountClient;
    }

    public static List<Worker> findMaxSalaryWorker() {
        String sql = SQLFile.getSqlFromFile(Prefs.FIND_MAX_SALARY_WORKER_SQL_QUERY);
        List<Worker> workersMaxSalary = new ArrayList<>();
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Worker worker = new Worker();
                    worker.setName(resultSet.getString(1));
                    worker.setSalary(BigDecimal.valueOf(Double.valueOf(resultSet.getString(2))));
                    workersMaxSalary.add(worker);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workersMaxSalary;
    }

    public static List<Worker> findYoungestEldestWorkers() {
        String sql = SQLFile.getSqlFromFile(Prefs.FIND_MAX_YOUNGEST_ELDEST_WORKERS_SQL_QUERY);
        List<Worker> youngestEldestWorkers = new ArrayList<>();
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Worker worker = new Worker();
                    worker.setName(resultSet.getString(1));
                    worker.setBirthday(LocalDate.parse(resultSet.getString(2)));
                    youngestEldestWorkers.add(worker);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return youngestEldestWorkers;
    }

    public static List<ProjectsPrice> getProjectPrices() {
        String sql = SQLFile.getSqlFromFile(Prefs.GET_PROJECTS_PRICE);
        List<ProjectsPrice> listProjectsPrices = new ArrayList<>();
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    ProjectsPrice projectsPrice = new ProjectsPrice();
                    projectsPrice.setNameProject(resultSet.getString(1));
                    projectsPrice.setPrice(BigDecimal.valueOf(Double.valueOf(resultSet.getString(2))));
                    listProjectsPrices.add(projectsPrice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProjectsPrices;
    }
}
