package maks.molch.dmitr.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import maks.molch.dmitr.data.RequestData;
import maks.molch.dmitr.data.ResponseData;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(new RequestData(123, "all work and no play makes jack a dull boy"));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(msg);
        ctx.close();
    }
}
