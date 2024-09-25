package com.project.shopapp.responses;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.List;

@Data //toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Builder

public class ProductListResponse {

    private List<ProductResponse> products;
    private int totalPages;
}
