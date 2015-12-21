/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parameters;

import controller.AddQuestionServlet;
import facades.CategoriaFacade;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.jpa.Categoria;
import model.jpa.Respuesta;

/**
 *
 * @author andresbailen93
 */
public class AddQuestionParameters {



    private String question;
    private Collection<Respuesta> respuestaCollection;
    private byte[] image;
    private Categoria category;

    public AddQuestionParameters(HttpServletRequest request) {
        try {
            question = request.getParameter("pregunta");
            if(request.getPart("fileName") != null){
            image = getImageBytes(request.getPart("fileName"));
            }
        } catch (IOException ex) {
            Logger.getLogger(AddQuestionParameters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(AddQuestionParameters.class.getName()).log(Level.SEVERE, null, ex);
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

    public Categoria getCategory() {
        return category;
    }

    public void setCategoria(Categoria categoria) {
        this.category = categoria;
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
