package com.oksoft.utils;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.oksoft.binding.UserAccount;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserAccount userAccount;
	
	public boolean sendUserAccUnlockEmail(UserAccount userAccount) {
		boolean isSent=false;
		try {
              MimeMessage mimeMessage = mailSender.createMimeMessage();			
		     MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
		     helper.setTo(userAccount.getEmailId());
		     helper.setSubject("unlock your account");
		     helper.setText(getUnlockAccEmailBody(userAccount), true);
		     
		     mailSender.send(mimeMessage);
		     isSent=true;
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return isSent;
	}

	private String getUnlockAccEmailBody(UserAccount userAcc) throws Exception {
    StringBuffer stringBuffer=new StringBuffer();
    
    FileReader  fr=new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
    BufferedReader br=new BufferedReader(fr);
    String line=br.readLine();
    while(line!=null) {
    	stringBuffer.append(line);
    	line=br.readLine();
    }
    
    br.close();
      
       String mailBody = stringBuffer.toString();
       mailBody=mailBody.replace("{FNAME}",userAcc.getFirstName());
       mailBody=mailBody.replace("{LNAME}", userAcc.getLastName());
       mailBody=mailBody.replace("{TEMP-PWD}", userAcc.getAccPwd());
       mailBody=mailBody.replace("{EMAIL}",userAcc.getEmailId());
       return mailBody;
       
		
	}
	
}
