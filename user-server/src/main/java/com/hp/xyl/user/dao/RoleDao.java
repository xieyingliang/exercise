package com.hp.xyl.user.dao;

import com.hp.xyl.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author:xyl
 * Date:2019/3/7 15:29
 * Description:
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}
