
interface Mediaplayer{
    public void play(String audioType, String filename);
}
interface AdvancedMediaPlayer{

    public void playVlc(String filename);
    public void playMp4(String filename);
}

class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String filename)
    {
        System.out.println("Playing VLC File. Name  :  "+filename);
    }
    public void playMp4(String filename)
    {

    }
}

class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String filename)
    {

    }
    public void playMp4(String filename)
    {
        System.out.println("Playing Mp4 File. Name  :  "+filename);
    }
}

class MediaAdapter implements Mediaplayer{

    AdvancedMediaPlayer advancedMediaPlayer;
    public MediaAdapter (String audioType)
    {
        if(audioType.equalsIgnoreCase("vlc"))
        {
            advancedMediaPlayer = new VLCplayer();
        }
        else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String filename)
    {
        if(audioType.equalsIgnoreCase("vlc"))
        {
            advancedMediaPlayer.playVlc(filename);
        }
        else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(filename);
        }
    }
}

class AudioPlayer implements Mediaplayer{
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String filename)
    {
        if (audioType.equalsIgnoreCase("mp3"))
        {
            System.out.println("Playing Mp3 File. Name :  "+filename);
        } else if ((audioType.equalsIgnoreCase("vlc")) || (audioType.equalsIgnoreCase("mp4"))){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,filename);
        }
        else {
            System.out.println("Invaled Media."+audioType+" format not supported ");
        }
    }
}
public class Main {
    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","beyond the horizon.mp3");
        audioPlayer.play("mp4","Reg.mp4");
        audioPlayer.play("vlc","Checked.vlc");
        audioPlayer.play("avi","mind me.avi");

    }
}