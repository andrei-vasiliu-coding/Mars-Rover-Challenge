package logic.layer;

public class Rover {
    Position position;
    PlateauSize plateauSize;

    public Rover(Position position) {
        this.position = position;
    }

    void rotate(Instruction direction) {
        if (position.getFacing().equals(CompassDirection.N) && direction.equals(Instruction.L)) {
            position.setFacing(CompassDirection.W);
            System.out.println("The rover is now facing " + position.getFacing());
        } else if (position.getFacing().equals(CompassDirection.S) && direction.equals(Instruction.L)) {
            position.setFacing(CompassDirection.E);
            System.out.println("The rover is now facing " + position.getFacing());
        } else if (position.getFacing().equals(CompassDirection.W) && direction.equals(Instruction.L)) {
            position.setFacing(CompassDirection.S);
            System.out.println("The rover is now facing " + position.getFacing());
        } else if (position.getFacing().equals(CompassDirection.E) && direction.equals(Instruction.L)) {
            position.setFacing(CompassDirection.N);
            System.out.println("The rover is now facing " + position.getFacing());
        } else if (position.getFacing().equals(CompassDirection.N) && direction.equals(Instruction.R)) {
            position.setFacing(CompassDirection.E);
            System.out.println("The rover is now facing " + position.getFacing());
        } else if (position.getFacing().equals(CompassDirection.S) && direction.equals(Instruction.R)) {
            position.setFacing(CompassDirection.W);
            System.out.println("The rover is now facing " + position.getFacing());
        } else if (position.getFacing().equals(CompassDirection.W) && direction.equals(Instruction.R)) {
            position.setFacing(CompassDirection.N);
            System.out.println("The rover is now facing " + position.getFacing());
        } else if (position.getFacing().equals(CompassDirection.E) && direction.equals(Instruction.R)) {
            position.setFacing(CompassDirection.S);
            System.out.println("The rover is now facing " + position.getFacing());
        }
    }

    void advance(Instruction instructionM) {

        if (instructionM.equals(Instruction.M) && position.getFacing().equals(CompassDirection.N)) {
            if (position.getY() + 1 <= plateauSize.getY()) {
                position.setY(position.getY() + 1);
                System.out.println("Transmitting rover's current coordinates: " + position.getX() + " " + position.getY());
            } else {
                System.out.println("Reached the plateau's boundary. Unable to proceed further.");
            }
        }

        if (instructionM.equals(Instruction.M) && position.getFacing().equals(CompassDirection.S)) {
            if (position.getY() - 1 >= 0) {
                position.setY(position.getY() - 1);
                System.out.println("Transmitting rover's current coordinates: " + position.getX() + " " + position.getY());
            } else {
                System.out.println("Reached the plateau's boundary. Unable to proceed further.");
            }
        }

        if (instructionM.equals(Instruction.M) && position.getFacing().equals(CompassDirection.W)) {
            if (position.getX() - 1 >= 0) {
                position.setX(position.getX() - 1);
                System.out.println("Transmitting rover's current coordinates: " + position.getX() + " " + position.getY());
            } else {
                System.out.println("Reached the plateau's boundary. Unable to proceed further.");
            }
        }

        if (instructionM.equals(Instruction.M) && position.getFacing().equals(CompassDirection.E)) {
            if (position.getX() + 1 <= plateauSize.getX()) {
                position.setX(position.getX() + 1);
                System.out.println("Transmitting rover's current coordinates: " + position.getX() + " " + position.getY());
            } else {
                System.out.println("Reached the plateau's boundary. Unable to proceed further.");
            }
        }
    }

}
