package input.layer;

import java.util.*;

public class InputParser {

    public static List<Instruction> parseInstruction(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("The input cannot be empty.");
        }

        List<Instruction> instructions = new ArrayList<>();

        for(char c : input.toCharArray()) {
            switch (c) {
                case 'L':
                    instructions.add(Instruction.L);
                    break;
                case 'R':
                    instructions.add(Instruction.R);
                    break;
                case 'M':
                    instructions.add(Instruction.M);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction: " + c);
            }
        }

        return instructions;
    }

    public static CompassDirection parseCompassDirection(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("The input cannot be empty.");
        }

        switch (input) {
            case "N":
                return CompassDirection.N;
            case "S":
                return CompassDirection.S;
            case "W":
                return CompassDirection.W;
            case "E":
                return CompassDirection.E;
            default:
                throw new IllegalArgumentException("Invalid compass direction " + input);
        }
    }

    public static Position parsePosition(String input) {
        String[] inputSplit = input.split(" ");

        if (inputSplit.length != 3) {
            throw new IllegalArgumentException("Invalid position: " + input);
        }

        int x = Integer.parseInt(inputSplit[0]);
        int y = Integer.parseInt(inputSplit[1]);
        CompassDirection direction = parseCompassDirection(inputSplit[2]);

        Position position = new Position(x, y, direction);
        //position.setX(x);
        //position.setY(y);
        //position.setFacing(direction);

        return position;
    }

    public static PlateauSize parsePlateauSize(String input) {
        String[] inputSplit = input.split(" ");

        if (inputSplit.length != 2) {
            throw new IllegalArgumentException("Invalid plateau size: " + input);
        }

        int x = Integer.parseInt(inputSplit[0]);
        int y = Integer.parseInt(inputSplit[1]);

        PlateauSize plateauSize = new PlateauSize(x, y);
        //plateauSize.setX(x);
        //plateauSize.setY(y);

        return plateauSize;
    }

}
