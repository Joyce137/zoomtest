//import com.iflytek.cloud.speech.SpeechError;
//import com.iflytek.cloud.speech.SynthesizerPlayer;
//import com.iflytek.cloud.speech.SynthesizerPlayerListener;
// 
//public class GetTTS {
//    public static void main(String[] args){
//        private String appid="填写你得到的appid";  //填写你得到的appid
//        private String voiceName= "xiaoyan";     //发音人声
//        private int volume = 100;                //发音音量
//        private int voiceSpeed = 40;             //发音语速
//        private String backgroundSound = null;   //背景音乐，1是一首music
//        private String ttsBufferTime = "tts_buffer_time=2000";   //缓冲时间
//        private String sentence = "我是大笨蛋";            //你要说的话
//     
//        //步骤一：获得播放器
//        SynthesizerPlayer tts = SynthesizerPlayer.createSynthesizerPlayer("appid=" + appid); 
// 
//        //步骤二：获得播放器监听器       
//        /**
//         * SynthesizerPlayer Listener
//         */
//        SynthesizerPlayerListener synListener = new SynthesizerPlayerListener() {
//            //缓冲
//            public void onBufferPercent(int percent, int beginPos, int endPos, String arg) {
//                System.out.println("正在缓冲：" + percent);
//            }
//            //播放结束
//            public void onEnd(SpeechError error) {
//                if (error == null)
//                    System.out.println("播放完成");
//                else
//                    System.out.println("错误代码:" + error.getErrorCode());
//            }
//            //开始播放
//            public void onPlayBegin() {
//            }
//            //播放暂停
//            public void onPlayPaused() {
//            }
//            //播放进度
//            public void onPlayPercent(int percent, int beginPos, int endPos) {
//            }
//            //恢复播放
//            public void onPlayResumed() {
//            }
//        };
//     
//        //步骤三：设置参数
//        tts.setVoiceName(voiceName);
//        tts.setSpeed(voiceSpeed);
//        tts.setVolume(volume);        
//        tts.setBackgroundSound(backgroundSound);
// 
//        //步骤四：开始说话
//        tts.playText(sentence,ttsBufferTime,synListener);
//        }
//    }
//}