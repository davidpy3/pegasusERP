package org.jsuns.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

public class JPA{
    
    private JPA(){}
    
    private static JPA instance;

    public static JPA getInstance(){
        if(instance==null)instance=new JPA();
        return instance;
    }
    
    private static final ThreadLocal<Connection> tc=new ThreadLocal<Connection>();
    
    private static final ThreadLocal<EntityManager> tj=new ThreadLocal<EntityManager>();
    
    private static final ThreadLocal<EntityTransaction> tt=new ThreadLocal<EntityTransaction>();
    
    public Connection getConnection() throws SQLException, NamingException {
        Connection cnx=tc.get();
        if(cnx==null)tc.set(cnx=((DataSource)new InitialContext().lookup("siigaa")).getConnection());
        return cnx;
    }
    
    public EntityManager getEntityManager(boolean transaction){
        EntityManager em=getEntityManager();
        if(transaction)getTransaction();
        return em;
    }
    
    public EntityManager getEntityManager(){
        EntityManager em=tj.get();
        if(em==null){
            if(emf==null)emf=Persistence.createEntityManagerFactory("siigaa");
            tj.set(em=emf.createEntityManager());
        }
        return em;
    }
    
    public static EntityManagerFactory emf;
    
    public EntityTransaction getTransaction(){
        EntityTransaction t=tt.get();
        if(t==null){
            EntityManager em=getEntityManager();
            t=em.getTransaction();
            t.begin();
            tt.set(t);
        }
        return t;
    }
    
    public void close(){
        Connection c=tc.get();
        try{
            if(c!=null&&!c.isClosed()){
                c.close();
                System.out.println("Se cerro la conneccion");
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        tc.remove();
        EntityManager em=tj.get();
        if(em!=null){
            commit();
            em.close();
            System.out.println("Se cerro la jpa");
            tj.remove();
        }
    }
    
    public void rollback(){
        EntityTransaction t=tt.get();
        if(t!=null&&t.isActive()){
            try{
                t.rollback();
                tt.remove();
            }catch(Exception e){
                
            }
        }
    }
    
    public void commit(){
        EntityTransaction t=tt.get();
        if(t!=null&&t.isActive()){
            try{
                t.commit();
                System.out.println("Se confirmo transaccion");
            }catch(Exception e){
                if(t.isActive())
                    t.rollback();
            }
        }
        tt.remove();
    }
    
}
