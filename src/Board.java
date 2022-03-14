import java.util.Scanner;

public class Board {

    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the mini crossword!");
        System.out.print("Select your level: (e)asy or (h)ard: ");
        String level = scanner.nextLine();
        if (level.equals("e"))
        {
            Crossword crossword = new Crossword();
            crossword.easy();
        }
        if (level.equals("h"))
        {
            Crossword crossword = new Crossword();
            crossword.hard();
        }
        System.out.print("Do you want to play the other level? (y)es or (n)o: ");
        String nextLevel = scanner.nextLine();
        if (nextLevel.equals("y"))
        {
            if (level.equals("e"))
            {
                Crossword crossword = new Crossword();
                crossword.hard();
            }
            if (level.equals("h"))
            {
                    Crossword crossword = new Crossword();
                    crossword.easy();
            }
        }
    }

}
