package com.spring.dao.ch8;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;


/**
 * Created by wangwei on 2017/10/22.
 * 此例中的接口继承了JpaRepository,让我们具备了JpaRepository所提供的方法；继承了JpaSpecificationExcutor,
 * 让我们举杯使用Specification的能力
 */
@NoRepositoryBean
public interface CustomRepository<T ,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>{

    Page<T> findByAuto(T example, Pageable pageable);

}
