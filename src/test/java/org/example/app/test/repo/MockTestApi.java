package org.example.app.test.repo;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.example.app.model.Category;
import org.example.app.model.CategoryRepo;
import org.example.app.model.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockTestApi {
    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private CategoryService categoryService ;

    @Test
    public void save() {
        Category category = new Category(null , "Electronic" , "make sure" , 5000.00);
        Category savedCategory = new Category(1L, "Electronic", "make sure", 5000.00);
        when(categoryRepo.save(Mockito.any(Category.class))).thenReturn(savedCategory);
        Category result = categoryRepo.save(category);
        Assertions.assertThat(result.getId()).isNotNull();
    }
    @Test
    public  void saveApi() {
        Category category = new Category(null , "Electronic" , "make sure" , 5000.00);
        Category saveCat = new Category(3L , "Electronic" , "make sure" , 5000.00);
        when(categoryRepo.save(Mockito.any(Category.class))).thenReturn(saveCat);
        Category cat  = categoryService.save(category);
        Assertions.assertThat(cat.getId()).isNotNull();

    }

    @Test
    public  void getAll() {
        List<Category> categories = categoryRepo.findAll();
        Assertions.assertThat(categories).isNotNull();
    }

    @Test
    public  void getAllApi(){
        List<Category> categories = categoryService.findAll();
        Assertions.assertThat(categories).isNotNull();
    }
    @Test
    public void  findById(){
        Category mockCategory = new Category(2L, "Electronic", "Description", 5000.00);
        when(categoryRepo.findById(2L)).thenReturn(Optional.of(mockCategory));
        Optional<Category> category = categoryRepo.findById(2L);
        String name = category.get().getName();
        Assertions.assertThat(name).isEqualTo("Electronic");
     }

     @Test
     public  void findByIdApi(){
         Category mockCategory = new Category(1L, "Electronic", "Description", 5000.00);
         when(categoryRepo.findById(1L)).thenReturn(Optional.of(mockCategory));
         Optional<Category> category = categoryService.findById(1L);
         Assertions.assertThat(category).isNotNull();

     }
     @Test
    public  void  delete(){
        Category mockCategory = new Category(3L, "Electronic", "Description", 5000.00);
        when(categoryRepo.findById(3L)).thenReturn(Optional.of(mockCategory)).thenReturn(Optional.empty());
        categoryRepo.deleteById(3L);
        Optional<Category> category = categoryRepo.findById(3L);
        Assertions.assertThat(category).isEmpty();
        verify(categoryRepo ,times(1)).deleteById(3L);
     }

     @Test
    public  void update(){
         Category category = new Category(2L , "Electronic" , "make sure" , 5000.00);
         Category updateCate = new Category(2L , "Electronic star" , "make sure and star" , 5000.00);

         when(categoryRepo.findById(2L)).thenReturn(Optional.of(category));
         when(categoryRepo.save(category)).thenReturn(updateCate);

         Category  cat = categoryService.update(category);
         Assertions.assertThat(cat.getId()).isNotNull();

         verify(categoryRepo, times(1)).findById(2L);
         verify(categoryRepo, times(1)).save(category);
     }
}
