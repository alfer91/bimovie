package org.zerock.bimovie.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.zerock.bimovie.entity.Movie;
import org.zerock.bimovie.entity.Poster;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    /*@Test
    public void testInsert() {

        log.info("testInsert...................");

        Movie movie = Movie.builder().title("극한직업").build();

        movie.addPoster(Poster.builder().fname("극한직업포스터1.jpg").build());
        movie.addPoster(Poster.builder().fname("극한직업포스터2.jpg").build());

        movieRepository.save(movie);

        log.info(movie.getMno());
    }*/

    @Test
    @Transactional
    @Commit
    public void testAddPoster() {

        Movie movie = movieRepository.getOne(1L); //데이터베이스에 존재하는 영화 번호

        movie.addPoster(Poster.builder().fname("극한직업포스터3.jpg").build()); //새로운 Poster 객체

        movieRepository.save(movie);
    }
}