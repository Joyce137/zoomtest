import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;


public class Play {
	public static void main(String[] args){
		// ��ʼ��
		SpeechUtility.createUtility("appid=" + Version.getAppid());
		// �ϳɵ��ı�����
		final String TEXT_CONTENT = "���Ƕ��Ǻú���";
		new New(TEXT_CONTENT);
		new New("hello world");
	}	

}
