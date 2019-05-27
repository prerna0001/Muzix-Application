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
    private TrackService trackService;
    ResponseEntity responseEntity;
    public TrackService getTrackService() {

        return trackService;
    }

    public void setTrackService(TrackService trackService)
    {
        this.trackService = trackService;
    }

    @PostMapping("/songs")
    public ResponseEntity<Track> addSong(@RequestBody Track track) {
        return new ResponseEntity<>(trackService.addMusicTrack(track), HttpStatus.OK);
    }

    @PutMapping("/songs")
    public ResponseEntity<Track> update(@RequestBody Track track) throws TrackAlreadyExistsException{
        try {

            return new ResponseEntity<>(trackService.addMusicTrack(track), HttpStatus.OK);
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }
        return responseEntity;
    }

//    @GetMapping("/songs")
//    public ResponseEntity<List<Track>> getAll() {
//
//        return new ResponseEntity<>(trackService.getAllMusicTracks(), HttpStatus.OK);
//    }

    @GetMapping("/songs")
    public ResponseEntity<List<Track>> getAll() {
        try {
            return new ResponseEntity<>(trackService.getAllMusicTracks(), HttpStatus.OK);

        }
        catch (TrackNotFoundException ex)
        {
            ex.getMessage();
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }

        return responseEntity;

    }

    @Value("$(delete.message)")
    private String deleteMessage;
    @DeleteMapping("/songs")
    public ResponseEntity<String> deleteSong(@RequestBody Track track) throws TrackNotFoundException{ //id name both required to ex query
        try {
            trackService.deleteMusicTrack(track.getTrackId());
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
        List<Track> trackOne = trackService.getTrackByName(trackName);
        return new ResponseEntity<List<Track>>(trackOne, HttpStatus.OK);
    }

}

   
