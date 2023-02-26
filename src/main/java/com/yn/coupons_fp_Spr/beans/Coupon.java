package com.yn.coupons_fp_Spr.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import javax.persistence.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Base64;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private double price;
    @Column(name = "image", unique = false, nullable = true, length = 100000)
    private String image;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Company company;
}
//    public void setImage(String image) throws IOException {
//
//        byte[]bytes=Files.readAllBytes(Paths.get(image));
//
//        this.image = Base64.getEncoder().encodeToString(bytes);
//    }
//
//    public Coupon(String image) throws IOException {
//        byte[]bytes=Files.readAllBytes(Paths.get(image));
//
//        this.image = Base64.getEncoder().encodeToString(bytes);
//    }
//}
