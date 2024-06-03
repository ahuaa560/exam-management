package com.example.examManageFronend1.service;


import com.example.examManageFronend1.mapper.*;
import com.example.examManageFronend1.model.*;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PdfService {

    public final ExamMapper examMapper;
    public final ExamineeMapper examineeMapper;
    public final ExamApplyInformationMapper examApplyInformationMapper;
    public final ExamCenterMapper examCenterMapper;
    public final RegionMapper regionMapper;

    public PdfService(ExamMapper examMapper, ExamineeMapper examineeMapper, ExamApplyInformationMapper examApplyInformationMapper, ExamCenterMapper examCenterMapper, RegionMapper regionMapper) {
        this.examMapper = examMapper;
        this.examineeMapper = examineeMapper;
        this.examApplyInformationMapper = examApplyInformationMapper;
        this.examCenterMapper = examCenterMapper;
        this.regionMapper=regionMapper;
    }


    public byte[] generateAdmissionTicket(String userId, String examId) throws IOException, WriterException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        Exam exam = examMapper.getExamByExamId(examId);
        Examinee examinee=examineeMapper.getExamineeByUserId(Integer.parseInt(userId));
        ExamApplyInformation examApplyInformation=examApplyInformationMapper.getExamApplyInformationByUserIdAndExamId(userId,examId);
        ExamCenter examCenter =examCenterMapper.getExamCenterByExamCenterId(examApplyInformation.getExamCenterId());
        Region region=regionMapper.getRegionById(examCenter.getRegionId());

        //考生信息
        String studentName=examinee.getExamineeName();
        String examExamineeNumber=examApplyInformation.getExamExamineeNumber();


        // 考试信息
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime examStartTime = exam.getStartExamTime();
        String startExamTime = examStartTime.format(formatter);//考试开始时间
        LocalDateTime examEndTime = exam.getEndExamTime();
        String endExamTime = examEndTime.format(formatter);//考试结束时间
        String examName=exam.getExamName();//考试名称
        String examForm;//考试类型
        if(exam.getExamForm()==ExamForm.SHENGKAO){
            examForm="省考";
        }
        else  {
            examForm="统考";
        }

        //考点信息
        String examLocation=region.getCityName()+region.getDistrictsName()+examCenter.getExamCenterLocation();//考点地址
        String examCenterName=examCenter.getExamCenterName();//考点名称


        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // 字体
        String fontPath = "src/main/resources/static/fonts/NotoSansSC-Regular.ttf"; // Update the path as needed
        PdfFont font = PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H, true);

        // 标题
        Paragraph title = new Paragraph(examName+" 准考证")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(20)
                .setFont(font)
                .setBold();

        // Student Information
        Paragraph studentInfo = new Paragraph("考生姓名：" + studentName)
                .setFontSize(14)
                .setFont(font)
                .setMarginTop(10)
                .setMarginBottom(2);
        Paragraph studentIdInfo = new Paragraph("准考证号：" + examExamineeNumber)
                .setFontSize(14)
                .setFont(font)
                .setMarginBottom(5);

        // 考试信息
        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 3}))
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginTop(20);

        table.addCell(new Paragraph("考试名称").setFont(font).setBold()).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Paragraph(examName).setFont(font));

        table.addCell(new Paragraph("考试类型").setFont(font).setBold()).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Paragraph(examForm).setFont(font));

        table.addCell(new Paragraph("考试开始时间").setFont(font).setBold()).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Paragraph(startExamTime).setFont(font));

        table.addCell(new Paragraph("考试结束时间").setFont(font).setBold()).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Paragraph(endExamTime).setFont(font));


        //考点信息
        Table examCenterTable = new Table(UnitValue.createPercentArray(new float[]{1, 3}))
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginTop(20);

        examCenterTable.addCell(new Paragraph("考点地区").setFont(font).setBold()).setTextAlignment(TextAlignment.CENTER);
        examCenterTable.addCell(new Paragraph("四川").setFont(font));

        examCenterTable.addCell(new Paragraph("考点名称").setFont(font).setBold()).setTextAlignment(TextAlignment.CENTER);
        examCenterTable.addCell(new Paragraph(examCenterName).setFont(font));

        examCenterTable.addCell(new Paragraph("考点地址").setFont(font).setBold()).setTextAlignment(TextAlignment.CENTER);
        examCenterTable.addCell(new Paragraph(examLocation).setFont(font));


        // 考试须知
        Paragraph instructionsTitle = new Paragraph("考试须知：")
                .setFontSize(14)
                .setFont(font)
                .setBold()
                .setMarginTop(20);

        List instructionsList = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(font);

        instructionsList.add(new ListItem("请务必准时参加考试。"));
        instructionsList.add(new ListItem("考试过程中请保持安静，不要交头接耳。"));
        instructionsList.add(new ListItem("禁止携带任何通讯工具进入考场。"));
        instructionsList.add(new ListItem("考试结束后，请将试卷和答题卡交给监考人员。"));
        instructionsList.add(new ListItem("违反考场纪律的行为将被取消考试资格。"));


        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        String printTime = currentTime.format(formatter);


        // Adding QR code
        Image qrCodeImage = generateQRCodeImage("考生: " + studentName + ", 考试时间: " + startExamTime + ", 考试地点: " + examLocation);
        qrCodeImage.setMarginTop(30);
        qrCodeImage.setHorizontalAlignment(com.itextpdf.layout.property.HorizontalAlignment.CENTER);

        // Adding elements to document
        document.add(title);
        document.add(studentInfo);
        document.add(studentIdInfo);
        document.add(table);
        document.add(examCenterTable);
        document.add(instructionsTitle);
        document.add(instructionsList);
        //document.add(qrCodeImage);
        //document.add(footer);

        // 在左上角添加打印时间
        PdfCanvas pdfCanvas = new PdfCanvas(pdfDoc.getFirstPage());
        Canvas canvas = new Canvas(pdfCanvas, pdfDoc, pdfDoc.getDefaultPageSize());
        Paragraph printTimeParagraph = new Paragraph( printTime)
                .setFontSize(12)
                .setFont(font);
        canvas.showTextAligned(printTimeParagraph, 20, pdfDoc.getDefaultPageSize().getHeight() - 20, TextAlignment.LEFT);

        // Adding a footer
        String footerText = "请携带准考证参加考试";
        Paragraph footer = new Paragraph(footerText)
                .setFontSize(12)
                .setFont(font)
                .setTextAlignment(TextAlignment.CENTER);
        canvas.showTextAligned(footer, 297.5f, 20, pdfDoc.getNumberOfPages(), TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);


        document.close();

        return byteArrayOutputStream.toByteArray();
    }

    private Image generateQRCodeImage(String text) throws WriterException, IOException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 200, 200);
        Path path = FileSystems.getDefault().getPath("qr_code.png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        Image qrCodeImage = new Image(com.itextpdf.io.image.ImageDataFactory.create("qr_code.png"));
        return qrCodeImage;
    }
}
