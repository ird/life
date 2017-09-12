package uk.org.ird;

class GameOfLife {
    public static String turn(String board, int size) {
        /* smallest valid board is 3x3 (length=9) */
        String res = "";
        String plainboard = String.join("", board.split("\n"));
        for(int i=0; i<plainboard.length(); ++i) {
            if(i > 0 && i % size == 0){
                res += "\n";
            }
            int count = countNeighbours(plainboard, size, i);
            if(plainboard.charAt(i) == '#') {
                // populated
                if((count == 2) || (count == 3)){
                    res += '#';
                } else {
                    res += ' ';
                }
            } else if (plainboard.charAt(i) == ' ') {
                // not
                if(count == 3){
                    res += '#';
                } else {
                    res += ' ';
                }
            }
        }
        return res;
    }

    public static int countNeighbours(String plainboard, int size, int i) {
        int count = 0;
        int positions[] = {i-size-1, i-size, i-size+1, i-1, i+1, i+size-1, i+size, i+size+1};
        for(int j=0; j<positions.length; ++j) {
            if(GameOfLife.validNeighbour(size, i, positions[j])) {
                if(plainboard.charAt(positions[j]) == '#'){
                    count += 1;
                }
            }
        }
        return count;
    }

    private static boolean validNeighbour(int size, int i, int n) {
        // return true if n is adjacent to i on a board of size x size (size >= 3)
        if(n < 0 || n >= size*size) {
            return false; // out of bounds
        }
        if(Math.abs(n-i) == 1) { // n and i are meant to be on the same row
            if(i/size == n/size){
                return true;
            }
        } else { // n and i are meant to be on different rows (when size >= 3)
            if(Math.abs(i/size - n/size) == 1){
                return true;
            }
        }
        return false;

    }
}
