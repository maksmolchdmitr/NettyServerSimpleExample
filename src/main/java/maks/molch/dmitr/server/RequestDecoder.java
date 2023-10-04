package maks.molch.dmitr.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import maks.molch.dmitr.data.RequestData;

import java.nio.charset.Charset;
import java.util.List;

public class RequestDecoder extends ReplayingDecoder<RequestData> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        int number = in.readInt();
        String string = readStr(in);
        out.add(new RequestData(number, string));
    }

    private String readStr(ByteBuf in) {
        int length = in.readInt();
        return in.readCharSequence(length, Charset.defaultCharset()).toString();
    }
}
