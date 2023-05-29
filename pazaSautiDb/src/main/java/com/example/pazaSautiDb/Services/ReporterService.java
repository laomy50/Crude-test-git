package com.example.pazaSautiDb.Services;

import com.example.pazaSautiDb.Model.Reporter;
import com.example.pazaSautiDb.Repository.ReporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporterService {

    @Autowired
    private ReporterRepository reporterRepository;

    public ReporterService(ReporterRepository reporterRepository) {
        this.reporterRepository = reporterRepository;
    }

    public Reporter addReporterType(Reporter reporter){
        return reporterRepository.save(reporter);
    }
}
