package com.sivalabs.bookmarker.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

  private final BookmarkRepository bookmarkRepository;

  @Transactional(readOnly = true)
  public BookmarksDTO getBookmarks(Integer page) {
    var pageNo = page < 1 ? 0 : page - 1;
    var pageable = PageRequest.of(pageNo, 10, Direction.DESC, "createdAt");
    var bookmarkPage = bookmarkRepository.findBookmarks(pageable);

    return new BookmarksDTO(bookmarkPage);
  }
}
