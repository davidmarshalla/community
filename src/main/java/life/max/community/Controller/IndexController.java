package life.max.community.Controller;

import life.max.community.dto.PaginationDto;
import life.max.community.dto.QuestionDto;
import life.max.community.mapper.QuestionMapper;
import life.max.community.mapper.UserMapper;
import life.max.community.model.Question;
import life.max.community.model.User;
import life.max.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "2") Integer size) {

        PaginationDto pagination = questionService.list(page, size);
        model.addAttribute("pagination", pagination);
        return "/index";
    }
}
