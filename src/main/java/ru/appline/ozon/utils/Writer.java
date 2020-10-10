package ru.appline.ozon.utils;

import ru.appline.ozon.entuty.Product;
import ru.appline.ozon.entuty.entityList.ProductList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс работы с файлом
 */
public class Writer {
    public static void write() {

        try {

            File file = new File("src/main/resources/text.txt");
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/text.txt", true));
            writer.flush();
            for (Product product : ProductList.getSortedList()) {
                writer.write(product.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(){
        boolean file = new File("src/main/resources/text.txt").delete();
    }
}
