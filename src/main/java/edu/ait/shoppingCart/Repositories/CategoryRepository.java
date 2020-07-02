package edu.ait.shoppingCart.Repositories;


import edu.ait.shoppingCart.Dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "SELECT c FROM Category c WHERE c.categoryId = ?1 ")
    Optional<Category> findByCategoryId(Integer categoryId);

    @Query(value = "SELECT c FROM Category c WHERE c.createdAt = ?1 ")
    List<Category> findCategoriesByCreatedAt_Date(Date date);
}
