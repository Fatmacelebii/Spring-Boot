package com.fatma.demo.service.impl;

import com.fatma.demo.model.Product;
import com.fatma.demo.repository.ProductRepository;
import com.fatma.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    // CREATE
    @Override
    public Product createProduct(Product product) {
        // Ürünü kaydet ve geri döndür
        return productRepository.save(product);
    }

    // READ - tüm ürünler
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // READ - tek ürün
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // UPDATE
    @Override
    public Product updateProduct(Long id, Product product) {
        // Veritabanından ürünü al
        Optional<Product> optionalProduct = productRepository.findById(id);

        // Eğer ürün varsa güncelle
        if (optionalProduct.isPresent()) {
            Product productToUpdate = optionalProduct.get(); // var olan ürün

            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());

            // Kaydet ve geri döndür
            return productRepository.save(productToUpdate);
        }
            // Ürün bulunamadıysa null dön
            return null;
    }

    // DELETE
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
