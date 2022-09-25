package com.deutschland.springconceptreplay.Repository;

import com.deutschland.springconceptreplay.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /** @EntityGraph(type= EntityGraph.EntityGraphType.FETCH, value="user_graph")
    List<User> findByNameContaining(String text); **/

    @Query(value = "SELECT u.id FROM public.user u " +
            "WHERE EXTRACT(day FROM u.birth_date) = :dayOfMonth AND EXTRACT (month FROM u.birth_date) = :month",
           nativeQuery = true)
    List<UUID> findMonthAndDayOfUsers(@Param("dayOfMonth") Integer dayOfMonth, @Param("month") Integer
            month);




    @Modifying
    @Query(value="update public.user u set age = :age where u.id = :id", nativeQuery = true)
    void updateUserWithNewAge(@Param("age") int age, @Param("id") UUID userId);

}
