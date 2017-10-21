
public class BaaseSeven {

    public String convertTo7(int num) {
        if(num == 0){
            return num+"";
        }
        StringBuilder result = new StringBuilder();
        int temp = Math.abs(num);
        
        while(temp >= 7){
            result.append(temp%7);
            temp = temp/7;
        }
        result.append(temp);
        result.reverse();
        
        return num > 0? result.toString():"-"+result.toString() ;
    }
    
    public static void main(String[] args) {
        BaaseSeven baSeven = new BaaseSeven();
        System.out.println(baSeven.convertTo7(-7));
    }
}
