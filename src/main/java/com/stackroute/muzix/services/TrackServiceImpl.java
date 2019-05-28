package com.stackroute.muzix.services;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService
{
    @Autowired
    private TrackRepository trackRepository;

    public TrackRepository getTrackRepository() {

        return trackRepository;
    }


    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track addMusicTrack(Track track)
    {

        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllMusicTracks()
    {

        return trackRepository.findAll();
    }

    @Override
    public void deleteMusicTrack(int trackId) throws TrackNotFoundException
    {
       if (trackRepository.existsById(trackId))
       {
           trackRepository.deleteById(trackId);
       }
       else
       {
           throw  new TrackNotFoundException("Track not found exception!!");
       }

    }


//    @Override
//    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException {
//
//        List<Track> listOfTracks = null;
//        listOfTracks = trackRepository.getTrackByName(trackName);
//        if (listOfTracks.equals(null))
//        {
//            throw new TrackNotFoundException("Track not found exception!!");
//        }
//        return listOfTracks;
//    }

}
