package view;

import model.Student;

import java.util.Scanner;

public class GetInputOutput {
    static Scanner sc=new Scanner(System.in);

    public static void showUserChoice(){
        System.out.println("""
                Enter 1 to add new student details\s
                Enter 2 to update student details\s
                Enter 3 to delete student details\s
                Enter 4 to display student details\s
                Enter 5 to Exit !!! \s
                """);
    }
    public static void printWhichtoUpdate() {
        System.out.println("""
                Enter 1 to change name
                Enter 2 to change department
                Enter 3 to exit
                """);
    }
    public static void success(){
        System.out.println("operation Success");
    }
    public static void fails(){
        System.out.println("operation fails");
    }
    public static void wrongInput(){
        System.out.println("Wrong input try again\n");
    }


    public static int getNum(){
            return sc.nextInt();
    }
    public static  String getString(){
        return sc.next();
    }
    public static Student getDetails(){
        System.out.print("Enter name :");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.print("Enter Department :");
        String dept=sc.nextLine();
        return new Student(name,dept);
    }








    public static void end(Boolean res) throws InterruptedException {
        if(res){
            success();
        }else{
            fails();
        }
        Thread.sleep(2000);
    }
}
