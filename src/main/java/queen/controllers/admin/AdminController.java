package queen.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import queen.models.admin.Admin;
import queen.service.BlogService;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("")
    public String index() {
        return "admin/controlPanel";
    }

    @RequestMapping("/login")
    public String login(String email, String password, boolean remember) {
        return "";
    }

    @RequestMapping("/register")
    public String register() {
        return "";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(String email) {
        return "";
    }

    @RequestMapping("/save")
    public String create(Admin admin) {
        try {
            blogService.save(admin);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "User succesfully saved!";
    }
}
