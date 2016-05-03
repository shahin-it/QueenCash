package queen.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import queen.models.admin.BlogAdmin;
import queen.service.admin.BlogAdminService;

@Controller
public class AdminController {

    @Autowired
    private BlogAdminService adminService;

    @RequestMapping("/")
    public String index() {
        return "admin";
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

    @RequestMapping(value = "/save")
    public String create(BlogAdmin admin) {
        try {
            adminService.save(admin);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "User succesfully saved!";
    }
}
