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
    private int myIndex;
    private int myLocalIndex;
    private Node myCurrent;


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
        return mySize;
    }

    /**
     * initializes the instance variables, creates
     * first Node from source.
     * @param source the source of this enzyme
     */
    @Override
    public void initialize(String source) {

        mySize = source.length();
        myAppends = 0;
        myFirst = new Node(source);
        myLast = myFirst;
        myIndex = 0;
        myLocalIndex = 0;
        myCurrent = myFirst;

    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
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

        myLast.next = temp;

        myLast = temp;

        mySize += dna.length();
        myAppends += 1;

        return this;
    }

    /**
     * reverses the entire strand
     * @return a new IDnaStrand that is the
     * reverse of this
     */
    @Override
    public IDnaStrand reverse() {

        LinkStrand ret = new LinkStrand();

        Node first = new Node(myFirst.info); //first node of the new list
        Node list = new Node(myFirst.info); //iterating node of the original list
        list.next = myFirst.next;
        StringBuilder temp;

        //temp = new StringBuilder(first.info);
        //temp.reverse();
        //first.info = temp.toString();

        while(list != null){
            //Reverses the string (i.e. the info of first)
            temp = new StringBuilder(list.info);
            temp.reverse();
            //list.info = temp.toString();
            //Adds list to the beginning of the new list
            Node newNode = new Node(temp.toString());
            newNode.next = first;
            first = newNode;
            list = list.next;
        }


        while (first.next != null) {
            ret.append(first.info);
            first = first.next;
        }


        return ret;
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        Node temp = myFirst;
        while (temp.next != null) {
            ret.append(temp.info);
            temp = temp.next;
        }
        ret.append(temp.info);

        return ret.toString();

    }

    @Override
    public char charAt(int index) {
        //int count = myIndex;
        //int dex = myLocalIndex;
        //Node list = myCurrent;
        if (index >= mySize) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        while (myIndex != index) {

            myIndex++;
            myLocalIndex++;
            if (myLocalIndex >= myCurrent.info.length()) {
                myLocalIndex = 0;
                myCurrent = myCurrent.next;
            }
        }

        //myIndex = index;
        //myLocalIndex = dex;
        return myCurrent.info.charAt(myLocalIndex);

    }
}
