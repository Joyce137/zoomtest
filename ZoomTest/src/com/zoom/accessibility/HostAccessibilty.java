package com.zoom.accessibility;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

import com.zoom.tasks.MeetingTask;
import com.zoom.utils.AccessibilityFrame;

public class HostAccessibilty {
	private String text = "��������Ҫ��һ����,������������ͣ�1��ʾ��Ƶ���飬0��ʾ��Ƶ���顣";
	public void host(){
		PlayText.play(text);
		AccessibilityFrame frame = new AccessibilityFrame();
		JTextField jt = frame.getJt();
		jt.setText(null);
		jt.addKeyListener(new KeyAdapter(){ 
            public void keyPressed(KeyEvent e){ 
                char ch=e.getKeyChar(); 
                if(ch>='0'&&ch<='1'){
                	PlayText.play("�㰴��"+ ch +",���ڿ���");
                	MeetingTask task = new MeetingTask();
                	task.host(ch -'0');
                }
                if(ch == 'x'){
                	PlayText.play("�㰴��"+ch+",�����ѹرա�");
                	frame.setVisible(false);
                }
            } 
        }); 	
	}
}
