package com.millky.demo.hal.one;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note, Integer> {

    Note findFirstByNameAndContentOrderByIdDesc(@Param("name") String name,
                                                @Param("content") String content);

    Page<Note> findByNameOrderByIdDesc(@Param("name") String name,
                                       Pageable pageable);

    Page<Note> findByOrderByIdDesc(Pageable pageable);
}
