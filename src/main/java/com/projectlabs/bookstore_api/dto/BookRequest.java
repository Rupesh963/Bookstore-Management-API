package com.projectlabs.bookstore_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @Positive(message = "Price must be positive")
    private Double price;

    private Integer publicationYear;

    @NotNull(message = "authorId is required")
    private Long authorId;
}
