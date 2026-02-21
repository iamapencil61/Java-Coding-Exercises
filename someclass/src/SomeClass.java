class SomeClass {
     String foo = "something";
}

class Main {
    public static void main(String[] args) {
        SomeClass sc1 = new SomeClass();
        SomeClass sc2 = new SomeClass();

        sc1.foo = "changed";

        System.out.println(sc2.foo);

    }
}