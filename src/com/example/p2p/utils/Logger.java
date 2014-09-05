package com.example.p2p.utils;

import android.util.Log;

/**
 * 封装打印类，主要是为了更好的控制打印
 * 
 * @author liyanshun
 * 
 */
public class Logger {
	/** 打印log的开关 */
	private static final boolean IS_DEBUG = true;
	// 内部断定是否显示log信息
	private static boolean mIsInnerShowLog = IS_DEBUG;

	/**
	 * 得到被打印的文件名行数等信息
	 */
	private static String getFunctionName() {
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		if (sts == null) {
			return null;
		}
		for (StackTraceElement st : sts) {
			if (st.isNativeMethod()) {
				continue;
			}
			if (st.getClassName().equals(Thread.class.getName())) {
				continue;
			}
			if (st.getClassName().equals("cn.com.carsmart.lecheng.carshop.util.Logger")) {
				continue;
			}
			return "[Line: " + st.getLineNumber() + "] ";
		}
		return null;
	}

	public static void i(String tag, Object message) {
		if (mIsInnerShowLog) {
			String name = getFunctionName();
			if (name == null) {
				Log.i(tag, message.toString());
			} else {
				Log.i(tag, name + message.toString());
			}

		}
	}

	public static void d(String tag, Object message) {
		if (mIsInnerShowLog) {
			String name = getFunctionName();
			if (name == null) {
				Log.d(tag, message.toString());
			} else {
				Log.d(tag, name + message.toString());
			}
		}
	}

	public static void v(String tag, Object message) {
		if (mIsInnerShowLog) {
			String name = getFunctionName();
			if (name == null) {
				Log.v(tag, message.toString());
			} else {
				Log.v(tag, name + message.toString());
			}
		}
	}

	public static void w(String tag, Object message) {
		if (mIsInnerShowLog) {
			String name = getFunctionName();
			if (name == null) {
				Log.w(tag, message.toString());
			} else {
				Log.w(tag, name + message.toString());
			}
		}
	}

	public static void e(String tag, Object message) {
		if (mIsInnerShowLog) {
			String name = getFunctionName();
			if (name == null) {
				Log.e(tag, message.toString());
			} else {
				Log.e(tag, name + message);
			}

		}
	}

	public static void e(String tag, Exception e) {
		if (mIsInnerShowLog) {
			String name = getFunctionName();
			if (name == null) {
				Log.e(tag, e.getMessage());
			} else {
				Log.e(tag, name + e.getMessage());
			}

		}
	}
}
