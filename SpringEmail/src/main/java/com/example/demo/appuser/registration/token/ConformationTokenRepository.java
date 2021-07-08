package com.example.demo.appuser.registration.token;

import java.time.LocalDateTime;  
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConformationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

	Optional<ConfirmationToken> findByToken(String token);

	@Transactional
	@Modifying
	@Query(value = "UPDATE confirmation_token c " + "SET c.confirmed_at = ?2 " + "WHERE c.token = ?1",nativeQuery = true)
	int updateConfirmedAt(String token, LocalDateTime confirmedAt);

}



