# rpc

### RMI: 访问和发布基于java的服务
	RMI很难穿透防火墙（RMI不是基于HTTP的），客户端和服务端都必须是java开发，网络传输使用java的序列化。	

### Hessian：基于HTTP，采用二进制消息进行客户端和服务端的交互，跨平台的。
### HttpInvoker：基于HTTP，它只是一个Spring框架所提供的远程调用解决方案。这意味着客户端和服务端必须都是Spring应用。并且，至少目前而言，也隐含表明客户端和服务端必须是基于Java的。另外，因为使用了Java的序列化机制，客户端和服务端必须使用相同版本的类（与RMI类似）。
			
### JAX-WS：java支持soap
### JAX-RS：java支持rest

### websocket(浏览器)
