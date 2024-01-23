package com.example.Reto2.socketsio.config;

public enum SocketEvents {
	ON_MESSAGE_RECEIVED("chat message"), ON_SEND_MESSAGE("chat message");

	public final String value;

	private SocketEvents(String value) {
		this.value = value;
	}
}
