//import com.iflytek.cloud.speech.SpeechError;
//import com.iflytek.cloud.speech.SynthesizerPlayer;
//import com.iflytek.cloud.speech.SynthesizerPlayerListener;
// 
//public class GetTTS {
//    public static void main(String[] args){
//        private String appid="��д��õ���appid";  //��д��õ���appid
//        private String voiceName= "xiaoyan";     //��������
//        private int volume = 100;                //��������
//        private int voiceSpeed = 40;             //��������
//        private String backgroundSound = null;   //�������֣�1��һ��music
//        private String ttsBufferTime = "tts_buffer_time=2000";   //����ʱ��
//        private String sentence = "���Ǵ󱿵�";            //��Ҫ˵�Ļ�
//     
//        //����һ����ò�����
//        SynthesizerPlayer tts = SynthesizerPlayer.createSynthesizerPlayer("appid=" + appid); 
// 
//        //���������ò�����������       
//        /**
//         * SynthesizerPlayer Listener
//         */
//        SynthesizerPlayerListener synListener = new SynthesizerPlayerListener() {
//            //����
//            public void onBufferPercent(int percent, int beginPos, int endPos, String arg) {
//                System.out.println("���ڻ��壺" + percent);
//            }
//            //���Ž���
//            public void onEnd(SpeechError error) {
//                if (error == null)
//                    System.out.println("�������");
//                else
//                    System.out.println("�������:" + error.getErrorCode());
//            }
//            //��ʼ����
//            public void onPlayBegin() {
//            }
//            //������ͣ
//            public void onPlayPaused() {
//            }
//            //���Ž���
//            public void onPlayPercent(int percent, int beginPos, int endPos) {
//            }
//            //�ָ�����
//            public void onPlayResumed() {
//            }
//        };
//     
//        //�����������ò���
//        tts.setVoiceName(voiceName);
//        tts.setSpeed(voiceSpeed);
//        tts.setVolume(volume);        
//        tts.setBackgroundSound(backgroundSound);
// 
//        //�����ģ���ʼ˵��
//        tts.playText(sentence,ttsBufferTime,synListener);
//        }
//    }
//}