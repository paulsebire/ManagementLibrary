package memails.repository;


import memails.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailRepository extends JpaRepository<Email,Long> {
}