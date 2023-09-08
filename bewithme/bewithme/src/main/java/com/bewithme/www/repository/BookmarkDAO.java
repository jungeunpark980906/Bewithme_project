package com.bewithme.www.repository;

import java.util.List;

import com.bewithme.www.domain.BookmarkVO;

public interface BookmarkDAO {

	List<Integer> selectBookmarkNum(String id);

	int deleteBookmark(BookmarkVO bvo);

	int isBook(BookmarkVO bookvo);

	int delete(BookmarkVO bookvo);

	int insert(BookmarkVO bookvo);

	List<Integer> bookList(String id);
	
	int booklist(BookmarkVO bookvo);

}
