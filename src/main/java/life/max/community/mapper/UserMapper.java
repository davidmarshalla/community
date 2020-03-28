package life.max.community.mapper;

import life.max.community.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (NAME, ACCOUNT_ID, TOKEN, GMT_CREATE, GMT_MODIFY, AVATAR_URL) values (#{name}, #{account_id}, #{token}, #{gmt_Create}, #{gmt_Modify}, #{avatar_url})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer creator);

    @Select("select * from user where account_id = #{account_id}")
    User findByAccountId(@Param("account_id") String account_id);

    @Update("update user set name = #{name}, token = #{token}, gmt_modify=#{gmt_Modify}, avatar_url=#{avatar_url} where account_id=#{account_id}")
    void update(User user);
}
