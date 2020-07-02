package edu.ait.shoppingCart.Controllers;


import edu.ait.shoppingCart.Dto.Item;
import edu.ait.shoppingCart.Exceptions.CommonNotFoundException;
import edu.ait.shoppingCart.Repositories.CategoryRepository;
import edu.ait.shoppingCart.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
public class ItemController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/Categories/{categoryId}/Items")
    public Page<Item> getAllItemsForSpecificCategory(@PathVariable Integer categoryId, Pageable pageable) {
        return itemRepository.findByCategoryCategoryId(categoryId, pageable);
    }


    //posting item under category
    @PostMapping("/Categories/{categoryId}/Items")
    public Item createItemInSpecificCategory(@PathVariable Integer categoryId, @Valid @RequestBody Item newItem) {

        return categoryRepository.findByCategoryId(categoryId).map(category -> {

            newItem.setCategory(category);
            return itemRepository.save(newItem);

        }).orElseThrow(() -> new CommonNotFoundException("Category with " + categoryId + " not found"));

    }


    //updating existing item
    @PutMapping("/Categories/{categoryId}/Items/{itemId}")
    public Item updateItemInSpecificCategory(@PathVariable Integer categoryId, @PathVariable Integer itemId, @Valid @RequestBody Item item) {

        if (!categoryRepository.existsById(categoryId)) {
            throw new CommonNotFoundException("category with  " + categoryId + " is not exist");
        }

        return itemRepository.findById(itemId).map(newItem -> {

            //newItem.setCategory(item.getCategory());
            newItem.setDescription(item.getDescription());
            newItem.setDiscount(item.getDiscount());
            newItem.setName(item.getName());
            newItem.setPrice(item.getPrice());
            newItem.setRemaining(item.getRemaining());
            newItem.setItemStatus(item.getItemStatus());
            return itemRepository.save(newItem);

        }).orElseThrow(() -> new CommonNotFoundException("item with  " + itemId + "is not exist"));
    }


    @DeleteMapping("/Categories/{categoryId}/Items/{itemId}")
    public ResponseEntity DeleteItemWithinCategory(@PathVariable Integer categoryId, @PathVariable Integer itemId) {

        return itemRepository.findByitemIdAndCategoryCategoryId(itemId, categoryId).map(item -> {

            itemRepository.delete(item);
            return ResponseEntity.ok().build();

        }).orElseThrow(() -> new CommonNotFoundException("Item is not existed with id " + itemId + " to delete"));
    }


    //Derived query for find specific item where discount less that {pathvariable}
    @GetMapping("/Items/{discount}")
    public List<Item> FindItemsWhereDiscountLessThan(@PathVariable int discount) {
        return itemRepository.findItemByDiscountLessThan(discount);
    }

    //2nd Derived query
    @GetMapping("/Price/{price}")
    public List<Item> findItemsByPriceLessThan(@PathVariable float price) {
        return itemRepository.findItemByPriceLessThan(price);
    }

}
