package com.oreilly.hh.data;
// Generated Nov 12, 2009 3:42:28 PM by Hibernate Tools 3.2.0.b9



/**
 * Represents an album in the music database, an organized list of tracks @author Jim Elliot
 */
public class AlbumTrack  implements java.io.Serializable {


     private Track track;
     private Integer disc;
     private Integer positionOnDisc;

    public AlbumTrack() {
    }

    public AlbumTrack(Track track, Integer disc, Integer positionOnDisc) {
       this.track = track;
       this.disc = disc;
       this.positionOnDisc = positionOnDisc;
    }
   
    public Track getTrack() {
        return this.track;
    }
    
    public void setTrack(Track track) {
        this.track = track;
    }
    public Integer getDisc() {
        return this.disc;
    }
    
    public void setDisc(Integer disc) {
        this.disc = disc;
    }
    public Integer getPositionOnDisc() {
        return this.positionOnDisc;
    }
    
    public void setPositionOnDisc(Integer positionOnDisc) {
        this.positionOnDisc = positionOnDisc;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("track").append("='").append(getTrack()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


