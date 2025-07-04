import java.util.Scanner;

public class EnhancedCalculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Enhanced Calculator ---");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculator");
            System.out.println("3. Unit Conversion");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> basicArithmetic();
                case 2 -> scientificCalculator();
                case 3 -> unitConversion();
                case 4 -> System.out.println("Exiting calculator...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    static void basicArithmetic() {
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        System.out.println("Choose operation: + - * /");
        char op = scanner.next().charAt(0);

        switch (op) {
            case '+' -> System.out.println("Result: " + (a + b));
            case '-' -> System.out.println("Result: " + (a - b));
            case '*' -> System.out.println("Result: " + (a * b));
            case '/' -> {
                if (b != 0)
                    System.out.println("Result: " + (a / b));
                else
                    System.out.println("Error: Division by zero!");
            }
            default -> System.out.println("Invalid operator.");
        }
    }

    static void scientificCalculator() {
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation (x^y)");
        System.out.print("Choose operation: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                if (num >= 0)
                    System.out.println("√" + num + " = " + Math.sqrt(num));
                else
                    System.out.println("Error: Negative input!");
            }
            case 2 -> {
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exp = scanner.nextDouble();
                System.out.println(base + "^" + exp + " = " + Math.pow(base, exp));
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    static void unitConversion() {
        System.out.println("1. Temperature (C ↔ F)");
        System.out.println("2. Currency (INR ↔ USD)");
        System.out.print("Choose conversion: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Fahrenheit to Celsius");
                int tempOption = scanner.nextInt();

                System.out.print("Enter temperature: ");
                double temp = scanner.nextDouble();

                if (tempOption == 1)
                    System.out.println("Result: " + ((temp * 9 / 5) + 32) + " °F");
                else if (tempOption == 2)
                    System.out.println("Result: " + ((temp - 32) * 5 / 9) + " °C");
                else
                    System.out.println("Invalid temperature option.");
            }
            case 2 -> {
                System.out.println("1. INR to USD");
                System.out.println("2. USD to INR");
                int currOption = scanner.nextInt();

                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();

                double rate = 83.0; // Static exchange rate
                if (currOption == 1)
                    System.out.println("Result: $" + (amount / rate));
                else if (currOption == 2)
                    System.out.println("Result: ₹" + (amount * rate));
                else
                    System.out.println("Invalid currency option.");
            }
            default -> System.out.println("Invalid conversion type.");
        }
    }
}
