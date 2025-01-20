import java.util.Scanner;
public class HelloWorld{
    public static void main(String []args){

     Scanner input = new Scanner(System.in);
        /*DIs is just for me to see if my new repo is working well */
        System.out.println("Add extra message? type [y] for yes or [n] for no");
        String answer = input.nextLine();
        if(answer.toLowerCase()== "y"){
            System.out.println("Write extra message: ");
             String extraMessage = input.nextLine();
            System.out.println("Hello world! " + extraMessage);
        }else{
            System.out.println("Helloworld! ");
        }
        input.close();
        



        
    }
}