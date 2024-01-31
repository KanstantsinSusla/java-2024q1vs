package com.epam.javaadvanced.service;

import com.epam.javaadvanced.config.H2DataSourceAutoConfiguration;
import com.epam.javaadvanced.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = H2DataSourceAutoConfiguration.class)
public class ProductServiceHSQLTest {

    @Autowired
    private ProductService productService;

    @Test
    public void addProductTest() {
        final String productName = "Product1";

        Product product = new Product();
        product.setName(productName);

        Product savedProduct = productService.addProduct(product);

        assertNotNull(savedProduct);
        assertEquals(productName, savedProduct.getName());
    }
}
