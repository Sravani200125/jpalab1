package com.cg.service;

import com.cg.pojo.Author;

public interface AuthorService {
     public String createAuthor(Author au);
     public String removeAuthor(int id);
     public Author getAuthor(int id);
}
