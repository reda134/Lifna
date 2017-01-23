package blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.models.User;
import blog.models.VerificationToken;

public interface VerificationTokenRepository 
  extends JpaRepository<VerificationToken, Long> {
 
    VerificationToken findByToken(String token);
 
    VerificationToken findByUser(User user);
}