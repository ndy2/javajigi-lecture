package net.slipp.myslipp.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class QnA {

    @Id @GeneratedValue
    @Column(name = "qna_id")
    private Long id;

    private String title;
    private LocalDateTime postDateTime;
    private String uploader;

    private String content;
}
