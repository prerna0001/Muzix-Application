//TrackController class to controll working of model class

package com.stackroute.muzix.controller;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TrackController {

    private TrackService trackService;
    ResponseEntity responseEntity;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    public TrackService getTrackService() {

        return trackService;
    }

    public void setTrackService(TrackService trackService)
    {
        this.trackService = trackService;
    }

    @PostMapping("/songs")
    public ResponseEntity<?> addSong(@RequestBody Track track) throws TrackAlreadyExistsException { //adding any song to our database
       try {
           return new ResponseEntity<>(trackService.addMusicTrack(track), HttpStatus.CREATED);
       }
       catch (TrackAlreadyExistsException ex)
       {
           return  new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
       }
       catch(Exception ex)
       {
           ex.getMessage();
       }
        return responseEntity;
    }

    @PutMapping("/songs")
    public ResponseEntity<?> update(@RequestBody Track track) throws TrackAlreadyExistsException{ //updating any song in Track
        try {

            return new ResponseEntity<>(trackService.addMusicTrack(track), HttpStatus.OK);
        }
        catch (TrackAlreadyExistsException ex)
        {
            return  new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }
        return responseEntity;
    }


    @GetMapping("/songs")
    public ResponseEntity<List<Track>> getAll() { // get mapping to show allthe tracks
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


}

   
