package com.osama.lookify.repositories;

import com.osama.lookify.models.Songs;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface SongRepository extends CrudRepository <Songs, Long> {
    public ArrayList<Songs> findAll();

    public ArrayList<Songs> findAllByArtist(String artist);

    public ArrayList<Songs> findTop10ByOrderByRateDesc();
}
