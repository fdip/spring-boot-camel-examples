package com.pioneerlabs.poc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/broadcast")
public class SpringBootController {

    private static final String[] loremIpsum = { "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                                "Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi.",
                                                "Cras vel lorem.",
                                                "Etiam pellentesque aliquet tellus.",
                                                "Phasellus pharetra nulla ac diam.",
                                                "Quisque semper justo at risus.",
                                                "Donec venenatis, turpis vel hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui id orci."};
    private final AtomicLong counter = new AtomicLong();
    private final Random rand = new Random();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    Message broadcast() {
        return new Message(counter.incrementAndGet(), loremIpsum[rand.nextInt(loremIpsum.length)]);
    }

}
