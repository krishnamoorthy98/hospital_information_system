import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ee extends HttpServlet{

    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          resp.setContentType("text/html");
          PrintWriter s=resp.getWriter();
         String m=  req.getParameter("sent");     
         this.send(m);
          RequestDispatcher rd=req.getRequestDispatcher("/h.html");
          rd.forward(req, resp);

    }
    void send(String v){

        final String username = "rubanru36@gmail.com";
        final String password = "rubanrockkkk";
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rubanru36@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(v));
			message.setSubject("hello sir");
			message.setText("YOUR PASSWORD IS: XUAOQ");

			Transport.send(message);



		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
}

}
