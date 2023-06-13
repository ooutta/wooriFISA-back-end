package step09interface.step01;

public class MusicTest {

	public static void main(String[] args) {
		Audio lpRecord = new Audio(); // 음악 CD
		
		Bts bts = new Bts();
		lpRecord.musicPlay(bts);
		
		System.out.println("다음 노래 재생");
		
		Joy joy = new Joy();
		lpRecord.musicPlay(joy);
	}

}
