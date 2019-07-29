package com.kh.hp.serviceCenter.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.kh.hp.serviceCenter.model.service.ServiceCenterService;

@ServerEndpoint("/serverStart")
public class RealTimeQnA {

//	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	private static Map<String, Session> clients = Collections.synchronizedMap(new HashMap<String, Session>());

	/**
	 * 서버 연결 시점
	 * @param session
	 */
	@OnOpen
	public void onOpen(Session session) {
		String queryString = session.getQueryString();
		String userSeq = queryString.split("=")[1];

		clients.put(userSeq, session);
		System.out.println("clients.size()::" + clients.size());
	}

	/**
	 * 메시지 전송  시점
	 * @param msg
	 * @param session
	 * @throws IOException
	 */
	@OnMessage
	public void onMessage(String msg, Session session) throws IOException {
		String queryString = session.getQueryString();
		String userSeq = queryString.split("=")[1];

		System.out.println("userSeq::" + userSeq);
		System.out.println("msg::" + msg);

		String[] temp = msg.split("§§");
		String userNick = temp[0];
		String sendMsg = "";
		if(temp.length > 1) {
			sendMsg = temp[1];
		}

		// 관리자 번호를 가진 회원번호 가져오기
		ArrayList<Integer> adminUserSeqList = new ServiceCenterService().selectAdminUserSeqList();

		// 해당 userSeq의 회원등급  코드를 가져온다.
		int userGradeCd = new ServiceCenterService().selectUserGradeCd(userSeq);

		// DB 저장 및 변경
		int result = new ServiceCenterService().insertConversation(userSeq, sendMsg, userGradeCd);

		Iterator<String> iter = clients.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();

			// 일반 회원일 경우 관리자에게 전송
			if(userGradeCd == 1 || userGradeCd == 2) {
				for(int adminUserSeq : adminUserSeqList) {
					if(Integer.parseInt(key) == adminUserSeq) {
						clients.get(key).getBasicRemote().sendText(userNick + ":" + sendMsg);
					}
				} // end for
			} // end if


		} // end while

	}

	/**
	 * 에러 발생 시점
	 * @param e
	 */
	@OnError
	public void onError(Throwable e) {
		//데이터를 전달하는 과정에서 에러가 발생할 경우 동작하는 메소드
		e.printStackTrace();
	}

	/**
	 * 종료 시점
	 * @param session
	 */
	@OnClose
	public void onClose(Session session) {
		String queryString = session.getQueryString();
		String userSeq = queryString.split("=")[1];

		clients.remove(userSeq);
	}
}
