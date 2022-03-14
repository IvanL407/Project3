import java.util.ArrayList;

public class Crossword {
    public void easy()
    {
        //System.out.println("Easy");
        String[][] board = new String[3][3];
        System.out.println();
        int count = 0;
        for (int rows = 0; rows < board.length; rows++)
        {
            for (int cols = 0; cols < board[0].length; cols++)
            {
                board[rows][cols] = " box" + count;
                System.out.print(board[rows][cols]);
                count++;
            }
            System.out.println();
        }
    }
    public void hard()
    {
        //System.out.println("Hard");
    }
}
