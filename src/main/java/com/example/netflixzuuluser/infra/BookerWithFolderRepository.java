package com.example.netflixzuuluser.infra;


import com.example.netflixzuuluser.entity.BookerWithFolder;
import com.example.netflixzuuluser.entity.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookerWithFolderRepository extends JpaRepository<BookerWithFolder, Integer> {
}
