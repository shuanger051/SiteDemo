package cn.qweb.cms.core.utils;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * IP转换
 * @author cuibz
 *
 */
public class IpUtil {
	/***************************************************************************
	 * IP转成长整型
	 */
	public static String ipToLong(String strIp) {
//		long[] ip = new long[4];
//		int position1 = strIp.indexOf(".");
//		int position2 = strIp.indexOf(".", position1 + 1);
//		int position3 = strIp.indexOf(".", position2 + 1);
//
//		ip[0] = Long.parseLong(strIp.substring(0, position1));
//		ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
//		ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
//		ip[3] = Long.parseLong(strIp.substring(position3 + 1));
//		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
		
		String[] ip = new String[4];
		int position1 = strIp.indexOf(".");
		int position2 = strIp.indexOf(".", position1 + 1);
		int position3 = strIp.indexOf(".", position2 + 1);

		ip[0] = bw(strIp.substring(0, position1));
		ip[1] = bw(strIp.substring(position1 + 1, position2));
		ip[2] = bw(strIp.substring(position2 + 1, position3));
		ip[3] = bw(strIp.substring(position3 + 1));
		return (ip[0] + ip[1] + ip[2] + ip[3]);
	}
	//补位
	private static String bw(String s){
		if(s == null || "".equalsIgnoreCase(s)){
			return s;
		}
		int sjLength = s.length();
		if(sjLength < 3){
			for(int i = 0; i < 3 - sjLength; i ++){
				s = "0" + s;
			}
		}
		return s;
	}

	/***************************************************************************
	 * 长整型转IP
	 */
	public static String longToIP(long longIp) {
		StringBuffer sb = new StringBuffer("");
		if (longIp > 0) {
			sb.append(String.valueOf((longIp >>> 24)));
			sb.append(".");
			sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
			sb.append(".");
			sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
			sb.append(".");
			sb.append(String.valueOf((longIp & 0x000000FF)));
		} else {
			int ip1 = Integer.parseInt(String.valueOf((longIp >> 24)));
			if (ip1 < 0) {
				ip1 = 256 + ip1;
			}
			sb.append(String.valueOf(ip1));
			sb.append(".");
			sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
			sb.append(".");
			sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
			sb.append(".");
			sb.append(String.valueOf((longIp & 0x000000FF)));
		}
		return sb.toString();
	}
	
	/**
	 * 获取客户端IP地址
	 * @param request
	 * @return
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
