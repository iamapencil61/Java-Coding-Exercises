class ProcessGrades {
    public static int[][] processGrades(int numStudents, int[] subjectsPerStudent) {

        int grades[][] = new int[numStudents][];

        for (int student = 0; student < numStudents; student++) {
            grades[student] = new int[subjectsPerStudent[student]];

            for (int subject = 0; subject < subjectsPerStudent[student]; subject++) {

                int value = (student + 1) * 10 + subject + 1;
                grades[student][subject] = value;
            }
        }
        return grades;
    }
}
