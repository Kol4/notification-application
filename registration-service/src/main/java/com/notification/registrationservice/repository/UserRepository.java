package com.notification.registrationservice.repository;

import com.notification.registrationservice.dto.StatisticInfoDto;
import com.notification.registrationservice.entity.UserForRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserForRegistration, Long> {

    /**
     * Delete user by firebase token.
     *
     * @param firebaseToken user id
     */
    void deleteByFirebaseToken(String firebaseToken);

    /**
     * Get statistic info data {@link StatisticInfoDto }.
     *
     * @return {@link List<StatisticInfoDto>}
     */
    @Query("SELECT new com.notification.registrationservice.dto.StatisticInfoDto(p.applicationVersion, count(p.firebaseToken), count(DISTINCT p.phoneNumber)) from UserForRegistration p GROUP BY p.applicationVersion")
    List<StatisticInfoDto> findAllVersionWithCountOfFirebaseTokensAndPhoneNumber();

    /**
     * Get firebase tokens by phone numbers.
     *
     * @param phoneNumber phone number
     *
     * @return {@link List<String>}
     */
    @Query("SELECT u.firebaseToken FROM UserForRegistration u WHERE u.phoneNumber=?1")
    List<String> getFirebaseTokenUsingPhoneNumber(String phoneNumber);
}
