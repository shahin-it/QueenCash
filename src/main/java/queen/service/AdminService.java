package queen.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import queen.models.admin.Administrator;
import queen.repository.AdminRepository;

import java.util.List;
import java.util.Map;

@Service
public class AdminService {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    AdminRepository adminRepository;

    List<Administrator> getAdminList(Map params) {
        return (List<Administrator>) adminRepository.findAll();
    }

    Administrator saveAdmin() {
        return adminRepository.save(new Administrator());
    }
}
