package services;

import model.Student;
import dbHelper.*;
import static view.GetInputOutput.*;


public class StudentServiceImpl implements StudentService{
    DbHelper dbHelper=new DbHelper();
    @Override
    public Boolean create() {
        Student student=getDetails();
        return dbHelper.addNewStudent(student);
    }

    @Override
    public Boolean update() {
        System.out.print("Enter RollNo :");
        int n=getNum();
        int index=authenticate(n);
        if(index!=-1){
                updating(dbHelper.getStudentByIndex(index));
                return true;
        }
        return false;
    }

    @Override
    public void display() {
        for(int i=0;i<dbHelper.getIndex();i++){
            System.out.println(dbHelper.getStudentByIndex(i));
        }
        if(dbHelper.getIndex()==0) System.out.println("Student database is empty");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean delete(int roll) {
        int index=authenticate(roll);
        if(index!=-1){
            dbHelper.reduceIndex();
            for(int j=index;j<49;j++){
                dbHelper.setStudentByIndex(j,dbHelper.getStudentByIndex(j+1));
            }
            return true;
        }else return false;
    }

    public void updating(Student student){
        System.out.println("Which one you want to update");
        update:
        while (true){
            printWhichtoUpdate();
            int n=getNum();
            switch (n){
                case 1:{
                    System.out.print("Enter name :");
                    student.setName(getString());
                    break;
                } case 2:{
                    System.out.println("Enter department");
                    student.setDepartment(getString());
                    break;
                } case 3:{
                    break update;
                } default:{
                    wrongInput();
                }
            }
        }
        System.out.println("Update successful");
        System.out.println(student);
    }

    public int authenticate(int roll){
        for(int i=0;i<dbHelper.getIndex();i++){
            if(dbHelper.getStudentByIndex(i).getRollNo()==roll){
                return i;
            }
        }
        return -1;
    }
}
