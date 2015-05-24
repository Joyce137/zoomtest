import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;


public class Play {
	public static void main(String[] args){
		// 初始化
		SpeechUtility.createUtility("appid=" + Version.getAppid());
		// 合成的文本内容
		final String TEXT_CONTENT = "我们都是好孩子";
		new New(TEXT_CONTENT);
		new New("hello world");
	}	

}
