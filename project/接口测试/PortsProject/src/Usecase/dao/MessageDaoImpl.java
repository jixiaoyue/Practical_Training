package Usecase.dao;

import java.util.List;
import java.util.Map;

import entity.Message;
import entity.Usecase;
import utils.DBUtil;

public class MessageDaoImpl {
	public List<Map<String, Object>> findAll() {
		return DBUtil.findAll("select * from message");
	}
	public List<Usecase> findAllCases() {
		return DBUtil.find(Message.class, "select * from message", null);
	}
	public int saveMessage(Message message) {
		return DBUtil.executeUpdate("insert into message(r_id,state,information) values (?,?,?)",
				new Object[] {message.getR_id(),message.getState(),message.getInformation()});
	}
	public Message findById(int id) {
		Object obj = DBUtil.findById(Message.class, id);
		return obj != null ? (Message) obj : null;
	}
	public int updateMessages(Message message) {
		return DBUtil.executeUpdate("update message set url=?,method=?,body=?  where id=?", 
				new Object[] {message.getR_id(),message.getState(),message.getInformation()});
	}
	public int deleteMessage(int id) {
		return DBUtil.executeUpdate("delete from message where id=?", new Object[] { id });
	}
//	
	public boolean deleteMessage () {
		return DBUtil.deleteAll("delete from message");
//		return 
	}

}
