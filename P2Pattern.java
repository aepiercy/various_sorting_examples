/** P2Pattern class
 *  @author Josh Hug & Vivant Sakore
 */

public class P2Pattern {
    /* Pattern to match a valid date of the form MM/DD/YYYY. Eg: 9/22/2019 */
    public static String P1 = "^(0?[1-9]|1[012])/(0?[1-9]|[12]\\d|3[01])/((19|20)\\d{2})";

    /** Pattern to match 61b notation for literal IntLists. */
    public static String P2 = "";//""^(\\((^(?:0*[1-9]\\d*\s*(?:,|$)\s*)+$)+"; //FIXME: Add your regex here

    /* Pattern to match a valid domain name. Eg: www.support.facebook-login.com */
    public static String P3 = ""; //FIXME: Add your regex here

    /* Pattern to match a valid java variable name. Eg: _child13$ */
    public static String P4 = "^([A-Za-z_$])([A-Za-z0-9_$])*$"; //FIXME: Add your regex here
    //([A-Za-z]|_\\d|$\\d)
    //([A-Za-z0-9]|_\\d|$\\d)*
    /* Pattern to match a valid IPv4 address. Eg: 127.0.0.1 */
    //private static final String P5ip = "^([0-255])$";
   // public static String.format("^%s\\.%s\\.%s\\.%s$", P5ip, P5ip, P5ip, P5ip);
    //public static String P5 ="^([0-255])\\.([0-255])\\.([0-255])\\.([0-255])$";
    private static final String P5ip = "([0-9]|[0-9][0-9]|[0-1][0-9][0-9]|2[0-4][0-9]|25[0-5])";
    public static String P5 = "^" + P5ip + "\\."+ P5ip + "\\."+ P5ip + "\\."+ P5ip + "$";
}
