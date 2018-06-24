package pl.coderslab.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;

@Controller
@RequestMapping("/bookrepo")
public class BookRepositoryTestController {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PublisherDao publisherDao; // only for retrieving publisher instance

	@GetMapping("/all")
	public String showAll(Model model) {
		List<Book> books = this.bookRepository.findAll();
		model.addAttribute("books", books);
		return "bookList";
	}

	@GetMapping("/findbytitle/{title}")
	@ResponseBody
	public String showByTitle(@PathVariable String title) {
		Book foundBook = this.bookRepository.findByTitle(title);
		if (foundBook == null) {
			return "nie znaleziono";
		} else {
			return foundBook.toString();
		}
	}

	@GetMapping("/findbytitlelike/{toSearch}")
	public String showByTitleLike(@PathVariable String toSearch, Model model) {
		List<Book> books = this.bookRepository.findByTitleLike("%" + toSearch + "%");
		model.addAttribute("books", books);
		return "bookList";
	}
	
	@GetMapping("/findbypublisher")
	public String showByPublisher(Model model) {
		Publisher publisher = this.publisherDao.findById(1L); // if you can obtain
		// publisher instance other way, you can do it
		List<Book> books = this.bookRepository.findByPublisher(publisher);
		
		model.addAttribute("books", books);
		return "bookList";
	}
	
	@GetMapping("/findbypublisherid/{id}")
	public String showByPublisherId(@PathVariable Long id, Model model) {
		List<Book> books = this.bookRepository.findByPublisherId(id);
		model.addAttribute("books", books);
		return "bookList";
	}
	
	@GetMapping("/findbytitlejpql/{toSearch}")
	public String showByTitleJpql(@PathVariable String toSearch, Model model) {
		List<Book> books = this.bookRepository.findMyFavouriteBooks(toSearch);
		model.addAttribute("books", books);
		return "bookList";
	}
	
	@GetMapping("/findgoodabout/{minRating}/{aboutWhat}")
	public String showGoodAbout(@PathVariable BigDecimal minRating,
								@PathVariable String aboutWhat,
								Model model) {
		List<Book> books = this.bookRepository.findGoodBooksAbout(aboutWhat, minRating);
		model.addAttribute("books", books);
		return "bookList";
	}
	
	@GetMapping("/findbypublisherjpql")
	public String showByPublisherJpql(Model model) {
		Publisher publisher = this.publisherDao.findById(2L); // if you can obtain
		// publisher instance other way, you can do it
		List<Book> books = this.bookRepository.findBooksByPublisher(publisher);
		
		model.addAttribute("books", books);
		return "bookList";
	}
}
