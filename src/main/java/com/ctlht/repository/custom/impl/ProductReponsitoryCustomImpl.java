package com.ctlht.repository.custom.impl;

import com.ctlht.constant.web.KeyParamsUrlConstant;
import com.ctlht.constant.web.SystemConstant;
import com.ctlht.entity.ProductEntity;
import com.ctlht.repository.custom.ProductReponsitoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class ProductReponsitoryCustomImpl implements ProductReponsitoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductEntity> getBuildingByFields(Map<String, String> params) {

        Integer page = Integer.parseInt(params.get(KeyParamsUrlConstant.PAGE));
        Integer limit = Integer.parseInt(params.get(KeyParamsUrlConstant.LIMIT));
        String categoryCode = (String)params.get(KeyParamsUrlConstant.CODE_CATEGORY);
        String sortByPrice = (String)params.get(KeyParamsUrlConstant.SORT_BY_PRICE);

        StringBuilder JPQL = new StringBuilder("SELECT p FROM ProductEntity p " + SystemConstant.WHERE_ONE_EQUAL_ONE);
        if(categoryCode != null){
            JPQL.append(" AND p.category.code = '" + categoryCode + "'");
        }
        if(sortByPrice != null){
            JPQL.append(" ORDER BY p.salePrice " + sortByPrice);
        }
        return entityManager.createQuery(JPQL.toString()).setFirstResult((page-1)*limit).setMaxResults(limit).getResultList();
    }

    @Override
    public List<ProductEntity> findTop3ByTop3LatestId() {
        StringBuilder JpaQuery = new StringBuilder("SELECT p FROM ProductEntity p ORDER BY p.id DESC");
        return entityManager.createQuery(JpaQuery.toString()).setFirstResult(0).setMaxResults(3).getResultList();
    }
}
