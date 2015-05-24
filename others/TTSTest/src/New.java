import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SynthesizerListener;


public class New {
	public New(String TEXT_CONTENT){
	// 语音合成对象
			SpeechSynthesizer mTts;
			// 初始化合成对象
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
								DebugLog.Log("onCompleted Code：" + error.getErrorCode());
						}
					};
			// 设置发音人为小燕
				mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
						// 设置朗读速度为50
						mTts.setParameter(SpeechConstant.SPEED, "50");
						// 设置语调，范围0~100
						mTts.setParameter(SpeechConstant.PITCH, "50");
						// 设置音量，范围0~100
						mTts.setParameter(SpeechConstant.VOLUME, "50");
						// 设置合成音频保存位置（可自定义保存位置），保存在“./iflytek.pcm”
						// 如果不需要保存合成音频，注释该行代码
						mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./iflytek.pcm");
						// 合成文本为TEXT_CONTENT的句子，设置监听器为mSynListener
						mTts.startSpeaking(TEXT_CONTENT, mSynListener);
						System.out.println(TEXT_CONTENT);
	}
}
