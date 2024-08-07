package application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u.image FROM user_account u WHERE u.id = :userId")
	public String getUserImagePathById(@Param("userId") Long userId);
	
	public Optional<User> findByUserInfo_Email(String email);
	
	public boolean existsUserByUserInfo_Email(String email);
	
}
