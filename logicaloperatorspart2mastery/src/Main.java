public class Main {
    public static void main(String[] args) {
        // Initial sensor states - don't modify these!
        boolean motionDetected = true;
        boolean doorOpen = false;
        boolean windowOpen = true;
        boolean systemArmed = true;

        // Calculate security conditions
        boolean alarmTrigger1 = systemArmed && (motionDetected || doorOpen);
        boolean alarmTrigger2 = systemArmed && windowOpen && !doorOpen;
        boolean alarmTrigger3 = !systemArmed || (!motionDetected && !windowOpen);

        // Don't modify the code below
        System.out.println("Security System Status:");
        System.out.println("---------------------");
        System.out.println("Alarm Trigger 1: " + alarmTrigger1);
        System.out.println("Alarm Trigger 2: " + alarmTrigger2);
        System.out.println("Alarm Trigger 3: " + alarmTrigger3);
    }
}
