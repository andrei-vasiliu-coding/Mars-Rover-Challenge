package logic.layer;

import input.layer.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Scanning Mars' surface. Define plateau size: (e.g. 0 0)");
        String plateauSizeInput = scanner.nextLine();
        PlateauSize plateauSize = InputParser.parsePlateauSize(plateauSizeInput);

        boolean choice = true;
        String decision;
        while (choice) {
            System.out.println("Suitable plateau identified. Specify landing coordinates: (e.g. 0 0 [N | S | W | E])");
            String positionInput = scanner.nextLine();
            Position position = InputParser.parsePosition(positionInput);

            System.out.println("Landing coordinates set. Initiating launching protocols.");
            System.out.println("3");
            Thread.sleep(1000);
            System.out.println("2");
            Thread.sleep(1000);
            System.out.println("1");
            Thread.sleep(1000);
            System.out.println("Launching system engaged.");

            Rover firstRover = new Rover(position);
            firstRover.plateauSize = plateauSize;

            System.out.println("Rover successfully landed on Mars. Input rover instructions: (e.g. LRMM)");
            String instructionsString = scanner.nextLine();
            List<Instruction> instructions = InputParser.parseInstruction(instructionsString);
            for (Instruction instruction : instructions) {
                firstRover.rotate(instruction);
                firstRover.advance(instruction);
            }

            System.out.println("Do you wish to launch another rover? Y/N");
            decision = scanner.nextLine();

            switch (decision) {
                case "Y":
                    choice = true;
                    break;

                case "N":
                    choice = false;
                    break;

                default:
                    boolean repeat = true;

                    while (repeat)
                    {
                        System.out.println("Invalid answer, please enter again.");
                        System.out.println("Do you wish to launch another rover? Y/N");
                        decision = scanner.nextLine();

                        switch (decision)
                        {
                            case "Y":
                                choice = true;
                                repeat = false;
                                break;

                            case "N":
                                choice = repeat = false;
                                break;

                            default:
                                repeat = true;
                        }
                    }
                    break;
            }
        }

        scanner.close();
    }
}