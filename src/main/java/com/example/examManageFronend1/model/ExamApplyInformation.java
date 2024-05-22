package com.example.examManageFronend1.model;

public class ExamApplyInformation {
    String examId;//考试ID
    int user_id;//用户ID
    //考试类型
    ExamForm examForm;
    boolean paymentStatu;//支付情况
    String examCenterId; //考点ID
    String examExamineeNumber;

    public String getExamId() { return examId; }
    public int getUser_id() { return user_id; }
    public String getExamCenterId() { return examCenterId; }
    public String getExamExamineeNumber() { return examExamineeNumber; }
    public boolean isPaymentStatu() { return paymentStatu; }
    public void setExamId(String examId) { this.examId = examId; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setExamCenterId(String examCenterId) { this.examCenterId = examCenterId; }
    public void setPaymentStatu(boolean paymentStatu) { this.paymentStatu = paymentStatu; }
    public void setExamExamineeNumber(String examExamineeNumber) { this.examExamineeNumber = examExamineeNumber; }
    public void setExamForm(ExamForm examForm) { this.examForm = examForm; }
    public ExamForm getExamForm(){return this.examForm;}
    @Override
    public String toString() {
        return "ExamApplyInformation [examId=" + examId + ", user_id=" + user_id
                + ", examCenterId=" + examCenterId + ", examExamineeNumber="
                + examExamineeNumber + ", paymentStatu=" + paymentStatu
                + "]";

    }

}
