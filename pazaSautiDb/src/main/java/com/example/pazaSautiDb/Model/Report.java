package com.example.pazaSautiDb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "reports")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportId;
    private String location;
    private String nameOfCrime;
    private String caseName;
    private String date;
    private String image;
    private String video;
    private String file;
    private String description;

    @ManyToOne
    private Reporter reporter;
public Report(Long reportId){
    this.reportId=reportId;
}

}
