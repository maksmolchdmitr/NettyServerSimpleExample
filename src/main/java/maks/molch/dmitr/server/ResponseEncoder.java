package maks.molch.dmitr.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import maks.molch.dmitr.data.ResponseData;

public class ResponseEncoder extends MessageToByteEncoder<ResponseData> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ResponseData msg, ByteBuf out) {
        out.writeInt(msg.number());
    }
}
