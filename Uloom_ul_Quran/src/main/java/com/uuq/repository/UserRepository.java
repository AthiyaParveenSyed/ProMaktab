package com.uuq.repository;
import com.uuq.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find a user by WhatsApp number
    User findByWhatsappNumber(String whatsappNumber);
}
