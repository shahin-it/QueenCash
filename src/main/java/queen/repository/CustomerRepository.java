package queen.repository;

import queen.models.Customer;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends CommonRepository<Customer> {
}