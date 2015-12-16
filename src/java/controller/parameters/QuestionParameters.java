/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parameters;

import controller.QuestionServlet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author csalas
 */
public class QuestionParameters {
    private int categoryID;
    private String questionText;
    private byte[] image;
    
    public QuestionParameters(HttpServletRequest request) {
        try {
            categoryID = Integer.valueOf(request.getParameter("categoryID"));
            questionText = request.getParameter("questionText");
            image = getImageBytes(request.getPart("fileImage"));
        } catch (IOException | ServletException ex) {
            Logger.getLogger(QuestionParameters.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    private final byte[] getImageBytes(Part p) {

        byte[] imageByteArray = null;
        int read = 0;
        
        try {
            imageByteArray = new byte[(int)p.getSize()];
            read = p.getInputStream().read(imageByteArray);
            
        } catch (IOException ex) {
            Logger.getLogger(QuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return imageByteArray;
    }
    
}
