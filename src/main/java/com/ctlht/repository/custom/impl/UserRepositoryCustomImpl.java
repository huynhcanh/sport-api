package com.ctlht.repository.custom.impl;

import com.ctlht.constant.web.KeyParamsUrlConstant;
import com.ctlht.entity.UserEntity;
import com.ctlht.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> getUsers(Map<String, String> params) {

        Integer page = Integer.parseInt(params.get(KeyParamsUrlConstant.PAGE));
        Integer limit = Integer.parseInt(params.get(KeyParamsUrlConstant.LIMIT_USER));

        StringBuilder JPQL = new StringBuilder("SELECT u FROM UserEntity u");

        return entityManager.createQuery(JPQL.toString()).setFirstResult((page - 1) * limit).setMaxResults(limit).getResultList();

    }
}
