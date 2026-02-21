class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void celebrateBirthday() {
        this.age++;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}
