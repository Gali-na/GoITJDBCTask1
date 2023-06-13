package goit.jdbc.model;

import java.math.BigDecimal;

public class ProjectsPrice {
    String nameProject;
    BigDecimal price;

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "nameProject='" + nameProject + '\'' +
                ", price=" + price +
                '}';
    }
}
