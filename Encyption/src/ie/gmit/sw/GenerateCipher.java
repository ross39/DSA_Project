package ie.gmit.sw;
import java.util.*;


public class GenerateCipher extends Runnable
{
    public static char[] ALPHABET = "ABCDEFGHIJKLMNOPRSTUVWXY".toCharArray();
    public static final char[][] ALPHABET_SQUARE = new char[5][5];

    // static block to populate the block
    static
    {
        int x = 0, y = 0;
        for (char c : ALPHABET)
        {
            ALPHABET_SQUARE[x][y] = c;
            x++;
            if (x == 5)
            {
                x = 0;
                y++;
            }
        }
    }


    //this cleans the cipher text
    public static String clean(String input)
    {
        input = input.trim().replace(" ", "").replace("Q", "").toUpperCase();
        StringBuilder cleanTxt = new StringBuilder();
        for (char c : input.toCharArray())
        {
            if (Character.getType(c) == Character.UPPERCASE_LETTER)
            {
                cleanTxt.append(c);
            }
        }
        return cleanTxt.toString();
    }

    //Generate the 5 x 5 using the users keyword
    public static char[][] genKeyTbl(String keyword)
    {
        keyword = clean(keyword);
        char[][] keyGrid = new char[5][5];
        List<Character> usedChars = new ArrayList<>();
        int x = 0, y = 0;
        for (char c : keyword.toCharArray())
        {
            if (!usedChars.contains(c))
            {
                keyGrid[x][y] = c;
                usedChars.add(c);
                x++;
                if (x == 5)
                {
                    x = 0;
                    y++;
                }
                if (y == 5)
                {
                    return keyGrid;
                }
            }
        }
        for(char c: ALPHABET)
        {
            if(!usedChars.contains(c))
            {
                keyGrid[x][y] = c;
                x++;
                if(x == 5)
                {
                    x = 0;
                    y++;
                }
                if(y == 5)
                {
                    return keyGrid;
                }
            }
        }
        return keyGrid;
    }

    public static String[] splitTxt(String plainTxt)
    {
        if(plainTxt.length() % 2 != 0)
            plainTxt += "X";
        String[] pairsTxt = new String[plainTxt.length() / 2];
        int count = 0;
        for (int i = 0; i < (plainTxt.length() / 2); i++)
        {
            pairsTxt[i] = plainTxt.substring(count, count + 2);
        }
        return pairsTxt;
    }
}
