package com.choco.nettychat.protocol.request;

import lombok.Data;
import com.choco.nettychat.protocol.command.Command;
import com.choco.nettychat.protocol.command.Packet;


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