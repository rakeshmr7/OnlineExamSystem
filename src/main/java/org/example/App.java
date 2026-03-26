package org.example;

import org.example.service.MemberService;
import org.example.service.QuestionService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner s = new Scanner(System.in);
    public static void main( String[] args )
    {
        while(true){
            System.out.println("Enter role:\n1. Member\n2. Admin");
            int ch = s.nextInt();
            if(ch == 1) memberService();
            else if(ch == 2) adminService();
            else {
                System.out.println("Invalid choice");
                return;
            }
        }
    }
    public static void memberService(){
        MemberService mServ = new MemberService();
        while(true){
            System.out.println("1. Register Member\n2. Take Exam\n3. Switch Role\nEnter choice: ");
            int ch = s.nextInt();
            switch (ch){
                case 1:
                    mServ.register();
                    break;
                case 2:
                    mServ.takeExam();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice!!");
            }
        }
    }
    public static void adminService(){
        QuestionService qServ = new QuestionService();
        while(true){
            System.out.println("1. Add Question\n2. Update Question\n3. View Questions\n4. Switch Role\nEnter choice: ");
            int ch = s.nextInt();
            switch (ch){
                case 1:
                    qServ.addQuestion();
                    break;
                case 2:
                    qServ.updateQuestion();
                    break;
                case 3:
                    qServ.viewQuestion();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!!");
            }
        }
    }
}
