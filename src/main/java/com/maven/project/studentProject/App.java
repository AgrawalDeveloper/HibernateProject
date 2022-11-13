package com.maven.project.studentProject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Laptop lp=new Laptop();
      lp.setLid(12);
      lp.setLname("Samsung");
      
      
      Student st=new Student();
      st.setName("Mona");
      st.setRollno(123);
      st.setMarks(98);
      st.getLaptop().add(lp);
      
      lp.setStudent(st);
      
      Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
      ServiceRegistry req=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
      SessionFactory sf=con.buildSessionFactory(req);
      Session session=sf.openSession();
      Transaction tx=session.beginTransaction();
      session.save(lp);
      session.save(st);
      
      tx.commit();
    }
}
