package com.fpi.bims.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回json实体
 * @author yangwei
 *
 */
public class JResult {
	
	/**
	 * 状态码
	 */
	private int code ;
	/**
	 * 业务数据
	 */
	private Object data ;
	/**
	 * 状态描述
	 */
	private String message ;
	
	public JResult() {
		this(null, State.SUCCESS);
	}
	
	public JResult(Object data) {
		this(data, State.SUCCESS);
	}

	public JResult(Object data, State state) {
		this.code = state.code;
		this.data = dataToDict(data);
		this.message = state.message;
	}

	public JResult(Object data, int code , String msg) {
		this.code = code;
		this.data = dataToDict(data);
		this.message = msg;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = dataToDict(data);
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "JResult [code=" + code + ", data=" + data + ", message=" + message + "]";
	}

	public Object dataToDict(Object data) {
		if(data!=null && data instanceof Collection) {
			Map<String , Object> map = new HashMap<String , Object>();
			map.put("entries", data);
			data = map ;
		}
		return data ;
	}
	
	public void putState(State state) {
		this.code = state.code;
		this.message = state.message;
	}
	
	public static JResult createErrorResult(int code,String message) {
		JResult jResult=new JResult();
		jResult.setCode(code);
		jResult.setMessage(message);
		return jResult;
	}
	
	public static JResult createErrorResult(int code,String message,Object data) {
        JResult jResult=new JResult(data);
        jResult.setCode(code);
        jResult.setMessage(message);
        return jResult;
    }
	
	/**
	 * 状态码枚举
	 * @author yangwei
	 *
	 */
	public enum State {
		/**
		 * 成功类型
		 */
		SUCCESS(200, "成功！"),
		/**
		 * 异常类型
		 */
		DEFAULT(201, "数据异常，请稍后再试！");

		private int code ;
		private String message ;


		State(int code , String message) {
            this.code = code ;
            this.message = message ;
        }



		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
    }
}
