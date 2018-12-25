import java.util.*;

public class SuperSimpleStorage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		Storage storage = new Storage();
		while(true) {
			System.out.println("Enter set, delete or get.");
			line = sc.nextLine();
      String[] words = line.trim().split(" ");
			if (words[0].trim().startsWith("get") && words.length >= 2) {
				try {
					String word = storage.get(Integer.parseInt(words[1]));
          if (word == null) throw new Exception();
          System.out.println(word);
				} catch (Exception e) {
          System.out.println("ERROR");
				}
			} else if (words[0].trim().startsWith("set") && words.length >= 3) {
        try {
          StringBuilder sb = new StringBuilder();
          for (int i = 2; i < words.length; i++) {
            if (i > 2) {
              sb.append(" ");
            }
            sb.append(words[i]);
          }
          storage.set(Integer.parseInt(words[1]), sb.toString());
          System.out.println("OK");
        } catch (Exception e) {
          System.out.println("ERROR");
        }
			} else if (words[0].trim().startsWith("delete") && words.length >= 2) {
        try {
					storage.delete(Integer.parseInt(words[1]));
          System.out.println("OK");
				} catch (Exception e) {
          System.out.println("ERROR");
				}
			} else if (words[0].trim().startsWith("exit")) {
        break;
      }
		}
	}
}

class Storage {
	private static final int SIZE = 100;
    private String[] storage = new String[SIZE];

    private boolean indexInRange(int index){
    	if (index > 0 && index <= SIZE) {
    		return true;
    	} else {
    		return false;
    	}
    }

    void set(int index, String str) {
        if (indexInRange(index)) {
        	storage[index-1] = str;
        } else {
        	throw new IllegalArgumentException("Size is " + SIZE + ", got index " + index);
        }
    }

    String get(int index) {
        String result = null;
        if (indexInRange(index)) {
        	result = storage[index-1];
        	if (!result.equals("")) {
        		return result;
        	}
        } else {
        	throw new IllegalArgumentException("Size is " + SIZE + ", got index " + index);
        }
        return null;
    }

    void delete(int index) {
        if (indexInRange(index)) {
        	storage[index-1] = "";
        } else {
        	throw new IllegalArgumentException("Size is " + SIZE + ", got index " + index);
        }
    }

}
