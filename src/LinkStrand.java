import java.util.LinkedList;

public class LinkStrand implements IDnaStrand {

    /**
     * Inner class for the object type Node
     * Holds an info and a next
     */
    private class Node {
        String info;
        Node next;
        public Node(String s){
            info = s;
            next = null;
        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;


    /**
     * Parameterized constructor
     * @param s is the entire DNA strand
     */
    public LinkStrand(String s){
        initialize(s);
    }


    /**
     * default constructor, constructs an empty
     * DNA strand where the Node will initialize
     * with an empty string info field
     */
    public LinkStrand(){
        this("");
    }


    @Override
    public long size() {
        return 0;
    }

    /**
     * initializes the instance variables, creates
     * first Node from source.
     * @param source the source of this enzyme
     */
    @Override
    public void initialize(String source) {
        mySize = 0;
        myAppends = 0;

        myFirst.info = source;
        myFirst.next = null;
        myLast = myFirst;
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return null;
    }


    /**
     * appends a new node to the DNA strand
     * @param dna
     *            is the string appended to this strand
     * @return the updated DNA strand
     */
    @Override
    public IDnaStrand append(String dna) {

        Node temp = new Node(dna);
        temp.next = null;
        myLast.next = temp;
        myLast = temp;

        mySize += dna.length();
        myAppends += 1;

        return this;
    }

    @Override
    public IDnaStrand reverse() {
        return null;
    }

    @Override
    public int getAppendCount() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        Node temp = myFirst;
        while (myFirst.next != null) {
            ret.append(temp.info);
            temp = temp.next;
        }
        return ret.toString();

    }

    @Override
    public char charAt(int index) {
        return 0;
    }
}
