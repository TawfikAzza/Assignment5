package be;

import bll.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {

    private List<GradeInfo> gradeReport = new ArrayList<>();
    private String education;

    public Student(int id, String name, String education) {
        super(id,name);
        this.education = education;
    }

    public double getAverageGrade() {
        double avgGrade;
        double totalGrade=0;

        for (GradeInfo gi: gradeReport) {
            totalGrade+=gi.getGrade();
        }

        avgGrade=totalGrade/gradeReport.size();
        return avgGrade;
    }
    public List<GradeInfo> getGradeReport() {
        return gradeReport;
    }

    public int getGrade(String education) {
        int grade = 0;
        for (GradeInfo gi: gradeReport) {
            if(Objects.equals(gi.getSubject(), education)) {
                grade=gi.getGrade();
            }
        }
        return grade;
    }
    public String getEducation() {
        return education;
    }

    public void addGrade(GradeInfo grade) {
        gradeReport.add(grade);
    }

    @Override
    public String toString() {
        return String.format("%s %20s %35s",super.toString(),getEducation(),getAverageGrade());
    }

}
