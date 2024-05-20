package com.example.examManageFronend1.model;

public class ExamineeNecessary {
    String examExamineeNumber;//考生考试号
    String examineeDemand;//考生需求
    boolean solveStatu;//解决情况

    public String getExamExamineeNumber() { return examExamineeNumber; }
    public String getExamineeDemand() { return examineeDemand; }
    public boolean getSolveStatu() { return solveStatu; }
    public void setExamExamineeNumber(String examExamineeNumber) { this.examExamineeNumber = examExamineeNumber; }
    public void setExamineeDemand(String examineeDemand) { this.examineeDemand = examineeDemand; }
    public void setSolveStatu(boolean solveStatu) { this.solveStatu = solveStatu; }

    @Override
    public String toString() {
        return "ExamineeNecessary [examExamineeNumber=" + examExamineeNumber
                + ", examineeDemand=" + examineeDemand + ", solveStatu="
                + solveStatu + "]";
    }

}
