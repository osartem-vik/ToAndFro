package com.ToAndFro.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private Long id;
    private Long senderId;
    private Long chatId;
    private String text;
    private LocalDateTime timestamp;
}
