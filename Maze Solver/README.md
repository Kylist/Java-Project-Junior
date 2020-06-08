

1	Brief Problem Summary
This project is to create a basic maze solving algorithm to find it’s way from the top left corner of the maze to the bottom right based on given auto-generated maze. It can be considered as a very basic AI.


2	Basic Maze-Solving Algorithm
When you have a choice in what direction to travel, make a choice. Follow that corridor and choose a new branch to go down as needed. If you reach a dead end, either because you’re blocked by walls or there’s nowhere new to visit, you backup until you find a new route to explore.
The way we do this with an algorithm is a stack.
push start position on top of stack
while maze exploartion is not done and and stack isn’t empty peek to get our current position
if we can go north and haven’t visited there yet push the location to the north on the stack mark the current location as visited
else if we can go south... repeat for east and west
1A term that might be worth looking up on wikipedia.
 



else
we can’t go anywhere so we are at a dead end mark current as a dead end
pop off the stack
Lookup depth first search for more details. The way this works for our code is that locations are represented by Cell objects and we can mark them visited by coloring them.


3.1	Maze
Run this class since it has the main method in it. It creates the MazeGridPanel and passes in parameters to set up how large of a maze you want. I’ve found that anything above a 100 × 100 maze is pretty slow.

3.2	MazeGridPanel
This holds our actuals maze. Our maze is held in the 2D array of Cell objects, called maze.
solveMaze() is your assignment and genDFSMaze() is your extra credit. solveMazeQueue() solves the maze using breadth-first search. visited() will check if the Cell at row or col has been visited by looking at the color (you should read this method.). genNWMaze() is the method I wrote that actually creates the maze.

3.3	Cell
The maze is made up of individual pieces of a grid, each represented by a Cell. Each cell has a boolean for each of the four possible walls it can have in any direction, as well as a row and col for easy reference to its location in the maze. We’ll keep track of whether we’ve seen a Cell by coloring it. My code considers white and red cells unvisited (red is used to mark the exit of the maze). A cell colored anything else has been seen or visited in some way, shape, or form. We can change the color of a Cell using the setBackground method, which takes in a Color. We can retrieve the color of a Cell using the
getBackground().


 




