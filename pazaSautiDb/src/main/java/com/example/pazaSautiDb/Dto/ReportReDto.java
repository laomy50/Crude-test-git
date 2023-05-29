package com.example.pazaSautiDb.Dto;

import lombok.Data;

@Data
public class ReportReDto {
    private String location;
    private String nameOfCrime;
    private String caseName;
    private String date;
    private String image;
    private String video;
    private String file;
    private String description;

    private  Long reporter;


}
