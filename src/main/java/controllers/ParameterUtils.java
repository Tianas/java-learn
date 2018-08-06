package controllers;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 解析request参数
 *
 * @author hzliuyan, xiaobo trans from illegal-video
 * @version 2015年10月29日
 */
public class ParameterUtils {

    /**
     * 从HttpServletRequest中获取参数值，如果为null，那么返回默认值
     *
     * @param request      HTTP请求
     * @param name         key
     * @param defaultValue 默认值
     * @return value
     */
    public static String optString(HttpServletRequest request, String name, String defaultValue) {
        String value = request.getParameter(name);
        return value == null ? defaultValue : value;
    }

    /**
     * 从HttpServletRequest中获取参数值，如果为null，那么返回默认值
     *
     * @param request      HTTP请求
     * @param name         key
     * @param defaultValue 默认值
     * @return value
     */
    public static int optInt(HttpServletRequest request, String name, int defaultValue) {
        String value = StringUtils.trimToNull(request.getParameter(name));
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.valueOf(value);
        } catch (Throwable e) {
            return defaultValue;
        }
    }

    /**
     * 从HttpServletRequest中获取参数值，如果为null，那么返回默认值
     *
     * @param request      HTTP请求
     * @param name         key
     * @param defaultValue 默认值
     * @return value
     */
    public static long optLong(HttpServletRequest request, String name, long defaultValue) {
        String value = StringUtils.trimToNull(request.getParameter(name));
        if (value == null) {
            return defaultValue;
        }
        try {
            return Long.valueOf(value);
        } catch (Throwable e) {
            return defaultValue;
        }
    }

    /**
     * 从HttpServletRequest中获取参数值，如果为null，那么返回默认值
     *
     * @param request      HTTP请求
     * @param name         key
     * @param defaultValue 默认值
     * @return value
     */
    public static float optFloat(HttpServletRequest request, String name, float defaultValue) {
        String value = StringUtils.trimToNull(request.getParameter(name));
        if (value == null) {
            return defaultValue;
        }
        try {
            return Float.valueOf(value);
        } catch (Throwable e) {
            return defaultValue;
        }
    }

    /**
     * 从HttpServletRequest中获取参数值，如果为null，那么返回默认值
     *
     * @param request      HTTP请求
     * @param name         key
     * @param defaultValue 默认值
     * @return value
     */
    public static double optDouble(HttpServletRequest request, String name, double defaultValue) {
        String value = StringUtils.trimToNull(request.getParameter(name));
        if (value == null) {
            return defaultValue;
        }
        try {
            return Double.valueOf(value);
        } catch (Throwable e) {
            return defaultValue;
        }
    }
}
