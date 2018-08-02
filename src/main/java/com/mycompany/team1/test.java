/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.team1;

import Entities.User;
import facade.UserFacade;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author yolly
 */
public class test {
    public static void main(String[] args) {
      
        System.out.println("================================");
UserFacade uf = new UserFacade();       
        uf.getuser();
        
        
    }
}
