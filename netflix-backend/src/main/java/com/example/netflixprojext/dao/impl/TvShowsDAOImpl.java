package com.example.netflixprojext.dao.impl;

import com.example.netflixprojext.dao.TvShowsDAO;
import com.example.netflixprojext.dto.TvShowsDTO;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.entities.TvShows;
import com.example.netflixprojext.entities.User;
import com.example.netflixprojext.repository.TvShowsRepository;
import com.example.netflixprojext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
public class TvShowsDAOImpl implements TvShowsDAO {
    @Autowired
    private TvShowsRepository tvShowsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<TvShowsDTO> getAll() {
        return tvShowsRepository.findAll().stream().map(TvShowsDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    public void addShowToUser(String name, Long id) {
        User user = userRepository.findByName(name);
        Optional<TvShows> tvShows = tvShowsRepository.findById(id);
        tvShows.ifPresent(value -> user.getTvShowsList().add(value));
    }

    @Override
    public TvShows add(TvShowsDTO dto) {
        return tvShowsRepository.save(mapToEntity(dto));
    }

    @Override
    public TvShowsDTO getById(Long id) {
        Optional<TvShows> optional = tvShowsRepository.findById(id);
        return optional.map(TvShowsDAOImpl::mapToDTO).orElse(null) ;
    }

    @Override
    public int removeById(Long id) {
        Optional<TvShows> optional = tvShowsRepository.findById(id);
        if(optional.isPresent()){
            tvShowsRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    public TvShowsDTO searchByTitle(String title){
        return mapToDTO(tvShowsRepository.findByTitle(title));
    }


    public static TvShows mapToEntity(TvShowsDTO tvShowsDTO){
        TvShows tvShows=new TvShows();
        tvShows.setTitle(tvShowsDTO.getTitle());
        tvShows.setNoOfEpisodes(tvShowsDTO.getNoOfEpisodes());
        tvShows.setDescription(tvShowsDTO.getDescription());
        tvShows.setDuration(tvShowsDTO.getDuration());
        tvShows.setImageUrl(tvShowsDTO.getImageUrl());
        tvShows.setId(tvShowsDTO.getId());
        tvShows.setUrl(tvShowsDTO.getUrl());
        tvShows.setPrice(tvShowsDTO.getPrice());

        return tvShows;

    }

    public static TvShowsDTO mapToDTO(TvShows tvShows){


        TvShowsDTO tvShowsDTO=new TvShowsDTO();

        tvShowsDTO.setTitle(tvShows.getTitle());
        tvShowsDTO.setDescription(tvShows.getDescription());
        tvShowsDTO.setNoOfEpisodes(tvShows.getNoOfEpisodes());
        tvShowsDTO.setDuration(tvShows.getDuration());
        tvShowsDTO.setImageUrl(tvShows.getImageUrl());
        tvShowsDTO.setId(tvShows.getId());
        tvShowsDTO.setUrl(tvShows.getUrl());
        tvShowsDTO.setPrice(tvShows.getPrice());
        return tvShowsDTO;

    }


}
