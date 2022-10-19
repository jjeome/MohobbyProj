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
//sns 채팅방 조회및 생성
	@Override
	public void getSnsChatRoomNo(CreateRoomVO createRoom) {
		mapper.getSnsChatRoomNo(createRoom);
	}
//체크인
	@Override
	public int updateCheckIn(int roomId) {
		return mapper.updateCheckIn(roomId);
	}
//체크아웃
	@Override
	public int updateCheckOut(int roomId) {
		return mapper.updateCheckOut(roomId);
	}
//체크인아웃
	@Override
	public int updateCheckInOut(int preRoomId, int currentRoomId) {
		return mapper.updateCheckInOut(preRoomId, currentRoomId);
	}
//체크인여부 조회
	@Override
	public int getCheckIn(int roomId) {
		return mapper.getCheckIn(roomId);
	}
	
}
