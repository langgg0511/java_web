package epms.z_util;
/**
 * ÔÂ·Ý×ª»»
 */
public class MonthUtil {
	public static int monthConvert(String month){
	
		switch (month) {
		case "jan":
			month="1";
			break;
		case "feb":
			month="2";
			break;
		case "mar":
			month="3";
			break;
		case "apr":
			month="4";
			break;
		case "may":
			month="5";
			break;
		case "jun":
			month="6";
			break;
		case "jul":
			month="7";
			break;
		case "aug":
			month="8";
			break;
		case "sept":
			month="9";
			break;
		case "oct":
			month="10";
			break;
		case "nov":
			month="11";
			break;
		case "_dec":
			month="12";
			break;
		default:
			break;
		}
		
		Integer monthInteger=new Integer(month);
		return monthInteger;
	}
	
}
