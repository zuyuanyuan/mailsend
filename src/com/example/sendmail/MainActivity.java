package com.example.sendmail;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnOK; 
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK = (Button) findViewById(R.id.button);
        btnOK.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                sendEmail();
            	//��ʱ����Ҫ���߳�...�м������ֶ����������
                new Thread(new Runnable() {

            		@Override
            		public void run() {
            			try {
            				EmailSender sender = new EmailSender();
            				//���÷�������ַ�Ͷ˿ڣ������ѵĵ�
            				sender.setProperties("smtp.163.com", "25");
            				//�ֱ����÷����ˣ��ʼ�������ı�����
            				sender.setMessage("sanyuan808@163.com", "EmailSender", "Java Mail ��");
            				//�����ռ���
            				sender.setReceiver(new String[]{"zuyuan.zhang@dianping.com"});
            				//��Ӹ���
            				//���������·�������ֻ���İ���Ҫ����û������ֻ�����ȷ��·��
//            				sender.addAttachment("/sdcard/DCIM/Camera/asd.jpg");
            				//�����ʼ�
            				sender.sendEmail("smtp.163.com", "sanyuan808@163.com", "2563048");
            			} catch (AddressException e) {
            				// TODO Auto-generated catch block
            				e.printStackTrace();
            			} catch (MessagingException e) {
            				// TODO Auto-generated catch block
            				e.printStackTrace();
            			}
            		}
            	}).start();
            }
        });

    }
  
}
