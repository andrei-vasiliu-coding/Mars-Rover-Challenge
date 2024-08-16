package logic.layer;

import input.layer.*;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Scanning Mars' surface. Define plateau size: ");
        String plateauSizeInput = scanner.nextLine();
        PlateauSize plateauSize = InputParser.parsePlateauSize(plateauSizeInput);

        boolean choice = true;
        String decision;
        while (choice) {
            System.out.println("Suitable plateau identified. Specify landing coordinates: ");
            String positionInput = scanner.nextLine();
            Position position = InputParser.parsePosition(positionInput);

            System.out.println("Landing coordinates set. Launching rover.");
            Rover firstRover = new Rover(position);
            firstRover.plateauSize = plateauSize;

            System.out.println("Input rover instructions: ");
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
                    System.out.println("Please enter again: Y/N");
                    boolean repeat = true;

                    while (repeat)
                    {
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