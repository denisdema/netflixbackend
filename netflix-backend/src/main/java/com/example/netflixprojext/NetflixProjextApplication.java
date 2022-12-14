package com.example.netflixprojext;

import com.example.netflixprojext.entities.*;
import com.example.netflixprojext.repository.CategoryRepository;
import com.example.netflixprojext.repository.MovieRepository;
import com.example.netflixprojext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import com.example.netflixprojext.entities.Category;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class NetflixProjextApplication  {

    public static void main(String[] args) {

        SpringApplication.run(NetflixProjextApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}




