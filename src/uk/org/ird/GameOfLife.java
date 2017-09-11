package uk.org.ird;

class GameOfLife {
    public static String turn(String board) {
        String res = "";
        String rows[] = board.split("\n");
        String plainboard = String.join("", board.split("\n"));
        int n = rows.length;
        System.out.println("Size: " + n);
        int i = 0;
        for(int x=0; x<n; ++x) {
            for(int y=0; y<n; ++y) {
                if(plainboard.charAt(i) == '#') {
                    // populated
                    System.out.println(i + " is populated. It has "+GameOfLife.countNeighbours(plainboard, n, i) + " friends");
                } else if (plainboard.charAt(i) == ' ') {
                    // not
                    System.out.println(i + " is empty. It has "+GameOfLife.countNeighbours(plainboard, n, i) + " friends");
                }
                ++i;
            }
        }
        return res;
    }

    public static int countNeighbours(String plainboard, int size, int i) {
        int count = 0;
        //TODO: Rework - this won't work!
        int positions[] = {size+1, size, size-1, 1, -1, (-1-size), -size, 1-size};
        for(int j=0; j<positions.length; ++j) {
            if((i-positions[j] >= 0) && (i-positions[j] < size*size)) {
                if(plainboard.charAt(i-positions[j]) == '#'){
                    count += 1;
                }
            }
        }
        return count;
    }
}
