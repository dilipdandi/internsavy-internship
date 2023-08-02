package internship;

public class CalculatorMain {
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        double num1 = 10;
        double num2 = 5;
        System.out.println("Addition: " + calculator.add(num1, num2));
        System.out.println("Subtraction: " + calculator.subtract(num1, num2));
        System.out.println("Multiplication: " + calculator.multiply(num1, num2));
        System.out.println("Division: " + calculator.divide(num1, num2));
    }
}
