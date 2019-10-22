package mbooks.controller.book;


import mbooks.controller.dto.BooksCreateDto;
import mbooks.controller.dto.BooksUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Books;
import mbooks.service.IBooksService;
import mbooks.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {

    @Autowired
    private IBooksService booksService;

    @GetMapping("/{id}")
    public Books find(@PathVariable Long id) {
        return booksService.find( id );
    }

    @GetMapping("/all")
    public List<Books> list(){

        List<Books> booksList = booksService.list();
        if (booksList.isEmpty()) throw new ResourceNotFoundException( "Aucun livre trouvé.");

        return booksList;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Books save(@DTO(BooksCreateDto.class) @RequestBody Books book)  {
        return booksService.save(book);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Books update(@DTO(BooksUpdateDto.class) @RequestBody Books book){
        return booksService.save( book );
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return booksService.delete( id );
    }
}
