package com.sivalabs.bookmarker.domain;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bookmarks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {

  @Id
  @SequenceGenerator(name = "bookmark_id_seq_gen", sequenceName = "bookmark_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookmark_id_seq_gen")
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String url;

  private Instant createdAt;
}
