package life.max.community.service;

import life.max.community.mapper.UserMapper;
import life.max.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccount_id());
        if(dbUser == null){
            //插入
            user.setGmt_Create(System.currentTimeMillis());
            user.setGmt_Modify(user.getGmt_Create());
            userMapper.insert(user);
        }else {
            //更新
            dbUser.setGmt_Modify(System.currentTimeMillis());
            dbUser.setAvatar_url(user.getAvatar_url());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            userMapper.update(dbUser);
        }
    }
}
