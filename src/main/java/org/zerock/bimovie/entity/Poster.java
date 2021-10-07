package org.zerock.bimovie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.NavigableMap;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "movie")
@Table(name = "tbl_poster")
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    private String fname;

    //포스터 순번
    private int idx;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
