package de.cr4zyfl1x.abiprep;

import de.cr4zyfl1x.abiprep.crypto.RSA;
import de.cr4zyfl1x.abiprep.dyn.List;
import de.cr4zyfl1x.abiprep.dyn.Node;

public class Main {

    public static void main(String[] args) {
        List l = new List();

        l.append(new Node("a"));
        l.append(new Node("b"));
        l.append(new Node("c"));
        l.append(new Node("d"));
        l.append(new Node("e"));
        l.append(new Node("f"));

        l.toFirst();
        l.setObject(new Node("x"));

        l.toLast();
        l.setObject(new Node("y"));

        l.toFirst();
        l.next();
        l.next();
        l.setObject(new Node("z"));


        l.append(new Node("ä"));

        l.toFirst();
        l.next();
        l.insert(new Node("p"));












        System.out.println();

        l.getAll();

        System.out.println();

        System.out.println("Length: " + l.getLength());
        System.out.println("Last: " + l.getLast().getContent());
        System.out.println("First: " + l.getFirst().getContent());
        System.out.println("Current: " + l.getObject().getContent());


        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println();

        new RSA().calculateKeys(31, 19);
    }
}
