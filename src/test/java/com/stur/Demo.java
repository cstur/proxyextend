package com.stur;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import junit.framework.TestCase;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.filters.RequestFilter;
import net.lightbody.bmp.filters.ResponseFilter;
import net.lightbody.bmp.util.HttpMessageContents;
import net.lightbody.bmp.util.HttpMessageInfo;

/**
 * Created by djshi on 2016/1/12.
 */
public class Demo extends TestCase{
	public void testDemo(){
		BrowserMobProxy proxy = new BrowserMobProxyServer();
		proxy.start();

		proxy.addRequestFilter(new RequestFilter() {
			@Override
			public HttpResponse filterRequest(HttpRequest request, HttpMessageContents contents, HttpMessageInfo messageInfo) {
				System.out.println(request.getUri());
				return null;
			}
		});

		// responses are equally as simple:
		proxy.addResponseFilter(new ResponseFilter() {
			@Override
			public void filterResponse(HttpResponse response, HttpMessageContents contents, HttpMessageInfo messageInfo) {
				System.out.println(response.getStatus());
			}
		});
	}
}
