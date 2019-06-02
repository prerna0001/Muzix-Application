//POJO class for Track a model class
package com.stackroute.muzix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.annotation.Documented;

@Document(collection="track")
//@Entity

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {


    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    int trackId;
    String trackName;


    //    public Track() {
//
//    }
//
//    public Track(int trackId, String trackName) {
//        this.trackId = trackId;
//        this.trackName = trackName;
//    }
//
//    public int getTrackId() {
//        return trackId;
//    }
//
//    public void setTrackId(int trackId) {
//        this.trackId = trackId;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    @Override
//    public String toString() {
//        return "Track{" +
//                "trackId=" + trackId +
//                ", trackName='" + trackName + '\'' +
//                '}';
//    }
}
