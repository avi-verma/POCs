package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movies,Long> {

}
