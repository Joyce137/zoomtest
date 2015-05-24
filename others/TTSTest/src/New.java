import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SynthesizerListener;


public class New {
	public New(String TEXT_CONTENT){
	// �����ϳɶ���
			SpeechSynthesizer mTts;
			// ��ʼ���ϳɶ���
					mTts = SpeechSynthesizer.createSynthesizer();
					SynthesizerListener mSynListener = new SynthesizerListener() {

						@Override
						public void onSpeakBegin() {
						}

						@Override
						public void onBufferProgress(int progress, int beginPos, int endPos,
								String info) {
							DebugLog.Log("--onBufferProgress--progress:" + progress
									+ ",beginPos:" + beginPos + ",endPos:" + endPos);
						}

						@Override
						public void onSpeakPaused() {

						}

						@Override
						public void onSpeakResumed() {

						}

						@Override
						public void onSpeakProgress(int progress, int beginPos, int endPos) {
							DebugLog.Log("--onSpeakProgress--progress:" + progress
									+ ",beginPos:" + beginPos + ",endPos:" + endPos);

						}

						@Override
						public void onCompleted(SpeechError error) {
							if (null != error)
								DebugLog.Log("onCompleted Code��" + error.getErrorCode());
						}
					};
			// ���÷�����ΪС��
				mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
						// �����ʶ��ٶ�Ϊ50
						mTts.setParameter(SpeechConstant.SPEED, "50");
						// �����������Χ0~100
						mTts.setParameter(SpeechConstant.PITCH, "50");
						// ������������Χ0~100
						mTts.setParameter(SpeechConstant.VOLUME, "50");
						// ���úϳ���Ƶ����λ�ã����Զ��屣��λ�ã��������ڡ�./iflytek.pcm��
						// �������Ҫ����ϳ���Ƶ��ע�͸��д���
						mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./iflytek.pcm");
						// �ϳ��ı�ΪTEXT_CONTENT�ľ��ӣ����ü�����ΪmSynListener
						mTts.startSpeaking(TEXT_CONTENT, mSynListener);
						System.out.println(TEXT_CONTENT);
	}
}
