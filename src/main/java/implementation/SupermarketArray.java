package implementation;

public class SupermarketArray implements Supermarket{
    final private String [] items;
    int lastIndex;

    public SupermarketArray(final int size) {
        items = new String[size];
        lastIndex = -1;
    }

    @Override
    public void add(final String item) {
        if (lastIndex==items.length-1) {
            System.err.println("List is full");
        } else {
            lastIndex++;
            items[lastIndex] = item;
        }

    }

    @Override
    public void remove(final int index) {
        if (index>=0 && index <= lastIndex) {
            shift(index);
            lastIndex--;
        } else {
            System.err.println("Not a valid index");
        }
    }

    private void shift(int index) {
        for(int i=index; i<lastIndex; i++) {
            items[i] = items[i+1];
        }
    }

    @Override
    public void print() {
        System.out.println("#######################################");
       if (lastIndex<0) {
           System.out.println("List is empty");
       }
       for (int i=0; i<=lastIndex; i++) {
           System.out.println(i + " -> " + items[i]);
       }
        System.out.println("#######################################");
    }
}
