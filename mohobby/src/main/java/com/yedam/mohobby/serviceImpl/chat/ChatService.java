package com.yedam.mohobby.serviceImpl.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.mohobby.mapper.chat.ChatMapper;
import com.yedam.mohobby.service.chat.ChatUserVO;
import com.yedam.mohobby.service.chat.ChatVO;
import com.yedam.mohobby.service.chat.ChatVO2;
import com.yedam.mohobby.service.chat.CreateRoomVO;
import com.yedam.mohobby.service.chat.NonReadChatVO;
import com.yedam.mohobby.service.chat.RoomVO;



@Service
public class ChatService implements com.yedam.mohobby.service.chat.ChatService {

	@Autowired
	ChatMapper mapper;

	@Override
	public List<RoomVO> getChatRoom(String memberId) {
		return mapper.getChatRoom(memberId);
	}

	@Override
	public List<RoomVO> getChatMoimRoom(String memberId) {
		return mapper.getChatMoimRoom(memberId);
	}

	@Override
	public List<ChatVO> getChat(String roomNo) {
		return mapper.getChat(roomNo);
	}

	@Override
	public int CreateRoom(CreateRoomVO cr) {
		return mapper.createRoom(cr);
	}

	@Override
	public List<String> getTargetId(ChatUserVO chatUser) {
		return mapper.getTargetId(chatUser);
	}

	@Override
	public List<NonReadChatVO> getNonReadChat(ChatUserVO chatUser) {
		return mapper.getNonReadChat(chatUser);
	}
	@Override
	public int insertMessage(ChatVO2 chat) {
		return mapper.insertMessage(chat);
	}

	@Override
	public int updateCheckTime(ChatUserVO chatUser) {
		return mapper.updateCheckTime(chatUser);
	} 
	
}
