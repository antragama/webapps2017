/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aa2036.webapps2016_2.ejb;

import javax.ejb.Local;

@Local
public interface UserService {
     public void registerUser(String email, String currency);
}