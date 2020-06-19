package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long authorid;

	private String firstname;
	private String lastname;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "author", allowSetters = true)
	private List<Wrote> wrotes = new ArrayList<>();

	public Author() {
	}

	public Author(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		// for (Wrote w : wrotes) {
		// 	w.setAuthor(this);
		// }
		// this.wrotes = wrotes;
	}

	public long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(long authorid) {
		this.authorid = authorid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	// public List<Wrote> getBooks() {
	// 	return books;
	// }
	//
	// public void setBooks(List<Wrote> books) {
	// 	this.books = books;
	// }


	public List<Wrote> getWrotes() {
		return wrotes;
	}

	public void setWrotes(List<Wrote> wrotes) {
		this.wrotes = wrotes;
	}

	public void addBook(Book book) {
		wrotes.add(new Wrote(this, book));
	}

	@Override
	public String toString() {
		return "Author{" +
			"authorid=" + authorid +
			", firstname='" + firstname + '\'' +
			", lastname='" + lastname + '\'' +
			", wrotes=" + wrotes +
			'}';
	}
}