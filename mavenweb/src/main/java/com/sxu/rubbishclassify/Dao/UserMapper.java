package com.sxu.rubbishclassify.Dao;

// UserMapper.java

import com.sxu.rubbishclassify.Bean.Garbage;
import com.sxu.rubbishclassify.Bean.User;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface UserMapper {

    User selectUser(@Param("id") String id);
    int insertUser(@Param("account") String account,@Param("password") String password,@Param("address")String address);
    int insertU(@Param("user")User user);
    int updateScore(@Param("userId")String userId,@Param("score")int score);
    int updateCreditScore(@Param("userId")int userId,@Param("creditScore")int creditScore);
    int updateNickName(@Param("userId")int userId,@Param("nickName")String nickName);
    int updatePassword(@Param("userId")int userId,@Param("password")String password);
    int updateAddress(@Param("userId")int userId,@Param("address")String address);
    int updateTelephone(@Param("userId")int userId,@Param("telephone")String telephone);
    int deleteUser(@Param("id")int id);

}
