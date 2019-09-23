package com.xingyun.springbootwitheasyshopsample.dao.repository;

import com.xingyun.springbootwitheasyshopsample.customize.UserRepositoryExtend;
import com.xingyun.springbootwitheasyshopsample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interface JpaRepository extends PagingAndSortingRepository extends CrudRepository extends Repository
 * @author 星云
 * @功能 Spring Data JPA 接口
 * @date 9/22/2019 11:03 AM
 */
public interface UserRepository extends JpaRepository<User,Long>{
}
