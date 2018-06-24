package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

@Controller
public class HomeController {
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private PublisherDao publisherDao;

	@GetMapping("/init")
	@ResponseBody
	public String add() {
		Author sienkiewicz = new Author();
		sienkiewicz.setFirstName("Henryk");
		sienkiewicz.setLastName("Sienkiewicz");
		this.authorDao.save(sienkiewicz);

		Author horstmann = new Author();
		horstmann.setFirstName("Cay S.");
		horstmann.setLastName("Horstmann");
		this.authorDao.save(horstmann);

		Author cornell = new Author();
		cornell.setFirstName("Gary");
		cornell.setLastName("Cornell");
		this.authorDao.save(cornell);

		Publisher ossolineum = new Publisher();
		ossolineum.setName("Ossolineum");
		this.publisherDao.save(ossolineum);

		Publisher pwn = new Publisher();
		pwn.setName("PWN");
		this.publisherDao.save(pwn);

		return "initialized authors and publishers."
				+ "Mozesz wrocic na strone glowna klikajac 'wstecz'"
				+ "i rozpoczac dodawanie ksiazek.";
	}
}
