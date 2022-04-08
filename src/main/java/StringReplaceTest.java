public class StringReplaceTest {

    public void replaceStr(){
        String str = "/upload/homes/show/20/08/homes_show_202008251714906757.png";

        System.out.println(str.replace("/upload",""));
    }

    public void splitStr(){
        String str = "/upload/homes/show/20/08/homes_show_202008251714906757.png";

        String sp[] = str.split("[\\/]");

        for(int i=0; i<sp.length;i++){
            System.out.println("i["+i +"]= "+sp[i]);
        }

    }
    public void replasceIframe(){
        String str = "<iframe src='https://tv.naver.com/embed/14833986?autoPlay=true' frameborder='no' scrolling='no' marginwidth='0' marginheight='0' WIDTH='936' HEIGHT='526' allow='autoplay' allowfullscreen></iframe>";

        str = str.replace("<","&lt;");
        System.out.println(str);
        str = str.replace(">","&gt;");
        System.out.println(str);
        str = str.replace("iframe","i1f2r3a4m5e6;");
        System.out.println(str);
    }
    public static void main(String[] argc) throws Exception{

        StringReplaceTest test = new StringReplaceTest();

        //test.replaceStr();
        //test.splitStr();
        test.replasceIframe();
    }


}
