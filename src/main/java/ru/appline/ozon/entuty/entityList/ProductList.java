package ru.appline.ozon.entuty.entityList;

import ru.appline.ozon.entuty.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Лист Продуктов
 */
public class ProductList {

    private static List<Product> productList;

    private ProductList(){

    }

    public static List<Product> getProductList(){
        if (productList == null)
            productList = new ArrayList<>();
        return productList;
    }

    public static List<String> getProductNameList(){
        List<String> nameList = new ArrayList<>();
        productList.forEach(product -> nameList.add(product.getName()));
        return nameList;
    }

    public static List<Product> getSortedList(){
        Collections.sort(productList);
        return productList;
    }



}
