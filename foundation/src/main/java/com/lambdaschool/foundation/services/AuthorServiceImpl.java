package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.Wrote;
import com.lambdaschool.foundation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorrepos;

	@Autowired
	private BookService bookService;

	@Override
	public List<Author> findAllAuthors() {
		List<Author> authorList = new ArrayList<>();

		authorrepos.findAll()
			.iterator()
			.forEachRemaining(authorList::add);
		return authorList;
	}

	@Transactional
	@Override
	public Author save(Author author) {
		Author newAuthor = new Author();

		newAuthor.setFirstname(author.getFirstname());
		newAuthor.setLastname(author.getLastname());

		List<Wrote> newWrotes = new ArrayList<>();
		newAuthor.getWrotes().clear();
		for (Wrote w : author.getWrotes()) {
			newWrotes.add(new Wrote(newAuthor, w.getBook()));
		}
		newAuthor.setWrotes(newWrotes);

		return authorrepos.save(newAuthor);
	}
}
