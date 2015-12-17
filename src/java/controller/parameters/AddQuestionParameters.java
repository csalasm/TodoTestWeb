/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parameters;

import controller.AddQuestionServlet;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import model.jpa.Respuesta;

/**
 *
 * @author andresbailen93
 */
public class AddQuestionParameters {

    private String question;
    private Collection<Respuesta> respuestaCollection;
    private byte[] image;
    private int categoryID;

    public AddQuestionParameters(HttpServletRequest request) {
        try {
            question = request.getParameter("pregunta");
            String categoria = request.getParameter("Categoria");
            categoryID = 0;
            if(request.getPart("fileImage") != null){
            image = getImageBytes(request.getPart("fileImage"));
            }
        } catch (IOException ex) {
            Logger.getLogger(AddQuestionParameters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(AddQuestionParameters.class.getName()).log(Level.SEVERE, null, ex);
        }
    
            String[] answer = request.getParameterValues("respuestaText[]");
            String answerIsCorrect = request.getParameter("respuesta");
            for(int i = 0; i<answer.length; i++){
                //AÑADIR RESPUESTAS JPA FACADE!
                ///////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////
                ///////////////////////////////////////
                ///////////////////////////////////////
                ///////////////////////////////////////
                ///////////////////////////////////////
                
                System.out.println(answerIsCorrect);
                System.out.println(answer[i]);
                }
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoria(int categoria) {
        this.categoryID = categoria;
    }

    public Collection<Respuesta> getRespuestaCollection() {
        return respuestaCollection;
    }

    public void setRespuestaCollection(Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
    }

    private final byte[] getImageBytes(Part p) {

        byte[] imageByteArray = null;
        int read = 0;

        try {
            imageByteArray = new byte[(int) p.getSize()];
            read = p.getInputStream().read(imageByteArray);

        } catch (IOException ex) {
            Logger.getLogger(AddQuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return imageByteArray;
    }

}
