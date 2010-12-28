package com.alibaba.intl.bcds.goldroom.mail.utils;

import java.util.LinkedList;

public class MailQueue {

	private LinkedList<MailDto> list;

	private MailQueue() {
		list = new LinkedList<MailDto>();
	}

	private static MailQueue mailQueue;

	static {

		mailQueue = new MailQueue();

	}

	public synchronized static MailQueue getInstance() {
		if (mailQueue == null) {
			mailQueue = new MailQueue();
		}
		return mailQueue;
	}

	// 队列元素的个数
	public int size() {
		return list.size();
	}

	// 进入队列
	public void enqueue(MailDto obj) {
		list.addLast(obj);

	}

	// 对头出来
	public MailDto dequeue() {
		return list.removeFirst();
	}

	// 浏览对头元素
	public Object front() {
		return list.peekFirst();
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
