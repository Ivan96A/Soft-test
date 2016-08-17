package soft.test.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soft.test.user.domain.CustomUser;

/**
 * Created by Iwan on 17.08.2016.
 */
public interface UserRepository extends JpaRepository<CustomUser, Long>{

    @Query("Select u from CustomUser u where u.username = :username")
    CustomUser findOneByUsername(@Param("username") String username);

    @Query("update CustomUser u set u.password = :password where u.id = :id")
    void changePassword(@Param("user") CustomUser customUser);
}
