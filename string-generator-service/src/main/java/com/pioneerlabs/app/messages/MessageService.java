package com.pioneerlabs.app.messages;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageService {
    private static final String[] loremIpsum = { "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                                "Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi.",
                                                "Cras vel lorem.",
                                                "Etiam pellentesque aliquet tellus.",
                                                "Phasellus pharetra nulla ac diam.",
                                                "Quisque semper justo at risus.",
                                                "Donec venenatis, turpis vel hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui id orci."};
    private final AtomicLong counter = new AtomicLong();
    private final Random rand = new Random();

    public Message generateRandom() {
        Message randomMsg = new Message(counter.incrementAndGet(), loremIpsum[rand.nextInt(loremIpsum.length)]);
        log.info("Generated message: {}", randomMsg);
        return randomMsg;
    }
}
