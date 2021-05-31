package Usecase.service;

import java.util.List;
import java.util.Map;

import Usecase.dao.MessageDaoImpl;
import entity.Message;
import entity.Usecase;

public class MessageServiceImpl {
	public List<Map<String, Object>> listMessages() {
		return new MessageDaoImpl().findAll();
	}

	public List<Usecase> listAllMessages() {
		return new  MessageDaoImpl().findAllCases();
	}

	public boolean addMessage(Message message) {
		int count = new MessageDaoImpl().saveMessage(message);
		return count > 0;
	}

	public Message getMessage(int id) {
		return new MessageDaoImpl().findById(id);
	}

	public boolean editCase(Message message) {
		int count = new MessageDaoImpl().updateMessages(message);
		return count > 0;
	}

	public boolean dropMessage(int id) {
		int count = new MessageDaoImpl().deleteMessage(id);
		return count > 0;
	}
	public boolean dropMessage() {
		return new MessageDaoImpl().deleteMessage();
	}

}
