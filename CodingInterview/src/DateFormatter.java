import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatter {

    public static void main(String[] args) throws Exception{
        Date date =new Date(deleteOrdinal("20th Oct 2052"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(date);
        System.out.println(format);
        String[] formattedDates = new String[4];
        for(String s:formattedDates){
            
        }
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        for(Entry<String, Integer> entry:map.entrySet()){
//            entry.getValue()
//        }
    }
    
    public static final Pattern p = Pattern.compile("([0-9]+)(st|nd|rd|th)");

    private static String deleteOrdinal(String dateString) {
        Matcher m = p.matcher(dateString);
        while (m.find()) {
            dateString = dateString.replaceAll(Matcher.quoteReplacement(m.group(0)), m.group(1));
        }
        return dateString;
    }
}
