package dateEg;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 得到一个特定日期相距多少天后的具体日期
 * @author linkage
 *
 */
public class DateTest {

 public static void main(String[] args) {
  Date date = new Date(); // 新建一个日期

  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 格式化日期

  String beforeDate = sdf.format(getDateBefore(date, 10));
  System.out.println(beforeDate);
  String afterDate = sdf.format(getDateAfter(date, 10));
  System.out.println(afterDate);
 }

 /**
  * 得到几天前的时间
  */

 public static Date getDateBefore(Date d, int day) {
  Calendar now = Calendar.getInstance();
  now.setTime(d);
  now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
  return now.getTime();
 }

 /**
  * 得到几天后的时间
  */
 
 public static Date getDateAfter(Date d, int day) {
  Calendar now = Calendar.getInstance();
  now.setTime(d);
  now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
  return now.getTime();
 }
}