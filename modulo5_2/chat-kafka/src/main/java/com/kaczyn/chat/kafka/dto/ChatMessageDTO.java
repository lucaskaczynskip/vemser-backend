package com.kaczyn.chat.kafka.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatMessageDTO {
	
	@NotEmpty
	private String usuario;
	
	@NotEmpty
	private String mensagem;
	private LocalDateTime dataCriacao;
}
