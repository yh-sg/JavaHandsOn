package JavaHandsOn.Maze;

import java.util.LinkedList;

public class Maze {
    //Break things down into own methods
    //1. static method (for easier project)
    //2. instance method

    static int[][] maze = {
        {2, 0, 1, 1},
        {1, 1, 0, 1},
        {0, 1, 1, 1}
    };
        // 0 -> Wall
        // 1 -> Path
        // 2 -> Destination
        // Use stack as an intersection! Backtrack when not found!
        // Change the path to 0 when we don't want to walk down the path

        static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args) {
        Position p = new Position(3,0);

        // path.add(p); this add to the end of the list
        path.push(p); // this add in front of the list

        maze[path.peek().y][path.peek().x] = 0; //[row][column]
    }
}
