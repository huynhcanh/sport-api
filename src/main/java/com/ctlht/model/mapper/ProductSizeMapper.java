package com.ctlht.model.mapper;

import com.ctlht.constant.web.SystemConstant;
import com.ctlht.entity.ImageEntity;
import com.ctlht.entity.ProductEntity;
import com.ctlht.entity.ProductSizeEntity;
import com.ctlht.model.request.ProductSizeRequest;
import com.ctlht.model.response.ProductSizeResponse;
import com.ctlht.model.request.ProductRequest;
import com.ctlht.repository.ProductSizeRepository;
import com.ctlht.repository.SizeRepository;
import com.ctlht.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public ProductSizeEntity toEntity(ProductSizeRequest productSizeRequest) {
        ProductSizeEntity productSizeEntity=null;
        // insert
        if(productSizeRequest.getId() == null){

            productSizeEntity =  new ProductSizeEntity();
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productSizeRequest.getName());
            productEntity.setUnitPrice(productSizeRequest.getUnitPrice());
            productEntity.setDiscount(productSizeRequest.getDiscount());
            productEntity.setDescription(productSizeRequest.getDescription());


            List<ImageEntity> imagesEntity=new ArrayList<>();
            for(MultipartFile file: productSizeRequest.getImages()){
                String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
                String fileName= date + file.getOriginalFilename();
                Path fileNameAndPath = Paths.get(SystemConstant.UPLOAD_IMG_DIR_PRODUCT, fileName);
                try{
                    Files.write(fileNameAndPath,file.getBytes());
                }catch (IOException e){
                    e.printStackTrace();
                }

                ImageEntity imageEntity= new ImageEntity(fileName, productEntity);
                imagesEntity.add(imageEntity);
            }
            productEntity.setImages(imagesEntity);
            productEntity.setCategory(categoryRepository.findByCode(productSizeRequest.getCategoryCode()));

            productSizeEntity.setProduct(productEntity);
            productSizeEntity.setSize(sizeRepository.findByCode(productSizeRequest.getSizeCode()));
            productSizeEntity.setQuantity(productSizeRequest.getQuantity());
        }
        // update
        else{
            productSizeEntity = productSizeRepository.findById(productSizeRequest.getId()).get();
            ProductEntity productEntity = productSizeEntity.getProduct();
            productEntity.setName(productSizeRequest.getName());
            productEntity.setUnitPrice(productSizeRequest.getUnitPrice());
            productEntity.setDiscount(productSizeRequest.getDiscount());
            productEntity.setDescription(productSizeRequest.getDescription());
            productEntity.setCategory(categoryRepository.findByCode(productSizeRequest.getCategoryCode()));
            productSizeEntity.setSize(sizeRepository.findByCode(productSizeRequest.getSizeCode()));
            productSizeEntity.setQuantity(productSizeRequest.getQuantity());
        }
        return productSizeEntity;
    }

    public ProductSizeResponse toResponse(ProductSizeEntity entity) {
        ProductSizeResponse productSizeResponse = modelMapper.map(entity, ProductSizeResponse.class);
        return productSizeResponse;
    }
}