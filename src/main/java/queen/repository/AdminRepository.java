package queen.repository;

import queen.models.admin.Administrator;

import javax.transaction.Transactional;

@Transactional
public interface AdminRepository extends CommonRepository<Administrator> {
}
