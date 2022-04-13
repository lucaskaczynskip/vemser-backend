package com.kaczyn.chat.kafka.topics;

public enum ChatTopic {
	GERAL("chat-geral"),        // 0
	ANA("chat-ana"),            // 1
	EZEQUIAS("chat-ezequias"),  // 2
	FLAVIO("chat-flavio"),
	FELIPE("chat-felipe"),
	GABRIEL("chat-gabriel"),
	GUILHERME("chat-guilherme"),
	GUSTAVO("chat-gustavo"),
	JOAO("chat-joao"),
	LUCAS("chat-lucas"),
	LUIZ("chat-luiz"),
	MAICON("chat-maicon"),      // 11
	NICOLAS("chat-nicolas"),
	PABLO("chat-pablo");
	
	private String description;
	
	ChatTopic(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
