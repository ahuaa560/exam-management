package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.service.PdfService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/downloadAdmissionTicket")
    public ResponseEntity<byte[]> downloadAdmissionTicket(
            @RequestParam String userId,
            @RequestParam String examId) {

        byte[] pdfBytes = null;
        try {
            pdfBytes = pdfService.generateAdmissionTicket(userId,examId);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=admission_ticket.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}


