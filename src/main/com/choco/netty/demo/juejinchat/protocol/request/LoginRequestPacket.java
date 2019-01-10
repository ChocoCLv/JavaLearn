package com.choco.netty.demo.juejinchat.protocol.request;

import lombok.Data;
import com.choco.netty.demo.juejinchat.protocol.command.Command;
import com.choco.netty.demo.juejinchat.protocol.command.Packet;


@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {

        return Command.LOGIN_REQUEST;
    }
}