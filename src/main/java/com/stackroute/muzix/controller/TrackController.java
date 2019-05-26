package com.stackroute.muzix.controller;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.services.TrackService;
import com.stackroute.muzix.services.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    @Autowired
    private TrackServiceImpl trackServiceImpl;
    ResponseEntity responseEntity;
    public TrackServiceImpl getTrackService() {
        return trackServiceImpl;
    }

    public void setTrackService(TrackServiceImpl trackService) {
        this.trackServiceImpl = trackService;
    }

    @PostMapping("/songs")
    public ResponseEntity<Track> addSong(@RequestBody Track track) {
        return new ResponseEntity<>(trackServiceImpl.addMusicTrack(track), HttpStatus.OK);
    }

    @PutMapping("/songs")
    public ResponseEntity<Track> update(@RequestBody Track track) throws TrackAlreadyExistsException{
        try {

            return new ResponseEntity<>(trackServiceImpl.addMusicTrack(track), HttpStatus.OK);
        }
        catch(Exception ex)
        {
            return responseEntity;

        }
    }

    @GetMapping("/songs")
    public ResponseEntity<List<Track>> addSong() {

        return new ResponseEntity<>(trackServiceImpl.getAllMusicTracks(), HttpStatus.OK);
    }

    @Value("$(delete.message)")
    private String deleteMessage;
    @DeleteMapping("/songs")
    public ResponseEntity<String> deleteSong(@RequestBody Track track) throws TrackNotFoundException{ //id name both required to ex query
        try {
            trackServiceImpl.deleteMusicTrack(track.getTrackId());
            return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
        }
        catch(TrackNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        return responseEntity;
    }


    @GetMapping(value = "/songs/{trackName}")
    public ResponseEntity<List<Track>> getTrackByName(@PathVariable("trackName") String trackName) throws TrackNotFoundException {
        List<Track> trackOne = trackServiceImpl.getTrackByName(trackName);
        return new ResponseEntity<List<Track>>(trackOne, HttpStatus.OK);
    }

}

   
