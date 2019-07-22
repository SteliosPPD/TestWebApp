package services;

import dao.StudentDao;
import entities.Student;
import java.io.IOException;
import java.util.List;


public class StudentService {
    
    StudentDao stuDao = new StudentDao();
    
    public String getStudents() throws IOException {
        
        List<Student> students = stuDao.SelectStudents();
        StringBuilder str = new StringBuilder(); 
        
            str.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Private School</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>This is our class!</h1>")
                .append("<br />");
            for (Student st : students) {
                String delete = " <a href='DeleteStudent?delete=" + st.getId() + "'>Delete</a> ";
                String update = " <a href='UpdateStudent?update=" + st.getId() + "'>Update</a> ";
                str.append("<p>").append(st).append(delete).append(update).append("</p>");
            } 
            str.append("</body>")
                .append("</html>");
        
        String string = str.toString();
        
        return string;
    }
    
    public boolean InsertStudent(Student st) {
        
        if (stuDao.InsertStudentJPA(st)) return true;
        
        return false;  
}
    
    public boolean DeleteStudent(int id){
        
        if(stuDao.deleteStudent(id))
            return true;
        return false;
    }
}

