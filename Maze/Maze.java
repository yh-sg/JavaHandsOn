package JavaHandsOn.Maze;

import java.util.ArrayList;
import java.util.LinkedList;

public class Maze {
    //Break things down into own methods
    //1. static method (for easier project)
    //2. instance method

        // 0 -> Wall
        // 1 -> Path
        // 2 -> Destination
        // Use stack as an intersection! Backtrack when not found!
        // Change the path to 0 when we don't want to walk down the path

    public static void main(String[] args) {

        ArrayList<MazeStructure> mazes = new ArrayList<MazeStructure>(); //Create a list of mazes

        MazeStructure m = new MazeStructure();

        int[][] maze = {
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };

        m.maze = maze;
        m.start = new Position(4,8);
        m.path = new LinkedList<Position>();

        MazeStructure n = new MazeStructure();

        int[][] maze1 = {
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };

        n.maze = maze1;
        n.start = new Position(4,8);
        n.path = new LinkedList<Position>();

        mazes.add(m);
        mazes.add(n);

        int i = 0 ;
        while(i < mazes.size()){
            if(solveMaze(mazes.get(i))){ //y,x
                System.out.println("You Won!");
            }else{
                System.out.println("No Path.");
            }
            i++;
        }
    }

    private static boolean solveMaze(MazeStructure m){

        Position p = m.start;

        // path.add(p); this add to the end of the list
        m.path.push(p); // this add in front of the list

        // maze[path.peek().y][path.peek().x] = 0; //[row][column]

        while(true){
            int y = m.path.peek().y;
            int x = m.path.peek().x;

            m.maze[y][x] = 0;

            if(isValid(y+1,x, m)){
                //down
                if(m.maze[y+1][x] == 2){
                    System.out.println("Move down.");
                    return true;
                }else if(m.maze[y+1][x] == 1){
                    System.out.println("Move down");
                    m.path.push(new Position(y+1 ,x));
                    continue;
                }
            }

            if(isValid(y,x-1 ,m)){
                //left
                if(m.maze[y][x-1] == 2){
                    System.out.println("Move left.");
                    return true;
                }else if(m.maze[y][x-1] == 1){
                    System.out.println("Move left");
                    m.path.push(new Position(y ,x-1));
                    continue;
                }
            }


            if(isValid(y-1,x,m)){
                //up
                if(m.maze[y-1][x] == 2){
                    System.out.println("Move up.");
                    return true;
                }else if(m.maze[y-1][x] == 1){
                    System.out.println("Move up");
                    m.path.push(new Position(y-1 ,x));
                    continue;
                }
            }

            if(isValid(y,x+1,m)){
                //right
                if(m.maze[y][x+1] == 2){
                    System.out.println("Move right.");
                    return true;
                }else if(m.maze[y][x+1] == 1){
                    System.out.println("Move right");
                    m.path.push(new Position(y ,x+1));
                    continue;
                }
            }

            //when no path
            m.path.pop();
            System.out.println("Moved back!");
            if(m.path.size() <= 0){
                // System.out.println("No path");
                return false;
            }
        }
    }

    public static boolean isValid(int y, int x, MazeStructure m){
        if(y < 0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length){
            return false;
        }
        return true;
    }
}
