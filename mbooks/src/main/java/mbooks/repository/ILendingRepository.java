package mbooks.repository;




import mbooks.model.Books;
import mbooks.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ILendingRepository extends JpaRepository<Lending,Long> {

    List<Lending> findAllByBook(Books book);
    List<Lending> findAllByIdUser(Long id );
    List<Lending> findAllByReturnDateIsNullAndAndEndDateBefore(Date date);
}
