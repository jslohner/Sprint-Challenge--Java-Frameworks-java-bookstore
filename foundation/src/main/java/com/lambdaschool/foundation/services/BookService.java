package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;

public interface BookService {
	Book findBookById(long id);

	Book save(Book book);
}
