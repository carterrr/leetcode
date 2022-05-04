public class 你完成的完整对局数_1904{
    public int numberOfRounds(String loginTime, String logoutTime) {
        String[] login = loginTime.split(":");
        String[] logout = logoutTime.split(":");
        Integer hs = Integer.parseInt(login[0]);
        Integer ms = Integer.parseInt(login[1]);
        Integer he = Integer.parseInt(logout[0]);
        Integer me = Integer.parseInt(logout[1]);
        Integer endNum = he * 4 + me / 15 ;
        Integer startNum = hs * 4 + ms / 15; 
        
        int res = endNum - startNum ; 

        if(he < hs || (hs == he && me < ms)){ // 跨了一天
            res += 24 * 4 ;
        } 
        if ( ms % 15 != 0 ){   // 如果起始时间不能整除15  少一局
            res = res > 0 ? res - 1:0; // "00:47", "00:57" 这种会变成负数

        }
        return res; 
    }
}