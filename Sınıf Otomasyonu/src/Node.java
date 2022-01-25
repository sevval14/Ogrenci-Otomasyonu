public class Node {
    Integer id;
    String name;
    Integer mat;
    Integer data;
    Integer avg;
    Node next;

    public Node(int id, String name, Integer mat, Integer data ){
        this.id=id;
        this.name=name;
        this.mat=mat;
        this.data=data;
        this.avg=(data+mat)/2;
        this.next=null;

    }
}
