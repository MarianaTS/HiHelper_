package ua.com.hihelper.service;

public interface MailService {

	
	
	public void sendMessage(String context, String mail, String mailbody);
	public void sendMessagefromuser(String content, String email, String mailBody, String ADMINMAIL , String PASSWORD);
}
