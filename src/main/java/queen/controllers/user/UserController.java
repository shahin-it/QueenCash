package queen.controllers.user;

import queen.models.admin.Admin;
import queen.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

  @Autowired
  private BlogService blogService;
  
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      Admin user = new Admin();
      blogService.delete(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping("/getByEmail")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      Admin user = blogService.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  @RequestMapping("/save")
  @ResponseBody
  public String create(String email, String name) {
    try {
      Admin user = new Admin();
      blogService.save(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }

} // class UserController
