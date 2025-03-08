package dbHelper;

import model.Student;

public class DbHelper {
   private final int size=50;
   Student[] arr=new Student[size];
   private int index=0;
   private int roll=1;

   public int getSize(){
       return size;
   }
   public int getIndex(){
       return index;
   }
    public boolean addNewStudent(Student student){
        if(index==50){
            System.out.println("Students full");
            return false;
        }
        student.setRollNo(roll++);
        arr[index++]=student;
        return true;
    }
    public Student getStudentByIndex(int i){
        return arr[i];
    }
    public void setStudentByIndex(int i,Student student){
       arr[i]=student;
    }
    public void reduceIndex(){
       index--;
    }
}
