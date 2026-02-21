public class Main {
    public static void main(String[] args) {

        boolean hasShield = true;
        boolean hasWeapon = true;
        boolean isInjured = false;
        boolean hasPotion = false;


        boolean canFight = hasWeapon && !isInjured;
        boolean needsHealing = isInjured || !hasShield;
        boolean isVulnerable = !hasShield && !hasWeapon;
        boolean shouldUsePotion = hasPotion && isInjured;
        boolean isReadyForBattle = hasWeapon && hasShield && !isInjured;


        System.out.println("Character Status Check:");
        System.out.println("---------------------");
        System.out.println("Can Fight: " + canFight);
        System.out.println("Needs Healing: " + needsHealing);
        System.out.println("Is Vulnerable: " + isVulnerable);
        System.out.println("Should Use Potion: " + shouldUsePotion);
        System.out.println("Ready for Battle: " + isReadyForBattle);
    }
}
