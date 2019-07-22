package dao;

import controllers.MyServlet;
import entities.Student;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class StudentDao extends Database {

    String server = "localhost:3306";
    String database = "bootcampdb";
    String username = "root";
    String password = "1234";
    private static final String selectStudents = "SELECT * FROM `bootcampdb`.`students`";
    private static final String insertStudents = "INSERT INTO STUDENTS (surname, name, grade, birthdate) VALUES (?,?,?,?)";

    public List<Student> SelectStudents () throws IOException {
        
        Student st;
        List<Student> students = new ArrayList<>();

        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, selectStudents);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        try {
            while (rs.next()) {
                st = new Student(rs.getLong("ID"), rs.getString("SURNAME"),
                        rs.getString("NAME"), rs.getFloat("GRADE"),
                        rs.getString("BIRTHDATE"));
                students.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;

    }

    public boolean InsertStudent(Student st) {

        String query = "INSERT INTO `bootcampdb`.`students` \n" +
                        "(SURNAME,NAME,GRADE,BIRTHDATE) \n" +
                        "VALUES(\"" + st.getSurname() + "\",\"" + st.getName() + "\"," + st.getGrade() + "," + "\"" + st.getBirthDate() + "\")";
        int i = Database(server, database, username, password, query, (byte)1);
        if (i >=1) return true;

        return false;
    }
    
    public boolean InsertStudentJPA(Student st){
        
        boolean completed = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TestWebApp.PasparakisPU");
        EntityManager em = emf.createEntityManager();
        //create transtaction
        //begin.transaction
        em.getTransaction().begin();
        try {
            em.persist(st);
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
        return completed;
    }

    public boolean deleteStudent(int id) {
        String query= "delete from students where ID="+id;
          int i =Database(server, database, username, password, query,(byte)1);
        if(i>=1){
            return true;
        }else{
          
            return false;
        }
      
    }
    
}
