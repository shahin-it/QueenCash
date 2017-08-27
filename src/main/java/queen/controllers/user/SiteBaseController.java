package queen.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="site")
public class SiteBaseController {

    @RequestMapping("/home")
    public String home() {
        return "site/home";
    }
}