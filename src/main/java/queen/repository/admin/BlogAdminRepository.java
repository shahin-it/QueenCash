/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queen.repository.admin;

import org.springframework.data.repository.CrudRepository;
import queen.models.admin.BlogAdmin;

/**
 *
 * @author shahin
 */
public interface BlogAdminRepository extends CrudRepository<BlogAdmin, Integer>{
    
}
