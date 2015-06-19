package in.itiffin.itiffin.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Lingaraj on 23-Feb-15.
 */
public class SendTask extends AsyncTask<String, Integer, Integer> {


    private Context mContext;
    String itiffin;
//    private ProgressDialog dialog = new ProgressDialog(mContext);

    public SendTask()
    {

    }
    public SendTask(Context mContext){
        this.mContext = mContext;

    }

    protected void onPreExecute() {
        // this.dialog.setCancelable(false);
        //this.dialog.setMessage("sending");
        //this.dialog.show();
    }

    protected Integer doInBackground(String... ids) {

        String to = ids[0];//change accordingly

        //Get the session object
        System.out.println("Mail at begining");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("mobisupport@itiffin.in", "bmiapp2015@itiffin.in");//change accordingly
                    }
                });

        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            MimeMessage message1 = new MimeMessage(session);

            message.setFrom(new InternetAddress("www.itiffin.in"));//change accordingly
            message1.setFrom(new InternetAddress("www.itiffin.in"));//change accordingly

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message1.addRecipient(Message.RecipientType.TO, new InternetAddress("mobisupport@itiffin.in"));

            message.setSubject("Nutrition and Health Consultancy");
            message1.setSubject("Nutrition and Health Consultancy");

            if(ids[2].equals("customer_result")) {
               message.setText(ids[3] + ":\n" + ids[5]+"\n\n" +ids[1]);
               message1.setText(ids[3] + ":\n" + ids[1]+"\nContact No:"+ids[4]+  ids[5]);
           }
            else
                message.setText(ids[1]);

            //send message
            Transport.send(message);
            Transport.send(message1);
            System.out.println("Mail send successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

}