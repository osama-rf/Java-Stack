package com.osama.lookify.controllers;

import com.osama.lookify.models.Songs;
import com.osama.lookify.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService){
        this.songService = songService;
    }

    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    // Dashboard
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model){
        model.addAttribute("songs", songService.allSongs());
        return "dashboard.jsp";
    }

    // Search for Songs
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchSong(@RequestParam(value = "artist") String artist){
        return "redirect:/search/" + artist;
    }

    @RequestMapping(value = "/search/{artist}", method = RequestMethod.GET)
    public String showArtist(@PathVariable(value = "artist") String artist, Model model){
        model.addAttribute("songs", songService.artistSongs(artist));
        model.addAttribute("artist", artist);
        return "search.jsp";
    }

    // Song Detail Page
    @RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
    public String showSong(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("song", songService.findSongs(id));
        return "show.jsp";
    }

    // Create Songs
    @RequestMapping(value = "/songs/new", method = RequestMethod.GET)
    public String newSong(@ModelAttribute("song") Songs songs){
        return "new.jsp";
    }

    @RequestMapping(value = "/songs/create", method = RequestMethod.POST)
    public String createSong(@Valid @ModelAttribute("song") Songs songs, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/songs/new";
        } else {
            songService.createSongs(songs);
            return "redirect:/dashboard";
        }
    }

    // Delete Songs
    @RequestMapping(value = "/songs/{id}/delete", method = RequestMethod.DELETE)
    public String deleteSong(@PathVariable(value = "id") long id){
        songService.deleteSongs(id);
        return "redirect:/dashboard";
    }

    // Return Top 10 songs
    @RequestMapping(value = "search/top", method = RequestMethod.GET)
    public String showTop(Model model){
        model.addAttribute("songs", songService.topSongs());
        return "top.jsp";
    }
}
