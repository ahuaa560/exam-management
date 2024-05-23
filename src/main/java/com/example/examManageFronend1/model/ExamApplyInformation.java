package com.example.examManageFronend1.model;

public class ExamApplyInformation {
    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isPaymentStatu() {
        return paymentStatu;
    }

    public void setPaymentStatu(boolean paymentStatu) {
        this.paymentStatu = paymentStatu;
    }

    public String getExamCenterId() {
        return examCenterId;
    }

    public void setExamCenterId(String examCenterId) {
        this.examCenterId = examCenterId;
    }

    public ExamForm getExamForm() {
        return examForm;
    }

    public void setExamForm(ExamForm examForm) {
        this.examForm = examForm;
    }

    public String getExamExamineeNumber() {
        return examExamineeNumber;
    }

    public void setExamExamineeNumber(String examExamineeNumber) {
        this.examExamineeNumber = examExamineeNumber;
    }

    String examId;//考试ID
    int user_id;//用户ID
    //考试类型
    ExamForm examForm;
    boolean paymentStatu;//支付情况
    String examCenterId; //考点ID
    String examExamineeNumber;


    @Override
    public String toString() {
        return "ExamApplyInformation [examId=" + examId + ", user_id=" + user_id
                + ", examCenterId=" + examCenterId + ", examExamineeNumber="
                + examExamineeNumber + ", paymentStatu=" + paymentStatu
                + "]";

    }

}
