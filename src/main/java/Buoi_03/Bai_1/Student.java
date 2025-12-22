package Buoi_03.Bai_1;

public class Student {
    private String id;
    private String name;
    private double score;

    private static int studentCount = 0;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        studentCount++;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

}
