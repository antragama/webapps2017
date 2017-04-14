/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aa2036.webapps2016_2.ejb;



import com.aa2036.webapps2016_2.entity.RegisteredUser;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Antragama
 */

@Stateless
public class UserServiceBean implements UserService{

    @PersistenceContext
    EntityManager em;
    
    public UserServiceBean() {
    }

    @Override
    public void registerUser(String email, String currency) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://localhost:8080/RSConversion/conversion/dollar/euro/100");
        String response = myResource.request(MediaType.TEXT_PLAIN).get(String.class);
        
        double amount = Double.parseDouble(response);
        
        
        //double amount = 10;
        RegisteredUser new_user = new RegisteredUser(amount, email, currency);
        em.persist(new_user);
    
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("Webapps: PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Webapps: PreDestroy");
    }
    
    
    
    
}
