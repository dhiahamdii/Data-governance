package com.coderdot.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EMAILSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendNewMail(String to) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject("Test Email");
            String htmlContent = "<div style=\"border-style:solid;border-width:thin;border-color:#dadce0;border-radius:8px;padding:40px 20px\" align=\"center\" class=\"m_-9195818624022335853mdv2rw\"><img src=\"https://ci3.googleusercontent.com/meips/ADKq_NZa00tQPIx4fdFGtuHSHzYQ-whZFD7HWD3OhXR05fT4XqJ_Wca2erL9R9_382bPBUom-sDOVfi4G3FXbYaZsHsGqQUAL6-JIKgEzWlarZbeNSLveyc6EKOURFQhphfzG2ZAwLiyrJsC=s0-d-e1-ft#https://www.gstatic.com/images/branding/googlelogo/2x/googlelogo_color_74x24dp.png\" width=\"74\" height=\"24\" aria-hidden=\"true\" style=\"margin-bottom:16px\" alt=\"Google\" class=\"CToWUd\" data-bit=\"iit\"><div style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;border-bottom:thin solid #dadce0;color:rgba(0,0,0,0.87);line-height:32px;padding-bottom:24px;text-align:center;word-break:break-word\"><div style=\"font-size:24px\">Nouvelle connexion depuis un Apple iPhone 13 </div><table align=\"center\" style=\"margin-top:8px\"><tbody><tr style=\"line-height:normal\"><td align=\"right\" style=\"padding-right:8px\"><img width=\"20\" height=\"20\" style=\"width:20px;height:20px;vertical-align:sub;border-radius:50%\" src=\"https://lh3.googleusercontent.com/a/ACg8ocJ4QWTreyn_TKyjVVUYLOiisPQDMYnwEhAb2L4wOG3PFA=s96-c\" alt=\"\" class=\"CToWUd\" data-bit=\"iit\"></td><td><a style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;color:rgba(0,0,0,0.87);font-size:14px;line-height:20px\">dhia.hamdi1@esprit.tn</a></td></tr></tbody></table> </div><div style=\"font-family:Roboto-Regular,Helvetica,Arial,sans-serif;font-size:14px;color:rgba(0,0,0,0.87);line-height:20px;padding-top:20px;text-align:center\">Nous avons détecté une nouvelle connexion à votre compte&nbsp;Google depuis un Apple iPhone 13. Si c'était vous, aucune action de votre part n'est requise. Dans le cas contraire, nous vous aiderons à sécuriser votre compte.<div style=\"padding-top:32px;text-align:center\"><a href=\"https://accounts.google.com/AccountChooser?Email=dhia.hamdi1@esprit.tn&amp;continue=https://myaccount.google.com/alert/nt/1709260310507?rfn%3D325%26rfnc%3D1%26eid%3D5879403907262854901%26et%3D1\" style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;line-height:16px;color:#ffffff;font-weight:400;text-decoration:none;font-size:14px;display:inline-block;padding:10px 24px;background-color:#4184f3;border-radius:5px;min-width:90px\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://accounts.google.com/AccountChooser?Email%3Ddhia.hamdi1@esprit.tn%26continue%3Dhttps://myaccount.google.com/alert/nt/1709260310507?rfn%253D325%2526rfnc%253D1%2526eid%253D5879403907262854901%2526et%253D1&amp;source=gmail&amp;ust=1709747262037000&amp;usg=AOvVaw3i4d_ylXYAnYY7F9dy5gTQ\">Consulter l'activité</a></div></div><div style=\"padding-top:20px;font-size:12px;line-height:16px;color:#5f6368;letter-spacing:0.3px;text-align:center\">Vous pouvez aussi voir l'activité liée à la sécurité de votre compte ici&nbsp;:<br><a style=\"color:rgba(0,0,0,0.87);text-decoration:inherit\">https://myaccount.google.com/<wbr>notifications</a></div></div>";
            helper.setText(htmlContent, true);
            mailSender.send(message);
            System.out.println("Mail Sent successfully...");

    }

}
