package queen.service.admin;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import queen.models.admin.BlogAdmin;
import queen.repository.admin.BlogAdminRepository;

@Service
public class BlogAdminService {
  
  @Autowired
  private SessionFactory _sessionFactory;
  @Autowired
  private BlogAdminRepository adminRepository;
  
  public void setBlogAdminRepository(BlogAdminRepository adminRepository) {
      this.adminRepository = adminRepository;
  }
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public BlogAdmin save(BlogAdmin admin) {
    return adminRepository.save(admin);
  }
  
  public void delete(BlogAdmin admin) {
    adminRepository.delete(admin);
  }
  
  @SuppressWarnings("unchecked")
  public List<BlogAdmin> getAll() {
    return getSession().createQuery("from BlogAdmin").list();
  }
  
  public BlogAdmin getByEmail(String email) {
    return (BlogAdmin) getSession().createQuery(
        "from BlogAdmin where email = :email")
        .setParameter("email", email)
        .uniqueResult();
  }

  public BlogAdmin getById(long id) {
    return (BlogAdmin) getSession().load(BlogAdmin.class, id);
  }

  public void update(BlogAdmin admin) {
    getSession().update(admin);
  }

}
