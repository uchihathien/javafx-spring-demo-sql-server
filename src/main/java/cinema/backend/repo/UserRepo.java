/*
 * Copyright © 2024. XTREME SOFTWARE SOLUTIONS
 *
 * All rights reserved. Unauthorized use, reproduction, or distribution
 * of this software or any portion of it is strictly prohibited and may
 * result in severe civil and criminal penalties. This code is the sole
 * proprietary of XTREME SOFTWARE SOLUTIONS.
 *
 * Commercialization, redistribution, and use without explicit permission
 * from XTREME SOFTWARE SOLUTIONS, are expressly forbidden.
 */

package cinema.backend.repo;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import cinema.backend.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author XDSSWAR
 * Created on 06/03/2024
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);

    //kiem tra username da ton tai
    boolean existsByUserName(String userName);

    //tim kiem nguoi dung theo vai tro
    List<User> findByRoleID_Id(int userName);
    Optional<User> findByUserNameAndPasswordHash(String userName, String passwordHash);
}
