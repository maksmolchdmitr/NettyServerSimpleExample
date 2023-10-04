package maks.molch.dmitr.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import maks.molch.dmitr.data.RequestData;

import java.nio.charset.Charset;

public class RequestDataEncoder extends MessageToByteEncoder<RequestData> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RequestData msg, ByteBuf out) {
        out.writeInt(msg.number());
        out.writeInt(msg.string().length());
        out.writeCharSequence(msg.string(), Charset.defaultCharset());
    }
}
