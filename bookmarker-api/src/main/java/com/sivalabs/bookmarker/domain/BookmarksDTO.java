package com.sivalabs.bookmarker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Setter
@Getter
public class BookmarksDTO {

  private List<BookmarkDTO> data;
  private long totalElements;
  private int totalPages;
  private int currentPage;

  @JsonProperty("isFirst")
  private boolean isFirst;

  @JsonProperty("isLast")
  private boolean isLast;

  private boolean hasNext;
  private boolean hasPrevious;

  public BookmarksDTO(Page<BookmarkDTO> page) {
    this.setData(page.getContent());
    this.setTotalElements(page.getTotalElements());
    this.setTotalPages(page.getTotalPages());
    this.setCurrentPage(page.getNumber() + 1);
    this.setFirst(page.isFirst());
    this.setLast(page.isLast());
    this.setHasNext(page.hasNext());
    this.setHasPrevious(page.hasPrevious());
  }
}
