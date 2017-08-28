package queen.controllers.user;

import queen.models.admin.Administrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
  
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      Administrator user = new Administrator();
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }

  @RequestMapping("/save")
  @ResponseBody
  public String create(String email, String name) {
    try {
      Administrator user = new Administrator();
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }

} // class UserController
