package input.layer;

import logic.layer.CompassDirection;
import logic.layer.Instruction;
import logic.layer.PlateauSize;
import logic.layer.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static input.layer.InputParser.*;
import static org.junit.jupiter.api.Assertions.*;

class testInputParser {

    //PARSE INSTRUCTION TESTING

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input in empty")
    void testParseInstructionWhenEmpty() {
        //Arrange
        String emptyInput = "";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parseInstruction(emptyInput));
    }

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input is invalid.")
    void testParseInstructionWithInvalidInput() {
        //Arrange
        String invalidInput = "A";

        //Assert
        assertThrows(IllegalArgumentException.class, () -> parseInstruction(invalidInput));
    }

    @Test
    @DisplayName("Returns an Instruction enum when the input is valid.")
    void testParseInstructionWithString() {
        //Arrange
        String input = "L";
        List<Instruction> expected = List.of(Instruction.L);

        //Act
        List<Instruction> result = parseInstruction(input);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Returns an Instruction enum list when the input is valid.")
    void testParseInstructionWithMultipleInstruction() {
        //Arrange
        String input = "LLRMMRL";
        List<Instruction> expected = List.of(Instruction.L, Instruction.L, Instruction.R, Instruction.M, Instruction.M,
                Instruction.R, Instruction.L);

        //Act
        List<Instruction> result = parseInstruction(input);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input is invalid.")
    void testParseInstructionWithMultipleInvalidInstructions() {
        //Arrange
        String input = "LLRMXMRL";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parseInstruction(input));
    }


    //PARSE COMPASS DIRECTION TESTING

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input in empty")
    void testParseCompassDirectionWhenEmpty() {
        //Arrange
        String emptyInput = "";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parseCompassDirection(emptyInput));
    }

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input is invalid.")
    void testParseCompassDirectionWithInvalidInput() {
        //Arrange
        String invalidInput = "A";

        //Assert
        assertThrows(IllegalArgumentException.class, () -> parseCompassDirection(invalidInput));
    }

    @Test
    @DisplayName("Returns a compass direction enum when the input is valid.")
    void testParseCompassDirectionWithValidString() {
        //Arrange
        String input = "N";

        //Act
        CompassDirection result = parseCompassDirection(input);

        //Assert
        assertEquals(CompassDirection.N, result);
    }

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input is invalid.")
    void testParseCompassDirectionWithInvalidString() {
        //Arrange
        String input = "B";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parseCompassDirection(input));
    }

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input is invalid.")
    void testParseCompassDirectionWithValidAndInvalidString() {
        //Arrange
        String input = "NB";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parseCompassDirection(input));
    }


    //PARSE POSITION TESTING

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input in empty")
    void testParsePositionWhenEmpty() {
        //Arrange
        String emptyInput = "";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parsePosition(emptyInput));
    }

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input is invalid")
    void testParsePositionWhenInvalid() {
        //Arrange
        String invalidInput = "Hey";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parsePosition(invalidInput));
    }

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input is invalid")
    void testParsePositionWhenHalfInvalid() {
        //Arrange
        String invalidInput = "5 6 B";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parsePosition(invalidInput));
    }

    @Test
    @DisplayName("Returns a Position when String is valid")
    void testParsePositionWhenValid() {
        //Arrange
        String input = "5 6 N";
        Position expected = new Position(5, 6, CompassDirection.N);
        //expected.setX(5);
        //expected.setY(6);
        //expected.setFacing(CompassDirection.N);

        //Act
        Position result = parsePosition(input);

        // Assert
        assertEquals(expected.getX(), result.getX());
        assertEquals(expected.getY(), result.getY());
        assertEquals(expected.getFacing(), result.getFacing());
    }


    //PARSE PLATEAU SIZE TESTING

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input in empty")
    void testParsePlateauSizeWhenEmpty() {
        //Arrange
        String emptyInput = "";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parsePlateauSize(emptyInput));
    }

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input is invalid")
    void testParsePlateauSizeWhenInvalid() {
        //Arrange
        String invalidInput = "Hey";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parsePlateauSize(invalidInput));
    }

    @Test
    @DisplayName("Returns an Illegal Argument Exception when the input is invalid")
    void testParsePlateauSizeWhenHalfInvalid() {
        //Arrange
        String invalidInput = "3";

        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> parsePlateauSize(invalidInput));
    }

    @Test
    @DisplayName("Returns a Position when String is valid")
    void testParsePlateauSizeWhenValid() {
        //Arrange
        String input = "3 5";
        PlateauSize expected = new PlateauSize(3, 5);
        //expected.setX(3);
        //expected.setY(5);

        //Act
        PlateauSize result = parsePlateauSize(input);

        // Assert
        assertEquals(expected.getX(), result.getX());
        assertEquals(expected.getY(), result.getY());
    }
}