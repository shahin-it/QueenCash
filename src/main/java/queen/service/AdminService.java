package queen.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import queen.models.admin.Admin;
import queen.repository.QueenRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    QueenRepository<Admin, Serializable> repository;

    List<Admin> getAdminList(Map params) {
        return (List<Admin>) repository.findAll();
    }

    Admin saveAdmin() {
        return repository.save(new Admin());
    }
}
