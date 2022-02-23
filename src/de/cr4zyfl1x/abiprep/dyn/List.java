package de.cr4zyfl1x.abiprep.dyn;

public class List {

    private Node first;
    private Node last;
    private Node current;

    public Node getLast() {
        return last;
    }

    public Node getFirst() {
        return first;
    }

    public boolean isEmpty()
    {
        return (first == null && last == null);
    }

    public boolean hasAccess()
    {
        return current != null;
    }

    public void toFirst()
    {
        if (!isEmpty()) current = first;
    }

    public void toLast()
    {
        if (!isEmpty()) current = last;
    }

    public void next()
    {
        if (!isEmpty() && hasAccess() && current != last) {
            current = current.getNext();
        } else {
            current = null;
        }
    }

    public Node getObject()
    {
        return hasAccess() ? current : null;
    }

    public void setObject(Node pNode)
    {
        if (hasAccess() && pNode != null) {
            Node nextCurrent = current.getNext();
            Node beforeCurrent = current.getPrevious();


            if (beforeCurrent != null) {
                beforeCurrent.setNext(pNode);
                beforeCurrent.getNext().setPrevious(beforeCurrent);
                current = beforeCurrent.getNext();
            } else {
                first = pNode;
                first.setNext(current.getNext());
                current = first;

                return;
            }

            if (nextCurrent != null) {
                nextCurrent.setPrevious(beforeCurrent.getNext());
                nextCurrent.getPrevious().setNext(nextCurrent);
                current = nextCurrent.getPrevious();
            } else {
                last = pNode;
                last.setPrevious(current.getPrevious());
                current = last;
            }
        }
    }

    public void insert(Node pNode)
    {
        if (pNode == null) return;

        if (isEmpty()) {
            append(pNode);
            return;
        }

        if (hasAccess()) {
            Node beforeCurrent = current.getPrevious();

            if (beforeCurrent != null) {
                beforeCurrent.setNext(pNode);
                beforeCurrent.getNext().setPrevious(beforeCurrent);
                beforeCurrent.getNext().setNext(current);
                current.setPrevious(beforeCurrent.getNext());
            } else {
                first = pNode;
                first.setNext(current);
                current.setPrevious(first);
            }
        }
    }



    public int getLength()
    {
        if (isEmpty()) return 0;
        int i = 1;
        Node tmp = first;
        while (tmp.getNext() != null) {
            i++;
            tmp = tmp.getNext();
        }
        return i;
    }


    public void append(Node pNode)
    {
        if (pNode == null) return;
        if (isEmpty()) {
            first = pNode;
            last = pNode;
        } else {
            last.setNext(pNode);
            last.getNext().setPrevious(last);
            last = last.getNext();
        }
    }






    public void getAll()
    {
        Node tmp = first;
        System.out.println(tmp.getContent());
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            System.out.println(tmp.getContent());
        }
    }

}
