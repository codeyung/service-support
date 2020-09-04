# service-support
complex service support

## 模块说明
|名称|描述
 ---- | ----- 
service-support-code|业务扩展支持
service-support-example|业务扩展支持示例


 ## 复杂业务扩展支持
 ![image](https://github.com/codeyung/service-support/blob/master/service-support.jpg)
 
 
 ## 使用
 ```java
   //implements Handler
  @Service
  public class TokenCheckHandler implements IHandler {
  
  
      private final static Logger LOGGER = LoggerFactory.getLogger(TokenCheckHandler.class);
  
      @Override
      public void execute() {
          LOGGER.info("TokenCheckHandler-execute");
      }
  }
  ```
 ```java
   //implements Handler
  @Service
  public class RequestCheckHandler implements IHandler {
  
      private final static Logger LOGGER = LoggerFactory.getLogger(RequestCheckHandler.class);
  
      @Override
      public void execute() {
          LOGGER.info("RequestCheckHandler-execute");
  
      }
  }
  ```
  
 ```java
  //register Processor extends BaseProcessor
  
 @Service
 public class RequestCheckProcessor extends BaseProcessor {
 
 
     //register handler chain
     public RequestCheckProcessor(TokenCheckHandler tokenCheckHandler, RequestCheckHandler requestCheckHandler) {
         this.setProcessor(this);
         this.setSuccessor(null);
         this.append(tokenCheckHandler);
         this.append(requestCheckHandler);
     }
 
     @Override
     public void configurate() {
 
     }
 
     //Override process method parallel or serial execute
     @Override
     public void process() {
         Iterator iterator = this.iterator();
         while (iterator.hasNext()) {
             IHandler handler = (IHandler) iterator.next();
             if (handler.executeFlag()) {
                 handler.execute();
             }
         }
         this.processSuccessor();
     }
 }
 ```
 
 ```java
 public class SupportApplicationTest {
 
     private final static Logger LOGGER = LoggerFactory.getLogger(SupportApplicationTest.class);
 
 
     @Autowired
     private RequestCheckProcessor requestCheckProcessor;
 
     //entry point
     @Test
     public void method() {
         Assert.assertNotNull("RequestCheckProcessor is null", requestCheckProcessor);
 
         try {
             //step 1 bind request
             contextHolder.bindRequest("request");
 
             //step 2 set contextHolder.bindResponse sucess before the end 
             requestCheckProcessor.getProcessor().process();
             contextHolder.bindResponse("response");
 
             //step 3 return response
             LOGGER.info("response : {}", contextHolder.getResponse());
             
         } catch (Exception e) {
             Result result = new Result(e, ErrorCode.FAIL);
             LOGGER.info("response : {}", result);
         } finally {
             //step 4 ThreadLocal contextHolder clear
             contextHolder.clear();
         }
     }
 
 
 }
```
 
 ## 日志
 ```java
 2020-09-05 21:45:25.858  INFO 9258 --- [main] c.c.s.support.holder.ContextHolder       : [ContextHolder] key=request_param,value="request" binded.
 2020-09-05 21:45:25.859 DEBUG 9258 --- [main] c.cy.service.support.core.BaseProcessor  : [BaseProcessor] processor is com.cy.service.support.processor.RequestCheckProcessor.
 2020-09-05 21:45:25.860 DEBUG 9258 --- [main] c.cy.service.support.core.BaseProcessor  : [BaseProcessor] handler is com.cy.service.support.handler.TokenCheckHandler.
 2020-09-05 21:45:25.860  INFO 9258 --- [main] c.c.s.support.handler.TokenCheckHandler  : TokenCheckHandler-execute
 2020-09-05 21:45:25.860 DEBUG 9258 --- [main] c.cy.service.support.core.BaseProcessor  : [BaseProcessor] handler is com.cy.service.support.handler.RequestCheckHandler.
 2020-09-05 21:45:25.860  INFO 9258 --- [main] c.c.s.s.handler.RequestCheckHandler      : RequestCheckHandler-execute
 2020-09-05 21:45:25.861  INFO 9258 --- [main] c.c.s.support.holder.ContextHolder       : [ContextHolder] key=terminate,value=null getted.
 2020-09-05 21:45:25.862  INFO 9258 --- [main] c.c.s.support.holder.ContextHolder       : [ContextHolder] key=response_param,value="response" binded.
 2020-09-05 21:45:25.862  INFO 9258 --- [main] c.c.s.support.SupportApplicationTest     : response : response
 ```