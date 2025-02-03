public class JavaBasics {
    public static void main(String[] args) {
        byte hello = 127;
        System.out.println(hello);

        String greeting = "Hello, World!";
        int length = greeting.length(); // Get length of string
        String upperCaseGreeting = greeting.toUpperCase(); // Convert to uppercase
        System.out.println(greeting);
        System.out.println(upperCaseGreeting);

        char letter = 'A';
        boolean isLetter = Character.isLetter(letter); // Check if it's a letter
        if (isLetter == true) {
            System.out.println(letter + " is a letter");
        } else {
            System.out.println(letter + " is not a letter");
        }

        float[][] grades = {
            {90,90,95},
            {90,90,95},
            {70,70,70},
            {99,99,99}
        };

        int i =0;
        while(true){
            System.out.println(grades[i][i]);
            i++;
        }

        do{
            
        }

    }

}
