package com.dsw.thread;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolink.rtls.client.api.Log;
import com.idolink.rtls.client.api.listener.LiveStreamListener;
import com.idolink.rtls.client.api.vo.LiveStreamError;
import com.idolink.rtls.client.api.vo.LiveStreamPosition;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Scanner;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class RTLSLiveStream extends WebSocketAdapter {
	private WebSocketClient client;
	private LiveStreamListener listener;
	private URI uri;
	private Session session;

	public RTLSLiveStream() {
	}

	public RTLSLiveStream(String url) {
		try {
			this.uri = URI.create(url);
			this.client = new WebSocketClient();
			this.client.start();
		} catch (Exception e) {
			Log.error(e);
		}
	}

	public void connect() {
		try {
			if (!this.client.isStarted()) {
				this.client.start();
			}
			this.client.connect(this, this.uri);
		} catch (Exception e) {
			Log.error(e);
		}
	}

	public void close() {
		try {
			getSession().close();
			this.client.stop();
		} catch (Exception e) {
			Log.error(e);
		}
	}

	public void subscribe(String endPoint, LiveStreamListener listener) {
		try {
			this.listener = listener;
			if (this.session != null)
				this.session.getRemote().sendString("SUBSCRIBE\nid:sub-0\ndestination:" + endPoint + "");
		} catch (IOException e) {
			Log.error(e);
		}
	}

	public void onWebSocketClose(int statusCode, String reason) {
		Log.debug("WebSocket Close = " + statusCode + ", " + reason);
		super.onWebSocketClose(statusCode, reason);
	}

	public void onWebSocketConnect(Session sess) {
		Log.debug("WebSocket Connect = " + sess.getRemoteAddress().toString());
		this.session = sess;
		super.onWebSocketConnect(sess);
	}

	public void onWebSocketError(Throwable cause) {
		Log.debug("WebSocket Error : ");
		cause.printStackTrace();
		super.onWebSocketError(cause);
	}

	public void onWebSocketText(String message) {
		try {
			String destination = "";
			String json = "";
			Scanner scanner = new Scanner(message);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.startsWith("destination:"))
					destination = line.split(":")[1].trim();
				else if (line.startsWith("{")) {
					json = line.trim();
				}
			}
			scanner.close();

			if (destination.equals("/queue/position")) {
				LiveStreamPosition item = (LiveStreamPosition) new ObjectMapper().readValue(json, new TypeReference() {
				});
				if (this.listener != null)
					this.listener.liveStreamPosition(item);
			} else if (destination.equals("/queue/error")) {
				LiveStreamError item = (LiveStreamError) new ObjectMapper().readValue(json, new TypeReference() {
				});
				if (this.listener != null)
					this.listener.liveStreamError(item);
			} else if (destination.equals("/queue/playback")) {
				LiveStreamPosition item = (LiveStreamPosition) new ObjectMapper().readValue(json, new TypeReference() {
				});
				if (this.listener != null)
					this.listener.liveStreamPlayback(item);
			}
		} catch (Exception e) {
			Log.error(e);
		}

		super.onWebSocketText(message);
	}
}