package life.max.community.mapper;

import life.max.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user (NAME, ACCOUNT_ID, TOKEN, GMT_CREATE, GMT_MODIFY) values (#{name}, #{account_id}, #{token}, #{gmtCreate}, #{gmtModified})")
    void insert(User user);
}
