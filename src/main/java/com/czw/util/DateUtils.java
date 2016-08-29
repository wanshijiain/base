package com.czw.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * @author ZeviChen
 * @Date 2016-07-20 14:45:02
 */
public class DateUtils {

	private static Calendar ca = Calendar.getInstance();
	private static Timestamp time = null;

	/**
	 * 功能: 将日期对象按照某种格式进行转换，返回转换后的字符串
	 *
	 * @param date
	 *            日期对象
	 * @param pattern
	 *            转换格式 例：yyyy-MM-dd
	 */
	public static String dts(Date date, String pattern) {
		String strDateTime = null;
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		strDateTime = date == null ? null : formater.format(date);
		return strDateTime;
	}

	/**
	 * 功能: 将传入的日期对象按照yyyy-MM-dd格式转换成字符串返回
	 *
	 * @param date
	 *            日期对象
	 * @return String
	 */
	public static String dts(Date date) {
		String _pattern = "yyyy-MM-dd";
		return date == null ? null : dts(date, _pattern);
	}

	/**
	 * 功能: 将传入的日期对象按照yyyy-MM-dd HH:mm:ss格式转换成字符串返回
	 *
	 * @param date
	 *            日期对象
	 * @return String
	 */
	public static String dtts(Date date) {
		String _pattern = "yyyy-MM-dd HH:mm:ss";
		return date == null ? null : dts(date, _pattern);
	}

	/**
	 * 功能: 将传入的日期对象按照yyyyMMddHHmmss格式转换成字符串返回 例：20130603110422
	 * 
	 * @param date
	 */
	public static String dtsWithoutChar(Date date) {
		String filename = DateUtils.dtts(new Date());
		filename = StringUtils.replace(filename, " ", "");
		filename = StringUtils.replace(filename, ":", "");
		filename = StringUtils.replace(filename, "-", "");
		return filename;
	}

	/**
	 * 功能: 将插入的字符串按格式转换成对应的日期对象
	 *
	 * @param str
	 *            字符串
	 * @param pattern
	 *            格式
	 * @return Date
	 */
	public static Date std(String str, String pattern) {
		Date dateTime = null;
		try {
			if (str != null && !str.equals("")) {
				SimpleDateFormat formater = new SimpleDateFormat(pattern);
				dateTime = formater.parse(str);
			}
		} catch (Exception ex) {
		}
		return dateTime;
	}

	/**
	 * 功能: 将传入的字符串按yyyy-MM-dd格式转换成对应的日期对象
	 * 
	 * @param str
	 *            需要转换的字符串
	 * @return Date 返回值
	 */
	public static Date std(String str) {
		String _pattern = "yyyy-MM-dd";
		return std(str, _pattern);
	}

	/**
	 * 功能: 将传入的字符串按yyyy-MM-dd HH:mm:ss格式转换成对应的日期对象
	 * 
	 * @param str
	 *            需要转换的字符串
	 * @return Date
	 */
	public static Date stdt(String str) {
		String _pattern = "yyyy-MM-dd HH:mm:ss";
		return std(str, _pattern);
	}

	/**
	 * 功能: 将传入的字符串转换成对应的Timestamp对象
	 * 
	 * @param str
	 *            待转换的字符串
	 * @return Timestamp 转换之后的对象
	 * @throws Exception
	 *             Timestamp
	 */
	public static Timestamp stdHMS(String str) throws Exception {
		time = Timestamp.valueOf(str);
		return time;
	}

	/**
	 * 功能: 根据传入的年月日返回相应的日期对象
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @param day
	 *            天
	 * @return Date 日期对象
	 */
	public static Date YmdToDate(int year, int month, int day) {
		ca.set(year, month, day);
		return ca.getTime();
	}

	/**
	 * 功能：返回传入日期对象（date）之后afterDays天数的日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param afterDays
	 *            往后天数
	 * @return java.util.Date 返回值
	 */
	public static Date getAfterDay(Date date, int afterDays) {
		ca.setTime(date);
		ca.add(Calendar.DATE, 1);
		return ca.getTime();
	}

	/**
	 * 功能：返回传入日期对象（date）之后afterDays天数的日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param afterDays
	 *            往后天数
	 * @return java.util.Date 返回值
	 */
	public static Date getAfterDay2(Date date, int afterDays) {
		ca.setTime(date);
		ca.add(Calendar.DATE, afterDays);
		return ca.getTime();
	}

	/**
	 * 功能：返回传入日期对象（date）之后beforeDays天数的日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param beforeDays
	 *            往前天数
	 * @return java.util.Date 返回值
	 */
	public static Date getBeforeDay(Date date, int beforeDays) {
		ca.setTime(date);
		ca.add(Calendar.DATE, beforeDays);
		return ca.getTime();
	}

	/**
	 * 功能：返回传入日期对象（date）之后beforeMonth月数的日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param beforeDays
	 *            往前月数
	 * @return java.util.Date 返回值
	 */
	public static Date getBeforeMonth(Date date, int beforeMonth) {
		ca.setTime(date);
		ca.add(Calendar.MONTH, beforeMonth);
		return ca.getTime();
	}

	/**
	 * 功能: 返回date1与date2相差的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return int
	 */
	public static int DateDiff(Date date1, Date date2) {
		int i = (int) ((date1.getTime() - date2.getTime()) / 3600 / 24 / 1000);
		return i;
	}

	/**
	 * 取得实际间隔段
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int DateDiff(String date1, String date2) {
		if (date1 == null || date2 == null)
			throw new NullPointerException("给定的时间串为null");
		return Math.abs(DateDiff(stdt(date1), stdt(date2))) + 1;
	}

	/**
	 * 取得系统时间与制定时间间隔天数
	 * 
	 * @param date
	 * @return
	 */
	public static int DateDiff(String date) throws Exception {
		if (date == null)
			throw new NullPointerException("给定的时间串为null");
		return Math.abs(DateDiff(new Date(), stdt(date))) + 1;
	}

	public static boolean compare_date(String DATE1, Date DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			// Date dt2 = df.parse(DATE2);
			Date dt2 = DATE2;
			if (dt1.getTime() > dt2.getTime()) {
				System.out.println("dt1 大于dt2");
				return false;
			} else if (dt1.getTime() < dt2.getTime()) {
				System.out.println("dt1小于dt2");
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * 获得几分钟后的时间
	 * 
	 * @param minute
	 * @return
	 */
	public static String getTimeAddMinute(String time, int minute) {
		ca.setTime(stdt(time));
		ca.add(Calendar.MINUTE, minute);
		return dtts(ca.getTime());
	}

	/**
	 * 获得几分钟后的时间
	 * 
	 * @param time
	 * @param minute
	 * @return
	 */
	public static Date getTimeAddMinute(Date time, int minute) {
		ca.setTime(time);
		ca.add(Calendar.MINUTE, minute);
		return ca.getTime();
	}

	/**
	 * 获取当前月第一天
	 * 
	 * @return
	 */
	public static String getCurrMonthFirstDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ca.add(Calendar.MONTH, 0);
		ca.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(ca.getTime());
		return first;
	}

	/**
	 * 获取当前月最后一天
	 * 
	 * @return
	 */
	public static String getCurrMonthLastDay() {
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String last = format.format(ca.getTime());
		return last;
	}

}
