package nl.novi.springboot.eindopdracht.repository;


import nl.novi.springboot.eindopdracht.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepsitory extends JpaRepository<User, String> {
}
