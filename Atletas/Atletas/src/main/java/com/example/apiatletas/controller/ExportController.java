package com.example.apiatletas.controller;

import com.example.apiatletas.model.Atleta;
import com.example.apiatletas.service.AtletaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

@RestController
@RequestMapping("/api/export")
public class ExportController {
    private final AtletaService service;
    private final ObjectMapper mapper = new ObjectMapper();

    public ExportController(AtletaService service){ this.service = service; }

    @GetMapping("/atletas/json")
    public ResponseEntity<?> exportJson() throws Exception {
        List<Atleta> atletas = service.findAll();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=atletas.json")
                .contentType(MediaType.APPLICATION_JSON)
                .body(mapper.writeValueAsString(atletas));
    }

    @GetMapping("/atletas/csv")
    public ResponseEntity<?> exportCsv() throws Exception {
        List<Atleta> atletas = service.findAll();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter printer = new CSVPrinter(new OutputStreamWriter(out), CSVFormat.DEFAULT
                .withHeader("ID","Nombre","Apellido","Nacionalidad","SalarioBase"));
        for(Atleta a : atletas){
            printer.printRecord(a.getId(), a.getNombre(), a.getApellido(), a.getNacionalidad(), a.getSalarioBase());
        }
        printer.flush();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=atletas.csv")
                .contentType(MediaType.TEXT_PLAIN)
                .body(out.toByteArray());
    }
}
