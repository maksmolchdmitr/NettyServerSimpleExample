package maks.molch.dmitr.server.handler;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import maks.molch.dmitr.data.RequestData;
import maks.molch.dmitr.data.ResponseData;

public class ProcessingHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        RequestData requestData = (RequestData) msg;
        System.out.println(requestData);
        ResponseData responseData = new ResponseData(requestData.number() * 2);
        ChannelFuture future = ctx.writeAndFlush(responseData);
        future.addListener(ChannelFutureListener.CLOSE);
    }
}
