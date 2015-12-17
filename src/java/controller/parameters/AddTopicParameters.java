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
public class AddTopicParameters {

    private String TopicName;

    public AddTopicParameters(HttpServletRequest request) {
        TopicName = request.getParameter("TopicName");
    }

    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String TopicName) {
        this.TopicName = TopicName;
    }
    
}
