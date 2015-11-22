package bjs.task15;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.powerOn();
        computer.installOperationSystem();
        computer.installApplications();

        System.out.print(computer.toString());

        Calculator calculator = computer.getCalculator();
        calculator.calcExpression("10.2 + 6.6");

        System.out.println("\nPrint result array:");
        calculator.printCalculationResults();

        /*
        Power is on.

        Hardware complies with the system requirements.

        Computer type: PC
        Processor type: Intel Core i5-2400 CPU
        Processor clock rate: 3.1
        Random access memory size: 8.0
        Fixed memory size: 1000.0

        Operation system: Windows 7, x64
        Computer name: MyComputer

        Installed applications:
            Calculator v0.1
            File Manager v0.1

        Expression result: 16.799999999999997

        Print result array:
        SUM: 16.799999999999997,
        Operating system Windows 7, x64 is shut down.
         */

        computer.powerOff();
    }
}
