package com.sha.springbootbookseller.repository;

import com.sha.springbootbookseller.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Books, Long>
{

}
