package com.sivalabs.bookmarker.domain;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookmarkDTO {

  private Long id;
  private String title;
  private String url;
  private Instant createdAt;
}
