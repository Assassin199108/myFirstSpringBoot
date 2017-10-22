package com.spring.dao.ch8.impl;

import com.spring.dao.CustomerSpecs;
import com.spring.dao.ch8.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;

/**
 * Created by wangwei on 2017/10/22.
 */
public class CustomRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID>{

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager=entityManager;
    }

    /**
     * 使用byAuto Specification构造的条件查询，并提供分页功能
     *
     * @param example
     * @param pageable
     * @return
     */
    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(CustomerSpecs.buAuto(entityManager,example), pageable);
    }

}
