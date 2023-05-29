package com.example.pazaSautiDb.Controller;

import com.example.pazaSautiDb.Model.Reporter;
import com.example.pazaSautiDb.Repository.ReporterRepository;
import com.example.pazaSautiDb.Services.ReporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ReporterController {

    @Autowired
    private ReporterService reporterService;

    @Autowired
    private ReporterRepository reporterRepository;

    public ReporterController(ReporterService reporterService, ReporterRepository reporterRepository) {
        this.reporterService = reporterService;
        this.reporterRepository = reporterRepository;
    }

    @PostMapping({"/addReporterType"})
    private Reporter addReporterType(Reporter reporter){
        return reporterService.addReporterType(reporter);
    }


    @GetMapping("/reporters")
    public List<Reporter> getAllReporters() {
        return reporterRepository.findAll();
    }

    @GetMapping("/reporters/{id}")
    public ResponseEntity<Reporter> getReporterById(@PathVariable(value = "id") String reporterType)
            throws ResourceNotFoundException {
        Reporter reporter = reporterRepository.findById(Long.valueOf(reporterType))
                .orElseThrow(() -> new ResourceNotFoundException("Reporter not found for this id :: " + reporterType));
        return ResponseEntity.ok().body(reporter);
    }
}
