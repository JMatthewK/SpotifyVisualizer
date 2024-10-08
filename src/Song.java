
/*
 * An object containing important variable of a song's listening data
 * @author John Matthew Kassapian
 */
public class Song {
    private String artistName;
    private String songName;
    private String combinedNames;
    private int msListened;

    public Song(int intMsListened, String strArtistName, String strSongName, String strCombinedNames){
        this.artistName = strArtistName;
        this.songName = strSongName;
        this.msListened = intMsListened;
        this.combinedNames = strCombinedNames;

        // Converting the string date to individual integers

        // Creating a song code with the first bits of the artist name and song name
    }
    /**
    * this method returns a String value that represents the name of the artist
    *
    * @param N/A
    * @return String artistName
    */
    public String getArtistName(){
        return this.artistName;
    }

    /**
    * this method returns a String value that represents the name of the song
    *
    * @param N/A
    * @return String songName
    */
    public String getSongName(){
        return this.songName;
    }

    /**
    * this method returns a int value that represents the msListened this song was listened to in all of the data
    *
    * @param N/A
    * @return int msListened
    */
    public int getMsListened(){
        return this.msListened;
    }

    /**
    * this method adds a given int representing mslistened, and adds it to the one already in the object
    *
    * @param int msListened
    * @return N/A
    */
    public void addMsListened(int x){
        this.msListened += x;
    }

    public void setMsListened(int x){
        this.msListened = x;
    }

    public String getCombinedNames(){
        return this.combinedNames;
    }

    public int getMinutesListened(){
        return (this.msListened / 60000);
    }

}

