public class Main {
    public static void main(String[] args) {
        // Initial values - don't modify these!
        int lives = 3;
        int score = 100;
        int level = 1;
        int coins = 5;


        lives--;
        lives--;

        coins++;
        coins++;
        coins++;

        lives++;

        level++;

        coins--;
        coins--;
        coins--;
        coins--;



        System.out.println("Game Status:");
        System.out.println("-----------");
        System.out.println("Lives: " + lives);
        System.out.println("Score: " + score);
        System.out.println("Level: " + level);
        System.out.println("Coins: " + coins);
    }
}
