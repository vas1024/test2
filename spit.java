import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer tokenizer = new StringTokenizer( reader.readLine() );
        int n = Integer.parseInt( tokenizer.nextToken() );
        HashMap<Integer, List<Integer>> hm = new HashMap<>();  // hm<<координата в которую плевали из списка>,<список координат, откуда плевали в ключ>>
        String result = "NO";
        for( int i = 0; i < n; i++ ){
            tokenizer = new StringTokenizer( reader.readLine() );
            int x = Integer.parseInt( tokenizer.nextToken() );
            int d = Integer.parseInt( tokenizer.nextToken() );
            int x2 = x + d;
            if( hm.get( x2 ) == null ){
                List<Integer> tmp = new ArrayList<>();
                hm.put( x2, tmp );
            }
            hm.get( x2 ).add( x );
            if( check( hm, x, x2 )) {
                result = "YES";
                break;
            }
        }
//        printHM( hm );
        System.out.println( result );

    }
    static void printHM( HashMap<Integer, List<Integer>> hm ){
        for( int key : hm.keySet() ){
            StringBuilder sb = new StringBuilder();
            sb.append( key ).append( " :  " );
            List<Integer> list = hm.get( key );
            for( int e : list ){
                sb.append( e ).append( ", " );
            }
            System.out.println( sb.toString() );
        }
    }
    static boolean check( HashMap<Integer, List<Integer>> hm, int x1, int x2 ){
// checks if both spited
      Boolean result = false;
      if( ( hm.get(x1) != null ) &&  ( hm.get(x1).contains( x2 ) ) &&
          ( hm.get(x2) != null ) &&  ( hm.get(x2).contains( x1 ) ) ) result = true;
      return result;
    }
}
