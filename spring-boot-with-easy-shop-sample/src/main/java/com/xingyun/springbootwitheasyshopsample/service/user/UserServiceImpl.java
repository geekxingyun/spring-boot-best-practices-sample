package com.xingyun.springbootwitheasyshopsample.service.user;

import com.xingyun.springbootwitheasyshopsample.dao.repository.UserInfoRepository;
import com.xingyun.springbootwitheasyshopsample.model.UserInfo;
import com.xingyun.springbootwitheasyshopsample.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 技术宅星云
 * @功能
 * @date 9/22/2019 11:45 AM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public Page<UserInfo> getPage(Pageable pageable) {
        //这里直接使用Jpa提供的分页查询功能
        return this.userInfoRepository.findAll(pageable);
    }

    @Override
    public List<UserInfo> showAllUser() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo load(Long id) {

        //封装查询条件
        UserInfo findUserInfo =new UserInfo();
        findUserInfo.setId(id);
        //转换成查询对象
        Example<UserInfo> findUserExample=Example.of(findUserInfo);

        //获取查询结果
        Optional<UserInfo> resultUserWithOptional=this.userInfoRepository.findOne(findUserExample);

        if(resultUserWithOptional.isPresent()){
            //获取业务实体类
            return resultUserWithOptional.get();
        }else{
            return null;
        }
    }

    @Override
    public UserInfo save(UserDto user) {

        UserInfo queryUserInfo =new UserInfo();
        queryUserInfo.setId(user.getId());
        //转换成查询对象
        Example<UserInfo> checkUserExample=Example.of(queryUserInfo);

        //获取查询结果
        Optional<UserInfo> findUserWithOptional=this.userInfoRepository.findOne(checkUserExample);

        //返回用户
        UserInfo checkUserInfo;
        if(findUserWithOptional.isPresent()){
            //返回用户
            checkUserInfo =findUserWithOptional.get();
        }else{
            //如果对象为空
            //创建一个对象
            checkUserInfo =new UserInfo();

            //设置要保存的对象属性
            checkUserInfo.setAvatar(user.getAvatar());
            checkUserInfo.setNickName(user.getNickName());
        }
        return this.userInfoRepository.save(checkUserInfo);
    }

    @Override
    public void delete(Long id) {
        //根据Id 删除某一个用户
        this.userInfoRepository.deleteById(id);
    }
}
