import java.util.Scanner;

public class EquationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Linear Equation Calculator!");
        System.out.print("Enter the first coordinate point (x1, y1): ");
        String input1 = scanner.nextLine();
        double x1 = extractX(input1);
        double y1 = extractY(input1);

        System.out.print("Enter the second coordinate point (x2, y2): ");
        String input2 = scanner.nextLine();
        double x2 = extractX(input2);
        double y2 = extractY(input2);

        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

        System.out.println("Pairs entered: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")");
        System.out.println("Slope intercept form: " + equation.getEquationString());
        System.out.println("Slope: " + equation.getSlope());
        System.out.println("Y-Intercept: " + equation.getYIntercept());
        System.out.println("Distance between the points: " + equation.calculateDistance());

        System.out.print("Enter a third x value: ");
        double x = scanner.nextDouble();
        String coordinate = equation.calculateCoordinate(x);
        System.out.println("Coordinate on the line: " + coordinate);
    }

    private static double extractX(String coordinate) {
        int startIndex = coordinate.indexOf('(') + 1;
        int commaIndex = coordinate.indexOf(',');
        return Double.parseDouble(coordinate.substring(startIndex, commaIndex).trim());
    }

    private static double extractY(String coordinate) {
        int commaIndex = coordinate.indexOf(',') + 1;
        int endIndex = coordinate.indexOf(')');
        return Double.parseDouble(coordinate.substring(commaIndex, endIndex).trim());
    }
}