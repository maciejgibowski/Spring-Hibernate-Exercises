package pl.coderslab.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.validation.Proposition;

@Controller
@RequestMapping("/proposition")
public class PropositionController {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private PublisherDao publisherDao;
	@Autowired
	private AuthorDao authorDao;
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private ServletContext servletContext;

	@GetMapping("/addtest")
	@ResponseBody
	public String add() {
		Book java = new Book();
		this.bookDao.save(java);

		return "added proposition java";
	}

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("book", new Book());
		return "addPropositionForm";
	}

	@PostMapping("/form")
	public String formPost(@Validated({Proposition.class}) Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "addPropositionForm";
		}
		book.setProposition(true);
		this.bookDao.save(book);
		return "redirect:/proposition/listJsp";
	}

	@GetMapping("/listJsp")
	public String listJsp() {
		return "propositionList";
	}

	@ModelAttribute("authors")
	public List<Author> getAuthors() {
		return this.authorDao.getAll();
	}

	@ModelAttribute("publishers")
	public List<Publisher> getPublishers() {
		return this.publisherDao.getAll();
	}

	@ModelAttribute("books")
	public List<Book> getBooks() {
		return this.bookDao.getAll();
	}
	
	@ModelAttribute("propositions")
	public List<Book> getPropositions() {
		return this.bookDao.getPropositions();
	}
}
