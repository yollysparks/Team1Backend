/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import Entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author yolly
 */
public class UserFacade {

  public UserFacade() {   
  }
  
public List<User> getuser(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Team1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
       
      List<User> userlist;
      try{
          em.getTransaction().begin();
          Query q = em.createNamedQuery("User.findAll");
          userlist = q.getResultList();
          return userlist;
      }catch(Exception e){
          return new ArrayList<>();
      }finally{
          em.close();
      }
             
  }
 
 
}
