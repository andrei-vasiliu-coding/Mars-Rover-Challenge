# Mars-Rover-Challenge
This project aims to create a program that can take in input defining a plateau size and a rover position to launch a rover on Mars. The user can then input instructions to either rotate or move the rover along the plateau.

# Steps explaining how to input instructions correctly:
1. After running the code, the user will be prompted to define the plateau size. The user must input two positive integers separated by a blank space, such as "5 5".

2. The user will be prompted to choose where on the plateau the rover should land and what direction it should face. The rover's position on the plateau must be within the plateau size that was previously defined. The direction must be a cardinal point. The user must input two positive integers and an uppercase cardinal point, all spearated by a blank space, such as "1 2 N".

3. The user can now input commands to rotate and move the rover. The letters "L" and "R" will rotate the rover either left or right, while the letter "M" will instruct the rover to move forwards in the direction it is facing. The user can choose to input a single command, such as "L", or a string of multiple commands (not separated by a blank space) such as "LRMMRLM".

4. Finally, after the rover completes the instructions, the user can choose to deploy another rover when prompted with the question "Do you wish to launch another rover? Y/N" by replying either "Y" for yes or "N" for no. If yes, the user will be taken back to step 2, meaning that the plateau size will not change. If no, the code will end.

# For developers:
- The code uses two enums: "Instruction" defines the instructions "L", "R" and "M", and "CompassDirection" defines the cardinal points.

- The class "Position" defines the position and direction of the rover with three attributes: int "x" for width, int "y" for length, and CompassDirection "facing" for the rover's direction.

- The class "PlateauSize" defines the width and length of the plateau with int "x" and int "y" respectively.

- The class "InputParser" ensures that the String the user inputs is converted into valid enums, which can then be used to construct the Position and Plateau Size.

- The class "Rover" takes in a mandatory attribute and parameter Position and an attribute Plateau Size. Each Rover has two methods: rotate() and advance(). Rotate() can rotate the rover either left or right using the parsed enums "L" and "R", while advance uses the parsed enum "M" to move the rover in the direction it is facing.
