class Student {

    private String studentId;
    int grade;
    protected String name;
    public String school;

    public Student(String studentId, String name, int grade, String school) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.school = school;
    }

    public String getInfo() {
        String info = "[" + studentId + "] " + name + " - Grade " + grade + " at " + school;
        return info;
    }
}