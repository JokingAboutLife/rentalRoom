package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User, UserQuery> {
    User findByLoginName(@Param("loginName") String loginName);

    int findCountByLoginName(@Param("loginName") String loginName, @Param("id") Integer id);

    int updateStatus(@Param("status") Integer status, @Param("id") Integer id);

    int updateRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    int bind(@Param("userId") int userId, @Param("roleId") int roleId);

    int unBind(@Param("userId") int userId, @Param("roleId") int roleId);

    List<User> findUsersByLessorId(@Param("lessorId") Integer lessorId,@Param("houseId") Integer houseId);
}
