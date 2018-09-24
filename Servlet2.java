/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletConfig;


/**
 *
 * @author Lenovo
 */
public class Servlet2 extends HttpServlet {
    @Override
   public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{   
    PrintWriter out=res.getWriter();
    String to=req.getParameter("email");
    ServletConfig config=getServletConfig();
    String from=config.getInitParameter("adminid");
    String  pwd=config.getInitParameter("password");
    String msg=req.getParameter("message");
    Properties props=new Properties();
    props.put("mail.smtp.auth", "true");

props.put("mail.smtp.starttls.enable", "true");

props.put("mail.smtp.host", "smtp.gmail.com");

props.put("mail.smtp.port", "587"); 
          Session session=Session.getInstance(props, new javax.mail.Authenticator() {    
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,pwd);  
           }    
          });    
          try
          {
           Message message=new MimeMessage(session);
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject("recognition of your request");    
           message.setText(msg);    
           
           Transport.send(message);    
           
          } 
catch (MessagingException e)
{ out.println(e);}    
             
    }  
          
    

}
