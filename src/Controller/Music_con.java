package Controller;

import java.util.ArrayList;

import Model.Music;
import javazoom.jl.player.MP3Player;

public class Music_con {
	ArrayList<Music> musiclist = new ArrayList<>();

	// 노래를 재생하거나 정지할 수 있는 기능 불러오기
	MP3Player mp3 = new MP3Player();

	public Music_con() {
		musiclist.add(new Music("music/ddiring.mp3")); //musicCon.play(0) 
		musiclist.add(new Music("music/growth.mp3")); //musicCon.play(1) 
		musiclist.add(new Music("music/lvup.mp3")); //musicCon.play(2) 
		musiclist.add(new Music("music/title.mp3")); //musicCon.play(3) 
	}

	public void play(int index) {
		// 노래 재생을 위한 메소드
		// 호출시 musiclist에 있는 노래를 play!
		if (mp3.isPlaying()) { // 실행되는 노래가 있다면 멈추고 다시 재생!
			mp3.stop();
		}

		mp3.play(musiclist.get(index).getMusicPath());
	}

	public void stop() {
		// 노래 정지를 위한 메소드
		mp3.stop();
	}
	
	
}
