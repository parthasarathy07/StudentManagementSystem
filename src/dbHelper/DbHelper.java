package dbHelper;

import model.Student;

import java.util.ArrayList;

public class DbHelper {
   private final ArrayList<Student> list=new ArrayList<>();
   private final int totalSize =50;
   private int roll=1;

    public int getCurrentSize(){
        return list.size();
    }
    public boolean addNewStudent(Student student){
        if(getCurrentSize()== totalSize){
            System.out.println("Students full");
            return false;
        }
        student.setRollNo(roll++);
        list.add(student);
        return true;
    }
    public Student getStudentByIndex(int index){
        return list.get(index);
    }
    public void deleteById(int index){
         list.remove(index);
    }
}
