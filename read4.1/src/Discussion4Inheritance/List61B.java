/**
 * superclass: List61B
 * subclass: AList, SLList
 * */
public interface List61B<Item> {
    public int count = 0;      // inherit all the methods and variable(final variable: can't be changed)
    public void addLast(Item x);
    public Item getLast();
    public Item get(int i);
    public int size();
    public Item removeLast();
    public Item getFirst();
    public void insert(Item x, int position);
    public void addFirst(Item x);

    default public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }



}
