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
            helper.setSubject("Reset Password");
            String htmlContent =( "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"direction:ltr;font-size:0px;padding:5px 5px 5px 5px;text-align:center\">\n" +
                    "<div style=\"margin:0px auto;max-width:590px\">\n" +
                    "<table style=\"width:100%\" role=\"presentation\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"direction:ltr;font-size:0px;padding:5px 5px 5px 5px;text-align:center\">\n" +
                    "<div class=\"m_-290301008761648123mj-column-per-100\" style=\"font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%\">\n" +
                    "<table style=\"vertical-align:top\" role=\"presentation\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"font-size:0px;padding:5px 5px 10px 5px;word-break:break-word\" align=\"left\">\n" +
                    "<div style=\"font-family:BinancePlex,Arial,PingFangSC-Regular,'Microsoft YaHei',sans-serif;font-size:20px;font-weight:900;line-height:25px;text-align:left;color:#000000\">\n" +
                    "<div>Did You Login From a New Device or Location?</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"background:#ffffff;font-size:0px;padding:5px 5px 5px 5px;word-break:break-word\" align=\"left\">\n" +
                    "<div style=\"font-family:BinancePlex,Arial,PingFangSC-Regular,'Microsoft YaHei',sans-serif;font-size:14px;line-height:20px;text-align:left;color:#000000\">\n" +
                    "<div>We noticed your Binance account <a href=\"mailto:hdhia46@gmail.com\" target=\"_blank\">hdhia46@gmail.com</a> was accessed from a new IP address.&nbsp;</div>\n" +
                    "<div>&nbsp;</div>\n" +
                    "<div><strong>When </strong>: 2024-03-06 17:24:16(UTC)</div>\n" +
                    "<div><strong>IP Address </strong>: 197.238.199.149</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"font-size:0px;padding:10px 5px 10px 5px;word-break:break-word\" align=\"left\">\n" +
                    "<table style=\"border-collapse:separate;line-height:100%\" role=\"presentation\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"border:none;border-radius:3px;background:#fcd535\" role=\"presentation\" align=\"center\" valign=\"middle\" bgcolor=\"#FCD535\"><a href=\"https://app.binance.com/en/my/security/account-activity?utm_source=crm&amp;utm_medium=email&amp;utm_campaign=transactional&amp;utm_content=email_login_ip&amp;_dp=L2FjY291bnQvYWNjb3VudEFjdGl2aXR5\" rel=\"noopener\" style=\"display:inline-block;background:#fcd535;color:#000000;font-family:BinancePlex,Arial,PingFangSC-Regular,'Microsoft YaHei',sans-serif;font-size:14px;font-weight:900;line-height:15px;margin:0;text-decoration:none;text-transform:none;padding:10px 25px;border-radius:3px\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://app.binance.com/en/my/security/account-activity?utm_source%3Dcrm%26utm_medium%3Demail%26utm_campaign%3Dtransactional%26utm_content%3Demail_login_ip%26_dp%3DL2FjY291bnQvYWNjb3VudEFjdGl2aXR5&amp;source=gmail&amp;ust=1709871784474000&amp;usg=AOvVaw3DBpzVTYQd9i5E_Vvvtvi7\"> Visit Your Account </a></td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"font-size:0px;padding:5px 5px 5px 5px;word-break:break-word\" align=\"left\">\n" +
                    "<div style=\"font-family:BinancePlex,Arial,PingFangSC-Regular,'Microsoft YaHei',sans-serif;font-size:14px;line-height:20px;text-align:left;color:#000000\">\n" +
                    "<div>Don’t recognize this activity? Please <a href=\"https://accounts.binance.com/en/user/reset-password/1?type=email\" style=\"font-family:BinancePlex,Arial,PingFangSC-Regular,'Microsoft YaHei',sans-serif;color:#f0b90b\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://accounts.binance.com/en/user/reset-password/1?type%3Demail&amp;source=gmail&amp;ust=1709871784474000&amp;usg=AOvVaw1KcZ5ahu5lm3FnaFBONZnn\">reset your password</a> and contact <a href=\"https://www.binance.com/en/support\" style=\"font-family:BinancePlex,Arial,PingFangSC-Regular,'Microsoft YaHei',sans-serif;color:#f0b90b\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.binance.com/en/support&amp;source=gmail&amp;ust=1709871784474000&amp;usg=AOvVaw1iNKXso7vg3AFrhy1Bvcie\">customer support</a> immediately.&nbsp;</div>\n" +
                    "<div>&nbsp;</div>\n" +
                    "<div><em>This is an automated message, please do not reply.&nbsp; </em></div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>") ;
            helper.setText(htmlContent, true);
            mailSender.send(message);
            System.out.println("Mail Sent successfully...");


    }

}
