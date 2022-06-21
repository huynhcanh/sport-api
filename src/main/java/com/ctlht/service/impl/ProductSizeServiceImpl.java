package com.ctlht.service.impl;


import com.ctlht.constant.web.SystemConstant;
import com.ctlht.entity.ImageEntity;
import com.ctlht.entity.ProductSizeEntity;
import com.ctlht.model.mapper.ProductSizeMapper;
import com.ctlht.model.request.ProductSizeRequest;
import com.ctlht.model.response.ProductSizeResponse;
import com.ctlht.repository.ProductRepository;
import com.ctlht.repository.ProductSizeRepository;
import com.ctlht.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductSizeServiceImpl implements ProductSizeService {

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Autowired
    private ProductRepository productReponsitory;

    @Autowired
    private ProductSizeMapper productSizeMapper;

    @Override
    public List<ProductSizeResponse> productsizesByParams(Map<String, String> params) {
        Integer page = Integer.parseInt(params.get("trang"));
        Integer limit = Integer.parseInt(params.get("soSanPham"));
        Pageable pageable = PageRequest.of(page - 1, limit);
        List<ProductSizeEntity> productSizeEntities = productSizeRepository.findAll(pageable).getContent();
        List<ProductSizeResponse> productSizeResponses = new ArrayList<>();
        for (ProductSizeEntity productSizeEntity : productSizeEntities) {
            productSizeResponses.add(productSizeMapper.toResponse(productSizeEntity));
        }
        return productSizeResponses;
    }


    @Override
    @Transactional
    public void deleteProductSizes(long[] ids) {
        for (long id : ids) {
            ProductSizeEntity productSizeEntity = productSizeRepository.findById(id).get();
            Long productId = productSizeEntity.getProduct().getId();
            productSizeRepository.deleteById(id);
            if (productSizeRepository.findByProductId(productId) == null) {
                productReponsitory.deleteById(productId);
                for(ImageEntity item: productSizeEntity.getProduct().getImages()){
                    File imgProduct = new File(SystemConstant.UPLOAD_IMG_DIR_PRODUCT + File.separator + item.getImage());
                    if(imgProduct.delete()) {
                        System.out.println("Delete Success !");
                    }
                    else System.out.println("Cannot delete file !");
                }
            }
        }
    }

    @Override
    @Transactional
    public ProductSizeResponse insertOrUpdate(ProductSizeRequest productSizeRequest) {
        ProductSizeEntity productSizeEntity = productSizeMapper.toEntity(productSizeRequest);
        if (productSizeRequest.getId() == null) { // insert
            productSizeEntity.setProduct(productReponsitory.save(productSizeEntity.getProduct()));
        }
        return productSizeMapper.toResponse(productSizeRepository.save(productSizeEntity));
    }

    @Override
    public long count() {
        return productSizeRepository.count();
    }
}