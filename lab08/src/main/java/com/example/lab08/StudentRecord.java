package com.example.lab08;

public class StudentRecord {
    private String StudentID;
    private float Assignments;
    private float Midterm;
    private float Final_exam;
    private float Final_mark;
    private String Letter_grade;



    public StudentRecord(String StudentID, float Assignments,
                         float Midterm, float Final_exam){
        this.StudentID = StudentID;
        this.Assignments = Assignments;
        this.Midterm = Midterm;
        this.Final_exam = Final_exam;
        this.Final_mark = (Final_exam*0.5f) + (Midterm*0.3f) + (Assignments*0.2f);
        if (80f<=Final_mark && Final_mark<=100f) {
            Letter_grade = "A";
        }else if (70f<=Final_mark && Final_mark<=79f) {
            Letter_grade = "B";
        }else if (60f<=Final_mark && Final_mark<=69f) {
            Letter_grade = "C";
        }else if (50f<=Final_mark && Final_mark<=59f) {
            Letter_grade = "D";
        }else{
            Letter_grade = "F";
        }
    }

    //    private void setLetterGrade(){
//        Letter_grade = "A";
//    }
    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public float getAssignments() {
        return Assignments;
    }

    public void setAssignments(float assignments) {
        Assignments = assignments;
    }

    public float getMidterm() {
        return Midterm;
    }
    public void setMidterm(float midterm) {
        Midterm = midterm;
    }


    public float getFinal_exam() {
        return Final_exam;
    }

    public void setFinal_exam(float final_exam) {
        Final_exam = final_exam;
    }
    public float getFinal_mark(){
        return this.Final_mark;
    }
    public String getLetter_grade(){
        return this.Letter_grade;
    }
}
