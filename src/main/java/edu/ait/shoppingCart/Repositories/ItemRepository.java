package edu.ait.shoppingCart.Repositories;

import edu.ait.shoppingCart.Dto.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {


    Page<Item> findByCategoryCategoryId(Integer CategoryId, Pageable pageable);
    Optional<Item> findByitemIdAndCategoryCategoryId(Integer ItemId, Integer CategoryId );

    List<Item> findItemByPriceLessThan(float price);
    List<Item> findItemByDiscountLessThan(int discount);

}
