package net.javaLMS.Library.repository;

import net.javaLMS.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
