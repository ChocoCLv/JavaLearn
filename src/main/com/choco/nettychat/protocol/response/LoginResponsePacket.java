package com.choco.nettychat.protocol.response;

import lombok.Data;
import com.choco.nettychat.protocol.command.Command;
import com.choco.nettychat.protocol.command.Packet;

@Data
public class LoginResponsePacket extends Packet {
    boolean success;
    String reason;

    public  Byte getCommand(){
        return Command.LOGIN_RESPONSE;
    }
}
