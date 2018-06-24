package pl.coderslab.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByTitle(String title);
	List<Book> findByTitleLike(String wildcard); // % _
	List<Book> findByPublisher(Publisher publisher);
	List<Book> findByPublisherId(Long id);
	List<Book> findByRatingBetween(BigDecimal min, BigDecimal max);
	List<Book> findByTitleIsNull();
	@Query("SELECT b FROM Book b WHERE b.title = :myTitle ORDER BY b.id DESC")
	List<Book> findMyFavouriteBooks(@Param("myTitle") String title);
	
	@Query("SELECT b FROM Book b WHERE b.description LIKE %:aboutWhat% AND b.rating >= :minRating ORDER BY b.rating DESC")
	List<Book> findGoodBooksAbout(@Param("aboutWhat") String aboutWhat,
			@Param("minRating") BigDecimal minRating);
	
	@Query("SELECT b FROM Book b WHERE b.publisher = :pub")
	List<Book> findBooksByPublisher(@Param("pub") Publisher publisherPassedByUser);
}
