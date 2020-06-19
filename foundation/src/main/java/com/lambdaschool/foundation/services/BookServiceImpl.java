package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceFoundException;
import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.models.UserRoles;
import com.lambdaschool.foundation.models.Wrote;
import com.lambdaschool.foundation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookrepos;

	@Override
	public Book findBookById(long id) {
		return bookrepos
			.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Book " + id + " Not Found"));
	}

	@Transactional
	@Override
	public Book save(Book book) {
		Book newBook = new Book();

		if (book.getBookid() != 0) {
			Book oldBook = bookrepos
				.findById(book.getBookid())
				.orElseThrow(() -> new ResourceNotFoundException("Book id " + book.getBookid() + " not found!"));

			// for (Wrote w : oldBook.getWrotes()) {
			// 	bookrepos.d(w.getAuthor().getAuthorid(), w.getBook().getBookid());
			// }

			newBook.setBookid(book.getBookid());
		}

		newBook.setBooktitle(book.getBooktitle());
		newBook.setISBN(book.getISBN());
		newBook.setCopy(book.getCopy());
		newBook.setSection(book.getSection());
		// newBook.setWrotes(book.getWrotes());
		newBook.getWrotes().clear();
		for (Wrote w : book.getWrotes()) {
			newBook.
		}

		return bookrepos.save(newBook);
	}
}
