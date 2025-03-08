package controller;

import services.StudentService;
import services.StudentServiceImpl;
import static view.GetInputOutput.*;

@SuppressWarnings("BusyWait")
public class studentController {
    public static void initiate() throws InterruptedException {
        StudentService service=new StudentServiceImpl();
        main :
       while (true){
            showUserChoice();
            int choice= getNum();
            switch(choice){
                case 1:{
                    Boolean res=service.create();
                    end(res);
                    System.out.println("The detail was");
                    service.display();
                    break;
                }
                case 2 :{
                    Boolean res=service.update();
                    end(res);
                    break ;
                }
                case 3 :{
                    System.out.println("Enter roll number to delete");
                    Boolean res=service.delete(getNum());
                    end(res);
                    break;
                }
                case 4 :{
                    service.display();
                    break ;
                } case 5 :{
                    break main;
                }
                default:{
                    wrongInput();
                    Thread.sleep(200);
                }

            }
           System.out.println("\n");
        }
    }
}
