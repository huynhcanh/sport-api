package com.ctlht.model.mapper;

import com.ctlht.entity.ImageEntity;
import com.ctlht.entity.ProductEntity;
import com.ctlht.entity.ProductSizeEntity;
import com.ctlht.model.response.ProductSizeResponse;
import com.ctlht.model.request.ProductRequest;
import com.ctlht.repository.ProductSizeRepository;
import com.ctlht.repository.SizeRepository;
import com.ctlht.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSizeMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductSizeEntity toEntity(ProductRequest productRequest) {
        ProductSizeEntity productSizeEntity;
        // insert
        if(productRequest.getIdProductSize() == null){

            productSizeEntity =  new ProductSizeEntity();
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productRequest.getName());
            productEntity.setUnitPrice(productRequest.getUnitPrice());
            productEntity.setDiscount(productRequest.getDiscount());
            productEntity.setDescription(productRequest.getDescription());
            List<ImageEntity> imagesEntity=new ArrayList<>();
            for(String image: productRequest.getImages()){
                ImageEntity imageEntity= new ImageEntity(image, productEntity);
                imagesEntity.add(imageEntity);
            }
            productEntity.setImages(imagesEntity);
            productEntity.setCategory(categoryRepository.findByCode(productRequest.getCategoryCode()));

            productSizeEntity.setProduct(productEntity);
            productSizeEntity.setSize(sizeRepository.findByCode(productRequest.getSizeCode()));
            productSizeEntity.setQuantity(productRequest.getQuantity());
        }
        // update
        else{
            productSizeEntity = productSizeRepository.findById(productRequest.getIdProductSize()).get();

            ProductEntity productEntity = productSizeEntity.getProduct();
            if(productRequest.getName()!= null){
                productEntity.setName(productRequest.getName());
            }
            if(productRequest.getUnitPrice()!= null){
                productEntity.setUnitPrice(productRequest.getUnitPrice());
            }
            if(productRequest.getDiscount()!= null){
                productEntity.setDiscount(productRequest.getDiscount());
            }
            if(productRequest.getDescription()!= null){
                productEntity.setDescription(productRequest.getDescription());
            }
            if(productRequest.getImages()!=null){
                List<ImageEntity> imagesEntity=new ArrayList<>();
                for(String image: productRequest.getImages()){
                    ImageEntity imageEntity= new ImageEntity(image, productEntity);
                    imagesEntity.add(imageEntity);
                }
                productEntity.setImages(imagesEntity);
            }
            if(productRequest.getCategoryCode()!=null){
                productEntity.setCategory(categoryRepository.findByCode(productRequest.getCategoryCode()));
            }
            if(productRequest.getSizeCode()!=null){
                productSizeEntity.setSize(sizeRepository.findByCode(productRequest.getSizeCode()));
            }
            if(productRequest.getQuantity()!=null){
                productSizeEntity.setQuantity(productRequest.getQuantity());
            }
        }
        return productSizeEntity;
    }

    public ProductSizeResponse toResponse(ProductSizeEntity entity) {
        ProductSizeResponse productSizeResponse = modelMapper.map(entity, ProductSizeResponse.class);
        return productSizeResponse;
    }
}