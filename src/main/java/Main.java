import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String gradingMethod = getGradingMethod(scanner); // <---- simply change this value to change the way grades are curved
        StudentGradeTranslator gradeTranslator = new StudentGradeTranslator(gradingMethod);

        HashMap<String, String> studentGrades = new HashMap<String, String>();
        studentGrades.put("Jamaal", "93");
        studentGrades.put("Jennifer", "87");
        studentGrades.put("Jules", "59");

        // get all the student and their grades using each entry
        System.out.println("List of students and their grades:");
        for (Map.Entry<String, String> studentGrade : studentGrades.entrySet()) {
            System.out.println(studentGrade.getKey() + "'s grade is " +
                    gradeTranslator.getLetterGrade(Integer.parseInt(studentGrade.getValue())));
            System.out.println("Passing grade status: "
                    + gradeTranslator.isPassingGrade(Integer.parseInt(studentGrade.getValue())));
            System.out.println("The Student requires this many more points to reach the next grade level: "
                    + gradeTranslator.howManyForNextLetterGrade(Integer.parseInt(studentGrade.getValue())));
        }
    }

    public static String getGradingMethod(Scanner scanner) {
        String gradingMethod = "";
        System.out.println("Please enter a Grading Method: \n 1. FLAT \n 2. SLIGHT \n 3. HEAVY ");
        String inputString = scanner.nextLine();
        int input = getInput(inputString);

        switch (input) {
            case 1: gradingMethod = "FLAT";
            break;

            case 2: gradingMethod = "SLIGHT";
            break;

            case 3: gradingMethod = "HEAVY";
            break;

            default: System.out.println("You are bad at typing numbers 1-3");
                        gradingMethod = getGradingMethod(scanner);
            break;
        }
        return gradingMethod;
    }
    private static int getInput(String sampleString) {
        try {
            return Integer.parseInt(sampleString);
        } catch (Exception e) {

            return -1;
        }
    }
}