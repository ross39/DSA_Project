package ie.gmit.sw;

//This class will Encrypt the cipher
public class Encrypt extends GenerateCipher
{
    public Encrypt(String plainTxt, String keyword1, String keyword2)
    {
        super();
        plainTxt = clean(plainTxt);
        String[] pairs = splitTxt(plainTxt);
        char[][] keyGrid1 = genKeyTbl(keyword1);
        char[][] keyGrid2 = genKeyTbl(keyword2);
        char first, second;
        int xFirst = 0, yFirst = 0, xSecond = 0, ySecond = 0;
        StringBuilder cipherTxt = new StringBuilder();
        for(String s : pairs)
        {
            first = s.charAt(0);
            second = s.charAt(1);
            for(int y = 0; y < 5; y++)
            {
                for(int x = 0; x < 5; x++)
                {
                    if(ALPHABET_SQUARE[x][y] == first)
                    {
                        xFirst = x;
                        yFirst = y;
                    }
                }

            }
            cipherTxt.append(keyGrid1[xSecond][yFirst]).append(keyGrid2[xFirst][ySecond]);
        }
        //return cipherTxt.toString();
    }
    

}

