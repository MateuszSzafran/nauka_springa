package pl.mszafran.many_to_many_lesson;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ClientOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDetails;
    @ManyToMany
    private List<Product> productList = new ArrayList<>();

    public ClientOrder() {
    }

    public ClientOrder(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void addProduct(Product product){
        productList.add(product);
        product.addOrder(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "ClientOrder{" +
                "id=" + id +
                ", orderDetails='" + orderDetails + '\'' +
                ", productList=" + productList +
                '}';
    }
}
