package myshopping.common;



import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回处理器
 */
public class ResponseHandler extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResponseHandler() {
        put("code", 0);
        put("msg", "success");
    }

    public static ResponseHandler error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static ResponseHandler error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static ResponseHandler error(int code, String msg) {
        ResponseHandler r = new ResponseHandler();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResponseHandler ok(String msg) {
        ResponseHandler r = new ResponseHandler();
        r.put("msg", msg);
        return r;
    }

    public static ResponseHandler ok(Map<String, Object> map) {
        ResponseHandler r = new ResponseHandler();
        r.putAll(map);
        return r;
    }

    public static ResponseHandler ok() {
        return new ResponseHandler();
    }

    public ResponseHandler put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}