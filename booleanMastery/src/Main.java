public class Main {
    public static void main(String[] args) {

        boolean isServerOnline = true;
        boolean isMaintenanceMode = false;
        boolean hasBackup = true;
        boolean isUpdating = false;
        boolean isDatabaseConnected = true;
        boolean needsRestart = false;

        System.out.println("Server Status:");
        System.out.println("-------------");
        System.out.println("Server Online: " + isServerOnline);
        System.out.println("Maintenance Mode: " + isMaintenanceMode);
        System.out.println("Backup Available: " + hasBackup);
        System.out.println("Update in Progress: " + isUpdating);
        System.out.println("Database Connected: " + isDatabaseConnected);
        System.out.println("Restart Required: " + needsRestart);
    }
}
