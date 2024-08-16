package logic.layer;
import static input.layer.InputParser.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testRover {

    // TESTING ROTATE METHOD

    @Test
    void testInvalidRotate() {
        //Arrange
        String stringPosition = "3 3 N";
        Rover firstRover = new Rover(parsePosition(stringPosition));

        //Act
        firstRover.rotate(Instruction.M);

        //Assert
        assertEquals(CompassDirection.N, firstRover.position.getFacing());
    }

    @Test
    void testValidRotate() {
        //Arrange
        String stringPosition = "3 3 N";
        Rover firstRover = new Rover(parsePosition(stringPosition));

        //Act
        firstRover.rotate(Instruction.L);

        //Assert
        assertEquals(CompassDirection.W, firstRover.position.getFacing());
    }


    //TESTING ADVANCE METHOD

    @Test
    void testInvalidAdvance() {
        //Arrange
        String stringPosition = "3 3 N";
        Rover firstRover = new Rover(parsePosition(stringPosition));
        firstRover.plateauSize = new PlateauSize(5, 5);

        //Act
        firstRover.advance(Instruction.L);

        //Assert
        assertEquals(3, firstRover.position.getY());
    }

    @Test
    void testValidAdvance() {
        //Arrange
        String stringPosition = "3 3 N";
        Rover firstRover = new Rover(parsePosition(stringPosition));
        firstRover.plateauSize = new PlateauSize(5, 5);

        //Act
        firstRover.advance(Instruction.M);

        //Assert
        assertEquals(4, firstRover.position.getY());
    }
}