// interface Iterator 
interface Iterator<T>{
    boolean hasNext(); // check more elements
    T next(); // retrieves the next element

}


interface IterableCollection<T>{
    Iterator<T> createIterator();
}



class NameCollection implements IterableCollection<String>{
    private final String[] names;

    public NameCollection(String[] names){
        this.names = names;
    }

    @Override
    public Iterator<String> createIterator(){
        return new NameIterator();
    }
    // the inner class implementing the Iterator interface 

    private class NameIterator implements Iterator<String>{
        private int index = 0;
        @Override
        public boolean hasNext(){
            return index < names.length;
        }
        @Override
        public String next(){
            if (hasNext()){
                return names[index++];
            }
            throw new IllegalStateException("No more elements");
        }
    }
}
public class IteratorEx {
    public static void main(String[] args) {
        String [] names = {"Nilum", "Kamla", "Sunil", "Ajith"};
        NameCollection nameCollection = new NameCollection(names);
        Iterator<String> iterator = nameCollection.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
