import java.util.Scanner;
public class tableArray {
    public static void main(String [] args ){
        Scanner scanner = new Scanner (System.in);

        String[] TOTAL_SUBJECTS = {"ComPro2","WebDev","CFVE"};
        String[] terms ={"prelim", "midterm","finals"};
        String[] subjects = new String [TOTAL_SUBJECTS];
        double [][] grades = new double[TOTAL_SUBJECTS][terms.length];



        System.out.print("Enter name:");
        String name = scanner.nextLine();
        loop:
        for(int i = 0; i < TOTAL_SUBJECTS; i++) {
            System.out.println("Enter subject " + i + 1);
            subjects[i] = scanner.nextLine();


            for (int j = 0; j < terms.length; j++) {
                System.out.print("\t" + terms[j] + ": ");
                try {
                    grades[i][j] = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("\tInvalid Grade, try again");;
                    j--;//resets the loop
                }

                if (grades[i][j] < MIN_GRADE){
                    System.out.println("Invalid grade, try again");
                    i--;
                }

            }
            System.out.print("add subjects? (y/n); ");
            char c = scanner.nextLine().charAt(0);

            if(Character.toLowerCase(c) != 'y'){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");

        for(int i = 0; i < TOTAL_SUBJECTS; i++){
            sb.append(String.format("%15s %10s %10s %10s %10s", subjects[i],terms[0],terms[1],terms[2],"Final Rating"));
            System.out.println(sb.toString());
        }



    }
    
}
