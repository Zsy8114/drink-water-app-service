package com.example.demo.mapper;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.mapper.domain.user;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<user> {


    /**
     * 通过id查找
     *
     * @param id
     * @return
     */
    user findById(Long id);

    /**
     * 通过账号查找
     *
     * @param identity
     * @return
     */
    Object findByIdentity(String identity);
}
