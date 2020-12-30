package xyz.montos.client.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

//全局异常处理器
//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", 500);
        map.put("errorMsg", exception.toString());
        return map;
    }

}
