package com.stackroute.muzix.repository;

import com.stackroute.muzix.model.Track;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TrackRepository extends MongoRepository<Track,Integer> {
//    @Query(value = "select * from track where track_id=?1", nativeQuery = true)
//    public default List<Track> getTrackByName(String trackName) {
//        return null;
//
//    }
}
