package com.spring.dao;

import com.google.common.collect.Iterables;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangwei on 2017/10/22.
 */
public class CustomerSpecs {

    /**
     * 定义一个返回值为Specification的方法byAuto，这里使用泛型T，所以这个Specification是可以用于任意的实体
     * 类型的。他接受的参数是entityManager和当前的包含值作为查询条件的实体类对象
     * @param entityManager
     * @param example
     * @param <T>
     * @return
     */
    public static <T>Specification<T> buAuto(final EntityManager entityManager,final T example) {

        //获得当前实体类类的对象的类型
        final Class<T> type = (Class<T>) example.getClass();

        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //新建Predicate列表的存储构造的查询条件
                List<Predicate> predicates = new ArrayList<Predicate>();

                //获得实体类的entityType,我们可以从EntityType获得实体类的属性
                EntityType<T> entity = entityManager.getMetamodel().entity(type);

                //对实体类的所有属性做循环
                for (Attribute<T,?> attr : entity.getDeclaredAttributes()) {
                    //获得实体类对象某一个属性的值
                    Object attrValue = getValue(example,attr);

                    if (attrValue != null){
                        //当前属性值为字符类型的时候
                        if (attr.getJavaType() == String.class){
                            //若当前字符串不为空的情况下
                            if (!StringUtils.isEmpty(attrValue)) {
                                //构造当前属性like(前后%)属性值查询条件，并添加到条件列表中
                                predicates.add(cb.like(root.get(attribute(entity,attr.getName(),String.class)),pattern((String) attrValue)));
                            }
                        }else{
                            //其余情况下，构造属性和属性值equal查询条件,并添加到条件列表中
                            predicates.add(cb.equal(root.get(attribute(entity,attr.getName(),attrValue.getClass())),attrValue));
                        }
                    }
                }
                //将条件列表转换为Predicate
                return predicates.isEmpty() ? cb.conjunction() : cb.and(Iterables.toArray(predicates,Predicate.class));
            }

            /**
             * 通过反射获得实体类对象对应属性的属性值。
             * @param example
             * @param attr
             * @param <T>
             * @return
             */
            private <T> Object getValue(T example,Attribute<T,?> attr){
                return ReflectionUtils.getField((Field) attr.getJavaMember(),example);
            }

            /**
             * 通过实体类的当前属性SingularAttribute,SingularAttribute 包含的是实体类的某个单独属性
             * @param entity
             * @param filedName
             * @param filedClass
             * @param <E>
             * @param <T>
             * @return
             */
            private <E,T>SingularAttribute<T,E> attribute(EntityType<T> entity,String filedName,Class<E> filedClass){
                return entity.getDeclaredSingularAttribute(filedName,filedClass);
            }
        };
    }


    /**
     * 构造Like的模糊查询模式，即前后加%
     *
     * @param str
     * @return
     */
    static private String pattern(String str){
        return "%"+str+"%";
    }
}
