import java.util.Scanner;

public class ReVolt {

    public static class Pair {
        public int X = 0;
        public int Y = 0;
    }

    public static boolean move(char[][] m, Pair l, int mSize, String command) {
        Pair n = new Pair();

        switch (command) {
            case "up":
                if (l.X == 0) {
                    n.X = mSize - 1;
                } else {
                    n.X = l.X - 1;
                }
                n.Y = l.Y;

                if (m[n.X][n.Y] == '-') {
                    m[n.X][n.Y] = 'f';
                    if(m[l.X][l.Y]=='B'){
                        l.X = n.X;
                    }else{
                        m[l.X][l.Y] = '-';
                        l.X = n.X;
                    }
                } else if (m[n.X][n.Y] == 'T') {
                    return false;
                } else if (m[n.X][n.Y] == 'F') {
                    m[n.X][n.Y] = 'f';
                    m[l.X][l.Y] = '-';
                    return true;
                } else {
                    m[l.X][l.Y] = '-';
                    l.X = n.X;
                    return move(m, l, mSize, command);
                }
                break;
            case "right":
                if (l.Y == mSize - 1) {
                    n.Y = 0;
                    n.X = l.X;
                } else {
                    n.X = l.X;
                    n.Y = l.Y + 1;
                }
                if (m[n.X][n.Y] == '-') {
                    m[n.X][n.Y] = 'f';
                    if (m[l.X][l.Y] != 'B') {
                        m[l.X][l.Y] = '-';
                    }
                    l.Y = n.Y;
                } else if (m[n.X][n.Y] == 'T') {
                    return false;
                } else if (m[n.X][n.Y] == 'F') {
                    m[n.X][n.Y] = 'f';
                    m[l.X][l.Y] = '-';
                    return true;
                } else {
                    m[l.X][l.Y] = '-';
                    l.Y = n.Y;
                   return move(m, l, mSize, command);
                }
                break;
            case "down":
                if (l.X == mSize - 1) {
                    n.X = 0;
                } else {
                    n.X = l.X + 1;
                }
                n.Y = l.Y;

                if (m[n.X][n.Y] == '-') {
                    m[n.X][n.Y] = 'f';
                    if(m[l.X][l.Y]=='B'){
                        l.X = n.X;
                    }else{
                        m[l.X][l.Y] = '-';
                        l.X = n.X;
                    }
                } else if (m[n.X][n.Y] == 'T') {
                    return false;
                } else if (m[n.X][n.Y] == 'F') {
                    m[n.X][n.Y] = 'f';
                    m[l.X][l.Y] = '-';
                    return true;
                } else {
                    m[l.X][l.Y] = '-';
                    l.X = n.X;
                   return move(m, l, mSize, command);
                }
                break;
            case "left":
                if (l.Y == 0) {
                    n.X = l.X;
                    n.Y = mSize - 1;
                } else {
                    n.X = l.X;
                    n.Y = l.Y - 1;
                }

                if (m[n.X][n.Y] == '-') {
                    m[n.X][n.Y] = 'f';
                    if (m[l.X][l.Y] != 'B') {
                        m[l.X][l.Y] = '-';
                    }
                    l.Y = n.Y;
                } else if (m[n.X][n.Y] == 'T') {
                    return false;
                } else if (m[n.X][n.Y] == 'F') {
                    m[n.X][n.Y] = 'f';
                    m[l.X][l.Y] = '-';
                    return true;
                } else {
                    m[l.X][l.Y] = '-';
                    l.Y = n.Y;
                    return move(m, l, mSize, command);
                }
                break;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        Pair l = new Pair();

        int mSize = cin.nextInt();
        int commands = cin.nextInt();

        char[][] matrix = new char[mSize][mSize];

        cin.nextLine();
        for (int r = 0; r < mSize; r++) {
            String str = cin.nextLine();

            for (int c = 0; c < mSize; c++) {

                char current = str.charAt(c);
                if (current == 'f') {
                    l.X = r;
                    l.Y = c;
                }

                matrix[r][c] = current;

            }

        }

        boolean hasFinished = false;

        for (int i = 0; i < commands; i++) {

            String command = cin.nextLine();

           hasFinished = move(matrix, l, mSize, command);

            if (hasFinished) {
                System.out.println("Player won!");
                break;
            }
        }

        if (!hasFinished) {
            System.out.println("Player lost!");
        }

        for (int i = 0; i < mSize; i++) {
            String row = new String();
            for (int j = 0; j < mSize; j++) {
                row += matrix[i][j];
            }
            System.out.println(row);
        }
    }

}
