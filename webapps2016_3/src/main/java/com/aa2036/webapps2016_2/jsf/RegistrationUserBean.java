/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aa2036.webapps2016_2.jsf;

import com.aa2036.webapps2016_2.ejb.UserService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Antragama
 */
@Named
@RequestScoped
public class RegistrationUserBean {
    String email;
    String currency;
    
    @EJB
    UserService usrSrv;

    public RegistrationUserBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public UserService getUsrSrv() {
        return usrSrv;
    }

    public void setUsrSrv(UserService usrSrv) {
        this.usrSrv = usrSrv;
    }
    
    //call the injected EJB
    public String register() {
        usrSrv.registerUser(email, currency);
        return "index";
    }
    
}
