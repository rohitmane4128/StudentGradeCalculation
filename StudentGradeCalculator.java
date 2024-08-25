import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of subjects: ");
        int numSubjects;
        try {
            numSubjects = Integer.parseInt(scanner.nextLine());
            if (numSubjects <= 0) {
                throw new NumberFormatException("Number of subjects must be positive.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Input Error: " + ex.getMessage());
            return;
        }

        double[] marks = new double[numSubjects];
        double total = 0;

        
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            try {
                marks[i] = Double.parseDouble(scanner.nextLine());
                if (marks[i] < 0 || marks[i] > 100) {
                    throw new NumberFormatException("Marks must be between 0 and 100.");
                }
                total += marks[i];
            } catch (NumberFormatException ex) {
                System.out.println("Input Error: " + ex.getMessage());
                i--; // Retry the same subject
            }
        }

        
        double percentage = total / numSubjects;
        String grade = calculateGrade(percentage);

        
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    
    private static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
