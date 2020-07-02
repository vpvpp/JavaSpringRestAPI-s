package edu.ait.shoppingCart.Dto;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Categories")
public class Category extends AuditingModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer categoryId;
    public String CategoryName;

    @NotNull
    @Size(max = 250)
    public String Description;



    //getters and setters



  /*
    public Category() {
    }


    public Category(String categoryName, String description) {
        CategoryName = categoryName;
        Description = description;

    }

*/
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer CategoryId) {
        categoryId = CategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }



/*
    @Override
    public String toString() {
        return "Category{" +
                "CategoryId=" + categoryId +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }

 */
}

