package Buoi_2.Bai3;

public class Student {
    private final String id;
    private String name;
    private double score;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be null!");
            return;
        }
        this.name = name;
    }

    public void setScore(double score) {
        if (score < 0 || score > 10) {
            System.out.println("Score must be between 0 and 10!");
            return;
        }
        this.score = score;
    }

    public void xuat() {
        System.out.println("Student [ id: " + id + ", name: " + name + ", score= " + score + " ]");
    }
}
