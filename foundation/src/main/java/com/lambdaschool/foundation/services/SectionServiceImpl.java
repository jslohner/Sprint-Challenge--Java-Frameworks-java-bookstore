package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.models.Wrote;
import com.lambdaschool.foundation.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "sectionService")
public class SectionServiceImpl implements SectionService {
	@Autowired
	private SectionRepository sectionrepos;

	@Transactional
	@Override
	public Section save(Section section) {
		Section newSection = new Section();

		newSection.setSectionname(section.getSectionname());
		newSection.getBooks().clear();
		for (Book b : section.getBooks()) {
			Book newBook = new Book();

			newBook.setBooktitle(b.getBooktitle());
			newBook.setISBN(b.getISBN());
			newBook.setCopy(b.getCopy());
			newBook.setSection(b.getSection());
			newBook.setWrotes(b.getWrotes());

			newSection.getBooks().add(newBook);
		}

		return sectionrepos.save(newSection);
	}
}
