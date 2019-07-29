package com.kh.hp.serviceCenter.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverStart")
public class RealTimeQnA {

//	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	private Map<Integer, Session> clients = Collections.synchronizedMap(new HashMap<Integer, Session>());

	 public RealTimeQnA() {
		// TODO Auto-generated constructor stub

	}

	@OnOpen
	public void onOpen(Session session) {
		//서버 연결한 시점에 동작하는 메소드
		System.out.println(session.getId() + " open!!!");

		String queryString = session.getQueryString();
		int userSeq = 0;
		if(queryString.length() > 1) {
			userSeq = Integer.parseInt(queryString.split("=")[1]);
		}

		//기존 사용자 리스트에 새로 연결 요청이 들어온 사용자를 추가한다
		clients.put(userSeq, session);

		System.out.println(clients.size() + "명 접속");
	}

	@OnMessage
	public void onMessage(String msg, Session session) throws IOException {
		System.out.println(msg);

		// 유저번호 + 메시지
		String[] temp = msg.split("§§");
		Integer sendUserSeq = 0; // 유저 번호
		String sendUserNick = ""; // 닉네임
		String sendMessage = ""; // 메시지
		if(temp.length == 2) {
			sendUserSeq = Integer.parseInt(temp[0]);
			sendUserNick = temp[1];
			sendMessage = temp[1];
		} else {
			// 빈칸일 때
			sendUserSeq = Integer.parseInt(temp[0]);
		}

		System.out.println(sendUserSeq);

		Iterator<Integer> iter = clients.keySet().iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			System.out.println(clients.get(key));
			if(key != sendUserSeq) {
				clients.get(key).getBasicRemote().sendText(sendUserNick + " : " + sendMessage);
			}
		}
	}

	@OnError
	public void onError(Throwable e) {
		//데이터를 전달하는 과정에서 에러가 발생할 경우 동작하는 메소드
		e.printStackTrace();
	}

	@OnClose
	public void onClose(Session session) {
		//지워주지 않으면 Set에 이미 나간 사용자가 남아있기 때문에 메세지 전송시 에러 난다.
		System.out.println("close!!");
		String queryString = session.getQueryString();
		int userSeq = 0;
		if(queryString.length() > 1) {
			userSeq = Integer.parseInt(queryString.split("=")[1]);
		}
		clients.remove(userSeq);
		System.out.println(clients.size() + "명 접속");
	}

}
