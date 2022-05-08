package com.ctlht.model.mapper;

import com.ctlht.entity.ImageEntity;
import com.ctlht.entity.ProductEntity;
import com.ctlht.entity.ProductSizeEntity;
import com.ctlht.model.reponse.ProductSizeResponse;
import com.ctlht.model.request.ProductRequest;
import com.ctlht.repository.ProductSizeReponsitory;
import com.ctlht.repository.SizeReponsitory;
import com.ctlht.repository.CategoryReponsitory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSizeMapper {

    @Autowired
    private CategoryReponsitory categoryReponsitory;

    @Autowired
    private SizeReponsitory sizeReponsitory;

    @Autowired
    private ProductSizeReponsitory productSizeReponsitory;

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
            productEntity.setCategory(categoryReponsitory.findByCode(productRequest.getCategoryCode()));

            productSizeEntity.setProduct(productEntity);
            productSizeEntity.setSize(sizeReponsitory.findByCode(productRequest.getSizeCode()));
            productSizeEntity.setQuantity(productRequest.getQuantity());
        }
        // update
        else{
            productSizeEntity = productSizeReponsitory.findById(productRequest.getIdProductSize()).get();

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
                productEntity.setCategory(categoryReponsitory.findByCode(productRequest.getCategoryCode()));
            }
            if(productRequest.getSizeCode()!=null){
                productSizeEntity.setSize(sizeReponsitory.findByCode(productRequest.getSizeCode()));
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