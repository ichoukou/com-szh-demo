package com.szh.test;

import com.dajie.common.util.StringUtil;
import org.apache.commons.mail.Email;

import javax.activation.DataHandler;
import javax.activation.URLDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by zhihaosong on 17-6-1.
 */
public class MailSenderTest {

    public static void test() {
        String host = "mx47.dajie.com";
        //  String ip = "211.151.116.98";
        String[] ips = new String[]{"211.151.116.105", "211.151.116.106", "211.151.116.107", "211.151.116.108", "211.151.116.109", "211.151.116.110", "211.151.116.111", "211.151.116.112", "211.151.116.113", "211.151.116.114", "211.151.116.115", "211.151.116.116", "211.151.116.117", "211.151.116.118", "211.151.116.119"};
        String ip = "211.151.116.105";
        String email = "18201090152@163.com";
        String uName = "窦汝鹏";
        String subject = "感谢您能参加开发的工作";
        String content = "窦先生，你好：我是大街网hr,特邀您来我公司查看。";
        for (int i = 0; i < ips.length; i++) {
            ip = ips[i];
            MTA mta = new MTA(1, host, ip);
            new MailSenderTest().doPost(mta, subject, content,
                    StringUtil.EMPTY, StringUtil.EMPTY, email, uName);

        }
    }

    public static void main(String[] args) {
        String host = "mx47.dajie.com";
        //  String ip = "211.151.116.98";
        String[] ips = new String[]{"211.151.116.105", "211.151.116.106", "211.151.116.107", "211.151.116.108", "211.151.116.109", "211.151.116.110", "211.151.116.111", "211.151.116.112", "211.151.116.113", "211.151.116.114", "211.151.116.115", "211.151.116.116", "211.151.116.117", "211.151.116.118", "211.151.116.119"};
        String ip = "211.151.116.105";
        String email = "1551151530@qq.com";
        String uName = "窦汝鹏";
        String subject = "感谢您能参加开发的工作";
        String content = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>edm-用户投递后推荐</title>\n" +
                "</head>\n" +
                "<body style=\"background:#f7f7f7;font-family:'微软雅黑';\">\n" +
                "    <div style=\"word-wrap: break-word;background:#f7f7f7\">   \n" +
                "        <table cellpadding=\"0\" cellspacing=\"0\" width='600' border=\"0\" align=\"center\" height\n" +
                "        =\"10\">\n" +
                "            <tbody> \n" +
                "                <tr> \n" +
                "                    <td width=\"10\">&nbsp;</td> \n" +
                "                    <td style=\"font-size:24px;\" align=\"left\" height=\"30\">  \n" +
                "                        <img src=\"https://f1.dajieimg.com/n/micro_blog/T1IrEvBKhv1R4cSCrK_c.png\" alt=\"\">\n" +
                "                    </td>\n" +
                "                    <td align=\"right\" style=\"color:#666666;font-size:14px;font-family:'微软雅黑'\">\n" +
                "                        2017-01-01\n" +
                "                    </td>\n" +
                "                    <td width=\"10\" bgcolor=\"\" align=\"left\" style=\"\">&nbsp;</td> \n" +
                "                </tr> \n" +
                "            </tbody> \n" +
                "        </table>\n" +
                "\n" +
                "        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\" style=\"border-top:3px solid #24aabb;border-left:1px solid #e8e8e8;border-right:1px solid #e8e8e8;\">\n" +
                "            <tbody> \n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"35\">&nbsp;</td> \n" +
                "                                    <td style=\"color:#333;font-weight:bold;font-size:18px;font-family:'微软雅黑';line-height:35px;\">您好</td>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"35\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td style=\"color:#333;font-size:14px;font-family:'微软雅黑';line-height:25px;\">\n" +
                "                                        $投递职位时间 }前，您在大街网投递过  {$投递职位名称 } 的职位。我们为您推荐与此相似的职位，也许您也会感兴趣！\n" +
                "                                    </td>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        <!--第一个列表-->\n" +
                "        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\" style=\"border-left:1px solid #e8e8e8;border-right:1px solid #e8e8e8;border-bottom:1px solid #e8e8e8;font-family:'微软雅黑'\">\n" +
                "            <tbody> \n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"25\">&nbsp;</td> \n" +
                "                                    <td>\n" +
                "                                        <table>\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td style=\"color:#09b6d7;font-size:22px;font-family:'微软雅黑'\">\n" +
                "                                                        <span style=\"display:inline-block;max-width: 290px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;\">java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师</span>&emsp;<span style=\"color:#ff6100;font-size:18px;display:inline-block;max-width: 100px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;\">30k-99k/月</span>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td style=\"color:#666;font-size:12px;font-family:'微软雅黑';line-height:20px;\">百度&emsp;<span style=\"color:#c9c9c9;\">|</span>&emsp;互联网行业&emsp;</td>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                    <td style=\"color:#fff;font-size:16px;font-family:'微软雅黑';vertical-align:middle;\" align=\"center\" width=\"110\" >\n" +
                "                                        <p style=\"color:#fff;font-size:16px;font-family:'微软雅黑';width:110px;height:40px;line-height:40px;background:#09b6d9;border-radius:4px;margin:0;padding:0;vertical-align:middle\">投递</p>\n" +
                "                                    </td>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"25\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "\n" +
                "        <!--第二个列表-->\n" +
                "        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\" style=\"border-left:1px solid #e8e8e8;border-right:1px solid #e8e8e8;border-bottom:1px solid #e8e8e8;font-family:'微软雅黑'\">\n" +
                "            <tbody> \n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"25\">&nbsp;</td> \n" +
                "                                    <td>\n" +
                "                                        <table>\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td style=\"color:#09b6d7;font-size:22px;font-family:'微软雅黑'\">\n" +
                "                                                        <span style=\"display:inline-block;max-width: 290px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;\">java工程师</span>&emsp;<span style=\"color:#ff6100;font-size:18px;display:inline-block;max-width: 100px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;\">30k-99k/月</span>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td style=\"color:#666;font-size:12px;font-family:'微软雅黑';line-height:20px;\">百度&emsp;<span style=\"color:#c9c9c9;\">|</span>&emsp;互联网行业&emsp;</td>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                    <td style=\"color:#fff;font-size:16px;font-family:'微软雅黑';vertical-align:middle;\" align=\"center\" width=\"110\" >\n" +
                "                                        <p style=\"color:#fff;font-size:16px;font-family:'微软雅黑';width:110px;height:40px;line-height:40px;background:#09b6d9;border-radius:4px;margin:0;padding:0;vertical-align:middle\">投递</p>\n" +
                "                                    </td>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"25\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "\n" +
                "        <!--第三个列表-->\n" +
                "        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\" style=\"border-left:1px solid #e8e8e8;border-right:1px solid #e8e8e8;border-bottom:1px solid #e8e8e8;font-family:'微软雅黑'\">\n" +
                "            <tbody> \n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"25\">&nbsp;</td> \n" +
                "                                    <td>\n" +
                "                                        <table>\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td style=\"color:#09b6d7;font-size:22px;font-family:'微软雅黑'\">\n" +
                "                                                        <span style=\"display:inline-block;max-width: 290px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;\">java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师</span>&emsp;<span style=\"color:#ff6100;font-size:18px;display:inline-block;max-width: 100px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;\">30k-99k/月</span>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td style=\"color:#666;font-size:12px;font-family:'微软雅黑';line-height:20px;\">百度&emsp;<span style=\"color:#c9c9c9;\">|</span>&emsp;互联网行业&emsp;</td>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                    <td style=\"color:#fff;font-size:16px;font-family:'微软雅黑';vertical-align:middle;\" align=\"center\" width=\"110\" >\n" +
                "                                        <p style=\"color:#fff;font-size:16px;font-family:'微软雅黑';width:110px;height:40px;line-height:40px;background:#09b6d9;border-radius:4px;margin:0;padding:0;vertical-align:middle\">投递</p>\n" +
                "                                    </td>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"25\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "\n" +
                "        <!--第四个列表-->\n" +
                "        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\" style=\"border-left:1px solid #e8e8e8;border-right:1px solid #e8e8e8;border-bottom:1px solid #e8e8e8;font-family:'微软雅黑'\">\n" +
                "            <tbody> \n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"25\">&nbsp;</td> \n" +
                "                                    <td>\n" +
                "                                        <table>\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td style=\"color:#09b6d7;font-size:22px;font-family:'微软雅黑'\">\n" +
                "                                                        <span style=\"display:inline-block;max-width: 290px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;\">java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师java工程师</span>&emsp;<span style=\"color:#ff6100;font-size:18px;display:inline-block;max-width: 100px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;\">30k-99k/月</span>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td style=\"color:#666;font-size:12px;font-family:'微软雅黑';line-height:20px;\">百度&emsp;<span style=\"color:#c9c9c9;\">|</span>&emsp;互联网行业&emsp;</td>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                    <td style=\"color:#fff;font-size:16px;font-family:'微软雅黑';vertical-align:middle;\" align=\"center\" width=\"110\" >\n" +
                "                                        <p style=\"color:#fff;font-size:16px;font-family:'微软雅黑';width:110px;height:40px;line-height:40px;background:#09b6d9;border-radius:4px;margin:0;padding:0;vertical-align:middle\">投递</p>\n" +
                "                                    </td>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"25\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#ffffff\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#f7f7f7\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" width='598' border=\"0\" align=\"center\" bgcolor=\"#f7f7f7\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td width=\"30\" bgcolor=\"#f7f7f7\" height=\"20\">&nbsp;</td> \n" +
                "                                    <td width=\"30\" bgcolor=\"#f7f7f7\" height=\"20\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "       \n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
        MTA mta = new MTA(1, host, ip);
        new MailSenderTest().doPost(mta, subject, content,
                StringUtil.EMPTY, StringUtil.EMPTY, email, uName);

    }

    public void doPost(MTA mta, String subject, String content,
                       String attachmentTitle, String attachmentUrl,
                       String email, String uName) {
        String charset = "UTF-8";
        Properties prop = new Properties();
        prop.setProperty(Email.MAIL_TRANSPORT_PROTOCOL, Email.SMTP);
        prop.setProperty(Email.MAIL_HOST, mta.getIp());
        prop.setProperty(Email.MAIL_PORT,
                String.valueOf(25));
        prop.setProperty("mail.smtp.timeout", "2000");
        prop.setProperty("mail.smtp.connectiontimeout", "2000");
        Session session = Session.getInstance(prop, null);
        MimeMessage message = new MimeMessage(session);
        Transport myTransport = null;
        String error = "";
        try {
            InternetAddress toAddr = new InternetAddress(email);
            toAddr.setPersonal(uName, charset);
            message.addRecipient(Message.RecipientType.TO, toAddr);
            message.setHeader("List-Unsubscribe", "http://www.dajie.com/settings/email");

            String from = StringUtil.EMPTY;
            String domain = StringUtil.EMPTY;

            if (from == null || "".equals(from)) {
                from = "noreply@sysmail.dajie.com";
            } else {
                from = from.split("@")[0] + "@" + "sysmail.dajie.com";
            }

            InternetAddress fromAddr = new InternetAddress(from);

            String fromName = "大街网";
            fromAddr.setPersonal(fromName, charset);

            message.setFrom(fromAddr);

            message.setSubject(subject, charset);

            message.setContent(content, "text/html;charset=" + charset);
            myTransport = session.getTransport("smtp");
            myTransport.connect();
            myTransport.sendMessage(message,
                    message.getRecipients(javax.mail.Message.RecipientType.TO));

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (SendFailedException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (myTransport != null) {
                    myTransport.close();
                }
            } catch (MessagingException mex) {
            }
        }
    }
}
