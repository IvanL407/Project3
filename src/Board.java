import java.util.Scanner;

public class Board
{
    private String name;
    private String[][] board;

    public Board()
    {
        name = "";
        board = new String[3][3];
    }

    public void start()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        name = scanner.nextLine();

        System.out.println("Welcome to the mini crossword, " + name + "!");
        play();
    }

    public void play()
    {

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
            System.out.println();

        }
        for (int rows = 0; rows < board.length; rows++)
        {
            for (int cols = 0; cols < board[0].length; cols++)
            {
                while (board[rows][cols].contains("box"))
                {
                    getClues();
                }
            }
        }
        checkAnswers();
    }
    public void getClues()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to fill in a (r)ow or (c)olumn? ");
        String choice = scanner.nextLine();

        if (choice.equals("r"))
        {
            Scanner scanner2 = new Scanner(System.in);
            Clues[] clueArray = setupRowClues();
            System.out.print("Which row do you want a hint for: (0 - 2): ");
            int rowChoice = scanner.nextInt();

            System.out.println("Hint for row " + rowChoice + ": " + clueArray[rowChoice].getHint());

            System.out.print("Would you like to try to fill in a box? (y)es or (n)o ");
            String fillIn = scanner2.nextLine();
            if (fillIn.equals("y")) {
                fillBox();
            }
        }
        if (choice.equals("c"))
        {
            Scanner scanner2 = new Scanner(System.in);
            Clues[] clueArray = setupColClues();
            System.out.print("Which column do you want a hint for: (0 - 2): ");
            int colChoice = scanner.nextInt();

            System.out.println("Hint for column " + colChoice + ": " + clueArray[colChoice].getHint());

            System.out.print("Would you like to try to fill in a box? (y)es or (n)o ");
            String fillIn = scanner2.nextLine();
            if (fillIn.equals("y")) {
                fillBox();
            }
        }
    }

    public void fillBox()
    {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Enter the row number of the box you want to fill: (0 - 2) ");
        int boxChoiceRow = scanner.nextInt();
        System.out.print("Enter the column number of the box you want to fill: (0 - 2) ");
        int boxChoiceCol = scanner.nextInt();


        System.out.print("What letter would you like to enter (lowercase): ");
        String letterChoice = scanner3.nextLine();

        System.out.println();
        for (int rows = 0; rows < board.length; rows++)
        {
            for (int cols = 0; cols < board[0].length; cols++)
            {
                board[boxChoiceRow][boxChoiceCol] = " " + letterChoice;
                System.out.print(board[rows][cols]);
            }
            System.out.println();
        }
    }

    public void checkAnswers()
    {
        String[] answers = {"o", "r", "e", "v", "i", "n", "o", "d", "d"};
        int count = 0;
        for (int rows = 0; rows < board.length; rows++)
        {
            for (int cols = 0; cols < board[0].length; cols++)
            {
                for (int x = 0; x < answers.length; x++)
                {
                    if (board[rows][cols].equals(answers[x]))
                    {
                        count++;
                    }
                }
            }
        }
    System.out.println("You got " + count + " of 9 correct. Thanks for playing, " + name + "!");
    }

    public static Clues[] setupRowClues()
    {
        Clues clue0 = new Clues(0, "A naturally occurring mineral");
        Clues clue1 = new Clues(1, "___ Diesel");
        Clues clue2 = new Clues(2, "Not even, but ___");

        Clues[] rowClues = {clue0, clue1, clue2};
        return rowClues;
    }

    public static Clues[] setupColClues()
    {
        Clues clue0 = new Clues(0, "Drake's brand");
        Clues clue1 = new Clues(1, "I don't need it, so I'll get ___ of it");
        Clues clue2 = new Clues(2, "Not the start, but the ___");

        Clues[] colClues = {clue0, clue1, clue2};
        return colClues;
    }
}
