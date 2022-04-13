package com.kaczyn.chat.kafka.topics;

public enum ChatTopic {
	CHAT_GERAL("chat-geral"),
	CHAT_MAICON("chat-maicon"),
	CHAT_EZEQUIAS("chat-ezequias"),
	CHAT_ANA("chat-ana"),
	CHAT_FLAVIO("chat-flavio"),
	CHAT_GUILHERME("chat-guilherme"),
	CHAT_LUIZ("chat-luiz"),
	CHAT_PABLO("chat-pablo"),
	CHAT_GUSTAVO("chat-gustavo"),
	CHAT_JOAO("chat-joao"),
	CHAT_GABRIEL("chat-gabriel"),
	CHAT_NICOLAS("chat-nicolas"),
	CHAT_LUCAS("chat-lucas");
	
	private String description;
	
	ChatTopic(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
