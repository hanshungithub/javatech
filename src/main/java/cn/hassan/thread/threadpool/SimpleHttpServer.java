package cn.hassan.thread.threadpool;

import cn.hassan.thread.threadpool.impl.DefaultThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/13 7:21
 * Description:
 */
public class SimpleHttpServer {
	// 处理HttpRequest的线程池
	static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(1);
	// SimpleHttpServer的根路径
	static String basePath;
	static ServerSocket serverSocket;
	// 服务监听端口
	static int port = 8080;
	public static void setPort(int port) {
		if (port > 0) {
			SimpleHttpServer.port = port;
		}
	}
	public static void setBasePath(String basePath) {
		if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
			SimpleHttpServer.basePath = basePath;
		}
	}
	// 启动SimpleHttpServer
	public static void start() throws Exception {
		serverSocket = new ServerSocket(port);
		Socket socket = null;
		while ((socket = serverSocket.accept()) != null) {
			// 接收一个客户端Socket，生成一个HttpRequestHandler，放入线程池执行
			threadPool.execute(new HttpRequestHandler(socket));
		}
		serverSocket.close();
	}
	static class HttpRequestHandler implements Runnable{

		private Socket socket;

		public HttpRequestHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			String line =null;
			BufferedReader br = null;
			BufferedReader reader = null;
			PrintWriter out = null;
			InputStream in = null;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String head = reader.readLine();
				String filePath = basePath + head.split(" ")[1];
				out = new PrintWriter(socket.getOutputStream());
				if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
					in = new FileInputStream(filePath);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					int i;
					while ((i = in.read()) != -1) {
						baos.write(i);
					}
					byte[] array = baos.toByteArray();
					out.println("HTTP/1.1 200 OK");
					out.println("Server: Molly");
					out.println("Content-Type: image/jpeg");
					out.println("Content-Length: " + array.length);
					out.println("");
					socket.getOutputStream().write(array, 0, array.length);
				}else {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
					out = new PrintWriter(socket.getOutputStream());
					out.println("HTTP/1.1 200 OK");
					out.println("Server: Molly");
					out.println("Content-Type: text/html; charset=UTF-8");
					out.println("");
					while ((line = br.readLine()) != null) {
						out.println(line);
					}
				}
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(br, in, reader, out, socket);
			}
		}
	}
	// 关闭流或者Socket
	private static void close(Closeable... closeables) {
		if (closeables != null) {
			for (Closeable closeable : closeables) {
				try {
					closeable.close();
				} catch (Exception ex) {
				}
			}
		}
	}
}
