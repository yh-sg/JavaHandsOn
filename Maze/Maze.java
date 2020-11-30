package JavaHandsOn.Maze;

import java.util.LinkedList;

public class Maze {
    //Break things down into own methods
    //1. static method (for easier project)
    //2. instance method

    static int[][] maze = {
        {2, 0, 1, 1},
        {1, 1, 1, 0},
        {0, 1, 1, 1}
    };
        // 0 -> Wall
        // 1 -> Path
        // 2 -> Destination
        // Use stack as an intersection! Backtrack when not found!
        // Change the path to 0 when we don't want to walk down the path

        static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args) {
        Position p = new Position(0,3); //y,x

        // path.add(p); this add to the end of the list
        path.push(p); // this add in front of the list


        // maze[path.peek().y][path.peek().x] = 0; //[row][column]


        while(true){
            int y = path.peek().y;
            int x = path.peek().x;

            maze[y][x] = 0;

            //down
            if(maze[y+1][x] == 2){
                System.out.println("Move down, You won!!!");
                return;
            }else if(maze[y+1][x] == 1){
                System.out.println("Move down");
                path.push(new Position(y+1 ,x));
                continue;
            }

            //left
            if(maze[y][x-1] == 2){
                System.out.println("Move left, You won!!!");
                return;
            }else if(maze[y][x-1] == 1){
                System.out.println("Move left");
                path.push(new Position(y ,x-1));
                continue;
            }

            //up
            if(maze[y-1][x] == 2){
                System.out.println("Move up, You won!!!");
                return;
            }else if(maze[y-1][x] == 1){
                System.out.println("Move up");
                path.push(new Position(y-1 ,x));
                continue;
            }

            //right
            if(maze[y][x+1] == 2){
                System.out.println("Move right, You won!!!");
                return;
            }else if(maze[y+1][x+1] == 1){
                System.out.println("Move right");
                path.push(new Position(y ,x+1));
                continue;
            }

            //when no path
            path.pop();
            if(path.size() <= 0){
                System.out.println("No path");
            }
        }
    }
}
