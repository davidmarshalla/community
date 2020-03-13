package life.max.community.Controller;

import life.max.community.Provider.GithubProvider;
import life.max.community.dto.AccessTokenDTO;
import life.max.community.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setClient_id(clientId);
        dto.setClient_secret(clientSecret);
        dto.setCode(code);
        dto.setRedirect_uri(redirectURI);
        dto.setState(state);
        String accessToken = githubProvider.getAccessToken(dto);
        GithubUser user = githubProvider.getUser(accessToken);
        if (user != null) {
            //登陆成功，写cookie和session
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        } else {
            //登陆失败，重新登陆
            return "redirect:index";
        }

    }
}
