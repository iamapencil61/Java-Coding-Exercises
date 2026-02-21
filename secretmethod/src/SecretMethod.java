class SecretMethod {
    public static void secret(int x) {
        System.out.println(x + " is the secret!");
    }
}

class Main {
    public static void main(String[] args) {
        SecretMethod.secret(5);
    }
}