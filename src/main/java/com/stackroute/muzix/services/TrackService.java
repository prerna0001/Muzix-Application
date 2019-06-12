//TrackService interface

package com.stackroute.muzix.services;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TrackService {
    public Track addMusicTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllMusicTracks() throws TrackNotFoundException;
    public void deleteMusicTrack(int trackId) throws TrackNotFoundException;

}
