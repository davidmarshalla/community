package life.max.community.Controller;

import life.max.community.Provider.GithubProvider;
import life.max.community.dto.AccessTokenDTO;
import life.max.community.dto.GithubUser;
import life.max.community.mapper.UserMapper;
import life.max.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect_uri}")
    private String redirectURI;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setClient_id(clientId);
        dto.setClient_secret(clientSecret);
        dto.setCode(code);
        dto.setRedirect_uri(redirectURI);
        dto.setState(state);
        String accessToken = githubProvider.getAccessToken(dto);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {
            //获取用户信息
            User user = new User();
<<<<<<< HEAD
=======
            //生成token，放到用户对象中
>>>>>>> c8110d0cb9e6db0bae00fc7633505053e6dda8fc
            user.setToken(accessToken);
            user.setName(githubUser.getName());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
<<<<<<< HEAD
            response.addCookie(new Cookie("token",accessToken));
=======
            //把token放到cookie里面
            response.addCookie(new Cookie("token", accessToken));
            //登陆成功，写cookie和session
>>>>>>> c8110d0cb9e6db0bae00fc7633505053e6dda8fc
            return "redirect:/";
        } else {
            //登陆失败，重新登陆
            return "redirect:/index";
        }

    }
}
