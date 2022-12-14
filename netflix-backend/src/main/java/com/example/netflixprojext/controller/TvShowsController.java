package com.example.netflixprojext.controller;

import com.example.netflixprojext.dto.TvShowsDTO;
import com.example.netflixprojext.entities.TvShows;
import com.example.netflixprojext.errorHandling.NotFoundException;
import com.example.netflixprojext.service.impl.TvShowsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tvShows")
public class TvShowsController {

    @Autowired
    TvShowsServiceImpl tvShowsService;



    @GetMapping("/tvShowsList")
    public List<TvShowsDTO> getTvShows(){
        return tvShowsService.getTvShows();
    }

    @GetMapping("/{id}")
    public TvShowsDTO getById(@PathVariable Long id){
        TvShowsDTO show = tvShowsService.getById(id);

        if(show==null){
            throw new NotFoundException("TvShow with id "+id+" not found.");
        }
        return show;
    }

    @GetMapping("/search")
    public TvShowsDTO searchTvShows(@RequestHeader("searchname") String name){
        TvShowsDTO show = tvShowsService.searchByName(name);

        if(show==null){
            throw new NotFoundException("TvShow with name "+name+" not found.");
        }
        return show;
    }

//    @PutMapping("/update")
//    public TvShows update(TvShowsDTO tvShowsDTO){
//        return tvShowsService.save(tvShowsDTO);
//    }

//    @DeleteMapping("/delete/{id}")
//    public int removeById(@PathVariable Long id){
//        int show = tvShowsService.removeById(id);
//
//        if(show==0){
//            throw new NotFoundException("TvShow with id "+id+" not found.");
//        }
//        return show;
//    }
//
//    @PostMapping("/save")
//    public TvShows save(TvShowsDTO tvShowsDTO){
//        return tvShowsService.save(tvShowsDTO);
//
//    }


}
