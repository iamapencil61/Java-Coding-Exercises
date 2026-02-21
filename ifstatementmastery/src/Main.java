public class Main {
    public static void main(String[] args) {

        int score = 95;
        int bonus = 18;


        String status = "Regular Score";

        if (score >= 80 && score <= 100 && bonus >= 10 && bonus <= 20) {
            if ((score > 90 && bonus > 15) || (score > 85 && bonus > 18)) {
                status = "High Score";
            }
        } else {
            status = "Invalid Values";
        }

        System.out.println("Status: " + status);
    }
}
