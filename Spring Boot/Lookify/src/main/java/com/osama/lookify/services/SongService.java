package com.osama.lookify.services;

import com.osama.lookify.models.Songs;
import com.osama.lookify.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    // Retrieve All the songs
    public ArrayList<Songs> allSongs(){
        return songRepository.findAll();
    }

    // Create Songs
    public Songs createSongs(Songs songs){
        return songRepository.save(songs);
    }

    // Find Songs
    public Songs findSongs(long id){
        Optional<Songs> songs = songRepository.findById(id);
        if (songs.isPresent()){
            return songs.get();
        }else {
            return null;
        }
    }

    // Update Songs
    public void updateSongs(long id, Songs songs){
        Optional<Songs> song = songRepository.findById(id);
        if (song.isPresent()){
            song.get().setTitle(songs.getTitle());
            song.get().setArtist(songs.getArtist());
            song.get().setRate(songs.getRate());
            songRepository.save(song.get());
        }
    }

    // Delete Songs
    public void deleteSongs(long id){
        Optional<Songs> songs = songRepository.findById(id);
        if (songs.isPresent()){
            songRepository.delete(songs.get());
        }
    }

    // Find Songs by Artist (IMPORTANT)
    public ArrayList<Songs> artistSongs(String artist){
        return songRepository.findAllByArtist(artist);
    }

    // Find Top 10 Songs (IMPORTANT)
    public ArrayList<Songs> topSongs(){
        return songRepository.findTop10ByOrderByRateDesc();
    }
}
