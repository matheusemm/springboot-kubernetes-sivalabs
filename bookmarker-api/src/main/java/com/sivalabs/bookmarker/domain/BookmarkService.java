package com.sivalabs.bookmarker.domain;

import com.sivalabs.bookmarker.api.CreateBookmarkRequest;
import java.time.Instant;
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
  private final BookmarkMapper bookmarkMapper;

  @Transactional(readOnly = true)
  public BookmarksDTO getBookmarks(Integer page) {
    var pageNo = page < 1 ? 0 : page - 1;
    var pageable = PageRequest.of(pageNo, 10, Direction.DESC, "createdAt");
    var bookmarkPage = bookmarkRepository.findBookmarks(pageable);

    return new BookmarksDTO(bookmarkPage);
  }

  @Transactional(readOnly = true)
  public BookmarksDTO searchBookmarks(String query, Integer page) {
    var pageNo = page < 1 ? 0 : page - 1;
    var pageable = PageRequest.of(pageNo, 10, Direction.DESC, "createdAt");
    var bookmarkPage = bookmarkRepository.findByTitleContainsIgnoreCase(query, pageable);

    return new BookmarksDTO(bookmarkPage);
  }

  public BookmarkDTO createBookmark(CreateBookmarkRequest body) {
    var bookmark = new Bookmark(null, body.getTitle(), body.getUrl(), Instant.now());
    var savedBookmark = bookmarkRepository.save(bookmark);

    return bookmarkMapper.toDTO(savedBookmark);
  }
}
