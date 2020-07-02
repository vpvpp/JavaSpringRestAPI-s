package edu.ait.shoppingCart.Controllers;

import edu.ait.shoppingCart.Dto.Category;
import edu.ait.shoppingCart.Exceptions.CommonNotFoundException;
import edu.ait.shoppingCart.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/Categories")
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }


    @RequestMapping(value="/Categories", method=RequestMethod.POST)
    public Category createCategory( @Valid @RequestBody Category Category) {
        return categoryRepository.save(Category);
    }


    @PutMapping("/Categories/{CategoryId}")
    public Category updateCategory(@PathVariable Integer CategoryId, @Valid @RequestBody Category category) {

        return categoryRepository.findById(CategoryId).map(category1 -> {

            category1.setCategoryName(category.getCategoryName());
            category1.setDescription(category.getDescription());
            return categoryRepository.save(category1);

        }).orElseThrow(() -> new CommonNotFoundException("Category with " + CategoryId + " not found"));

    }



    @DeleteMapping("/Categories/{CategoryId}")
    public ResponseEntity<Object> deletePost(@PathVariable Integer CategoryId) {

        return categoryRepository.findById(CategoryId).map(category -> {

            categoryRepository.delete(category);
            return ResponseEntity.ok().build();

        }).orElseThrow(() -> new CommonNotFoundException("PostId " + CategoryId + " not found"));
    }


}
