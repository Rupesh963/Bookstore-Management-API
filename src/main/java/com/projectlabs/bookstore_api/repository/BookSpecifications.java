package com.projectlabs.bookstore_api.repository;

import com.projectlabs.bookstore_api.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecifications {

    public static Specification<Book> filterBy(String title, Long authorId) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (title != null && !title.isBlank()) {
                predicates = cb.and(predicates,
                        cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
            }
            if (authorId != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("author").get("authorId"), authorId));
            }
            return predicates;
        };
    }
}