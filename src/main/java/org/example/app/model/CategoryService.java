package org.example.app.model;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private  CategoryRepo repo ;

    public List<Category> findAll() {
        return  repo.findAll();
    }

    public Optional<Category> findById(Long id) {
        return  repo.findById(id);
    }
    public  Category save(Category category) {
        return  repo.save(category);
    }

    public  Category update(Category category) {
        return repo.save(category);
    }

}
