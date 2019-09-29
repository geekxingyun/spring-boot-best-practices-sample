package com.xingyun.springbootwitheasyshopsample.service.user;

import com.xingyun.springbootwitheasyshopsample.dao.repository.UserRepository;
import com.xingyun.springbootwitheasyshopsample.model.User;
import com.xingyun.springbootwitheasyshopsample.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 星云
 * @功能
 * @date 9/22/2019 11:45 AM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> getPage(Pageable pageable) {
        //这里直接使用Jpa提供的分页查询功能
        return this.userRepository.findAll(pageable);
    }

    @Override
    public List<User> showAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User load(Long id) {

        //封装查询条件
        User findUser=new User();
        findUser.setId(id);
        //转换成查询对象
        Example<User> findUserExample=Example.of(findUser);

        //获取查询结果
        Optional<User> resultUserWithOptional=this.userRepository.findOne(findUserExample);

        if(resultUserWithOptional.isPresent()){
            //获取业务实体类
            return resultUserWithOptional.get();
        }else{
            return null;
        }
    }

    @Override
    public User save(UserDto user) {

        User queryUser=new User();
        queryUser.setId(user.getId());
        //转换成查询对象
        Example<User> checkUserExample=Example.of(queryUser);

        //获取查询结果
        Optional<User> findUserWithOptional=this.userRepository.findOne(checkUserExample);

        //返回用户
        User checkUser;
        if(findUserWithOptional.isPresent()){
            //返回用户
            checkUser=findUserWithOptional.get();
        }else{
            //如果对象为空
            //创建一个对象
            checkUser=new User();

            //设置要保存的对象属性
            checkUser.setAvatar(user.getAvatar());
            checkUser.setNickName(user.getNickName());
        }
        return this.userRepository.save(checkUser);
    }

    @Override
    public void delete(Long id) {
        //根据Id 删除某一个用户
        this.userRepository.deleteById(id);
    }
}
