package com.choco.netty.demo.juejinchat.protocol.response;

import lombok.Data;
import com.choco.netty.demo.juejinchat.protocol.command.Command;
import com.choco.netty.demo.juejinchat.protocol.command.Packet;

@Data
public class LoginResponsePacket extends Packet {
    boolean success;
    String reason;

    public  Byte getCommand(){
        return Command.LOGIN_RESPONSE;
    }
}
