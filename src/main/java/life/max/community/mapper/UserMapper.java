package life.max.community.mapper;

import life.max.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (NAME, ACCOUNT_ID, TOKEN, GMT_CREATE, GMT_MODIFY) values (#{name}, #{account_id}, #{token}, #{gmtCreate}, #{gmtModified})")
    void insert(User user);
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
