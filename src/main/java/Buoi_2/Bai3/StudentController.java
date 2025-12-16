package Buoi_2.Bai3;

public class StudentController {
    public static void main(String[] args) {
        Student s = new Student("SV001", "Phi", 8.5);
        s.xuat();

        s.setName("");
        s.setScore(-2);
        s.setScore(11);

        s.setName("Ngo Nhat Phi");
        s.setScore(9.25);
        s.xuat();

    }
}
