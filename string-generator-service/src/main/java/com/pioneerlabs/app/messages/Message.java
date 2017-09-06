package com.pioneerlabs.app.messages;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private final long id;
    private final String content;
}
