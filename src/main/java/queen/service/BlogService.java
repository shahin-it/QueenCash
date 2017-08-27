package queen.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import queen.models.admin.Admin;
import queen.repository.QueenRepository;

@Service
public class BlogService {
  
  @Autowired
  private SessionFactory sessionFactory;
  @Autowired
  private QueenRepository blogRepository;

  
  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public Admin save(Admin admin) {
    return (Admin) blogRepository.save(admin);
  }
  
  public void delete(Admin admin) {
      blogRepository.delete(admin);
  }
  
  public Admin getByEmail(String email) {
    return null;
  }

  public Admin getById(long id) {
    return (Admin) getSession().load(Admin.class, id);
  }

  public void update(Admin admin) {
    getSession().update(admin);
  }

}
