public class Main {
    public static void main(String[] args) {

        boolean motionDetected = true;
        boolean doorLocked = false;
        boolean windowsClosed = true;
        boolean alarmActive = true;
        boolean nightTime = true;


        boolean isSecure = !((!doorLocked) && motionDetected);
        boolean needsAttention = !(windowsClosed || alarmActive);
        boolean isHighRisk = !(doorLocked && windowsClosed) && nightTime;
        boolean shouldAlert = !isSecure || needsAttention;


        System.out.println("Smart Home Security Status:");
        System.out.println("-------------------------");
        System.out.println("Home is Secure: " + isSecure);
        System.out.println("Needs Attention: " + needsAttention);
        System.out.println("High Risk Situation: " + isHighRisk);
        System.out.println("Alert Required: " + shouldAlert);
    }
}