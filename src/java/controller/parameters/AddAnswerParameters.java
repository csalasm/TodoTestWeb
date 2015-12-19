/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parameters;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.jpa.Respuesta;

/**
 *
 * @author andresbailen93
 */
public class AddAnswerParameters {

    private String[] text;
    private int correcta;
    ArrayList<Respuesta> answer_resp;
    
    public AddAnswerParameters(HttpServletRequest request) {
        answer_resp = new ArrayList<>();
        Respuesta resp;
        text = request.getParameterValues("respuestaText[]");
        correcta = Integer.parseInt(request.getParameter("respuesta"));
        System.out.println(correcta);
        for(int i = 0; i < text.length; i++){
            resp = new Respuesta();
            if(correcta==i){
                resp.setTexto(text[i]);
                resp.setCorrecta((short) 1);
                answer_resp.add(resp);
            }else{
                resp.setTexto(text[i]);
                resp.setCorrecta((short) 0);
                answer_resp.add(resp);
            }
        }
    }

    public ArrayList<Respuesta> getAnswer_resp() {
        return answer_resp;
    }

    public void setAnswer_resp(ArrayList<Respuesta> answer_resp) {
        this.answer_resp = answer_resp;
    }
    

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

}