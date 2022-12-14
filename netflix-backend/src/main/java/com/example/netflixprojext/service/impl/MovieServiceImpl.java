package com.example.netflixprojext.service.impl;

import com.example.netflixprojext.dao.impl.MoviesDAOImpl;
import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MoviesDAOImpl moviesDAO;





    public List<MoviesDTO> getMovies(){
        return moviesDAO.getAll();
    }

    public Movie save(MoviesDTO moviesDTO){
        return moviesDAO.add(moviesDTO);
    }

    public MoviesDTO getById(Long id){
        return moviesDAO.getById(id);
    }

    public int removeById(Long id){
        return moviesDAO.removeById(id);
    }

    public void addMovieToUser(String name,Long id){
        moviesDAO.addMovieToUser(name, id);
    }


    public MoviesDTO searchByName(String name){
        return moviesDAO.searchByName(name);
    }

    public List<MoviesDTO> findCategory(Long id){
        return moviesDAO.findByCategory(id);
    }
}
