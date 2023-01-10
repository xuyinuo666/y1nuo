package exception;

import res.ResponseCodeInterface;

public class BusinessException extends RuntimeException {

    /** * 提示的编码 */
    private final String code;
    /** * 提示语 */
    private final String msg;
    public BusinessException(String code, String msg) {

        super(msg); // 将msg传入父类构造方法，从而实现了抛出异常的功能
        this.code = code;
        this.msg = msg;
    }
    // 取出传入到当前构造方法中的ResponseCodeInterface实现类（枚举类）对象中的状态码和异常信息数据到本类成员变量中。
    public BusinessException(ResponseCodeInterface responseCodeInterface){

        this(responseCodeInterface.getCode(),responseCodeInterface.getMsg());// 此处this的作用是调用本类中其他构造方法 // 此处是调用上面的参数为code和msg的构造方法
    }
    public String getCode() {

        return code;
    }
    public String getMsg() {

        return msg;
    }
}