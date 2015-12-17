/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parameters;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Asus
 */
public class AddCategoryParameters {

    private String CategoryName;

    public AddCategoryParameters(HttpServletRequest request) {
        CategoryName = request.getParameter("TopicName");
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
    
}
