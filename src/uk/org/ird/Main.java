package uk.org.ird;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String turn1 = GameOfLife.turn(" # \n###\n###", 3);
        // #
        //###
        //###
        System.out.println(turn1);
    }
}
