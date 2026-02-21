public class Main {
    public static void main(String[] args) {

        int classNumber = 3;
        String ability = "";
        int health = 0;
        int power = 0;

        switch (classNumber) {
            case 1:
                ability = "Sword Master";
                health = 100;
                power = 8;
                break;

            case 2:
                ability = "Spell Caster";
                health = 70;
                power = 10;
                break;

            case 3:
                ability = "Sharp Shooter";
                health = 80;
                power = 9;
                break;

            case 4:
                ability = "Life Giver";
                health = 60;
                power = 7;
                break;

            case 5:
                ability = "Shield Bearer";
                health = 90;
                power = 8;
                break;

            default:
                ability = "Unknown";
                health = 50;
                power = 5;
        }

        System.out.println("Character Creation:");
        System.out.println("-----------------");
        System.out.println("Class Number: " + classNumber);
        System.out.println("Special Ability: " + ability);
        System.out.println("Health: " + health);
        System.out.println("Power: " + power);
    }
}
