
import java.io.*;
import java.util.Scanner;
public class student {
    public static final double MIN_GRADE = 50;
    public static final String FILE_DIR = "target/records";
    public static final int NUM_OF_SUBJECTS = 64;
    public static final int NUM_OF_TERMS = 3;

    public static void main(String[] args) {
        String name;
        String[] subjects = new String[NUM_OF_SUBJECTS];
        double[][] grades = new double[NUM_OF_SUBJECTS][NUM_OF_TERMS];
        String[] terms = {"Prelim", "Midterm", "Finals"};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        name = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name);
        sb.append("\n").append(String.format("%-15s%-10s%-10s%-10s%s\n", "SUBJECTS", "PRELIM", "MIDTERM", "FINAL", "FINAL RATING"));

        for (int i = 0; i < NUM_OF_SUBJECTS; i++) {
            System.out.print("Enter subject: ");
            subjects[i] = scanner.nextLine();
            String firstLine, secondLine = "";
            if (subjects[i].length() > 15) {
                int midPoint = subjects[i].length() / 2;
                firstLine = subjects[i].substring(0, midPoint);
                secondLine = subjects[i].substring(midPoint);
            } else {
                firstLine = subjects[i];
            }
            sb.append(String.format("%-15" + "s", firstLine));
            for (int j = 0; j < NUM_OF_TERMS; j++) {
                System.out.print("\t" + terms[j] + ": ");
                try {
                    grades[i][j] = Double.parseDouble(scanner.nextLine());
                    if (grades[i][j] > 100) {
                        throw new Exception("Error! No grades Greater than 100(Genius?)");
                    }
                    if (grades[i][j] < MIN_GRADE) {
                        throw new Exception("Error! No grades lesser than 50.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\tError! Invalid number.");
                    --j;
                    continue;
                } catch (Exception e) {
                    System.out.println("\t" + e.getMessage());
                    --j;
                    continue;
                }
                sb.append(String.format("%-10.2f", grades[i][j]));
            }

            sb.append(String.format("%-10.2f\n", getFinalRating(grades[i])));
            if (!secondLine.isEmpty()) {
                sb.append(String.format("%-15" + "s\n", secondLine));
            }
            System.out.print("Add another subject (y/n): ");
            char choice = scanner.nextLine().charAt(0);
            if (Character.toLowerCase(choice) != 'y') break;
        }

        System.out.println(sb);
        writeToFile(name, sb.toString());
        scanner.close();
    }

    public static double getFinalRating(double[] termGrades) {
        return termGrades[0] * 0.3 + termGrades[1] * 0.3 + termGrades[2] * 0.4;
    }

    public static void writeToFile(String fileName, String data) {
        File folder = new File(FILE_DIR);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folder, fileName);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
