package goit.jdbc.model;

public class ProjectDuration {
   private String nameProject;
   private  int projectDurationMonths;



    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public int getProjectDurationMonths() {
        return projectDurationMonths;
    }

    public void setProjectDurationMonths(int projectDurationMonths) {
        this.projectDurationMonths = projectDurationMonths;
    }

    @Override
    public String toString() {
        return "Project{" +
                "nameProject='" + nameProject + '\'' +
                ", projectDurationMonths=" + projectDurationMonths +
                '}';
    }
}
