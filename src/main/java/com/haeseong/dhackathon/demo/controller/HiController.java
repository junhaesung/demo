package com.haeseong.dhackathon.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HiController {

    // 최초로 메시지를 전송
    @PostMapping("/hi1")
    public String getHi1() {
        return "{\"responseType\":\"inChannel\",\"text\":\"HelloWorld!\"}";
    }

    // 메시지를 보낸 후 추가로 전송
    @PostMapping("/hi2")
    public String getHi2() {
        return "{\"replaceOriginal\":false,\"responseType\":\"inChannel\",\"text\":\"HelloWorld!\"}";
    }

    // 기존에 보낸 메시지를 업데이트
    @PostMapping("/hi3")
    public String getHi3() {
        return "{\"responseType\":\"inChannel\",\"replaceOriginal\":true,\"text\":\"HelloWorld!(Updated)\"}";
    }

    // 기존에 보낸 메시지를 삭제하고 메시지를 새로 전송
    @PostMapping("/hi4")
    public String getHi4() {
        return "{\"responseType\":\"inChannel\",\"deleteOriginal\":true,\"text\":\"HelloWorld!(Updated)\"}";
    }

    // 주사위 던지기
    @PostMapping("/dice")
    public String dice() {
        return String.format("{\"responseType\":\"inChannel\",\"text\":\"%d\"}", getRandomDiceNumber());
    }

    @PostMapping("/dice/slack")
    public String diceToSlack() {
        return String.format("{\"text\":\"%d\"", getRandomDiceNumber());
    }

    private int getRandomDiceNumber() {
        return new Random().nextInt(6) + 1;
    }
}
