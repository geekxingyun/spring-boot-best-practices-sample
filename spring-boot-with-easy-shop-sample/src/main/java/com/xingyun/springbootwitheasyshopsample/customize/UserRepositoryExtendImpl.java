package com.xingyun.springbootwitheasyshopsample.customize;

import com.xingyun.springbootwitheasyshopsample.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author 星云
 * @功能 Spring Data JPA 自定义扩展接口实现类
 * @date 9/22/2019 11:19 AM
 */
public class UserRepositoryExtendImpl implements UserRepositoryExtend {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<UserInfo> findTopUser(int maxResult) {
        Query query= null;
//        try {
////            query = this.entityManager.createQuery("select u from User u",User.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        query.setMaxResults(maxResult);
        return query.getResultList();
    }
}
