# router
> Android路由功能,主要是用于webView 扩展之后，调用原生的
方法跳转。

### 使用方法

## ddd


1.将router 文件夹拷贝到项目目录下

2.代码如下
``` java
 /**
 * context 上下文
 * url 服务端获取的url
 */
 new UrlRouter(Context context).router(String url);
```
