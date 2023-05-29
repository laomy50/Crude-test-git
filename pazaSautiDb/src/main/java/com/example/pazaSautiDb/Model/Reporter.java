package com.example.pazaSautiDb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "reporters")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reporter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reporterId;
    private String reporterType;
    private String firstNme;
    private String middleName;
    private String lastName;

    public Reporter(Long reporterId){
        this.reporterId=reporterId;
    }

}
