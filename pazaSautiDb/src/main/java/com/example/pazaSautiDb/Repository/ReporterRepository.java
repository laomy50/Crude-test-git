package com.example.pazaSautiDb.Repository;

import com.example.pazaSautiDb.Model.Reporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporterRepository extends JpaRepository<Reporter, Long> {
}
