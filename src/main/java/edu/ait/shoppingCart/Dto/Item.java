package edu.ait.shoppingCart.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Items")
public class Item extends AuditingModel{

    public enum ItemStatus {
        InStock,
        OutOfStock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer itemId;

    @NotNull
    @Column(unique = true)
    public String name;
    public String description;
    public Float price;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public int discount;
    public int remaining;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

    /*
    public Item() {
    }

    public Item(@NotNull String name, String description, Float price, ItemStatus itemStatus, int discount, int remaining, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.itemStatus = itemStatus;
        this.discount = discount;
        this.remaining = remaining;
        this.category = category;
    }
*/

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /*
    @Override
    public String toString() {
        return "Item{" +
                "ItemId=" + itemId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", itemStatus=" + itemStatus +
                ", discount=" + discount +
                ", remaining=" + remaining +
                ", category=" + category +
                '}';
    }

     */
}
