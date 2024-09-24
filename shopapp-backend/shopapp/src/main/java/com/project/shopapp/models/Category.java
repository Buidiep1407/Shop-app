package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

import javax.xml.transform.sax.SAXResult;

@Entity //để biết là thực thể trong Java Spring
@Table(name = "categories")
@Data //toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false) //thuộc tính name không được phép null
    private String name;
}
