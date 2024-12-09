package org.example.app.test.repo;

import org.example.app.model.Category;
import org.example.app.model.CategoryRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepoTest {
    @Autowired
    private CategoryRepo categoryRepo ;
    @Test
    public  void create_category(){
        Category category = new Category(null , "Electronic" , "make sure" , 5000.00);
        categoryRepo.save(category);
        Assertions.assertNotNull(category.getId());
     }

}
