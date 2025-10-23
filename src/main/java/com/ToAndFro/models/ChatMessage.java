package com.ToAndFro.models;

import lombok.*;

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
