package com.example.pazaSautiDb.Controller;

import com.example.pazaSautiDb.Dto.ReportReDto;
import com.example.pazaSautiDb.Model.Report;
import com.example.pazaSautiDb.Repository.ReportRepository;
import com.example.pazaSautiDb.Services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportRepository reportRepository;

    public ReportController(ReportService reportService, ReportRepository reportRepository) {
        this.reportService = reportService;
        this.reportRepository = reportRepository;
    }

    @GetMapping("/reports")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable(value = "id") Long reportId)
            throws ResourceNotFoundException {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found for this id :: " + reportId));
        return ResponseEntity.ok().body(report);
    }

    @PostMapping("/reports")
    public Report createreports(@Valid @RequestBody Report report, ReportReDto reportReDto) {
        return reportService.createreports(report, reportReDto);
    }


    @PutMapping("/reports/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable(value = "id") Long reportId,
                                                   @Valid @RequestBody Report reportDetails) throws ResourceNotFoundException {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found for this id :: " + reportId));

        report.setFile(reportDetails.getFile());
        report.setDate(reportDetails.getDate());
        report.setImage(reportDetails.getImage());
        report.setLocation(reportDetails.getLocation());
        report.setDescription(reportDetails.getDescription());
        report.setVideo(reportDetails.getVideo());
        report.setNameOfCrime(reportDetails.getNameOfCrime());
        final Report updatedReport = reportRepository.save(report);
        return ResponseEntity.ok(updatedReport);
    }

    @DeleteMapping("/reports/{id}")
    public Map<String, Boolean> deleteReport(@PathVariable(value = "id") Long reportId)
            throws ResourceNotFoundException {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found for this id :: " + reportId));

        reportRepository.delete(report);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

//    image cotroller
//@Autowired
//public ReportService imageService;
//    @PostMapping(value ="upload")
//    public ResponseEntity uploadImage(@RequestParam MultipartFile file){
//        return this.imageService.uploadToLocalFileSystem(file);
//    }
//    @GetMapping(
//            value = "getImage/{imageName:.+}",
//            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE,MediaType.APPLICATION_PDF_VALUE,MediaType.APPLICATION_STREAM_JSON_VALUE}
//    )
//    public @ResponseBody byte[] getImageWithMediaType(@PathVariable(name = "imageName") String fileName) throws IOException, IOException {
//        return this.imageService.getImageWithMediaType(fileName);
//    }
}
