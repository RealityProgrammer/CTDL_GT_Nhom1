package com.realityprogrammer.bigexercise;

public class Student implements Cloneable {
    private String studentID;
    private String fullName;
    private double avgScore;
    private StudentResult result;

    public Student() { }

    public Student(String studentID, String fullName, double avgScore) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.avgScore = avgScore;
        this.result = calculateResult(avgScore);
    }

    private StudentResult calculateResult(double gpa) {
        if (gpa >= 8) return StudentResult.EXCELLENT;
        if (gpa >= 5) return StudentResult.MODERATE;

        return StudentResult.AVERAGE;
    }

    @Override
    public String toString() {
        return "Student(" +
                "studentID='" + studentID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", avgScore=" + avgScore +
                ", result=" + result +
                ')';
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getAverageScore() {
        return avgScore;
    }

    public void setAverageScore(double avgScore) {
        this.avgScore = avgScore;
        this.result = calculateResult(avgScore);
    }

    public StudentResult getResult() {
        return result;
    }

    public Object clone() {
        return new Student(studentID, fullName, avgScore);
    }
}
