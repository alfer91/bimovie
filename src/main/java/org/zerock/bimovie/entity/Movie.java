package org.zerock.bimovie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "posterList")
@Table(name = "tbl_movie")
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    private String title;

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Poster> posterList = new ArrayList<>();

    public void addPoster(Poster poster) {

        poster.setIdx(this.posterList.size());
        poster.setMovie(this);
        posterList.add(poster);
    }
}
