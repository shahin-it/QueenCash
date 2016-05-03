package queen.controllers.user;

import queen.models.admin.BlogAdmin;
import queen.service.admin.BlogAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class UserController {

  @Autowired
  private BlogAdminService _userDao;
  
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      BlogAdmin user = new BlogAdmin(id);
      _userDao.delete(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping(value="/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      BlogAdmin user = _userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  @RequestMapping(value="/save")
  @ResponseBody
  public String create(String email, String name) {
    try {
      BlogAdmin user = new BlogAdmin(email, name);
      _userDao.save(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }

} // class UserController
