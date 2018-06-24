package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	// @IsOver18YO
	// private int yearOfBirth;
	// @IsOverXYO(age=23)
	// private int authorAge;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	// public int getYearOfBirth() {
	// return yearOfBirth;
	// }
	//
	// public void setYearOfBirth(int yearOfBirth) {
	// this.yearOfBirth = yearOfBirth;
	// }
	//
	// public int getAuthorAge() {
	// return authorAge;
	// }
	//
	// public void setAuthorAge(int authorAge) {
	// this.authorAge = authorAge;
	// }

}
