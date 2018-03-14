package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String loadData(Model model){

        Actor a = new Actor();
        a.setName("Sandra Bullock");
        a.setRealname("Sandra Mae Bullowski");
        actorRepository.save(a);

        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

        a.addMovie(movie);
        movieRepository.save(movie);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
