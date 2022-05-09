package com.ctlht.repository.custom.impl;

import com.ctlht.constant.web.KeyParamsUrlConstant;
import com.ctlht.entity.OrderEntity;
import com.ctlht.repository.custom.OrderRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OrderEntity> getOrdersByFields(Map<String, String> params) {

        Integer page = Integer.parseInt(params.get(KeyParamsUrlConstant.PAGE));
        Integer limit = Integer.parseInt(params.get(KeyParamsUrlConstant.LIMIT_ODER));
        Long userId = Long.parseLong(params.get(KeyParamsUrlConstant.ID_USER));

        StringBuilder JPQL = new StringBuilder("SELECT o FROM OrderEntity o WHERE o.user.id = " + userId);

        return entityManager.createQuery(JPQL.toString()).setFirstResult((page - 1) * limit).setMaxResults(limit).getResultList();
    }

    @Override
    public List<OrderEntity> getOrdersByCurrentMonth(String month) {
        StringBuilder JPQL = new StringBuilder("SELECT o FROM OrderEntity o WHERE MONTH(o.createdDate) = " + month);
        return entityManager.createQuery(JPQL.toString()).getResultList();
    }

    @Override
    public List<OrderEntity> countOrdersByDay(String day) {
        StringBuilder JPQL = new StringBuilder("SELECT o FROM OrderEntity o WHERE DAY(o.createdDate) = " + day);
        return entityManager.createQuery(JPQL.toString()).getResultList();
    }

}
