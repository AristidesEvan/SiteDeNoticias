package com.noticiasonline.demo.controller;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import com.noticiasonline.demo.service.UsuarioService;

@Controller
@CrossOrigin("*")
@RequestMapping("/pdf")
public class ReportController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<byte[]> generatePdf() throws Exception, JRException {
        // ResponseEntity<byte[]> downloadInvoice()

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
                usuarioService.pegarTodosOsUsuarios());

        // JasperReport compileReport = JasperCompileManager.compileReport(new
        // FileInputStream("sr/main/resources/usuarios.jrxml"));
        JasperReport compileReport = JasperCompileManager.compileReport(
                this.getClass().getResourceAsStream("/usuarios.jrxml"));

        HashMap<String, Object> map = new HashMap<>();
        JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);

        // JasperExportManager.exportReportToPdfFile(report, "usuarios.pdf"); Exporta o
        // pdf para a mesma pasta do projeto spring.

        byte[] data = JasperExportManager.exportReportToPdf(report);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=usuarios.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);

    }

    @GetMapping("/pdfPorNome/{nome}")
    public ResponseEntity<byte[]> generatePdfPorNome(@PathVariable String nome) throws Exception, JRException {
        // ResponseEntity<byte[]> downloadInvoice()

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
                usuarioService.pegarPeloNome(nome));

        // JasperReport compileReport = JasperCompileManager.compileReport(new
        // FileInputStream("sr/main/resources/usuarios.jrxml"));
        JasperReport compileReport = JasperCompileManager.compileReport(
                this.getClass().getResourceAsStream("/usuarios.jrxml"));

        HashMap<String, Object> map = new HashMap<>();
        JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);

        // JasperExportManager.exportReportToPdfFile(report, "usuarios.pdf"); Exporta o
        // pdf para a mesma pasta do projeto spring.

        byte[] data = JasperExportManager.exportReportToPdf(report);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=usuarios.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);

    }

}