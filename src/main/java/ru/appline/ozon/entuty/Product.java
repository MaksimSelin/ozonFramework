package ru.appline.ozon.entuty;

/**
 * Продукт
 */
public class Product implements Comparable<Product>{
    private String name;
    private String price;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }


    @Override
    public int compareTo(Product o) {
        return o.getPrice().compareTo(this.price);
    }
}
